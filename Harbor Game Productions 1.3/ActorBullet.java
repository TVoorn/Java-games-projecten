import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ActorBullet extends Actor {
    
    public int lifeTime = 100;
    public int rot;
    
    public ActorBullet(int rot) {
        this.rot = rot;
    }
    
    public void act() {
        setRotation(rot);
        move(4);
        if(isTouching(ActorThief.class)) {
            Actor actor = getOneIntersectingObject(ActorThief.class);
            if(actor instanceof ActorThief) {
                ((ActorThief)actor).damage(1);
                getWorld().removeObject(this);
                return;
            }
        }
        lifeTime--;
        if(lifeTime <= 0 && getWorld() != null) {
            getWorld().removeObject(this);
        }
    }    
}
