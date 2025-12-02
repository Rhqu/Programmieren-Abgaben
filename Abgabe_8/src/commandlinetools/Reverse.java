package commandlinetools;

import java.util.Arrays;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Es wurden unpassende Aufrufargumente übergeben.");
            System.exit(1);
        }
        StringBuilder inputLines = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            inputLines.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        String input = inputLines.toString().strip();
        String output = "";
        if (args[0].equals("-char-by-char")) {
            output = inputLines.reverse().toString().strip();
        } else if (args[0].equals("-line-by-line")) {
            String[] split = inputLines.toString().split("\\R");
            for (int i = 0; i < split.length / 2; i++) {
                String temp = split[i];
                split[i] = split[split.length - i - 1];
                split[split.length - i - 1] = temp;
            }
            StringBuilder outputbuilder = new StringBuilder();
            for (String string : split) {
                outputbuilder.append(string).append("\n");
            }
            output = outputbuilder.toString();
        } else {
            System.out.println("Es wurden unpassende Aufrufargumente übergeben.");
            System.exit(1);
        }
        System.out.println("Eingegebener Text:\n" + input);
        System.out.println("Geänderter Text:\n" + output);
    }
}
