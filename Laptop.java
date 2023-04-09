
public class Laptop extends AppleProducts
{
   //1.Create the getters and Setters
   //2.Create the toString
    
    
    private String processor;
    private String graphicCard; 
    private String keypad;//based language or country
    
    public Laptop(float price, String warranty, float display, int storage, String colour, String name, int stock,  int amountSold, String processor, String graphic, String keypad)
    {
        super(price, warranty, display, storage, colour, name, stock, amountSold, "laptop");
        setProcessor(processor);
        setGraphicCard(graphic);
        setKeypad(keypad);
    }
    //non-polymorphic methods below
    public String getProcessor()
    {
        return this.processor;
    }
    
   public void setProcessor(String processor)
   {
       this.processor = processor;
   } 
    
   public String getGraphicCard()
    {
        return this.graphicCard;
    }
    
   public void setGraphicCard(String graphic)
   {
       this.graphicCard = graphic;
   } 
    
   public String getKeypad()
    {
        return this.keypad;
    }
   
   public void setKeypad(String keypad)
   {
       this.keypad = keypad;
   }
   
   public String toString()
   {
        return (super.toString() + "\n" +
        "Processor: " + this.processor + "\n" +
        "Graphics Card: " + this.graphicCard + "\n" +
        "Keypad Language/Layout: " + this.keypad);
        
        
   }
}
