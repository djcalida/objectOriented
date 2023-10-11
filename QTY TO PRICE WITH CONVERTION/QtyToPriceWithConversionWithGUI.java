import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QtyToPriceWithConversionWithGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Order Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel orderLabel = new JLabel("Choose an Order:");
        panel.add(orderLabel);

        JComboBox<String> orderChoiceBox = new JComboBox<>(new String[]{
                "Jolly Mac Spaghetti with a side of Sardines",
                "Chicken Sandwich in Pandesal",
                "Beef Stick with Broccoli",
                "Sundae Available Every day"
        });
        panel.add(orderChoiceBox);

        JLabel quantityLabel = new JLabel("Quantity:");
        panel.add(quantityLabel);

        JTextField quantityField = new JTextField();
        panel.add(quantityField);

        JLabel resultLabel = new JLabel("Subtotal Price:");
        panel.add(resultLabel);

        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        panel.add(resultField);

        JButton calculateButton = new JButton("Calculate");
        panel.add(calculateButton);

        JButton voidButton = new JButton("Void Order");
        panel.add(voidButton);

        JButton exitButton = new JButton("Exit");
        panel.add(exitButton);

        double totalResult = 0; // Initialize the total result variable
        double[] orderResults = new double[4]; // Initialize an array to store results for each order

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int orderIndex = orderChoiceBox.getSelectedIndex();
                int quantity = Integer.parseInt(quantityField.getText());

                if (orderIndex >= 0 && orderIndex <= 3) {
                    double result = processOrder(orderIndex + 1, quantity);
                    totalResult += result; // Add the result to the total
                    orderResults[orderIndex] += result; // Store the result for the specific order
                    resultField.setText("PHP " + result);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid choice");
                }
            }
        });

        voidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int orderToVoid = orderChoiceBox.getSelectedIndex();
                if (orderToVoid >= 0 && orderToVoid <= 3) {
                    totalResult -= orderResults[orderToVoid]; // Subtract the voided order's result from the total
                    orderResults[orderToVoid] = 0; // Reset the voided order's result to 0
                    resultField.setText("Order voided.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid choice");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double pesoToUsd = totalResult / 56;
                JOptionPane.showMessageDialog(frame, "Total Price: PHP " + totalResult + "\nTotal Price in Dollar: $" + pesoToUsd);
                System.exit(0);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static double processOrder(int choice, int quantity) {
        // Prices of the Items;
        int[] prices = {56, 87, 79, 50};

        if (choice >= 1 && choice <= 4) {
            double result = quantity * prices[choice - 1];
            return result;
        } else {
            return 0;
        }
    }
}
