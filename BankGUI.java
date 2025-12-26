import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankGUI extends JFrame {

    private double balance;
    private JLabel balanceLabel;
    private JTextField amountField;

    public BankGUI() {
        super("Bank Account Application");

        // Ask user for initial balance
        String input = JOptionPane.showInputDialog("Enter initial bank account balance:");
        balance = Double.parseDouble(input);

        // Panel to display balance
        JPanel balancePanel = new JPanel();
        balanceLabel = new JLabel("Current Balance: $" + balance);
        balancePanel.add(balanceLabel);

        // Panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField(10);
        inputPanel.add(amountField);

        // Buttons
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton showBalanceButton = new JButton("Show Balance");

        // Add ActionListeners
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                balance += amount;
                updateBalance();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                if (amount <= balance) {
                    balance -= amount;
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds!");
                }
                updateBalance();
            }
        });

        showBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateBalance();
            }
        });

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(showBalanceButton);

        // Add panels to frame
        setLayout(new GridLayout(3, 1));
        add(balancePanel);
        add(inputPanel);
        add(buttonPanel);

        // Window settings
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Print final balance on exit
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Final Balance: $" + balance);
            }
        });

        setVisible(true);
    }

    private void updateBalance() {
        balanceLabel.setText("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        new BankGUI();
    }
}

