package com.ocado.threads.observer;


import com.ocado.productions.Production;

public interface Subject extends Runnable{



    void addProduction(Production production);


}
