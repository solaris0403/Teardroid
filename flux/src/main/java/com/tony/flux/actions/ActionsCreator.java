package com.tony.flux.actions;

/**
 * Action Helper方法,实现之后需要设计成单例模式，通过Dispatcher分发Action
 */
public interface ActionsCreator<T extends Action> {
    T createAction(String type, Object object);
}
