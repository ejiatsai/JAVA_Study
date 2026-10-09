import java.util.Scanner;

public class week3HW3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = 0,b = 0,c = 0;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        int max = a;
        if(max > b){
            if(max > c){
                System.out.println("max = " + max);
            }
            else{
                max = c;
                System.out.println("max = " + max);
            }
        }
        else{
            max = b;
            if(max > c){
                System.out.println("max = " + max);
            }
            else{
                max = c;
                System.out.println("max = " + max);
            }
        }

        sc.close();
    }
}
