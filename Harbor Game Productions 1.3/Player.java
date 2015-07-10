import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author Igor Ivanisevic-Mustapic 
 * @version 20-12-2013
 */
public class Player extends Actor
{
    private GreenfootImage playerRight;
    private GreenfootImage playerLeft;
    private int tellerEnter;
    private World world;
    
    //constructor van de player
    public Player(){
        playerRight  = getImage();
        playerLeft = new GreenfootImage(getImage());
        playerLeft.mirrorHorizontally();
    }

    //act methode
    public void act(){
        movePlayer();
        
        Actor bericht = getOneObjectAtOffset(0, 0, Bericht.class);
        
        if(Greenfoot.isKeyDown("enter") && tellerEnter == 0){
            world = getWorld();
            world.removeObject(bericht);            
        }
    } 
    
    //methode zodat de player kan bewegen
    public void movePlayer(){ 
        int x = getX();
        int y = getY();
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - 1);
            setImage(playerLeft);
            setRotation(90);
            Greenfoot.delay(10);
        }
        else if(Greenfoot.isKeyDown("right")){
            setLocation(getX() + 1, getY());
            setImage(playerRight);
            setRotation(0);
            Greenfoot.delay(10);
        }
        else if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY() + 1);
            setImage(playerRight);
            setRotation(90);
            Greenfoot.delay(10);
        }
        else if(Greenfoot.isKeyDown("left")){
            setLocation(getX() - 1, getY());
            setImage(playerLeft);
            setRotation(0);
            Greenfoot.delay(10);
        }
    }
 
}
