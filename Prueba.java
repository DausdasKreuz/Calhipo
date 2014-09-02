import java.text.DecimalFormat;

public class Prueba {
    public static void main(String[] args) {
        double result, instalmentFixed, rate,
        period;

        instalmentFixed = 1200;
        rate = 2.48;
        period = 21;

        result = instalmentFixed * (100*(1-(Math.pow((1+rate/12/100),(-period*12))))) / (rate/12);
        System.out.println(result);
    }
}