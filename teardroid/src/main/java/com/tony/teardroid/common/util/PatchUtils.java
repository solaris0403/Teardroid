package com.tony.teardroid.common.util;


import com.tony.teardroid.common.entity.PatchResult;

/**
 * PatchUtils
 */
public class PatchUtils {

    /**
     * patch old apk and patch file to new apk
     * 
     * @param oldApkPath
     * @param patchPath
     * @param newApkPath
     * @return
     */
    public static native PatchResult patch(String oldApkPath, String patchPath, String newApkPath);
}
