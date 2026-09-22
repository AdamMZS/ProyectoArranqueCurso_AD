package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorTareas{

    private final List<Tarea> tareas;
    private int contadorId;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
        this.contadorId = 1;
    }

    public void agregarTarea(Prioridad prioridad,String descripcion) {
        Tarea nuevaTarea = new Tarea(contadorId, prioridad,descripcion);
        tareas.add(nuevaTarea);
        contadorId++;
    }

    public List<Tarea> obtenerTareas() {
        return Collections.unmodifiableList(tareas);
    }

    public boolean marcarComoCompletada(int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null) {
            tarea.setCompletada(true);
            return true;
        }
        return false;
    }

    public boolean eliminarTarea(int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null) {
            tareas.remove(tarea);
            return true;
        }
        return false;
    }

    private Tarea buscarPorId(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
    public List<Tarea> buscarPorPrioridad(Prioridad prioridad){
        List<Tarea> resultado= new ArrayList<>();
        for(Tarea t:tareas){
            if (t.getPrioridad()==prioridad){
            resultado.add(t);
            }
        }
        return resultado;
    }
}