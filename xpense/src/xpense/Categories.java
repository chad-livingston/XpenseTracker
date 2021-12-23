package xpense;

import java.util.ArrayList;

public class Categories {
    private static ArrayList<String> categories = new ArrayList<>();

    public void viewCategory() {

    }
    public String getCategoryName(ArrayList categories){
      //  for (String category : categories){
       //
       // }
        return "";
    }

    public ArrayList<String> viewAllCategories() {
        return this.categories;
    }

    public static void addCategory(String category) {
        if (categories.size() >= 0) {
            categories.add(category);
            System.out.println(category + " added to categories list.");
        }
    }

    public static void removeCategory(String category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).equals(category)) {
                categories.remove(i);
            } else {
                System.out.println("The category entered does not match one in the category list to remove.");
            }
        }
    }

    public String toString(){
        String returnElements = "";
        for (String category : categories){
            returnElements += category;
        }
        return returnElements;
    }
}
