package interfazGrafica;

import model.Cliente;
import app.Main;

import model.Boleto;
import model.MaquinaExpendedora;
import interfazGrafica.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static app.Main.mostrarBoleto;
import static app.Main.mostrarBoletoS;

public class menuUser extends JFrame implements ActionListener {

    private JLabel label1;
    private JButton bConsultarPrecio;
    private JButton bImprimirBoleto;
    private JButton bConsultarHistorial;
    private JButton bAtras;


    Cliente cliente = Login.cliente;

    MaquinaExpendedora[] copiaMaquina = Login.maquinas;
    MaquinaExpendedora maquinaValid;
    int valor;


    public menuUser(int value) {
        valor = value;
        maquinaValid = copiaMaquina[value];

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Elegir Opción - Usuario");
        label1 = new JLabel("Elija una opción");
        label1.setBounds(30, 20, 400, 80);
        add(label1);

        bConsultarPrecio = new JButton("Precio Ticket");
        bConsultarPrecio.setBounds(30, 100, 150, 30);
        bConsultarPrecio.addActionListener(this);
        add(bConsultarPrecio);

        bImprimirBoleto = new JButton("Imprimir Boleto");
        bImprimirBoleto.setBounds(30, 150, 150, 30);
        bImprimirBoleto.addActionListener(this);
        add(bImprimirBoleto);

        bConsultarHistorial = new JButton("Consultar Historial");
        bConsultarHistorial.setBounds(30, 200, 150, 30);
        bConsultarHistorial.addActionListener(this);
        add(bConsultarHistorial);

        bAtras = new JButton("Regresar");
        bAtras.setBounds(250, 320, 90, 20);
        bAtras.addActionListener(this);
        add(bAtras);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bConsultarPrecio) {
            JOptionPane.showMessageDialog(null, "El valor del boleto es de: $ " + maquinaValid.getPrecio());
        } else if (e.getSource() == bImprimirBoleto) {
            String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad de boletos que quiere comprar: ");
            int value = validaInt(cantidad);
            if (value < maquinaValid.getStock()) {
                Boleto[] boleto = maquinaValid.imprimirBoleto(value);
                cliente.setHistorialCompra(boleto);
                for (int i = 0; i < boleto.length; i++) {
                    JOptionPane.showMessageDialog(null, mostrarBoletoS(boleto[i]));
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay stock suficiente, intente nuevamente");
            }
        } else if (e.getSource() == bConsultarHistorial) {
            JOptionPane.showMessageDialog(null, "Los boletos que compro el usuario son: " + cliente.getHistorialCompra().length);
            for (int i = 0; i < cliente.getHistorialCompra().length; i++) {
                JOptionPane.showMessageDialog(null, mostrarBoletoS(cliente.getHistorialCompra()[i]));
            }
        } else {
            Perfil elegirPerfil = new Perfil();
            elegirPerfil.setBounds(0,0,400,400);
            elegirPerfil.setVisible(true);
            elegirPerfil.setLocationRelativeTo(null);
            elegirPerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            elegirPerfil.setResizable(false);
            this.setVisible(false);
        }
    }


    public int validaInt(String number) {
        int result = 0; //Valor default.
        try {
            if (number != null) {
                result = Integer.parseInt(number);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "El valor introducido no corresponde con un número");
        }
        return result;
    }
}
