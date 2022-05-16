package interfazGrafica;

import interfazGrafica.Login;

import model.MaquinaExpendedora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarAdmin extends JFrame implements ActionListener {
    JLabel dialogo,stock,precio,nombre;
    JTextField textStock,textPrecio,textNombre;
    JButton bAtras,bAceptar;

    MaquinaExpendedora[] maquina = Login.maquinas;



    public AgregarAdmin(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Agregar Maquina - Administrador");

        dialogo = new JLabel("Complete todos los campos para crear una nueva máquina ");
        dialogo.setBounds(20,10,350,20);
        add(dialogo);

        stock = new JLabel("Stock:");
        stock.setBounds(20,50,50,20);
        add(stock);

        precio = new JLabel("Precio:");
        precio.setBounds(20,90,50,20);
        add(precio);

        nombre = new JLabel("Nombre:");
        nombre.setBounds(20,130,50,20);
        add(nombre);

        textStock = new JTextField(7);
        textStock.setBounds(100,50,50,20);
        textStock.addActionListener(this);
        add(textStock);

        textPrecio = new JTextField(10);
        textPrecio.setBounds(100,90,50,20);
        textPrecio.addActionListener(this);
        add(textPrecio);

        textNombre = new JTextField(25);
        textNombre.setBounds(100,130,200,20);
        textNombre.addActionListener(this);
        add(textNombre);

        bAceptar = new JButton("Aceptar");
        bAceptar.setBounds(150,250,100,25);
        bAceptar.addActionListener(this);
        add(bAceptar);


        bAtras = new JButton("Regresar");
        bAtras.setBounds(275, 250, 100, 25);
        bAtras.addActionListener(this);
        add(bAtras);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MaquinaExpendedora modelo;
        if(e.getSource()==bAceptar){
            String sStock = textStock.getText().trim();
            if(!sStock.equals("")) {
                int valor = validaInt(sStock);
                String sPrecio = textPrecio.getText().trim();
                if(!sPrecio.equals("")){
                    float valorf = validaFloat(sPrecio);
                    String sNombre = textNombre.getText().trim();
                    if(!sNombre.equals("")){
                       modelo = new MaquinaExpendedora(valor,valorf,sNombre);
                       MaquinaExpendedora [] copia = new MaquinaExpendedora[maquina.length+1];
                       int i = 0;
                       while(i< maquina.length){
                           copia[i] = maquina[i];
                           i++;
                       }
                       copia[maquina.length] = modelo;
                       Login.maquinas = copia;

                       JOptionPane.showMessageDialog(null,"Se ha añadido con éxito la maquina: "+sNombre);
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingrese un valor en el campo Nombre");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Ingrese un valor en el campo Precio");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Ingrese un valor en el campo Stock");
            }
        }else{
            Admin admin= new Admin();
            admin.setBounds(0, 0, 400, 400);
            admin.setVisible(true);
            admin.setLocationRelativeTo(null);
            admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            admin.setResizable(false);
            this.setVisible(false);
        }

    }
    public static int validaInt(String number) {
        int result = 0; //Valor default.
        try {
            if (number != null) {
                result = Integer.parseInt(number);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "El valor introducido no corresponde con un número int");
        }
        return result;
    }
    public static float validaFloat(String number) {
        float result = 0; //Valor default.
        try {
            if (number != null) {
                result = Float.parseFloat(number);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "El valor introducido no corresponde con un número float");
        }
        return result;
    }


}
