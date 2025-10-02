/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robot;

/**
 *
 * @author johan
 */
public class Sensor {
    private String tipo;
    
    public Sensor (String tipo){
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return "Sensor [tipo=" + tipo + "]";
    }
}
