import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ConcreteDecorator class. Adds the score when small rock is hit
 * 
 * @Team 15
 */

public class SmallDecorator extends ScoreDecorator
{
    
    public SmallDecorator(Score s)
    {
        super(s);
    }
    
    public int addScore()
    {
       return super.addScore() + 5; 
    }
    
    
}
