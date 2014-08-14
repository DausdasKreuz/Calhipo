public class User {
    //Atributos: name, initial, income, expenses, indebtedness
    public String name;
    public int initial;
    public double income;
    public int expenses;
    public double instalments;
    public double indebtednessBefore;
    public double indebtedness;
    public double spendable;

    public User(String namedata, int initialdata, double incomedata, int expensesdata, double instalments, double indebtednessdata) {
        name = namedata;
        initial = initialdata;
        income = incomedata;
        expenses = expensesdata;
        indebtedness = indebtednessdata;
    }

    public User() {
        getUserData();
    }

    public void getUserData() {
        DataInPanel namePanel = new DataInPanel();
        name = namePanel.createPanel(50, 10, "Name", "Please enter your name");
        
        DataInPanel initialPanel = new DataInPanel();
        initial = Integer.parseInt(initialPanel.createPanel(50, 10, "Initial", "How much money do you have to spend in a house?"));

        DataInPanel incomePanel = new DataInPanel();
        income = Double.parseDouble(initialPanel.createPanel(50, 10, "Income", "How much money do you get per month?"));

        DataInPanel expensesPanel = new DataInPanel();
        expenses = Integer.parseInt(initialPanel.createPanel(50, 10, "Expenses", "How much money do you spend per month?"));        

        DataInPanel instalmentsPanel = new DataInPanel();
        instalments = Double.parseDouble(instalmentsPanel.createPanel(50, 10, "Instalments", "How much money do you pay in instalments?"));
        
        indebtednessBefore = (instalments / income);
    }

    public void calcFreeMoney(double instalment) {
        spendable = income - expenses - instalment;
    }

    public void calcIndebtedness(double instalment) {
        indebtedness = indebtednessBefore + instalment / income;
    }

    public double instalment(double indebtednessFixed) {
        return (indebtednessFixed * income) - expenses;
    }
}