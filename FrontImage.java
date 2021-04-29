import greenfoot.*;
import java.awt.Color;

public class FrontImage extends BackFront
{
  private static GreenfootImage mainimage=new GreenfootImage("GAJAH.png");
  
  public FrontImage()
  {
      
  }
  
  public FrontImage(int i,int j)
  {
      super(i,j);
  }
  
  public void setGambar()
  {
      GreenfootImage image=new GreenfootImage(Width,Width);
      image.setColor(Color.WHITE);
      image.fill();
      image.drawImage(mainimage,-idi*Width,-idj*Width);
      setImage(image);
  }
  
  public void act() 
  {
      // Add your action code here.
  }    
}
