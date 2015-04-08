import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShootStrategy here.
 * 
 * @author (Khoa Nguyen) 
 * @version (v1.1)
 */
public interface ShootStrategy
{
    
    public void shoot(World currWold, Vector movement, int currRotation, int currPosX, int currPosY);
}
