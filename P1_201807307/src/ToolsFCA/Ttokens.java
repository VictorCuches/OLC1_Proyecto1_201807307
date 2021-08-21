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
public class Ttokens {
    String lexema, tipo, descripcion;
    int linea, columna;
    
    public Ttokens(String le, int li, int col, String tip, String desc){
        lexema = le;
        linea = li;
        columna = col;
        tipo = tip;
        descripcion = desc;
        
        
    }
    
}
