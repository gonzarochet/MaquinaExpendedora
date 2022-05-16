package app;

import model.Boleto;
import model.Cliente;
import model.MaquinaExpendedora;

import interfazGrafica.Login;


import java.util.Locale;
import java.util.Scanner;


public class Main {

    static Scanner teclado;
    static Scanner tecladoString;

    public static void main(String[] args) {

        //Cliente cliente = login();
        // MaquinaExpendedora[] maquina = menu0(cliente);
        //menu1(maquina,cliente);

        teclado = new Scanner(System.in);
        tecladoString = new Scanner(System.in);

        Login login = new Login();

        teclado.close();
        tecladoString.close();
    }

    public static Cliente login() {
        int valor = 0;
        Cliente cliente = null;
        do {
            System.out.println("HOLA BIENVENIDO:");
            System.out.println("1. Ingresar al sistema");
            System.out.println("Pulse 0 (cero) para salir");
            valor = teclado.nextInt();

            switch (valor) {
                case 1:
                    System.out.println("Ingresar el nombre y apellido");
                    String nombre = tecladoString.nextLine();

                    System.out.println("Ingresar dni");
                    int dni = teclado.nextInt();
                    cliente = new Cliente(nombre, dni);
                    break;

            }

        } while (valor != 0);
        return cliente;
    }

    public static MaquinaExpendedora[] menu0(Cliente cliente) {
        MaquinaExpendedora[] arrayMaquinas = null;
        if (cliente != null) {
            if (cliente.getDni() == 43592210) {
                System.out.println("CONFIGURACIÓN BÁSICA DEL SISTEMA: ");
                System.out.println("Ingrese los tipos de boletos que existiran: ");
                int valor = teclado.nextInt();
                if (valor > 0) {
                    arrayMaquinas = new MaquinaExpendedora[valor];
                    for (int i = 0; i < valor; i++) {
                        System.out.println("Ingrese el tipo boleto de la maquina nª:" + i+ " .");
                        String tipoBoleto = tecladoString.nextLine();
                        System.out.println("Ingrese el stock inicial de boletos de la máquina nª:" + i+ " .");
                        int stock = teclado.nextInt();
                        if (stock >= 0) {
                            System.out.println("Ingrese el valor del boleto que tendrá la máquina nª" + i+ ":");
                            float precio = teclado.nextFloat();
                            if (precio >= 0) {
                                arrayMaquinas[i] = new MaquinaExpendedora(stock, precio, tipoBoleto);
                            } else {
                                System.out.println("El valor del boleto no es válido");
                            }
                        } else {
                            System.out.println("EL stock de boletos no es válido");
                        }
                        clear();
                    }
                } else {
                    System.out.println("El valor debe ser positivo");
                }
            } else {
                System.out.println("Por favor ingrese con un perfil de administrador para este paso");
            }
        } else {
            System.out.println("Debe ingresar un usuario válido");
        }

        return arrayMaquinas;
    }

    public static void menu1(MaquinaExpendedora[] maquina, Cliente cliente) {
        int valor = 0;
        do {
            System.out.println("Ingrese el perfil de como quiere ingresar al sistema: ");
            System.out.println("1. Modo ADMINSTRADOR");
            System.out.println("2. Modo USUARIO");
            System.out.println("Pulse 0 para salir del sistema");
            valor = teclado.nextInt();
            switch (valor) {
                case 1:
                    if (cliente.getDni() == 43592210) {
                        menuAdm(maquina);
                    } else {
                        System.out.println("Usted no tiene permiso para acceder a este menú");
                    }
                    break;
                case 2:
                    menuCli(maquina, cliente);
                    break;
                default:
                    valor = 0;
                    break;
            }
            clear();
        } while (valor != 0);

    }

    public static void menuAdm(MaquinaExpendedora[] maquina) {

        int valor = 0;
        mostrarMaquina(maquina);
        System.out.println("Elija la maquina con la que desea trabajar: ");
        int nromaquina = teclado.nextInt();

        if (nromaquina < maquina.length && nromaquina > 0) {
            do {
                System.out.println("NÚMERO DE LA MÁQUINA: " + nromaquina);
                System.out.println("Elija una opción: ");
                System.out.println("1. Ver stock");
                System.out.println("2. Agregar Stock");
                System.out.println("3. Ver recaudacion");
                System.out.println("4. Vaciar recaudacion");
                System.out.println("5. Ver precio Boleto");
                System.out.println("6. Modificar precio boleto");
                System.out.println("7. Cantidad de boletos emitidos");
                System.out.println("Pulse 0 (cero) para salir ");
                valor = teclado.nextInt();

                switch (valor) {
                    case 1:
                        System.out.println("El stock es: " + maquina[nromaquina].getStock());
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad de stock que quiera añadir: ");
                        boolean key = maquina[nromaquina].addStock(teclado.nextInt());
                        if (key) {
                            System.out.println("El valor ha sido añadido con exito");
                        } else {
                            System.out.println("El valor que quiere ingresar es igual o menor a 0");
                        }
                        break;
                    case 3:
                        System.out.println("La recaudacion es: " + maquina[nromaquina].getRecaudacion());
                        break;
                    case 4:
                        float recaudacion = maquina[nromaquina].vaciarRecaudacion();
                        System.out.println("La recaudación fue de: $ " + recaudacion);
                        break;
                    case 5:
                        System.out.println("El precio del boleto es: " + maquina[nromaquina].getPrecio());
                        break;
                    case 6:
                        System.out.println("Ingrese el valor nuevo del boleto: ");
                        boolean flag = maquina[nromaquina].setPrecio(teclado.nextFloat());
                        if (flag) {
                            System.out.println("El nuevo precio ha sido añadido con exito");
                        } else {
                            System.out.println("El valor que quiere ingresar es igual o menor a 0");
                        }
                        break;
                    case 7:
                        System.out.println("La cantidad de boletos emitidos fue de: " + maquina[nromaquina].getCantidadBoletosEmitidos() + " unidades");
                    default:
                        valor = 0;
                        break;
                }
                clear();
            } while (valor != 0);

        } else {
            System.out.println("El valor ingresado no corresponde a ninguna máquina");
        }


    }


    public static void menuCli(MaquinaExpendedora[] maquina, Cliente cliente) {
        int valor = 0;
        mostrarMaquina(maquina);
        System.out.println("Elija la maquina con la que desea trabajar: ");
        int nromaquina = teclado.nextInt();
        if (nromaquina < maquina.length && nromaquina > 0) {
            do {
                System.out.println("Elija una opción: ");
                System.out.println("1. Emitir boletos");
                System.out.println("2. Consultar precio de un boleto:");
                System.out.println("Pulse 0 (cero)para salir del sistema");
                valor = teclado.nextInt();

                switch (valor) {
                    case 1:
                        System.out.println("Elija la cantidad de boletos a imprimir:");
                        int cantidad = teclado.nextInt();
                        Boleto[] boletito = maquina[nromaquina].imprimirBoleto(cantidad);
                        if (boletito != null) {
                            System.out.println("Los boletos han sido emitidos con éxito");
                            mostrarBoleto(boletito);

                        } else {
                            System.out.println("No hay stock para emitir este boleto");
                        }
                        break;
                    case 2:
                        System.out.println("El precio del boleto es: " + maquina[nromaquina].getPrecio());
                        break;
                    default:
                        valor = 0;
                        break;

                }
                clear();
            } while (valor != 0);
        }


    }

    public static void mostrarBoleto(Boleto[] boleto) {
        for (int i = 0; i < boleto.length; i++) {
            System.out.println("-----------------------------------------");
            System.out.println("- Fecha de Boleto: " + boleto[i].getFechaEmision().toString());
            System.out.println("- Id: " + boleto[i].getId());
            System.out.println("- Precio: $ " + boleto[i].getPrecio());
            System.out.println("-----------------------------------------");
        }

    }

    public static String mostrarBoletoS(Boleto boleto) {
        return("-----------------------------------------" + "\n" +
                "- Fecha de Boleto: " + boleto.getFechaEmision().toString() + "\n" +
                "- Id: " + boleto.getId() + "\n" +
                "- Precio: $ " + boleto.getPrecio() + "\n" +
                "----------------------------------------");
    }

    private static void mostrarMaquina(MaquinaExpendedora[] maquinita) {
        for (int i = 0; i < maquinita.length; i++) {
            System.out.println("-----------------------------------------");
            System.out.println("- NRO DE LA MÁQUINA: " + i);
            System.out.println("- Tipo de Maquina/Boleto: " + maquinita[i].getTipoBoleto());
            System.out.println("- Precio del boleto: $ " + maquinita[i].getPrecio());
            System.out.println("- Stock disponible en la máquina: " + maquinita[i].getStock() + " unidades.");
            System.out.println("-----------------------------------------");
        }

    }


    private static void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
        }
    }
}





