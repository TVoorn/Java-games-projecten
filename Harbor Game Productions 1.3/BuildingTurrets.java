import greenfoot.*;

public class BuildingTurrets extends Building {
    
    public BuildingTurrets(WorldHarborGameProductions menu, int x, int y) {
        super(menu, x, y);
        this.img = new GreenfootImage("BuildingTurrets.png");
    }
    
    /**
     * Apply effect to the robbery thread
     * @param robbery - the robbery thread
     */
    @Override
    public void effect(Robbery robbery){
        robbery.actualChanceOfRobberyMasses -= 10;
    }
    
}
