
/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * main class
 * @author Tom Sijbers
 * @id 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 14/10/21
 * assignment copyright Kees Huizing
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PrisonersDilemma extends JFrame implements ActionListener{
    private JButton goButton;
    private JButton pauseButton;
    private JButton resetButton;
    private PlayingField field;
    private JSlider alphaSlider;
    private JSlider frequencySlider;
    private JLabel alphaLabel;
    private JLabel frequencyLabel;
    private JPanel panel;
    private int frequencyValue;
    private double alphaValue;

    
    void buildGUI() {
        SwingUtilities.invokeLater( () -> {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Prisoner's Dilemma");
            setLayout(null);
            
            //set up JPanel
            field = new PlayingField();
            field.setBounds(50, 20, 501, 501);
            add(field);
            
            //set up JPanel for buttons and sliders
            panel = new JPanel();
            panel.setLayout(null);
            //panel.setBackground(Color.GRAY);
            panel.setBounds(0, 350, 600, 350);
            add(panel);


            //set up go button
            goButton = new JButton("Go");
            goButton.setBounds(60, 275, 80, 50);
            goButton.setFocusable(false);
            goButton.addActionListener(field);
            goButton.setBackground(Color.WHITE);
            panel.add(goButton);

            //set up pause button
            pauseButton = new JButton("Pause");
            pauseButton.setBounds(260, 275, 80, 50);
            pauseButton.setFocusable(false);
            pauseButton.addActionListener(field);
            pauseButton.setBackground(Color.WHITE);
            panel.add(pauseButton);

            //set up reset button
            resetButton = new JButton("Reset");
            resetButton.setBounds(460, 275, 80, 50);
            resetButton.setFocusable(false);
            //resetButton.addActionListener(field);
            resetButton.addActionListener(this);
            resetButton.setBackground(Color.WHITE);
            panel.add(resetButton);

            //set up alpha slider
            alphaSlider = new JSlider(JSlider.HORIZONTAL, 0,30,10);
            alphaSlider.setMajorTickSpacing(10);
            alphaSlider.setPaintTicks(true);
            alphaSlider.setPaintLabels(true);
            alphaSlider.setBounds(100, 175, 150, 50);
            Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
            table.put(0, new JLabel("0.0"));
            table.put(10, new JLabel("1.0"));
            table.put(20, new JLabel("2.0"));
            table.put(30, new JLabel("3.0"));
            alphaSlider.setLabelTable(table);
            alphaSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider source = (JSlider) e.getSource();
                    alphaValue = source.getValue()/10.0;
                    field.setAlpha(alphaValue);
                }     
            });
            panel.add(alphaSlider);

            //set label for alpha slider
            alphaLabel = new JLabel();
            alphaLabel.setText("Defection α:");
            alphaLabel.setBounds(10, 175, 70, 50);
            panel.add(alphaLabel);

            //set up frequency slider
            frequencySlider = new JSlider(JSlider.HORIZONTAL, 0, 60, 10);
            frequencySlider.setMajorTickSpacing(10);
            frequencySlider.setPaintTicks(true);
            frequencySlider.setPaintLabels(true);
            frequencySlider.setBounds(400, 175, 150, 50);
            frequencySlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider source = (JSlider) e.getSource();
                    //frequencyValue is set equal to the slider value
                    frequencyValue = source.getValue();
                    //frequency setter sets the variable frequency in the class PlayingField equal to the frequancy slider value
                    field.setFrequency(frequencyValue);
                }
                
            });
            panel.add(frequencySlider);

            //set up frequency label
            frequencyLabel = new JLabel();
            frequencyLabel.setText("frequency:");
            frequencyLabel.setBounds(330, 175, 70, 50);
            panel.add(frequencyLabel);


            //more JFrame setup
            setResizable(false);
            setSize(600, 750);
            setVisible(true);
        } );
    }
    
    public void setPlayingField(PlayingField field){

    }
    public PlayingField getPlayingField(){
        return this.field;
    }
    
    public static void main( String[] a ) {
        (new PrisonersDilemma()).buildGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton){
            remove(field);
            field = new PlayingField();
            field.setBounds(50, 20, 501, 501);
            add(field);
            repaint();
        }
    }
}