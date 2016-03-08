import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

/**
 * Write a description of class Marine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Marine extends AI{
    
    public boolean deleteMe = false;
    double time =0;
    public int mSpeed = 4;
    public Bar hpBar;
    
    public Marine(){
        hpBar = new Bar("Marine","Health", 100, 100);
    }
    
    /**
     * Act - do whatever the Marine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        move(mSpeed);
        checkWorld();
        randomTurn();
        shoot();
        remove();
    }  
    
    public void shoot(){
        if (time % 60 ==0 ){
          getWorld().addObject(new Bullet(getRotation()),getX() ,getY() );    
        }
        time++;
    }
    
    public void remove(){
         if(hpBar.getValue() == hpBar.getMinimumValue()){
             ZMarine zm = new ZMarine();       
             getWorld().addObject(zm , getX() , getY() );
             Dead d = new Dead();
             getWorld().addObject(d,getX(),getY());
             drop (new Life() ,  25);
             Zombie.marinesEaten++;
             getWorld().removeObject(this);
         }
    }
}