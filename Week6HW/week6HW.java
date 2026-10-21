package Week6HW;

public class week6HW {
    public static double totalPay(Payable[] people){
        double total = 0;
        for(Payable p : people){
            if(p != null){
                total += p.monthlyPay();
            }
        }
        return total;
    }
    public static void main(String[] args){
        Payable p1;
        p1 = new SalariedEmployee("Thor",30900);
        System.out.println(p1.monthlyPay());
        p1 = new HourlyEmployee("Loki", 205, 160);
        System.out.println(p1.monthlyPay()); 
        p1 = new PieceworkEmployee("Hulk", 25, 1500);
        System.out.println(p1.monthlyPay()); 
        //HW1

        Payable[] p6 = new Payable[6];
        p6[0] = new SalariedEmployee("Thor",30900);
        p6[1] = new HourlyEmployee("Loki", 205, 160);
        p6[2] = new PieceworkEmployee("Hulk", 25, 1500);
        System.out.println("TotalPay:" + totalPay(p6));
        //HW6
    }
}

interface Payable{
    double monthlyPay();
}

abstract class Employee implements Payable{
    private String name;
    public Employee(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

class SalariedEmployee extends Employee{
    private double monthlySalary;
    public SalariedEmployee(String name,double monthlySalary){
        super(name);
        this.monthlySalary = monthlySalary;
    }
    @Override 
    public double monthlyPay(){
        return monthlySalary;
    }
}

class HourlyEmployee extends Employee{
    private double hourlyRate;
    private int hours;
    public HourlyEmployee(String name,double hourlyRate,int hours){
        super(name);
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }
    @Override 
    public double monthlyPay(){
        return hourlyRate * hours;
    }
}

class PieceworkEmployee extends Employee{
    private double pieceRate;
    private int pieces;
    public PieceworkEmployee(String name,double pieceRate,int pieces){
        super(name);
        this.pieceRate = pieceRate;
        this.pieces = pieces;
    }
    @Override 
    public double monthlyPay(){
        return pieceRate * pieces;
    }
}//Hw6