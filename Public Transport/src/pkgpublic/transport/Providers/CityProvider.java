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
public class CityProvider {
    
    public ArrayList<String> GetCities()
    {
        ArrayList<String> cities = new ArrayList<String>();
        
        cities.add("Beşiktaş");
        cities.add("Kadıköy");
        cities.add("Levent");
        cities.add("Bağcılar");
        cities.add("Şirinevler");
        cities.add("Avcılar");
        cities.add("Kartal");        
        
        return cities;
    }
}
