/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be;

/**
 *
 * @author thanh
 */
public class Caesar {
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                result.append((char) ((ch + shift - base) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
     
      public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }
}
