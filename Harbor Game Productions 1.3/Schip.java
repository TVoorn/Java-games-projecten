import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Schip here.
 * 
 * @author Igor Ivanisevic-Mustapic 
 * @version 07-01-2014
 */
public class Schip extends Actor
{
    public int punten = 0; 
    public ScoreBord s;
    public ControleCentrumWorld c;
    
    //consturctor van de schip
    public Schip(int punten){
        this.punten = punten; 
    }
    
    //act methode
    public void act(){
        
    }
    
    //setSpeed moethode zodat je de snelheid kan instellen
    public void setSpeed(int x){
        setLocation(getX(), getY() - x);
    }
     
    //respawn methode zodat het schip opnieuw geplaats wordt op het speeldveld
    public void respawn(){
        //setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), 650);
        setLocation(Greenfoot.getRandomNumber(501) + 50, 600);
    }
    
    //addPuntenToScoreBord methode zodat de punten op worden geteld
    public void addPuntenToScoreBord(int x){
        c = (ControleCentrumWorld) getWorld();
        s = c.getScoreBord();
        s.addToScore(x);
    }
    
    public void stopGame(){
        
        c.addObject(new Explosion(), getX(), getY() + 100);
        Greenfoot.playSound("explosie.mp3");
        Greenfoot.delay(50);
        c.addObject(new Bericht(5), 300, 300);
        
        
        List x = c.getObjects(ContainerSchip.class);
        List y = c.getObjects(OlieTanker.class);
        List z = c.getObjects(PolitieSchip.class);
        
        c.removeObjects(x);
        c.removeObjects(y);
        c.removeObjects(z);
        
        
        
    }
    
    public void playSound(){
        Greenfoot.playSound("click.mp3");
    }
    
}
