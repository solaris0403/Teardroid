package com.tony.flux.stores;

import com.squareup.otto.Bus;
import com.tony.flux.actions.Action;

/**
 * 应用的状态(state)和逻辑(logic)。
 * 它们根据当前的状态对action做出处理,执行业务逻辑,
 * 它会管理多个对象的状态
 * 并且在处理完成时发出change事件。这个事件用于通知View更新UI。
 * 只能通过Dispatcher来更新（不要提供setter方法），对外仅暴露各种getter方法来获取UI状态。
 * <p/>
 * 数据缓存
 * 对外只暴露getter方法用 (永远不要提供setter方法)
 * 只能通过Action来响应外部的变化
 * 当Store状态发生变化的时候，需要通知Controller-View
 * 只有在接收到Action的时候才能触发通知
 */
public abstract class Store<T extends Action> {
    private static final Bus bus = new Bus();

    protected Store() {
    }

    public void register(final Object view) {
        this.bus.register(view);
    }

    public void unregister(final Object view) {
        this.bus.unregister(view);
    }

    protected void emitStoreChange() {
        //state更改後　通過Bus通知view
        this.bus.post(changeEvent());
    }

    public abstract StoreChangeEvent changeEvent();

    /**
     * 这个方法是注册在Dispatcher里面的回调接口，当Dispatcher有数据派发过来的时候，可以在这里处理
     *
     * @param action
     */
    public abstract void onAction(T action);

    public class StoreChangeEvent {
    }
}
