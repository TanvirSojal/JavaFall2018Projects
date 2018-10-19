package vectordemo;

import java.util.ArrayList;

class Vector {
    ArrayList < Double >  components = new ArrayList<>(); // components of the Vector
    double EPS; // epsilon for our floating point computation
    
    // constructor method
    public Vector(double x, double ...u){ // taking arbitrary number of parameters, since dimension is not fixed, but at least 1
        
        this.components.add(x); // adding the first mandatory argument
        for (int i = 0; i < u.length; i++){ // adding the rest of the arguments
            this.components.add(u[i]);
        }
        
        this.EPS = 0.00001; // 10 ^ -5 is used as epsilon
    }
    
    // copy constructor method
    public Vector(Vector copy){
        for (int i = 0; i < copy.size(); i++){
            double value = copy.components.get(i);
            this.components.add(value);
        }
        EPS = copy.EPS;
    }
    
    public int size(){ // method to return size/dimension of the Vector
        return this.components.size();
    }
    
    // method to add two Vectors of same vector space
    public Vector add(Vector that){ 
        if (this.size() != that.size()){ // Vectors of different dimensions are incompatible for addition
            throw new IllegalArgumentException("Can not add Vectors of different sizes!");
        }
        
        Vector now = new Vector(this); // copying this to another Vector
        for (int i = 0; i < now.size(); i++){
            double value = now.components.get(i) + that.components.get(i);
            now.components.set(i, value);
        }
        return now;
    }
    
    // method to subtract a Vector
    public Vector subtract(Vector that){
        if (this.size() != that.size()){ // Vectors of different dimensions are incompatible for subtraction
            throw new IllegalArgumentException("Can not subtract Vectors of different sizes!");
        }
        
        Vector now = new Vector(this); // copying this to another Vector
        for (int i = 0; i < now.size(); i++){
            double value = now.components.get(i) - that.components.get(i);
            now.components.set(i, value);
        }
        return now;
    }
    
    // method to multiply the Vector with a constant
    public Vector scalarMultiply(double factor){
        Vector now = new Vector(this); // copying this to another Vector
        for (int i = 0; i < now.size(); i++){
            double value = now.components.get(i) * factor; // multiplying every component with given constant factor
            now.components.set(i, value);
        }
        return now;
    }
    
    // method to divide the Vector with a constant
    public Vector scalarDivide(double factor){
        if (factor < this.EPS){ // dividing by zero or too small value
            throw new IllegalArgumentException("Can not perform Division by Zero!");
        }
        
        Vector now = new Vector(this); // copying this to another Vector
        for (int i = 0; i < now.size(); i++){
            double value = now.components.get(i) / factor; // dividing every component with given constant factor
            now.components.set(i, value);
        }
        return now;
    }
    
    // method to Dot Multiply two Vectors in same vector space
    public double dotMultiply(Vector that){
        if (this.size() != that.size()){ // Vectors of different dimensions are incompatible for dot multiplication
            throw new IllegalArgumentException("Can not subtract Vectors of different sizes!");
        }
        
        double result = 0;
        for (int i = 0; i < this.size(); i++){
            result = result + ( this.components.get(i) * that.components.get(i) ); // multiplying corresponding components of both Vectors
        }
        return result;
    }
    
    // method to Cross Multiply two Vectors in same vector space
    // Cross product is possible only in 3D and 7D vector spaces
    public Vector crossMultiply(Vector that){
        if (this.size() != that.size()){
            throw new IllegalArgumentException("Vectors must be of equal sizes!");
        }
        if (this.size()!=3 && this.size()!=7){
            throw new IllegalArgumentException("Cross Product only possible in 3rd and 7th Dimensions");
        }
        if (this.size() == 3){ // cross multiplication for 3D Vector
            
            double u1 = ( this.components.get(1) * that.components.get(2) ) - ( this.components.get(2) * that.components.get(1) );
            double u2 = ( this.components.get(2) * that.components.get(0) ) - ( this.components.get(0) * that.components.get(2) );
            double u3 = ( this.components.get(0) * that.components.get(1) ) - ( this.components.get(1) * that.components.get(0) );
            
            return new Vector(u1, u2, u3);
        }
        else{ // cross multiplication for 7D Vector
            double u1 = ( this.components.get(1) * that.components.get(3) ) - ( this.components.get(3) * that.components.get(1) )
                      + ( this.components.get(2) * that.components.get(6))  - ( this.components.get(6) * that.components.get(2) )
                      + ( this.components.get(4) * that.components.get(5))  - ( this.components.get(5) * that.components.get(4) );
            
            double u2 = ( this.components.get(2) * that.components.get(4) ) - ( this.components.get(4) * that.components.get(2) )
                      + ( this.components.get(3) * that.components.get(0))  - ( this.components.get(0) * that.components.get(3) )
                      + ( this.components.get(5) * that.components.get(6))  - ( this.components.get(6) * that.components.get(5) );
            
            double u3 = ( this.components.get(3) * that.components.get(5) ) - ( this.components.get(5) * that.components.get(3) )
                      + ( this.components.get(4) * that.components.get(1))  - ( this.components.get(1) * that.components.get(4) )
                      + ( this.components.get(6) * that.components.get(0))  - ( this.components.get(0) * that.components.get(6) );
            
            double u4 = ( this.components.get(4) * that.components.get(6) ) - ( this.components.get(6) * that.components.get(4) )
                      + ( this.components.get(5) * that.components.get(2))  - ( this.components.get(2) * that.components.get(5) )
                      + ( this.components.get(0) * that.components.get(1))  - ( this.components.get(1) * that.components.get(0) );
            
            double u5 = ( this.components.get(5) * that.components.get(0) ) - ( this.components.get(0) * that.components.get(5) )
                      + ( this.components.get(6) * that.components.get(3))  - ( this.components.get(3) * that.components.get(6) )
                      + ( this.components.get(1) * that.components.get(2))  - ( this.components.get(2) * that.components.get(1) );
            
            double u6 = ( this.components.get(6) * that.components.get(1) ) - ( this.components.get(1) * that.components.get(6) )
                      + ( this.components.get(0) * that.components.get(4))  - ( this.components.get(4) * that.components.get(0) )
                      + ( this.components.get(2) * that.components.get(3))  - ( this.components.get(3) * that.components.get(2) );
            
            double u7 = ( this.components.get(0) * that.components.get(2) ) - ( this.components.get(2) * that.components.get(0) )
                      + ( this.components.get(1) * that.components.get(5))  - ( this.components.get(5) * that.components.get(1) )
                      + ( this.components.get(3) * that.components.get(4))  - ( this.components.get(4) * that.components.get(3) );
            
            return new Vector(u1, u2, u3, u4, u5, u6, u7);
        }
    }

    // method to compute Vector Projection onto another Vector
    // formula: B * ( |A . B| / (|B|)^2 )
    public Vector projectionOnto(Vector that){
        double magnitudeOfThat = that.magnitude();
        double factor = this.dotMultiply(that) / ( magnitudeOfThat * magnitudeOfThat ); 
        return that.scalarMultiply(factor); 
    }
    
    // method to transform Vector into unit vector
    // formula: A / |A|
    public Vector normalize(){ 
        double magnitude = this.magnitude();
        if (magnitude < this.EPS){ // if magnitude is zero
            throw new IllegalArgumentException("Can not normalize Zero Vector!");
        }
        
        Vector now = new Vector(this);
        for (int i = 0; i < this.size(); i++){
            double value = now.components.get(i) / magnitude; // dividing each component with magnitude |v|
            now.components.set(i, value);
        }
        return now;
    }
    
    // method to calculate magnitude |v| of a vector
    public double magnitude(){
        double result = 0;
        for (int i = 0; i < this.size(); i++){ // formula is to sum the squares of every component then return square root of the sum
            result = result + ( this.components.get(i) * this.components.get(i) );
        }
        return Math.sqrt(result);
    }
    
    // function to print a Vector
    public void print(){
        int len = this.size();
        System.out.printf("[ "); // starting bracket
        for (int i = 0; i < len; i++){
            if (i == len-1){
                System.out.printf("%f", components.get(i)); // printing newline instead of comma for the last component
            }
            else {
                System.out.printf("%f, ", components.get(i)); // print other components
            }
        }
        System.out.printf(" ]\n"); // closing bracket
    }
    
    // function to check if two Vectors are equal
    @Override
    public boolean equals(Object o){
        Vector that = (Vector) o; // converting object to Vector
        
        int thisLength = this.size(); // size of current object compoments
        int thatLength = that.size(); // size of componets of object we are comparing to
        
        if (thisLength != thatLength) // if their sizes are not same, they are not equal
            return false;
        
        for (int i = 0; i < thisLength; i++){                    // based on our precision check
            if (Math.abs(this.components.get(i) - that.components.get(i)) > this.EPS) // if at any dimension they have different axis value
                return false;                                            // they are not equal
        }
        
        return true; // otherwise, they are equal
    }
}
