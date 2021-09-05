/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.util.ArrayList;

/**
 *
 * @author vcuch
 */
public class ErroresF {
    // pendiente de borrar esta lista jajaja
    //public static ArrayList<ErroresF> listaError = new ArrayList<ErroresF>();

    private String lexema;
    private String tipo;
    private String linea;
    private String columna;
    private String name_archivo;

    public ErroresF(String lexema, String tipo, String linea, String columna, String name_archivo) {
        this.lexema = lexema;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
        this.name_archivo = name_archivo;
    }

    public String getLexema() {
        return lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLinea() {
        return linea;
    }

    public String getColumna() {
        return columna;
    }

    public String getName_archivo() {
        return name_archivo;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public void setName_archivo(String name_archivo) {
        this.name_archivo = name_archivo;
    }
    
}
