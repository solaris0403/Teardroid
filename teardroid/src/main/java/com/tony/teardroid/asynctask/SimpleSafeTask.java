package com.tony.teardroid.asynctask;

/**
 * 简单的安全异步任务，仅仅指定返回结果的类型，不可输入参数
 */
public abstract class SimpleSafeTask<T> extends SafeTask<Object, Object, T> {
    //@Override
    //protected void onPreExecuteSafely() throws Exception {}

    @Override
    protected final T doInBackgroundSafely(Object... params) throws Exception {
        return doInBackgroundSafely();
    }

    //@Override
    //protected void onPostExecuteSafely(T result, Exception e) throws Exception {}

    protected abstract T doInBackgroundSafely() throws Exception;
}
