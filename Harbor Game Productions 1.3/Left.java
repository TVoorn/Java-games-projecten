import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Left here.
 * 
 * @author Johnny van Velthoven
 * @version 15-01-2014
 */
public class Left extends Drive
{
    private int richting = 4; //Righting bepalen
    //Constructor voor Left
    public Left(){
    
    }
    
    /**
     * Kijken of er geklikt word op Left in de act methode
     */
    public void act() 
    {
           if (Greenfoot.mouseClicked(this)) {  
                Greenfoot.playSound("click.mp3");
                setImage("leftclicked.png"); //Plaatje veranderen
                AutonoomWorld a = (AutonoomWorld) getWorld();  //Een referetie naar de wereld maken
                List l = a.getList(); //List ophalen
                l.addToList(richting); //Righting toevoegen aan list
                Greenfoot.delay(20); //Even wachten 
                setImage("left.png"); //Plaatje weer terug veranderen
           }
    }
}
