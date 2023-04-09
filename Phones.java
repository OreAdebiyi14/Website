public class Phones extends AppleProducts
{
   //1.Create the getters and Setters
   //2.Create the toString
    
   private String cameraType;
   
   public Phones(float price, String warranty, float display, int storage, String colour,int stock, String name,  int amountSold, String camera)
    {
        super(price, warranty, display, storage, colour, name, stock, amountSold, "phone");
        setCameraType(camera);
        
    }
    //non-polymorphic methods below
   public String getCameraType()
    {
        return this.cameraType;
    }
    
   public void setCameraType(String camera)
   {
       this.cameraType = camera;
   } 
   
   public String toString()
   {
        return (super.toString() + "\n" +
        "Camera Type: " + this.cameraType);
   }
}
