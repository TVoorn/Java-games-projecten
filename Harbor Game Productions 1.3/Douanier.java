import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Douane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Douanier extends Actor{
    /**
     * Act - do whatever the Douane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        movePlayer();
    } 
    
    public void movePlayer()
    {
        if(Greenfoot.isKeyDown("up")){
            //setImage(link-stand-up.ong);
            //direction = "up";
            setLocation(getX(), getY() - 7);
        }
        if(Greenfoot.isKeyDown("down")){
            //setImage(link-stand.png);
            //direction = "down";
            setLocation(getX(), getY() + 7);
        }
    }

}
   
  
  
