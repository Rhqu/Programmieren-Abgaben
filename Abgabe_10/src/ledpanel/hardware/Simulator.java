package ledpanel.hardware;

import ledpanel.controller.API;

import java.awt.*;
import java.util.Arrays;

public class Simulator {

    /**
     * If this variable is set to true, the simulated panel will be shown.
     */
    public static boolean showSimulatedPanel = true;

    private final int matrixSize;
    private final byte[] matrix0;
    private final byte[] matrix1;
    private final byte[] matrix2;
    private final byte[] matrix3;
    private final byte[] matrix4;
    private GameView gameView;

    Simulator() {
        this.matrixSize = 8;
        matrix0 = new byte[matrixSize];
        matrix1 = new byte[matrixSize];
        matrix2 = new byte[matrixSize];
        matrix3 = new byte[matrixSize];
        matrix4 = new byte[matrixSize];
    }

    void startSimulation() {
        if (API.DEBUGGING_MODE) {
            plotChanges();
        } else {
            if (showSimulatedPanel) {
                gameView = new GameView();
                gameView.updateStatusText("Java Programmierung WS 2025/26");
                gameView.updateWindowIcon("light.png");
                gameLoop();
            }
        }
    }

    byte[] getMatrix0() {
        return matrix0;
    }

    byte[] getMatrix1() {
        return matrix1;
    }

    byte[] getMatrix2() {
        return matrix2;
    }

    byte[] getMatrix3() {
        return matrix3;
    }

    byte[] getMatrix4() {
        return matrix4;
    }

    void gameLoop() {
        new Thread(() -> {
            while (true) {
                addTable();
                addPanel();
                addLights();
                gameView.plotCanvas();
            }
        }).start();
        sleep(500);
    }

    private void addTable() {
        gameView.addImageToCanvas("table.jpg", 0, 0, 1.3, 0);
    }

    private void addPanel() {
        int y = 250;
        int x = 150;
        int xGap = 200;
        double scaleFactor = 0.31;
        double rotation = 0;
        int matrices = 5;

        addKnob(x, y);
        addKnob(x + 998, y);
        addKnob(x, y + 202);
        addKnob(x + 998, y + 202);

        gameView.addImageToCanvas("cable.png", x - 400, y + 130, 0.5, 0);
        gameView.addRectangleToCanvas(x - 5, y - 5, 1009, 213, 0, true, Color.GRAY.darker());
        gameView.addRectangleToCanvas(x - 2, y - 2, 1003, 207, 0, true, Color.GRAY.brighter());
        for (int matrix = 0; matrix < matrices; matrix++) {
            gameView.addImageToCanvas("matrix.jpg", x + matrix * xGap, y, scaleFactor, rotation);
        }
    }

    private void addKnob(int x, int y) {
        gameView.addOvalToCanvas(x - 1, y + 1, 25, 25, 2, true, Color.BLACK);
        gameView.addOvalToCanvas(x - 1, y + 1, 24, 24, 0, true, Color.WHITE.darker());
        gameView.addOvalToCanvas(x, y, 20, 20, 0, true, Color.BLACK.brighter());
    }

    private void addLights() {
        addLightsToMatrix(matrix0, 0);
        addLightsToMatrix(matrix1, 1);
        addLightsToMatrix(matrix2, 2);
        addLightsToMatrix(matrix3, 3);
        addLightsToMatrix(matrix4, 4);
    }

    private void addLightsToMatrix(byte[] matrixBytes, int matrixIndex) {
        int y = 247;
        int xyGap = 25;
        int x = 145;
        int matrixGap = 200;
        double scaleFactor = 0.08;
        double rotation = 0;

        int lightIndex = 0;
        for (int line = 0; line < matrixSize; line++) {
            for (int column = 0; column < matrixSize; column++) {
                if ((matrixBytes[lightIndex / 8] & (byte) (1 << 7-(lightIndex % 8))) != 0) {
                    gameView.addImageToCanvas("light.png",
                            x + column * xyGap + matrixIndex * matrixGap, y + line * xyGap, scaleFactor, rotation);
                }
                lightIndex++;
            }
        }
    }

    public void plotChanges() {
        new Thread(new Runnable() {
            private byte[] matrix0_backup;
            private byte[] matrix1_backup;
            private byte[] matrix2_backup;
            private byte[] matrix3_backup;
            private byte[] matrix4_backup;

            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                long cumulativeTime = 0;
                waitUntilPanelHasStabilized();
                while (true) {
                    if (panelHasChanged()) {
                        long time = System.currentTimeMillis() - startTime;
                        int timeRoundedDownToTen = (int) (((time) / 10) * 10);
                        cumulativeTime += timeRoundedDownToTen;
                        startTime = System.currentTimeMillis();
                        waitUntilPanelHasStabilized();
                        System.out.println("Zustand ab dem Zeitpunkt " + cumulativeTime + ":\n" + panelAsString());
                        matrix0_backup = matrix0.clone();
                        matrix1_backup = matrix1.clone();
                        matrix2_backup = matrix2.clone();
                        matrix3_backup = matrix3.clone();
                        matrix4_backup = matrix4.clone();
                    } else {
                        Thread.onSpinWait();
                    }
                }
            }

            private boolean panelHasChanged() {
                return !Arrays.equals(matrix0, matrix0_backup) || !Arrays.equals(matrix1, matrix1_backup)
                       || !Arrays.equals(matrix2, matrix2_backup) || !Arrays.equals(matrix3, matrix3_backup)
                       || !Arrays.equals(matrix4, matrix4_backup);
            }
        }).start();
    }

    private void waitUntilPanelHasStabilized() {
        try {
            Thread.sleep(6);
        } catch (InterruptedException ignored) {
        }
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }

    public String panelAsString() {
        String panel = "";
        panel += "Matrix 0: " + Arrays.toString(matrix0) + "\n";
        panel += "Matrix 1: " + Arrays.toString(matrix1) + "\n";
        panel += "Matrix 2: " + Arrays.toString(matrix2) + "\n";
        panel += "Matrix 3: " + Arrays.toString(matrix3) + "\n";
        panel += "Matrix 4: " + Arrays.toString(matrix4) + "\n";
        return panel;
    }
}