import java.io.Serializable;
public class AppleProducts implements Serializable

/**
 * Write a description of class AppleProducts here.
 *
 * Name: Ore Adebiyi
 * Student Number: C21360871
 */

{
   //1.Create the superclass
   //2.Create the getters and Setters
   //3.Create the toString
    
   private float price;
   private String warranty;
   private float displaySize; //in inches
   private int storage; // in gb
   private String colour; 
   private String name;
   private int stock; 
   private String type;
   private int amountSold;
   
   public AppleProducts()
    {
        this.price = 0;
        this.warranty ="";
        this.displaySize = 0; 
        this.storage = 0;
        this.colour = "";
        this.name = "";
        this.stock = 0;
        this.amountSold = 0 ;
    }
    
   public AppleProducts(float price, String warranty, float display, int storage, String colour, String name, int stock, int amountSold, String type)
    {
        this.price = price;
        this.warranty = warranty;
        this.displaySize = display; 
        this.storage = storage;
        this.colour = colour;
        this.name = name;
        this.stock = stock;
        this.type = type;
        this.amountSold = amountSold;
    }
    
   public String getType()
    {
        return this.type;
    }
    
   public float getPrice()
    {
        return this.price;
    }
    
   public void setPrice(float price)
   {
       this.price = price;
   } 
    
   public String getWarranty()
    {
        return this.warranty;
    }
    
   public void setWarranty(String warranty)
   {
       this.warranty = warranty;
   } 
    
   public float getDisplaySize()
    {
        return this.displaySize;
    }
   
   public void setDisplaySize(float display)
   {
       this.displaySize = display;
   }
    
   public int getStorage()
    {
        return this.storage;
    }
   
   public void setStorage(int storage)
   {
       this.storage = storage;
   }
   
    public String getColour()
    {
        return this.colour;
    }
    
   public void setColour(String colour)
   {
       this.colour = colour;
   }
    
   public String getName()
    {
        return this.name;
    }
    
   public void setName(String name)
   {
       this.name = name;
   }
   
   public int getStock()
    {
        return this.stock;
    }
    
   public void setStock(int stock)
   {
       this.stock = stock;
   }
   
   public int getAmountSold()
    {
        return this.amountSold;
    }
    
   public void purchase()
   {
       this.amountSold++;
   } 
   
   public void reset()
   {
       this.amountSold = 0;
   } 
   
   public String toString()
   {
       
       return ("---" + this.name + "---\n" +
       "Colour: " + this.colour + "\n" +
       "Price: $" + this. price + "\n" +
       "Storage: " + this.storage + "GB\n" +
       "Display Size: " + this.displaySize  + " Inches\n" +
       "Warranty: " + this.warranty  + "\n" +
       "Stock Level: " + this.stock + "\n" + "Amount Sold: " + this.amountSold);
       
   }
   
}
