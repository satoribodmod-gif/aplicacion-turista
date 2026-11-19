# Llanquihue Tour

Aplicación de consola en Java para consultar información turística y gestionar empleados asociados a la agencia Llanquihue Tour. El programa carga datos desde archivos de texto, los almacena en colecciones y permite mostrarlos, filtrarlos y buscarlos.

## Funcionalidades

- Carga tours desde `tours.txt` y los muestra por consola.
- Filtra los tours gastronómicos.
- Carga empleados desde `personal.txt` y los almacena en una `ArrayList`.
- Muestra a los empleados con sus datos personales, dirección, código y cargo.
- Filtra a los empleados con el cargo de guía turístico.
- Busca empleados por nombre, sin distinguir entre mayúsculas y minúsculas.
- Comprueba el formato básico del RUT y omite registros con un RUT inválido.

## Estructura

```text
src/
└── main/
    ├── java/
    │   ├── data/
    │   │   └── GestorDatos.java
    │   ├── exception/
    │   │   └── RutInvalidoException.java
    │   ├── model/
    │   │   ├── Direccion.java
    │   │   ├── Empleado.java
    │   │   ├── Persona.java
    │   │   ├── Rut.java
    │   │   └── Tour.java
    │   └── ui/
    │       └── Main.java
    └── resources/
        ├── personal.txt
        └── tours.txt
```

## Archivos de datos

Cada línea de `tours.txt` representa un tour. Los campos se separan con punto y coma y siguen este orden: `nombre;tipo;destino;precio`.

Cada línea de `personal.txt` representa un empleado. Los campos se separan con punto y coma y siguen este orden: `nombres;apellidos;rut;calle;numero;comuna;region;codigoEmpleado;cargo`.

El archivo `personal.txt` no debe incluir una línea de encabezado.

## Requisitos

- JDK 26
- IntelliJ IDEA

## Cómo ejecutar

1. Abre en IntelliJ IDEA la carpeta raíz del proyecto.
2. Abre `src/main/java/ui/Main.java`.
3. Ejecuta la clase `Main`.
4. Cuando el programa solicite un nombre, escríbelo en la consola para buscar al empleado.