import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws RemoteException {
        client c = new client();
        c.connectRemote();

    }
    private void connectRemote() throws  RemoteException{
        try{
            Scanner sc = new Scanner(System.in);
            // server's port and ip needed..
            Registry reg = LocateRegistry.getRegistry("localhost",9998);

            adder ad = (adder)reg.lookup("Hi Server");

            System.out.println("What do you want to do ?");
            System.out.println("Select the Input for: \n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
            int choice;
            choice = sc.nextInt();
            if(choice<5 && choice>0) {
                System.out.println("Enter two number: ");
                int a = sc.nextInt();
                int b = sc.nextInt();
                switch(choice){
                    case 1:  System.out.println("Addition is: "+ad.add(a,b));
                        break;
                    case 2:  System.out.println("Subtraction is: "+ad.sub(a,b));
                        break;
                    case 3:  System.out.println("Multiplication is: "+ad.mul(a,b));
                        break;
                    case 4:  System.out.println("Division (" + a + "/" + b + ") " + "is: "+ad.div(a,b));
                        break;
                    default:
                        //System.out.println("Wrong Selection..");
                        break;
                }
            }else{
                System.out.println("Wrong Selection..");
                System.exit(0);
            }



        }catch(NotBoundException|RemoteException e){
            System.out.println("Exception: "+e);
        }
    }
}
