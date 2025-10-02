/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robot;

/**
 *
 * @author johan
 */
public class Mentor {
    private String idMentor;
    private String nombre;
    
    public Mentor(String idMentor, String nombre){
        this.idMentor = idMentor;
        this.nombre = nombre;
    }
    
    public String getIdMentor(){
        return idMentor;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public String toString(){
        return "Mentor [idMentor=" + idMentor + ", nombre=" + nombre + "]";
    }
}
