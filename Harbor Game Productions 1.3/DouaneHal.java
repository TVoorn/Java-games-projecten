import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
/**
 * Write a description of class DouaneHal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DouaneHal extends World implements ButtonController
{
    private ScoreBord scoreBord;
    private World firstWorld;
    private int tellerEnter;
    private int tellerBackspace;
    
    /**
     * Constructor for objects of class DouaneHal.
     * 
     */
    public DouaneHal(World firstWorld){
        super(800, 400, 1);
        this.firstWorld = firstWorld;
        
        addObject(new Bericht(3), 400, 200);
    } 
 
    
    public void act(){
        if(Greenfoot.isKeyDown("enter") && tellerEnter == 0){
            this.removeObjects(this.getObjects(null));
            
            speelVeld();
            scoreBord = new ScoreBord();
            addObject(scoreBord,27,10);
            tellerEnter++;
        }
        else if(Greenfoot.isKeyDown("backspace") && tellerBackspace == 0){
            Greenfoot.setWorld(firstWorld);
            tellerBackspace++;
        }
    }
   
    public void speelVeld()
    {
        addObject(new Controlelijn(), 178, 204);
        addObject(new XrayLijnBegin(), 499,200);
        addObject(new XrayLijnEind(), 422,200);
        addObject(new Rollenband(), 500, 64);
        addObject(new Rollenband(), 500, 200);
        addObject(new Rollenband(), 500, 335);
        addObject(new Douanier(), 190, 200);
               //
        addObject(new Krat(), 550,65);
        addObject(new Krat(), 700,200);
        addObject(new Krat(), 1300,335);
        //addObject(new XrayLijn(), 499,200);
    }
    
    public ScoreBord getScoreBord(){
        return scoreBord;
    } 
    
    public void buttonPressed(Button button){
        if("Back".equals(button.getTitle())){
            Greenfoot.setWorld(firstWorld);
        }
    }
}
