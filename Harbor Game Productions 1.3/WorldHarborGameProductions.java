import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class WorldHarborGameProductions extends World {
    
    public static WorldHarborGameProductions instance;
    public static Robbery robbery;
    public static Thread robberyThread;
    protected static int wealth = 10000;
    protected GreenfootImage overallHUD;
    
    public WorldHarborGameProductions(int width, int height, int cellsize) {    
        super(width, height, cellsize); 
        init();
    }
    
    public WorldHarborGameProductions(int width, int height, int cellsize, boolean bounded) {   
        super(width, height, cellsize, bounded); 
        init();
    }
    
    /**
     * Initialize all variables
     */
    public void init(){
        instance = this;
        overallHUD = new GreenfootImage("overallHUD2.png");
        if(robbery == null) {
            robbery = new Robbery();
            robberyThread = new Thread(robbery);
            robberyThread.start();
        }
        resetMapTexture();
    }
    
    /**
     * Change the wealth and update the money display
     */
    public void changeWealth(int amount, String... strings) {
        wealth += amount;
        resetMapTexture();
    }
    
    /**
     * Set the map background back to the default and draw the HUD
     */
    public void resetMapTexture() {
        setBackground(getMapName());
        getBackground().drawImage(overallHUD, 0, 0);
        getBackground().drawString(wealth+"", 789-200, 8+12);
    }
    
    /**
     * Spawn thieves if world is instanceof WorldTowerDefense
     */
    public void spawnThief() {
    }
    
    /**
     * The name of the backgrounds texture
     */
    public abstract String getMapName();
}
