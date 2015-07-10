import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Drive here.
 * 
 * @author Johnny van Velthoven
 * @version 15-01-2014
 */
public class Drive extends Actor
{
    //Constructor voor de Drive
    public Drive(){
    }
   
    /**
     * Kijken of er geklikt word op de Drive knop in de act methode
     * Methode clicked uitvoeren als er geklikt word
     */
    public void act() 
    {
       if (Greenfoot.mouseClicked(this)) {  
            clicked(); 
       }
    }     
 
    public void clicked(){     
        AutonoomWorld a = (AutonoomWorld) getWorld(); 
        List l = a.getList(); //List ophalen 
        l.movecar(); //Methode movecar van List uitvoeren 
    }
}
