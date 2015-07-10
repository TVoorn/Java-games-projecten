import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
/**
 * Write a description of class List here.
 * 
 * @author Johnny van Velthoven
 * @version 15-01-2014
 */
public class List extends Actor
{
    ArrayList<Integer> list = new ArrayList<Integer>();  
    public void list(ArrayList<Integer> list){
        this.list = list;
    }
    //Act methode
    public void act() 
    {
    }    
    //toevoegen aan de lijst methode
    public void addToList(int x){  
      list.add(x);
    }
    //movecar methode  
    public void movecar(){
        getlist();
        AutonoomWorld a = (AutonoomWorld) getWorld(); // get a reference to the world
        AutonoomAuto c = a.getAutonoomAuto();  // get a reference to the drive
        
        for (int i = 0; i <  list.size(); i++) {
            if(list.get(i)==1){
                //bottom
                if(!c.foundContainer()&& !c.foundLading()){
                    c.setImage("autobottom.png");
                    c.setLocation(c.getX(),c.getY()+1);
                    Greenfoot.delay(20); 
                }
            }else if(list.get(i)==2){
                //right
                if(!c.foundContainer() && !c.foundLading()){
                    c.setImage("autoright.png");
                    c.setLocation(c.getX()+1,c.getY());
                    Greenfoot.delay(20); 
                }
            }
            else if(list.get(i)==3){
                //top
                if(!c.foundContainer()&& !c.foundLading()){   
                    c.setImage("autotop.png");
                    c.setLocation(c.getX(),c.getY()-1);
                    Greenfoot.delay(20); 
                }
            }else{
                //left
                if(!c.foundContainer() && !c.foundLading()){
                    c.setImage("autoleft.png");
                    c.setLocation(c.getX()-1,c.getY());
                    Greenfoot.delay(20); 
                }
            }
        }
    }

    public ArrayList<Integer> getlist(){
        return list;
    }
    
}
