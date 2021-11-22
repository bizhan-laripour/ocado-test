package com.ocado;

import com.ocado.config.PropertyConfig;
import com.ocado.productions.*;
import com.ocado.robots.Robot;
import com.ocado.threads.queue.ProductionsQueue;

import java.io.IOException;
import java.util.ArrayList;

public class OcadoLauncher {

    public static void main(String[] args) throws IOException {



        ProductionsQueue subject = new ProductionsQueue();

        int robotNumbers = Integer.parseInt(PropertyConfig.getProperties().getProperty("robot.size"));
        for(int i=0 ; i<robotNumbers ; i++){
            Robot robot = new Robot();
            subject.addRobots(robot);
        }
        for(int i = 0 ; i<10 ; i++) {
            Production production = new BasicOrder();
            production = new Bread(production);
            production = new Potato(production);
            production = new Tomato(production);
            subject.addProduction(production);
        }
    }
}
