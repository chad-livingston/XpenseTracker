package xpense;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class expenses {
    private final double expenseCost;
    private final String storeName;
    private String description;
    private String category;

    public expenses(String name, Double cost) {
        this.storeName = name;
        this.expenseCost = cost;
        this.description = "no description";
        this.category = "none specified";
    }

    public String getStoreName() {
        return storeName;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        return this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public String setCategory(String category) {
        return this.category = category;
    }

    public Double getExpenseCost() {
        return expenseCost;
    }

    public String toString() {
        return storeName + "," + expenseCost + "," + category + "," + description + "\n";
    }
}
