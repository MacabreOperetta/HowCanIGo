/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import pkgpublic.transport.Login_ScreenController;

/**
 *
 * @author Macabre Operetta
 */
public class UnitTestPublicTransport {
    
    public UnitTestPublicTransport() {
    }
    
    public void TryTest()
    {
        Login_ScreenController lg = new Login_ScreenController();
        boolean expected = lg.CanLogin("Deneme", "");
        boolean actual = false;
        assertEquals(expected, actual);
    }
    
}
