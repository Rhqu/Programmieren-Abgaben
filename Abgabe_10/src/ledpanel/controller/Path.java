package ledpanel.controller;

/**
 * Diese Klasse erlaubt das Erstellen von LED-Pfaden. Sie füllt fehlende LEDs auf, sodass man jeweils nur Start- und
 * Ende-LED angeben muss, um einen vollständigen Pfad zu erzeugen. Darüber hinaus können Pfade hintereinander geschaltet
 * werden.
 */
public class Path {
    private final int[] keyPositions;
    private int[] leds;

    /**
     * Ein Pfad wird erzeugt. Nur einzelne Wegpunkte auf dem Pfad müssen in der richtigen Reihenfolge übergeben werden.
     * Es sind nur gerade Wege erlaubt (links, rechts, runter, rauf), Diagonalen sind verboten.
     * <br><br>
     * Beispiele für Pfade:<br>
     * <pre>
     * {@code new Path(0, 10)} --> (0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
     * {@code new Path(10, 0)} --> (10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
     * {@code new Path(0, 280)} --> (0, 40, 80, 120, 160, 200, 240, 280)
     * {@code new Path(0, 39, 319, 280, 0)} --> Eine Runde im Viereck um das Panel </pre><br>
     * <br>
     *
     * @param keyPositions Die Wegpunkte auf dem Pfad.
     */
    public Path(int... keyPositions) {
        this.keyPositions = keyPositions;
        calculatePaths();
    }

    private void calculatePaths() {

        int totalSize = 1;
        for (int i = 0; i < keyPositions.length - 1; i++) {
            int start = keyPositions[i];
            int end = keyPositions[i + 1];
            totalSize += countSteps(start, end);
        }


        leds = new int[totalSize];
        int index = 0;

        for (int i = 0; i < keyPositions.length - 1; i++) {
            int start = keyPositions[i];
            int end = keyPositions[i + 1];
            int step = getStep(start, end);

            int current = (i == 0) ? start : start + step;

            while (current != end + step) {
                assert leds != null;
                leds[index++] = current;
                current += step;
            }
        }
    }

    private int countSteps(int start, int end) {
        if (start / 40 == end / 40) {
            return Math.abs(end - start);
        } else {
            return Math.abs(end - start) / 40;
        }
    }

    private int getStep(int start, int end) {
        if (start / 40 == end / 40) {
            return (end > start) ? 1 : -1;
        } else {
            return (end > start) ? 40 : -40;
        }
    }

    int[] getLeds() {
        return leds;
    }

    /**
     * Die Größe des Pfads.
     *
     * @return Größe des Pfads.
     */
    int size() {
        return leds.length;
    }
}