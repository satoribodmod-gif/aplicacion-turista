# Llanquihue Tour

Proyecto sencillo en Java para cargar y mostrar información de tours turísticos desde un archivo de texto.

## ¿Qué hace?

Lee los tours guardados en `tours.txt`, crea un objeto `Tour` por cada registro y los almacena en una lista. Luego muestra todos los tours y filtra los que son gastronómicos.

## Estructura

```text
src/
└── main/
    ├── java/
    │   ├── data/
    │   │   └── GestorDatos.java
    │   ├── model/
    │   │   └── Tour.java
    │   └── ui/
    │       └── Main.java
    └── resources/
        └── tours.txt
```

## Cómo ejecutarlo

Abre el proyecto en IntelliJ IDEA y ejecuta `Main`, ubicado en el paquete `ui`.
