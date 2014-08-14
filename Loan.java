public class Loan {
    //Atributos: debt, differential, euribor, rate, period, bank, initial
    public String bank;
    public double debt;
    public double differential;
    private static double euribor;
    public double rate;
    public int period;
    public double instalment;

    public Loan(String bankdata, int debtdata, double differentialdata, int perioddata) {
        bank = bankdata;
        debt = debtdata;
        differential = differentialdata;
        period = perioddata;
    }

    public Loan() {
        getLoanData();
    }

    public void getLoanData() {
        DataInPanel bankPanel = new DataInPanel();
        bank = bankPanel.createPanel(50, 10, "Bank", "Enter the name of the bank (loan identification)");

        //DataInPanel debtPanel = new DataInPanel();
        //debt = Integer.parseInt(debtPanel.createPanel(50, 10, "Debt", "How much money you need from the bank?"));

        DataInPanel differentialPanel = new DataInPanel();
        differential = Double.parseDouble(differentialPanel.createPanel(50, 10, "Differential", "Differential to apply to Euribor"));

        DataInPanel periodPanel = new DataInPanel();
        period = Integer.parseInt(periodPanel.createPanel(50, 10, "Period", "How many years is the period?"));

        if (euribor == 0.0) {
            DataInPanel euriborPanel = new DataInPanel();
        euribor = Double.parseDouble(euriborPanel.createPanel(50, 4, "Euribor", "It is needed the Euribor value"));
        putEuribor(euribor);
        }
    }

    public void putEuribor(double euribordata) {
        euribor = euribordata;
        rate = euribor + differential;
    }

    public double giveEuribor() {
        return euribor;
    }

    public void calcInstalment(int price, double initialCosts, int initialUser) {
        debt = price + initialCosts - initialUser;
        //double pot;
        //pot = Math.pow((1+rate/12/100),(-period*12));
        instalment = (debt*(rate/12)/(100*(1-(Math.pow((1+rate/12/100),(-period*12))))));
    }

    public double debt(double instalmentFixed) {
        return instalmentFixed * (100*(1-(Math.pow((1+rate/12/100),(-period*12))))) / (rate/12);
    }
}