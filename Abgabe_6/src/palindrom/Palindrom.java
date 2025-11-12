package palindrom;

public class Palindrom {
    static boolean palindrom(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "Rentner";
        boolean isPalindrom = palindrom(word);
    }
}
