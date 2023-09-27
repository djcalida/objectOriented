import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QtyToPriceWithConversionWithGUI {
    private static double totalResult = 0; // Initialize the total result variable
    private static JTextField quantityField;
    private static JTextArea resultTextArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        
        JLabel orderLabel = new JLabel("Choose an Order:");
        panel.add(orderLabel);
        
        JComboBox<String> orderComboBox = new JComboBox<>(new String[] {
            "Jolly Mac Spaghetti with a side of Sardines",
            "Chicken Sandwich in Pandesal",
            "Beef Stick with Broccoli",
            "Sundae Available Every day"
        });
        panel.add(orderComboBox);
        
        JLabel quantityLabel = new JLabel("Quantity:");
        panel.add(quantityLabel);
        
        quantityField = new JTextField();
        panel.add(quantityField);
        
        JButton calculateButton = new JButton("Calculate");
        panel.add(calculateButton);
        
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        panel.add(resultTextArea);
        
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateOrder(orderComboBox.getSelectedIndex());
            }
        });
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    private static void calculateOrder(int selectedIndex) {
        int quantity = 0;
        double result = 0;
        int[] prices = {56, 87, 79, 50}; // Prices of the items
        
        try {
            quantity = Integer.parseInt(quantityField.getText());
        } catch (NumberFormatException e) {
            resultTextArea.setText("Invalid quantity.");
            return;
        }
        
        if (quantity < 0) {
            resultTextArea.setText("Quantity cannot be negative.");
            return;
        }
        
        if (selectedIndex >= 0 && selectedIndex < prices.length) {
            result = quantity * prices[selectedIndex];
            totalResult += result;
            resultTextArea.setText("Subtotal Price: " + result + "\nTotal Price: " + totalResult);
        } else {
            resultTextArea.setText("Invalid choice.");
        }
    }
}
