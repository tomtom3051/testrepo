/** Ballroom.java
  *   @author
  *   @id
  */

/* Don't make your lines longer than this one *********************************/

//TODO
// Add bounciness at the end of the screen

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;

class Ballroom {
  BallroomPanel ballroomPanel = new BallroomPanel();
  Timer timer;

  void createGUI() {
    // create the GUI on the event thread.
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        final JFrame frame = new JFrame("Ballroom");
        frame.add(ballroomPanel, BorderLayout.CENTER);
        frame.setSize( 600, 400 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ballroomPanel.addBalls();

        timer = new Timer( 50, ballroomPanel);

        timer.start();
      }
    });
  }

  public static void main( String[] a ) {
    new Ballroom().createGUI();
  }
}

class BallroomPanel extends JPanel implements ActionListener {
  Timer timer;
  ArrayList<Baall> balls =
    new ArrayList<Baall>(); 

  void addBalls() {
    balls.add( new Baall( 100, 10 ));
    balls.add(new Baall(180, 10));
    balls.add(new RedBall(20, 10));
    balls.add(new BlinkingBall(60, 10));
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    for (Baall ball : balls) {
      ball.draw( g );
    }
  }

  public void actionPerformed( ActionEvent e ) {
    for (Baall ball : balls) {
      ball.step();
    }
    repaint();
  }

}

class Baall {
  int radius;

  int x;    // x coordinate center (pixel coordinates)
  int y;    // y coordinate center (pixel coordinates)

  int fallStep;

  Color ballColor;

  Baall() {
    // location extremely top left
    this(0,0);
  }

  Baall( int x, int y ) {
    this.x = x;
    this.y = y;

    radius = 20;
    fallStep = 20;
    ballColor = Color.BLUE;
  }
  boolean goingDown = true;
  // update the ball because a time step has passed
  void step( ) {
    y += fallStep; 
  }

  void draw( Graphics g ) {
    // draw ball
    g.setColor( ballColor );
    g.fillOval( x - radius/2, y - radius/2, radius, radius );
  }

}

class RedBall extends Baall{
    public RedBall(int startX, int startY) {
        super(startX, startY);
    }
    
    @Override
    void draw (Graphics g){
        g.setColor(Color.RED);
        g.fillOval( x - radius/2, y - radius/2, radius, radius );
    }
}
class BlinkingBall extends Baall{
    int phase = 0;
    public BlinkingBall(int startX, int startY) {
        super(startX, startY);
    }
    void changeColor(){
        if (ballColor == Color.BLUE){
            ballColor = Color.RED;
        }
        else if (ballColor == Color.RED){
            ballColor = Color.BLUE;
        }
    }

    @Override
    void step(){
        y += fallStep;
        phase++;
    }

    @Override
    void draw(Graphics g) {
        if (phase%4==0){
            changeColor();
        }
        g.setColor( ballColor );
        g.fillOval( x - radius/2, y - radius/2, radius, radius );
    }
}

class BouncingBall extends Baall{
    int fallStepX = 20;
    public BouncingBall(int x, int y){
        super(x, y);
    }
    @Override
    void step(){
        if (y >330){
            fallStep = -fallStep;
        }
        if (y < 20){
            fallStep = - fallStep;
        }
        if (x < 40){
            fallStepX = -fallStepX;
        }
        if (x > 550){
            fallStepX = -fallStepX;
        }

    }
}