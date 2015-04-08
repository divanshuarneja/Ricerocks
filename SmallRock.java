import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SmallRock class. 
 * 
 * @Team15
 */
public class SmallRock extends Rock
{
   public void act()
   {
       movement();
       rotation();
   }
    
   public void movement()
   {
        if (((ricerocks) getWorld()).started == true)
        {
            move();
        }
    }
    
    
   public void rotation()
   {
        if (((ricerocks) getWorld()).started == true)
        {
            turn(-2);
        }
   }
}
