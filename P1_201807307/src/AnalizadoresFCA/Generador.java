/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AnalizadoresFCA;

/**
 *
 * @author vcuch
 */
public class Generador {  
    public static void generarCompilador() {
        try {
            String ruta = "src/AnalizadoresFCA/";
            String opcFlex[] = {ruta + "Lexico1.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
           
            String opcCUP[] = {"-destdir", ruta, "-parser", "Parser1", ruta + "Parser1.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
        }     
    }


}
