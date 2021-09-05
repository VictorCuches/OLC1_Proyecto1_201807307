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
public class Variables {
    private String name_file;
    private String id;

    public Variables(String name_file, String id) {
        this.name_file = name_file;
        this.id = id;
    }

    public String getName_file() {
        return name_file;
    }

    public String getId() {
        return id;
    }

    public void setName_file(String name_file) {
        this.name_file = name_file;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
