import greenfoot.*;

public class BuildingFactory extends Building {
    
    public BuildingFactory(WorldHarborGameProductions menu, int x, int y) {
        super(menu, x, y);
        this.img = new GreenfootImage("BuildingFactory.png");
    }
    
    /**
     * Apply effect to the robbery thread
     * @param robbery - the robbery thread
     */
    @Override
    public void effect(Robbery robbery){
        robbery.actualChanceOfRobbery -= 10;
    }
    
}
