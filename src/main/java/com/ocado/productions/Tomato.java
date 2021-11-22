package com.ocado.productions;

public class Tomato extends OrderDecorator {

    public Tomato(Production production){
        this.production = production;
    }

    @Override
    public double prise() {
        return production.prise() + 1.5;
    }

    @Override
    public String description() {
        return production.description() + " tomato added";
    }
}
