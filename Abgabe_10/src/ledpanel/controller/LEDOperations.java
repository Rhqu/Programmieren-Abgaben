package ledpanel.controller;

public class LEDOperations extends LEDController {

    void turnAllOn() {
        for (int i = 0; i < 320; i++) {
            this.updateMatrix(i, true);
        }
    }

    void turnAllOff() {
        for (int i = 0; i < 320; i++) {
            this.updateMatrix(i, false);
        }
    }

    void showSpecificLED(int[] ledIndices, int milliseconds){
        for (int index : ledIndices){
            this.updateMatrix(index, true);
        }
        waitFor(milliseconds);
        for (int index : ledIndices){
            this.updateMatrix(index, false);
        }
    }

    void blinkingLED(int[] leds, int millisecondsOn, int millisecondsOff, int repetitions){
        for (int i = 0; i < repetitions; i++) {
            for (int index : leds) {
                this.updateMatrix(index, true);
            }
            waitFor(millisecondsOn);
            for (int index : leds) {
                this.updateMatrix(index, false);
            }
            waitFor(millisecondsOff);
        }
    }

    public void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignored) {
        }
    }

    void runningDot(Path path, int milliseconds, int repetitions) {
        int[] leds = path.getLeds();
        for (int r = 0; r < repetitions; r++) {
            for (int led : leds) {
                this.updateMatrix(led, true);
                waitFor(milliseconds);
                this.updateMatrix(led, false);
            }
        }
    }

    void runningDots(Path[] paths, int milliseconds, int repetitions) {
        int maxLength = 0;
        for (Path path : paths) {
            if (path.size() > maxLength) {
                maxLength = path.size();
            }
        }

        for (int r = 0; r < repetitions; r++) {
            for (int step = 0; step < maxLength; step++) {
                for (Path path : paths) {
                    if (step < path.size()) {
                        this.updateMatrix(path.getLeds()[step], true);
                    }
                }
                waitFor(milliseconds);
                for (Path path : paths) {
                    if (step < path.size()) {
                        this.updateMatrix(path.getLeds()[step], false);
                    }
                }
            }
        }
    }

    void showStringImage(String stringImage, int milliseconds) {
        String[] lines = stringImage.split("\\R");
        int panelWidth = 40;

        for (int row = 0; row < lines.length && row < 8; row++) {
            for (int col = 0; col < lines[row].length() && col < panelWidth; col++) {
                if (lines[row].charAt(col) == '#') {
                    int ledIndex = row * panelWidth + col;
                    this.updateMatrix(ledIndex, true);
                }
            }
        }

        waitFor(milliseconds);
        turnAllOff();
    }

    void showMovingStringImage(String[] frames, int milliseconds, int repetitions) {
        int panelWidth = 40;

        for (int r = 0; r < repetitions; r++) {
            for (String frame : frames) {
                String[] lines = frame.split("\\R");

                for (int row = 0; row < lines.length && row < 8; row++) {
                    for (int col = 0; col < lines[row].length() && col < panelWidth; col++) {
                        int ledIndex = row * panelWidth + col;
                        if (lines[row].charAt(col) == '#') {
                            this.updateMatrix(ledIndex, true);
                        } else {
                            this.updateMatrix(ledIndex, false);
                        }
                    }
                }

                waitFor(milliseconds);
            }
        }
        turnAllOff();
    }
}
