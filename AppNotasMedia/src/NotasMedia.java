import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class NotasMedia {
    private JButton ButAdicionarNota;
    private JTextArea ExibirNotas;
    private JButton ButCalcularMedia;
    private JTextField EntradaNotas;
    private JLabel AprovadoOuReprovado;
    private JLabel AppNotas;
    private JLabel AddNotas;
    private JPanel main;



    private final ArrayList<Double> notas;



    public NotasMedia() {
        notas = new ArrayList<>();



        ButAdicionarNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double nota = Double.parseDouble(EntradaNotas.getText());
                    notas.add(nota);
                    ExibirNotas.append(nota + "\n");
                    EntradaNotas.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico.");
                }
            }
        });



        ButCalcularMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhuma nota foi inserida.");
                    return;
                }

                double soma = 0;
                for (double nota : notas) {
                    soma += nota;
                }
                double media = soma / notas.size();
                String resultado = media >= 7 ? "Aprovado" : "Reprovado";
                AprovadoOuReprovado.setText("Média: " + media + " - " + resultado);
            }
        });
    }



    public static void main(String[] args){

        JFrame frame = new JFrame("Aplicativo de notas");
        frame.setContentPane(new NotasMedia().main);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    }

