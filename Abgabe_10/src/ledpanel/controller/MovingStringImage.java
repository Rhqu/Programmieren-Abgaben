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
        return null;
    }
}