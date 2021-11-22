package com.ocado.robots;

import com.ocado.productions.Production;
import com.ocado.threads.queue.ProductionsQueue;

public class Robot implements Command {


    @Override
    public void execute() {

        Production production = ProductionsQueue.basketQueue.poll();

        System.out.println(production.description() + " and the prise is:" + production.prise());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
