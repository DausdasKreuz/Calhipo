import javax.swing.*;

public class CalhipoMain {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
        } catch(Exception e) {
            e.printStackTrace();
        }


        String studyOption;

        
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

                if (user.indebtedness <= 0.40 && house.initial <= user.initial) {
                    JOptionPane.showMessageDialog(null, "Ok! You can buy this house.");
                    user.calcFreeMoney(loan.instalment);
                    JOptionPane.showMessageDialog(null, "You need from the bank: " + loan.debt);
                    JOptionPane.showMessageDialog(null, "Instalment: " + loan.instalment);
                    JOptionPane.showMessageDialog(null, "The new indebtedness: " + user.indebtedness);
                    JOptionPane.showMessageDialog(null, "Money to spend per month: " + user.spendable);
                }
                else {
                    JOptionPane.showMessageDialog(null, "I'm so sorry. You can't buy this house.");
                    if (user.initial < house.initial) {
                        double lack = house.initial - user.initial;
                        JOptionPane.showMessageDialog(null, "To get this house you need " + lack + " more.");
                    }
                    if (user.indebtedness > 0.4) {
                        double lack = (user.indebtedness - 0.4) * user.income;
                        JOptionPane.showMessageDialog(null, "The bank need you get more money per month. Exactly " + lack + " more.");
                    }
                }

            }
            if (loanOption == 1) { //condiciones del préstamo NO conocidas
                JOptionPane.showMessageDialog(null, "Not yet implemented");
            }
        }
        if (houseOption == 1) { //Casa NO conocida
            JOptionPane.showMessageDialog(null, "Not yet implemented");
        }






        


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
//            user.calcIndebtedness(loan.instalment);
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
    }
}
//System.out.printf("%.2f %n", i); //Imprime solo dos decimales