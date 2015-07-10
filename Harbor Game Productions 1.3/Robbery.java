import java.util.*;
import java.awt.*;
import greenfoot.*;

public class Robbery implements Runnable {
    
    public int baseChanceOfRobbery;
    public int actualChanceOfRobbery;
    public int baseChanceOfRobberyCosts;
    public int actualChanceOfRobberyCosts;
    public int baseChanceOfRobberyMasses;
    public int actualChanceOfRobberyMasses;
    public static Map<Integer, String> itemsWithValue;
    
    public Random rand;
    
    public final int POPUP_X = 532;
    public final int POPUP_Y = 520;
    
    public Robbery() {
        rand = new Random();
        actualChanceOfRobbery = 100;
        actualChanceOfRobberyCosts = 100;
        actualChanceOfRobberyMasses = 10;
    }

    /**
     * Spawn thieves
     */
    @Override
    public void run() {
        while(true) {
            try {
                if(rand.nextInt(100) <= actualChanceOfRobbery) {
                    if(actualChanceOfRobberyMasses < 1) {
                        actualChanceOfRobberyMasses = 1;
                    }
                    int masses = rand.nextInt(actualChanceOfRobberyMasses);
                    if(WorldHarborGameProductions.instance instanceof WorldTowerDefense) {
                        for(int i = 0; i < masses; i++) {
                            WorldHarborGameProductions.instance.spawnThief();
                            Thread.sleep(1000);
                        }
                    } else {
                        Map.Entry item = getRandomItem();
                        int price = -Integer.parseInt(item.getKey().toString())*masses;
                        WorldHarborGameProductions.instance.changeWealth(price);
                        Actor popup = new Popup("Thieves stole "+-price, "worth of goods");
                        WorldHarborGameProductions.instance.addObject(popup, POPUP_X, POPUP_Y);
                    }
                } else {
                    int loot = rand.nextInt(10)*500;
                    Actor popup = new Popup("Your turrets defeated", "hostile thieves", "carrying "+loot);
                    WorldHarborGameProductions.instance.changeWealth(loot);
                    WorldHarborGameProductions.instance.addObject(popup, POPUP_X, POPUP_Y);
                }
                Thread.sleep(10000);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Get a random item along with its value
     */
    public Map.Entry<Integer, String> getRandomItem() {
        Set<Map.Entry<Integer, String>> keys = itemsWithValue.entrySet();
        int item = rand.nextInt(itemsWithValue.size());
        int index = 0;
        Iterator<Map.Entry<Integer, String>> itr = keys.iterator();
        while(itr.hasNext()) {
            if(index == item) {
                return itr.next();
            }
            index++;
        }
        return null;
    }
    
    static {
        itemsWithValue = new HashMap<Integer, String>();
        itemsWithValue.put(10000, " container full of smartphones");
        itemsWithValue.put(1000, " container full of televisions");
        itemsWithValue.put(500, " container full of food");
        itemsWithValue.put(500, "Harbor property equipment");
    }
}
