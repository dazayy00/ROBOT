/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robot;

/**
 *
 * @author johan
 */
public class Alumno {
    private String matricula;
    private String nombre;
    
    public Alumno(String matricula, String nombre) {
        this.matricula = matricula;
        this.nombre = nombre;
    }
    
    public String getMatricula(){
        return matricula;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public String toString(){
        return "Alumno [matricula = "+ matricula + ", nombre = "+ nombre +"]";
    }
}
