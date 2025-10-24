/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Alumno extends Persona {
    
    public Alumno(String matricula, String nombre) {
        super(matricula, nombre);
    }
    
    public String getMatricula(){
        return id;
    }

    @Override
    public String getRol(){
        return "Alumno";
    }
    
    @Override
    public String toString(){
        return id + nombre;
    }
}
