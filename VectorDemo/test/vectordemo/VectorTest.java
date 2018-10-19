/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectordemo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sojal
 */
public class VectorTest {
    
    public VectorTest() {
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
     * Test of size method, of class Vector.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Vector v1 = new Vector(2, 3, -5);
        int expResult = 3;
        int result = v1.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class Vector.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Vector v2 = new Vector(2, 4, 5);
        Vector v1 = new Vector(2, 3, 4);
        Vector expResult = new Vector(4, 7, 9);
        Vector result = v1.add(v2);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class Vector.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Vector v2 = new Vector(2, 4, 5);
        Vector v1 = new Vector(2, 3, 4);
        Vector expResult = new Vector(0, -1, -1);
        Vector result = v1.subtract(v2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of scalarMultiply method, of class Vector.
     */
    @Test
    public void testScalarMultiply() {
        System.out.println("scalarMultiply");
        double factor = 2;
        Vector v1 =new Vector(5, 6, 3);
        Vector expResult = new Vector(10, 12, 6);
        Vector result = v1.scalarMultiply(factor);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testScalarDivide() {
        System.out.println("scalarDivide");
        double factor = 2;
        Vector v1 = new Vector(4, 10, 12);
        Vector expResult = new Vector(2, 5, 6);
        Vector result = v1.scalarDivide(factor);
        assertEquals(expResult, result);
    }
   

    /**
     * Test of dot method, of class Vector.
     */
    @Test
    public void testDotMultiply() {
        System.out.println("dotMultiply");
        Vector v2 = new Vector(2, 4, -5);
        Vector v1 = new Vector(2, 3, 6);
        double expResult = -14;
        double result = v1.dotMultiply(v2);
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of crossMultiply method, of class Vector.
     */
    @Test
    public void testCrossMultiply3D() {
        System.out.println("crossMultiply");
        Vector v2 = new Vector(3, 8, 6);
        Vector v1 = new Vector(2, 5, 9);
        Vector expResult = new Vector(-42, 15, 1);
        Vector result = v1.crossMultiply(v2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCrossMultiply7D() {
        System.out.println("crossMultiply");
        Vector v2 = new Vector(3, 4, 5, 34, 43, 23, 3);
        Vector v1 = new Vector(2, 23, 4, -4, 24, 5, 6);
        Vector expResult = new Vector(1117, -151, -1143, -314, 284, 125, -481);
        Vector result = v1.crossMultiply(v2);
        assertEquals(expResult, result);
    }

    /**
     * Test of vectorProjectionOnto method, of class Vector.
     */
    @Test
    public void ProjectionOnto() {
        System.out.println("vectorProjectionOnto");
        Vector v2 = new Vector(2, 3, 4);
        Vector v1 = new Vector(4, 7, 8);
        Vector expResult = new Vector(122/29.0, 183/29.0, 244/29.0);
        Vector result = v1.projectionOnto(v2);
        assertEquals(expResult, result);
    }

    /**
     * Test of normalize method, of class Vector.
     */
    @Test
    public void testNormalize() {
        System.out.println("normalize");
        Vector v1 = new Vector(3, 1, 2);
        Vector result = v1.normalize();
        Vector expResult = new Vector(0.801784, 0.267261, 0.534522);
        assertEquals(expResult, result);
    }
/**
     * Test of magnitude method, of class Vector.
     */
    @Test
    public void testMagnitude() {
        System.out.println("magnitude");
        Vector v1 = new Vector(1, -2, 3);
        double expResult = Math.sqrt(14);
        double result = v1.magnitude();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of equals method, of class Vector.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Vector v1 = new Vector(2, 3, 4, 6);
        Vector v2 = new Vector(2, 3, 4, 6);
        boolean expResult = true;
        boolean result = v1.equals(v2);
        assertEquals(expResult, result);
    }
    
}
