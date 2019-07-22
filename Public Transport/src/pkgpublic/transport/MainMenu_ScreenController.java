/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgpublic.transport;

import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pkgpublic.transport.Providers.*;
import pkgpublic.transport.RoutesProperties.*;

/**
 *
 * @author Macabre Operetta
 */
public class MainMenu_ScreenController implements Initializable {
            
    @FXML
    ComboBox fromCombobox = new ComboBox();
    @FXML
    ComboBox toCombobox = new ComboBox();
    @FXML
    ListView routeListView = new JFXListView();    
    @FXML
    Label labelsituation = new Label();
    @FXML
    Button showButton = new Button();
    @FXML
    Button saveButton = new Button();
    @FXML
    Label routesLabel = new Label();    
    
    private ArrayList<String> RoutesList = new ArrayList<String>();
    private ArrayList<String> CityList = new ArrayList<String>();
    private ArrayList<String> CheapRoutesList = new ArrayList<String>();
    private ArrayList<String> ShortRoutesList = new ArrayList<String>();
    private ArrayList<String> FastRoutesList = new ArrayList<String>();
    private ArrayList<String> TrafficLessRoutesList = new ArrayList<String>();
    private ArrayList<String> SavedRouteList = new ArrayList<String>();
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        toCombobox.setDisable(true);
        fromCombobox.setDisable(true);
        
        labelsituation.setDisable(true);
        
        CityProvider cityProvider = new CityProvider();        
        CityList = cityProvider.GetCities();
        SortList(CityList);
        
        RoutesProvider routesProvider = new RoutesProvider();
        RoutesList = routesProvider.GetRoutesList();
        SortList(RoutesList);
    }    
    
    public void signOutButtonClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();        
    }
    
    public void createRoutesButtonClick(ActionEvent event)
    {
        fromCombobox.setVisible(true);
        toCombobox.setVisible(true);
        showButton.setVisible(true);
        saveButton.setVisible(true);
        routesLabel.setVisible(true);
        labelsituation.setVisible(true);
        
        fromCombobox.setDisable(false);
        toCombobox.setDisable(false);
              
        fromCombobox.getItems().addAll(CityList);
        toCombobox.getItems().addAll(CityList);
    }
        
    public void showRoutesButton(ActionEvent event)
    {        
        fromCombobox.setVisible(true);
        toCombobox.setVisible(true);
        showButton.setVisible(true);
        saveButton.setVisible(true);
        routesLabel.setVisible(true);
        labelsituation.setVisible(true);
        labelsituation.setDisable(true);        
        routeListView.getItems().clear();
        routeListView.getItems().addAll(RoutesList);    
    }
    
    public void cheapestRoutesCreateButtonClick(ActionEvent event)
    {       
        fromCombobox.setVisible(true);
        toCombobox.setVisible(true);
        showButton.setVisible(true);
        saveButton.setVisible(true);
        routesLabel.setVisible(true);
        labelsituation.setVisible(true);
        labelsituation.setDisable(false);
        labelsituation.setText("\t\tCost");
        CheapRoutesProvider cheapRoutesProvider = new CheapRoutesProvider();
        RoutesCosts routesCosts = new RoutesCosts();
        ArrayList Costs = new ArrayList();
        
        CheapRoutesList = cheapRoutesProvider.GetCheapRoutes(RoutesList);
        Costs = routesCosts.GetRoutesCost(CheapRoutesList);
        SortList(Costs);
        
        for (int i = 0; i < CheapRoutesList.size(); i++) 
        {
            String cost = "\t \t \t \t \t \t \t" + Costs.get(i) + " €";
            String element = CheapRoutesList.get(i);
            CheapRoutesList.set(i, element + cost);
        }
        
        routeListView.getItems().clear();
        routeListView.getItems().addAll(CheapRoutesList);        
    }
    
    public void fastestRoutesButtonClick(ActionEvent event)
    {
        fromCombobox.setVisible(true);
        toCombobox.setVisible(true);
        showButton.setVisible(true);
        saveButton.setVisible(true);
        routesLabel.setVisible(true);
        labelsituation.setVisible(true);
        labelsituation.setDisable(false);
        labelsituation.setText("\tTime");
        FastRoutesProvider fastRoutesProvider = new FastRoutesProvider();
        RoutesTimes routesTimes = new RoutesTimes();
        ArrayList Times = new ArrayList();
        
        FastRoutesList = fastRoutesProvider.GetFastRoutes(RoutesList);
        Times = routesTimes.GetRoutesTime(FastRoutesList);
        SortList(Times);
        
        for (int i = 0; i < FastRoutesList.size(); i++) 
        {
            String time = "\t \t \t \t \t \t" + Times.get(i) + " min.";
            String element = FastRoutesList.get(i);
            FastRoutesList.set(i, element + time);
        }
        
        routeListView.getItems().clear();
        routeListView.getItems().addAll(FastRoutesList);
    }
    
    public void shortestRoutesCreateButtonClick(ActionEvent event)
    {
        fromCombobox.setVisible(true);
        toCombobox.setVisible(true);
        showButton.setVisible(true);
        saveButton.setVisible(true);
        routesLabel.setVisible(true);
        labelsituation.setVisible(true);
        labelsituation.setDisable(false);
        labelsituation.setText("\tDistance");
        ShortRoutesProvider shortRoutesProvider = new ShortRoutesProvider();
        RoutesShortDistance shortDistance = new RoutesShortDistance();
        ArrayList distance = new ArrayList();
        
        ShortRoutesList = shortRoutesProvider.GetShortestRoutes(RoutesList);
        distance = shortDistance.GetShortDistanceRoutes(ShortRoutesList);
        SortList(distance);
        
        for (int i = 0; i < ShortRoutesList.size(); i++) 
        {
            String time = "\t \t \t \t \t \t" + distance.get(i) + " km";
            String element = ShortRoutesList.get(i);
            ShortRoutesList.set(i, element + time);
        }
        
        routeListView.getItems().clear();
        routeListView.getItems().addAll(ShortRoutesList);
    }
    
    public void lessTrafficRoutesCreateButtonClick(ActionEvent event)
    {
        fromCombobox.setVisible(true);
        toCombobox.setVisible(true);
        showButton.setVisible(true);
        saveButton.setVisible(true);
        routesLabel.setVisible(true);
        labelsituation.setVisible(true);
        labelsituation.setDisable(false);
        labelsituation.setText("Traffic Jam");
        LessTrafficRoutesProvider lessTrafficRoutesProvider = new  LessTrafficRoutesProvider();
        RoutesLessTraffic lessTraffic = new RoutesLessTraffic();
        ArrayList trafficStatu = new ArrayList();
        
        TrafficLessRoutesList = lessTrafficRoutesProvider.GetLessTrafficRoutes(RoutesList);
        trafficStatu = lessTraffic.GetTrafficStatuOfRoutes();
        SortList(trafficStatu);
        
        for (int i = 0; i < TrafficLessRoutesList.size(); i++) 
        {
            String time = "\t \t \t \t \t" + trafficStatu.get(i);
            String element = TrafficLessRoutesList.get(i);
            TrafficLessRoutesList.set(i, element + time);
        }
        
        routeListView.getItems().clear();
        routeListView.getItems().addAll(TrafficLessRoutesList);
    }
    
    public void saveRoutesButton(ActionEvent event)
    {
        SavedRouteList.add((String) routeListView.getSelectionModel().getSelectedItem());
    }
    
    public void myRoutesButtonClick(ActionEvent event)
    {
        fromCombobox.setVisible(false);
        toCombobox.setVisible(false);
        showButton.setVisible(false);
        saveButton.setVisible(false);
        labelsituation.setVisible(false);
        routeListView.getItems().clear();
        routeListView.getItems().addAll(SavedRouteList);
        
    }
    
    public void SortList(ArrayList List)
    {
        Collections.sort(List);
    }
        
}
