import greenfoot.*; 

 
public class Latar extends World
{
    public BackFront[] backfront=new BackFront[16];
    
    public Latar()
    {
        super(600, 600, 1,false);
        
        for(int i=0;i<4;i++){
           for(int j=0;j<4;j++){ 
               backfront[i*4+j]=new BackFront(i,j);
               addObject(backfront[i*4+j],(int)(0.5*getWidth()+(i-1.5)*BackFront.Width),(int)(0.5*getHeight()+(j-3)*BackFront.Width));
            }
        }
    }
}
 

    
    

