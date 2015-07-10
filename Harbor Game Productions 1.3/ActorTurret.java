import greenfoot.*;
import java.util.*;

public class ActorTurret extends ActorBuilding {
    
    public int shootSpeed;
    public int shootCooldown;
    
    public ActorTurret() {
        super(100);
        shootSpeed = 50;
    }
    
    @Override
    public void act() {
        super.act();
        shootCooldown--;
    }
    
    /**
     * Called when thieves enter this buildings' range
     * @param Thieves - the list of thieves
     */
    @Override
    public void onThievesInRange(java.util.List<ActorThief> thieves) {
        ActorThief thief = thieves.get(0);
        turnTowards(thief.getX(), thief.getY());
        if(shootCooldown <= 0) {
            getWorld().addObject(new ActorBullet(getRotation()), getX(), getY());
            shootCooldown = shootSpeed;
        }
    }
    
}                     
