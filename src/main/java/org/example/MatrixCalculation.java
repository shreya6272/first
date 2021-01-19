package org.example;
import java.util.Scanner;

public class MatrixCalculation {

    public void matrixSum(int a[][],int b[][],int r,int c){
        int sum[][] = new int[r][c];
        for(int i=0;i<r;i++) {
            for (int j=0; j<c; j++)
                sum[i][j] = a[i][j] + b[j][j];
        }
        for(int i=0;i<r;i++){
            for(int j=0; j<c; j++)
                System.out.print(sum[i][j]+ "\t");
            System.out.println();
        }

    }
    public void matrixScalarMul(int a[][],int value,int r, int c){
        int mul[][] = new int[r][c];
        for(int i=0;i<r;i++) {
            for (int j=0; j<c; j++)
                mul[i][j] = value * a[i][j];
        }
        for(int i=0;i<r;i++){
            for(int j=0; j<c; j++)
                System.out.print(mul[i][j]+ "\t");
            System.out.println();
        }
    }
    public void matrixTrans(int a[][], int r, int c){
        int b[][]= new int[c][r];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++) {
                b[j][i]= a[i][j];
            }
        }
        for(int i=0;i<c;i++){
            for(int j=0; j<r; j++)
                System.out.print(b[i][j]+ "\t");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int i,j,r,c;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of matrix");
        r = in.nextInt();
        c = in.nextInt();
        int first[][] = new int[r][c];
        int second[][] = new int[r][c];

        System.out.println("Enter the elements of first matrix");
        for (i=0; i<r; i++) {
            for (j = 0; j < c; j++)
                first[i][j] = in.nextInt();
        }
        System.out.println("Enter the elements of second matrix");
        for (i=0 ; i<r; i++) {
            for (j = 0; j < c; j++)
                second[i][j] = in.nextInt();
        }
        MatrixCalculation mac= new MatrixCalculation();
        for (i=0; i<r; i++) {
            for (j = 0; j < c; j++)
                System.out.print(first[i][j]+"\t");
            System.out.println();
        }
        for (i=0; i<r; i++) {
            for (j = 0; j < c; j++)
                System.out.print(second[i][j]+"\t");
            System.out.println();
        }

        System.out.println("The sum of first and second matrix is : \n");
        mac.matrixSum(first,second, r,c);
        System.out.println("Enter a number to be multiplied with matrix: \n");
        int n = in.nextInt();
        System.out.println("The result of multiplication with first matrix is: \n");
        mac.matrixScalarMul(first,n,r,c);
        System.out.println("The result of multiplication with second matrix is: \n");
        mac.matrixScalarMul(second,n,r,c);
        System.out.println("Transportation of first matrix is: ");
        mac.matrixTrans(first,r,c);
        System.out.println("Transportation of second matrix is: ");
        mac.matrixTrans(second,r,c);

    }

}
