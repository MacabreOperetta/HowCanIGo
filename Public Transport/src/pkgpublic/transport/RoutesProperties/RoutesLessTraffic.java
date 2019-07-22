/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgpublic.transport.RoutesProperties;

import java.util.ArrayList;

/**
 *
 * @author Macabre Operetta
 */
public class RoutesLessTraffic {
    
    public ArrayList<String> GetTrafficStatuOfRoutes()
    {
        ArrayList<String> statu = new ArrayList<String>();
        
        statu.add("High");
        statu.add("Low");
        statu.add("Medium");
        statu.add("Maintenance");
        statu.add("No Traffic");
        
        return statu;
    }
    
    
}
