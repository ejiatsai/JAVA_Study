package Week5HW;

public class week5HW {
    public static void main(String[] args) {
        animal a = new animal();
        animal c = new cat();
        // animal d = new dog();
        a.makeSound();
        c.makeSound();
        // d.makeSound();
    }
}

class animal{
    public void makeSound(){
        System.out.println("I am iron man!");
    }
}

class cat extends animal{
    @Override
    public void makeSound(){
        System.out.println("I an spider man!");
    }
}

// class dog extends animal{
//     @Override
//     public void makesound(){
//         System.out.println("I am bat man!");
//     }
// }
