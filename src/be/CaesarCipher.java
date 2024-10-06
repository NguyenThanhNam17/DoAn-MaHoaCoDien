/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be;

/**
 *
 * @author thanh
 */
public class CaesarCipher {

    // Hàm mã hóa Caesar
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        // Lặp qua từng ký tự của chuỗi
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            // Xử lý ký tự chữ cái in hoa
            if (Character.isUpperCase(character)) {
                char encryptedChar = (char) (((int) character + shift - 65) % 26 + 65);
                result.append(encryptedChar);
            }
            // Xử lý ký tự chữ cái thường
            else if (Character.isLowerCase(character)) {
                char encryptedChar = (char) (((int) character + shift - 97) % 26 + 97);
                result.append(encryptedChar);
            }
            // Giữ nguyên ký tự không phải chữ cái
            else {
                result.append(character);
            }
        }

        return result.toString();
    }
    
    public static String decrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (Character.isUpperCase(character)) {
                char decryptedChar = (char) (((int) character - shift - 65 + 26) % 26 + 65);
                result.append(decryptedChar);
            } else if (Character.isLowerCase(character)) {
                char decryptedChar = (char) (((int) character - shift - 97 + 26) % 26 + 97);
                result.append(decryptedChar);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
    
}
