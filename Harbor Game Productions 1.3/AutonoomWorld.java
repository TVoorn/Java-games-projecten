import greenfoot.*;
import java.awt.Color;
/**
 * AutonoomWorld.
 * 
 * @author Johnny van Velthoven
 * @version 15-01-2014
 */
public class AutonoomWorld extends World implements ButtonController
{
    private Drive theDrive;
    private AutonoomAuto theAutonoomAuto;
    private List theList;
    private int lvlgehaald;
    private World firstWorld;
    private int tellerEnter;
    private int tellerBackspace;
    
    /**
     * Constructor for objects of class AutonoomWorld.
     * 
     */
    public AutonoomWorld(World firstWorld){    
        super(10, 10, 60); 
        this.firstWorld = firstWorld;
        
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        
        addObject(new Bericht(2), 5, 5);
        /*
        plaatsmenu();
        plaatslijst();
        plaatscontainers();
        plaatsauto();
        plaatsbesturing();
        plaatslading();
        plaatstimer();*/
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("enter") && tellerEnter == 0){
            this.removeObjects(this.getObjects(null));
            setBackground("cell.jpg");
            plaatsmenu();
            plaatslijst();
            plaatscontainers();
            plaatsauto();
            plaatsbesturing();
            plaatslading();
            plaatstimer();
            
            tellerEnter++;
        }
        else if(Greenfoot.isKeyDown("backspace") && tellerBackspace == 0){
            Greenfoot.setWorld(firstWorld);
            tellerBackspace++;
        }
    }
    
    
    
    public void plaatstimer(){
        addObject(new Timer(true, true, 60, "Tijd:"), 9, 0);
    }
    public void plaatstimerlvl2(){
        addObject(new Timer(true, true, 50, "Tijd:"), 9, 0);
    }
    public void plaatstimerlvl3(){
        addObject(new Timer(true, true, 40, "Tijd:"), 9, 0);
    }
    public void plaatsmenu(){
        for (int y = 0; y<1; y++) {
            for (int x = 0; x<10; x++){
                addObject( new Menu (), x, y );
            }
        }
    }
    public void plaatscontainers(){
        addObject(new Container(),0,1);
        addObject(new Container(),0,2);
        addObject(new Container(),0,3);
        addObject(new Container(),0,4);
        addObject(new Container(),0,5);  
        addObject(new Container(),0,6);
        addObject(new Container(),0,7);
        addObject(new Container(),0,8);
        addObject(new Container(),0,9);
        addObject(new Container(),1,1);  
        addObject(new Container(),2,1);
        addObject(new Container(),2,9);
        addObject(new Container(),2,8);
        addObject(new Container(),2,7);
        addObject(new Container(),2,6);
        addObject(new Container(),2,5);
        addObject(new Container(),2,4);
        addObject(new Container(),3,4);
        addObject(new Container(),3,1);
        addObject(new Container(),4,1);
        addObject(new Container(),4,4);
        addObject(new Container(),5,1);
        addObject(new Container(),5,4);
        addObject(new Container(),6,1);
        addObject(new Container(),6,4);
        addObject(new Container(),7,1);
        addObject(new Container(),7,4);
        addObject(new Container(),8,1);
        addObject(new Container(),9,1);
        addObject(new Container(),9,2);
        addObject(new Container(),9,3);
        addObject(new Container(),9,4);
        addObject(new Container(),9,5);
        addObject(new Container(),9,6);
        addObject(new Container(),8,6);
        addObject(new Container(),7,6);
        addObject(new Container(),6,6);
        addObject(new Container(),5,6);
        addObject(new Container(),4,6);
        addObject(new Container(),4,7);
        addObject(new Container(),4,8);      
        addObject(new Container(),6,8);
        addObject(new Container(),6,9);
        addObject(new Container(),9,7);
        addObject(new Container(),9,8);
        addObject(new Container(),7,8);
        addObject(new Container(),7,9);
        addObject(new Container(),1,2);
        addObject(new Container(),3,3);
        addObject(new Container(),5,2);
        addObject(new Container(),7,3);
    }
    public void plaatscontainerslvl2(){
        addObject(new Container(),1,1);
        addObject(new Container(),2,1);
        addObject(new Container(),3,1);
        addObject(new Container(),4,1);
        addObject(new Container(),5,1);  
        addObject(new Container(),6,1);
        addObject(new Container(),6,2);
        addObject(new Container(),6,3);
        addObject(new Container(),6,4);
        addObject(new Container(),8,2);  
        addObject(new Container(),8,3);
        addObject(new Container(),8,4);
        addObject(new Container(),8,5);
        addObject(new Container(),8,6);
        addObject(new Container(),7,6);
        addObject(new Container(),7,7);
        addObject(new Container(),7,8);
        addObject(new Container(),6,6);
        addObject(new Container(),6,7);
        addObject(new Container(),6,8);
        addObject(new Container(),5,6);
        addObject(new Container(),5,7);
        addObject(new Container(),4,9);
        addObject(new Container(),0,9);
        addObject(new Container(),1,7);
        addObject(new Container(),1,6);
        addObject(new Container(),1,5);
        addObject(new Container(),3,5);
        addObject(new Container(),3,4);      
        addObject(new Container(),3,3);
        addObject(new Container(),2,3);
        addObject(new Container(),1,3);
        addObject(new Container(),0,3);
        addObject(new Container(),2,7);
        addObject(new Container(),3,7);
        addObject(new Container(),4,7);
        addObject(new Container(),2,8);
        addObject(new Container(),9,8);
        addObject(new Container(),0,1);
    }
    public void plaatscontainerslvl3(){
        addObject(new Container(),0,1);
        addObject(new Container(),1,1);
        addObject(new Container(),2,1);
        addObject(new Container(),3,1);
        addObject(new Container(),4,1);
        addObject(new Container(),5,1);  
        addObject(new Container(),6,1);
        addObject(new Container(),7,1);
        addObject(new Container(),8,1);
        addObject(new Container(),9,1);
        addObject(new Container(),8,2);  
        addObject(new Container(),8,3);
        addObject(new Container(),8,4);
        addObject(new Container(),8,5);
        addObject(new Container(),8,6);
        addObject(new Container(),7,6);
        addObject(new Container(),7,7);
        addObject(new Container(),7,8);
        addObject(new Container(),6,6);
        addObject(new Container(),6,7);
        addObject(new Container(),6,8);
        addObject(new Container(),5,6);
        addObject(new Container(),5,7);
        addObject(new Container(),4,9);
        addObject(new Container(),0,9);
        addObject(new Container(),1,7);
        addObject(new Container(),1,6);
        addObject(new Container(),1,5);
        addObject(new Container(),3,5);
        addObject(new Container(),3,4);      
        addObject(new Container(),3,3);
        addObject(new Container(),2,3);
        addObject(new Container(),1,3);
        addObject(new Container(),0,3);
        addObject(new Container(),2,7);
        addObject(new Container(),3,7);
        addObject(new Container(),4,7);
        addObject(new Container(),2,8);
        addObject(new Container(),9,8);
        addObject(new Container(),0,1);
        addObject(new Container(),5,2);
    }
    public void plaatsbesturing(){
        theDrive = new Drive();
        addObject(theDrive, 4, 0);
        addObject(new Left(),0,0);
        addObject(new Top(),1,0);
        addObject(new Right(),2,0);
        addObject(new Bottom(),3,0);
    }
    public void plaatsauto(){
        theAutonoomAuto = new AutonoomAuto();
        addObject(theAutonoomAuto, 1, 9);
    }
    public void plaatsautolinksboven(){
        theAutonoomAuto = new AutonoomAuto();
        theAutonoomAuto.setImage("autoright.png");
        addObject(theAutonoomAuto, 0, 2);
    }
    public void plaatslijst(){
        theList = new List();
        addObject(theList,0,0);
    }
    public void plaatslading(){
        addObject(new Lading(),9,9);
    }
    public void plaatsladinglvl3(){
        addObject(new Lading(),9,2);
    }
    public void loadlvl1(){
        plaatsmenu();
        plaatslijst();
        plaatscontainers();
        plaatsauto();
        plaatsbesturing();
        plaatslading();
        plaatstimer();
        //addObject(new Button("Back", this), 7, 0);
    }
    public void loadlvl2(){
        plaatsmenu();
        plaatslijst();
        plaatscontainerslvl2();
        plaatsautolinksboven();
        plaatsbesturing();
        plaatslading();
        plaatstimerlvl2();
        //addObject(new Button("Back", this), 7, 0);
    }
    public void loadlvl3(){
        addObject(new Carcrash(), 4, 2);
        addObject(new Carcrash(), 8, 8);
        plaatsmenu();
        plaatslijst();
        plaatscontainerslvl3();
        plaatsautolinksboven();
        plaatsbesturing();
        plaatsladinglvl3();      
        plaatstimerlvl3();
        //addObject(new Button("Back", this), 7, 0);
    }
    public void lvlplus(){
        lvlgehaald++;
    }
    public void lvlreset(){
        lvlgehaald=0;
    }
    public int lvlgehaald(){
        return lvlgehaald;
    }
    public List getList(){
        return theList;
    }
    public Drive getDrive(){
        return theDrive;
    }
    public AutonoomAuto getAutonoomAuto(){
        return theAutonoomAuto;
    }
    
    public void buttonPressed(Button button)
    {
        if ("Back".equals(button.getTitle()) ) {
            Greenfoot.setWorld(firstWorld);
        }
    }
}
