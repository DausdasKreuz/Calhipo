public class Instalment {
	//Atributos: instalment
	public double instalment;

	public void calcInstalment(int debt, double rate, int period) {
		double pot, num, den;
		pot = Math.pow((1+rate/12/100),(-period*12));
		System.out.println(pot);
		num = debt*(rate/12);
		System.out.println(num);
		den = 100*(1-(pot));
		System.out.println(den);
		instalment = (debt*(rate/12)/(100*(1-(pot))));
		System.out.println(instalment);

	}
}