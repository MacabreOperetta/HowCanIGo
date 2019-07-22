/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgpublic.transport.RoutesProperties;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Macabre Operetta
 */
public class RoutesShortDistance {
    
    
    public ArrayList GetShortDistanceRoutes(ArrayList<String> routes)
    {
        ArrayList distance = new ArrayList();
        Random random = new Random();
        
        for (int i = 0; i < routes.size(); i++) 
        {            
            int cost = random.nextInt(50)+10;
            distance.add(cost);
        }       
        
        return distance;
    }
    
}
