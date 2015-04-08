import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ricerocks World. Add objects to the world.
 * 
 * @Team 15
 */
public class ricerocks extends World
{
    public boolean started = false;
    private Score scoreCounter;
    private Lives liveCount;
    /**
     * Constructor for objects of class ricerocks.
     * 
     */
    public ricerocks()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        
        addObject(new Ship() , 450, 300);
        addRocks(6);
        
        if (started == false)
        {
            addObject(new Splash(),getWidth()/2, getHeight()/2);
            
            scoreCounter = new Score("Score: 0");
            addObject(scoreCounter, 800, 50);
        
            liveCount = new Lives("Lives: 3");
            addObject(liveCount, 50, 50);
        }
        
    }
    
    private void addRocks(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            int selectRock = Greenfoot.getRandomNumber(2);
            
            if (selectRock == 0)
            {
                addObject(new SmallRock(), x, y);
            }
            else
            {
                addObject(new LargeRock(), x, y);
            }
        }
    } 

}
