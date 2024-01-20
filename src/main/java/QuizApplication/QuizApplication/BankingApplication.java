package QuizApplication.QuizApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BankingApplication extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    JLabel label;
    JTextField amountField;
    JButton btnDeposit, btnWithdraw, btnCheckBalance, btnExit;
    double balance = 0;

    BankingApplication(String s) {
        super(s);
        label = new JLabel("Balance: $" + balance);
        amountField = new JTextField();
        btnDeposit = new JButton("Deposit");
        btnWithdraw = new JButton("Withdraw");
        btnCheckBalance = new JButton("Check Balance");
        btnExit = new JButton("Exit");

        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnCheckBalance.addActionListener(this);
        btnExit.addActionListener(this);

        add(label);
        add(amountField);
        add(btnDeposit);
        add(btnWithdraw);
        add(btnCheckBalance);
        add(btnExit);

        label.setBounds(30, 40, 200, 20);
        amountField.setBounds(30, 80, 200, 20);
        btnDeposit.setBounds(30, 120, 100, 30);
        btnWithdraw.setBounds(150, 120, 100, 30);
        btnCheckBalance.setBounds(30, 160, 200, 30);
        btnExit.setBounds(30, 200, 100, 30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(300, 300);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDeposit) {
            try {
                double depositAmount = Double.parseDouble(amountField.getText());
                balance += depositAmount;
                updateBalance();
            } catch (NumberFormatException ex) {
                showError("Invalid input for deposit amount");
            }
        } else if (e.getSource() == btnWithdraw) {
            try {
                double withdrawAmount = Double.parseDouble(amountField.getText());
                if (withdrawAmount <= balance) {
                    balance -= withdrawAmount;
                    updateBalance();
                } else {
                    showError("Insufficient funds");
                }
            } catch (NumberFormatException ex) {
                showError("Invalid input for withdrawal amount");
            }
        } else if (e.getSource() == btnCheckBalance) {
            showBalance();
        } else if (e.getSource() == btnExit) {
            exitApplication();
        }
    }

    private void updateBalance() {
        label.setText("Balance: $" + balance);
    }

    private void showBalance() {
        JOptionPane.showMessageDialog(this, "Current Balance: $" + balance);
    }

    private void exitApplication() {
        JOptionPane.showMessageDialog(this, "Thank you for using the Banking Application!");
        System.exit(0);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new BankingApplication("Simple Banking App");
    }
}
