package ua.opnu.list;


import ua.opnu.list.DrawFrame;

import javax.swing.*;

public class MainForDraw {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new DrawFrame("Program Draw"));
    }
}