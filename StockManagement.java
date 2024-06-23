import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StockManagement {
    private static Product[] products;
    
    public static void main(String[] args) throws Exception{
    	int menuChoice;
    	LocalDate date = LocalDate.now(); // Create a date object
        LocalTime time = LocalTime.now(); // Create a time object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = time.format(formatter);
        System.out.println("\n----------------------------------------------------------------------");
		System.out.println("*************** Welcome to the Stock Management System ***************");
        System.out.print("********************** DATE:");
        System.out.print(date + " " + formattedTime);  // Display the current date + time
        System.out.print(" **********************");
        System.out.println(" ");
		System.out.println("\t\t\t\t 1.Chin Kah Jun ");
		System.out.println("\t\t\t\t 2.Ong Zhi Yin ");
		System.out.println("\t\t\t\t 3.See Keng Lek ");
		System.out.println("\t\t\t\t 4.Tan Rui Zheng ");
		System.out.println("----------------------------------------------------------------------");
        
        Scanner scanner = new Scanner(System.in);
        UserInfo user = new UserInfo();
        user.setName();
        String userID = user.getUserID();
        String name = user.getName();

        // Option for add stock
        int addStockopt;
        do {
            try {
                System.out.print("Do you wish to add stock? (1 for yes, 0 for no): ");
                addStockopt = scanner.nextInt();
                break; // If the input is valid, exit the loop
            } catch (InputMismatchException e) {
                // If the input is invalid, clear the scanner buffer and display an error message
                System.out.println("Invalid input, please enter an integer value (0 or 1).");
                scanner.next();
            }
        } while (true);

        if (addStockopt == 1) {
            int max = getMaxProducts(scanner);
            products = new Product[max];
            try {
                for(int i=0; i<max;i++) {
                    addNewProduct(products, scanner);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(products.length!=0) {
                do {
                    menuChoice = getMenuChoice(scanner);
                    executeMenu(menuChoice, products, scanner);
                } while(menuChoice!=0);
            }
            else {
                System.out.println("The product list is empty, exiting the program");
            }
        }
        else {
            System.out.println("Exiting...");
        }
        System.out.println("User ID: " + userID + "\nName: " + name);
        System.out.println("Thanks for using the program " + userID + ". See you again");
        
        scanner.close();
    }
    
    public static int getMaxProducts(Scanner scanner) {
    	int maxProducts = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print("Enter the maximum number of products you want to manage: ");
                maxProducts = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // consume the invalid input
            }
        } while (!validInput);
        return maxProducts;
    }
    

    public static int getMenuChoice(Scanner scanner) {

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. View products");
            System.out.println("2. Add stock");
            System.out.println("3. Deduct stock");
            System.out.println("4. Discontinue product");
            System.out.println("0. Exit");
            System.out.print("Please enter a menu option: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 0 && choice <= 4) {
                    scanner.nextLine();
                    return choice;
                }
            }
            System.out.println("Invalid input. Please enter a number between 0 and 5.");
            scanner.nextLine();
        }
    }


    public static int displayProducts(Product[] products, Scanner scanner) {
    	System.out.println("Available products:");
        int i = 1;
        for (Product p : products) {
            if (p != null) {
                System.out.printf("%d. %s%n", i, p.getproductName());
                i++;
            }
        }
        int choice;
        do {
            System.out.print("Please choose a product (0 to exit): ");
            try {
                choice = scanner.nextInt();
                if (choice < 0) {
                    System.out.println("Please enter a positive number or 0 to exit.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // clear scanner buffer
                choice = -1; // set choice to an invalid value to trigger loop
            }
        } while (choice < 0 || choice > products.length);
        return choice;
    }
    

    public static void addStock(Product[] products, Scanner scanner) {
    	int choice = displayProducts(products, scanner);
    		if (choice == 0) {
    			return;
    		}
    		int quantity;
    		do {
    			System.out.print("How many products do you wish to add? ");
    			while (!scanner.hasNextInt()) {
    				System.out.print("Please enter a positive integer: ");
    				scanner.next();
    			}
    			quantity = scanner.nextInt();
    		} while (quantity < 0);
    		products[choice - 1].setavailableQuantity(products[choice - 1].getavailableQuantity() + quantity);
    		System.out.printf("%d %s added to stock.%n", quantity, products[choice - 1].getproductName());
    }


    public static void deductStock(Product[] products, Scanner scanner) {
        int choice = displayProducts(products, scanner);
        if (choice == 0) {
            return;
        }
        int quantity;
        do {
            System.out.printf("How many %s do you wish to deduct? ", products[choice - 1].getproductName());
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a positive integer: ");
                scanner.next();
            }
            quantity = scanner.nextInt();
        } while (quantity < 0 || quantity > products[choice - 1].getavailableQuantity());
        products[choice - 1].setavailableQuantity(products[choice - 1].getavailableQuantity() - quantity);
        System.out.printf("%d %s deducted from stock.%n", quantity, products[choice - 1].getproductName());
    }
    
    
    public static void setProductStatus(Product[] products, Scanner scanner) {
    	int productChoice;
        do {
            System.out.println("Please select a product to discontinue:");
            productChoice = displayProducts(products, scanner) - 1;
            if (productChoice < 0) {
                System.out.println("Invalid choice. Please select a product again.");
            }
        } while (productChoice < 0);

        System.out.print("Set the status of the product (1-Active, 2- Discontinue): ");
        int statusChoice = scanner.nextInt();
        if (statusChoice == 1) {
            products[productChoice].setproductStatus(true);
            System.out.println(products[productChoice].getproductName() + " has been activated.");
        } else if (statusChoice == 2) {
            products[productChoice].setproductStatus(false);
            System.out.println(products[productChoice].getproductName() + " has been discontinued.");
        } else {
            System.out.println("Invalid choice. Please choose 1 for Active or 2 for Discontinue.");
        }
    }
    
    
    public static void executeMenu(int choice, Product[] products, Scanner scanner) {
            switch (choice) {
                case 1:
                    displayProducts(products);
                    break;
                case 2:
                    addStock(products, scanner);
                    break;
                case 3:
                    deductStock(products, scanner);
                    break;
                case 4:
                	setProductStatus(products, scanner);
                    break;
                case 0:
                	System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        
    }
    
    public static void addNewProduct(Product[] products, Scanner scanner) {
    	while (true) {
            System.out.println("Available Product");
            System.out.println("1. Refrigerator");
            System.out.println("2. TV");
            System.out.println("3. Printer");
            System.out.println("4. Monitor");
            System.out.print("Please choose the product you want to add: ");
            try {
            int input = scanner.nextInt();
            int choice = 0;
            if (input!=0) { 
                choice = input;
                if (choice < 1 || choice > 4) {
                    System.out.println("Only number 1, 2, 3, 4 allowed!");
                    continue;
                }
            } else {
                System.out.println("Invalid input!");
                continue;
            }
            if (choice == 1) {
                addRefrigerator(products, scanner);
            } else if (choice == 2) {
                addTV(products, scanner);
            }
            else if (choice == 3) {
                addPrinter(products, scanner);
            }
            else if (choice == 4) {
                addMonitor(products, scanner);
            }
            break;
        }catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.next();
        }
    	}
    }

    public static void addRefrigerator(Product[] products, Scanner scanner) {
        System.out.println("Please enter the following information for the refrigerator:");
        scanner.nextLine(); // clear input buffer
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Door Design: ");
        String doorDesign = scanner.nextLine();
        
        System.out.print("Color: ");
        String color = scanner.nextLine();
        
        System.out.print("Capacity (in Litres): ");
        double capacity = scanner.nextDouble();
        
        System.out.print("Quantity in stock: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        
        System.out.print("Item number: ");
        int itemNumber = scanner.nextInt();
        products[itemNumber - 1] = new Refrigerator(itemNumber, name, quantity, price,true, doorDesign, color, capacity);
        // add the refrigerator to the products array
    }

    public static void addTV(Product[] products, Scanner scanner) {
        System.out.println("Please enter the following information for the TV:");
        scanner.nextLine(); // clear input buffer
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Screen type: ");
        String screenType = scanner.nextLine();
        
        System.out.print("Resolution: ");
        int resolution = scanner.nextInt();
        
        System.out.print("Display size: ");
        int displaySize = scanner.nextInt();
        
        System.out.print("Quantity in stock: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        
        System.out.print("Item number: ");
        int itemNumber = scanner.nextInt();
        products[itemNumber-1] = new TV(itemNumber, name, quantity, price,true, screenType, resolution, displaySize);
        // add the TV to the products array
    }
    public static void addPrinter(Product[] products, Scanner scanner) {
        System.out.println("Please enter the following information for the Printer:");
        scanner.nextLine(); // clear input buffer
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Paper Size: ");
        String maxPaperSize = scanner.nextLine();
        
        System.out.print("Color: ");
        String color = scanner.nextLine();
        
        System.out.print("Resolution: ");
        int maxResolution = scanner.nextInt();
        
        System.out.print("Paper Tray capacity: ");
        int paperTrayCapacity = scanner.nextInt();
        
        System.out.print("Quantity in stock: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        
        System.out.print("Item number: ");
        int itemNumber = scanner.nextInt();
        products[itemNumber-1] = new Printer(itemNumber, name, quantity, price,true, maxPaperSize, maxResolution, color, paperTrayCapacity);
        // add the TV to the products array
    }

    public static void addMonitor(Product[] products, Scanner scanner) {
        System.out.println("Please enter the following information for the Monitor:");
        scanner.nextLine(); // clear input buffer
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Screen type: ");
        String screenType = scanner.nextLine();
        
        System.out.print("Panel type: ");
        String panelType = scanner.nextLine();
        
        System.out.print("Resolution: ");
        int resolution = scanner.nextInt();
        
        System.out.print("Refresh rate: ");
        int refreshRate = scanner.nextInt();
        
        System.out.print("Response Time: ");
        int responseTime = scanner.nextInt();
        
        System.out.print("Display size: ");
        int displaySize = scanner.nextInt();
        
        System.out.print("Quantity in stock: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        
        System.out.print("Item number: ");
        int itemNumber = scanner.nextInt();
        products[itemNumber-1] = new Monitor(itemNumber, name, quantity, price,true, screenType, panelType, resolution, refreshRate, responseTime, displaySize);
        // add the Monitor to the products array
    }
    
    
    
    public static void displayProducts(Product[] products) {
		System.out.println();
		for (int i = 0; i < products.length; i++){
			System.out.println("Index Number:" + (i) );
			System.out.println(products[i].toString());
			System.out.println();
        }
    }
}
