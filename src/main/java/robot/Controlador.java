/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robot;

/**
 *
 * @author johan
 */
public class Controlador {
    private String firmware;
    private String modelo;
    
    public Controlador(String firmware, String modelo){
        this.firmware = firmware;
        this.modelo = modelo;
    }
    
    @Override
    public String toString(){
        return "Controlador [firmware=" + firmware + ", modelo=" + modelo + "]";
    }
    
}
