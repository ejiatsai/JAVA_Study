import java.util.Scanner;

public class week3HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0,sum = 0;
        float ave = 0;
        for(int i = 0;i < 5;i++){
            num = sc.nextInt();
            sum += num;
        }
        ave = sum / 5.0f;
        System.out.println("sum = " + sum);
        System.out.printf("ave = %.1f",ave);

        sc.close();
    }
}
