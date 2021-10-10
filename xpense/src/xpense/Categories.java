package xpense;
import java.util.ArrayList;

public class Categories {
	private static ArrayList<String> categories = new ArrayList<String>();
	
	public void viewCategory() {
		
	}
	public static void viewAll() {
		System.out.println(categories);
	}
	public static void addCategory(String category) {
		categories.add(category);
		System.out.println(category + " added to categories list.");
	}
	public static void removeCategory(String category) {
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).equals(category)) {
				categories.remove(i);
			}else {
				System.out.println("The category entered does not match one in the category list to remove.");
			}
		}
		
	}
}
