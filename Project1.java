import java.util.*;
import java.io.*;

public class Project1 {

    public static void main(String[] args) throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the name of the file you want to check: "); //user inputs filename
        String file = sc.nextLine();
        sc.close();
        int[][] matrix = new int[10][10]; //creates a matrix 
        System.out.println();
        System.out.println("File input: " + file + "\n");
        
        //reading the input file and stores them into a new file
        Scanner newFile = new Scanner(new File(file));

        for (int i = 0; i < 10; i++)//need a nested loop because it's a multidimensional array
        {
            for (int j = 0; j < 10; j++)
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

    public static void printReflexiveOrNot(int [][] matrix) //reflexive = all diagonal elements are 1
    {
        for(int i = 0; i < 10; i++) //using guard clause to clean up code
        {
            if (matrix[i][i]!= 1)
            {
                System.out.println("Reflexive: no");
                return;
            }
        }
        System.out.println("Reflexive: yes");
    }
    
    public static void printAntiReflexiveOrNot(int [][] matrix) // if any diagonal elements is 1, then it is not anti-reflexive, else yes
    {
        for(int i = 0; i < 10; i++) //guard clause
        {
            if (matrix[i][i]==1)
            {
                System.out.println("Antireflexive: no");
                return;
            }
        }
        System.out.println("Antireflexive: yes");
    }

    public static void printSymmetricOrNot(int [][] matrix) // if the matrix is symmetric(which means matrix and its transpose looks same), then it is symmetric, else not
    {
        
        for (int i = 0; i < 10; i++) //guard clause
        {
            for (int j = i + 1; j < 10; j++)
            {
                if (matrix[i][j]!=matrix[j][i])
                {
                    System.out.println("Symmetric: no");
                    return;
                }
            }
        }
        System.out.println("Symmetric: yes");
    }

    public static void printAntiSymmetricOrNot(int [][] matrix) // if any element of matrix[i][j] and matrix[j][i] is 1, then it is not anti-symmetric, else yes
    {
        for (int i = 0; i < 10; i++) //guard clause
        {
            for (int j = i + 1; j < 10; j++)
            {
                if (matrix[i][j] == 1 && matrix[j][i] == 1)
                {
                    System.out.println("Antisymmetric: no");
                    return;
                }
            }
        }
        System.out.println("Antisymmetric: yes");
    }
}
