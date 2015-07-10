import greenfoot.*;
import java.util.*;
import java.lang.Thread.State;

public class WorldTowerDefense extends WorldHarborGameProductions {
    
    public PathFinder pathFinder;
    private static java.util.List<ActorBuilding> buildings;
    public static Robbery robbery;
    public static Thread robberyThread;
    public static WorldTowerDefense instance;
    public static int pathSize;
    private GreenfootImage overallHUD;
    
    static {
        buildings = new ArrayList<ActorBuilding>();
        robbery = new Robbery();
        robberyThread = new Thread(robbery);
    }
    
    public WorldTowerDefense() {
        super(832, 480, 1, false); 
        init();
    }
    
    /**
     * Initialize all variables
     */
    public void init() {
        super.init();
        instance = this;
        loadEntities();
        pathFinder = new PathFinder(this, false);
        ActorButton button = new ActorButton("Back", new IAction() {
            @Override
            public boolean performAction(ActorButton button) {
                saveEntities();
                Greenfoot.setWorld(new WorldMenu());
                return true;
            }
        });
        addObject(button, 832-32, 48);
        overallHUD = new GreenfootImage("overallHUD.png");
        resetMapTexture();
    }
    
    @Override
    public void act() {
        super.act();
        if(robberyThread.getState() == State.NEW) {
            robberyThread.start();
        }
        MouseInfo mouseinfo = Greenfoot.getMouseInfo();
        if(mouseinfo != null && mouseinfo.getButton() == 1 && mouseinfo.getClickCount() == 2) {
            ActorButton button = new ActorButton(new String[]{"Construct turret $100"}, construct);
            button.dissapearOnFocusLost(true);
            button.setImage("buttonWide.png");
            int x = (int) Math.floor(mouseinfo.getX() / 32);
            int y = (int) Math.floor(mouseinfo.getY() / 32);
            addObject(button, x*32+ 16, y*32 + 16);
            button = new ActorButton(new String[]{"Construct containers","$10"}, container);
            button.dissapearOnFocusLost(true);
            button.setImage("buttonWide.png");
            addObject(button, x*32+ 16, y*32 + 48);
        }
    }
    
    /**
     * Save all buildings
     */
    public void saveEntities() {
        buildings.clear();
        java.util.List<ActorBuilding> list = getObjects(ActorBuilding.class);
        for(ActorBuilding building : list) {
            buildings.add(building);
        }
        pathSize = pathFinder.findPath(0, 0, 25, 14).size();
    }
    
    /**
     * Load all buildings
     */
    public void loadEntities() {
        for(ActorBuilding building : buildings) {
            addObject(building, building.getX(), building.getY());
        }
    }
    
    /**
     * Make every thief plot out a new path
     */
    public void updatePaths() {
        java.util.List<ActorThief> thiefs = getObjects(ActorThief.class);
        for(ActorThief thief : thiefs) {
            thief.setPath(null);
        }
    }
    
    /**
     * Spawn thieves if world is instanceof WorldTowerDefense
     */
    @Override
    public void spawnThief() {
        ActorThief thief = new ActorThief();
        addObject(thief, 0, 0);
    }
    
    /**
     * Set the map background back to the default and draw the HUD
     */
    @Override
     public void resetMapTexture() {
        setBackground(getMapName());
        if(overallHUD != null) {
            getBackground().drawImage(overallHUD, 0, 0);
            getBackground().drawString(wealth+"", 789, 8+12);
        }
    }
    
    /**
     * Remove all building buttons
     */
    public void removeBuildingButtons() {
        java.util.List<ActorButton> list = (java.util.List<ActorButton>)getObjects(ActorButton.class);
        if(list != null && list.size() > 0) {
            for(ActorButton actor : list) {
                if(actor.getX() != 400 && actor.getY() != 48) {
                    removeObject(actor);
                }
            }
        }
    }
    
    /**
     * The name of the backgrounds texture
     */
    public String getMapName() {
        return "MapTD.png";
    }
    
    /**
     * Get the worlds instance
     */
    public WorldTowerDefense getWorld() {
        return this;
    }
    
    /**
     * get a grid of passable and unpassable tiles
     * Used by the Pathfinder
     */
    public int[][] getMapTiles() {
        return grid;
    }
    
    public static int[][] grid = new int[][] {
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        
    public IAction construct = new IAction() {
        @Override
        public boolean performAction(ActorButton button) {
            if(grid[button.getY()/32][button.getX()/32] == 0 && wealth >= 100 && button.getX() > 3 && button.getY() > 1) {
                grid[button.getY()/32][button.getX()/32] = 1;
                if(pathFinder.findPath(0, 0, 25, 14) == null) {
                    grid[button.getY()/32][button.getX()/32] = 0;
                    return false;
                }
                ActorTurret turret = new ActorTurret();
                addObject(turret, button.getX(), button.getY());
                grid[button.getY()/32][button.getX()/32] = 1;
                WorldTowerDefense.instance.removeObject(button);
                wealth -= 100;
                resetMapTexture();
                updatePaths();
                removeBuildingButtons();
                return true;
            }
            return false;
        }
    };
    public IAction container = new IAction() {
        @Override
        public boolean performAction(ActorButton button) {
            int y = (button.getY()-32)/32;
            if(grid[y][button.getX()/32] == 0 && wealth >= 10 && button.getX() > 3 && y > 1) {
                grid[y][button.getX()/32] = 1;
                if(pathFinder.findPath(0, 0, 25, 14) == null) {
                    grid[y][button.getX()/32] = 0;
                    System.out.println("Blocking path");
                    return false;
                }
                ActorContainer turret = new ActorContainer();
                addObject(turret, button.getX(), button.getY()-32);
                WorldTowerDefense.instance.removeObject(button);
                wealth -= 10;
                resetMapTexture();
                updatePaths();
                removeBuildingButtons();
                return true;
            }
            return false;
        }
    };
}
