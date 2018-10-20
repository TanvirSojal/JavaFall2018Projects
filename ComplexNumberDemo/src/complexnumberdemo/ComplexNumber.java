package complexnumberdemo;

class ComplexNumber {
    // a + bi
    private double a;
    private double b;
    
    // constructor
    public ComplexNumber(double a, double b){
        this.a = a;
        this.b = b;
    }
    
    // method to add two ComplexNumbers
    public ComplexNumber add(ComplexNumber that){
        double p = this.a + that.a;
        double q = this.b + that.b;
        return new ComplexNumber(p, q);
    }
    
    // method to subtract two ComplexNumbers
    public ComplexNumber subtract(ComplexNumber that){
        double p = this.a - that.a;
        double q = this.b - that.b;
        return new ComplexNumber(p, q);
    }
    
    // method to multiply two ComplexNumbers
    public ComplexNumber multiply(ComplexNumber that){
        double p = (this.a * that.a) - (this.b * that.b);
        double q = (this.a * that.b) + (this.b * that.a);
        return new ComplexNumber(p, q);
    }
    
    // method to divide two ComplexNumbers
    public ComplexNumber divide(ComplexNumber that){
        if ( Math.abs(that.a) < 0.000001 && Math.abs(that.b) < 0.000001){ // if the number is zero
            System.err.println("Division by Zero");
            return null;
        }
        ComplexNumber conj = new ComplexNumber(that.a, (that.b * -1.0)); // Conjugate of the divider
        ComplexNumber numerator = this.multiply(conj);
        ComplexNumber denominator = that.multiply(conj);
        double p = numerator.a / denominator.a;
        double q = numerator.b / denominator.a;
        return new ComplexNumber(p, q);
    }
    
    
    // method to print in a + bi form
    public void print(){
        if (Math.abs(this.b) < 0.000001){
            System.out.printf("%f\n", this.a);
            return;
        }
        if (this.b == Math.abs(this.b)){
            System.out.printf("%f + %fi\n", this.a, this.b);
        }
        else{
            System.out.printf("%f - %fi\n", this.a, Math.abs(this.b));
        }
        
    }
    
    @Override
    public boolean equals(Object o){ // method to check equality
        ComplexNumber that = (ComplexNumber) o;
        // since they are double value we consider precision loss
        return ( Math.abs(this.a - that.a) < 0.000001 ) && ( Math.abs( this.b - that.b ) < 0.000001 );
    }
}
