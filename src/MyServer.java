import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;

public class MyServer {
    public static void main(String[] args) {
        int numberOfWorkers = 5;

        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        if (System.getSecurityManager() == null) System.setSecurityManager(new SecurityManager());
        try
        {
            Registry reg = LocateRegistry.createRegistry(1099);

        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        try
        {
            LinkedList<Workerr> workers = new LinkedList<>();
            for(int i = 0; i < numberOfWorkers; i ++) {
                workers.add(new Workerr());
                Naming.rebind("//127.0.0.1/server" + i, workers.getLast());
            }
            System.out.println("Server is registered now :)");
            System.out.println("Press Crl+C to stop...");
        }
        catch (Exception e)
        {
            System.out.println("SERVER CANT BE REGISTERED!");
            e.printStackTrace();
            return;
        }
    }
}
