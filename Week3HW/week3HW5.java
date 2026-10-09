import java.util.Scanner;
import java.util.ArrayList;

class Grade{
    String name;
    float score;
}

public class week3HW5 {
    static int prase_func(String s,ArrayList<Grade> grade,int count){
        String cur = "";
        boolean isname = true;
        Grade g = new Grade();
        for(char ch:s.toCharArray()){
            if(ch == ',' || ch == '\0'){
                if(!cur.isEmpty()) {
                    if(isname){
                        g.name = cur;
                    }
                    else{
                        g.score = Float.parseFloat(cur);
                        grade.add(g);
                        g = new Grade();
                    }

                    isname = !isname;
                    cur = "";
                }
                else if(cur.isEmpty() && !isname){
                    g.score = -1;
                    count++;
                    grade.add(g);
                    g = new Grade();
                }
            }
            else{
                cur += ch;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Grade> gr = new ArrayList<>();
        int N = 0;
        N = sc.nextInt();
        int count = 0;
        for(int i = 0;i < N;i++){
            String TmpData = sc.next();
            count = prase_func(TmpData + '\0', gr,count);
        }
        System.out.println("有效筆數:" + (N - count));
        System.out.println("無效筆數:" + count);
        float sum = 0;
        float max = 0;
        for(int i = 0;i < N;i++){
            if(gr.get(i).score != -1){
                sum += gr.get(i).score;
            }
            if(gr.get(i).score > max){
                max = gr.get(i).score;
            }
        }
        float ave = (float)sum / (N - count);
        System.out.printf("平均:%.2f%n",ave);
        System.out.println("最高分:");
        for(int i = 0;i < N;i++){
            if(gr.get(i).score == max){
                System.out.println(gr.get(i).name);
            }
        }
        
        sc.close();
    }
}