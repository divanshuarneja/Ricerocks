import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ConcreteDecorator class. Adds the score when large rock is hit
 * 
 * @Team 15
 */

public class LargeDecorator extends ScoreDecorator
{
    
    public LargeDecorator(Score s)
    {
        super(s);
    }
    
    public int addScore()
    {
        return super.addScore() + 10;
    }
    
     
}
