package com.tipo.witter.obs;

import java.util.concurrent.Executor;

/**
 * @description:
 * @author: Tipo
 * @create: 2020-07-06 21:01
 **/

public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}