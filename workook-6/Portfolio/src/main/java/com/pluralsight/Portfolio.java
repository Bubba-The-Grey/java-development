package com.pluralsight;
import java.util.*;
public class Portfolio {
    private String name, owner;
    private List<Valuable> assets;
    public Portfolio(String name, String owner){
        this.name = name;
        this.owner = owner;
    }
    public void add(Valuable asset){

    }
    public double getValue(){
        double sum = 0.0;
        for(Valuable v: assets){
            sum += v.getValue();
        }
        return sum;
    }
    public Valuable getMostValuable(){
        Valuable result = assets.get(0);
        double creditValue = 0.0;
        for(Valuable v: assets){
            if(v instanceof CreditCard){
                creditValue = (-1 * v.getValue());
                if(creditValue < result.getValue()){
                    result  = v;
                }
            }
            else{
                if(v.getValue() < result.getValue()){
                    result = v;
                }
            }
        }
        return result;
    }
    public Valuable getLeastValuable(){
        return null;
    }
}
