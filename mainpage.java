
/*Before executing the mainpage.java file please check the paths of the image as all the images are attached in assets folder*/

/********************************************************************************/
package mainpage;


import TicTacToe.TicTacToe;
import SnakeGame.GameFrame;
import BreakBricks.MiniProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.border.Border;



class mainpage extends JFrame implements ActionListener
{
    JButton b1,b2,b3;
    JLabel lb2, lb3;
    Dialog d;
   
    public mainpage()
    {   
        this.setTitle("Gaming Portal in Java");
        this.setSize(1450,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        
        /******************Title Bar and Title Heading with Logo************************************/
        JLabel strip=new JLabel(new ImageIcon  
        ("C:\\Users\\Sai\\Documents\\NetBeansProjects\\MiniProject\\src\\assets\\strip.png"));
        //(getClass().getClassLoader().getResource("strip.png")));
        strip.setBounds(0,10,1000,60);
        add(strip);
        
        JLabel strip1=new JLabel(new ImageIcon  
        ("C:\\Users\\Sai\\Documents\\NetBeansProjects\\MiniProject\\src\\assets\\strip.png"));
        //(getClass().getClassLoader().getResource("strip.png")));
        strip1.setBounds(900,10,1000,60);
        add(strip1);
        
        JLabel mainlogo=new JLabel(new ImageIcon  
        ("C:\\Users\\Sai\\Documents\\NetBeansProjects\\MiniProject\\src\\assets\\mainlogo.png"));
        //(getClass().getClassLoader().getResource("mainlogo.png")));
        mainlogo.setBounds(-40,0,200,60);
        strip.add(mainlogo);
        
        lb3=new JLabel("Gaming Portal");
        lb3.setBounds(120,5,1450,50);
        lb3.setBackground(Color.black);
        lb3.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lb3.setForeground(Color.white);
        strip.add(lb3);
        
        
        /******************Background Image and Main Heading************************************/
        JLabel background=new JLabel(new ImageIcon  
        ("C:\\Users\\Sai\\Documents\\NetBeansProjects\\MiniProject\\src\\assets\\mainpage.jpg"));
        //(getClass().getClassLoader().getResource("mainpage.jpg")));
        background.setBounds(0,0,1400,800);
        add(background);
        
        
        lb2=new JLabel("Adorn your Life with the Joyful Games.");
        lb2.setBounds(120,120,1300,200);
        lb2.setFont(new Font("Times New Roman",Font.BOLD,65));
        lb2.setForeground(new Color(142,20,56));
        background.add(lb2);
        
        
        
       
        /********************************Snake Game******************************************/
        JLabel snakeimg=new JLabel(new ImageIcon
        ("C:\\Users\\Sai\\Documents\\NetBeansProjects\\MiniProject\\src\\assets\\snake.png"));
        //(getClass().getClassLoader().getResource("snake.png")));
        snakeimg.setBounds(150,350,350,250);
        background.add(snakeimg);
        
        b1=new JButton("Get Started");
        b1.setBounds(220,610,200,50);
        b1.setBackground(new Color(142,20,56));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        background.add(b1);
        
        /********************************Breakout Ball Game******************************************/
        JLabel brick=new JLabel(new ImageIcon
        ("C:\\Users\\Sai\\Documents\\NetBeansProjects\\MiniProject\\src\\assets\\brick.jpeg"));
        //(getClass().getClassLoader().getResource("brick.jpeg")));
        brick.setBounds(500,350,350,250);
        background.add(brick);
        
        b2=new JButton("Get Started");
        b2.setBounds(580,610,200,50);
        b2.setBackground(new Color(142,20,56));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        b2.setFont(new Font("Times New Roman", Font.BOLD, 24));
        background.add(b2);
        
        /********************************Tic-Tac-Toe Game******************************************/
        JLabel bird=new JLabel(new ImageIcon
        ("C:\\Users\\Sai\\Documents\\NetBeansProjects\\MiniProject\\src\\assets\\tictactoe.png"));
        //(getClass().getClassLoader().getResource("tictactoe.png")));
        bird.setBounds(850,350,350,250);
        background.add(bird);

        b3=new JButton("Get Started");
        b3.setBounds(930,610,200,50);
        b3.setBackground(new Color(142,20,56));
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        b3.setFont(new Font("Times New Roman", Font.BOLD, 22));
        background.add(b3);


        setSize(1349,799);
        setSize(1450,800);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==b1){
           new GameFrame();
        }
        else if(e.getSource()==b2){
            new MiniProject();
        }
        else if(e.getSource()==b3){
            new TicTacToe();
        }
    }
    
    public static void main(String args[])
    {
        new mainpage();
        
        /********************************Dialog Box******************************************/
        ImageIcon icon;  
        icon = new ImageIcon("C:\\Users\\Sai\\Documents\\NetBeansProjects\\MiniProject\\src\\assets\\mainlogo2.png");
        
        JOptionPane.showMessageDialog(null,"Welcome to the Gaming Portal in Java. Hope you will enjoy the games. Click OK to continue","Gaming Portal",JOptionPane.PLAIN_MESSAGE,icon);
        
    }
    
}