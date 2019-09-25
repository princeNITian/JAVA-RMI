import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class server extends UnicastRemoteObject implements adder {
    public server() throws RemoteException {
    }

    @Override
    public int add(int n1, int n2) throws RemoteException {
        return n1+n2;
    }

    @Override
    public int sub(int n1, int n2) throws RemoteException {
        return n1-n2;
    }

    @Override
    public int mul(int n1, int n2) throws RemoteException {
        return n1*n2;
    }

    @Override
    public int div(int n1, int n2) throws RemoteException {
        int res = -1;
         try{
           res =  n1/n2;
        }catch (ArithmeticException e){
           System.out.print("Divide by zero Exception..");
        }
        return res;
    }

    public static void main(String[] args) throws RemoteException{
        try {
            Registry reg = LocateRegistry.createRegistry(9998);
            reg.rebind("Hi Server", new server());
            System.out.println("Sever is ready..");
        }catch(RemoteException e){
            System.out.println("Exception "+e);
        }
    }
}
