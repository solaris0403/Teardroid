package com.tony.flux.dispatcher;

import com.tony.flux.actions.Action;
import com.tony.flux.stores.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * 中央分发器,将所有action分发到每个Store;
 */
public class Dispatcher {
    //TODO 保存注册的所有store　当比较复杂的时候需要重新选择高效率的容器
    private List<Store> stores = new ArrayList<>();
    private Dispatcher() {
    }

    public static Dispatcher getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder{
        private static final Dispatcher sInstance = new Dispatcher();
    }

    /**
     * 用来注册每个Store的回调接口
     * @param store
     */
    public void register(final Store store) {
        stores.add(store);
    }

    /**
     * 用来解除Store的回调接口
     * @param store
     */
    public void unregister(final Store store) {
        stores.remove(store);
    }

    /**
     * 用来触发Store注册的回调接口
     * 所有订阅了这个Action的Store会接收到订阅的Action并消化Action
     * 随着App的增长，Dispatcher会变得更加重要，它可以通过调整回调方法的触发次序来管理Store之间的依赖关系。
     * Store可以声明等待其他Store更新完毕再更新自己。
     * @param action
     */
    public void dispatch(Action action) {
        for (Store store : stores) {
            store.onAction(action);
        }
    }
}
