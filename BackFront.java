import greenfoot.*;
import java.awt.Color;

public class BackFront extends Actor
{
    protected int idi=0,idj=0;
    public static int Width=75;
    
    public FrontImage frontimage;
    
    private Color backcolor=new Color(75,75,75);
    private int jeda=0;
    
    public BackFront()
    {
        
    }
    
    public BackFront(int i,int j)
    {
        idi=i;idj=j;
    }
    
    public void addedToWorld(World Latar)
    {
        setGambar();
    }
    
    public void setCyan()
    {
        jeda=10;
        backcolor=Color.CYAN;
        setGambar();
    }
    
    public void setGambar()
    {
       GreenfootImage image=new GreenfootImage(Width,Width);
       image.setColor(backcolor);
       image.fill();
       image.setColor(Color.CYAN);
       if(idi==0 && idj==0){
           image.drawRect(0,0,image.getWidth()-1,image.getHeight()-1);
       }else{
          if(idi==0 && idj>0){
               image.drawRect(0,-1,image.getWidth()-1,image.getHeight()-1); 
          }else if(idj==0 && idi>0){
               image.drawRect(-1,0,image.getWidth()-1,image.getHeight()-1);
          }else{
              image.drawRect(-1,-1,image.getWidth()-1,image.getHeight()-1);
          }
       }
        
       setImage(image);
       
    }
    
    public boolean checkTempel()
    {
        return (frontimage==null);
    }
    
    public void act() 
    {
        if(jeda>0)jeda--;
        if(jeda==1){
            backcolor=new Color(75,75,75);
            setGambar();
        }    
    }
}    
