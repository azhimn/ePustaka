/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epustaka.backend;

import java.sql.Connection;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author mazhn
 */
public class Validation {
    private static boolean validateRegex(String pattern, String value) {
        return Pattern.compile(pattern)
          .matcher(value)
          .matches();
    }
    
    public static boolean validateEmail(String email) {
        String pattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        boolean result = validateRegex(pattern, email);
        
        if(!result) {
            JOptionPane.showMessageDialog(null, "Format email salah.", "Pemberitahuan", 2);
        }
        return result;
    }
    
    public static boolean validateEmailExists(String email, String table) {
        try {
            String sql = "select email from " + table + " where email = '" + email + "'";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            if (res.next()) {
                JOptionPane.showMessageDialog(null, "Email " + email+ " sudah digunakan, silahkan masukkan email yang baru.", "Pemberitahuan", 2);
                return false;
            }
        } catch (Exception e) {}   
        return true;
    }
    
    public static boolean validatePassword(String password) {
        String pattern = "^(?=\\S+$).{8,}$";
        boolean result = validateRegex(pattern, password);
        
        if(!result) {
            JOptionPane.showMessageDialog(null, "Password minimal terdiri dari 8 angka dan tidak boleh ada spasi.", "Pemberitahuan", 2);
        }
        return result;
    }
    
    public static boolean validatePhone(String phone) {
        if ("0".equals(phone.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Nomor telepon diawali dengan kode negara.", "Pemberitahuan", 2);
            return false;
        }
        
        String pattern = "^[0-9]{11,14}$";
        boolean result = validateRegex(pattern, phone);
        
        if(!result) {
            JOptionPane.showMessageDialog(null, "Hanya angka dibolehkan dalam Nomor Telepon \n Contoh: 6281234567890", "Pemberitahuan", 2);
        }
        return result;
    }
    
    public static boolean validateISBN(String isbn) {
        String pattern = "^[0-9]{10,13}$";
        boolean result = validateRegex(pattern, isbn);
        
        if(!result) {
            JOptionPane.showMessageDialog(null, "ISBN harus terdiri dari 10 s.d. 13 angka.", "Pemberitahuan", 2);
        }
        return result;
    }
    
    public static boolean validateISBNExists(String isbn) {
        try {
            String sql = "select isbn from buku where isbn = '" + isbn + "'";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            if (res.next()) {
                JOptionPane.showMessageDialog(null, "ISBN " + isbn + " sudah digunakan, silahkan masukkan ISBN yang baru.", "Pemberitahuan", 2);
                return false;
            }
        } catch (Exception e) {}
        return true;
    }
    
    public static boolean validateGreaterDate(Date lesser, Date greater) {
        int result = lesser.compareTo(greater);

        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Tanggal tenggat tidak boleh berada sebelum tanggal peminjaman.", "Pemberitahuan", 2);
            return false;
        } else if (result < 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Kedua tanggal tidak boleh sama.", "Pemberitahuan", 2);
            return false;
        }
    }
    
    public static boolean validateLocation(String location) {
        String patternA = "^[A-Z]-\\d$";
        String patternB = "^[A-Z]{2}-\\d{2}$";
        
        boolean resultA = validateRegex(patternA, location);
        boolean resultB = validateRegex(patternB, location);
        if(!resultA && !resultB) {
            JOptionPane.showMessageDialog(null, "Format lokasi harus mengikuti salah satu contoh di bawah: \n A-1 atau AA-01", "Pemberitahuan", 2);
            return false;
        }
        return true;
    }
    
//    static class NumberOnlyFilter extends DocumentFilter {
//        @Override
//        public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr)
//                throws BadLocationException {
//            if (isNumeric(text)) {
//                super.insertString(fb, offset, text, attr);
//            }
//        }
//
//        @Override
//        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
//                throws BadLocationException {
//            if (isNumeric(text)) {
//                super.replace(fb, offset, length, text, attrs);
//            }
//        }
//
//        private boolean isNumeric(String str) {
//            return str.matches("\\d*");
//        }
//    }
}
