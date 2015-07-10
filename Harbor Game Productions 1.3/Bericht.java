import greenfoot.*;
/**
 * Write a description of class Bericht here.
 * 
 * @author HarborGameProductions  
 * @version 1.0
 */
public class Bericht extends Actor{
    
    private int id;
    private GreenfootImage img;
    
    public Bericht(int id){
        this.id = id;
        showBericht(id);
    }
    
    public void showBericht(int id){        
        if(id == 1){
            img = new GreenfootImage("wolk1.png");
        }
        else if(id == 2){
            img = new GreenfootImage("wolk2.png");
        }
        else if(id == 3){
            img = new GreenfootImage("wolk3.png");
        }
        else if(id == 4){
            System.out.println("geen afbeelding");
        }
        else if(id == 5){
            img = new GreenfootImage("wolkgameover.png");
            Greenfoot.playSound("gameover.mp3");
        }
        else if(id == 6){
            img = new GreenfootImage("wolkstart.png");
        }
        else if(id == 7){
            img = new GreenfootImage("wolkwin.png");
        }
        setImage(img);
        
    }   
    
}
