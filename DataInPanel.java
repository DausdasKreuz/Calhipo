import javax.swing.*;

public class DataInPanel {

   public String createPanel(int gap, int fieldSize, String label, String message) {

    JTextField field = new JTextField(fieldSize);   
    JPanel panel = new JPanel();
    panel.add(Box.createHorizontalStrut(gap));
    panel.add(new JLabel(label));
    panel.add(field);
    panel.add(Box.createHorizontalStrut(gap));
    int result = JOptionPane.showConfirmDialog(null, panel, 
    message, JOptionPane.OK_CANCEL_OPTION);

    //if (result == JOptionPane.OK_OPTION) {
    //} //falta implementar la opción de cancel
    return field.getText();
    }
}

// modificar para que pueda coger un número solicitado de valores
//panel con n ventanas de opción
