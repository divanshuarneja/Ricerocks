import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Lives class. Updates the lives of the ship.
 * 
 * @Team15
 */

public class Lives extends Actor
{
    public static int life = 3;
    
    public Lives(String text)
    {
        updateImage(text);  
    }  
        
    public void updateImage(String text)  
    {  
        GreenfootImage image = getImage();
        image.clear();
        setImage(new GreenfootImage(text, 20, Color.white, null));
    }  
    
    public void act() 
    {
        updateImage("Lives: " + life );
    }    
    
    public static void minus(int num)
    {
        life -= num;
    } 
    
    public static int getlife()
    { 
        return life;
    }
}
