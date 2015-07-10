import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class WorldMenu extends WorldHarborGameProductions {
    
    public java.util.List<ActorButton> constructionButtons;
    boolean hasMouseClicked;
    int lastMouseClick;
    public static Building[][] buildings;
    
    static {
        buildings = new Building[6][2];
    }

    public WorldMenu() {
        super(632, 480, 1, false); 
    }
    
    /**
     * Initialize all variables
     */
    public void init(){
        super.init();
        constructionButtons = new ArrayList<ActorButton>();
        setBackground(new GreenfootImage("mapMenu.png"));
        getBackground().drawImage(overallHUD, 0, 0);
        getBackground().drawString(wealth+"", 789-200, 8+12);
        ActorButton button = new ActorButton(new String[]{"Terug naar","menu"}, new IAction() {
            @Override
            public boolean performAction(ActorButton button) {
                Greenfoot.setWorld(new MenuWorld());
                return true;
            }
        });
        addObject(button, 38+32, 160+32);
        button = new ActorButton(new String[]{"Tower","Defense"}, new IAction() {
            @Override
            public boolean performAction(ActorButton button) {
                Greenfoot.setWorld(new WorldTowerDefense());
                return true;
            }
        });
        addObject(button, 38+32, 254+32);
    }
    
    /**
     * The name of the backgrounds texture
     */
    public String getMapName() {
        return "mapMenu.png";
    }
    
    @Override
    public void act() {
        super.act();
        checkMouseClick();
        MouseInfo mouseinfo = Greenfoot.getMouseInfo();
        if(mouseinfo != null && hasMouseClicked){
            final int x = mouseinfo.getX() / 64;
            final int y = mouseinfo.getY() / 64;
            if((x>=3 && x<=8) && (y==3 || y==4) && constructionButtons.size() == 0) {
                if(buildings[x-3][y-3] == null) {
                    final ActorButton button = new ActorButton(new String[]{"Construct Factory","-10% chance of robbery, $1000"}, new IAction(){ 
                        @Override
                        public boolean performAction(ActorButton button) {
                            if(wealth < 1000) {
                                return false;
                            }
                            changeWealth(-1000);
                            BuildingFactory building = new BuildingFactory(WorldHarborGameProductions.instance, x*64, y*64);
                            building.effect(WorldTowerDefense.robbery);
                            buildings[x-3][y-3] = building;
                            WorldMenu.instance.removeObject(button);
                            return true;
                        }   
                    });
                    button.setImage("buttonLarge.png");
                    addObject(button, x*64,y*64);
                    constructionButtons.add(button);
                    final ActorButton button2 = new ActorButton(new String[]{"Turret Improvements","10% smaller waves, $500"}, new IAction(){ 
                        @Override
                        public boolean performAction(ActorButton button) {
                            if(wealth < 500) {
                                return false;
                            }
                            changeWealth(-500);
                            BuildingTurrets building = new BuildingTurrets(WorldHarborGameProductions.instance, x*64, y*64);
                            building.effect(WorldTowerDefense.robbery);
                            ((WorldMenu)WorldHarborGameProductions.instance).buildings[x-3][y-3] = building;
                            WorldMenu.instance.removeObject(button);
                            return true;
                        }   
                    });
                    button2.setImage("buttonLarge.png");
                    addObject(button2, x*64,y*64+32);
                    constructionButtons.add(button2);
                } else {
                    buildings[x-3][y-3].showDropdownList();
                }
            } else {
                for(ActorButton button : constructionButtons) {
                    removeObject(button);
                }
                constructionButtons.clear();
            }
        }
        for(int x = 0; x < 6; x++) {
            for(int y = 0; y < 2; y++) {
                if(buildings[x][y] != null) {
                    getBackground().drawImage(buildings[x][y].img, (x+3)*64, (y+3)*64);
                }                    
            }
        }
    }
    
    /**
     * Check if the mouse has only clicked once
     */
    public void checkMouseClick() {
        MouseInfo mouseinfo = Greenfoot.getMouseInfo();
        if(mouseinfo != null) {
            if(mouseinfo.getButton() == 1 && mouseinfo.getClickCount() == 1) {
                hasMouseClicked = true;
            } else {
                hasMouseClicked = false;
            }
            lastMouseClick = mouseinfo.getButton();
        }
    }    
    
}
