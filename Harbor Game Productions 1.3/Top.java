import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Top here.
 * 
 * @author Johnny van Velthoven
 * @version 15-01-2014
 */
public class Top extends Drive
{
    private int richting = 3; //Righting bepalen
    //Constructor voor Top
    public Top(){
    
    }
    
    /**
     * Kijken of er geklikt word op Top in de act methode
     */
    public void act() 
    {
           if (Greenfoot.mouseClicked(this)) { 
                Greenfoot.playSound("click.mp3");
                setImage("topclicked.png"); //Plaatje veranderen
                AutonoomWorld a = (AutonoomWorld) getWorld();  //Een referetie naar de wereld maken
                List l = a.getList(); //List ophalen
                l.addToList(richting); //Righting toevoegen aan list
                Greenfoot.delay(20); //Even wachten 
                setImage("top.png"); //Plaatje weer terug veranderen
           }
    }
}
