# tallerGrupalDBScala

# Conexion a base de datos

**1. Genere el archivo CSV para los siguientes datos de estudiantes:**


| nombre | edad |calificacion |genero|
| --- | --- | --- | --- |
| Andrés | 10 | 20 | M |
| Ana | 11 | 19 | F |
| Luis | 9 | 18 | M |
| Cecilia | 9 | 18 | F |
| Katy | 11 | 15 | F |
| Jorge | 8 | 17 | M |
| Rosario | 11 | 18 | F |
| Nieves | 10 | 20 | F |
| Pablo | 9 | 19 | M |
| Daniel | 10 | 20 | M |

En el paquete "Resources" se agrega un file como estudiantes.csv

```
nombre;edad;calificacion;genero
Andrés;10;20;M
Ana;11;19;F
Luis;9;18;M
Cecilia;9;18;F
Katy;11;15;F
Jorge;8;17;M
Rosario;11;18;F
Nieves;10;20;F
Pablo;9;19;M
Daniel;10;20;M
```

**2. Genere la tabla en MYSQL para esta información**

```
CREATE TABLE estudiantes (
    nombre VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    calificacion DECIMAL(5, 2) NOT NULL,
    genero CHAR(1) NOT NULL CHECK (genero IN ('M', 'F'))
);

```

**3. Elabore un programa que inyecte los datos del archivo CSV a la base de datos**

```

```

**4. En el mismo programa agregue la funcionalidad para obtener de la base de datos todos los registros de Estudiantes**

```

```
