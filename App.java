package sg.edu.nus.iss;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public final class App 
{
private App(){

}

public static void main(String[] args) {
    String dirPath = "\\data2"; 
    String filename = ""; 

    File newDirectory = new File (dirPath); 
    if (newDirectory.exists()){
        System.out.println("Directory already exists");
    } else {
        newDirectory.mkdir(); 
    }
    System.out.println("Welcome to my shopping cart");

    List<String> cartItems = new ArrayList<String>(); 

    Console con = System.console(); 
    String input = "";  

    while(!input.equals("quit")){
        input = con.readLine("What do you want to perform? (Type 'quit' to exit program"); 
    } 

    switch(input){
        case "help":
        displayMessage("'list' to show a list of items in shopping cart");
        displayMessage("'login <name>' to access your shopping cart"); 
        displayMessage("'add <item>' to add items into your shopping cart"); 
        displayMessage("'delete <item #>'");  
        displayMessage("'quit' to exit this program"); 
        break; 
        
        case "list":
        if(cartItems.size()>0){
            for(String item: cartItems){
                System.out.printf(item);
            }
        } else {
            displayMessage("your cart is empty");
        }
        break; 

        case "users":
        break; 
        default: 
    }

    if (input.startsWith("add")){
        input = input.replace(',', ' '); 
        String strValue = ""; 
        Scanner scanner = new Scanner (input.substring(4)); 

        while(scanner.hasNext()){
            strValue = scanner.next(); 
            cartItems.add(strValue); 
        }
    }
}

    public static void displayMessage (String message){
        System.out.println(message);
    }

}

