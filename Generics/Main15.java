import java.util.*;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public List<T> getMeals() {
        return meals;
    }
}

class MealPlanner {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> mealPlan, T meal) {
        mealPlan.addMeal(meal);
    }
}

public class Main15 {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegPlan = new Meal<>();
        Meal<VeganMeal> veganPlan = new Meal<>();
        Meal<KetoMeal> ketoPlan = new Meal<>();
        Meal<HighProteinMeal> proteinPlan = new Meal<>();

        MealPlanner.generateMealPlan(vegPlan, new VegetarianMeal());
        MealPlanner.generateMealPlan(veganPlan, new VeganMeal());
        MealPlanner.generateMealPlan(ketoPlan, new KetoMeal());
        MealPlanner.generateMealPlan(proteinPlan, new HighProteinMeal());

        for (MealPlan meal : vegPlan.getMeals()) System.out.println(meal.getMealType());
        for (MealPlan meal : veganPlan.getMeals()) System.out.println(meal.getMealType());
        for (MealPlan meal : ketoPlan.getMeals()) System.out.println(meal.getMealType());
        for (MealPlan meal : proteinPlan.getMeals()) System.out.println(meal.getMealType());
    }
}
