import java.util.Scanner;

public class QtyToPriceWithConversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalResult = 0; // Initialize the total result variable

        while (true) {
            System.out.println("\nChoose an Order: ");
            System.out.println("1. Jolly Mac Spaghetti with a side of Sardines");
            System.out.println("2. Chicken Sandwich in Pandesal");
            System.out.println("3. Beef Stick with Broccoli");
            System.out.println("4. Sundae Available Everyday");
            System.out.println("5. Exit");
            
            int orderChoice = scan.nextInt();
            
            if (orderChoice == 5) {
                break; // Exit the loop if the user chooses option 3
            }
            
            int quantity;
            double result = 0;
            //Prices of the Items;
            int spaghetti = 56;
            int chicken = 87;
            int beef = 79;
            int sundae = 50;
            
            switch (orderChoice) {
                case 1:
                    System.out.print("How many pieces of Jolly Mac Spaghetti: ");
                    quantity = scan.nextInt();
                    result = quantity * spaghetti; // Calculate the total price for option 1
                    break;
                case 2:
                    System.out.print("How many pieces of Chicken Sandwich: ");
                    quantity = scan.nextInt();
                    result = quantity * chicken; // Calculate the total price for option 2
                    break;
                case 3:
                    System.out.print("How many pieces of Beef Sticks: ");
                    quantity = scan.nextInt();
                    result = quantity * beef; // Calculate the total price for option 2
                    break;
                case 4:
                    System.out.print("How many pieces of Sundae: ");
                    quantity = scan.nextInt();
                    result = quantity * sundae; // Calculate the total price for option 2
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            if (result > 0) {
                totalResult += result; // Add the result to the total
                System.out.println("Subtotal Price: " + result);
            }
        }

        System.out.println("Total Price: " + totalResult); // Print the total price after exiting the loop
    }
}
