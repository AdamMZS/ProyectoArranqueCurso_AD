# Gestor de Tareas en Consola (Java)

Aplicación básica de gestión de tareas en memoria mediante interfaz de consola, diseñada con Programación Orientada a Objetos.

## Estructura del Proyecto

* **`Tarea.java`**: Modelo de datos con atributos (`id`, `descripcion`, `completada`) y formato de visualización.
* **`GestorTareas.java`**: Lógica de negocio y control del listado dinámico (CRUD en memoria con IDs autoincrementales).
* **`Main.java`**: Menú interactivo por consola con validación robusta de entrada de usuario (`Scanner`).

## Funcionalidades

1. **Listar tareas**: Muestra el identificador, descripción y estado (`[ ]` pendiente o `[X]` completada).
2. **Añadir tarea**: Registra una nueva tarea con texto no vacío.
3. **Completar tarea**: Cambia el estado a completada mediante su ID.
4. **Eliminar tarea**: Borra la tarea seleccionada por ID.

## Requisitos y Ejecución

* **Java JDK 17 o superior**
* Compilar y ejecutar desde la clase `Main.java`:
  ```bash
  javac *.java
  java Main