/*
 Author: Alex Scott
 Title: BPMeasure
 -------------------
 This is an application for DJ's to use when mixing two tracks together.
 To get the percentage adjustment for the track you want to mix into, enter the BPM for the current song playing
 and the next song you would like to play. The percentage increase tells you how much to adjust the pitch slider on
 almost all normal CDJ's.
 */
// main
import javax.swing.*;
public class BPMeasure {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BPFrame test = new BPFrame();
            }
        });
    } 
}