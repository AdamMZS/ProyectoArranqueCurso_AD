package org.example;

public class Tarea {

    private final int id;
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;

    public Tarea(int id,Prioridad prioridad, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.completada = false; // Por defecto nace pendiente
        this.prioridad=prioridad;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public Prioridad getPrioridad(){
        return prioridad;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        String estado = completada ? "[X]" : "[ ]";
        return estado + " #" + id+ " - " +prioridad+ " - " + descripcion;
    }
}