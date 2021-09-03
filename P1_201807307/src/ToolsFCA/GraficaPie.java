/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolsFCA;

import java.util.ArrayList;

/**
 *
 * @author vcuch
 */
public class GraficaPie {
    private String titulo;
    private ArrayList<String> ejex;
    private ArrayList<String> valores;

    public GraficaPie(String titulo, ArrayList<String> ejexx, ArrayList<String> valoress) {
        this.titulo = titulo;
        
        ejex = new ArrayList<>();
        ejex.addAll(ejexx);
        valores = new ArrayList<>();
        valores.addAll(valoress);
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<String> getEjex() {
        return ejex;
    }

    public ArrayList<String> getValores() {
        return valores;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEjex(ArrayList<String> ejex) {
        this.ejex = ejex;
    }

    public void setValores(ArrayList<String> valores) {
        this.valores = valores;
    }
 
    

   

    
    
    
}
