import greenfoot.*;
import java.awt.Color;

/**
 * MenuWorld class.
 * 
 * @author Igor Ivanisevic-Mustapic
 * @version 07-01-2014
 */
public class MenuWorld extends World implements ButtonController
{
    private int tellerEnter;
    
    //Constructor van MenuWorld
    public MenuWorld(){
        super(12, 12, 50);
        //getBackground().setColor(Color.GREEN);
        //getBackground().fill();
        
        //knop toevoegen aan de wereld
        //addObject(new Button("Controle centrum", this), 300, 300);
        //addObject(new Button("Test world", this), 400, 500);      
        
        addObject(new Button("Controle centrum", this), 2, 1);
        addObject(new Button("Autonome auto's", this), 9, 1);
        addObject(new Button("Douane hal", this), 2, 10);
        addObject(new Button("Tower Defense", this), 9, 10);

        addObject(new Player(), 5, 6);
        
        addObject(new Bericht(6), 5 ,6);        
    }
    
    public void act(){
        /*GreenfootSound s = new GreenfootSound("Burning Spear - Walk.mp3");
        
        if(Greenfoot.isKeyDown("p")){
            s.play();
        }
        else if(Greenfoot.isKeyDown("s")){
            System.out.println("stop the music.....");
            s.stop();
        } */
    }
    
    //Zodra er op de button gedrukt is gaat de button een nieuwe wereld openen
    public void buttonPressed(Button button)
    {
        if ("Controle centrum".equals(button.getTitle()) ) {
            World controleCentrumWorld = new ControleCentrumWorld(this);
            Greenfoot.setWorld(controleCentrumWorld);
        }
        else if("Autonome auto's".equals(button.getTitle())){
            World autonome = new AutonoomWorld(this);
            Greenfoot.setWorld(autonome);
        }
        else if("Douane hal".equals(button.getTitle())){
            World douaneHal = new DouaneHal(this);
            Greenfoot.setWorld(douaneHal);
        }
        else if("Tower Defense".equals(button.getTitle())){
            Greenfoot.setWorld(new WorldMenu());
        }
    }
    
}