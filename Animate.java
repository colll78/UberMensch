import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Animate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animate extends Actor{
    
    Random rand = new Random();
  
    public void remove(){
        getWorld().addObject(new Dead() , this.getX() , this.getY());
        getWorld().removeObject(this);
    
    }
    
    // dropRate is percent change 1-100
    public void drop(Actor obj,int dropRate){
        int dCheck = rand.nextInt(100) + 1;
        if( dCheck <= dropRate ){
        World world = getWorld();
        world.addObject(obj, this.getX(), this.getY()); 
        }
    }
}
