import greenfoot.*;
import java.awt.Color;
public class FrontImage extends BackFront
{
    private static GreenfootImage mainimage=new GreenfootImage("butterfly.png");
    
    private boolean drag=false;
    private int rx=0,ry=0;
    
    public BackFront  backfront;
    private int posox,posoy;
    
    public FrontImage()
    {
        
    }
    
    public FrontImage(int i,int j)
    {
        super(i,j);
    }
    
    public void positiono()
    {
        posox=getX();posoy=getY();
    }
    
    public void setGambar()
    {
        GreenfootImage image=new GreenfootImage(Width,Width);
        image.setColor(Color.WHITE);
        image.fill();
        image.drawImage(mainimage,-idi*Width,-idj*Width);
        setImage(image);
    }
    
    public void makefront()
    {
        ((Latar)getWorld()).makeFront(idi,idj);
    }
    
    public void checkBackFront()
    {
       Actor actor=getOneObjectAtOffset(0,0,BackFront.class);
       if(actor!=null){
           ((BackFront)actor).setCyan();
       }
    }
        
    public void Bound()
    {
         Actor actor=getOneObjectAtOffset(Width,Width,BackFront.class);
       if(actor!=null){
           BackFront back=((BackFront)actor);
           if(back.frontimage==null){
               backfront=back;
               backfront.frontimage=this;
               setLocation(backfront.getX(),backfront.getY());
           }
       }
    }
    
    public void act() 
    {
       if(Greenfoot.mouseDragged(this)){
           MouseInfo mouse=Greenfoot.getMouseInfo();
           if(!drag) {
               if(backfront!=null){
                   backfront.frontimage=null;
                   backfront=null; 
               }
               makefront();
               drag=true; 
               rx=getX()-mouse.getX();
               ry=getY()-mouse.getY();
           }else{
               setLocation(mouse.getX()+rx,mouse.getY()+ry);
               checkBackFront();
           }
       }    
       if(Greenfoot.mouseDragEnded(this)){
           Bound();
           drag=false;
       }
       if(!drag && backfront==null){
           int xo=getX(),yo=getY();
           int d=5;
           if(posox!=getX()){
               if(posox>xo)xo=(Math.abs(posox-xo)>d)?xo+=d:posox;
               else xo=(Math.abs(posox-xo)>d)?xo-=d:posox;
           }
           if(posoy!=getY()){
               if(posoy>yo)yo=(Math.abs(posoy-yo)>d)?yo+=d:posoy;
               else yo=(Math.abs(posoy-yo)>d)?yo-=d:posoy;
           }
           setLocation(xo,yo);
       }
    }
}

           
           
