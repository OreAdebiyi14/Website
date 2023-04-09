import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

//Student name = Oreoluwa Adebiyi
//Student number = C21360871

public class AppleDriver
{
    //3.Create the array list 
    //3.2Create the menus
    //4. Create the data file
    
    ArrayList <AppleProducts> listOfProducts;
    Scanner scan = new Scanner(System.in);
    public AppleDriver ()
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("\f");
        listOfProducts = new ArrayList<AppleProducts>();

        if (readFromFile())
        {
            System.out.println("System has loaded all products available");
        }
        else
        {
            System.out.println("There are no products available in this system");

        }
        scan.nextLine();
        Menu();

        saveToFile();

        
        System.out.println("\f");
        System.out.println("(All Products have been saved)");
    }
    
    //Copy Stock from a data file into the program
    //Save stock from the program into a data file
    public void saveToFile()
    {
        ObjectOutputStream fileOut;

        try{
            fileOut = new ObjectOutputStream(new FileOutputStream("AppleProducts.dat"));
            scan.nextLine();
            for (AppleProducts p: listOfProducts)
            {
                fileOut.writeObject(p);
            }
            fileOut.close();
            System.out.println("All products have been saved");
        }
        catch (IOException e)
        {
            System.out.println("IO Error : " + e.getMessage());

        }
    }

    public boolean readFromFile()
    {
        
        ObjectInputStream fileIn;
        AppleProducts p;
        int index = 0;
        try{
            fileIn = new ObjectInputStream(new FileInputStream("AppleProducts.dat"));
            System.out.println("Opened file successfully");
            p = (AppleProducts)fileIn.readObject();
            index = 1;
            while (p != null)
            {
                listOfProducts.add(p);
                p = (AppleProducts) fileIn.readObject();
                index++;
            }
            fileIn.close();
            return true;
        }
        catch (IOException e)
        {
            if (index > 0)
            {
                return true;
            }
            else
            {
                System.out.println("Data file does not exist\n");
                return false;
            }

        }
        catch (ClassNotFoundException e)//can only read a class (phone or laptop or apple products)
        {
            System.out.println("--- Error : " + e.getMessage() + "---");
            return false;
        }
    }

    public void Menu()
    {
        //3.2.1 Create the menu to call other menus
        //3.2.1.1 Ask user to input a number
        //3.2.1.2 Execute the option
        
        Scanner scan = new Scanner(System.in);
        boolean menu = true;
        int option;

        do
        {
            System.out.println("\f");
            System.out.println("--- Please choose an Option from the staff menu ---");
            System.out.println("1) Staff Menu ");
            System.out.println("2) Customer Menu");
            System.out.println("3) Exit Menu");

            option = scan.nextInt();
            scan.nextLine();

            switch(option)
            {
                case 1:
                    StaffMenu();
                    break;
                case 2:
                    CustomerMenu();
                    break;
                case 3:
                    System.out.println("\f");
                    System.out.println("--- Thank you for purchasing a product from Apple ---");
                    System.out.println("----- We hope you like the product -----");
                    menu = false;
                    break;
                default:
                    System.out.print("Error - Option can only be between 1-3");
                    break;
            }
        }while(menu );

    }

    public void StaffMenu()
    {
        //3.2.2 Create the staff menu
        //3.2.2.1 Allow staff to input a number
        //3.2.2.2.1 Create option 1 - phone
        //3.2.2.2.2 Create option 2 - laptop
        //3.2.2.2.3 Create option 3 - locate an item
        //3.2.2.2.4 Create option 4 - update stock
        //3.2.2.2.5 Create option 5 - special offer
        //3.2.2.2.6 Create option 6 - reset the week
        //3.2.2.2.7 Create option 7 - exit menu 
        //Display messages
        Scanner scan = new Scanner(System.in);
        boolean menu = true;
        int option;
        do
        {
            scan.nextLine();
            System.out.println("\f");
            System.out.println("--- Please choose an Option from the staff menu ---");
            System.out.println("1) Add Phone - to add all details and it's stock level");
            System.out.println("2) Add Laptop - to add all details and it's stock level");
            System.out.println("3) Find an item - by its name");
            System.out.println("4) To increase stock level by name");
            System.out.println("5) Special - Staff Discount on selected items");
            System.out.println("6) Reset the amount of products sold ");
            System.out.println("7) Exit (Press enter to return to the main menu)");
            option = scan.nextInt();

            switch(option)
            {
                case 1:
                    phone();
                    break;
                case 2:
                    laptop();
                    break;
                case 3:
                    locateItem();
                    break;
                case 4:
                    updateStock();
                    break;  
                case 5:
                    Special();
                    break;
                case 6:
                    ResetWeek();
                    break;
                case 7:
                    menu = false;
                    break;
                default:
                    System.out.print("Error - Option chosen can only be between 1-7");
                    break;
            }
            scan.nextLine();
        }while(menu);

    }

    public void CustomerMenu()
    {
        Scanner scan = new Scanner(System.in);
        boolean menu = true;
        int option;
        do
        {
            System.out.println("\f");
            System.out.println("--- Please choose a Menu Option ---");
            System.out.println("1) View products available");
            System.out.println("2) Purchase a product ");
            System.out.println("3) Exit (Press enter to return to main menu)");
            option = scan.nextInt();
            switch(option)
            {
                case 1:
                    ViewProducts();
                    break;
                case 2:
                    PurchaseProduct();
                    break; 
                case 3:
                    menu = false;
                    break;
                default:
                    System.out.print("ERROR - Option choosen is wrong can only be between 1 & 3");
                    break;
            }

        }while(menu);

    }

    public void phone()
    {
        //3.2.2 Create the customer menu
        //3.2.2.1 Allow customer to input a number 1-3
        //3.2.2.2.1 Create option 1 - view products
        //3.2.2.2.2 Create option 2 - purchase products
        //3.2.2.2.3 Create option 3 - exit menu
        //Display messages
        
        Scanner scan = new Scanner(System.in);
        String name , colour , warranty , camera , topItem;
        float price;
        float display;
        int storage , stock , items;
        Phones phone1;

        System.out.print("\f");
        System.out.println("-- Please create a phone and add the stock level for the item --");

        System.out.println("How many items do you want to add");
        items = scan.nextInt(); scan.nextLine();

        System.out.print("\f");
        for (int count = 0; count < items; count++)
        {
            System.out.print("Please input item name: ");
            name = scan.nextLine();

            System.out.print("Please input a price for the item: ");
            price = scan.nextFloat(); scan.nextLine();

            System.out.print("Please input the display size: ");
            display = scan.nextFloat(); scan.nextLine();

            System.out.print("Please input the storage available for the item: ");
            storage = scan.nextInt(); scan.nextLine();

            System.out.print("Please input the colours available for the item: ");
            colour = scan.nextLine();

            System.out.print("Please input the stock available for the item: ");
            stock = scan.nextInt(); scan.nextLine();

            System.out.print("Please input the warranty available for the item: ");
            warranty = scan.nextLine();

            System.out.print("Please input the camera type: ");
            camera = scan.nextLine();

            System.out.print("\n\n");

            phone1 = new Phones(price, warranty , display , storage , colour , stock , name , 0, camera);
            listOfProducts.add(phone1);
        }
        System.out.print("---- You have now created an item ---- ");
        scan.nextLine();
    }

    public void laptop()
    {
        Scanner scan = new Scanner(System.in);
        String name , colour , warranty , camera , processor , graphic , keypad;
        float price; 
        float display;
        int storage , items;
        int stock;
        Laptop laptop1;

        System.out.print("\f");
        System.out.println("-- Please create a laptop and add the stock level for the item --");

        System.out.println("How many items do you want to add?");
        items = scan.nextInt(); scan.nextLine();
        System.out.print("\f");
        for (int count = 0; count < items; count++)
        {
            System.out.print("Please input item name: ");
            name = scan.nextLine();

            System.out.print("Please input a price for the item: ");
            price = scan.nextFloat(); scan.nextLine();

            System.out.print("Please input the display size: ");
            display = scan.nextFloat(); scan.nextLine();

            System.out.print("Please input the storage available for the item: ");
            storage = scan.nextInt(); scan.nextLine();

            System.out.print("Please input the colours available for the item: ");
            colour = scan.nextLine();

            System.out.print("Please input the stock available for the item: ");
            stock = scan.nextInt(); scan.nextLine();

            System.out.print("Please input the warranty available for the item: ");
            warranty = scan.nextLine();

            System.out.print("Please input the Processor: ");
            processor = scan.nextLine();

            System.out.print("Please input the graphic card: ");
            graphic = scan.nextLine();

            System.out.print("Please input the keypad option (country / language): ");
            keypad = scan.nextLine();

            System.out.print("\n\n");

            laptop1 = new Laptop(price , warranty , display , storage , colour , name , stock , 0 , processor , graphic , keypad);
            listOfProducts.add(laptop1);

        }
        System.out.print("---- You have now created an item ---- ");
        scan.nextLine();
    }

    public void locateItem()
    {
        //Ask user to input product name
        //Get products location with the name 
        //If item is not found show error message
        //If item found then product is displayed
        Scanner scan = new Scanner(System.in);
        String name;
        int item;

        System.out.println("\f");
        System.out.print("Please input a product name: ");
        name = scan.nextLine();

        item = getAppleProductsLocation(name);

        if (item == -1)
        {
            System.out.println("Error - Product inputed is not in the system, please try again");
        }
        else
        {
            System.out.println(listOfProducts.get(item).toString());

        }
        scan.nextLine();
    }

    public int getAppleProductsLocation (String name)
    {
        for (int i = 0 ; i < listOfProducts.size(); i++)
        {
            if (name.equalsIgnoreCase(listOfProducts.get(i).getName()) )
            {
                return i;
            }
        }

        return -1;
    }

    public void updateStock()
    {
        //Display message 
        //Ask user to input a name
        //Get products location by name inputted
        //Askuser to input quantity
        //Get item then get the stock of the item and add it to the quantity
        //Display message
        
        System.out.println("\f");
        Scanner scan = new Scanner(System.in);
        System.out.println("A delivery of new stock has arrived for one of the items\n");

        String name;
        int quantity;  
        int stock;
        int item;
        AppleProducts stock1;

        do
        {
            System.out.println("Please input an item name to change the stock level: ");
            name = scan.nextLine();

            item = getAppleProductsLocation(name);

            if (item == -1)
            {
                System.out.print("Error - Product inputed is not in the system, please try again");
            }
            else
            {
                System.out.println("\nInput the quantity: ");
                quantity = scan.nextInt();   scan.nextLine();

                stock = listOfProducts.get(item).getStock() + quantity;
                System.out.println("\n\nThe stock level was updated for: " + listOfProducts.get(item).getName());
                System.out.println("The new Stock Level for " + listOfProducts.get(item).getName() + " is " + stock);

                listOfProducts.get(item).setStock(stock);
                System.out.println("The delivery was succesful");
            }
            scan.nextLine();
        }  while(item == -1);
        scan.nextLine();
    }  

    public void ViewProducts()
    {
        //Get the products from the list of products
        //Display the details of each products
        
        System.out.println("\f");

        for(AppleProducts p: listOfProducts)
        {
            System.out.println(p.toString());
            System.out.println("\n\n");
            scan.nextLine();

        }

    }

    public int TopItem()
    {
        //gets the amount sold from list of products
        //if amount sold is > current record
        //current record equals amount sold
        //records position of amount sold
        int currentRecord  = 0;
        int recordsPosition = 0;

        for (int i = 0 ; i < listOfProducts.size(); i++)
        {
            if (listOfProducts.get(i).getAmountSold() > currentRecord) 
            {
                currentRecord = listOfProducts.get(i).getAmountSold();
                recordsPosition = i;
            } 
        }

        return(recordsPosition);
    }

    public void ResetWeek()
    {
        //Display message
        //get stock from list of products
        //reset stock to origanl amount
        //get reset week from superclass
        //display message with new amount sold
        //display messages
        
        System.out.println("\f");

        String sold;
        int stock;

        System.out.println("Do you want to reset the amount sold this week (yes / no)");
        sold = scan.nextLine();

        if (sold.equalsIgnoreCase("Yes"))
        {
            for(AppleProducts p: listOfProducts)
            {
                stock = p.getStock() + p.getAmountSold();
                p.setStock(stock);
                
                p.reset();
                
                System.out.println(p.getName() + " has the amount sold reset to " + p.getAmountSold() + "\n\n");
            }   
            System.out.println("Amount of Products sold this week has been resetted");
            System.out.println("To purchase an item please go to the menu");
        }
        else 
        {
                System.out.print("To return to main menu please press enter");
        }

        
    }
    
    
        public void PurchaseProduct()
        {
            //ask user to input product name
            // get product location with name
            //if item is not found display error message
            //if item is found then change stock level
            //if stock level is > 0 then stock level is decreased by 1
            //get item from list then set stock to new stock level
            //display messages
            //else display no stock available
            
            Scanner scan = new Scanner(System.in);

            String name , colour;
            int item;

            int position = TopItem();
            System.out.println("\f");

            System.out.println("-------------Top Item Sold this Week--------------");
            System.out.println(listOfProducts.get(position).toString());
            System.out.println("---------------------------\n\n");

            System.out.print("Please input the product that you want to purchase: ");
            name = scan.nextLine();

            item = getAppleProductsLocation(name);

            if (item == -1)
            {
                System.out.print("Error - Product inputed is not in the system");
            }
            else
            {
                int stockLevel = listOfProducts.get(item).getStock();

                if(stockLevel > 0)
                {
                    stockLevel = stockLevel-1;
                    listOfProducts.get(item).setStock(stockLevel);
                    listOfProducts.get(item).purchase();
                    System.out.println("\f");
                    
                    System.out.print("Please enter the colour you want:");
                    colour = scan.nextLine();
                    
                    System.out.println("\f");
                    
                    System.out.println("Product was purchased successfully");
                    System.out.println("-- Thank for buying the "+ name + " in " + colour + " --");
                }
                else
                {
                    System.out.println("ERROR - There is no stock available for item wanted");
                }

            }
            scan.nextLine();

        }

        public void Special()
        {
            //Ask if they want the deal
            //if yes continue
            //get stock from list 
            //if stock  is > 0 stock decreases by 1 
            // amount sold increases by 1
            //display messages
            //multiply price by 45% and set the price
            //display messages
            //get price from list and reser it to origanal price
            //if no display messages
            
            System.out.println("\f");
            Scanner scan = new Scanner(System.in);
            String deal , name , accesories;
            String colour , case1 , case2 , case3;
            int item;
            float price;
            AppleProducts colour1;

            int position = TopItem();

            System.out.println("-------------Top Item Sold this Week--------------");
            System.out.println(listOfProducts.get(position).toString());
            System.out.println("---------------------------\n\n");

            System.out.println("You get a discount of 45% on any Iphone");
            System.out.print("Please enter 'yes' or 'no' if you want to continue with this deal:");
            deal = scan.nextLine();

            System.out.println("\n\n");

            if(deal.equalsIgnoreCase("Yes"))
            {
                System.out.print("Please enter the product you want: ");
                name = scan.nextLine();

                item = getAppleProductsLocation(name);

                int stockLevel = listOfProducts.get(item).getStock();

                if(stockLevel > 0)
                {
                    stockLevel = stockLevel - 1;
                    listOfProducts.get(item).setStock(stockLevel);
                    listOfProducts.get(item).purchase();
                }

                System.out.print("Please enter the colour you want: ");
                colour = scan.nextLine();

                System.out.println("You have now chosen your colour"); 
                colour = scan.nextLine();

                System.out.print("Do you want to buy a phone case? (yes/no):");
                case1 = scan.nextLine();
                System.out.print("Do you want a screen protector? (yes/no):");
                case2 = scan.nextLine();
                System.out.print("Do you want to buy a charger? (yes/no):");
                case3 = scan.nextLine();

                price = listOfProducts.get(item).getPrice();

                price = price * 45/100;

                listOfProducts.get(item).setPrice(price);

                System.out.println("\f");

                System.out.println("The discount has been applied \n");

                System.out.println("Product bought is: " + name);
                System.out.println("Product colour is: " + colour);
                System.out.println("The price is now: " + price);
                System.out.println("Phone case included: " + case1);
                System.out.println("Screen protector included: " + case2);
                System.out.println("Charger included: " + case3);

                System.out.println("---- Product has been bought successfully ----");

                price = listOfProducts.get(item).getPrice();
                price = (price * 100) / 45;
                listOfProducts.get(item).setPrice(price);
            }
            else
            {
                System.out.print("Please press enter to return to the staff menu");
            }
            scan.nextLine();
        }

        public static void main(String[] args)
        {
            new AppleDriver();
        }
}

