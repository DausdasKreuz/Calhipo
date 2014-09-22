import javax.swing.*;
import java.text.DecimalFormat;

public class NotAvaibleDialog {
    DecimalFormat formatter = new DecimalFormat("####");

    public void printMessages(User user, int houseInitial, double indebtedness) {
        JOptionPane.showMessageDialog(null, "I'm so sorry " + user.name + ". You can't buy this house.");
        if (user.initial < houseInitial) {
            JOptionPane.showMessageDialog(null, "To get this house you need " + formatter.format(houseInitial - user.initial) + " more.");
        }

        if (user.indebtedness > indebtedness) {
            JOptionPane.showMessageDialog(null, "The bank need you get more money per month. Exactly " + formatter.format((user.indebtedness - indebtedness) * user.income) + " more.");
        }
    }
}
