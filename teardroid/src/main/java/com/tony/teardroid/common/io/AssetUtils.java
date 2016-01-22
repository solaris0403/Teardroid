package com.tony.teardroid.common.io;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Asset 工具类
 * 
 */
public class AssetUtils {
	private AssetUtils() {
	}

	/**
	 * 由于不同的编译器目录结构不一样,故需要判断不同的编译器
	 */
	public enum IDE {
		ECLIPSE, ANDROID_STUDIO
	}

	private static InputStream openEclipseAssetFile(Context context, String fileName) {
		InputStream is = null;
		try {
			is = context.getAssets().open(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}

	private static InputStream openAndroidStudioAssetFile(Context context, String fileName) {
		InputStream is = context.getClass().getClassLoader().getResourceAsStream("assets/" + fileName);
		return is;
	}

	/**
	 * 打开Asset下的文件
	 * 
	 * @param fileName
	 *            文件名
	 * @param ide
	 *            编辑器
	 * @return InputStream
	 */
	public static InputStream openAssetFile(Context context, String fileName, IDE ide) {
		if (ide == IDE.ANDROID_STUDIO) {
			return openAndroidStudioAssetFile(context, fileName);
		} else {
			return openEclipseAssetFile(context, fileName);
		}
	}
}
