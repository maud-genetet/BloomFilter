/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author maud
 */
public class HashMethodesTest {

    /**
     * Test of hash0 method, of class HashMethodes.
     */
    @Test
    public void testHash0() {
        System.out.println("hash0");
        
        int i = 1;
        int i2 = 101;
        
        int m = 100;
        HashMethodes hash = new HashMethodes(m);
        assertEquals(1, hash.hash0(i));
        assertEquals(1, hash.hash0(i2));
    }

    /**
     * Test of hash1 method, of class HashMethodes.
     */
    @Test
    public void testHash1() {
        System.out.println("hash1");
        
        int i = 1;
        int i2 = 101;
        
        int m = 100;
        HashMethodes hash = new HashMethodes(m);
        assertEquals((1+1)*3, hash.hash1(i));
        assertEquals((1+1)*3, hash.hash1(i2));
    }

    /**
     * Test of hash2 method, of class HashMethodes.
     */
    @Test
    public void testHash2() {
        System.out.println("hash2");
        
        int i = 1;
        int i2 = 101;
        
        int m = 100;
        HashMethodes hash = new HashMethodes(m);
        assertEquals((1+33)*7%100, hash.hash2(i));
        assertEquals((1+33)*7%100, hash.hash2(i2));
    }

    /**
     * Test of hash3 method, of class HashMethodes.
     */
    @Test
    public void testHash3() {
        System.out.println("hash3");
       
        int i = 1;
        int i2 = 101;
        
        int m = 100;
        HashMethodes hash = new HashMethodes(m);
        assertEquals(44, hash.hash3(i));
        assertEquals(44, hash.hash3(i2));
    }

    /**
     * Test of hash4 method, of class HashMethodes.
     */
    @Test
    public void testHash4() {
        System.out.println("hash4");
        
        int i = 1;
        int i2 = 101;
        
        int m = 100;
        HashMethodes hash = new HashMethodes(m);
        assertEquals((1+17)*17%100, hash.hash4(i));
        assertEquals((1+17)*17%100, hash.hash4(i2));
    }
    
}
