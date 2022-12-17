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
public class TabFilterTest {

    /**
     * Test of isInFilter method, of class TabFilter.
     */
    @Test
    public void testIsInFilter() {
        System.out.println("isInFilter");
        int taille = 1000;
        BloomFilter b = new TabFilter(1,taille);

        int i = 0;
        int i2 = 1;
        String s = "a";

        assertFalse(b.isInFilter(i));
        assertFalse(b.isInFilter(i2));
        assertFalse(b.isInFilter(s));
        
        b.addAObject(i);
        b.addAObject(i2);
        b.addAObject(s);
    
        assertTrue(b.isInFilter(i));
        assertTrue(b.isInFilter(i2));
        assertTrue(b.isInFilter(s));
        
        i2++;
        i++;
        s += "b";
        
        assertTrue(b.isInFilter(i));
        assertFalse(b.isInFilter(i2));
        assertFalse(b.isInFilter(s));
        
    }

    /**
     * Test of addAObject method, of class TabFilter.
     */
    @Test
    public void testAddAObject() {
        System.out.println("addAObject");
        
        int taille = 1000;
        BloomFilter b = new TabFilter(1,taille);

        int i = 0;
        int i2 = 1;

        assertFalse(b.isInFilter(i));
        assertFalse(b.isInFilter(i2));
        
        b.addAObject(i);
        b.addAObject(i2);
    
        assertTrue(b.isInFilter(i));
        assertTrue(b.isInFilter(i2));
    }
    
}
