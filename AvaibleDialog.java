import javax.swing.*;
import java.text.DecimalFormat;

public class AvaibleDialog {
    DecimalFormat formatter = new DecimalFormat("####");

    public void printMessages(User user, Loan loan) {
        JOptionPane.showMessageDialog(null, "Ok " + user.name + "! You can buy this house.");
        JOptionPane.showMessageDialog(null, "You need from " + loan.bank + " bank: " + formatter.format(loan.debt));
        JOptionPane.showMessageDialog(null, "Instalment: " + loan.instalment);
        JOptionPane.showMessageDialog(null, "Your new indebtedness: " + formatter.format(user.indebtedness));
        JOptionPane.showMessageDialog(null, "Money to spend per month: " + formatter.format(user.spendable));
    }

}
