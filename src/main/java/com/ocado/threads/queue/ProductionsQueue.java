package com.ocado.threads.queue;

import com.ocado.productions.Production;
import com.ocado.robots.Robot;
import com.ocado.threads.ThreadPool;
import com.ocado.threads.observer.Observer;
import com.ocado.threads.observer.Subject;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ProductionsQueue implements Subject {

    public static Queue<Production> basketQueue = new LinkedList<>();
    public static Queue<Robot> robotQueue = new LinkedList<>();
    private Observer observer;

    private Lock lock;

    public ProductionsQueue(){
        this.observer = new ThreadPool();
        this.lock = new ReentrantLock();
    }


    @Override
    public void addProduction(Production production) {
        basketQueue.add(production);
        observer.initThreadPool(this);
    }

    public void addRobots(Robot robot){
        robotQueue.add(robot);
    }

    @Override
    public void run() {
        Robot robot = null;
        if (robotQueue.size() !=0){
            robot  = robotQueue.poll();
            robot.execute();

            robotQueue.offer(robot);
        }else {
            try {
                Thread.sleep(5000);
                if(robotQueue.size() !=0) {
                    robot = robotQueue.poll();
                    robot.execute();
                    robotQueue.offer(robot);
                }else{
                    lock.lock();
                    Production p = basketQueue.poll();
                    lock.unlock();
                    this.addProduction(p);
                    System.out.println("please add more robots there is lots of requests");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
