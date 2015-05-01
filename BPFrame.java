// GUI for BPMeasure
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat; // to format our numbers
public class BPFrame implements ActionListener {
    // INSTANCE VARIABLES
    private JLabel jlabInstruction; // instructions label
    private JPanel gridPanel; // holds our user input components
    private JLabel jlabBpmCurrent; // current bpm label
    private JTextField jtxtBpmCurrent; // current bpm user input
    private JLabel jlabBpmNext; // next bpm label
    private JTextField jtxtBpmNext; // next bpm user input
    private JButton jbtnConvert; // converts to percentage adjustment
    private JTextField jtxtConvert; // displays the percentage adjustment
    BPCalculations calculate = new BPCalculations(); // holds all the algorithm information
    DecimalFormat df = new DecimalFormat("0.##"); // formats our decimal to two places
    
    // CONSTRUCTOR
    public BPFrame() {
        JFrame jfrm = new JFrame("BPMeasure");
        jfrm.setLayout(new FlowLayout()); // sets flow layout
        jfrm.setSize(500, 500); // sets size
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // instructions
        jlabInstruction = new JLabel("<html>Enter the BPM of the song you are currently mixing and the BPM of <br />" +
                                    "the song you would like to mix into, then hit convert. The percentage <br />" +
                                     "you see is the pitch adjustment needed to beatmatch the two tracks. <br /></html>");
        jfrm.add(jlabInstruction);
        // grid layout with user input
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3,2)); // 3 rows, 2 columns
        
        // first row (current bpm)
        jlabBpmCurrent = new JLabel("Enter current track BPM: ");
        jtxtBpmCurrent = new JTextField(1);
        gridPanel.add(jlabBpmCurrent);
        gridPanel.add(jtxtBpmCurrent);
        
        // second row (next tracks bpm)
        jlabBpmNext = new JLabel("Enter the next track's BPM: ");
        jtxtBpmNext = new JTextField(1);
        gridPanel.add(jlabBpmNext);
        gridPanel.add(jtxtBpmNext);
        
        // third row (convert row)
        jbtnConvert = new JButton("Convert");
        jbtnConvert.addActionListener(this); // for actionPerformed
        jtxtConvert = new JTextField(1);
        jtxtConvert.setEditable(false); // user can not edit result
        gridPanel.add(jbtnConvert);
        gridPanel.add(jtxtConvert);
        
        // end and add panel to jframe
        jfrm.add(gridPanel);
        jfrm.getRootPane().setDefaultButton(jbtnConvert); // if user hits enter, convert by default
        
        
        jfrm.setVisible(true);
    }
    
    // action performed, if it equals the button clicked, we will display the correct bpm
    public void actionPerformed(ActionEvent e) {
        double currentBpm = Double.parseDouble(jtxtBpmCurrent.getText());
        double nextBpm = Double.parseDouble(jtxtBpmNext.getText());
        // set the tracks to use in BPCalculations
        calculate.setTrackA(currentBpm);
        calculate.setTrackB(nextBpm);
        // checks to see if user hits convert, if so, convert to percentage
        if(e.getActionCommand().equals("Convert")) {
            jtxtConvert.setText("" + df.format(calculate.finalPercentage()) + "%");
        }
    }
    
}