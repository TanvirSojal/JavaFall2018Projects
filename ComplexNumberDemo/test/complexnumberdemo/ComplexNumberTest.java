package complexnumberdemo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComplexNumberTest {
    
    public ComplexNumberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ComplexNumber c2 = new ComplexNumber(4, 5);
        ComplexNumber c1 = new ComplexNumber(2, 3);
        ComplexNumber expResult = new ComplexNumber(6, 8);
        ComplexNumber result = c1.add(c2);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class ComplexNumber.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        ComplexNumber c2 = new ComplexNumber(4, 5);
        ComplexNumber c1 = new ComplexNumber(2, 3);
        ComplexNumber expResult = new ComplexNumber(-2, -2);
        ComplexNumber result = c1.subtract(c2);
        assertEquals(expResult, result);

    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
         System.out.println("subtract");
        ComplexNumber c2 = new ComplexNumber(2, 3);
        ComplexNumber c1 = new ComplexNumber(4, 5);
        ComplexNumber expResult = new ComplexNumber(-7, 22);
        ComplexNumber result = c1.multiply(c2);
        assertEquals(expResult, result);
    }
    
    @Test // test for ComplexNumber with it's Conjugate
    public void testMultiply1() {
        System.out.println("multiply");
         System.out.println("subtract");
        ComplexNumber c2 = new ComplexNumber(4, 5);
        ComplexNumber c1 = new ComplexNumber(4, -5);
        ComplexNumber expResult = new ComplexNumber(41, 0);
        ComplexNumber result = c1.multiply(c2);
        assertEquals(expResult, result);
    }

    /**
     * Test of divide method, of class ComplexNumber.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        ComplexNumber c2 = new ComplexNumber(14, 5);
        ComplexNumber c1 = new ComplexNumber(20, 30);
        ComplexNumber expResult = new ComplexNumber(1.9457014, 1.4479638);
        ComplexNumber result = c1.divide(c2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDivide1() { // divide by only imaginary part
        System.out.println("divide");
        ComplexNumber c2 = new ComplexNumber(0, 5);
        ComplexNumber c1 = new ComplexNumber(20, 30);
        ComplexNumber expResult = new ComplexNumber(6, -4);
        ComplexNumber result = c1.divide(c2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDivide2() { // divide by zero check
        System.out.println("divide");
        ComplexNumber c2 = new ComplexNumber(0, 0);
        ComplexNumber c1 = new ComplexNumber(20, 30);
        ComplexNumber expResult = null;
        ComplexNumber result = c1.divide(c2);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ComplexNumber.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ComplexNumber c1 = new ComplexNumber(2, 3);
        ComplexNumber c2 = new ComplexNumber(43, 5);
        boolean expResult = false;
        boolean result = c1.equals(c2);
        assertEquals(expResult, result);
    }
    
}
