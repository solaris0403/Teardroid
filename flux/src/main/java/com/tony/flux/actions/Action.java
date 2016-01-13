package com.tony.flux.actions;

/**
 * 注意Action一旦创建是不可更改的， 所以它的字段类型修饰为final类型.
 * Action通过ActionCreator的帮助类产生并传递给Dispatcher
 */
public class Action<T> {
    private final String type;
    private final T data;

    /**
     * @param type 类型
     * @param data 数据
     */
    public Action(String type, T data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public T getData() {
        return data;
    }
}
