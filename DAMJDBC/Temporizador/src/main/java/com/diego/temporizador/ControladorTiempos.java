/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diego.temporizador;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author diego
 */
public class ControladorTiempos implements Initializable{
    
    @FXML
    TableView<Tiempo> tablaTiempo;
    
    public static String cubo = "cubo";
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void cargarCronometro(ActionEvent e) throws IOException {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Cronometro.fxml"));

            Scene escena = new Scene(root);
            Image icono = new Image("img/icono.png");
            stage.getIcons().add(icono);
            stage.setScene(escena);
            stage.show();
            ( (Node) (e.getSource() ) ).getScene().getWindow().hide();   
    }
    private void configurarTamanhoColumnas(){
        tablaTiempo.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ObservableList<TableColumn<Tiempo, ?>> columnas = tablaTiempo.getColumns();
        columnas.get(0).setMaxWidth(1f * Integer.MAX_VALUE * 20); 
        columnas.get(1).setMaxWidth(1f * Integer.MAX_VALUE * 30); 
        columnas.get(2).setMaxWidth(1f * Integer.MAX_VALUE * 50);

    }
    
}
