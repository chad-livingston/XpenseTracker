package xpense;

import java.util.ArrayList;
import java.util.Scanner;

public class Investments {
    private double  boughtPrice;
    private double  boughtCount;

    public void Investments(double boughtCount, double boughtPrice){
        this.boughtCount = boughtCount;
        this.boughtPrice = boughtPrice;

    }
    public double getBoughtCount(){
        return boughtCount;
    }
    public double getBoughtPrice(){
        return boughtPrice;
    }
}
