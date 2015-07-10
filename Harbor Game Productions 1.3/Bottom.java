import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bottom.
 * 
 * @author Johnny van Velthoven
 * @version 15-01-2014
 */
public class Bottom extends Drive
{
    private int richting = 1; //Righting bepalen
    //Constructor voor Bottom
    public Bottom(){
    
    }
    
    /**
     * Kijken of er geklikt word op Bottom in de act methode
     */
    public void act() 
    {
           if (Greenfoot.mouseClicked(this)) {  
                Greenfoot.playSound("click.mp3");
                setImage("bottomclicked.png"); //Plaatje veranderen
                AutonoomWorld a = (AutonoomWorld) getWorld();  //Een referetie naar de wereld maken
                List l = a.getList(); //List ophalen
                l.addToList(richting);  //Righting toevoegen aan list
                Greenfoot.delay(20); //Even wachten 
                setImage("bottom.png"); //Plaatje weer terug veranderen
           }
    }
}
