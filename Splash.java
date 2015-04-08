import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Splash screen. It needs to be clicked to start the game. 
 * It comes over again when the game gets over
 * 
 * @Team 15
 */

public class Splash extends Actor
{
    /**
     * Act - do whatever the Splash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(Greenfoot.mousePressed(this)) 
       {  
           remove();  
       }
    }
    
    public void remove()
    {
        ((ricerocks) getWorld()).started= true;
        getWorld().removeObject(this);
        Lives.life = 3;
        Score.sc = 0;
    }
}
