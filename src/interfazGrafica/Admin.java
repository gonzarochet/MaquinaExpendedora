package interfazGrafica;


import model.MaquinaExpendedora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

    private JButton bAgregar, bModificar, bAtras;
    private JLabel label1;


    public Admin() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Administrador");
        label1 = new JLabel("Elija una opción: ");
        label1.setBounds(30, 10, 350, 30);
        add(label1);

        bAgregar = new JButton("Agregar Maquina");
        bAgregar.setBounds(30, 50, 250, 30);
        bAgregar.addActionListener(this);
        add(bAgregar);

        bModificar = new JButton("Modificar Maquina existente");
        bModificar.setBounds(30, 90, 250, 30);
        bModificar.addActionListener(this);
        add(bModificar);

        bAtras = new JButton("Regresar");
        bAtras.setBounds(250, 320, 90, 20);
        bAtras.addActionListener(this);
        add(bAtras);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAgregar) {
            AgregarAdmin admin = new AgregarAdmin();
            admin.setBounds(0, 0, 400, 400);
            admin.setVisible(true);
            admin.setLocationRelativeTo(null);
            admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            admin.setResizable(false);
            this.setVisible(false);

        } else if (e.getSource() == bModificar) {

            ModificarAdmin admin = new ModificarAdmin();
            admin.setBounds(0, 0, 400, 400);
            admin.setVisible(true);
            admin.setLocationRelativeTo(null);
            admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            admin.setResizable(false);
            this.setVisible(false);


        } else {
            Perfil elegirPerfil = new Perfil();
            elegirPerfil.setBounds(0, 0, 400, 400);
            elegirPerfil.setVisible(true);
            elegirPerfil.setLocationRelativeTo(null);
            elegirPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            elegirPerfil.setResizable(false);
            this.setVisible(false);
        }
    }
}
