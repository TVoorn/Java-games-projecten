import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public abstract class ActorBuilding extends Actor {
    
    public int range;
    
    public ActorBuilding(int range) {
        this.range = range;
    }
    
    public void act() {
        java.util.List<ActorThief> thieves = getObjectsInRange(range, ActorThief.class);
        if(thieves != null && thieves.size() > 0) {
            onThievesInRange(thieves);
        }
    }
    
    /**
     * Called when thieves enter this buildings' range
     * @param Thieves - the list of thieves
     */
    public void onThievesInRange(java.util.List<ActorThief> Thieves) {
    }
}
