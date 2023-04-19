package es.susosise;

import java.rmi.RemoteException;

public class App 
{
    public static void main( String[] args )
    {
        ParteServidor servidor = new ParteServidor();
        servidor.arrancar();
        
        ParteCliente cliente = new ParteCliente();
        try {
            cliente.saludar();
        } catch (RemoteException e) {
            System.err.println("Fallo intentar saludar: " + e.toString());
            e.printStackTrace();
        }
    }
}
