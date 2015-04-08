import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Ship class. Moves up and down and shoots missiles.
 * 
 * @Team15
 */
public class Ship extends SmoothMover
{
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean thrust = false;
    GreenfootSound g1= new GreenfootSound("thrust.mp3");
    private boolean readSpace = true; 
    private boolean readUp = true; 
    double force = .2;
    double acc1= 2.0;
    double acc2= 0.7;
    int fireType = 0;
    ShootStrategy ss = new OneShot();
    ConcreteLargeRock rgb = new ConcreteLargeRock();
    ConcreteSmallRock rgs = new ConcreteSmallRock();
    
    public void act() 
    {
        if (((ricerocks) getWorld()).started == true)
        {
            
            checkKeys();
            move();
            checkHit();
            
        }
    }
    
    
    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("1"))
        {
           ss = new OneShot();
        }
        
        else if(Greenfoot.isKeyDown("2"))
        {
           ss = new TwoShot();
        }
        
        else if(Greenfoot.isKeyDown("3"))
        {
           ss = new ThreeShot();
        }
           
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-3);
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            turn(3);
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            double force = -.2;
            
            Vector ignite = new Vector (getRotation(), force);
            addForce(ignite);
           
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            double force = .2;
            
            set_thrust(true);
            setImage("ship2.png");
            
            Vector ignite = new Vector (getRotation(), force);
            addForce(ignite);
        }
        else
        {
            set_thrust(false);
            setImage("ship1.png");
        }
            
        
        
        if(!readSpace && !Greenfoot.isKeyDown("space"))
        {
            readSpace=true;
        }
        
        if(Greenfoot.isKeyDown("space") && readSpace)
        {
            shoot();
            readSpace=false;
        }
    }
    public void set_thrust(boolean val)
    {
        thrust = val;
        if (thrust)
        {
            g1.play();
        }
        else
        {
            g1.stop();
        }
    }
    public void setShoot(ShootStrategy ss){
        this.ss = ss;
    }
    public void shoot()
    {
//         missile m = new missile(getMovement().copy(), getRotation());
//         getWorld().addObject(m,getX(), getY());
           ss.shoot(getWorld(), getMovement().copy(), getRotation(), getX(), getY());
    }
    
    public void checkHit()
    {
        Rock a = (Rock) getOneIntersectingObject(Rock.class);
        if (a != null)
        {
            int shipX = 0;
            int shipY = 0;
            
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
            
            Lives.minus(1);
            
            explode();
        }
    }
    public void explode()
    {
       getWorld().addObject( new Explosion(), getX(), getY()); 
       if (Lives.getlife() == 0)
       {
           getWorld().addObject(new Splash(),getWorld().getWidth()/2, getWorld().getHeight()/2);
           ((ricerocks) getWorld()).started= false;
        }
            
    }
       
        
}
