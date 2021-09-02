/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolsFCA;

/**
 *
 * @author vcuch
 */
public class GraficaLinea {
    private String titulo;
 
    private String archivo;

    public GraficaLinea(String titulo, String archivo) {
        this.titulo = titulo;
        this.archivo = archivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    
}
