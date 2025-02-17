package icu.wenxin.napcat.interfaces;

import icu.wenxin.napcat.context.BaseContext;

@FunctionalInterface
public interface EventHandler<T extends BaseContext> {
    void handle(T context);
}
