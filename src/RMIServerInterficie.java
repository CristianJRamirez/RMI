import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Dionis on 22/02/2016.
 */
public interface RMIServerInterficie extends Remote{


    public double suma(String[] valores) throws RemoteException;
    public double resta(String[] valores) throws RemoteException;
    public double division(String[] valores) throws RemoteException;
    public double multiplicar(String[] valores) throws RemoteException;

}
