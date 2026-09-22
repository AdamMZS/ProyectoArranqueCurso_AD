package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorTareas{

    private final List<Tarea> tareas;
    private int contadorId;
    public GestorTareas() throws FileNotFoundException {
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
    public void guardarEnArchivo(String ruta){
        BufferedWriter bw=null;
    try{
       bw=new BufferedWriter(new FileWriter(ruta));
        for (Tarea t:tareas){
            bw.write(t.getId()+"-"+t.getPrioridad()+"-"+t.getDescripcion());
            bw.newLine();
        }
        System.out.println("Tareas guardadas correctamente en:"+ruta);
    } catch (IOException e) {
        System.out.println("Error al guardar archivo");
    }finally {
        if (bw!=null){
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    }
}