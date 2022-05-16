package interfazGrafica;
import model.Cliente;
import app.Main;
import model.MaquinaExpendedora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Login extends JFrame implements ActionListener {

    private JPanel panel = new JPanel();
    private JFrame ventanaGral = new JFrame(); // Ventana gral.
    private JLabel user;
    private JLabel dni;
    private JTextField userText;
    private JTextField dniText;
    private JButton loginButton;

    public static Cliente cliente = new Cliente();
    public static MaquinaExpendedora[] maquinas;


    public Login (){
        ventanaGral.setBounds(0,0,400,400);
        ventanaGral.setLocationRelativeTo(null); // coloca al centro de la pantalla
        ventanaGral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaGral.setResizable(false);
        ventanaGral.add(panel);

        /*
        LAYOUT: Es la clase en que deciden en qué posición van los componentes, si van alienados,
        en forma de matriz, cuáles se hacen más grandes al expandir la ventana etc.
         */
        panel.setLayout(null); // Se elimina el layout.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaGral.setTitle("Maquina Expendedora - Gonzalo Rochet");


        user = new JLabel("Usuario: ");
        user.setBounds(10,20,80,30);
        panel.add(user);

        userText = new JTextField(50);
        userText.setBounds(100,20,165,30);

        panel.add(userText);

        dni = new JLabel("DNI: ");
        dni.setBounds(10,50,80,30);
        panel.add(dni);

        dniText = new JTextField(10);
        dniText.setBounds(100,50,165,30);
        panel.add(dniText);

        loginButton = new JButton("Ingresar");
        loginButton.setBounds(10, 90, 100, 30);
        loginButton.addActionListener(this);
        panel.add(loginButton);


        ventanaGral.setVisible(true);

        maquinas = new MaquinaExpendedora[2];
        MaquinaExpendedora maquinaDefault = new MaquinaExpendedora(100,50,"Default");
        maquinas[0] = maquinaDefault;

        MaquinaExpendedora maquinaDefault2 = new MaquinaExpendedora(200,75,"Default 2");
        maquinas[1] = maquinaDefault2;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            cliente.setNombre(userText.getText().trim());
            if (Objects.equals(cliente.getNombre(), "")) {
                JOptionPane.showMessageDialog(null, "Debes ingresar algún valor en el campo nombre");
            } else {
                String dni = dniText.getText();
                if(dni.equals("")){
                    JOptionPane.showMessageDialog(null,"Debe Ingresar algún valor en el campo dni");
                }else{
                    int valor = validaInt(dniText.getText());
                    cliente.setDni(valor);
                    if (cliente.getDni() <= 0 && cliente.getDni()>999999999) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar un dni válido en el campo");
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
            }
        }
    }
    /*
    https://es.stackoverflow.com/questions/219906/como-soluciono-un-exception-in-thread-awt-eventqueue-0-java-lang-numberformat
     */
    public int validaInt(String number){
        int result = 0; //Valor default.
        try{
            if(number != null){
                result = Integer.parseInt(number);
            }
        }catch(NumberFormatException nfe){
            //*No es numerico!
        }
        return result;
    }


}


