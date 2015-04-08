import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * An explosion. It starts by expanding and then collapsing. 
 * 
 * @Team 15
 */

public class Explosion extends GifActor
{
    
    public void addedToWorld(World world)
    {
       setImage("graphics-explosions-504104.gif");
       Greenfoot.setSpeed(35);
       Greenfoot.playSound("explosion.mp3");
       
    }
    
    public void act()
    {
        super.act(); //You MUST keep this in your act method for your animation to work!
        getWorld().removeObject(this);
        Greenfoot.setSpeed(50);
    }
    
}