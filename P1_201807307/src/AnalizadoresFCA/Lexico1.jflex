/*
 * Organización de Lenguajes y Compiladores 1 
 * Victor Cuches 201807307
 */

package AnalizadoresFCA;
import java_cup.runtime.Symbol;
import Errores.*;


%% 
%class Lexico
%public 
%line 
%char 
%cup 
%unicode
%ignorecase

%init{ 
    yyline = 1; 
    yycolumn = 1; 
%init} 

ENTERO =[0-9]+ 
CADENA =[\"\“\'] [^\"\”\'\n]* [\"\”\'\n]
BLANCOS=[ \t\r\f\n]+
%%

"+" {return new Symbol(sym.mas,yycolumn,yyline,yytext());}
"-" {return new Symbol(sym.menos,yycolumn,yyline,yytext());}
"*" {return new Symbol(sym.por,yycolumn,yyline,yytext());}
"/" {return new Symbol(sym.div,yycolumn,yyline,yytext());}

"(" {return new Symbol(sym.par1,yycolumn,yyline,yytext());}
")" {return new Symbol(sym.par2,yycolumn,yyline,yytext());}

";" {return new Symbol(sym.puntoycoma,yycolumn,yyline,yytext());}


"mover" {return new Symbol(sym.pr_mover,yyline,yycolumn, yytext());} 
"a" {return new Symbol(sym.pr_a,yyline,yycolumn, yytext());} 
"la" {return new Symbol(sym.pr_la,yyline,yycolumn, yytext());} 
"hacia" {return new Symbol(sym.pr_hacia,yyline,yycolumn, yytext());} 

"izquierda" {return new Symbol(sym.pr_izquierda,yyline,yycolumn, yytext());} 
"derecha" {return new Symbol(sym.pr_derecha,yyline,yycolumn, yytext());} 
"arriba" {return new Symbol(sym.pr_arriba,yyline,yycolumn, yytext());} 
"abajo" {return new Symbol(sym.pr_abajo,yyline,yycolumn, yytext());} 
"saludar" {return new Symbol(sym.pr_saludar,yyline,yycolumn, yytext());} 

{BLANCOS} {} 
{ENTERO} {return new Symbol(sym.entero,yyline,yycolumn, yytext());} 
{CADENA} {return new Symbol(sym.cadena,yyline,yycolumn, yytext());} 

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yycolumn);
AnalizadorLenguaje.errores.add(new MiError(yyline, yycolumn, TipoError.LEXICO, 
            "Se detectó un error léxico (caracter "+yytext()+")"));
}
