
package BreakBricks;

import javax.swing.JFrame;

public class MiniProject extends JFrame{

    /***********Parent Window Frame Constructor***************/
    
    public MiniProject(){
        Gameplay gamePlay = new Gameplay();
        setBounds(10,10,700,600);
        setTitle("Breakout Ball");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(gamePlay);
        this.setLocationRelativeTo(null);
    }
    
}
