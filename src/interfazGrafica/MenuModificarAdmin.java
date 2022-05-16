package interfazGrafica;

import model.MaquinaExpendedora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class MenuModificarAdmin extends JFrame implements ActionListener {
   JLabel jTitle,jStock,jPrecio,jBoleto,jRecaudacion;
   JButton bVerStock,bAddStock,bVerPrecio,bSetPrecio,bCambiarNombre,bCantBoletEmit,bVerRecaudacion,bVaciarRecaudacion,bAtras;

   MaquinaExpendedora maquina= Login.maquinas[ModificarAdmin.eleccion];

   public MenuModificarAdmin(){
       setLayout(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setTitle("Modificar Maquina - Administrador");

       //  1. Jlabels

       jTitle = new JLabel("MODIFICAR MÁQUINA "+maquina.getTipoBoleto().toUpperCase());
       jTitle.setBounds(20,5,380,35);
       add(jTitle);

       jStock = new JLabel("Stock");
       jStock.setBounds(20,55,80,25);
       add(jStock);

       jPrecio = new JLabel("Precio");
       jPrecio.setBounds(20,105,80,25);
       add(jPrecio);

       jBoleto = new JLabel("Boleto");
       jBoleto.setBounds(20,155,80,25);
       add(jBoleto);

       jRecaudacion = new JLabel("Recaudacion");
       jRecaudacion.setBounds(20,220,80,25);
       add(jRecaudacion);

       // 2.Botones

       bVerStock = new JButton("Ver");
       bVerStock.setBounds(20,77,80,20);
       bVerStock.addActionListener(this);
       add(bVerStock);

       bAddStock = new JButton("Agregar");
       bAddStock.setBounds(110,77,80,20);
       bAddStock.addActionListener(this);
       add(bAddStock);

       bVerPrecio = new JButton("Ver");
       bVerPrecio.setBounds(20,127,80,20);
       bVerPrecio.addActionListener(this);
       add(bVerPrecio);

       bSetPrecio = new JButton("Agregar");
       bSetPrecio.setBounds(110,127,80,20);
       bSetPrecio.addActionListener(this);
       add(bSetPrecio);

       bCambiarNombre = new JButton("Cambiar Nombre");
       bCambiarNombre.setBounds(20,177,160,20);
       bCambiarNombre.addActionListener(this);
       add(bCambiarNombre);

       bCantBoletEmit = new JButton("Cantidad Boletos Vendidos");
       bCantBoletEmit.setBounds(20,197,200,20);
       bCantBoletEmit.addActionListener(this);
       add(bCantBoletEmit);

       bVerRecaudacion = new JButton("Ver");
       bVerRecaudacion.setBounds(20,245,80,20);
       bVerRecaudacion.addActionListener(this);
       add(bVerRecaudacion);

       bVaciarRecaudacion = new JButton("Vaciar");
       bVaciarRecaudacion.setBounds(110,245,80,20);
       bVaciarRecaudacion.addActionListener(this);
       add(bVaciarRecaudacion);

       bAtras = new JButton("Regresar");
       bAtras.setBounds(275, 300, 100, 25);
       bAtras.addActionListener(this);
       add(bAtras);


   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bVerStock){
            JOptionPane.showMessageDialog(null, "El stock de boletos es de: "+maquina.getStock()+" unidades");
        }else if(e.getSource()==bVerPrecio){
            JOptionPane.showMessageDialog(null, "El precio del boleto es de: $"+maquina.getPrecio());
        }else if(e.getSource()==bVerRecaudacion){
            JOptionPane.showMessageDialog(null,"La Recaudación es de: $"+maquina.getRecaudacion());
        }else if(e.getSource()==bCantBoletEmit){
            JOptionPane.showMessageDialog(null,"La cantidad de boletos vendidos fue de: "+maquina.getCantidadBoletosEmitidos());
        }else if(e.getSource()==bAddStock){
            int value =  AgregarAdmin.validaInt(JOptionPane.showInputDialog("Ingrese la cantidad de stock que quiere agregar:"));
            boolean flag = Login.maquinas[ModificarAdmin.eleccion].addStock(value);
            if(flag){
                JOptionPane.showMessageDialog(null,"Se ha añadido la nueva cantidad de stock con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Intente nuevamente");
            }
        }else if(e.getSource()==bSetPrecio){
            float valorF = AgregarAdmin.validaFloat(JOptionPane.showInputDialog("Ingrese el valor nuevo del boleto"));
            boolean flag = Login.maquinas[ModificarAdmin.eleccion].setPrecio(valorF);
            if(flag){
                JOptionPane.showMessageDialog(null,"Se ha añadido con éxito el nuevo valor del boleto");
            }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Intente nuevamente");
            }
        }else if(e.getSource()==bCambiarNombre){
            String value = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la maquina/tipo de boleto");
            if(!value.equals("")){
                Login.maquinas[ModificarAdmin.eleccion].setTipoBoleto(value);
                JOptionPane.showMessageDialog(null,"El nombre se ha actualizado con éxito");
            }else{
                JOptionPane.showInputDialog(null, "Ha ocurrido un error. Intente nuevamente");
            }
        }else if(e.getSource()==bVaciarRecaudacion){
            float valor = Login.maquinas[ModificarAdmin.eleccion].getRecaudacion();
            Login.maquinas[ModificarAdmin.eleccion].vaciarRecaudacion();
            JOptionPane.showMessageDialog(null,"La recaudación de: $"+valor + " se ha vaciado con éxito");

        }else{
            Admin admin = new Admin();
            admin.setBounds(0,0,400,400);
            admin.setVisible(true);
            admin.setLocationRelativeTo(null);
            admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            admin.setResizable(false);
            this.setVisible(false);
        }

    }
}
