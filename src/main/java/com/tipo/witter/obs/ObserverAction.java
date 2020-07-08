package com.tipo.witter.obs;

import org.assertj.core.util.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: Tipo
 * @create: 2020-07-06 20:39
 **/
public class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
