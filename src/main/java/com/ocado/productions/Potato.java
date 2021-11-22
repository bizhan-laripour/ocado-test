package com.ocado.productions;

public class Potato extends OrderDecorator {

    public Potato(Production production){
        this.production = production;
    }

    @Override
    public double prise() {
        return production.prise() + 1.15;
    }

    @Override
    public String description() {
        return production.description()+" potato added";
    }
}
