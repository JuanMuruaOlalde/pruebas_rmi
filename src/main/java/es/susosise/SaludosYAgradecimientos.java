package es.susosise;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SaludosYAgradecimientos extends Remote {
    String getSaludo() throws RemoteException;
}
