package demoApp;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyMapApp extends Application {

  private ArcGISMap map;
  private MapView   mapView;

  @Override
  public void start(Stage stage) throws Exception {
    // create a border pane
    BorderPane borderPane = new BorderPane();
    Scene scene = new Scene(borderPane);

    // size the stage and add a title
    stage.setTitle("My first map application");
    stage.setWidth(600);
    stage.setHeight(350);
    stage.setScene(scene);
    stage.show();

    // create an ArcGISMap that defines the layers of data to view
    map = new ArcGISMap();

    // make the basemap for streets
    map.setBasemap(Basemap.createNationalGeographic());

    // create the MapView JavaFX control and assign its map
    mapView = new MapView();
    mapView.setMap(map);

    // add the MapView
    borderPane.setCenter(mapView);
  }

  @Override
  public void stop() throws Exception {
    // release resources when the application closes
    mapView.dispose();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}