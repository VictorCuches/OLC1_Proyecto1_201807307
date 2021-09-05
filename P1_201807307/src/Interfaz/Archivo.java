package Interfaz;


import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vcuch
 */
public class Archivo {
    public String readJS(String ruta){
        String contenido = "";
        try{
            // PENDIENTE DE VALIDAR QUE SOLO SE ACEPTEN ARCHIVOS .JS
            BufferedReader buf = new BufferedReader(new FileReader(ruta));
            String temp = "";
            String bfRead;
            while((bfRead = buf.readLine()) != null){
                temp += bfRead +"\n";
            }
            contenido = temp;
           
        } catch (Exception e){
            System.out.println("No se encontro el archivo");
        }
        return contenido;
    }
    
}
