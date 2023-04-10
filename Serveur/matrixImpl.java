package Serveur;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

import Interface.matrixInterface;
import utilisateur.Utilisateur;

public class matrixImpl extends UnicastRemoteObject implements matrixInterface{
	private ArrayList<Utilisateur> clients;
	public matrixImpl() throws RemoteException {
		 clients = new ArrayList<Utilisateur>();
	}
	
	public int findClientByName(ArrayList<Utilisateur> listOfClients,Utilisateur client) throws RemoteException{
		for(int i=0; i < listOfClients.size(); i++) {
			if (client.getId().equals(listOfClients.get(i).getId())) return i;
		}
		return -1;
	}
	
	public int auth(Utilisateur client) throws RemoteException{
		if (findClientByName(clients,client) != -1) {
			
			if(clients.get(findClientByName(clients,client)).getPass().equals(client.getPass())) {
				System.out.println("Le client: "+client.getId()+" est authentifié!");
				return 1;
				}
			else {
				System.out.println("Mot de pass incorrect pour le client: "+client.getId());
				return 0;
			}
			}
		else {
			clients.add(client);
			System.out.println("Le client: "+client.getId()+" est ajouté!");
			return 1;
		}
	}

	public int[][] sumOfmatrix(int[][] A, int[][] B) throws RemoteException {
		int[][] C = new int[A.length][A[0].length];
		for(int i=0;i<A.length;i++) {
    		for(int j=0;j<A[i].length;j++) {
    			C[i][j] = A[i][j] + B[i][j];
    		}	
    	}
		return C;
	}

	public int[][] productOfmatrix(int[][] A, int[][] B) throws RemoteException {
		int[][] C = new int[A.length][B[0].length];
		for(int i=0;i<A.length;i++) {
    		for(int j=0;j<B[0].length;j++) {
    			for(int k=0;k<A[0].length;k++)
    			C[i][j] += A[i][k] * B[k][j];
    		}	
    	}
		return C;
	}

	public int[][] transposeOfmatrix(int[][] A) throws RemoteException {
		int[][] C = new int[A[0].length][A.length];
		for(int i=0;i<A[0].length;i++) {
    		for(int j=0;j<A.length;j++) {
    			C[i][j] = A[j][i];
    		}	
    	}
		return C;
	}

	public double[][] inverseOfMatrix(int[][] m) throws RemoteException {
		int[][] M = transposeOfmatrix(coMatrix(m));
    	double[][] inv = new double[M[0].length][M.length];
    	double det = determinant(m);
    	for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M[i].length; j++)
            	inv[i][j] = M[i][j]/det;

        return inv;
	}
	
	public int[][] subMatrix(int[][] M, int r, int c) throws RemoteException{

		int[][] subMatrix = new int[M.length - 1][M.length - 1];

        int k = 0;
        for (int i = 0; i < M.length; i++) {
            int l = 0;
            if (i != r) {
                for (int j = 0; j < M[i].length; j++) {
                    if (j != c)
                        subMatrix[k][l++] = M[i][j];
                }
                k++;
            }
        }

        return subMatrix;
    }

	public int sign(int n) throws RemoteException{

        if (n % 2 == 0)
            return 1;
        else
            return -1;
    }
    
    public int determinant(int[][] M) throws RemoteException{

    	if (M.length == 1) {
            return M[0][0];
        }
    	
        if (M.length == 2) {
            return (M[0][0] * M[1][1]) - (M[0][1] * M[1][0]);
        }
        
        int sum = 0;
        for (int i = 0; i < M[0].length; i++) {
            sum += sign(i) * M[0][i] * determinant(subMatrix(M, 0, i));
        }
        
        return sum;
    }
    
    public int[][] coMatrix(int[][] M) throws RemoteException{

    	int[][] t = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++)
                t[i][j] = sign(i) * sign(j) * determinant(subMatrix(M, i, j));
        }
        return t;
    }
        
	

}
