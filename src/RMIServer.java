import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Dionis on 22/02/2016.
 */
public class RMIServer implements RMIServerInterficie{


    public static void main(String[] args) {
        System.out.println("Creant registre d'objectes remots");
        Registry reg = null;

        try{
            reg = LocateRegistry.createRegistry(5555);
            System.out.println(reg);
        }catch (Exception e){
            System.out.println("Error: No s'ha pogut crear el registre");
            e.printStackTrace();
        }

        System.out.println("Creant l'objecte servidor e inscribint-lo en el registre ...");

        RMIServer inter= new RMIServer();

        try{
            reg.rebind("Calculado",(RMIServerInterficie) UnicastRemoteObject.exportObject(inter,0));
        }catch (Exception e){
            System.out.println("No s'ha pogut inscriure l'objecte servidor");
            e.printStackTrace();
        }
    }

    @Override
    public double suma(String[] valores) throws RemoteException {
        System.out.println(valores[0]+"--"+Double.parseDouble(valores[1]));
        Double resultad =Double.parseDouble(valores[0]) + Double.parseDouble(valores[1]);
        return resultad;
    }

    @Override
    public double resta(String[] valores) throws RemoteException {
        System.out.println(Double.parseDouble(valores[0])+"--"+Double.parseDouble(valores[1]));
        Double resultad =Double.parseDouble(valores[0])-Double.parseDouble(valores[1]);
        return resultad;
    }

    @Override
    public double division(String[] valores) throws RemoteException {
        System.out.println(Double.parseDouble(valores[0])+"--"+Double.parseDouble(valores[1]));
        Double resultad =Double.parseDouble(valores[0])/Double.parseDouble(valores[1]);
        return resultad;
    }

    @Override
    public double multiplicar(String[] valores) throws RemoteException {
        System.out.println(Integer.parseInt(valores[0])+"--"+Integer.parseInt(valores[1]));
        Double resultad =Double.parseDouble(valores[0])*Double.parseDouble(valores[1]);
        return resultad;
    }
}
