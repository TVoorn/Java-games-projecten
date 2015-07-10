import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBord extends Actor
{
    private int totaalScore = 0;

    public ScoreBord()
    {
        setImage(new GreenfootImage("Score: 0", 20, Color.WHITE, Color.BLACK));
        //setImage(new GreenfootImage("0", 20, Color.WHITE, Color.BLACK));
    }
    //Tel de score bij te totaalScore op
    public void addToScore(int score)
    {
        totaalScore += score;
        setImage(new GreenfootImage("Score: " + totaalScore, 20, Color.WHITE, Color.BLACK));
    }
    //getter
    public int getScore(){
        return totaalScore;
    }
}