/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Controlador extends ComponenteRobot{
    private String firmware;
    private String modelo;

    public Controlador(String firmware, String modelo) {
        this.firmware = firmware;
        this.modelo = modelo;
    }

  @Override
    public String getDetalles() {
        return "Controlador: "+ modelo + " (v" + firmware + ")";
    }

    @Override
    public String toString() {
        return "Controlador: "+ modelo;
    }
}
