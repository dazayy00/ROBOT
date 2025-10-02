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
public class Torneo {
    private String nombre;
    private String sede;
    private List<Equipo> equiposInscritos;
    
    public Torneo(String nombre, String sede){
        this.nombre = nombre;
        this.sede = sede;
        this.equiposInscritos = new ArrayList<>();
    }
    
    public void inscribirEquipo(Equipo equipo){
        this.equiposInscritos.add(equipo);
        System.out.println("El equipo '" + equipo.nombre + "' ha sido inscrito en el torneo '" + this.nombre + "'.");
    }
    
    public void mostrarEquiposParticipantes() {
        System.out.println("\n--- Equipos participantes en el Torneo: " + nombre + " (" + sede + ") ---");
        equiposInscritos.forEach(equipo -> System.out.println("* " + equipo.nombre));
    }
}
