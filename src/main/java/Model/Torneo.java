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
public class Torneo {
    private String nombre;
    private String sede;
    private List<Equipo> equiposInscritos;

    public Torneo(String nombre, String sede) {
        this.nombre = nombre;
        this.sede = sede;
        this.equiposInscritos = new ArrayList<>();
    }
    
    public void inscribirEquipo(Equipo equipo){
        this.equiposInscritos.add(equipo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getSede() {
        return sede;
    }

    public List<Equipo> getEquiposInscritos() {
        return equiposInscritos;
    }
}
