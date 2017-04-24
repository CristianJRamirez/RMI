import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Created by dremo on 22/02/2016.
 */
public class RMIClient {
    public static RMIServerInterficie inter = null;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Escribeme la operacion");
        String operacion=sc.nextLine();


        try{
            System.out.println("Localitzant registre d'objectes remots ...");
            Registry registry = LocateRegistry.getRegistry("localhost",5555);
            System.out.println("Obtenint l'objecte remot...");
            inter = (RMIServerInterficie) registry.lookup("Calculado");



        }catch (Exception e){
            e.printStackTrace();
        }

        if(inter!= null){
            System.out.println("Realitzant operacions");

            try{
                System.out.println("Ek resyktat és:");

                calcular(operacion);

                //System.out.println(inter.dirHello());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        System.out.println("FI");

    }

    public static void calcular(String operacion) throws RemoteException {
        Double salida = 0.0;

        if (operacion.contains("+")) {
            System.out.println("El resultado es -> " + inter.suma(operacion.split("\\+")));
        } else if (operacion.contains("-")) {
            System.out.println("El resultado es -> " + inter.resta(operacion.split("-")));
        } else if (operacion.contains("*")) {
            System.out.println("El resultado es -> " + inter.multiplicar(operacion.split("\\*")));
        } else if (operacion.contains("/")) {
            System.out.println("El resultado es -> " + inter.division(operacion.split("\\/")));
        }

    }

}
