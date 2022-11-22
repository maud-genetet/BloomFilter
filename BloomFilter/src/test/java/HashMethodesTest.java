/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.ArrayList;
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
     * Test of hash1 method, of class HashMethodes.
     */
    @Test
    public void testHash1() {
        System.out.println("hash1");
        HashMethodes instance = new HashMethodesImpl();
        //assertEquals(0, instance.hash1(0));
        
    }

    /**
     * Test of hash2 method, of class HashMethodes.
     */
    @Test
    public void testHash2() {
        System.out.println("hash2");
        HashMethodes instance = new HashMethodesImpl();
        //assertEquals(7, instance.hash2(7));
        
    }

    /**
     * Test of hash3 method, of class HashMethodes.
     */
    @Test
    public void testHash3() {
        System.out.println("hash3");
        HashMethodes instance = new HashMethodesImpl();
        //assertEquals(1776004908, instance.hash3("Bonjour"));
        //assertEquals(0, instance.hash3(0));
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = -1000; i < 100000; i++) {
            if (a.contains(instance.hash3(i))){
                System.out.println("HashMethodesTest.testHash1()");
            }
            else {
                a.add(instance.hash3(i));
            }
        }
    }

    /**
     * Test of hash4 method, of class HashMethodes.
     */
    @Test
    public void testHash4() {
        System.out.println("hash4");
        HashMethodes instance = new HashMethodesImpl();
        //assertEquals(1285996592, instance.hash4("Bonjour"));
        //assertEquals(321725712, instance.hash4(0));
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        for (int i = 0; i < 100; i++) {
            if (a.contains(instance.hash4(i))){
                //System.out.println(i);
            }
            else {
                a.add(instance.hash4(i));
            }
        }
    }

    public class HashMethodesImpl extends HashMethodes {
    }
    
}
