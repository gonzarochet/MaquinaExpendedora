package interfazGrafica;

import model.MaquinaExpendedora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame implements ActionListener {

    private JLabel label1;
    private JMenuBar mb;
    public JMenu listaMaquinas;
    public JMenuItem[] tipoBoletos;

    MaquinaExpendedora[] maquinas = Login.maquinas;


    public User() {
        System.out.println("User" + maquinas.length);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Maquina Expendedora - Usuario");

        mb = new JMenuBar();
        mb.setBackground(new Color(255, 0, 0));
        mb.setBounds(0, 0, 400, 50);
        setJMenuBar(mb);

        listaMaquinas = new JMenu("Tipos Tickets");
        mb.add(listaMaquinas);

        tipoBoletos = new JMenuItem[maquinas.length];

        for (int i = 0; i < maquinas.length; i++) {
            JMenuItem menuOp = new JMenuItem(maquinas[i].getTipoBoleto().trim());
            tipoBoletos[i] = menuOp;
            tipoBoletos[i].addActionListener(this);
            listaMaquinas.add(tipoBoletos[i]);
        }

        label1 = new JLabel("Elija el tipo de boleto para seguir");
        label1.setBounds(5, 5, 200, 80);
        add(label1);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < tipoBoletos.length; i++) {
            if (e.getSource() == tipoBoletos[i]) {
                menuUser usuario = new menuUser(i);
                usuario.setBounds(0, 0, 400, 400);
                usuario.setVisible(true);
                usuario.setLocationRelativeTo(null);
                usuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                usuario.setResizable(false);
                this.setVisible(false);
            }
        }
    }
}
