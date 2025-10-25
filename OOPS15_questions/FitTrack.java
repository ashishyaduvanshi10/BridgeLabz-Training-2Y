interface ITrackable {
    void startWorkout();
    void stopWorkout();
}

class UserProfile {
    private String name;
    private int age;
    private double weight;
    private int goal;

    public UserProfile(String name, int age, double weight, int goal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = goal;
    }

    public UserProfile(String name, int age, double weight) {
        this(name, age, weight, 500);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getGoal() {
        return goal;
    }

    public int computeRemaining(int burned) {
        return goal - burned;
    }
}

abstract class Workout implements ITrackable {
    private String type;
    private int duration;
    private int caloriesBurned;
    private boolean active;

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    protected void setCaloriesBurned(int c) {
        this.caloriesBurned = c;
    }

    public void startWorkout() {
        active = true;
    }

    public void stopWorkout() {
        active = false;
    }

    public abstract void calculateCalories();
}

class CardioWorkout extends Workout {
    public CardioWorkout(String type, int duration) {
        super(type, duration);
    }
    public void calculateCalories() {
        setCaloriesBurned(getDuration() * 8);
    }
}

class StrengthWorkout extends Workout {
    public StrengthWorkout(String type, int duration) {
        super(type, duration);
    }
    public void calculateCalories() {
        setCaloriesBurned(getDuration() * 5);
    }
}

public class FitTrack {
    public static void main(String[] args) {
        UserProfile user = new UserProfile("John", 25, 70, 600);
        Workout w1 = new CardioWorkout("Running", 30);
        w1.startWorkout();
        w1.calculateCalories();
        w1.stopWorkout();

        Workout w2 = new StrengthWorkout("Weights", 40);
        w2.startWorkout();
        w2.calculateCalories();
        w2.stopWorkout();

        int total = w1.getCaloriesBurned() + w2.getCaloriesBurned();
        System.out.println("Calories burned: " + total);
        System.out.println("Remaining target: " + user.computeRemaining(total));
    }
}
