/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be;

import java.util.LinkedHashSet;

/**
 *
 * @author thanh
 */
public class Playfair {
    
  public static String prepareKey(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();

        for (char ch : key.toCharArray()) {
            charSet.add(ch);
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (ch == 'J') continue; // Loại bỏ J, coi là I
            charSet.add(ch);
        }

        StringBuilder preparedKey = new StringBuilder();
        for (char ch : charSet) {
            preparedKey.append(ch);
        }
        return preparedKey.toString();
    }

    public static String[] createDigraphs(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder digraphs = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char first = text.charAt(i);
            char second = (i + 1 < text.length()) ? text.charAt(i + 1) : 'X';
            if (first == second) {
                digraphs.append(first).append('X');
                i--; // Lùi lại một bước để không bỏ sót ký tự
            } else {
                digraphs.append(first).append(second);
            }
        }
        return digraphs.toString().split("(?<=\\G..)");
    }

    public static String encrypt(String text, String key) {
        String preparedKey = prepareKey(key);
        String[] digraphs = createDigraphs(text);
        StringBuilder result = new StringBuilder();

        for (String digraph : digraphs) {
            int[] pos1 = findPosition(preparedKey, digraph.charAt(0));
            int[] pos2 = findPosition(preparedKey, digraph.charAt(1));

            if (pos1[0] == pos2[0]) { // Cùng hàng
                result.append(preparedKey.charAt(pos1[0] * 5 + (pos1[1] + 1) % 5));
                result.append(preparedKey.charAt(pos2[0] * 5 + (pos2[1] + 1) % 5));
            } else if (pos1[1] == pos2[1]) { // Cùng cột
                result.append(preparedKey.charAt(((pos1[0] + 1) % 5) * 5 + pos1[1]));
                result.append(preparedKey.charAt(((pos2[0] + 1) % 5) * 5 + pos2[1]));
            } else { // Hình chữ nhật
                result.append(preparedKey.charAt(pos1[0] * 5 + pos2[1]));
                result.append(preparedKey.charAt(pos2[0] * 5 + pos1[1]));
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, String key) {
        String preparedKey = prepareKey(key);
        String[] digraphs = createDigraphs(text);
        StringBuilder result = new StringBuilder();

        for (String digraph : digraphs) {
            int[] pos1 = findPosition(preparedKey, digraph.charAt(0));
            int[] pos2 = findPosition(preparedKey, digraph.charAt(1));

            if (pos1[0] == pos2[0]) { // Cùng hàng
                result.append(preparedKey.charAt(pos1[0] * 5 + (pos1[1] + 4) % 5));
                result.append(preparedKey.charAt(pos2[0] * 5 + (pos2[1] + 4) % 5));
            } else if (pos1[1] == pos2[1]) { // Cùng cột
                result.append(preparedKey.charAt(((pos1[0] + 4) % 5) * 5 + pos1[1]));
                result.append(preparedKey.charAt(((pos2[0] + 4) % 5) * 5 + pos2[1]));
            } else { // Hình chữ nhật
                result.append(preparedKey.charAt(pos1[0] * 5 + pos2[1]));
                result.append(preparedKey.charAt(pos2[0] * 5 + pos1[1]));
            }
        }
        return result.toString();
    }

    public static int[] findPosition(String key, char ch) {
        int index = key.indexOf(ch);
        return new int[]{index / 5, index % 5};
    }
    
   
}
