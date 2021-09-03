/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

/**
 *
 * @author vcuch
 */

public class Token {
    private String lexema;
    private String token;
    private String linea;
    private String columna;
    private String name_archivo;

    public Token(String lexema, String token, String linea, String columna, String name_archivo) {
        this.lexema = lexema;
        this.token = token;
        this.linea = linea;
        this.columna = columna;
        this.name_archivo = name_archivo;
    }

    public String getLexema() {
        return lexema;
    }

    public String getToken() {
        return token;
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

    public void setToken(String token) {
        this.token = token;
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
