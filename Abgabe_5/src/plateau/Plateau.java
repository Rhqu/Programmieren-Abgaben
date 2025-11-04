package plateau;

public class Plateau {
    public static void main(String[] args) {
        int[] altitudes = {10, 17, 17, 17, 17, 17, 11, 10, 14, 10, 11, 11, 11, 9, 13, 15, 16, 16, 13};
        int length = 0;
        int startindex = 0;
        int valueMinusOne = altitudes[0];
        int valuePlusOne = altitudes[2];
        boolean onPlateau = false;
        for (int indexAltitude = 1; indexAltitude < altitudes.length; indexAltitude++) {
            if (valueMinusOne < altitudes[indexAltitude] && valuePlusOne == altitudes[indexAltitude]) {
                onPlateau = true;
                startindex = indexAltitude;
            }
            if (valuePlusOne < altitudes[indexAltitude] && onPlateau) {
                onPlateau = false;
                System.out.printf("Index: %d Height: %d Length: %d\n", startindex, altitudes[indexAltitude], length + 1);
            } else if (valuePlusOne > altitudes[indexAltitude]) {
                length = 0;
                startindex = 0;
                onPlateau = false;
            }
            if (onPlateau) {
                length++;
            }
            valueMinusOne = altitudes[indexAltitude];
            if (indexAltitude + 2 < altitudes.length) {
                valuePlusOne = altitudes[indexAltitude + 2];
            }
        }
    }
}
