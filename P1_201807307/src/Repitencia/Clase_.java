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
public class Clase_ {
    private String name_File;
    private String nombreC;
    private ArrayList<String> metodos;
    private String lineas;

    public Clase_(String name_File, String nombreC, ArrayList<String> metodoss, String lineas) {
        this.name_File = name_File;
        this.nombreC = nombreC;
        metodos = new ArrayList<>();
        metodos.addAll(metodoss);
        this.lineas = lineas;
    }

    public String getName_File() {
        return name_File;
    }

    public String getNombreC() {
        return nombreC;
    }

    public ArrayList<String> getMetodos() {
        return metodos;
    }

    public String getLineas() {
        return lineas;
    }

    public void setName_File(String name_File) {
        this.name_File = name_File;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public void setMetodos(ArrayList<String> metodos) {
        this.metodos = metodos;
    }

    public void setLineas(String lineas) {
        this.lineas = lineas;
    }

    
    
    
}
