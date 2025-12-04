package frograce.game;

public class Track {
    String name;
    int distanceInCm;
    Frog[] frogs;

    public Track(String name, int distanceInCm, Frog[] frogs) {
        this.name = name;
        this.distanceInCm = distanceInCm;
        this.frogs = frogs;
    }

    int getCurrentDistanceInCm() {
        return distanceInCm;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("\n");
        display.append(name).append(": ").append(distanceInCm).append(" Zentimeter\n").append("\n");
        createEdgeLine(display);
        for (Frog frog : frogs) {
            String frogString = frog.toString();
            display.append(" ".repeat("| Ziel".length() + 2)).append(frogString).append("\n").append("\n");
        }
        createEdgeLine(display);
        return display.toString();
    }

    void createEdgeLine(StringBuilder display) {
        display.append("\n").append(" ").append("Start |");
        for (int i = 0; i < distanceInCm; i += 10) {
            display.append("-");
        }
        display.append("| Ziel").append("\n").append("\n").append("\n");
    }
}
