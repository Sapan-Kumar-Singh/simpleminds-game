package Exam;

import javax.swing.*;  // import swing package
import java.awt.*; //import awt package
import java.awt.event.*; // import action listener


public class Marks extends JFrame implements ActionListener{
     
    
     int score ;

    JButton playAgain;
   Marks(int score){
   // this.name=name;
   this.score=score;
     
    setBounds(100,10,1200,700);// set location and size of frame
    getContentPane().setBackground(Color.WHITE); // set frame color
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/result.jpg")); // to add image in frame
    Image i2=i1.getImage().getScaledInstance(1200, 400, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3); 
    image.setBounds(0,0,1200,300); // set location and size of image in frame
    add(image); // add image to frame

    JLabel heading=new JLabel("ThankYou for playing Simple Minds ");
    heading.setBounds(100,320,1100,60);
    heading.setForeground(new Color(30,144,254));
    heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
     add(heading);

      JLabel marks=new JLabel("Your Score is "+ score);
      marks.setBounds(400,400,1000,60);
      marks.setForeground(new Color(30,144,254));
      marks.setFont(new Font("Viner Hand ITC",Font.BOLD,40)); // set font type , size
       add(marks);

      playAgain=new JButton("Play Again"); // create button
      playAgain.setBounds(500,550,150,30); // set bounds of button
      playAgain.setFont(new Font("Mongolian Bait",Font.PLAIN,20));
      playAgain.addActionListener(this); // add click event to logout button
        add(playAgain); // add button to frame
       setVisible(true);
   }
    
     @Override
   public void actionPerformed(ActionEvent ae){
            if(ae.getSource()== playAgain){
                this.dispose();
                login lg=new login();
                lg.setVisible(true);
            }
   }
    public static void main(String args[]){
        new Marks(0);
    }
}

