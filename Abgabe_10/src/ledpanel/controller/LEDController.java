package ledpanel.controller;

import ledpanel.hardware.LEDPanel;

public class LEDController extends LEDPanel {
    private static final int elementsPerMatrix = 64;
    private static final int panelWidth = 40;
    private static final int matrixWidth = 8;

    private byte[] findMatrix(int numberLED) {
        int col = numberLED % panelWidth;
        int matrixNumber = col / matrixWidth;
        byte[] currentMatrix = null;

        switch (matrixNumber) {
            case 0:
                currentMatrix = this.matrix0;
                break;
            case 1:
                currentMatrix = this.matrix1;
                break;
            case 2:
                currentMatrix = this.matrix2;
                break;
            case 3:
                currentMatrix = this.matrix3;
                break;
            case 4:
                currentMatrix = this.matrix4;
                break;
        }
        return currentMatrix;
    }

    private int generateByte(int localIndex) {
        int col = localIndex % matrixWidth;
        return (int) Math.pow(2, 7 - col);
    }

    public void updateMatrix(int index, boolean turn) {
        int row = index / panelWidth;
        int col = index % panelWidth;
        int localIndex = col % matrixWidth;

        byte[] currentMatrix = findMatrix(index);
        int generatedByte = generateByte(localIndex);

        if (turn) {
            currentMatrix[row] = (byte) (currentMatrix[row] | generatedByte);
        } else {
            currentMatrix[row] = (byte) (currentMatrix[row] & ~generatedByte);
        }
    }
}
