import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Missile class. An explosion occurs when it hits the rock
 * 
 * @Team15
 */
public class missile extends SmoothMover implements MissileSubject
{
    /**
     * Act - do whatever the missile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int life = 30;
    ConcreteLargeRock rgb =new ConcreteLargeRock();
    ConcreteSmallRock rgs =new ConcreteSmallRock();
    
    public missile (Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addForce(new Vector(rotation, 15));
        Greenfoot.playSound("missile.mp3");
    }
    
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            checkRockHit();
        }
    }
    
    
    public void checkRockHit()
    {
        Rock a = (Rock) getOneIntersectingObject(Rock.class);
        if (a != null)
        {
            int shipX = 0;
            int shipY = 0;
            
            updateScore(a);
            getWorld().removeObject(a);
            
            try{
                List<Ship> l = getWorld().getObjects(Class.forName("Ship"));
                shipX =((Ship)l.get(0)).getX() ;
                shipY =((Ship)l.get(0)).getY() ;
                System.out.println("Ship X:"+ shipX);
                System.out.println("Ship Y:"+ shipY);
            }catch(Exception e){
                e.printStackTrace();
            }
            int x = Greenfoot.getRandomNumber(getWorld().getWidth());
            int y = Greenfoot.getRandomNumber(getWorld().getHeight());
            //Generating new Rock x and y if it is in radius of the ship 150 pixels 
            while( ((x - shipX)*(x - shipX) + (y - shipY)*(y - shipY) ) < 150*150){
                x = Greenfoot.getRandomNumber(getWorld().getWidth());
                y = Greenfoot.getRandomNumber(getWorld().getHeight());

            }
            //System.out.println("Rock X: " + x);
            //System.out.println("Rock Y: " + y);
            
            int selectRock = Greenfoot.getRandomNumber(2);
            if (selectRock == 0)
            {
                getWorld().addObject(rgs.makeRock("S"), x, y);
            }
            else
            {
                getWorld().addObject(rgb.makeRock("B"), x, y);
            }
            
            explode();
            
           
        }
    }
    
    public void updateScore( Rock a){
    
    int score;
            Score s1 = new Score("Score:"+ Score.sc);
            if (a instanceof SmallRock)
            {
                ScoreInterface s = new SmallDecorator(s1);
                score = s.addScore() ;
                s1.setScore(score);
            }
            else if (a instanceof LargeRock)
            {
                ScoreInterface s = new LargeDecorator(s1);
                score = s.addScore() ;
                s1.setScore(score);
            }
    
    }
    
    public void explode()
    {
        getWorld().addObject( new Explosion(), getX(), getY()); 
        getWorld().removeObject(this);
            
    }
}
