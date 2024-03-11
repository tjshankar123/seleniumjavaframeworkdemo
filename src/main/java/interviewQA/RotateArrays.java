package interviewQA;

import java.util.Scanner;
public class RotateArrays {
         public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int no;
            System.out.print("Enter size of Array : ");
            no = sc.nextInt();
            int[][] a = new int[no][no];
            System.out.print("Enter  "+ no*no+" Element Array : ");

            for(int i = 0; i<no; i++){
                for(int j = 0; j<no; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            System.out.print("\nArray Before Rotation\n\n");
            for(int i = 0; i<no; i++){
                for(int j = 0; j<no; j++){
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("\n");
            //Rotation

            //Transpose
            for(int i = 0; i < no; i++){
                for(int j = i; j < no; j++){
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }

            //Reverse Each row
            for(int i = 0; i < no; i++){
                int l, j;
                for(j = 0, l = no -1; j < l; j++){
                    int temp = a[i][j];
                    a[i][j] = a[i][l];
                    a[i][l] = temp;
                    l--;
                }
            }

            System.out.println("Array After Rotation - \n");

            for(int i = 0; i<no; i++){
                for(int j = 0; j<no; j++){
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }

}
