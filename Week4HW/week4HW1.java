package Week4HW;

class Rectangle{
    private float width;
    private float height;

    public Rectangle(float width,float height){
        if(width <= 0 || height <= 0){
            throw new IllegalArgumentException("寬和高不得為負數");
        }
        this.width = width;
        this.height = height;
    }

    public float area(){
        return width * height;
    }

    public boolean isSquare(){
        if(width == height){
            return true;
        }
        else{
            return false;
        }
    }
}

public class week4HW1 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(3, 4);
        System.out.println("r1面積:" + r1.area());
        System.out.println("r2面積:" + r2.area());
        System.out.println("r1是否為正方形:" + r1.isSquare());
        System.out.println("r2是否為正方形:" + r2.isSquare());
        // Rectangle r3 = new Rectangle(-1, -4); //透過IllegalArgumentException拒絕負值
    }
}