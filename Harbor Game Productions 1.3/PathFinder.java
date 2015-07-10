import greenfoot.*;
import java.util.*;
import java.awt.*;

/**
 * Write a description of class PathFinder here.
 * 
 * @author sirolf2009 
 * @version 0.1
 */
public class PathFinder {
    
    private WorldTowerDefense world;
    private Node[][] nodes;
    private int mapWidth;
    private int mapHeight;
    private boolean canCross;
    
    private java.util.List<Node> closed = new ArrayList<Node>();
    private java.util.List<Node> open = new ArrayList<Node>();
    
    public PathFinder(WorldTowerDefense world, boolean canCross) {
        this.world = world;
        this.canCross = canCross;
        mapWidth = (int)(world.getWidth()/32);
        mapHeight = (int)(world.getHeight()/32);
        nodes = new Node[mapWidth][mapHeight];
        for(int x = 0; x < mapWidth; x++) {
            for(int y = 0; y < mapHeight; y++) {
                nodes[x][y] = new Node(x, y);
            }
        }
    }
    
    /**
     * Calculate a path between two actors
     * @param me - the origin actor
     * @param dest - the destination actor
     */
    public java.util.List<Point> findPath(Actor me, Actor dest) {
        return findPath(me, dest.getX(), dest.getY());
    }
    
    /**
     * Calculate a path an actor and coords
     * @param me - the origin actor
     * @param destX - the dest X coord
     * @param destY - the dest Y coord
     */
    public java.util.List<Point> findPath(Actor me, int destX, int destY) {
        return findPath(me.getX(), me.getY(), destX, destY);
    }
    
    /**
     * Calculate a path between 2 coords
     * @param beginX - the begin X coord
     * @param beginY - the begin Y coord
     * @param destX - the dest X coord
     * @param destY - the dest Y coord
     */
    public java.util.List<Point> findPath(int beginX, int beginY, int destX, int destY) {
        int startX = beginX/32;
        int startY = beginY/32;
        
        nodes[startX][startY].cost = 0;
        nodes[startX][startY].depth = 0;
        nodes[destX][destY].parent = null;
        closed.clear();
        open.clear();
        open.add(nodes[startX][startY]);
        int maxDepth = 0;
        while ((maxDepth < 255) && (open.size() != 0)) {
            Node current = open.get(0);
            if (current == nodes[destX][destY]) {
                break;
            }
            
            open.remove(current);
            closed.add(current);

            for (int x=-1;x<2;x++) {
                for (int y=-1;y<2;y++) {
                    
                    if((x == 0) && (y == 0)) {
                        continue;
                    }
                
                    int xp = x + current.x;
                    int yp = y + current.y;
                    
                    if(xp<0  || yp<0 || xp>=mapWidth || yp>=mapHeight) {
                        continue;
                    }
                    
                    if(world.instance.getMapTiles()[yp][xp] == 1) {
                        continue;
                    }
                    
                    if((x!=0&&y!=0) && !canCross) {
                        continue;
                    }
                    
                    int nextStepCost = (x!=0&&y!=0) ? current.cost +2 : current.cost + 1;
                    Node neighbour = nodes[xp][yp];
                    
                    if (nextStepCost < neighbour.cost) {
                        if (open.contains(neighbour)) {
                            open.remove(neighbour);
                        }
                        if (closed.contains(neighbour)) {
                            closed.remove(neighbour);
                        }
                    }
                    if (!open.contains(neighbour) && !closed.contains(neighbour)) {
                        neighbour.cost = nextStepCost;
                        neighbour.parent=current;
                        maxDepth = Math.max(maxDepth, neighbour.depth);
                        open.add(neighbour);
                    }
                }
            }
        }
        
        if (nodes[destX][destY].parent == null) {
            return null;
        }
                
        java.util.List<Point> path = new ArrayList<Point>();
        Node target = nodes[destX][destY];
        while (target != nodes[startX][startY]) {
            path.add(0, new Point(target.x, target.y));
            target = target.parent;
        }
        path.add(0, new Point(startX, startY));
        return path;
    }
    
    public class Node {
        int cost;
        int depth;
        int x, y;
        boolean isPassable;
        Node parent;
    
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
