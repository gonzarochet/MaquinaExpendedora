package interfazGrafica;

import model.MaquinaExpendedora;

import javax.swing.*;
import java.awt.event.*;

public class Perfil extends JFrame implements ActionListener {

    private JButton botonAdm, botonCli;
    private JLabel label1;

    public Perfil(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Elegir modo - Maquina Expendedora");
        label1 = new JLabel("Elija un modo con el que quiera ingresar");
        label1.setBounds(90,20,400,80);
        add(label1);

        botonAdm = new JButton("Administrador");
        botonAdm.setBounds(30,80,150,30);
        botonAdm.addActionListener(this);
        add(botonAdm);

        botonCli = new JButton("Cliente");
        botonCli.setBounds(200,80,150,30);
        botonCli.addActionListener(this);
        add(botonCli);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonAdm){
           String password =  JOptionPane.showInputDialog("Ingrese la contraseña: (ayuda: mejor jugador del mundo)");
           if(password.equals("messi")){
               Admin admin = new Admin();
               admin.setBounds(0,0,400,400);
               admin.setVisible(true);
               admin.setLocationRelativeTo(null);
               admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               admin.setResizable(false);
               this.setVisible(false);

           }else{
               JOptionPane.showMessageDialog(null,"La contraseña no es valida");
           }
        }
        else
        {
            User usuario = new User();
            usuario.setBounds(0,0,400,400);
            usuario.setVisible(true);
            usuario.setLocationRelativeTo(null);
            usuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            usuario.setResizable(false);
            this.setVisible(false);
        }
    }
}
