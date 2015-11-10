/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brianobioha
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.text.DecimalFormat;

public class Program extends JFrame {
    
    private JTextField text1 = new JTextField();
    private JTextField text2 = new JTextField();
    private JTextField text3 = new JTextField();
    private JTextField text4 = new JTextField();
    private JTextField text5 = new JTextField();
    private JTextField text6 = new JTextField();
    private JTextField text7 = new JTextField();
    private JTextField text8 = new JTextField();
    
    private Vector<JTextField> texts = new Vector<JTextField>();
    
    private JTextField ans = new JTextField();
    
    private JLabel gradeLabel = new JLabel("Grade %");
    private JLabel weightLabel = new JLabel("Weight");
    private JButton calc = new JButton("Calculate");
    
    
    public void RectangleGridLayout(){
        Container content = this.getContentPane();
        GridLayout layout = new GridLayout(6,2);
        content.setLayout(layout);
        
        content.add(gradeLabel);
        content.add(weightLabel);
        
        content.add(text1);
        texts.add(text1);
        
        content.add(text2);
        texts.add(text2);
        
        content.add(text3);
        texts.add(text3);
        
        content.add(text4);
        texts.add(text4);
        
        content.add(text5);
        texts.add(text5);
        
        content.add(text6);
        texts.add(text6);
        
        content.add(text7);
        texts.add(text7);
        
        content.add(text8);
        texts.add(text8);
        
        content.add(calc);
        content.add(ans);
        
        calc.addActionListener(new CalcButtonHandler());
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    private class CalcButtonHandler implements ActionListener {
        DecimalFormat df = new DecimalFormat("0.00");
        @Override
        public void actionPerformed(ActionEvent e) {
            double sum = 0;
            try{
                for(int i  = 0; i < 4; i++){
                    sum += (Double.parseDouble(((texts.get(2*i)).getText())) * Double.parseDouble((texts.get( i < 1 ? 1 : 2*i + 1 )).getText()));
                }
            }catch(Exception ex){
                ans.setText("N/A");
            }
            ans.setText(df.format(sum) + "%");
        }
    }
   
    public static void main(String [] args){
        Program p = new Program();
        p.setSize(200, 300);
        p.RectangleGridLayout();
        p.setVisible(true);
    }
}
