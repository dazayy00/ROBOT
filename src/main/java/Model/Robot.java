/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class Robot {
    private String idRobot;
    
    private final List<ComponenteRobot> componentes;
    
    public Robot(String idRobot){
        this.idRobot = idRobot;
        this.componentes = new ArrayList<>();
    }
    
    public String getIdRobot(){
        return idRobot;
    }
    
    public void agregarComponente(ComponenteRobot componente) {
        this.componentes.add(componente);
    }
    
    public List<ComponenteRobot> getComponentes() {
        return componentes;
    }
}
