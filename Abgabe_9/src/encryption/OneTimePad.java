package encryption;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

class OneTimePad {

    /**
     * Erzeugt einen Schlüssel in der angegebenen Länge.
     *
     * @param lengthInBytes Die länge des Schlüssels in Bytes.
     * @return Der Schlüssel.
     */
    byte[] createKey(int lengthInBytes) {
        byte[] key = new byte[lengthInBytes];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(key);
        return key;
    }

    /**
     * Diese Methode wandelt das übergebene Byte-Array in einen Binärstring um. Nach je 8 Bits wird ein Leerzeichen
     * eingefügt.
     *
     * @param bytes Das umzuwandelnde Byte-Array.
     * @return Der Binärstring.
     */
    String toBinaryString(byte[] bytes) {
        StringBuilder binaryString = new StringBuilder();
        for (byte bytePiece : bytes) {
            for (int i = 7; i >= 0; i--) {
                int bit = (bytePiece & (int) Math.pow(2, i)) >>> i;
                binaryString.append(bit);
            }
            binaryString.append(" ");
        }
        return binaryString.toString();
    }

    /**
     * Diese Methode verschlüsselt die übergebene Nachricht mit dem Schlüssel. Dabei wird jedes Byte der Nachricht durch
     * den Exklusiv-Oder-Operator mit dem entsprechenden Byte des Schlüssels verknüpft.
     *
     * @param message Die zu verschlüsselnde Nachricht.
     * @param key     Der Schlüssel.
     * @return Die verschlüsselte Nachricht als Byte-Array.
     */
    byte[] encryptMessage(byte[] message, byte[] key) {
        byte[] encryptMessage = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            encryptMessage[i] = (byte) (message[i] ^ key[i]);
        }
        return encryptMessage;
    }

    /**
     * Diese Methode entschlüsselt die übergebene verschlüsselte Nachricht mit dem Schlüssel. Dabei wird jedes Byte der
     * Nachricht durch den Exeklusiv-Oder-Operator mit dem entsprechenden Byte des Schlüssels verknüpft.
     *
     * @param encryptedMessage Die verschlüsselte Nachricht.
     * @param key              Der Schlüssel.
     * @return Die entschlüsselte Nachricht als Byte-Array.
     */
    byte[] decryptMessage(byte[] encryptedMessage, byte[] key) {
        byte[] decryptMessage = new byte[encryptedMessage.length];
        for (int i = 0; i < decryptMessage.length; i++) {
            decryptMessage[i] = (byte) (encryptedMessage[i] ^ key[i]);
        }
        return decryptMessage;
    }

    /**
     * Diese Methode wandelt den übergebenen Binärstring (mit Leerzeichen zwischen je 8 Bits) in ein Byte-Array um.
     *
     * @param binaryString Der Binärstring.
     * @return Das Byte-Array.
     */
    private byte[] toByteArray(String binaryString) {
        // Teil 2) Bitte implementieren: Verwenden Sie zur Umwandlung eines einzelnen Bytes die folgende Anweisung
        //   byte b = (byte) Integer.parseInt(byteString, 2);
        String[] binrayStringArray = binaryString.split(" ");
        byte[] byteArray = new byte[binrayStringArray.length];

        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = (byte) Integer.parseInt(binrayStringArray[i], 2);
        }
        return byteArray;
    }

    /**
     * Diese Methode fragt interaktiv nach einer zu verschlüsselnden Nachricht. Es wird ein Schlüssel erzeugt und die
     * Nachricht wird mit dem Schlüssel verschlüsselt.
     * <p>
     * Schlüssel und verschlüsselte Nachricht werden als Binärstring ausgegeben.
     */
    void encryptionInteractive() {
        System.out.println("***Verschlüsseln einer Nachricht***");
        // Teil 2) Bitte implementieren.
        // Hier ein paar Bausteine:
        //   System.out.print("Bitte den zu verschlüsselnden Text eingeben: ");
        //   System.out.println("Der Schlüssel:\n" + keyAsBinaryString);
        //   System.out.println("Die verschlüsselte Nachricht:\n" + encryptedMessageAsBinaryString);
        System.out.print("Bitte den zu verschlüsselnden Text eingeben: ");
        Scanner textScanner = new Scanner(System.in);
        byte[] textAsByteArray = toByteArray(toBinaryString(textScanner.nextLine().getBytes()));
        byte[] key = createKey(textAsByteArray.length);
        String keyAsBinaryString = toBinaryString(key);
        System.out.println("Der Schlüssel:\n" + keyAsBinaryString);
        byte[] encryptedMessage = encryptMessage(textAsByteArray, key);
        String encryptedMessageAsBinaryString = toBinaryString(encryptedMessage);
        System.out.println("Die verschlüsselte Nachricht:\n" + encryptedMessageAsBinaryString);
    }

    /**
     * Diese Methode fragt interaktiv nach einer verschlüsselten Nachricht und nach einem Schlüssel. Die Nachricht wird
     * mit dem Schlüssel entschlüsselt.
     * <p>
     * Die entschlüsselte Nachricht wird im Klartext ausgegeben.
     */
    void decryptionInteractive() {
        System.out.println("***Entschlüsseln einer Nachricht***");
        System.out.print("Bitte den zu entschlüsselnden Binärstring eingeben: ");
        Scanner textScanner = new Scanner(System.in);
        String secret = textScanner.nextLine();
        System.out.print("Bitte den Schlüssel als Binärstring eingeben: ");
        String key = textScanner.nextLine();
        String decryptedMessage = new String(decryptMessage(toByteArray(secret), toByteArray(key)));
        System.out.println("Die entschlüsselte Nachricht:\n" + decryptedMessage);

    }
}
