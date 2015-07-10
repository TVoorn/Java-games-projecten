import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class ContainerSchip1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContainerSchip extends Schip
{
    //constructor
    public ContainerSchip(int punten){
        super(punten);  
    }
    
    
    public void act() 
    {
        c = (ControleCentrumWorld) getWorld();
        s = c.getScoreBord();
        List containerschipLijst = c.getObjects(ContainerSchip.class);
        
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
                super.setSpeed(2);
            }
            else if(s.getScore() >= 20 && s.getScore() < 30){
                super.setSpeed(2);
                
                if(containerschipLijst.size() == 1){
                    ContainerSchip co = new ContainerSchip(1);
                    c.addObject(co, Greenfoot.getRandomNumber(501) + 50, 600);    
                }
                
            }
            else if(s.getScore() >= 30 && s.getScore() < 40){
                super.setSpeed(2);
            }
            else if(s.getScore() >= 40){
                super.setSpeed(3);
                
                if(containerschipLijst.size() == 2){
                    ContainerSchip co1 = new ContainerSchip(1);
                    c.addObject(co1, Greenfoot.getRandomNumber(501) + 50, 600);
                }
                
            }
            else{
                super.setSpeed(1);
            }
        }
    }
}
