import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class OlieTanker1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OlieTanker extends Schip
{
    //constructor van de olieTanker
    public OlieTanker(int punten){
        super(punten);       
    }
    //In java zou je normaal hier de act methode kunnen overschrijven van de superclass maar in
    //greenfoot gaat dat niet dus vandaar de OlieTankerAct methode
    //bron: http://www.greenfoot.org/topics/2153
    public void act(){
        c = (ControleCentrumWorld) getWorld();
        s = c.getScoreBord();
        List olietankerLijst = c.getObjects(OlieTanker.class);
        
        if(getY() == 0){
            super.stopGame();
        }
        else if (Greenfoot.mouseClicked(this)){  
            super.playSound();
            super.respawn();
            super.addPuntenToScoreBord(punten);
        }
        else{
            
            if(s.getScore() >= 0 && s.getScore() < 10){
                super.setSpeed(1);
            }
            else if(s.getScore() >= 10 && s.getScore() < 20){
                super.setSpeed(1);
                
                if(olietankerLijst.size() == 2){
                    OlieTanker o = new OlieTanker(1);
                    c.addObject(o, Greenfoot.getRandomNumber(501) + 50, 600);
                }
                
            }
            else if(s.getScore() >= 20 && s.getScore() < 30){
                super.setSpeed(2);
            }
            else if(s.getScore() >= 30 && s.getScore() < 40){
                super.setSpeed(2);
                
                if(olietankerLijst.size() == 3){
                    OlieTanker o = new OlieTanker(1);
                    c.addObject(o, Greenfoot.getRandomNumber(501) + 50, 600);
                }
                
            }
            else if(s.getScore() >= 40){
                super.setSpeed(2);
            }
            else{
                super.setSpeed(1);
            }
            
        }
    }
    
}
