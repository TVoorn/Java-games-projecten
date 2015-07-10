import greenfoot.*;

/**
 * Write a description of class PolitieSchip1 here.
 * 
 * @author (Igor Ivanisevic-Mustapic) 
 * @version (20-12-2013)
 */
public class PolitieSchip extends Schip
{ 
    //constructor van de politieSchip
    public PolitieSchip(int punten){
        super(punten);  
    }
    
    //act methode
    public void act(){
        c = (ControleCentrumWorld) getWorld();
        s = c.getScoreBord();
        
        if(getY() == 0){
            super.respawn();            
        }
        else if(Greenfoot.mouseClicked(this)){
            playSound();
            super.addPuntenToScoreBord(punten);                   
        }
        else{
            if(s.getScore() >= 0 && s.getScore() < 10){
                super.setSpeed(1);
            }
            else if(s.getScore() >= 10 && s.getScore() < 20){
                super.setSpeed(2);
            }
            else if(s.getScore() >= 20 && s.getScore() < 30){
                super.setSpeed(3);
            }
            else if(s.getScore() >= 30 && s.getScore() < 40){
                super.setSpeed(4);
            }
            else if(s.getScore() >= 40){
                super.setSpeed(4);
            }
            else{
                super.setSpeed(1);
            }
        }
    }
    //de politie schip heeft een andere geluid als er op geklikt wordt dus @Override overschrijf de methode
    //playSound() van de superclass schip
    @Override
    public void playSound(){
        Greenfoot.playSound("wrongclick.mp3");
    }
    
   
}
