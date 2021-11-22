package com.ocado.productions;

public class Bread extends OrderDecorator {


    public Bread(Production production){
        this.production = production;
    }

    @Override
    public double prise() {
        return production.prise() + 1;
    }


    @Override
    public String description(){
        return production.description() + " bread added";
    }


}
