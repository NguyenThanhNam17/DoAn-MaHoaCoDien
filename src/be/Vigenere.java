/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be;

/**
 *
 * @author thanh
 */
public class Vigenere {
    
      // Hàm mở rộng khóa
    public static String extendKey(String text, String key) {
        StringBuilder extendedKey = new StringBuilder();
        for (int i = 0, j = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                extendedKey.append(key.charAt(j % key.length()));
                j++;
            } else {
                extendedKey.append(text.charAt(i));
            }
        }
        return extendedKey.toString();
    }
    
     // Hàm mã hóa
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        key = key.toLowerCase();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                character = (char) ((character + shift - base) % 26 + base);
                keyIndex++;
            }
            result.append(character);
        }
        return result.toString();
    }

    // Hàm giải mã
    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        key = key.toLowerCase();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                character = (char) ((character - shift - base + 26) % 26 + base);
                keyIndex++;
            }
            result.append(character);
        }
        return result.toString();
    }
}
