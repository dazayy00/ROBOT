/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class Robot {
    public String idRobot;
    
    private final List<Sensor> sensores;
    private final List<Actuador> actuadores;
    private final List<Controlador> controladores;
    
    public Robot(String idRobot){
        this.idRobot = idRobot;
        this.sensores = new ArrayList<>();
        this.actuadores = new ArrayList<>();
        this.controladores = new ArrayList<>();
    }
    public String getIdRobot(){
        return idRobot;
    }
    public void agregarSensor(String tipo){
        this.sensores.add(new Sensor(tipo));
    }
    
    public void agregarActuador(String tipo){
        this.actuadores.add(new Actuador(tipo));
    }
    
    public void agregarControlador(String firmware, String modelo){
        this.controladores.add(new Controlador(firmware, modelo));
    }
    
    public void mostrarComponentes(){
        System.out.println("Componentes del Robot:"+ idRobot +" :");
        sensores.forEach(System.out::println);
        actuadores.forEach(System.out::println);
        controladores.forEach(System.out::println);
    }
}
