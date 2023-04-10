package Client;
import java.rmi.*;
import java.util.Random;
import java.util.Scanner;

import Interface.matrixInterface;
import utilisateur.Utilisateur;

public class Client1 {
	
	public static void main(String []argv) { 
		Scanner scanner = new Scanner(System.in);
		try {
			matrixInterface obj = (matrixInterface) Naming.lookup("//:2000/matrix");
			System.out.print("Nom: ");
		    String clientName = scanner.nextLine();
		    System.out.print("mot de passe: ");
		    String clientPassword = scanner.nextLine();
		    
			int auth = obj.auth(new Utilisateur(clientName,clientPassword));
			while (auth == 0) {
				System.out.println("Mot de pass incorrect!");
				System.out.print("Nom: ");
			    clientName = scanner.nextLine();
			    System.out.print("mot de passe: ");
			    clientPassword = scanner.nextLine();
			    auth = obj.auth(new Utilisateur(clientName,clientPassword));
			}
			
			System.out.println("choisissez une opération: \n- Somme(+)\n- Multiplication(*)\n- Transposée(t)\n- Inverse(i)");
			char opperation = scanner.next().charAt(0);
			
			switch (opperation) {
			case '+':
				System.out.println("La 1er matrice :");
				System.out.println("Entrez le nombre des lignes : ");
				int row = scanner.nextInt();
				System.out.println("Entrez le nombre des col : ");
				int col = scanner.nextInt();
				
				int[][] M1 = new int[row][col];
				
				System.out.println("Voulez vous remplir la matrice aléatoirement? (oui/non) ");
				scanner.nextLine();
			    String answerM1 = scanner.nextLine();
			    
			    Random rand = new Random();
			    switch (answerM1) {
			    case "oui":
			    	for(int i=0;i<row;i++) {
			    		for(int j=0;j<col;j++) {
			    			M1[i][j]=rand.nextInt(10);
			    		}
			    	}
			    	break;
			    case "non":
			    	for(int i=0;i<row;i++) {
			    		for(int j=0;j<col;j++) {
			    			System.out.print("M1["+i+"]["+j+"]= ");
			    			M1[i][j]=scanner.nextInt();
			    		}
			    	}
			    	break;
			    default: break;
			    }
			    
			    boolean same=false;
			    int row1=0;
			    int col1=0;
			    while(same==false) {
					System.out.println("La 2eme matrice :");
					System.out.println("Entrez le nombre des lignes : ");
					row1 = scanner.nextInt();
					System.out.println("Entrez le nombre des col : ");
					col1 = scanner.nextInt();
					
					if (row1 != row || col1 != col) {
						System.out.println("Il faut donner des matrices du meme taille pour faire la somme! ");
					}
					else {
						same=true;
					}
				}
				
				int[][] M2 = new int[row1][col1];
				
				System.out.println("Voulez vous remplir la matrice aléatoirement? (oui/non) ");
				scanner.nextLine();
			    String answerM2 = scanner.nextLine();
			
			    switch (answerM2) {
			    case "oui":
			    	for(int i=0;i<row;i++) {
			    		for(int j=0;j<col;j++) {
			    			M2[i][j]=rand.nextInt(10);
			    		}
			    	}
			    	break;
			    case "non":
			    	for(int i=0;i<row;i++) {
			    		for(int j=0;j<col;j++) {
			    			System.out.print("M2["+i+"]["+j+"]= ");
			    			M2[i][j]=scanner.nextInt();
			    		}	
			    	}
			    	break;
			    default: break;
			    }
			    
			    System.out.println("La 1er matrice :");
			    for (int i = 0; i < M1.length; i++) {
					for (int j = 0; j < M1[i].length; j++)
		             System.out.print(M1[i][j] + " ");
					System.out.println("");
				}
				
			    System.out.println("La 2eme matrice :");
			    for (int i = 0; i < M2.length; i++) {
					for (int j = 0; j < M2[i].length; j++)
		             System.out.print(M2[i][j] + " ");
					System.out.println("");
				}
			    
			    int[][] result = obj.sumOfmatrix(M1, M2);
			    System.out.println("Le resultat :");
			    for (int i = 0; i < result.length; i++) {
					for (int j = 0; j < result[i].length; j++)
		             System.out.print(result[i][j] + " ");
					System.out.println("");
				}
				break;
			
			case '*':
				System.out.println("La 1er matrice :");
				System.out.println("Entrez le nombre des lignes : ");
				int rowP = scanner.nextInt();
				System.out.println("Entrez le nombre des col : ");
				int colP = scanner.nextInt();
				
				int[][] MP1 = new int[rowP][colP];
				
				System.out.println("Voulez vous remplir la matrice aléatoirement? (oui/non) ");
				scanner.nextLine();
			    String answerMP = scanner.nextLine();
			    
			    Random randP = new Random();
			    switch (answerMP) {
			    case "oui":
			    	for(int i=0;i<rowP;i++) {
			    		for(int j=0;j<colP;j++) {
			    			MP1[i][j]=randP.nextInt(10);
			    		}
			    	}
			    	break;
			    case "non":
			    	for(int i=0;i<rowP;i++) {
			    		for(int j=0;j<colP;j++) {
			    			System.out.print("M1["+i+"]["+j+"]= ");
			    			MP1[i][j]=scanner.nextInt();
			    		}
			    	}
			    	break;
			    default: break;
			    }
			    
			    boolean sameD=false;
			    int rowP1=0;
			    int colP1=0;
			    while(sameD==false) {
					System.out.println("La 2eme matrice :");
					System.out.println("Entrez le nombre des lignes : ");
					rowP1 = scanner.nextInt();
					System.out.println("Entrez le nombre des col : ");
					colP1 = scanner.nextInt();
					
					if (rowP1 != colP || colP1 != rowP) {
						System.out.println("Il faut donner un nombre des col comme la premier matrice! ");
					}
					else {
						sameD=true;
					}
				}
				
				int[][] MP2 = new int[rowP1][colP1];
				
				System.out.println("Voulez vous remplir la matrice aléatoirement? (oui/non) ");
				scanner.nextLine();
			    String answerMP2 = scanner.nextLine();
			
			    switch (answerMP2) {
			    case "oui":
			    	for(int i=0;i<rowP1;i++) {
			    		for(int j=0;j<colP1;j++) {
			    			MP2[i][j]=randP.nextInt(10);
			    		}
			    	}
			    	break;
			    case "non":
			    	for(int i=0;i<rowP1;i++) {
			    		for(int j=0;j<colP1;j++) {
			    			System.out.print("M2["+i+"]["+j+"]= ");
			    			MP2[i][j]=scanner.nextInt();
			    		}	
			    	}
			    	break;
			    default: break;
			    }
			    
			    System.out.println("La 1er matrice :");
			    for (int i = 0; i < MP1.length; i++) {
					for (int j = 0; j < MP1[i].length; j++)
		             System.out.print(MP1[i][j] + " ");
					System.out.println("");
				}
				
			    System.out.println("La 2eme matrice :");
			    for (int i = 0; i < MP2.length; i++) {
					for (int j = 0; j < MP2[i].length; j++)
		             System.out.print(MP2[i][j] + " ");
					System.out.println("");
				}
			    
			    int[][] resultProduct = obj.productOfmatrix(MP1, MP2);
			    System.out.println("Le resultat :");
			    for (int i = 0; i < resultProduct.length; i++) {
					for (int j = 0; j < resultProduct[i].length; j++)
		             System.out.print(resultProduct[i][j] + " ");
					System.out.println("");
				}
				break;
				
			case 't':
				System.out.println("La matrice :");
				System.out.println("Entrez le nombre des lignes : ");
				int rowT = scanner.nextInt();
				System.out.println("Entrez le nombre des col : ");
				int colT = scanner.nextInt();
				
				int[][] Mt = new int[rowT][colT];
				
				System.out.println("Voulez vous remplir la matrice aléatoirement? (oui/non) ");
				scanner.nextLine();
			    String answerMt = scanner.nextLine();
			    
			    Random randt = new Random();
			    switch (answerMt) {
			    case "oui":
			    	for(int i=0;i<rowT;i++) {
			    		for(int j=0;j<colT;j++) {
			    			Mt[i][j]=randt.nextInt(10);
			    		}
			    	}
			    	break;
			    case "non":
			    	for(int i=0;i<rowT;i++) {
			    		for(int j=0;j<colT;j++) {
			    			System.out.print("M["+i+"]["+j+"]= ");
			    			Mt[i][j]=scanner.nextInt();
			    		}
			    	}
			    	break;
			    	
			    default: break;}
			    
			    
			    System.out.println("La  matrice :");
			    for (int i = 0; i < Mt.length; i++) {
					for (int j = 0; j < Mt[i].length; j++)
		             System.out.print(Mt[i][j] + " ");
					System.out.println("");
				
			    }
			    
			    int[][] resultTran = obj.transposeOfmatrix(Mt);
			    System.out.println("Le resultat :");
			    for (int i = 0; i < resultTran.length; i++) {
					for (int j = 0; j < resultTran[i].length; j++)
		             System.out.print(resultTran[i][j] + " ");
					System.out.println("");
				}
			    break;
			    
			case 'i':
				System.out.println("La matrice :");
				
				boolean same1= false;
				int rowI = 0;
				int colI = 0;
				while(same1==false) {
					System.out.println("Entrez le nombre des lignes : ");
					rowI = scanner.nextInt();
					System.out.println("Entrez le nombre des col : ");
					colI = scanner.nextInt();
					
					if (rowI != colI) {
						System.out.println("Il faut donner une matrice caree! ");
					}
					else {
						same1=true;
					}
				}
				
				int[][] Mi = new int[rowI][colI];
				
				System.out.println("Voulez vous remplir la matrice aléatoirement? (oui/non) ");
				scanner.nextLine();
			    String answerMi = scanner.nextLine();
			    
			    Random randI = new Random();
			    switch (answerMi) {
			    case "oui":
			    	for(int i=0;i<rowI;i++) {
			    		for(int j=0;j<colI;j++) {
			    			Mi[i][j]=randI.nextInt(10);
			    		}
			    	}
			    	break;
			    case "non":
			    	for(int i=0;i<rowI;i++) {
			    		for(int j=0;j<colI;j++) {
			    			System.out.print("M["+i+"]["+j+"]= ");
			    			Mi[i][j]=scanner.nextInt();
			    		}
			    	}
			    	break;
			    	
			    default: break;}
			    
			    System.out.println("La  matrice :");
			    for (int i = 0; i < Mi.length; i++) {
					for (int j = 0; j < Mi[i].length; j++)
		             System.out.print(Mi[i][j] + " ");
					System.out.println("");
				
			    }
			      
			    double[][] resultInverse = obj.inverseOfMatrix(Mi);
			    System.out.println("Le resultat :");
			    for (int i = 0; i < resultInverse.length; i++) {
					for (int j = 0; j < resultInverse[i].length; j++)
		             System.out.print(resultInverse[i][j] + " ");
					System.out.println("");
				}
			    break;
			
			default: break;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
