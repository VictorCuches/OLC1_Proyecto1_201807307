/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repitencia;

import java.util.ArrayList;

/**
 *
 * @author vcuch
 */
public class Metodo {
    private String name_File;
    private String nombreM;
    private ArrayList<String> parametros;
    private String lineas;

    public Metodo(String name_File, String nombreM, ArrayList<String> parametross, String lineas) {
        this.name_File = name_File;
        this.nombreM = nombreM;
        parametros = new ArrayList<>();
        parametros.addAll(parametross);
        this.lineas = lineas;
    }

    public String getName_File() {
        return name_File;
    }

    public String getNombreM() {
        return nombreM;
    }

    public ArrayList<String> getParametros() {
        return parametros;
    }

    public String getLineas() {
        return lineas;
    }

    public void setName_File(String name_File) {
        this.name_File = name_File;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public void setParametros(ArrayList<String> parametros) {
        this.parametros = parametros;
    }

    public void setLineas(String lineas) {
        this.lineas = lineas;
    }
    
}
