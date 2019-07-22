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
public class RoutesTimes {
    
    public ArrayList GetRoutesTime(ArrayList<String> routes)
    {
        ArrayList times = new ArrayList();
        Random random = new Random();
        
        for (int i = 0; i < routes.size(); i++) 
        {            
            int time = random.nextInt(60)+10;
            times.add(time);
        }       
        
        return times;
    }
    
}
