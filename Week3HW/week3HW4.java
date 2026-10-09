import java.util.Scanner;

public class week3HW4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        n = sc.nextInt();
        int[] gr = new int[100];
        int score = 0;
        int sum = 0,max = 0;
        float ave = 0;
        for(int i = 0;i < n;i++){
            score = sc.nextInt();
            if(score > max){
                max = score;
            }
            sum += score;
            gr[i] = score;
        }
        ave = (float)sum / n;
        System.out.println("sum = " + sum);
        System.out.printf("ave = %.2f%n",ave);
        System.out.println("max = " + max);
        
        sc.close();
    }
}
