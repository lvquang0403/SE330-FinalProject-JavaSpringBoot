package com.project.WebApp.model;

public class FormatNumber {
    public static final String formatMoney(Double value){
        return String.format("%.3f",value)+" VND";
    }
}
