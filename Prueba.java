import javax.swing.JOptionPane;

public class Prueba {
	public static void main(String[] args) {
		YesNoPanel panelOption = new YesNoPanel();
        int selection = panelOption.createYesNoPanel("Cual es la opción que quieres?", "Elige una opción");
		System.out.println(selection);
	}
}