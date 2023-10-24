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

    public static void printReflexiveOrNot(int[][] matrix) //reflexive = all diagonal elements are 1
    {
        for (int i = 0; i < 10; i++) 
        {
            if (matrix[i][i]!= 1) // checks array positions of [0][0], [1][1], [2][2] ...
            {
                System.out.println("Reflexive: no");
                return;
            }
        }
        System.out.println("Reflexive: yes");
    }
    
    public static void printAntiReflexiveOrNot(int[][] matrix) // no diagonal value can be a 1
    {
        for (int i = 0; i < 10; i++) 
        {
            if (matrix[i][i]==1)
            {
                System.out.println("Antireflexive: no");
                return;
            }
        }
        System.out.println("Antireflexive: yes");
    }

    public static void printSymmetricOrNot(int[][] matrix) // if the matrix's transpose is identical
    {
        
        for (int i = 0; i < 10; i++) 
        {
            for (int j = i + 1; j < 10; j++)
            {
                if (matrix[i][j] != matrix[j][i])
                {
                    System.out.println("Symmetric: no");
                    return;
                }
            }
        }
        System.out.println("Symmetric: yes");
    }

    public static void printAntiSymmetricOrNot(int[][] matrix) // check if value of [i][j] and [j][i] are the same
    {
        for (int i = 0; i < 10; i++) 
        {
            for (int j = i + 1; j < 10; j++)
            {
                if (matrix[i][j] == 1 && matrix[j][i] == 1) //checks if values are the same
                {
                    System.out.println("Antisymmetric: no");
                    return;
                }
            }
        }
        System.out.println("Antisymmetric: yes");
    }
}
