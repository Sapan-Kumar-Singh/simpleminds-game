package Exam;

import javax.swing.*;  // import swing package
import java.awt.*; //import awt package
import java.awt.event.*; // import action listener

public class quiz extends JFrame implements ActionListener{

       String questions[][]=new String[10][5]; // store 10 question with 4 option
      String answer[][]=new String[10][1]; // to store correct answer;
      String userAnswer [][]=new String[10][1]; // to store user answer

      JLabel qno,question;
      JRadioButton op1,op2,op3,op4;
      JButton next,lifeline,submit;
      ButtonGroup groupOption;

      public static int timer=15;

      public static int ans_given=0;
      public static int count=0;
      public static int score;
      public  String name;

    public quiz(){
        // assign question and answer to 2-d array

        //this.name=name;

        questions[0][0]="What is Java?";
        questions[0][1]="An operating system";
        questions[0][2]="A programming language";
        questions[0][3]="A database management system";
        questions[0][4]="A web browser";

        questions[1][0]="What is the syntax for declaring a variable in Java?";
        questions[1][1]="var <variable name>;";
        questions[1][2]="String <variable name>;";
        questions[1][3]="int <variable name>;";
        questions[1][4]="declare <variable name>;";

        questions[2][0]="What is an interface in Java?";
        questions[2][1]="A class that can be instantiated";
        questions[2][2]="A data structure";
        questions[2][3]="A method of object creation";
        questions[2][4]="A blueprint for a class";

        questions[3][0]="What is a constructor in Java?";
        questions[3][1]=" A method that is used to access private variables";
        questions[3][2]="A method that is called when an object is destroyed";
        questions[3][3]="A method that is called automatically when an object is created";
        questions[3][4]="A method that is used to access public variables";

        questions[4][0]="Which of the following is not a primitive data type in Java?";
        questions[4][1]="string";
        questions[4][2]=" int";
        questions[4][3]="float";
        questions[4][4]="char";

        questions[5][0]="What is polymorphism in object-oriented programming?";
        questions[5][1]="The ability of an object to have multiple instances";
        questions[5][2]="The ability of an object to take on many forms";
        questions[5][3]=" The ability of an object to change its own properties";
        questions[5][4]="The ability of an object to reference another object";

        questions[6][0]="What is the purpose of the 'final' keyword in Java?";
        questions[6][1]="To indicate that a class cannot be subclassed";
        questions[6][2]="To indicate that a method cannot be overridden";
        questions[6][3]="To indicate that a variable cannot be changed once it is assigned a value";
        questions[6][4]="All of the above";

        questions[7][0]="What is the purpose of the super keyword in Java?";
        questions[7][1]="To declare a superclass";
        questions[7][2]="To declare a subclass";
        questions[7][3]="To invoke a superclass constructor or method";
        questions[7][4]="To invoke a subclass constructor or method";

        questions[8][0]="What is the difference between a class and an object in object-oriented programming?";
        questions[8][1]="A class is a blueprint for creating objects, while an object is an instance of a class";
        questions[8][2]="A class is a data type, while an object is a variable";
        questions[8][3]="A class is a method, while an object is a property";
        questions[8][4]="A class is a package, while an object is a module";

        questions[9][0]="Which of the following is not a Java features?";
        questions[9][1]="Dynamic";
        questions[9][2]="Architecture Neutral";
        questions[9][3]="Object-oriented";
        questions[9][4]="Use of pointers";

        answer[0][0]="A programming language";
        answer[1][0]="int <variable name>;";
        answer[2][0]="A blueprint for a class";
        answer[3][0]="A method that is called automatically when an object is created";
        answer[4][0]="string";
        answer[5][0]="The ability of an object to take on many forms";
        answer[6][0]="All of the above";
        answer[7][0]="To invoke a superclass constructor or method";
        answer[8][0]="A class is a blueprint for creating objects, while an object is an instance of a class";
        answer[9][0]="Use of pointers";



        setBounds(100,10,1200,700);// set location and size of frame
        getContentPane().setBackground(Color.WHITE); // set frame color
        setLayout(null);
       ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("image/quiz.jpg")); // to add image in frame
         JLabel image=new JLabel(i2); //
        image.setBounds(0,0,1200,300); // set location and size of image in frame
        add(image); // add image to frame

         qno=new JLabel();
        qno.setBounds(50,300,50,50);
        qno.setFont(new Font("Serif", Font.PLAIN, 24));
        qno.setForeground(Color.BLACK);
        add(qno);

        question=new JLabel();
        question.setBounds(90,300,900,50);
        question.setFont(new Font("Serif", Font.PLAIN, 24));
        question.setForeground(Color.BLACK);
        add(question);

        // set radio button
         op1=new JRadioButton();
        op1.setBounds(70,350,700,30);
        op1.setBackground(Color.WHITE);
        op1.setFont(new Font("Serif",Font.PLAIN,20));
        add(op1);

         op2=new JRadioButton();
        op2.setBounds(70,385,700,30);
        op2.setBackground(Color.WHITE);
        op2.setFont(new Font("Serif",Font.PLAIN,20));
        add(op2);

        op3=new JRadioButton();
        op3.setBounds(70,415,700,30);
        op3.setBackground(Color.WHITE);
        op3.setFont(new Font("Serif",Font.PLAIN,20));
        add(op3);

        op4=new JRadioButton();
        op4.setBounds(70,445,700,30);
        op4.setBackground(Color.WHITE);
        op4.setFont(new Font("Serif",Font.PLAIN,20));
        add(op4);
        // make radio button group to select one option at one time
        groupOption=new ButtonGroup();
        groupOption.add(op1);
        groupOption.add(op2);
        groupOption.add(op3);
        groupOption.add(op4);

        lifeline=new JButton("50-50 lifeline"); // create button
        lifeline.setBounds(800,400,200,40); // set bounds of button
        lifeline.setFont(new Font("Mongolian Bait",Font.PLAIN,15));
        lifeline.addActionListener(this); // add click event to login button
        add(lifeline); // add button to frame

        next=new JButton("next"); // create button
        next.setBounds(800,450,200,40); // set bounds of button
        next.setFont(new Font("Mongolian Bait",Font.PLAIN,15));
        next.addActionListener(this); // add click event to login button
         add(next); // add button to frame

        submit=new JButton("submit"); // create button
        submit.setBounds(800,500,200,40); // set bounds of button
        submit.setFont(new Font("Mongolian Bait",Font.PLAIN,15));
        submit.addActionListener(this); // add click event to login button
        submit.setEnabled(false); // initially submit is disable
        add(submit); // add button to frame

        // call start function to start quiz

        start(count);

        setVisible(true);
    }

       @Override
    public void actionPerformed(ActionEvent ae){
        // next button click
       if(ae.getSource()==next){
         repaint();
         op1.setEnabled(true);// when next ques comes all radio button should enabled 
         op2.setEnabled(true);
         op3.setEnabled(true);
         op4.setEnabled(true);
         ans_given=1;
         // groupoption give null when not any radio button is choose
         if(groupOption.getSelection()==null){
            userAnswer[count][0]=""; // user not select any answer
          }
         else{
           userAnswer[count][0]=groupOption.getSelection().getActionCommand(); // to select user answer
         }
         if(count==8){
            next.setEnabled(false);// next is enable from ques 9
            submit.setEnabled(true);
        }
         count++;
         start(count);

       }
         // if lifeline button click
        else if(ae.getSource()==lifeline){

        if(count==2 || count==4 || count==6 || count==8 || count==9){
            op2.setEnabled(false);
            op3.setEnabled(false);
        } else{
            op1.setEnabled(false);
            op4.setEnabled(false);
        }
         lifeline.setEnabled(false);

       } 
        // if submit button click

       else if(ae.getSource()==submit){
          ans_given=1;
           
          if(groupOption.getSelection()==null){
            userAnswer[count][0]=""; // user not select any answer
           }
          else {
            userAnswer[count][0]=groupOption.getSelection().getActionCommand(); // to select user answer

          }

          for(int i=0;i<userAnswer.length;i++){

               if(userAnswer[i][0].equals(answer[i][0])==true){
                  score+=10;
               }
        }

       // setvisible false for this frame
          this.dispose(); // close current frame
         
       // now move to next score frame
         
          Marks mks=new Marks(score);
          mks.setVisible(true);
       }

    }

    // to update frame  we use paint method 

       @Override
    public void paint(Graphics g){
        super.paint(g); // paint method call automatically 

        String time="Time Left - "+ timer+ " Seconds";
        g.setColor(Color.BLUE); 
        g.setFont(new Font("Mongolian Bait",Font.BOLD,25));
        if(timer>0){
           g.drawString(time, 850, 380);
        }
        else{
            g.setColor(Color.RED); 
            g.drawString("Times Up!!", 850, 380);
        }

        timer--;

        // call repaint after one second
        try{
            Thread.sleep(1000); // thread method stop here for one sec
            repaint();  // call paint method repeatly
        }
        catch(InterruptedException e){
        }

        if(ans_given==1){
            // if ans is given then move to next ques
            ans_given=0;
            timer=15;

        }
        else if(timer<0){
            // if ans not given but times up
            timer=15;
            op1.setEnabled(true);// when next ques comes all radio button should enabled 
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);
            

            if(count==8){
                next.setEnabled(false);// next is enable from ques 9
                submit.setEnabled(true);
            }
            if(count==9){ // submit button case auto submit after question end

                if(groupOption.getSelection()==null){
                    userAnswer[count][0]=""; // user not select any answer
                 }
                else {
                   userAnswer[count][0]=groupOption.getSelection().getActionCommand(); // to select user answer

               }

               for(int i=0;i<userAnswer.length;i++){
                if(userAnswer[i][0].equals(answer[i][0])==true){
                    score+=10;
                }

               }

               // setvisible false for this frame
               this.dispose(); // close current frame
         
       // now move to next score frame
          //new Marks(name,score);
                      Marks mks=new Marks(score);
                      mks.setVisible(true);
           
            } else{ // next button case 

                 // groupoption give null when not any radio button is choose
              if(groupOption.getSelection()==null){
                  userAnswer[count][0]=""; // user not select any answer
               }
              else {
                 userAnswer[count][0]=groupOption.getSelection().getActionCommand(); // to select user answer
             }
              count++;
             start(count);

            }

           
        }

    }

     public void start(int count)
     {
           qno.setText(" "+(count+1)+". "); // setText() only store string value
           question.setText(questions[count][0]);
           op1.setText(questions[count][1]);
           op1.setActionCommand(questions[count][1]); // to set answer

           op2.setText(questions[count][2]);
           op2.setActionCommand(questions[count][2]);

           op3.setText(questions[count][3]);
           op3.setActionCommand(questions[count][3]);

           op4.setText(questions[count][4]);
           op4.setActionCommand(questions[count][4]);

           groupOption.clearSelection(); // clear radio button as we previous selected
     }
    public static void main(String args[]){
        count=0;
           new quiz();// anonamous object
    }
}
