package complexnumberdemo;

public class ComplexNumberDemo {

    public static void main(String[] args) {
        ComplexNumber x = new ComplexNumber(4, 5);
        ComplexNumber y = new ComplexNumber(2, 3);
        
        System.out.printf("x = ");
        x.print();
        System.out.printf("y = ");
        y.print();
        
        System.out.printf("x + y = ");
        x.add(y).print();
        
        System.out.printf("x - y = ");
        x.subtract(y).print();
        
        System.out.printf("x * y = ");
        x.multiply(y).print();
        
        System.out.printf("x / y = ");
        x.divide(y).print();
    }
    
}
