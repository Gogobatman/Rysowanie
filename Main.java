
package sliski.joe.industry;

import javax.swing.*;

public class Main extends JFrame {

    public Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600,850);
        getContentPane().add(new PanelRysowanie());
        setVisible(true);

    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}
