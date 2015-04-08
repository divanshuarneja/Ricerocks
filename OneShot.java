import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShootStrategy here.
 * 
 * @author (Khoa Nguyen) 
 * @version (v1.1)
 */
public class OneShot implements ShootStrategy 
{
      public void shoot(World currWorld, Vector movement, int currRotation, int currPosX, int currPosY){
                  missile m1 = new missile(movement, currRotation);
                  currWorld.addObject(m1,currPosX, currPosY);
        }
}
