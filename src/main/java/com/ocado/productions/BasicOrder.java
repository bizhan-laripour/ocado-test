package com.ocado.productions;

import java.util.Date;

public class BasicOrder implements Production{

    @Override
    public double prise() {
        return 0;
    }

    @Override
    public String description() {
        Date date = new Date();
        return "the order started at "+ date.getDate()+"/"+date.getMonth()+"-"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
    }
}
