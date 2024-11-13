import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AgendaDiaria {
    private JPanel AgendaDiaria;
    private JTextField Compromisso;
    private JSpinner Data;
    private JButton ButAdicionar;
    private JButton ButRemover;
    private JTable TelaDeCoisas;
    private JSpinner Hora;




    public AgendaDiaria() {
        Compromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        TelaDeCoisas.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });


        ButRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        ButAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        Data.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });


        Hora.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });




    }

    public static void main(String[] args){

        JFrame frame = new JFrame("Aplicativo de notas");
        frame.setContentPane(new AgendaDiaria().AgendaDiaria);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
