/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.utilities;

import javax.swing.JOptionPane;

/**
 *
 * @author lecturerf6
 */
public class MessageUtils {

    public static void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(
                null, 
                message, 
                title, 
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfoMessage(String title, String message) {
        JOptionPane.showMessageDialog(
                null, 
                message, 
                title, 
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean showConfirmMessage(String title, String message) {
        return JOptionPane.showConfirmDialog(
                null, 
                message, 
                title, 
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE)
                == JOptionPane.OK_OPTION;
    }

    private MessageUtils() {
    }
    
    
}
