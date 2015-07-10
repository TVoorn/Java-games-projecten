import greenfoot.*;
import java.awt.Color;
/**
 * ControleCentrumWorld.
 * 
 * @author Igor Ivanisevic-Mustapic
 * @version 1.0
 */
public class ControleCentrumWorld extends World implements ButtonController
{
    private World firstWorld;
    private ScoreBord scoreBord;
    private ControleCentrumWorld c;
    private int tellerEnter;
    private int tellerBackspace;
    
    /**
     * Constructor voor ControleCentrumWorld
     */
    public ControleCentrumWorld(World firstWorld){
        super(700, 600, 1);
        this.firstWorld = firstWorld;
        
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        
        addObject(new Bericht(1), 300, 300);
    }
    
    /**
     * Methode act
     * Als er enter wordt gedruk en de tellerEnter is 0 dan start het spel
     * Anders als er backspace wordt gedrukt en de tellerBackspace is 0 dan ga je naar het menu 
     */
    public void act(){
        if(Greenfoot.isKeyDown("enter") && tellerEnter == 0){
            //System.out.println("teller : " + tellerEnter);
            //c = (ControleCentrumWorld) getWorld();
            //c.removeObjects(getObjects(null));
            this.removeObjects(this.getObjects(null));
            Water w = new Water();
            addObject(w, 300, 300);
        
            vulSchepen();
        
            scoreBord = new ScoreBord();
            addObject(scoreBord, 650, 100);
            
            //addObject(new Button("Back", this), 700, 200);
            tellerEnter++;
        }
        else if(Greenfoot.isKeyDown("backspace") && tellerBackspace == 0){
            //System.out.println("teller 1 : " + tellerBackspace);
            Greenfoot.setWorld(firstWorld);
            tellerBackspace++;
        }
    }
    
    /**
     * Methode buttonPressed van de interface ButtonController
     * Als er op de back knop wordt gedrukt dan ga je naar het menu
     */
    public void buttonPressed(Button button){
        if("Back".equals(button.getTitle())){        
            Greenfoot.setWorld(firstWorld);
        }
    }
    
    /**
     * Methode getScoreBord
     * Return scoreBord
     */
    public ScoreBord getScoreBord(){
        return scoreBord;
    }
    
    /**
     * Methode vulSchepen
     * Er worden 3 soorten scheppen toegevoegd aan de wereld
     */
    public void vulSchepen(){
        Schip c = new ContainerSchip(2);
        addObject(c, Greenfoot.getRandomNumber(598), 650);
    
        Schip o = new OlieTanker(1);
        addObject(o, Greenfoot.getRandomNumber(598), 650);
        
        Schip o1 = new OlieTanker(1);
        addObject(o1, Greenfoot.getRandomNumber(598), 650);
        
        Schip p = new PolitieSchip(-2);
        addObject(p, Greenfoot.getRandomNumber(598), 650);
    }
    
}