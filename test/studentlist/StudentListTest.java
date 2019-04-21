/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlist;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zhuan
 */
public class StudentListTest {
    
    public StudentListTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void phoneDeseiralizeTest() {
        Phone phone=new Phone();
        phone.deserialize("001-647(607)5668");
        assertEquals("001",phone.countryCode);
        assertEquals("647",phone.areaCode);
        assertEquals("607",phone.code1);
        assertEquals("5668",phone.code2);
    }
    
    @Test
    public void phoneSerializeTest() {
        Phone phone=new Phone();
        phone.countryCode="002";
        phone.areaCode="905";
        phone.code1="456";
        phone.code2="1234";
        assertEquals("002-905(456)1234",phone.toString());
                
    }
}
