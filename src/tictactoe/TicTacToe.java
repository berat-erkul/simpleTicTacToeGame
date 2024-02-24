package tictactoe;
import java.util.Scanner;

public class TicTacToe {
 
    // Method to check for 'x' winning scenarios
    public static boolean xControl(char[][] matrix){

        boolean hasWon = false;
        
        // Checking each scenario where 'x' can win
        if (matrix[0][0]=='x' && matrix[1][1]=='x' && matrix[2][2]=='x' ||      //1
            matrix[0][2]=='x' && matrix[1][1]=='x' && matrix[2][0]=='x' ||      //2
            matrix[0][0]=='x' && matrix[0][1]=='x' && matrix[0][2]=='x' ||      //3
            matrix[1][0]=='x' && matrix[1][1]=='x' && matrix[1][2]=='x' ||      //4
            matrix[2][0]=='x' && matrix[2][1]=='x' && matrix[2][2]=='x' ||      //5    
            matrix[0][0]=='x' && matrix[1][0]=='x' && matrix[2][0]=='x' ||      //6 
            matrix[0][1]=='x' && matrix[1][1]=='x' && matrix[2][1]=='x' ||      //7    
            matrix[0][2]=='x' && matrix[1][2]=='x' && matrix[2][2]=='x'         //8    
        ){
            System.out.println("Congratulations! X, you won :)");
            System.out.println("Sorry, O, you lost :(");      
            hasWon = true;
        }        
            
        return hasWon;
    }
 
//---------------------------------------------------------------------------------------    
    
    // Method to check for 'o' winning scenarios
    public static boolean oControl(char[][] matrix){

        boolean hasWon = false;
        
        // Checking each scenario where 'o' can win
        if  (matrix[0][0]=='o' && matrix[1][1]=='o' && matrix[2][2]=='o' ||     //1
             matrix[0][2]=='o' && matrix[1][1]=='o' && matrix[2][0]=='o' ||     //2
             matrix[0][0]=='o' && matrix[0][1]=='o' && matrix[0][2]=='o' ||     //3
             matrix[1][0]=='o' && matrix[1][1]=='o' && matrix[1][2]=='o' ||     //4
             matrix[2][0]=='o' && matrix[2][1]=='o' && matrix[2][2]=='o' ||     //5    
             matrix[0][0]=='o' && matrix[1][0]=='o' && matrix[2][0]=='o' ||     //6 
             matrix[0][1]=='o' && matrix[1][1]=='o' && matrix[2][1]=='o' ||     //7    
             matrix[0][2]=='o' && matrix[1][2]=='o' && matrix[2][2]=='o'        //8    
        ){                
            System.out.println("Congratulations! O, you won :)");
            System.out.println("Sorry, X, you lost :(");    
            hasWon = true;
        }        
            
        return hasWon;
    }
    
//---------------------------------------------------------------------------------------    
    
    // Method to print the game board
    public static void printMap(char[][] matrix){
    
        System.out.println("");
        System.out.println("");
        
        
        // Print the game board
        for (int i = 0; i < 3; i++) {                
            for (int j = 0; j < 3; j++) {                    
               System.out.print(matrix[i][j] + " ");                                   
            }                                    
            System.out.println("");                
        }        
    }
    
//---------------------------------------------------------------------------------------    
    
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        
        char[][] matrix = new char[3][3];  // Create an empty 3x3 matrix
        
        for (int i = 0; i < 3; i++) {            
            
            for (int j = 0; j < 3; j++) {                
                
                matrix[i][j] = '_';        // Initialize all elements of the matrix with "_"        
            }            
        }
                
        printMap(matrix);      // Print the game board
                
        int count = 1;        // Counter to alternate between 'x' and 'o' moves
        
        while(true){                    
            
            if (count%2==1) {   // If odd, it's 'x' turn
                
                System.out.println("Player X's turn... ");
                
                System.out.print("Enter column number: ");                
                int xSelectRow = scn.nextInt()-1;           
                
                System.out.print("Enter row number: ");
                int xSelectCol= scn.nextInt()-1;
                
                // Replace the selected cell with 'x'
                matrix[xSelectCol][xSelectRow] = 'x';
                
                printMap(matrix);      // Print the game board
                                               
                if (xControl(matrix)==true) {       // Check if 'x' has won
                    break;   // If 'x' has won, end the game
                }                      
            }           
            
            
            
            if (count%2==0) {   // If even, it's 'o' turn
                
                System.out.print("Player O's turn... ");
                
                System.out.print("Enter column number: ");                
                int oSelectRow = scn.nextInt()-1;           
                
                System.out.print("Enter row number: ");
                int oSelectCol= scn.nextInt()-1;
                
                // Replace the selected cell with 'o'
                matrix[oSelectCol][oSelectRow] = 'o';
                               
                printMap(matrix);   // Print the game board
                
                if (oControl(matrix)==true) {       // Check if 'o' has won           
                    break;    // If 'o' has won, end the game
                }                                       
            }                             
            
            count++;   // Increment the counter for the next turn         
        }                        
    }    
}
