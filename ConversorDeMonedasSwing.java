import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ConversorDeMonedasSwing extends JFrame {
    private JLabel labelResultado;
    private JTextField campoCantidad;
    private JButton botonConvertir;
    private JComboBox<String> comboMonedas;
    private double tasaUSDToEUR;
    private double tasaUSDToCOP;
    private double tasaUSDToCLP;
    private double tasaUSDToMXN;
    private double tasaUSDToBRL;
    private double tasaUSDToBOB;
    private double tasaUSDToVEF;

    public ConversorDeMonedasSwing() {
        tasaUSDToEUR = 0.85;  // Tasa de cambio fija para USD a EUR (1 USD = 0.85 EUR)
        tasaUSDToCOP = 3600;  // Tasa de cambio ficticia para USD a COP (1 USD = 3600 COP)
        tasaUSDToCLP = 800;   // Tasa de cambio ficticia para USD a CLP (1 USD = 800 CLP)
        tasaUSDToMXN = 20;    // Tasa de cambio ficticia para USD a MXN (1 USD = 20 MXN)
        tasaUSDToBRL = 5;     // Tasa de cambio ficticia para USD a BRL (1 USD = 5 BRL)
        tasaUSDToBOB = 7;     // Tasa de cambio ficticia para USD a BOB (1 USD = 7 BOB)
        tasaUSDToVEF = 2800;  // Tasa de cambio ficticia para USD a VEF (1 USD = 2800 VEF)

        setTitle("Conversor de Monedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        labelResultado = new JLabel("Resultado: ");
        campoCantidad = new JTextField(10);
        botonConvertir = new JButton("Convertir");
        comboMonedas = new JComboBox<>(new String[]{
                "USD a EUR", "USD a COP", "USD a CLP", "USD a MXN",
                "USD a BRL", "USD a BOB", "USD a VEF"
        });

        botonConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirMoneda();
            }
        });

        add(new JLabel("Cantidad: "));
        add(campoCantidad);
        add(comboMonedas);
        add(botonConvertir);
        add(labelResultado);

        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    public void convertirMoneda() {
        String seleccion = (String) comboMonedas.getSelectedItem();
        double cantidad = Double.parseDouble(campoCantidad.getText());
        double resultado;

        DecimalFormat df = new DecimalFormat("#,##0.00");

        if (seleccion.equals("USD a EUR")) {
            resultado = cantidad * tasaUSDToEUR;
            labelResultado.setText("Resultado: " + df.format(cantidad) + " USD equivalen a " + df.format(resultado) + " EUR.");
        } else if (seleccion.equals("USD a COP")) {
            resultado = cantidad * tasaUSDToCOP;
            labelResultado.setText("Resultado: " + df.format(cantidad) + " USD equivalen a " + df.format(resultado) + " COP.");
        } else if (seleccion.equals("USD a CLP")) {
            resultado = cantidad * tasaUSDToCLP;
            labelResultado.setText("Resultado: " + df.format(cantidad) + " USD equivalen a " + df.format(resultado) + " CLP.");
        } else if (seleccion.equals("USD a MXN")) {
            resultado = cantidad * tasaUSDToMXN;
            labelResultado.setText("Resultado: " + df.format(cantidad) + " USD equivalen a " + df.format(resultado) + " MXN.");
        } else if (seleccion.equals("USD a BRL")) {
            resultado = cantidad * tasaUSDToBRL;
            labelResultado.setText("Resultado: " + df.format(cantidad) + " USD equivalen a " + df.format(resultado) + " BRL.");
        } else if (seleccion.equals("USD a BOB")) {
            resultado = cantidad * tasaUSDToBOB;
            labelResultado.setText("Resultado: " + df.format(cantidad) + " USD equivalen a " + df.format(resultado) + " BOB.");
        } else if (seleccion.equals("USD a VEF")) {
            resultado = cantidad * tasaUSDToVEF;
            labelResultado.setText("Resultado: " + df.format(cantidad) + " USD equivalen a " + df.format(resultado) + " VEF.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConversorDeMonedasSwing conversor = new ConversorDeMonedasSwing();
                conversor.setVisible(true);
            }
        });
    }
}
