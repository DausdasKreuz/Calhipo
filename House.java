public class House {
    //Atributos: price, reform, expense
    public String name;
    public int price;
    public int reform;
    public int expense;
    public double initial;

    public House(String namedata, int pricedata, int reformdata, int expensedata, double initialdata) {
        name = namedata;
        price = pricedata;
        reform = reformdata;
        expense = expensedata;
        initial = initialdata;
    }

    public House() {
        getHouseData();
    }

    public void getHouseData() {
        
        DataInPanel namePanel = new DataInPanel();
        name = namePanel.createPanel(50, 10, "Name", "Please, indicate the house name.");

        DataInPanel pricePanel = new DataInPanel();
        price = Integer.parseInt(pricePanel.createPanel(50, 10, "Price", "How much is the house"));

// Implementar la reforma de la casa: puede que con la
//reforma no pueda comprarse la casa pero
//o solo pueda reformarse parcialmente.
//        YesNoPanel reformOptionPanel = new YesNoPanel();
//            int reformOption = reformOptionPanel.createYesNoPanel("The reform", "Will you do a reform?");
//            if (reformOption == 0) { //Yes
//                DataInPanel reformPanel = new DataInPanel();
//                reform = Integer.parseInt(reformPanel.createPanel(50, 10, "Money to reform", "How much money will you spend to reform the house?"));
//            }
            //if (reformOption == 1) { //No
            //}

        DataInPanel expensePanel = new DataInPanel();
        expense = Integer.parseInt(expensePanel.createPanel(50, 10, "Expense", "How much is the house per month"));
    }
    
    public void calcInitial(double price) {
        initial = price * 0.07 + 2500;
    }   
}