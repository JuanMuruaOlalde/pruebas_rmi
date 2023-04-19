package es.susosise;

import java.rmi.RemoteException;

public class SaludosYAgradecimientos_impl  implements SaludosYAgradecimientos {

    @Override
    public String getSaludo() throws RemoteException {
        return "Hola, prosperos y felices dias...";
    }
    
}
