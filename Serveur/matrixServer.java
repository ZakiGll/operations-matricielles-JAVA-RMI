package Serveur;

import java.rmi.*;

public class matrixServer {
	public static void main(String[] argv){
		try {
			matrixImpl object = new matrixImpl();
			java.rmi.registry.LocateRegistry.createRegistry(2000);
			Naming.rebind("//:2000/matrix", object);
			System.out.println("Serveur en attente ");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
