import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.awt.image.*;

public class ActorButton extends Actor {
    
    public IAction action;
    private boolean dissapearOnFocusLost;
    private String[] description;
    
    public ActorButton(String description, IAction action) {
        this((new String[]{description}), action);
    }
    
    public ActorButton(String[] description, IAction action) {
        this.action = action;
        getImage().setFont(new Font("Times New Roman", Font.PLAIN, 12));
        for(int i = 0; i < description.length; i++) {
            getImage().drawString(description[i], 10, 12*i+16);
        }
        this.description = description;
    }
    
    public void act() {
        greenfoot.MouseInfo mouse = Greenfoot.getMouseInfo();
        if(getWorld() != null && Greenfoot.mousePressed(this) && mouse != null && mouse.getClickCount() == 0) {
            action.performAction(this);
        } else if(mouse != null && dissapearOnFocusLost && (mouse.getX() < getX()-64 || mouse.getX() > getX()+64 || mouse.getY() < getY()-64 || mouse.getY() > getY()+64)) {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Set to true if this button should dissapear when the mouse is moved away
     * @param flag
     */
    public void dissapearOnFocusLost(boolean flag) {
        dissapearOnFocusLost = flag;
    }
    
    @Override
    public void setImage(String fileName) {
        super.setImage(fileName);
        getImage().setFont(new Font("Times New Roman", Font.PLAIN, 12));
        for(int i = 0; i < description.length; i++) {
            getImage().drawString(description[i], 10, 12*i+16);
        }
    }
}
