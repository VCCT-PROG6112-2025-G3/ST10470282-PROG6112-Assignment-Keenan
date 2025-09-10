/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package st10470282_prog6112_assignment;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Keenan
 */
public class SeriesRestrictionsTest {
    
    public SeriesRestrictionsTest() {
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
     * Test of SeriesIdRestriction method, of class SeriesRestrictions.
     */
    @Test
    public void testSeriesIdRestriction() {
        System.out.println("SeriesIdRestriction");
        Scanner scan = null;
        int expResult = 0;
        int result = SeriesRestrictions.SeriesIdRestriction(scan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SeriesNameRestrictions method, of class SeriesRestrictions.
     */
    @Test
    public void testSeriesNameRestrictions() {
        System.out.println("SeriesNameRestrictions");
        Scanner scan = null;
        String expResult = "";
        String result = SeriesRestrictions.SeriesNameRestrictions(scan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SeriesAgeRestrictions method, of class SeriesRestrictions.
     */
    @Test
    public void testSeriesAgeRestrictions() {
        System.out.println("SeriesAgeRestrictions");
        Scanner scan = null;
        int expResult = 0;
        int result = SeriesRestrictions.SeriesAgeRestrictions(scan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SeriesEpisodesRestrictions method, of class SeriesRestrictions.
     */
    @Test
    public void testSeriesEpisodesRestrictions() {
        System.out.println("SeriesEpisodesRestrictions");
        Scanner scan = null;
        int expResult = 0;
        int result = SeriesRestrictions.SeriesEpisodesRestrictions(scan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
