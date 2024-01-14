/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epustaka.backend;

import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, "Format email salah.");
        }
        return result;
    }
    
    public static boolean validatePassword(String password) {
        String pattern = "^(?=\\S+$).{8,}$";
        boolean result = validateRegex(pattern, password);
        
        if(!result) {
            JOptionPane.showMessageDialog(null, "Password minimal terdiri dari 8 angka dan tidak boleh ada spasi.");
        }
        return result;
    }
    
    public static boolean validatePhone(String phone) {
        if ("0".equals(phone.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Nomor telepon diawali dengan kode negara.");
            return false;
        }
        
        String pattern = "^[0-9]*.{11,14}$";
        boolean result = validateRegex(pattern, phone);
        
        if(!result) {
            JOptionPane.showMessageDialog(null, "ISBN harus terdiri dari 10 s.d. 13 angka.");
        }
        return result;
    }
    
    public static boolean validateISBN(String isbn) {
        String pattern = "^[0-9]{10,13}$";
        boolean result = validateRegex(pattern, isbn);
        
        if(!result) {
            JOptionPane.showMessageDialog(null, "ISBN harus terdiri dari 10 s.d. 13 angka.");
        }
        return result;
    }
    
    public static boolean validateGreaterDate(Date lesser, Date greater) {
        int result = lesser.compareTo(greater);

        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Tanggal tenggat tidak boleh berada sebelum tanggal peminjaman.");
            return false;
        } else if (result < 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Kedua tanggal tidak boleh sama.");
            return false;
        }
    }
}
