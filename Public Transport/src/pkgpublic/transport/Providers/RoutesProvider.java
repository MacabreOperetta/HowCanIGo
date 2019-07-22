/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgpublic.transport.Providers;

import java.util.ArrayList;

/**
 *
 * @author Macabre Operetta
 */
public class RoutesProvider {
    
    public ArrayList<String> GetRoutesList()
    {
        ArrayList<String> routesList = new ArrayList<String>();
        
        routesList.add("Route_1 ");
        routesList.add("Route_2 ");
        routesList.add("Route_3 ");
        routesList.add("Route_4 ");
        routesList.add("Route_5 ");
        
        
        return routesList;
    }
}
