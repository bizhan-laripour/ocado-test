package com.ocado.threads;

import com.ocado.config.PropertyConfig;
import com.ocado.threads.observer.Observer;
import com.ocado.threads.observer.Subject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool implements Observer {

    public static ExecutorService executorService =
            Executors.newFixedThreadPool(Integer.parseInt(PropertyConfig.getProperties().getProperty("thread.pool.size")));

    private Subject subject;


    @Override
    public void initThreadPool(Subject subject){
        this.subject = subject;
        execute();
    }


    @Override
    public  void execute() {
        executorService.submit(subject);
    }
}
