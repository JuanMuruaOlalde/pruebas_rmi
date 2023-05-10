package es.susosise.RealizarTareas.Servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
    private static String NOMBRE_DEL_SERVICIO = "EjecutadorDeTareas";
    private static int  PUERTO_DE_ESCUCHA = 8881;

    public static void main( String[] args )
    {
        System.setProperty("java.security.policy", "permisoGeneralParaTodo.policy");
        //System.setProperty("java.security.policy", "permisosEspecificos.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        System.setProperty("java.rmi.server.codebase", "http://localhost:8080/");
        System.setProperty("java.rmi.server.useCodebaseOnly", "false");

        try {
            ////Si este servidor va a utilizar un registro de servicios que ya este activo en nuestro sistema, usar LocateRegistry.getRegistry
            Registry registroDeServicios = LocateRegistry.getRegistry();
            ////Si este servidor va a crear su propio registro de servicios, usar LocateRegistry.createRegistry
            //Registry registroDeServicios = LocateRegistry.createRegistry(1099);

            Trabajador_impl trabajador = new Trabajador_impl();
            Trabajador stubTrabajador = (Trabajador) UnicastRemoteObject.exportObject(trabajador, PUERTO_DE_ESCUCHA);
            registroDeServicios.bind(NOMBRE_DEL_SERVICIO, stubTrabajador);
            System.out.println("El servidor para ejecutar tareas está activo.");
        } catch (Exception e) {
            System.err.println("Fallo al iniciar un SERVIDOR para ejecutar tareas: " + e.toString());
            e.printStackTrace();
        }
    }
    
}
