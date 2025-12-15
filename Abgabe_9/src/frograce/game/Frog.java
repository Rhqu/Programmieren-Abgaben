package frograce.game;

public class Frog {
    private static final double MAXIMUM_POSSIBLE_JUMP_DISTANCE_IN_CM = 100;
    private final String name;
    private final double strength;
    private final double endurance;
    private final double willpower;
    private int currentDistanceInCm;

    public Frog(String name, double strength, double endurance, double willpower) {
        this.name = name;
        this.strength = strength;
        this.willpower = willpower;
        this.endurance = endurance;
        this.currentDistanceInCm = 0;
    }

    private int calculateMaximumJumpDistanceInCmForNextJump() {
        double maximumDistance = strength * MAXIMUM_POSSIBLE_JUMP_DISTANCE_IN_CM
                - ((1 - endurance) * currentDistanceInCm / 2);
        return (int) Math.max(maximumDistance, MAXIMUM_POSSIBLE_JUMP_DISTANCE_IN_CM / 4);
    }

    void jump() {
        if (Math.random() <= willpower) {
            currentDistanceInCm += (int) (Math.random() * calculateMaximumJumpDistanceInCmForNextJump());
        }
    }

    String getName() {
        return this.name;
    }

    int getCurrentDistanceInCm() {
        return this.currentDistanceInCm;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        for (int i = 10; i <= currentDistanceInCm; i += 10) {
            display.append("=");
        }

        return display.append(">").append(" ").append(this.name).toString();
    }
}