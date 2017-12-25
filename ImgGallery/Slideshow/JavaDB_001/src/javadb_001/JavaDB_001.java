package javadb_001;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JavaDB_001 extends JFrame {
    JLabel pic;
    Timer tm;
    int x = 0;

    //Images Path In Array
    String[] list = {
                      "img/1.jpg",//0
                      "img/2.jpg",//1
                      "img/3.jpg",//2
                      "img/4.jpg",//3
                      "img/5.jpg",//4
                      "img/6.jpg",//5
                      "img/7.jpg"//6
                    };
    
    public JavaDB_001(){
        super("Java SlideShow");
        pic = new JLabel();
        pic.setBounds(20,20,400,300);

        //Call The Function SetImageSize
        SetImageSize(6);
        
       //set a timer
        tm = new Timer(2000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length)
                    x = 0; 
            }
        });
        add(pic);
        tm.start();
        setLayout(null);
        setSize(460,500);
        getContentPane().setBackground(Color.decode("#ffeead"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

    public static void main(String[] args){ 
        new JavaDB_001();
    }
}