import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor{
    private int startingTime;
    private int seconds = 180;
    private int clockType = 0;
    private long lastCurrentSecond;
    private long timeSaved = 0;
    private boolean timeUp = false;
    private boolean count = false;
    private boolean displayTime;
    private boolean countDown;
    private String text;
    private AutonoomWorld aw;
    private AutonoomAuto aa;
    
    public Timer(boolean countDown, boolean displayTime, int startingTime, String text) {
        this.countDown = countDown;
        this.displayTime = displayTime;
        this.startingTime = startingTime;
        this.text = text;
   
        seconds = startingTime;
        getImage().clear();
        if (!countDown) {
            seconds = 0;
        }
        if (displayTime) {
            getImage().scale(60, 60);
        }
        this.startClock();
    }
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (countDown) {
            if (count && !timeUp) {
                if (System.currentTimeMillis() - lastCurrentSecond >= 1000) {
                    lastCurrentSecond += 1000;
                    seconds--;
                    if (displayTime) {
                        drawTime();
                    }
                }
                if (seconds == 0) {
                    youLose();
           
                    timeUp = true;
                }
            }
        }
        else {
            if (count) {
                if (System.currentTimeMillis() - lastCurrentSecond >= 1000) {
                    lastCurrentSecond += 1000;
                    seconds++;
                    if (displayTime) {
                        drawTime();
                    }
                }
            }
        }
    }    
        
    /**
     * Alle objecten uit de wereld verwijderen
       Een bericht aan de gebruiker laten zien
       Kijken welk level hij nu moet gaan laden    
     */
    private void youLose() {
        aw = (AutonoomWorld) getWorld(); 
        aa = aw.getAutonoomAuto();
        aa.stopGame();
        //aw.removeObjects(getWorld()
        //aw.removeObject(aw).getObjects(null);  
            /*AutonoomWorld a = (AutonoomWorld) getWorld(); 
            a.removeObjects(getWorld().getObjects(null));  
            Object[] options = {"OK"};
            int n = JOptionPane.showOptionDialog(new JInternalFrame(),
                "Je hebt verloren probeer het opnieuw!","Game information",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);*//*
            if(aw.lvlgehaald()==0){
                aw.loadlvl1();
            }else if(aw.lvlgehaald()==1){
                aw.loadlvl2();
            }else if(aw.lvlgehaald()==2){
                aw.loadlvl3();
            }*/
    }
   
    
    /**
     * The drawing method of the clock.
     * This method draws the current value of your clock onto the clock object.
     */
    private void drawTime() {
        int min = (int) (seconds / 60);
        int sec = seconds % 60;
        String remainingTime;
        if (sec < 10) {
            remainingTime = min + ":0" + sec;
        }
        else {
            remainingTime = min + ":" + sec;
        }
        getImage().setColor(Color.gray);
        getImage().fill();
        GreenfootImage text = new GreenfootImage((this.text == null ? "" : this.text), 30, Color.black, new Color(0, 0, 0, 0));
        GreenfootImage time = new GreenfootImage(remainingTime, 40, Color.black, new Color(0, 0, 0, 0));
        if (text.getWidth() > getImage().getWidth()) {
            getImage().clear();
            getImage().scale(text.getWidth() + 10, 60);
            getImage().setColor(Color.gray);
            getImage().fill();
        }
        getImage().drawImage(text, (getImage().getWidth()/2)-(text.getWidth()/2), 5);
        getImage().drawImage(time, (getImage().getWidth()/2)-(time.getWidth()/2), (this.text == null ? (getImage().getHeight()/2)-(time.getHeight()/2) : 30));
    }
    
    /**
     * Check whether the time is up.
     * 
     * @return
     *      Returns true if the time is up. If the clock is no countdown clock the method will return false.
     */
    public boolean timeUp() {
        return timeUp;
    }
    
    /**
     * Start the clock.
     */
    public void startClock() {
        lastCurrentSecond = System.currentTimeMillis() - timeSaved;
        count = true;
    }
    /**
     * Pause the clock.
     */
    public void stopClock() {
        timeSaved = System.currentTimeMillis() - lastCurrentSecond;
        count = false;
    }
    /**
     * Reset the clock.
     */
    public void resetClock() {
        seconds = startingTime;
        timeUp = false;
    }
}
