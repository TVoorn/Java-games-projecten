import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Krat extends Actor{
    private int id;
    private DouaneHal d; 
    private ScoreBord s;
    /**
     * id 1 = banaan  
     * id 2 = tshirt
     * id 3 = pistool
     * id 4 = bom
     */
    
    public Krat(){
        this.id = Greenfoot.getRandomNumber(4) + 1;
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        int huidigid = getId(); 
        d = (DouaneHal) getWorld();
        s = d.getScoreBord();
        List kratLijst = d.getObjects(Krat.class);
        
        
        if(s.getScore() >= 0 && s.getScore() < 10){
            moveKrat(1);
        }
        else if(s.getScore() >= 10 && s.getScore() < 20){
            moveKrat(1);
            
            if(kratLijst.size() == 3){
                Krat k = new Krat();
                d.addObject(k, 888, 200);
            }
            
        }
        else if(s.getScore() >= 20 && s.getScore() < 30){
            moveKrat(2);
        }
        else if(s.getScore() >= 30 && s.getScore() < 40){
            moveKrat(2);
            
            if(kratLijst.size() == 5){
                Krat k = new Krat();
                d.addObject(k, 888, 200);
            }
            
        }
        else if(s.getScore() >= 40){
            moveKrat(3);            
        }
        else{
            moveKrat(1);
        }
        
        if (xrayLijnBeginTouched()){            
            showInhoudKrat();            
        }
        else if(xrayLijnEindTouched()){
            showKrat();
        }
        else if(checkPlayer()){
            if(huidigid == 1 || huidigid == 2){
                addPunten(-1);
                d.removeObject(this);
                respawn();
                Greenfoot.playSound("wrongclick.mp3");
                //Greenfoot.stop();
            }
            else if(huidigid == 3 || huidigid == 4){
                addPunten(1);
                d.removeObject(this);
                respawn();
                Greenfoot.playSound("click.mp3");
            }
        }
        else if(checklijn()){
            if(huidigid == 1 || huidigid == 2){
                addPunten(1);
                d.removeObject(this);
                respawn();
                Greenfoot.playSound("click.mp3");
            }
            else if(huidigid == 3 || huidigid == 4){
                //addPunten(-1);
                //d.removeObject(this);
                //respawn();
                //Greenfoot.stop();
                stopGame();
            }
        }
        
    }
   
    public void showInhoudKrat(){
        int huidigid = getId();
        
        if(huidigid == 1){
            setImage("banaan.png");
        }
        else if(huidigid == 2){  
            setImage("tshirt.png");
        }
        else if(huidigid == 3){
            setImage("pistool.png");
        }
        else if(huidigid ==4){
            setImage("bom.png");
        }
    }
    
    public void showKrat(){
        setImage("crate.jpg");
    }
    
    public void moveKrat(int x){
        setLocation(getX()-x, getY());
    }
    
    public boolean xrayLijnBeginTouched(){
        Actor xray = getOneObjectAtOffset(0, 0, XrayLijnBegin.class);
        if(xray != null){
            return true;
        }
        else{
            return false;
        }
    }
     public boolean xrayLijnEindTouched(){
        Actor xray = getOneObjectAtOffset(0, 0, XrayLijnEind.class);
        if(xray != null){
            return true;
        }
        else{
            return false;
        }
    }
 
    public boolean checklijn(){
        Actor lijn = getOneObjectAtOffset(0, 0, Controlelijn.class);
       
        if(lijn != null){
                return true;
        }
        else{
             return false;
        }
    }
    
    public boolean checkPlayer(){
        Actor p = getOneObjectAtOffset(0, 0, Douanier.class);
        if(p != null){
            return true;
        }
        else{
            return false;
        }
    }
            
    public void respawn(){
        int random = Greenfoot.getRandomNumber(3) + 1;
        
        if(random == 1){
            d.addObject(new Krat(), 888, 65);
        }
        else if(random == 2){
            d.addObject(new Krat(), 888, 200);
        }
        else if(random == 3){
            d.addObject(new Krat(), 888, 335);
        }
    }
    
    public void addPunten(int x){
        DouaneHal d = (DouaneHal) getWorld();
        ScoreBord s = d.getScoreBord();
        s.addToScore(x);
    }
    
    public int getId(){
        return this.id;
    }
    
    public void stopGame(){
        d.addObject(new Explosion(), getX(),getY()); 
        Greenfoot.playSound("explosie.mp3"); 
        Greenfoot.delay(25); 
        d.removeObjects(getWorld().getObjects(null));  //Alle objecten uit de wereld verwijderen
        d.addObject(new Bericht(5), 400, 200);
    }

}   