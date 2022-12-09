import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    GreenfootSound sound;
    GreenfootImage[] images = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer(); 
    public Elephant(){
        sound = new GreenfootSound("elephantcub.mp3");
        
        for(int i = 0; i < images.length; i++)
        {
            images[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            images[i].scale(75,75);
        }
        
        animationTimer.mark();
        
        setImage(images[4]);
        
        
    }
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("d"))
        {
            move(3);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            move(-3);
        }
        
        eat();
        animations();
    
    }
    
    int i = 0;
    public void animations()
    {
        if(animationTimer.millisElapsed() < 500)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(images[i]);
        i++;
        if(i > 7)
        {
            i = 0;
        }
        
        
    }
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            sound.play();
        }
    }
}
