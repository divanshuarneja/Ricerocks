import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Decorator class. Extended by ConcreteDecorator classes
 * 
 * @Team 15
 */

public class ScoreDecorator extends Actor implements ScoreInterface
{
    protected Score s;
    
    public ScoreDecorator(Score s)
    {
        this.s = s;
    }
    
    public int addScore()
    {
        return s.addScore();
    }    
}
