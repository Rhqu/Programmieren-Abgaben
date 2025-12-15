package ledpanel.controller;

/**
 * Erzeugt MovingStringImages für Lauftext auf dem LED-Panel. Jeder Buchstabe benötigt 8 * 8 LEDs auf dem Panel.
 * Diese Klasse nutzt die Klasse StringImage, um ein Bild für einen String zu erzeugen, der sich von rechts nach links bewegt.
 */
public class MovingStringImage extends StringImage {

    /**
     * Ein MovingStringImage kann aus dem übergebenen String erzeugt werden.
     *
     * @param string String, aus dem ein Lauftext erzeugt werden soll.
     */
    public MovingStringImage(String string) {
        super(string);
    }

    /**
     * Diese Methode gibt ein Array von Strings zurück, dass für eine Animation benutzt werden kann, wenn man sie
     * hintereinander anzeigt. Der String erscheint am rechten Rand des Panels und scrollt zum linken Rand durch, bis er
     * ganz verschwunden ist.
     *
     * @return Das Array mit der Animation.
     */
    public String[] movingStrings() {
        int panelWidth = 40;
        int textWidth = string.length() * 8;
        int totalFrames = panelWidth + textWidth;

        String[] lines = stringImage.split("\\R");
        String[] paddedLines = new String[linesOfCharImage];
        String padding = " ".repeat(panelWidth);

        for (int i = 0; i < linesOfCharImage; i++) {
            paddedLines[i] = padding + lines[i] + padding;
        }

        String[] frames = new String[totalFrames];
        for (int frame = 0; frame < totalFrames; frame++) {
            StringBuilder frameBuilder = new StringBuilder();
            for (int line = 0; line < linesOfCharImage; line++) {
                frameBuilder.append(paddedLines[line].substring(frame, frame + panelWidth));
                frameBuilder.append("\n");
            }
            frames[frame] = frameBuilder.toString();
        }

        return frames;
    }
}