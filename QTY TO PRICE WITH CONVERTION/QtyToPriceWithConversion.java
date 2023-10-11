import java.util.Scanner;

public class QtyToPriceWithConversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalResult = 0; // Initialize the total result variable
        double[] orderResults = new double[4]; // Initialize an array to store results for each order

        while (true) {
            System.out.println("\nChoose an Order: ");
            System.out.println("1. Jolly Mac Spaghetti with a side of Sardines");
            System.out.println("2. Chicken Sandwich in Pandesal");
            System.out.println("3. Beef Stick with Broccoli");
            System.out.println("4. Sundae Available Every day");
            System.out.println("5. Void Order");
            System.out.println("6. Exit");

            int orderChoice = scan.nextInt();

            if (orderChoice == 6) {
                break; // Exit the loop if the user chooses option 6
            }

            if (orderChoice == 5) {
                System.out.print("Enter the order number to void (1-4): ");
                int orderToVoid = scan.nextInt();
                
                if (orderToVoid >= 1 && orderToVoid <= 4) {
                    totalResult -= orderResults[orderToVoid - 1]; // Subtract the voided order's result from the total
                    orderResults[orderToVoid - 1] = 0; // Reset the voided order's result to 0
                    System.out.println("Order " + orderToVoid + " voided.");
                } else {
                    System.out.println("Invalid order number.");
                }
                
                continue; // Continue to the next iteration of the loop
            }

            double result = processOrder(orderChoice, scan);

            if (result > 0) {
                totalResult += result; // Add the result to the total
                orderResults[orderChoice - 1] += result; // Store the result for the specific order
                System.out.println("Subtotal Price: " + result);
            }
        }
        
        System.out.println("Total Price: PHP" + totalResult); // Print the total price after exiting the loop
        double pesoToUsd = totalResult / 56;
        System.out.println("Total Price in Dollar: $" + pesoToUsd);
    }

    public static double processOrder(int choice, Scanner scan) {
        int quantity;
        double result = 0;

        // Prices of the Items;
        int spaghetti = 56;
        int chicken = 87;
        int beef = 79;
        int sundae = 50;

        switch (choice) {
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
                result = quantity * beef; // Calculate the total price for option 3
                break;
            case 4:
                System.out.print("How many pieces of Sundae: ");
                quantity = scan.nextInt();
                result = quantity * sundae; // Calculate the total price for option 4
                break;
            default:
                System.out.println("Invalid choice");
        }

        return result;
    }
}
