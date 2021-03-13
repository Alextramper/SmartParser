package frame;

import javax.swing.*;
import java.awt.*;

/**
 * Окно для вывода сообщений о ходе выполнения программы
 */
public class SimpleFrame extends JFrame {

    private String message = "Программа выполняется...";
    JLabel jLabel;

    public SimpleFrame() {
        super("Программа");
        jLabel = new JLabel(this.message);
        this.setBounds(500, 500, 470, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(jLabel);
        this.setVisible(true);

    }

    public void setMessage(String message) {
        jLabel.setText(message);
    }
}
