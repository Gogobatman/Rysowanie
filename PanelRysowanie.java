package sliski.joe.industry;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.*;

public class PanelRysowanie extends JPanel {
    ArrayList<Piksel> listaPikseli;
    int size=5;
    Color color = Color.blue;
    Przycisk przycisk0= new Przycisk("Czarny",this);
    Przycisk przycisk1= new Przycisk("Cyjanowy",this);
    Przycisk przycisk2= new Przycisk("Czerwony",this);
    Przycisk przycisk3= new Przycisk("Niebieski",this);
    Przycisk przycisk4= new Przycisk("Biały",this);
    Przycisk przycisk5= new Przycisk("+",this);
    Przycisk przycisk6= new Przycisk("-",this);
    public void paintComponent(Graphics canvas){
        super.paintComponent(canvas);
        for(Piksel b: listaPikseli){
            b.draw(canvas);
        }
    }
    public void wyczysc(){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1600,850);
    }
    private class Przycisk extends JButton {
        public Przycisk(String nazwa,PanelRysowanie panelRysowanie){
            super(nazwa);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(nazwa=="Cyjanowy"){
                        panelRysowanie.color = Color.CYAN;
                    } else if(nazwa=="Czerwony"){
                        panelRysowanie.color = Color.RED;
                    } else if(nazwa=="Niebieski"){
                        panelRysowanie.color = Color.BLUE;
                    } else if(nazwa=="Biały"){
                        panelRysowanie.color = Color.WHITE;
                    } else if(nazwa=="+"){
                        size+=5;
                    }else if(nazwa=="-" && size>5){

                        size-=5;
                    }
                    else if(nazwa=="Czarny"){

                        panelRysowanie.color = Color.BLACK;
                    }

                }
            });
        }

    }
    public PanelRysowanie(){
        listaPikseli = new ArrayList<Piksel>();
        setBackground(Color.BLACK);
        addMouseListener(new BubbleListener());
        addMouseMotionListener(new BubbleListener());
        add(przycisk0);
        add(przycisk1);
        add(przycisk2);
        add(przycisk3);
        add(przycisk4);
        add(przycisk5);
        add(przycisk6);
    }

    private class Piksel{
        private int x;
        private int y;
        private int size;
        private Color color;
        public Piksel(int newX, int newY, int newSize, Color color){
            x=newX;
            y=newY;
            size=newSize;
            this.color= color;
        }
        public void draw(Graphics canvas){
            canvas.setColor(color);
            canvas.fillOval(x-size/2, y-size/2, size, size);
        }
    }
    private class BubbleListener extends  MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            listaPikseli.add(new Piksel(e.getX(),e.getY(),size,color));
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            listaPikseli.add(new Piksel(e.getX(),e.getY(),size,color));
            repaint();
        }
        @Override
        public void mouseClicked(MouseEvent e) {
        }

    }

}
