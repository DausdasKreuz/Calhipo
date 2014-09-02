public class House {
    //Atributos: price, reform, expense
    public String name;
    public int price;
    public int expense;
    public int initial;

    public House(String namedata, int pricedata, int expensedata, int initialdata) {
        name = namedata;
        price = pricedata;
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

        DataInPanel expensePanel = new DataInPanel();
        expense = Integer.parseInt(expensePanel.createPanel(50, 10, "Expense", "How much is the house per month"));
    }
    
    public void calcInitial(int price) {
        initial = (int) (price * 0.07 + 2500);
    }

    public void calcPrice(double debt, int initialUser) {
        price = (int) ((debt - 2500 + initialUser) / 1.07);
    }

    public void calcPrice(int initial) {
        price = (int) (initial - 2500 / 0.07);
    }
}


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
