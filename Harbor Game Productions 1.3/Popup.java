import greenfoot.*;
import java.util.*;

public class Popup extends Actor {
    
    protected java.util.List<String> messages;
    protected int state;
    protected int timer;

    public Popup(String... messages) {
        this.messages = new ArrayList(Arrays.asList(messages));
        timer = 100;
    }
    
    @Override
    public void act() {
        for(int i = 0; i < messages.size(); i++) {
            getImage().drawString(messages.get(i), 48, 20+12*i);
        }
        if(state == 0) {
            setLocation(getX(), getY() - 1);
            if(getY() == 480 - 30) {
                state++;
            }
        } else if(state == 1) {
            timer--;
            if(timer <= 0) {
                state++;
            }
        } else if(state == 2) {
            setLocation(getX(), getY() + 1);
            if(getY() == getWorld().getBackground().getHeight()+getImage().getHeight()) {
                getWorld().removeObject(this);
            }
        }
    }
    
}
