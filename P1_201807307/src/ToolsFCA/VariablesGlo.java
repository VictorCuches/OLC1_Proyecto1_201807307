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
public class VariablesGlo {
    private String tipo;
    private String ident;
    private String value;
    

    public VariablesGlo(String tipo, String ident,String value) {
        this.tipo = tipo;
        this.ident = ident;
        this.value = String.valueOf(value);
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getIdent() {
        return ident;
    }

    public String getTipo() {
        return tipo;
    }

    public String getValue() {
        return value;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValue(String value) {
        this.value = value;
    }
   
    
    
    
   
    
}
