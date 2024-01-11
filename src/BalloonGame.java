/*Given a MxN matrix filled with ‘-‘ and you need to drop the balloons in the desired columns starting from the bottom. You need to print the matrix when a new balloon is dropped.
You need to continue getting inputs until the box is full or until the user chooses to stop.

  TEST CASE  :

  Enter the matrix size(m*n)  :  3 3
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  - - -
  - R -
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  B
  Contents of the matrix    :
  - - -
  - B -
  - R -
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  1
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  - B -
  R R -
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - R -
  - B -
  R R -
  Do you wish to continue(Y/N)  :  N
  Program Stopped
2. Extended version of the previous problem. Now you need to quit when a row become filled completely.

  TEST CASE  :

  Enter the matrix size(m*n)  :  3 3
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  - - -
  - R -
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  B
  Contents of the matrix    :
  - - -
  - B -
  - R -
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - R -
  - B -
  - R -
  Column is filled completely. Program is terminated.
3. Extended version of the previous problem. Now you need to drop balloon in the first free cell from left if the specified column is filled in every row.


  TEST CASE  :

  Enter the matrix size(m*n)  :  3 3
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  - - -
  - R -
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  B
  Contents of the matrix    :
  - - -
  - - -
  B R -
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  - - -
  B R R
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  - R -
  B R R
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  B
  Contents of the matrix    :
  - - -
  B R -
  B R R
  Do you wish to continue(Y/N)  :  N
  Program terminated.
4. Extended version of the previous problem. If any column has three continuous balloons of same colors then we need to burst them.

  TEST CASE  :

  Enter the matrix size(m*n)  :  3 3
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  - - -
  - R -
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  - - -
  R R -
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  - - -
  R R R
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  - R -
  R R R
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  B
  Contents of the matrix    :
  - - -
  R R -
  R R R
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  R R R
  R R R
  Do you wish to continue(Y/N)  :  Y
  Enter the column number    :  2
  Enter the color of the balloon  :  R
  Contents of the matrix    :
  - - -
  R - R
  R - R
  Do you wish to continue(Y/N)  :  N
  Program Terminated.
5. Extended version of the previous problem. Now you need to burst the three continuous colors in the same row.*/
import java.util.*;
public class BalloonGame{
    public static void printMatrix(char[][]A,int m,int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean BoxCheck(char[][]A,int m,int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]=='-'){
                    return false;
                }
            }
        }
        return true;
    }
    public static void add1(char[][]A,int m,int n,int cn,char s){
        for(int i=m-1;i>=0;i--){
            if(A[i][cn]=='-'){
                A[i][cn]=s;
                return;
            }
        }
    }
    public static boolean add2(char[][]A,int m,int n,int cn,char s){
        int i;
        for( i=m-1;i>0;i--){
            if(A[i][cn]=='-'){
                A[i][cn]=s;
                return false;
            }
        }
        if(i==0){
            A[0][cn]=s;
            return true;
        }
        return false;
    }
    public static void add3(char[][]A,int m,int n,int cn,char s,boolean b){
        if(b){
            int a=m-1;
            if(A[a][cn]=='-'){
                A[a][cn]=s;
                return;
            }
            for(int i=0;i<cn;i++){
                if(A[a][i]=='-'){
                    A[a][i]=s;
                    return;
                }
            }
            for(int i=cn+1;i<n;i++){
                if(A[a][i]=='-'){
                    A[a][i]=s;
                    return;
                }
            }
            add3(A,m-1,n,cn,s,true);
        }


    }
    public static void columnCheck(char[][]A,int m,int n){
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=2;j--){
                if(A[j][i]=='R' && A[j-1][i]=='R' && A[j-2][i]=='R'){
                    A[j][i]='-';
                    A[j-1][i]='-';
                    A[j-2][i]='-';
                }
                else if (A[j][i]=='B' && A[j-1][i]=='B' && A[j-2][i]=='B') {
                    A[j][i]='-';
                    A[j-1][i]='-';
                    A[j-2][i]='-';
                }
            }
        }
    }

    public static void rowCheck(char[][]A,int m,int n){
        for(int j=m-1;j>=0;j--){
            for(int i=0;i<=n-2;i++){
                if(A[j][i]=='R' && A[j][i+1]=='R' && A[j][i+2]=='R'){
                    A[j][i]='-';
                    A[j][i+1]='-';
                    A[j][i+2]='-';
                }
                else if (A[j][i]=='B' && A[j][i+1]=='B' && A[j][i+2]=='B') {
                    A[j][i]='-';
                    A[j][i+1]='-';
                    A[j][i+2]='-';
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("____________________Balloon Game___________________");
        boolean c=true;
        System.out.println("Enter the matrix size(m*n) : ");
        int m=in.nextInt();
        int n=in.nextInt();
        char[][]A=new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                A[i][j]='-';
            }
        }
        while (c){
            System.out.println("Enter the column number : ");
            int cn=in.nextInt()-1;
            System.out.println("Enter the colour of the balloon (Available colour Red(R) or Blue(B): ");
            char s=in.next().charAt(0);
            //case 1
            //add1(A,m,n,cn,s);
            //case 2
           /* if(add2(A,m,n,cn,s)){
                printMatrix(A,m,n);
                System.out.println("Column is completely filled. Program is terminated.");
                return;
            }
            */
            //case3
            add3(A,m,n,cn,s,true);
            //case4
            columnCheck(A,m,n);
            rowCheck(A,m,n);
            System.out.println("Contents of the matrix : ");
            printMatrix(A,m,n);
            if(BoxCheck(A,m,n)){
                System.out.println("The box is full, Game is end");
                System.out.println("_______________*****_________________");
                return;
            }
            System.out.println("Do you wish to continue?(Y/N)");
            char ans=in.next().charAt(0);
            if(ans=='N' || ans=='n'){
                System.out.println("Program Stopped");
                c=false;
            }

        }

    }
}
