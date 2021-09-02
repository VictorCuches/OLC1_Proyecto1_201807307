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
public class CompareFile {
    private String ruta1;
    private String ruta2;

    public CompareFile(String ruta1, String ruta2) {
        this.ruta1 = ruta1;
        this.ruta2 = ruta2;
    }

    public String getRuta1() {
        return ruta1;
    }

    public String getRuta2() {
        return ruta2;
    }

    public void setRuta1(String ruta1) {
        this.ruta1 = ruta1;
    }

    public void setRuta2(String ruta2) {
        this.ruta2 = ruta2;
    }
    
    
}
