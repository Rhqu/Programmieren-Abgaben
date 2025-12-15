package ledpanel.controller;

import ledpanel.hardware.LEDPanel;

public class LEDController {
    private final static int elementsPerMatrix = 64;
    LEDPanel ledPanel;

    LEDController(LEDPanel ledPanel) {
        this.ledPanel = ledPanel;
    }

    private byte[] findMatrix(int numberLED) {
        byte[] currentMatrix = null;
        int matrixNumber = 0;
        matrixNumber = ((numberLED - 1) / elementsPerMatrix) + 1;

        switch (matrixNumber) {
            case 1:
                currentMatrix = this.ledPanel.matrix0;
            case 2:
                currentMatrix = this.ledPanel.matrix1;
            case 3:
                currentMatrix = this.ledPanel.matrix2;
            case 4:
                currentMatrix = this.ledPanel.matrix3;
            case 5:
                currentMatrix = this.ledPanel.matrix4;
        }
        return currentMatrix;
    }

    void turnOnLED(int numberLED) {
        byte[] matrix = findMatrix(numberLED);
        matrix[numberLED]= 1;
    }

    void turnOffLED(int numberLED) {
        byte[] matrix = findMatrix(numberLED);
        matrix[numberLED]= 1;
    }

    void turnAllOn(){
        for (int i = 0; i < 8; i++){
            turnOnLED(i);
        }
    }

    void turnAllOff(){
        for (int i = 0; i < 8; i++){
            turnOffLED(i);
        }
    }

}
