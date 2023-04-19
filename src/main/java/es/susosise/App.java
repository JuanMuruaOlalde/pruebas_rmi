package es.susosise;

import es.susosise.CalculadorMatematico.ServidorCalculador;

import java.rmi.RemoteException;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        ParteRegistradorDeServicios registrador = new ParteRegistradorDeServicios();
        registrador.arrancar(1099);

        ParteServidor servidor = new ParteServidor();
        servidor.arrancar();

        ServidorCalculador servidorCalculos = new ServidorCalculador();
        servidorCalculos.arrancar();
        
        ParteCliente cliente = new ParteCliente();
        Scanner lectorDeTeclado = new Scanner(System.in);
        System.out.print("Teclea un numero: ");
        Double unNumero = lectorDeTeclado.nextDouble();
        lectorDeTeclado.nextLine();
        System.out.println();
        System.out.print("Teclea otro numero: ");
        Double otroNumero = lectorDeTeclado.nextDouble();
        lectorDeTeclado.nextLine();
        System.out.println();
        System.out.print("Tu nombre: ");
        String nombre = lectorDeTeclado.nextLine();
        System.out.println();
        lectorDeTeclado.close();
        try {
            cliente.saludar();
            cliente.calcularCon(unNumero, otroNumero);
            cliente.agradecerA(nombre);
        } catch (RemoteException e) {
            System.err.println("Fallo intentar saludar: " + e.toString());
            e.printStackTrace();
        }
    }
}
