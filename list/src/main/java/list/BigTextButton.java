package ua.opnu.list;

import javax.swing.*;
import java.awt.*;

public class BigTextButton extends JButton {

    public BigTextButton(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.PLAIN, 22));
    }
}
