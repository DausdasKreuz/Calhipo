import javax.swing.*;
import java.text.DecimalFormat;

public class InfoDialog {
     DecimalFormat formatter = new DecimalFormat("####");

     public void printMessages(User user, int housePrice, Loan loan) {
         JOptionPane.showMessageDialog(null, "Done. " + user.name + ", the most expensive house you can buy costs " + housePrice + " Euros.");
         JOptionPane.showMessageDialog(null, "You need from " + loan.bank + " bank: " + formatter.format(loan.debt));
         JOptionPane.showMessageDialog(null, "Instalment: " + loan.instalment);
         JOptionPane.showMessageDialog(null, "Your new indebtedness: " + formatter.format(user.indebtedness));
         JOptionPane.showMessageDialog(null, "Money to spend per month: " + formatter.format(user.spendable));
    }
}
