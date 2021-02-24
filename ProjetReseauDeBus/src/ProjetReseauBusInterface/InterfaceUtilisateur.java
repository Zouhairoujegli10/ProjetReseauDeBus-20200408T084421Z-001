/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetReseauBusInterface;

import ProjetReseauBusClasse.ArretDAO;
import ProjetReseauBusClasse.BusDAO;
import ProjetReseauBusClasse.DAOFactory;
import ProjetReseauBusClasse.LigneBusDAO;
import ProjetReseauBusClasse.arret;
import ProjetReseauBusClasse.bus;
import ProjetReseauBusClasse.ligneBus;
import ProjetReseauBusClasse.reseauBus;
import com.oracle.jrockit.jfr.Transition;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JFrame;

/**
 *
 * @author Karim
 */
public class InterfaceUtilisateur extends Application {
    
    public static boolean Bottonctive = false;
    public static reseauBus ReseauB;
    public static boolean ok = false;
    private static Pane root = new Pane();
    private static PathTransition Transition1;
    public  void creerLigne(ArrayList<arret> arts, Color col)
    {
        ArrayList<Circle> crls = new ArrayList<>();
    Polyline polyline1 = new Polyline();
        for (arret ar:arts)
        {polyline1.getPoints().addAll(ar.getPositionX(),ar.getPositionY());
          crls.add(new Circle (ar.getPositionX(),ar.getPositionY(),2,Color.WHITE));      
        } 
        polyline1.setStroke(col);
        polyline1.setStrokeWidth(4);
        root.getChildren().add(polyline1);
        for(Circle cr:crls){root.getChildren().add(cr);}
       
   }
    
    @Override
    public void start(Stage primaryStage) {
        ReseauB = new reseauBus();
        Button DemarrerTousLesBus = new Button();
        DemarrerTousLesBus.setLayoutX(600);
        DemarrerTousLesBus.setLayoutY(30);
        DemarrerTousLesBus.setPrefSize(150,30);
        DemarrerTousLesBus.setText("Demarrer Tous Les Bus");
        DemarrerTousLesBus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ReseauB.miseEnServiceTout();
            }
        });
        
        Button ArreterTousLesBus = new Button();
        ArreterTousLesBus.setLayoutX(600);
        ArreterTousLesBus.setLayoutY(80);
        ArreterTousLesBus.setPrefSize(150,30);
        ArreterTousLesBus.setText("Arreter Tous Les Bus");
        ArreterTousLesBus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               ReseauB.miseHorsServiceTous();
            }
        });
        
        Button AjouterUnBus = new Button();
        AjouterUnBus.setLayoutX(600);
        AjouterUnBus.setLayoutY(130);
        AjouterUnBus.setPrefSize(150,30);
        AjouterUnBus.setText("Ajouter Un Bus");
        
        AjouterUnBus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!Bottonctive){
                Bottonctive=true;
                AjouterUnBus ajouterUnBus = new AjouterUnBus();
                ajouterUnBus.setAlwaysOnTop(true);
                ajouterUnBus.requestFocus();
                ajouterUnBus.setVisible(true);
                }
            }
        });
        
        Button ReaffecterUnBus = new Button();
        ReaffecterUnBus.setLayoutX(600);
        ReaffecterUnBus.setLayoutY(180);
        ReaffecterUnBus.setPrefSize(150,30);
        ReaffecterUnBus.setText("Reaffecter Un Bus");
        ReaffecterUnBus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 if(!Bottonctive){
                Bottonctive=true;
                ReaffecterUnBus ReaffecterUnBus = new ReaffecterUnBus();
                ReaffecterUnBus.setAlwaysOnTop(true);
                ReaffecterUnBus.setVisible(true);
            }}
        });
        Button ArreterUnBus = new Button();
        ArreterUnBus.setLayoutX(600);
        ArreterUnBus.setLayoutY(230);
        ArreterUnBus.setPrefSize(150,30);
        ArreterUnBus.setText("Arreter Un Bus");
        ArreterUnBus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  if(!Bottonctive){
                Bottonctive=true;
                ArreterUnBus ArreterUnBus = new ArreterUnBus();
                ArreterUnBus.setAlwaysOnTop(true);
                ArreterUnBus.setVisible(true);
            }}
        });
        Button DemarrerUnBus = new Button();
        DemarrerUnBus.setLayoutX(600);
        DemarrerUnBus.setLayoutY(280);
        DemarrerUnBus.setPrefSize(150,30);
        DemarrerUnBus.setText("Demarrer Un Bus");
        DemarrerUnBus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              if(!Bottonctive){
                Bottonctive=true;   
                DemarrerUnBus DemarrerUnBus = new DemarrerUnBus();
                DemarrerUnBus.setAlwaysOnTop(true);
                DemarrerUnBus.setVisible(true);
            }}
        });
        Button quite = new Button();
        quite.setLayoutX(600);
        quite.setLayoutY(350);
        quite.setPrefSize(150,30);
        quite.setText("Quite");
        quite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        Rectangle chema = new Rectangle(30, 20, 530, 370);
        chema.setFill(Color.WHITE);
        
        Rectangle button = new Rectangle(570, 20, 210, 370);
        button.setFill(Color.WHITE);
        root.getChildren().add(chema);
        root.getChildren().add(button);
        root.getChildren().add(DemarrerTousLesBus);
        root.getChildren().add(ArreterTousLesBus);
        root.getChildren().add(AjouterUnBus);
        root.getChildren().add(ReaffecterUnBus);
        root.getChildren().add(ArreterUnBus);
        root.getChildren().add(DemarrerUnBus);
        root.getChildren().add(quite);
        
        
        ArrayList<ligneBus> lbus = ReseauB.getLignesBus();
        Color cols[]= {Color.BLUE,Color.BROWN,Color.CHOCOLATE,Color.AQUA,Color.DARKGREEN};
        int i=0;
        for(ligneBus lbs:lbus)
        {creerLigne(lbs.getArrets(),cols[i]);i++;}
        
        Scene scene = new Scene(root, 800, 400);
        
        primaryStage.setTitle("Erojet reseau de bus");
        primaryStage.setScene(scene);
        primaryStage.show();
                
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
