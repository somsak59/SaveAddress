package com.boupha.scdev.saveaddress;

/**
 * Created by scdev on 15/4/2560.
 */

public class GGD {
    private String name = "";
    public String getName(){
        return name;
    }
    public void setName(String names){
        name = names;
    }
    public String toString(){
        return getName();
    }
}
