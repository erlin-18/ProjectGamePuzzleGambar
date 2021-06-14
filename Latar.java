import greenfoot.*; 
import java.util.Random;


public class Latar extends World
{
    public BackFront[] backfront=new BackFront[16];
    public FrontImage[] frontimage=new FrontImage[16];
    
    public Latar()
    {    
        super(500, 850, 1,false);
        
        int[] sorting=generateSort(16);
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                backfront[i*4+j]=new BackFront(i,j);
                addObject(backfront[i*4+j],(int)(0.5*getWidth()+(i-1.5)*BackFront.Width),(int)(0.5*getHeight()+(j-4)*BackFront.Width));
                
                int id=sorting[i*4+j];
                int io=id/4;
                int jo=id&4;
                frontimage[id]=new FrontImage(io,jo);
                addObject(frontimage[id],(int)(0.5*getWidth()+(i-1.5)*BackFront.Width),(int)(0.5*getHeight()+(j+0.5)*BackFront.Width));
                frontimage[id].positiono();
            }
        }
   }

   private int [] generateSort(int num)
   {
       int[] result=new int[num];
       Random ran=new Random();
       for(int i=0;i<num;i++){
          int a=ran.nextInt(num);
          boolean ketemu=false;
          for(int j=0;j<i;j++){
              if(a==result[j]){
                  ketemu=true;
                  break;
              }
          }
          if(!ketemu){
              result[i]=a;
          }else i--;
       }
       return result;
   }

   
   public void makeFront(int i,int j)
   {
     int posx=frontimage[i*4+j].getX();
     int posy=frontimage[i*4+j].getY();
     removeObject(frontimage[i*4+j]);
     addObject(frontimage[i*4+j],posx,posy);
   }
}