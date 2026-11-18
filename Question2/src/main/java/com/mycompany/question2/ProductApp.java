package com.mycompany.question2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//  main class 
 
public class ProductApp extends JFrame {

    //  Mattress products available in the combo box
    private static final String[] PRODUCTS = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

    //Line of stars used above and below the details in the text file
    private static final String STARS = "*".repeat(34);

    //Name of the file the details are saved to
    private static final String FILE_NAME = "data.txt";

    // customer name text box, product combo box, price text box
    private final JTextField txtCustomerName = new JTextField(16);
    private final JComboBox<String> cmbProduct = new JComboBox<>(PRODUCTS);
    private final JTextField txtPrice = new JTextField(16);

    public ProductApp() {
        setTitle("Product App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        add(createFormPanel());
        pack();
        setLocationRelativeTo(null);   // apper in the middle of the screen
    }

    
    private JMenuBar createMenuBar() {
        // File menu
        JMenu mnuFile = new JMenu("File");
        JMenuItem mnuExit = new JMenuItem("Exit");
        mnuFile.add(mnuExit);

        // Tools menu
        JMenu mnuTools = new JMenu("Tools");
        JMenuItem mnuProcess = new JMenuItem("Process");
        JMenuItem mnuClear = new JMenuItem("Clear");
        mnuTools.add(mnuProcess);
        mnuTools.add(mnuClear);

        
        mnuExit.addActionListener(e -> System.exit(0));
        mnuProcess.addActionListener(e -> processSale());  
        mnuClear.addActionListener(e -> clearForm());

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        return menuBar;
    }

   
    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);
        gbc.anchor = GridBagConstraints.WEST;

        addRow(panel, gbc, 0, "Customer Name:", txtCustomerName);
        addRow(panel, gbc, 1, "Select Product:", cmbProduct);
        addRow(panel, gbc, 2, "Enter Price:", txtPrice);

       // proccess button will appear across all culmbs 
        JButton btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSale());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnProcess, gbc);

        return panel;
    }

  
    private void addRow(JPanel panel, GridBagConstraints gbc, int row,
                        String labelText, JComponent input) {
        // Label in column 0
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panel.add(new JLabel(labelText), gbc);

        // Input in column 1, stretched to fill the width
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        panel.add(input, gbc);
    }

    
    private void processSale() {
        String customerName = txtCustomerName.getText().trim();
        String productName = (String) cmbProduct.getSelectedItem();

        // The customer name must be captured
        if (customerName.isEmpty()) {
            showError("Please enter the customer name.");
            return;
        }

        // Convert the price to a number; letters or a blank box cannot be converted
        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException e) {
            showError("The price must be a number, e.g. 3500.");
            return;
        }

        if (price <= 0) {
            showError("The price must be greater than 0.");
            return;
        }

        ProductCalculations calculations = new ProductCalculations(price);

        String details = "Customer Name: " + customerName + "\n"
                + "Product: " + productName + "\n"
                + "VAT: R " + calculations.GetVat() + "\n"
                + "COMMISSION: R " + calculations.GetCommission() + "\n"
                + "TOTAL: R " + calculations.GetTotal();

        // Store first, then display
        saveToFile(details);
        JOptionPane.showMessageDialog(this, details, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveToFile(String details) {
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("DATA LOG");
            writer.newLine();
            writer.write(STARS);
            writer.newLine();

            // Write the details one line at a time
            for (String line : details.split("\n")) {
                writer.write(line);
                writer.newLine();
            }

            writer.write(STARS);
            writer.newLine();
        } catch (IOException e) {
            showError("The details could not be saved: " + e.getMessage());
        }
    }

  // Clears the text boxes and sets the combo box selected index to 0.
   
    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
        txtCustomerName.requestFocus();
    }

    // Shows an error massage 
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException e) {
          
        }

       
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
