import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract Rock class. 
 * 
 * @Team15
 */

public abstract class Rock extends SmoothMover 
{
    /**
     * Act - do whatever the asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rock()
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
    }
    
    public void act() 
    {
       
    }
    
    abstract public void movement();
    abstract public void rotation();
    
   
    
}