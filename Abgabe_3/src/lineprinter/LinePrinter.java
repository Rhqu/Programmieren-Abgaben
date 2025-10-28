package lineprinter;

public class LinePrinter {
    public static void main(String[] args) {
        String word = "Hallo!";
        int maximumNumberOfChars = 100;
        String line = "";
        int currentchars = 0;

        while (currentchars < maximumNumberOfChars) {
            line = line + word;
            currentchars += line.length();
            System.out.println(line);
        }

        System.out.println("\nMaximale Anzahl von Zeichen: " + maximumNumberOfChars);
        System.out.println("Es wurden " + currentchars + " Zeichen ausgegeben.");
        System.out.println("Es wurden " + line.length() / word.length()  + " Zeilen ausgegeben.");
        System.out.println("Es wurden " + currentchars / word.length() + " Wörter ausgegeben.");
    }
}
