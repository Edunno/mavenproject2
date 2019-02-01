/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationtests;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.HttpClient;

/**
 *
 * @author Esben
 */
public class WebCalculatorTest {

    HttpClient hc = new HttpClient("http://104.248.22.167:8080/mavenproject2/calculator");

    public WebCalculatorTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        System.out.println("WebCalcTest");
        assert (true);
    }

    @Test
    public void mulIT() {
        String expRes = "Result of: 10*10= 100";
        String res = "";
        try {
            res = hc.makeHttpRequest("?operation=mul&n1=10&n2=10");
        } catch (IOException ex) {
            Logger.getLogger(WebCalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(expRes,res);
    }
}
