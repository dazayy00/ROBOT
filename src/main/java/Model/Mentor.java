/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Mentor extends Persona{
    
    public Mentor(String idMentor, String nombre){
        super(idMentor, nombre);
    }
    
    public String getIdMentor(){
        return id;
    }    
    
    @Override
    public String getRol(){
        return "Mentor";
    }

    @Override
    public String toString() {
        return id + nombre;
    }    
    
}
