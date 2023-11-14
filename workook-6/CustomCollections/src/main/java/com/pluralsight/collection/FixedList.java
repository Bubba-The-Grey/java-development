package com.pluralsight.collection;
import java.util.*;
public class FixedList<T>{
    private List<T> items = new ArrayList<>();
    private int maxSize;
    public FixedList(int maxSize){
        this.maxSize = maxSize;
    }
    public void add(T item){
        if(items.size() < maxSize) {
            items.add(item);
        }
        else{
            System.out.println("Error: Maximum Capacity Has Been Reached!");
        }
    }
    public List<T> getItems(){
        return items;
    }
}
