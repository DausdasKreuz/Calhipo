import javax.swing.*;
import java.text.DecimalFormat;

public class Test {

    public static void main (String [] args) {
        DecimalFormat formatterDecimal = new DecimalFormat("####.##");

        //Conocidos prestamo y casa
        User user = new User("yo", 20000, 3000, 1500, 360);
        House house = new House("desiderable", 250000, 100, 0);
        house.calcInitial(house.price);
        Loan loan = new Loan("invented", 1.89, 21, 0.4);

        loan.calcInstalment(house.price, house.initial, user.initial);
        house.calcInitial(house.price);
        user.calcIndebtedness(loan.instalment);

        if (user.indebtedness <= loan.maxIndebtedness && house.initial <= user.initial) {
            user.calcFreeMoney(loan.instalment);
            AvaibleDialog aDialog = new AvaibleDialog();
            aDialog.printMessages(user, loan);

        }
        else {
        }
    }
}
