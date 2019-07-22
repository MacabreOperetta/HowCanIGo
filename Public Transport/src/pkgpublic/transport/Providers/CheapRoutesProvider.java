/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgpublic.transport.Providers;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Macabre Operetta
 */
public class CheapRoutesProvider {
    
    public ArrayList<String> GetCheapRoutes(ArrayList<String> routes)
    {
        ArrayList<String> cheapRoutesList = new ArrayList<>();
        Random random = new Random();
        ArrayList randomNumberList = new ArrayList();
        
        for (int i = 0; i < routes.size(); i++) 
        {
            int index;
            
            do {
                index = random.nextInt(routes.size());
            } while (randomNumberList.contains(index));
            randomNumberList.add(index);
            
            cheapRoutesList.add(routes.get(index));
        }
        
        return cheapRoutesList;
    }
}
