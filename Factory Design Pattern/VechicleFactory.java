import java.util.Scanner;

interface Vechicle {
    public void model();
    public void wheels();
}
class Car implements Vechicle {
    public void model(){
        System.out.println("BMW");
    }
    public void wheels(){
        System.out.println("4 wheels");
    }
}

class Bike implements Vechicle {
    public void model(){
        System.out.println("Hero");
    }
    public void wheels(){
        System.out.println("2 wheels");
    }
}

/**
 * FactoryMethod
 */
class FactoryMethod {
    public static Vechicle getInstance(String type){
        if(type.equals("Car")){
            return new Car();
        }
        else if(type.equals("Bike")){
            return new Bike();
        }else{
            return null;
        }
    }
}

public class VechicleFactory {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String type=sc.next();
        Vechicle instace=FactoryMethod.getInstance(type);
        instace.model();
        instace.wheels();
    }
}

/*
 Product Features -> Factory Method -> client 
 */



