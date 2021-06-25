
package BreakBricks;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
    
    /***********Declaration***************/
    boolean play = false;
    int score = 0;
    
    int totalBricks = 21;
    
    Timer timer;
    static final int delay = 1;
    
    int playerX = 310;
    
    int ballposX = 120;
    int ballposY = 350;
    int ballXdir = -1;
    int ballYdir = -2;
    
    MapGenerator map;
    
    
    /***********Constructor***************/
    public Gameplay(){
        map = new MapGenerator(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
        
    }
   
    public void paint(Graphics g){
        //background
        g.setColor(Color.black);
        g.fillRect(1, 1, 690, 590);
        
        //map draw
        map.draw((Graphics2D)g);
        
        //borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        
        //score addition
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString("" +score, 590, 30);
        
        //the paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);
        
        //ball
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, 20, 20);
        
        if(totalBricks==0){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("YOU WON, Score is : " +score, 190, 300);
         
        }
        if(ballposY > 570){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("GAME OVER, Score is : " +score, 190, 300);
           
        }
        g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        timer.start();
        if(play){
            if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))){
               ballYdir = -ballYdir; 
            }
            
            A: for(int i =0; i< map.map.length; i++){
                for(int j=0; j<map.map[0].length; j++){
                    if(map.map[i][j]>0){
                        int brickX = j*map.brickWidth + 80;
                        int brickY = i*map.brickHeight+ 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;
                        
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rect;
                        
                        if(ballRect.intersects(brickRect)){
                            map.setBrickValue(0, i, j);
                            totalBricks--;
                            score += 5;
                            
                            if(ballposX + 19 <= brickRect.x || ballposX +1>=brickRect.x + brickRect.width){
                                ballXdir = -ballXdir;
                            }else{
                                ballYdir = -ballYdir;
                            }
                            
                            break A;
                        }
                    }
                }
            }
            ballposX += ballXdir;
            ballposY += ballYdir;
            if(ballposX < 0){
                ballXdir = -ballXdir;
            }
            if(ballposY < 0){
                ballYdir = -ballYdir;
            }
            if(ballposX > 670){
                ballXdir = -ballXdir;
            }
        }
        
        repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){}


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(playerX>=600){
             playerX=600;   
            }else{
                moveRight();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(playerX<10){
             playerX=10;   
            }else{
                moveLeft();
            }
        }
        
    }
    public void moveRight(){
        play = true;
        playerX+=20;
    }
     public void moveLeft(){
        play = true;
        playerX-=20;
    }

     
}
