import greenfoot.*;
import java.awt.Color;
/**
 * An object you can click on, and something will happen...
 * 
 * @author Sven van Nigtevecht
 * @version 1.0
 */
public class Button extends Actor
{
    private String title;
    private ButtonController world;
    
    /**
     * Constructor for objects of the class Button
     */
    public Button(String title, ButtonController world)
    {
        this.title = title;
        putTextOnImage();
        this.world = world;
    }
    
    private void putTextOnImage()
    {
        GreenfootImage backgroundImage = new GreenfootImage(getImage());
        GreenfootImage text = new GreenfootImage(title, 22, Color.BLACK, new Color(0,0,0,0));
        
        if (text.getWidth() > backgroundImage.getWidth() - 20) {
            backgroundImage.scale(text.getWidth() + 20, backgroundImage.getHeight());
        }
        
        int x = (backgroundImage.getWidth() -text.getWidth() ) /2;
        int y = (backgroundImage.getHeight() -text.getHeight() ) /2;
        backgroundImage.drawImage(text, x, y);
        setImage(backgroundImage);
    }
    
    /**
     * Check for clicks on the button.
     */
    public void act() 
    {
        if(isPlayerOnButton()){
            if(Greenfoot.isKeyDown("p")){
                world.buttonPressed(this);                
            }
        }
        
        if(Greenfoot.mouseClicked(this)) {
            world.buttonPressed(this);
        }
        
    }
    
    /**
     * Returns the title of the button.
     */
    public String getTitle()
    {
        return title;
    }
    
    
    
    //checken of dat de player op de knop staat 
    public boolean isPlayerOnButton(){
        Actor player = getOneObjectAtOffset(0, 0, Player.class);
        if(player != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    
    
}