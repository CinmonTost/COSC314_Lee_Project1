import java.util.*;
import java.io.*;

public class Project1 {

    public static void main(String[] args) throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the name of the file you want to check: "); //user inputs filename
        String file = sc.nextLine();
        sc.close();

        int matrixSize = 10;
        
        int[][] matrix = new int[matrixSize][matrixSize]; //creates a matrix 
        System.out.println();
        System.out.println("File input: " + file + "\n");
        
        //reading the input file and stores them into a new file
        Scanner newFile = new Scanner(new File(file));

        for (int i = 0; i < matrixSize; i++) //need a nested loop because it's a multidimensional array
        {
            for (int j = 0; j < matrixSize; j++)
            {
                matrix[i][j] = newFile.nextInt(); 
            }
        } //if the code reaches here, newFile is the same as user inputted file
        newFile.close();

        //prints output
        printReflexiveOrNot(matrix);
        printAntiReflexiveOrNot(matrix);
        printSymmetricOrNot(matrix);
        printAntiSymmetricOrNot(matrix);
        System.out.println();

    }

    public static void printReflexiveOrNot(int[][] matrix) //reflexive = all diagonal elements are 1
    {
        int matrixSize = 10;
        for (int i = 0; i < matrixSize; i++) 
        {
            if (matrix[i][i] != 1) // checks array positions of [0][0], [1][1], [2][2] ...
            {
                System.out.println("Reflexive: no"); //The moment there is a 0, it is not reflexive
                return;
            }
        }
        System.out.println("Reflexive: yes");
    }
    
    public static void printAntiReflexiveOrNot(int[][] matrix) // no diagonal value can be a 1
    {   
        int matrixSize = 10;
        int count = 0; //counting 1s
        for (int i = 0; i < matrixSize; i++) 
        {
            if (matrix[i][i] == 1)
            {
                count++;
            }
        }
        if (count > 0 && count <= 10) //if some but not all diagonals are 1s
        {
            System.out.println("Antireflexive: no");
            return;
        }
        
        System.out.println("Antireflexive: yes");
    }

    public static void printSymmetricOrNot(int[][] matrix) // if the matrix's inverses are the same
    {
        int matrixSize = 10;
        for (int i = 0; i < matrixSize; i++) 
        {
            for (int j = i + 1; j < matrixSize; j++)
            {
                if (matrix[i][j] != matrix[j][i])
                {
                    System.out.println("Symmetric: no"); //immediate no if element aren't inverses
                    return;
                }
            }
        }
        System.out.println("Symmetric: yes");
    }

    public static void printAntiSymmetricOrNot(int[][] matrix) // checks for inverses
    {
        int matrixSize = 10;
        for (int i = 0; i < matrixSize; i++) 
        {
            for (int j = i + 1; j < matrixSize; j++)
            {
                if (matrix[i][j] == 1 && matrix[j][i] == 1) //checks if values are the same
                {
                    System.out.println("Antisymmetric: no"); //immediate no if elements are inverses
                    return;
                }
            }
        }
        System.out.println("Antisymmetric: yes");
    }
}
