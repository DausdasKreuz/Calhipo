import javax.swing.*;
import java.text.DecimalFormat;

public class CalhipoMain {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
        } catch(Exception e) {
            e.printStackTrace();
        }

        DecimalFormat formatter = new DecimalFormat("####");
        DecimalFormat formatterDecimal = new DecimalFormat("####.##");
        AvaibleDialog aDialog = new AvaibleDialog();
        NotAvaibleDialog nADialog = new NotAvaibleDialog();
        InfoDialog iDialog = new InfoDialog();


        JOptionPane.showMessageDialog(null, "Wellcome to Calhipo calculator!");
        JOptionPane.showMessageDialog(null, "Please, first give me some information");
        User user = new User();

        YesNoPanel houseOptionPanel = new YesNoPanel();
        int houseOption = houseOptionPanel.createYesNoPanel("The house", "Do you know the house you want?");

        if (houseOption == 0) { //conocida la casa
            House house = new House();
            YesNoPanel loanOptionPanel = new YesNoPanel();
            int loanOption = loanOptionPanel.createYesNoPanel("The loan", "Do you know the loan conditions?");

            if (loanOption == 0) { //Condiciones del préstamo conocidas
                Loan loan = new Loan();
                loan.calcInstalment(house.price, house.initial, user.initial);
                house.calcInitial(house.price);
                user.calcIndebtedness(loan.instalment);

                if (user.indebtedness <= loan.maxIndebtedness && house.initial <= user.initial) {
                    user.calcFreeMoney(loan.instalment);
                    aDialog.printMessages(user, loan);
                }

                else {
                    nADialog.printMessages(user, house.initial, loan.maxIndebtedness);
                }
            }

            if (loanOption == 1) { //condiciones del préstamo NO conocidas
                JOptionPane.showMessageDialog(null, "I´m going to calculate with data about loans from internet");
                JOptionPane.showMessageDialog(null, "Differential to euribor 2%; Euribor 0,48%; period 21 years; maximum indebtedness 35%");
                Loan loan = new Loan("Invented", 2, 21, 0.4);
                loan.calcInstalment(house.price, house.initial, user.initial);
                house.calcInitial(house.price);
                user.calcIndebtedness(loan.instalment);

                if (user.indebtedness <= loan.maxIndebtedness && house.initial <= user.initial) {
                    user.calcFreeMoney(loan.instalment);
                    aDialog.printMessages(user, loan);
                }

                else {
                    nADialog.printMessages(user, house.initial, loan.maxIndebtedness);
                }
            }
        }


        if (houseOption == 1) { //Casa NO conocida
            JOptionPane.showMessageDialog(null, "To do the calculations I will use 100 € for the house expenses.");
            YesNoPanel loanOptionPanel = new YesNoPanel();
            int loanOption = loanOptionPanel.createYesNoPanel("The loan", "Do you know the loan conditions?");

            if (loanOption == 0) { //Condiciones del préstamo conocidas
                Loan loan = new Loan();
                House house = new House("Desired", 0, 100, 0);
                house.calcPrice(loan.calcDebt(user.maxInstalment(loan.maxIndebtedness)), user.initial);
                loan.calcInstalment(house.price, house.initial, user.initial);
                house.calcInitial(house.price);
                user.calcIndebtedness(loan.instalment);

                if (user.initial < house.initial) {
                    house.calcPrice(user.initial);
                    house.initial = user.initial;
                }

                user.calcFreeMoney(loan.instalment);
                iDialog.printMessages(user, house.price, loan);
            }

            if (loanOption == 1) { //condiciones del préstamo NO conocidas
                JOptionPane.showMessageDialog(null, "I´m going to calculate with data about loans from internet");
                JOptionPane.showMessageDialog(null, "Differential to euribor 2%; Euribor 0,48%; period 21 years; maximum indebtedness 40%");
                Loan loan = new Loan("Invented", 2, 21, 0.4);
                House house = new House("Desired", 0, 100, 0);

                user.calcIndebtedness(loan.maxIndebtedness);
                loan.instalment = user.maxInstalment(user.indebtedness);
                loan.debt = loan.calcDebt(loan.instalment);
                house.calcPrice(loan.debt, user.initial);
                house.calcInitial(house.price);

                if (user.initial < house.initial) {
                    house.calcPrice(user.initial);
                    house.initial = user.initial;
                }

                loan.calcInstalment(house.price, house.initial, user.initial);
                user.calcIndebtedness(loan.instalment);
                user.calcFreeMoney(loan.instalment);
                iDialog.printMessages(user, house.price, loan);
            }
        }
    }
}
//System.out.printf("%.2f %n", i); //Imprime solo dos decimales






        


//        //Loan
//        JOptionPane.showMessageDialog(null, "And finally the loan data");
//        Loan loan = new Loan();
//        studyOption = JOptionPane.showInputDialog("Please, you want a COMPLETE or SIMPLE study");
//
//        while ((!studyOption.equalsIgnoreCase("complete")) && (!studyOption.equalsIgnoreCase("simple"))) {
//            studyOption = JOptionPane.showInputDialog(null, "Please, indicate one of this options: complete - simple");
//        }
//        
//        JOptionPane.showMessageDialog(null, "Thanks! We are comming the " + studyOption + " study");
//
//        if (studyOption.equalsIgnoreCase("complete")) {
//            loan.calcInstalment();
//            loan.calcInitial(house.price);
//            user.calcPayment(loan.instalment);
//            user.calcNewIndebtedness(loan.instalment);
//            double maxInstalment = user.instalment(0.4);
//            double maxDebt = loan.debt(maxInstalment);
//            double maxPriceInitial = house.priceInitial(user.initial);
//            double maxPrice;
//            if (maxDebt >= maxPriceInitial) {
//                maxPrice = maxDebt;
//            } else {
//                maxPrice = maxPriceInitial;
//            }
//            double betterInstalment = user.instalment(0.30);
//            double betterDebt = loan.debt(betterInstalment);
//            if (maxDebt >= maxPriceInitial) {
//                maxPrice = maxDebt;
//            }
//            else {
//                maxPrice = maxPriceInitial;
//            }
//
//        }
