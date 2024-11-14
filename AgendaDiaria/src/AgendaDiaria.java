import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class AgendaDiaria {
    private JPanel main;
    private JTextField EntradaCompromisso;
    private JSpinner Data;
    private JButton ButAdicionar;
    private JSpinner Hora;
    private JButton ButRemover;
    private JTable Tela;

    private DefaultTableModel tableModel;




    public AgendaDiaria() {
        tableModel = new DefaultTableModel(new Object[]{"Compromisso", "Data", "Hora"}, 0);
        Tela.setModel(tableModel);

        SpinnerDateModel dataModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        Data.setModel(dataModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(Data, "dd/MM/yyyy");
        Data.setEditor(dateEditor);

        SpinnerDateModel horaModel = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
        Hora.setModel(horaModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(Hora, "HH:mm");
        Hora.setEditor(timeEditor);




        ButAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String compromisso = EntradaCompromisso.getText();
                Date dataEscolhida = (Date) Data.getValue();
                Date horaEscolhida = (Date) Hora.getValue();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat stf = new SimpleDateFormat("HH:mm");

                if (!compromisso.isEmpty()) {
                    tableModel.addRow(new Object[]{compromisso, sdf.format(dataEscolhida), stf.format(horaEscolhida)});
                }
            }
        });

        ButRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = Tela.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                }
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

        Tela.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setContentPane(new AgendaDiaria().main);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
