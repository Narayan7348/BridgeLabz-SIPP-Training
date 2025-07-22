import java.util.*;

interface MealPlan {
    String getMealName();
}

class VegetarianMeal implements MealPlan {
    String name;
    VegetarianMeal(String name) {
        this.name = name;
    }
    public String getMealName() {
        return name;
    }
}

class VeganMeal implements MealPlan {
    String name;
    VeganMeal(String name) {
        this.name = name;
    }
    public String getMealName() {
        return name;
    }
}

class KetoMeal implements MealPlan {
    String name;
    KetoMeal(String name) {
        this.name = name;
    }
    public String getMealName() {
        return name;
    }
}

class HighProteinMeal implements MealPlan {
    String name;
    HighProteinMeal(String name) {
        this.name = name;
    }
    public String getMealName() {
        return name;
    }
}

class Meal<T extends MealPlan> {
    List<T> mealList = new ArrayList<>();
    void addMeal(T meal) {
        mealList.add(meal);
    }
    List<T> getMeals() {
        return mealList;
    }
}

public class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        for (T m : meal.getMeals()) {
            System.out.println(m.getMealName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Meal<VegetarianMeal> vegetarianMeal = new Meal<>();
        Meal<VeganMeal> veganMeal = new Meal<>();
        Meal<KetoMeal> ketoMeal = new Meal<>();
        Meal<HighProteinMeal> highProteinMeal = new Meal<>();

        System.out.print("Enter number of vegetarian meals: ");
        int vCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < vCount; i++) {
            System.out.print("Enter vegetarian meal name: ");
            vegetarianMeal.addMeal(new VegetarianMeal(scanner.nextLine()));
        }

        System.out.print("Enter number of vegan meals: ");
        int veCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < veCount; i++) {
            System.out.print("Enter vegan meal name: ");
            veganMeal.addMeal(new VeganMeal(scanner.nextLine()));
        }

        System.out.print("Enter number of keto meals: ");
        int kCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < kCount; i++) {
            System.out.print("Enter keto meal name: ");
            ketoMeal.addMeal(new KetoMeal(scanner.nextLine()));
        }

        System.out.print("Enter number of high-protein meals: ");
        int hCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < hCount; i++) {
            System.out.print("Enter high-protein meal name: ");
            highProteinMeal.addMeal(new HighProteinMeal(scanner.nextLine()));
        }

        System.out.println("Vegetarian Meal Plan:");
        generateMealPlan(vegetarianMeal);

        System.out.println("Vegan Meal Plan:");
        generateMealPlan(veganMeal);

        System.out.println("Keto Meal Plan:");
        generateMealPlan(ketoMeal);

        System.out.println("High-Protein Meal Plan:");
        generateMealPlan(highProteinMeal);
    }
}
