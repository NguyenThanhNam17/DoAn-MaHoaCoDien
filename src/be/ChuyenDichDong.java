/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be;

/**
 *
 * @author thanh
 */
public class ChuyenDichDong {
   


    // Hàm mã hóa văn bản bằng cách chuyển dịch các ký tự
    public static String shiftText(String text, int shift) {
        StringBuilder encoded = new StringBuilder();  // Dùng StringBuilder để xây dựng chuỗi kết quả
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);  // Lấy từng ký tự trong chuỗi
            // Kiểm tra nếu là chữ cái viết thường (a-z)
            if (c >= 'a' && c <= 'z') {
                c = (char) ('a' + (c - 'a' + shift) % 26);  // Dịch chuyển vị trí trong bảng chữ cái
            }
            // Kiểm tra nếu là chữ cái viết hoa (A-Z)
            else if (c >= 'A' && c <= 'Z') {
                c = (char) ('A' + (c - 'A' + shift) % 26);  // Dịch chuyển vị trí trong bảng chữ cái
            }
            encoded.append(c);  // Thêm ký tự đã mã hóa vào chuỗi kết quả
        }
        return encoded.toString();  // Trả về chuỗi đã mã hóa
    }
    
public static String shiftLines(String text, int shift) {
    StringBuilder decoded = new StringBuilder();      // Sử dụng StringBuilder để xây dựng chuỗi kết quả
    String[] lines = text.split("\n");                // Tách văn bản thành mảng các dòng bằng cách sử dụng ký tự xuống dòng

    int totalLines = lines.length;                    // Lấy tổng số dòng trong văn bản
    // Duyệt qua từng dòng trong mảng lines
    for (int i = 0; i < totalLines; i++) {
        // Tính chỉ số của dòng sau khi dịch chuyển
        int newIndex = (i + shift + totalLines) % totalLines;  // Dịch chuyển và đảm bảo chỉ số không âm
        decoded.append(lines[newIndex]);               // Thêm dòng đã dịch chuyển vào chuỗi kết quả
        decoded.append("\n");                           // Thêm ký tự xuống dòng để giữ nguyên cấu trúc
    }
    
    return decoded.toString().trim();                 // Trả về chuỗi đã giải mã và loại bỏ ký tự xuống dòng thừa ở cuối
}
}
