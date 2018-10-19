package vectordemo;

public class VectorDemo {

    public static void main(String[] args) {
        Vector v1 = new Vector(2, 3, 5.5);
        Vector v2 = new Vector(10, 23.2, 12);
        
        System.out.printf("v1 = ");
        v1.print(); // v1
        
        System.out.printf("v2 = ");
        v2.print(); // v2
        
        
        Vector add = v1.add(v2); // Addition
        System.out.printf("v1 + v2 = ");
        add.print();
        
        Vector sub = v1.subtract(v2); // Subtraction
        System.out.printf("v1 - v2 = ");
        sub.print();
        
        Vector mul = v1.scalarMultiply(2); // Scalar Multiplication
        System.out.printf("v1 * 2 = ");
        mul.print();
        Vector div = v1.scalarDivide(10); // Scalar Division
        System.out.printf("v1 / 10 = ");
        div.print();
        
        double dot = v1.dotMultiply(v2); // Dot Multiplication
        System.out.printf("v1.v2 = %f\n", dot);
      
        Vector cross = v1.crossMultiply(v2); // Cross Multiplication
        System.out.printf("v1 x v2 = ");
        cross.print();
       
        System.out.printf("|v1| = %f\n", v1.magnitude()); // Magnitude calculation
        System.out.printf("|v2| = %f\n", v2.magnitude());
        
        Vector unit = v2.normalize(); // Normalization of v2
        System.out.printf("Normalized v2 = ");
        unit.print();
        
        Vector projection = v1.projectionOnto(v2);
        System.out.printf("Projection of v1 onto v2 = ");
        projection.print();
    }
    
}
