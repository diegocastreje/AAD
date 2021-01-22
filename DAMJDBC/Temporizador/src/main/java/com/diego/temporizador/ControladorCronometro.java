/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diego.temporizador;

import java.util.Date;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author diego
 */
public class ControladorCronometro extends Thread implements Initializable{
    
    double segundos = 0;
    static boolean parar = false;
    static Timeline reloj;
    String fecha;
    Date date = new Date();

    
    @FXML
    Label tiempo;
    
    @FXML
    Button inicio;
    
    TiemposDao tiemposDao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fecha = date.getDay() + "-" + date.getMonth() + "-" + date.getYear();
    }
    
    public void cargarTiempos(ActionEvent e) throws IOException{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Tiempos.fxml"));

            Scene escena = new Scene(root);
            Image icono = new Image("img/icono.png");
            stage.getIcons().add(icono);
            stage.setScene(escena);
            stage.show(); 
            ( (Node) (e.getSource() ) ).getScene().getWindow().hide();
    }
    
    public void iniciar(){
        if(!parar){

        reloj = new Timeline(new KeyFrame(Duration.ZERO, e -> { 
            
            tiempo.setText("" + Math.floor(segundos * 100)/100);
            segundos = segundos + (0.01);

        }),
                new KeyFrame(Duration.seconds(0.01))

        );
        
        reloj.setCycleCount(Animation.INDEFINITE);
        reloj.play();
        inicio.setOnAction(new EventHandler<ActionEvent>(){
            
            public void handle(ActionEvent event){
                System.out.println("Para");
                reloj.stop();
                parar = true;
                //guardar();
            }
        });
        }
    }
    
    public void resetear(){
        reloj.stop();
        segundos = 0;
        tiempo.setText("0.00");
        parar = false;
    }
    
    private void guardar(){
       Tiempo tiempo = new Tiempo();
       tiempo.setId(id);
       tiempo.setUsuario(ControladorLogin.user);
       tiempo.setCubo(cubo);
       tiempo.setFecha(fecha);
       tiempo.setTiempo(segundos);     
       
       tiemposDao.guardar(tiempo);    
    }
    
}
