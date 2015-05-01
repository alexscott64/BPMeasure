/*
ALGORITHM CLASS FOR BPMeasure
-------------------------------------------------------------------------------------------------------------
To calculate pitch adjustment, we have two variables, variable A (the current track playing, or "first" track)
and variable B (the track we want to mix in or the "second" track).

When A > B (ie. we must mix our next track to a higher BPM)
((A - B) / A) * 100 = percentage we must increase track B by

When B > A (ie. we must mix our next track to a lower BPM)
((A - B) / B) * 100 = percentage we must decrease track B by
 */
public class BPCalculations {
    
    // INSTANCE VARIABLES
    private double trackA; // first track we play (+)
    private double trackB; // second track we play (+)
    private double percentShift; // amount we must shift by (+/-)
    
    // CONSTRUCTOR
    public BPCalculations() {
        trackA = 0.0;
        trackB = 0.0;
        percentShift = 0.0;
    }
    
    // MUTATORS
    // sets first track
    public void setTrackA(double a) {
        if(isValidTrack(a) == true) {
            trackA = a;
        } else {
            trackA = 0.0; // default value, will display message in GUI later on
        }
    }
    
    // sets second track
    public void setTrackB(double b) {
        if(isValidTrack(b) == true) {
            trackB = b;
        } else {
            trackB = 0.0; // default value, display message in GUI later on
        }
    }
    
    // ACCESSORS
    public double getTrackA() {
        return trackA;
    }
    
    public double getTrackB() {
        return trackB;
    }
    
    // ALGORITHM
    // A > B, the percentage we INCREASE track B by
    // ((A - B) / A) * 100
    public double percentageIncrease() {
        percentShift = ((trackA - trackB) / trackA) * 100;
        return percentShift;
    }
    
    // A < B, percentage we DECREASE track B by
    // ((A - B) / B) * 100
    public double percentageDecrease() {
        percentShift = ((trackA - trackB) / trackB) * 100;
        return percentShift;
    }
    
    // determine what algorithm to use
    public double finalPercentage() {
        if(trackA > trackB) {
            return percentageIncrease();
        } else {
            return percentageDecrease();
        }
    }
    
    // OTHER METHODS
    // checks if the BPM is valid (no negative BPMs, BPM's 0-200)
    public boolean isValidTrack(double track) {
        if(track >= 0.0 && track <= 200.0) {
            return true;
        } else {
            return false;
        }
    }
    
}