package com.ocado.productions;

public abstract class OrderDecorator implements Production {

    protected Production production;

    @Override
    public abstract double prise();

    @Override
    public String description() {
        return "the order is started ";
    }
}
