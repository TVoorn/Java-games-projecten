import greenfoot.*;

public class Building {
    
    private int x;
    private int y;
    public GreenfootImage img;
    protected WorldHarborGameProductions menu;

    public Building(WorldHarborGameProductions menu, int x, int y) {
        this.x = x;
        this.y = y;
        this.menu = menu;
    }
    
    /**
     * Apply effect to the robbery thread
     * @param robbery - the robbery thread
     */
    public void effect(Robbery robbery){
        
    }
    
    /**
     * Show a list with possible actions
     */
    public void showDropdownList(){
        ActorButton button = new ActorButton("Destroy", new IAction() {
            @Override
            public boolean performAction(ActorButton button) {
                ((WorldMenu)WorldHarborGameProductions.instance).buildings[x/64-3][y/64-3] = null;
                menu.setBackground(new GreenfootImage("mapMenu.png"));
                menu.removeObject(button);
                return true;
            }
        });
        menu.addObject(button, x, y);
        ((WorldMenu)WorldHarborGameProductions.instance).constructionButtons.add(button);
    }
    
    /**
     * The X location of the building
     */
    public int getX() {
        return x;
    }
    
    /**
     * The Y location of the building
     */
    public int getY() {
        return y;
    }
}
