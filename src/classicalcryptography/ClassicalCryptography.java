package classicalcryptography;
/**
 * @190315091
 * @author Yaser Beker
 */
import java.util.Scanner;

public class ClassicalCryptography {

    public static void main(String[] args) {
        String message;
        Scanner input = new Scanner(System.in);
        String line = "";
        char letters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',};
        do {
            System.out.println("Enter a message in English letters : ");
            line = input.nextLine().toUpperCase();
        } while (!inLetters(line, letters));
        String cipher = encrypt(line, 3);
        System.out.println("the encrypted message: " + cipher.toUpperCase());
        String decrypted = decrypt(cipher, 3);
        System.out.println("the decrypted message: " + decrypted);
    }
// Here the given text is encoded by incrementing it by 3
    public static String encrypt(String plaintext, int shift) {
        if (shift > 26) {
            shift = shift % 26;
        } else if (shift < 0) {
            shift = (shift % 26) + 26;
        }
        String cipherText = "";
        int length = plaintext.length();
        for (int i = 0; i < length; i++) {
            char ch = plaintext.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char c = (char) (ch + shift);
                    if (c > 'z') {
                        cipherText += (char) (ch - (26 - shift));
                    } else {
                        cipherText += c;
                    }
                } else if (Character.isUpperCase(ch)) {
                    char c = (char) (ch + shift);
                    if (c > 'Z') {
                        cipherText += (char) (ch - (26 - shift));
                    } else {
                        cipherText += c;
                    }
                }
            } else {
                cipherText += ch;
            }
        }
        return cipherText;
    }
// Here it returns the given text as it was
    public static String decrypt(String plaintext, int shift) {
        if (shift > 26) {
            shift = shift % 26;
        } else if (shift < 0) {
            shift = (shift % 26) + 26;
        }
        String cipherText = "";
        int length = plaintext.length();
        for (int i = 0; i < length; i++) {
            char ch = plaintext.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char c = (char) (ch - shift);
                    if (c < 'a') {
                        cipherText += (char) (ch + (26 - shift));
                    } else {
                        cipherText += c;
                    }
                } else if (Character.isUpperCase(ch)) {
                    char c = (char) (ch - shift);
                    if (c < 'A') {
                        cipherText += (char) (ch + (26 - shift));
                    } else {
                        cipherText += c;
                    }
                }
            } else {
                cipherText += ch;
            }
        }
        return cipherText;
    }
// Here to prevent the user from entering any non-English character
    public static boolean inLetters(String message, char[] letters) {
        char[] chars = message.toCharArray();
        boolean found = true;
        for (char c : chars) {
            if (!found) {
                break;
            }
            for (int i = 0; i < letters.length; i++) {
                if (c == letters[i] || c == ' ') {
                    found = true;
                    break;
                } else {
                    found = false;
                }
            }
        }
        return found;
    }
}
