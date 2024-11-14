import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMC {
    private JPanel CalculadoraIMC;
    private JTextField EntradaPeso;
    private JTextField EntradaAltura;
    private JButton ButCalcularPeso;
    private JTextArea ResultadoIMC;
    private JButton ButLimpar;

    public IMC() {
        ButCalcularPeso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesoTexto = EntradaPeso.getText();
                String alturaTexto = EntradaAltura.getText();

                if (isNumeric(pesoTexto) && isNumeric(alturaTexto)) {
                    double peso = Double.parseDouble(pesoTexto);
                    double altura = Double.parseDouble(alturaTexto);
                    double imc = peso / (altura * altura);
                    String categoria;

                    if (imc < 18.5) {
                        categoria = "Baixo peso";
                    } else if (imc < 24.9) {
                        categoria = "Peso normal";
                    } else if (imc < 29.9) {
                        categoria = "Sobrepeso";
                    } else {
                        categoria = "Obesidade";
                    }

                    ResultadoIMC.setText(String.format("Seu IMC é: %.2f - %s", imc, categoria));
                } else {
                    ResultadoIMC.setText("Por favor, insira valores válidos.");
                }
            }
        });

        ButLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntradaPeso.setText("");
                EntradaAltura.setText("");
                ResultadoIMC.setText("");
            }
        });
    }

    private boolean isNumeric(String str) {
        return str != null && str.matches("\\d*(\\.\\d+)?");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setContentPane(new IMC().CalculadoraIMC);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
