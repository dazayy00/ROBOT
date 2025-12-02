/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Actuador extends ComponenteRobot{
    private String tipo;
    
    public Actuador(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getDetalles() {
        return "Actuador: "+ tipo;
    }

    @Override
    public String toString() {
        return "Actuador: "+ tipo;
    }
    
}
