import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import java.util.List;
/**
 * Write a description of class AutonoomAuto here.
 * 
 * @author Johnny van Velthoven
 * @version 15-01-2014
 */
public class AutonoomAuto extends Actor
{
    private AutonoomWorld a;
    //Constructor voor de AutonoomAuto
    public AutonoomAuto(){
        
    }

    /**
     * In de act word er gekeken of de auto een container, 
     * de lading, de carcrash of het menu heeft gevonden
     * Als die een van de dingen vind gaat die iets uitvoeren
     */
    public void act(){
        a = (AutonoomWorld) getWorld();
        
        if(foundContainer()){
            stopGame(); 
        }
        else if(foundLading()){
            AutonoomWorld a = (AutonoomWorld) getWorld(); 
            Greenfoot.playSound("victory.mp3"); 
            Greenfoot.delay(25);  
            a.removeObjects(getWorld().getObjects(null)); 
            a.lvlplus(); 
            //Kijken welk level hij nu moet gaan laden 
            if(a.lvlgehaald()==1){
                a.loadlvl2();
            }
            else if(a.lvlgehaald()==2){
                a.loadlvl3();
            }
            else{
                a.lvlreset();
                a.addObject(new Bericht(7), 5, 5);
                Greenfoot.playSound("victory.mp3"); 
                Greenfoot.delay(25);  
            }
            
        }
        else if(foundMenu()){
            stopGame();
        }
        else if(foundCarcrash()){
            //AutonoomWorld a = (AutonoomWorld) getWorld();
            AutonoomAuto c = a.getAutonoomAuto(); 
            int b = Greenfoot.getRandomNumber(2);
            if(b==1){
                c.setLocation(getX(),getY());
                Greenfoot.delay(25);
                c.setLocation(getX()+1,getY());
                Greenfoot.delay(25);
            }
            else{
                c.setLocation(getX(),getY());
                Greenfoot.delay(25);
            }
        }
    }   
    
    public boolean foundCarcrash(){
        //Kijken of de auto op een carcrash staat
        Actor c = getOneObjectAtOffset(0, 0, Carcrash.class); //Referentie maken
        if(c != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean foundContainer(){
        //Kijken of de auto op een container staat
        Actor cont = getOneObjectAtOffset(0, 0, Container.class); //Referentie maken
        if(cont != null) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean foundLading()
    {
        //Kijken of de auto op de lading staat
        Actor lad = getOneObjectAtOffset(0, 0, Lading.class); //Referentie maken
        if(lad != null) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean foundMenu()
    {
        //Kijken of de auto op het menu staat
        Actor lad = getOneObjectAtOffset(0, 0, Menu.class); //Referentie maken
        if(lad != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void stopGame(){
        a.addObject(new Explosion(), getX(),getY()); 
        Greenfoot.playSound("explosie.mp3"); 
        Greenfoot.delay(25); 
        a.removeObjects(getWorld().getObjects(null));  //Alle objecten uit de wereld verwijderen
        a.addObject(new Bericht(5), 5, 5);
    }
}
