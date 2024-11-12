import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JTextField Tela;
    private double PrimeiroN = 0;
    private double SegundoN = 0;
    private String operador = "";
    private boolean novoNumero = true;
    private JPanel CalculadoraOP;
    private JButton But0, But1, But2, But3, But4, But5, But6, But7, But8, But9;
    private JButton butSoma, butSubtracao, butMultiplicacao, butDivisao, butIgual, ButLimpar;

    public Calculadora() {
        Tela = new JTextField();
        Tela.setEditable(false);
        Tela.setHorizontalAlignment(JTextField.RIGHT);

        But0 = new JButton("0");
        But1 = new JButton("1");
        But2 = new JButton("2");
        But3 = new JButton("3");
        But4 = new JButton("4");
        But5 = new JButton("5");
        But6 = new JButton("6");
        But7 = new JButton("7");
        But8 = new JButton("8");
        But9 = new JButton("9");
        butSoma = new JButton("+");
        butSubtracao = new JButton("-");
        butMultiplicacao = new JButton("*");
        butDivisao = new JButton("/");
        butIgual = new JButton("=");
        ButLimpar = new JButton("C");

        ActionListener numeroListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numero = ((JButton) e.getSource()).getText();
                if (novoNumero) {
                    Tela.setText(numero);
                    novoNumero = false;
                } else {
                    Tela.setText(Tela.getText() + numero);
                }
            }
        };

        But0.addActionListener(numeroListener);
        But1.addActionListener(numeroListener);
        But2.addActionListener(numeroListener);
        But3.addActionListener(numeroListener);
        But4.addActionListener(numeroListener);
        But5.addActionListener(numeroListener);
        But6.addActionListener(numeroListener);
        But7.addActionListener(numeroListener);
        But8.addActionListener(numeroListener);
        But9.addActionListener(numeroListener);

        ActionListener operadorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador = ((JButton) e.getSource()).getText();
                PrimeiroN = Double.parseDouble(Tela.getText());
                novoNumero = true;
            }
        };

        butSoma.addActionListener(operadorListener);
        butSubtracao.addActionListener(operadorListener);
        butMultiplicacao.addActionListener(operadorListener);
        butDivisao.addActionListener(operadorListener);

        butIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SegundoN = Double.parseDouble(Tela.getText());
                double resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = PrimeiroN + SegundoN;
                        break;
                    case "-":
                        resultado = PrimeiroN - SegundoN;
                        break;
                    case "*":
                        resultado = PrimeiroN * SegundoN;
                        break;
                    case "/":
                        if (SegundoN != 0) {
                            resultado = PrimeiroN / SegundoN;
                        } else {
                            Tela.setText("Erro: Div/0");
                            return;
                        }
                        break;
                }
                Tela.setText(String.valueOf(resultado));
                novoNumero = true;
            }
        });

        ButLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tela.setText("");
                PrimeiroN = 0;
                SegundoN = 0;
                operador = "";
                novoNumero = true;
            }
        });

        CalculadoraOP = new JPanel();
        CalculadoraOP.setLayout(new BorderLayout());
        CalculadoraOP.add(Tela, BorderLayout.NORTH);
        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(4, 4));
        botoes.add(But7);
        botoes.add(But8);
        botoes.add(But9);
        botoes.add(butDivisao);
        botoes.add(But4);
        botoes.add(But5);
        botoes.add(But6);
        botoes.add(butMultiplicacao);
        botoes.add(But1);
        botoes.add(But2);
        botoes.add(But3);
        botoes.add(butSubtracao);
        botoes.add(But0);
        botoes.add(butSoma);
        botoes.add(butIgual);
        botoes.add(ButLimpar);
        CalculadoraOP.add(botoes, BorderLayout.CENTER);

        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(CalculadoraOP);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
