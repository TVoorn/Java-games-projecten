import greenfoot.*;
import java.awt.*;
import java.util.*;

public class ActorThief extends Actor {
    
    private java.util.List<Point> path;
    private int currentPathStep;
    private boolean hasStolen;
    private int hp = 10;
    
    public void act() {
        if(path != null) {
            if(currentPathStep >= path.size()) {
                if(!hasStolen) {
                    hasStolen = true;
                    path = ((WorldTowerDefense)getWorld()).pathFinder.findPath(this, 0, 0);
                } else {
                    Map.Entry item = WorldTowerDefense.robbery.getRandomItem();
                    WorldTowerDefense.instance.changeWealth(-Integer.parseInt(item.getKey().toString()), (String)item.getValue(), "has been stolen!");
                    getWorld().removeObject(this);
                }
                currentPathStep = 0;
            } else {
                int destX = path.get(currentPathStep).x*32+16;
                int destY = path.get(currentPathStep).y*32+16;
                if(getX() == destX && getY() == destY) {
                    currentPathStep++;
                }
                turnTowards(destX, destY);
                move(1);
            }
        } else {
            if(!hasStolen) {
                path = ((WorldTowerDefense)getWorld()).pathFinder.findPath(this, 25, 14);
            } else {
                path = ((WorldTowerDefense)getWorld()).pathFinder.findPath(this, 0, 0);
            }
            currentPathStep = 0;
        }
    }
    
    /**
     * Apply damage and award money on kill
     * @param amount - the amount to add
     */
    public void damage(int amount) {
        hp -= amount;
        if(hp <= 0) {
            ((WorldTowerDefense)getWorld()).changeWealth(50, "A thief was shot!");
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Set this thiefs path
     * @param path - the new path
     */
    public void setPath(java.util.List<Point> path) {
        this.path = path;
    }
}
