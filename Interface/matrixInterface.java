package Interface;
import java.rmi.*;
import java.util.ArrayList;

import utilisateur.Utilisateur;
public interface matrixInterface extends Remote {
	
	public int[][] sumOfmatrix(int[][] A,int[][] B) throws RemoteException;
	public int[][] productOfmatrix(int[][] A,int[][] B) throws RemoteException;
	public int[][] transposeOfmatrix(int[][] A) throws RemoteException;
	public double[][] inverseOfMatrix(int[][] m) throws RemoteException;
	public int[][] subMatrix(int[][] M, int r, int c) throws RemoteException;
	public int[][] coMatrix(int[][] M) throws RemoteException;
	public int sign(int n) throws RemoteException;
	public int determinant(int[][] M) throws RemoteException;
	public int findClientByName(ArrayList<Utilisateur> listOfClients,Utilisateur client) throws RemoteException;
	public int auth(Utilisateur client) throws RemoteException;

}
