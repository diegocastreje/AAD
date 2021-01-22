/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diego.temporizador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author diego
 */
public class TiemposDao {
    
    public static final String URL_CONEXION = "jdbc:h2:./TemporizadorDB";
    public static final String USUARIO_BD = "root";
    public static final String PASSWORD_BD = "root";
    
    public TiemposDao() {
        crearTablaSiNoExiste();
    }

    private void crearTablaSiNoExiste() {
        try (Connection conexionDataBase =
            DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
            Statement statement = conexionDataBase.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS tiempos" +
                    "(id INTEGER auto_increment, " +
                    "fecha DATE, " +
                    "usuario VARCHAR(255), " +
                    "cubo VARCHAR(255), " +
                    "tiempo DOUBLE(255)) "; 
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }       

    public void guardar(Tiempo tiempo) {
        
        try (Connection conexionDataBase =
            DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
            Statement statement = conexionDataBase.createStatement();
            String sql = "INSERT INTO departamento(fecha, usuario, cubo, tiempo) " +
            "VALUES ('" + tiempo.getFecha() + "', '" + tiempo.getUsuario() + 
                    "','" + tiempo.getCubo() + "', '" + tiempo.getTiempo() + "')";
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            throw new RuntimeException("Ocurrio un error al guardar la informacion: " + ex.getMessage());
        }
        
    }
        
}
