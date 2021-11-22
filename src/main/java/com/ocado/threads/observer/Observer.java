package com.ocado.threads.observer;

public interface Observer {

    void execute();
    void initThreadPool(Subject subject);
}
