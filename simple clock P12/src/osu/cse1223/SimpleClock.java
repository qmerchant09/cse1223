/**
 * SimpleClock.java
 *
 * A class that implements a simple
 *
 * @author Jeremy Morris
 *
 */
package osu.cse1223;
public class SimpleClock {

    /* -------- Private member variables --------------------- */
    private int hours;
    private int minutes;
    private int seconds;
    private boolean morning;

    /* -------- Constructor --------------------------------- */
    /**
     * The constructor should set the intial value of the clock to 12:00:00AM.
     */
    public SimpleClock() {
        // TODO - code for constructor here.
    	this.hours = 12;
    	this.minutes = 00;
    	this.seconds = 00;
    	this.morning = true;
    }

    /* --------- Instance methods ------------------------- */

    /**
     * Sets the time showing on the clock.
     * 
     * @param hh
     *            - the hours to display
     * @param mm
     *            - the minutes to display
     * @param ss
     *            - the seconds to display
     * @param morning
     *            - true for AM, false for PM
     */
    public void set(int hh, int mm, int ss, boolean morning) {
        // TODO - code for set here
    	this.hours = hh;
    	this.minutes = mm;
    	this.seconds = ss;
    	this.morning = morning;
    }

    /**
     * Advances the clock by 1 second. Make sure when implementing this method
     * that the seconds "roll over" correctly - 11:59:59AM should become
     * 12:00:00PM for example.
     */
    public void tick() {
        // TODO - code for tick here
    	this.seconds = this.seconds + 1;
    	if (this.seconds == 60) {
    		this.seconds = 0;
    		this.minutes = this.minutes + 1;
    		if (this.minutes == 60) {
    			this.minutes = 0;
    			this.hours = this.hours + 1;
    			if(this.hours > 12) {
    				this.hours = 1;
    			}
    			if(this.hours == 12) {
    				this.morning = !this.morning;
    			}
    			}
    		}
    	}
    	

    /**
     * Returns a string containing the current time formatted as a digital clock
     * format. For example, midnight should return the string "12:00:00AM" while
     * one in the morning would return the string "1:00:00AM" and one in the
     * afternoon the string "1:00:00PM".
     *
     * @return - the current time formatted in AM/PM format
     */
    public String time() {
        // TODO - code for time here
    	String sHours = String.format("%02d", this.hours);
    	String sMinutes = String.format("%02d", this.minutes);
    	String sSeconds = String.format("%02d", this.seconds);
    	String morn = "";
    	if (this.morning) {
    		morn = "AM";
    	}else {
    		morn = "PM";
    	} 	
    	String str = sHours + ":" + sMinutes + ":" + sSeconds + " " + morn;
        return str;
    }

}
