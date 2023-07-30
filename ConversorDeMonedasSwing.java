import javax.swing.JOptionPane;

public class ConversorDeMonedasSwing {
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            String[] opciones = { "Conversión de Monedas", "Conversión de Temperatura", "Conversión de Kilometraje", "Salir" };
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el tipo de conversión:",
                    "Conversor Múltiple",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            if (opcionSeleccionada != null) {
                switch (opcionSeleccionada) {
                    case "Conversión de Monedas":
                        realizarConversionMonedas();
                        break;
                    case "Conversión de Temperatura":
                        realizarConversionTemperatura();
                        break;
                    case "Conversión de Kilometraje":
                        realizarConversionKilometraje();
                        break;
                    case "Salir":
                        continuar = false;
                        break;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Programa Terminado", "Terminado", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void realizarConversionMonedas() {
        double tasaUSDtoEUR = 0.85;
        double tasaUSDtoCOP = 3600;
        double tasaUSDtoJPY = 110.0;

        String[] opciones = { "USD a EUR", "USD a COP", "USD a JPY" };
        String opcionSeleccionada = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la conversión:",
                "Conversor de Monedas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (opcionSeleccionada != null) {
            String cantidadStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad en USD:");
            if (cantidadStr != null && !cantidadStr.isEmpty()) {
                try {
                    double cantidadUSD = Double.parseDouble(cantidadStr);
                    double resultado = 0.0;
                    String monedaDestino = "";

                    if (opcionSeleccionada.equals("USD a EUR")) {
                        resultado = cantidadUSD * tasaUSDtoEUR;
                        monedaDestino = "EUR";
                    } else if (opcionSeleccionada.equals("USD a COP")) {
                        resultado = cantidadUSD * tasaUSDtoCOP;
                        monedaDestino = "COP";
                    } else if (opcionSeleccionada.equals("USD a JPY")) {
                        resultado = cantidadUSD * tasaUSDtoJPY;
                        monedaDestino = "JPY";
                    }

                    String mensaje = String.format("%.2f USD equivalen a %.2f %s.", cantidadUSD, resultado, monedaDestino);
                    JOptionPane.showMessageDialog(null, mensaje, "Resultado de Conversión", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida en USD.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad en USD.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void realizarConversionTemperatura() {
        String[] opciones = { "Celsius a Fahrenheit", "Fahrenheit a Celsius" };
        String opcionSeleccionada = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la conversión:",
                "Conversor de Temperatura",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (opcionSeleccionada != null) {
            String cantidadStr = JOptionPane.showInputDialog(null, "Ingrese la temperatura:");
            if (cantidadStr != null && !cantidadStr.isEmpty()) {
                try {
                    double temperatura = Double.parseDouble(cantidadStr);
                    double resultado = 0.0;

                    if (opcionSeleccionada.equals("Celsius a Fahrenheit")) {
                        resultado = celsiusToFahrenheit(temperatura);
                        JOptionPane.showMessageDialog(null, temperatura + " °C equivalen a " + resultado + " °F.", "Resultado de Conversión", JOptionPane.INFORMATION_MESSAGE);
                    } else if (opcionSeleccionada.equals("Fahrenheit a Celsius")) {
                        resultado = fahrenheitToCelsius(temperatura);
                        JOptionPane.showMessageDialog(null, temperatura + " °F equivalen a " + resultado + " °C.", "Resultado de Conversión", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese una temperatura válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una temperatura.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void realizarConversionKilometraje() {
        double kmPorMillas = 1.60934;

        String cantidadStr = JOptionPane.showInputDialog(null, "Ingrese la distancia en millas:");
        if (cantidadStr != null && !cantidadStr.isEmpty()) {
            try {
                double millas = Double.parseDouble(cantidadStr);
                double kilometros = millas * kmPorMillas;
                JOptionPane.showMessageDialog(null, millas + " millas equivalen a " + kilometros + " kilómetros.", "Resultado de Conversión", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese una distancia válida en millas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una distancia en millas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
