import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;



public class CadastroContatos {
    private JPanel CadastroDeContatos;
    private JLabel Cadastrodecontatos;
    private JTextField EntradaNome;
    private JTextField EntradaTelefone;
    private JTextField EntradaEmail;
    private JButton ButAdicionar;
    private JList<String> listContatos;
    private JButton ButRemover;

    private DefaultListModel<String> listModel;
    private List<Contato> contatos;




    public CadastroContatos() {
        listModel = new DefaultListModel<>();
        listContatos.setModel(listModel);
        contatos = new ArrayList<>();




        ButAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = EntradaNome.getText().trim();
                String telefone = EntradaTelefone.getText().trim();
                String email = EntradaEmail.getText().trim();

                if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    Contato contato = new Contato(nome, telefone, email);
                    contatos.add(contato);
                    listModel.addElement(contato.toString());
                    limparCampos();
                }
            }
        });


        ButRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listContatos.getSelectedIndex();
                if (selectedIndex != -1) {
                    contatos.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um contato para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    private void limparCampos() {
        EntradaNome.setText("");
        EntradaTelefone.setText("");
        EntradaEmail.setText("");
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new CadastroContatos().CadastroDeContatos);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



    private static class Contato {
        String nome;
        String telefone;
        String email;



        Contato(String nome, String telefone, String email) {
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
        }

        

        @Override
        public String toString() {
            return nome + " - " + telefone + " - " + email;
        }
    }
}
