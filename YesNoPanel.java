import javax.swing.*;

public class YesNoPanel {

    public int createYesNoPanel(String title, String message) {
        
        int selection = JOptionPane.showOptionDialog(
        null, // ¿Componente padre? en el ejemplo venía con  this. Preguntar a Miguel
        message, //Mensaje
        title, // Título
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null, // null para icono por defecto.
        new Object[] {"Yes", "No"}, // null para YES, NO y CANCEL
        "Yes");

        return selection;

        //En el ejemplo venía con estos if
        //if (selection != -1) {
        //  if((selection + 1)==1) { // PRESIONO SI
        //        return selection + 1;
        //    }
        //    else { // PRESIONO NO
        //        return selection + 1;
        //    }
        //}
    }
}