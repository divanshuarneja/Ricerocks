import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Score Class. Updates the score in the game
 * 
 * @Team15
 */

public class Score extends Actor implements ScoreInterface
{
    public static int sc = 0;
    Level level;
    
    public Score(String text)
    {
        updateImage(text); 
        level = new Level1();
    }  
        
    public void updateImage(String text)  
    {  
        GreenfootImage image = getImage();
        image.clear();
        setImage(new GreenfootImage(text, 20, Color.white, null));
    }  
    
    public void act() 
    {
        updateImage("Score: " + sc );
    }    
    
    public int addScore()
    {
        //sc += 10;
        
        if(sc>100 && sc<500)
            level =new Level2();
        else if (sc>500 && sc<1200)
             level =new Level3();
        else if (sc>1200)
             level =new Level4();
        
        sc += level.addLevelScore();  //initial score depends on the level
        return sc;
    }
    
    public void setScore(int d)
    {
        sc = d;
    }
}
