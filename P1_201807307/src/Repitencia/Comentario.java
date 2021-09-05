/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repitencia;

/**
 *
 * @author vcuch
 */
public class Comentario {
    private String name_file;
    private String comentario;

    public Comentario(String name_file, String comentario) {
        this.name_file = name_file;
        this.comentario = comentario;
    }

    public String getName_file() {
        return name_file;
    }

    public String getComentario() {
        return comentario;
    }

    public void setName_file(String name_file) {
        this.name_file = name_file;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
    
}
