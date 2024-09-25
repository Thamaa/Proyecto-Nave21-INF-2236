import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Institucion{
    private String nombreInstitucion;
    private ArrayList<Curso> cursos;
    private ArrayList<Profesor> profesores;

    public Institucion(String nombreInstitucion) throws IOException {
        this.nombreInstitucion = nombreInstitucion;
        this.cursos = new ArrayList<>();
        this.profesores = new ArrayList<>();
        // Crear archivos CSV si no existen
        CSVUtil.createCSVIfNotExists("cursos.csv", "ID,Nombre,Alumnos,Recursos");
        CSVUtil.createCSVIfNotExists("alumnos.csv", "Nombre,Apellido,Edad,RUT,IdCursoAlQuePertenece");
        CSVUtil.createCSVIfNotExists("profesores.csv", "Nombre,Apellido,Edad,RUT");
        CSVUtil.createCSVIfNotExists("recursos.csv", "ID,Nombre,RutProfesor,DescRec,CursoAlQuePertenece");

        cargarDatosDesdeCSV();
    }

    public void setNombreInstitucion(String nombreInstitucion){
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getNombreInstitucion(){
        return nombreInstitucion;
    }

    public void agregarCurso(Curso curso)throws IOException{
        this.cursos.add(curso);
        if(!CSVUtil.idExistsInCSV("cursos.csv", curso.getCursoId())){
            CSVUtil.appendToCSV("cursos.csv", curso.toCSV());
        }

    }

    public void agregarProfesor(Profesor profesor)throws IOException{
        this.profesores.add(profesor);
        if(!CSVUtil.rutExistsInCSV("profesores.csv", profesor.getRut())){
            CSVUtil.appendToCSV("profesores.csv", profesor.toCSV());
        }
    }

    public void setCursos(ArrayList<Curso> cursos){
        this.cursos = cursos;
    }

    public ArrayList<Curso> getCursos(){
        return cursos;
    }

    public void setProfesores(ArrayList<Profesor> profesores){
        this.profesores = profesores;
    }

    public ArrayList<Profesor> getProfesores(){
        return profesores;
    }

    public Profesor buscarProfesorPorRut(String rut){
        for(Profesor profesor : profesores){
            if(profesor.getRut().equals(rut)){
                return profesor;
            }
        }
        return null;
    }

    //METODO AGREGAR PROFESOR A RECURSO SIN PROFESOR
    public void asignarProfesorARecurso() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Cargar recursos desde el CSV
        ArrayList<String[]> recursosCSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("recursos.csv"))) {
            String line = br.readLine(); // Saltar el header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                recursosCSV.add(values);
            }
        }
    
        // Mostrar lista de recursos sin profesor
        System.out.println("Lista de recursos sin profesor:");
        for (String[] recurso : recursosCSV) {
            if (recurso[2].equals("0")) { // Suponiendo que el RUT del profesor está en la tercera columna
                System.out.println("ID: " + recurso[0] + ", Nombre: " + recurso[1] + ", Descripción: " + recurso[3] + ", Curso: " + recurso[4]);
            }
        }
    
        System.out.print("Ingrese el ID del recurso al que desea asignar un profesor: ");
        String idRecurso = lector.readLine();
    
        // Cargar profesores desde el CSV
        ArrayList<String[]> profesoresCSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("profesores.csv"))) {
            String line = br.readLine(); // Saltar el header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                profesoresCSV.add(values);
            }
        }
    
        // Mostrar lista de profesores
        System.out.println("Lista de profesores:");
        for (String[] profesor : profesoresCSV) {
            System.out.println("Nombre: " + profesor[0] + ", Apellido: " + profesor[1] + ", Edad: " + profesor[2] + ", RUT: " + profesor[3]);
        }
    
        System.out.print("Ingrese el RUT del profesor a asignar: ");
        String rutProfesor = lector.readLine();
    
        // Actualizar el recurso con el nuevo RUT del profesor
        boolean recursoActualizado = false;
        for (String[] recurso : recursosCSV) {
            if (recurso[0].equals(idRecurso) && recurso[2].equals("0")) {
                recurso[2] = rutProfesor;
                recursoActualizado = true;
                break;
            }
        }
    
        if (!recursoActualizado) {
            System.out.println("ID de recurso inválido o el recurso ya tiene un profesor asignado.");
            return;
        }
    
        // Escribir los recursos actualizados de vuelta al archivo CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("recursos.csv"))) {
            bw.write("ID,Nombre,RutProfesor,DescRec,CursoAlQuePertenece"); // Escribir el header
            bw.newLine();
            for (String[] recurso : recursosCSV) {
                bw.write(String.join(",", recurso));
                bw.newLine();
            }
        }
    
        System.out.println("Profesor asignado exitosamente al recurso.");
    }   


    //METODOS CREAR

    //METODO CREAR CURSO
    public void crearCurso() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int id;
    
        // Pedir al usuario ingresar un ID y verificar si ya existe en el archivo CSV
        while (true) {
            System.out.print("Ingrese el ID del curso: ");
            id = Integer.parseInt(lector.readLine());
    
            if (!CSVUtil.idExistsInCSV("cursos.csv", id)) {
                break;
            } else {
                System.out.println("El ID ingresado ya existe. Por favor, ingrese un ID válido.");
            }
        }
    
        System.out.print("Ingrese el nombre del curso: ");
        String nombre = lector.readLine();
    
        Curso nuevoCurso = new Curso(id, nombre);
    
        agregarCurso(nuevoCurso);
        System.out.println("Curso creado exitosamente");
    }

    //METODO CREAR ALUMNO
    public void agregarAlumno() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = lector.readLine();
        
        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = lector.readLine();
        
        System.out.print("Ingrese la edad del alumno: ");
        int edad = Integer.parseInt(lector.readLine());
        
        System.out.print("Ingrese el rut del alumno: ");
        String rut = lector.readLine();
        
        // Verificar si el RUT ya existe en el archivo CSV
        if (CSVUtil.rutExistsInCSV("alumnos.csv", rut)) {
            System.out.println("No se pudo agregar al alumno porque el RUT ya existe.");
            return;
        }
        
        System.out.println("Seleccione el curso al cual desea agregar el alumno:");
        
        // Leer cursos desde el archivo CSV y mostrarlos
        try (BufferedReader br = new BufferedReader(new FileReader("cursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    int id = Integer.parseInt(values[0]);
                    String nombreCurso = values[1];
                    System.out.println("ID: " + id + " - Nombre: " + nombreCurso);
                }
            }
        }
        
        System.out.print("Ingrese el ID del curso: ");
        int cursoId = Integer.parseInt(lector.readLine());
        
        Curso cursoSeleccionado = buscarCurso(cursoId);
        if (cursoSeleccionado == null) {
            System.out.println("Curso no válido.");
            return;
        }
        
        Alumno nuevoAlumno = new Alumno(nombre, apellido, edad, rut, cursoId);
        
        cursoSeleccionado.agregarAlumnoACurso(nuevoAlumno);
        System.out.println("Alumno creado exitosamente");
        
        // Escribir el alumno en el archivo CSV
    }


    //METODO AGREGAR PROFESOR A RECURSO 
    public void agregarProfesorARecurso() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Leer profesores desde el archivo CSV y mostrarlos
        ArrayList<Profesor> profesoresDesdeCSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("profesores.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 4) {
                    String nombre = values[0];
                    String apellido = values[1];
                    String rut = values[3];
                    profesoresDesdeCSV.add(new Profesor(nombre, apellido, Integer.parseInt(values[2]), rut));
                    System.out.println("Nombre: " + nombre + " " + apellido + " | RUT: " + rut);
                }
            }
        }
        
        System.out.print("\nIngrese el RUT del profesor: ");
        String rutBuscado = lector.readLine();
        
        Profesor profesorSeleccionado = null;
        for (Profesor profesor : profesoresDesdeCSV) {
            if (profesor.getRut().equals(rutBuscado)) {
                profesorSeleccionado = profesor;
                break;
            }
        }
        
        if (profesorSeleccionado == null) {
            System.out.println("No se encontró un profesor con el RUT especificado.");
            return;
        }
        
        // Leer cursos desde el archivo CSV y mostrarlos
        ArrayList<Curso> cursosDesdeCSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("cursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    int id = Integer.parseInt(values[0]);
                    String nombreCurso = values[1];
                    cursosDesdeCSV.add(new Curso(id, nombreCurso));
                    System.out.println((cursosDesdeCSV.size()) + ". " + nombreCurso);
                }
            }
        }
        
        System.out.print("Ingrese el número del curso: ");
        int posicionCurso = Integer.parseInt(lector.readLine()) - 1;
        
        if (posicionCurso < 0 || posicionCurso >= cursosDesdeCSV.size()) {
            System.out.println("Curso no válido.");
            return;
        }
        
        Curso cursoSeleccionado = cursosDesdeCSV.get(posicionCurso);
        
        // Leer recursos desde el archivo CSV y mostrarlos
        ArrayList<Recurso> recursosDesdeCSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("recursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 5) {
                    int idRecurso = Integer.parseInt(values[0]);
                    String nombreRecurso = values[1];
                    int cursoId = Integer.parseInt(values[4]);
                    if (cursoId == cursoSeleccionado.getCursoId()) {
                        recursosDesdeCSV.add(new Recurso(idRecurso, nombreRecurso, values[3], cursoId));
                        System.out.println("ID del Recurso: " + idRecurso + " | Nombre del Recurso: " + nombreRecurso);
                    }
                }
            }
        }
        
        System.out.print("Ingrese el ID del recurso al cual desea asignar el profesor: ");
        int idRecurso = Integer.parseInt(lector.readLine());
        
        Recurso recursoSeleccionado = null;
        for (Recurso recurso : recursosDesdeCSV) {
            if (recurso.getRecursoID() == idRecurso) {
                recursoSeleccionado = recurso;
                break;
            }
        }
        
        if (recursoSeleccionado == null) {
            System.out.println("No se encontró un recurso con el ID especificado.");
            return;
        }
        
        // Verificar si el recurso ya tiene un profesor asignado
        if (recursoSeleccionado.getProfesor() != null) {
            System.out.println("Este recurso ya tiene profesor.");
            return;
        }
        
        // Asignar el profesor al recurso
        recursoSeleccionado.agregarProfesorARecurso(profesorSeleccionado);
        System.out.println("Profesor asignado exitosamente al recurso.");
    }


    // METODOS CREAR PROFESOR
    public void crearProfesor() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese el nombre del profesor: ");
        String nombre = lector.readLine();
        
        System.out.print("Ingrese el apellido del profesor: ");
        String apellido = lector.readLine();
        
        System.out.print("Ingrese la edad del profesor: ");
        int edad = Integer.parseInt(lector.readLine());
        
        System.out.print("Ingrese el rut del profesor: ");
        String rut = lector.readLine();
        
        Profesor nuevoProfesor = new Profesor(nombre, apellido, edad, rut);
        
        agregarProfesor(nuevoProfesor);
        System.out.println("Profesor creado exitosamente");
    
    }


    //METODOS CREAR RECURSO
    public void crearRecurso() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Seleccione el curso al cual desea agregar un recurso:");
        
        // Leer cursos desde el archivo CSV y mostrarlos
        ArrayList<Curso> cursosDesdeCSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("cursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    int id = Integer.parseInt(values[0]);
                    String nombreCurso = values[1];
                    cursosDesdeCSV.add(new Curso(id, nombreCurso));
                    System.out.println("ID: " + id + " - Nombre: " + nombreCurso);
                }
            }
        }
        
        System.out.print("Ingrese el ID del curso: ");
        int cursoId = Integer.parseInt(lector.readLine());
        
        Curso cursoSeleccionado = null;
        for (Curso curso : cursosDesdeCSV) {
            if (curso.getCursoId() == cursoId) {
                cursoSeleccionado = curso;
                break;
            }
        }
        
        if (cursoSeleccionado == null) {
            System.out.println("Curso no válido.");
            return;
        }
        
        System.out.println("Seleccione el profesor para el recurso:");
        
        // Leer profesores desde el archivo CSV y mostrarlos
        ArrayList<Profesor> profesoresDesdeCSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("profesores.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 4) {
                    String nombre = values[0];
                    String apellido = values[1];
                    String rut = values[3];
                    profesoresDesdeCSV.add(new Profesor(nombre, apellido, Integer.parseInt(values[2]), rut));
                    System.out.println((profesoresDesdeCSV.size()) + ". " + nombre + " " + apellido);
                }
            }
        }
        
        System.out.print("Ingrese el número del profesor: ");
        int profeElegido = Integer.parseInt(lector.readLine()) - 1;
        
        if (profeElegido < 0 || profeElegido >= profesoresDesdeCSV.size()) {
            System.out.println("Profesor no válido.");
            return;
        }
        
        Profesor profesorSeleccionado = profesoresDesdeCSV.get(profeElegido);
        
        int id;
        while (true) {
            System.out.print("Ingrese el ID del Recurso: ");
            String idInput = lector.readLine();
            if (idInput.isEmpty()) {
                System.out.println("ID del recurso no puede estar vacío. Por favor, ingrese un ID válido.");
                continue;
            }
            id = Integer.parseInt(idInput);
            
            // Verificar que el ID no choque con ningún otro recurso en el archivo CSV
            boolean idEnUso = false;
            try (BufferedReader br = new BufferedReader(new FileReader("recursos.csv"))) {
                String line;
                br.readLine(); // Saltar la cabecera
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length >= 5) {
                        int recursoId = Integer.parseInt(values[0]);
                        if (recursoId == id) {
                            idEnUso = true;
                            break;
                        }
                    }
                }
            }
            
            if (idEnUso) {
                System.out.println("El ID del recurso ya está en uso en otro curso. Por favor, elija otro ID.");
            } else {
                break;
            }
        }
        
        // Asignar valores al nuevo recurso
        System.out.print("Ingrese el nombre del Recurso: ");
        String nombreRecurso = lector.readLine();
        
        System.out.print("Ingrese la descripcion del Recurso: ");
        String descripcionRecurso = lector.readLine();
        
        Recurso nuevoRecurso = new Recurso(nombreRecurso, descripcionRecurso, id, profesorSeleccionado, cursoId);
        
        cursoSeleccionado.agregarRecurso(nuevoRecurso);
        
        System.out.println("Recurso agregado exitosamente al curso " + cursoSeleccionado.getNombre());
    }
    //METODOS ELIMINAR

    //METODO ELIMINAR ALUMNO
    public void eliminarAlumno() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Leer alumnos desde el archivo CSV
        ArrayList<Alumno> alumnos = cargarAlumnosDesdeCSV();
        
        // Mostrar la lista de alumnos
        System.out.println("Lista de alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println("Nombre: " + alumno.getNombre() + ", Apellido: " + alumno.getApellido() + ", RUT: " + alumno.getRut());
        }
        
        // Solicitar el RUT del alumno a eliminar
        System.out.print("Ingrese el RUT del alumno a eliminar: ");
        String rut = lector.readLine();
        
        // Buscar y eliminar el alumno
        boolean alumnoEliminado = false;
        ArrayList<Alumno> alumnosActualizados = new ArrayList<>();
        for (Alumno alumno : alumnos) {
            if (alumno.getRut().equals(rut)) {
                alumnoEliminado = true;
                System.out.println("Alumno eliminado exitosamente");
            } else {
                alumnosActualizados.add(alumno);
            }
        }
        
        if (!alumnoEliminado) {
            System.out.println("No se encontró un alumno con el RUT especificado.");
            return;
        }
        
        // Actualizar el archivo CSV
        actualizarCSVAlumnos(alumnosActualizados);
    }

    //METODO ELIMINAR CURSO
    public void eliminarCurso() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese el ID del curso a eliminar: ");
        int cursoId = Integer.parseInt(lector.readLine());

        ArrayList<Curso> cursos = cargarCursosDesdeCSV();
        boolean cursoEliminado = cursos.removeIf(curso -> curso.getCursoId() == cursoId);

        if (!cursoEliminado) {
            System.out.println("ID inválido");
            return;
        }

        // Actualizar el archivo CSV para reflejar la eliminación del curso
        try (FileWriter writer = new FileWriter("cursos.csv")) {
            writer.append("ID,Nombre\n");
            for (Curso curso : cursos) {
                writer.append(String.valueOf(curso.getCursoId())).append(",").append(curso.getNombre()).append("\n");
            }
        }

        // Actualizar el id del curso de los alumnos que estaban en el curso eliminado a 0
        ArrayList<Alumno> alumnos = cargarAlumnosDesdeCSV();
        for (Alumno alumno : alumnos) {
            if (alumno.getIdCursoPerteneciente() == cursoId) {
                alumno.setIdCursoPerteneciente(0);
            }
        }

        // Escribir los cambios de vuelta al archivo CSV de alumnos
        try (FileWriter writer = new FileWriter("alumnos.csv")) {
            writer.append("Nombre,Apellido,Edad,Rut,CursoPerteneciente\n");
            for (Alumno alumno : alumnos) {
                writer.append(alumno.getNombre()).append(",")
                      .append(alumno.getApellido()).append(",")
                      .append(String.valueOf(alumno.getEdad())).append(",")
                      .append(alumno.getRut()).append(",")
                      .append(String.valueOf(alumno.getIdCursoPerteneciente())).append("\n");
            }
        }

        System.out.println("Curso eliminado exitosamente y alumnos actualizados.");
    }


    //METODO ELIMINAR PROFESOR
    public void eliminarProfesor() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Cargar profesores desde el CSV
        ArrayList<String[]> profesoresCSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("profesores.csv"))) {
            String line = br.readLine(); // Saltar el header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                profesoresCSV.add(values);
            }
        }
    
        // Mostrar lista de profesores
        System.out.println("Lista de profesores:");
        for (String[] profesor : profesoresCSV) {
            System.out.println("Nombre: " + profesor[0] + ", Apellido: " + profesor[1] + ", Edad: " + profesor[2] + ", RUT: " + profesor[3]);
        }
    
        System.out.print("Ingrese el RUT del profesor a eliminar: ");
        String rut = lector.readLine();
    
        boolean profesorEliminado = false;
        Iterator<String[]> profesorIterator = profesoresCSV.iterator();
        while (profesorIterator.hasNext()) {
            String[] profesor = profesorIterator.next();
            if (profesor[3].equals(rut)) { // Suponiendo que el RUT está en la cuarta columna
                profesorIterator.remove();
                profesorEliminado = true;
                break;
            }
        }
    
        if (!profesorEliminado) {
            System.out.println("RUT inválido");
            return;
        }
    
        // Actualizar el archivo CSV de profesores
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("profesores.csv"))) {
            bw.write("Nombre,Apellido,Edad,RUT"); // Escribir el header
            bw.newLine();
            for (String[] profesor : profesoresCSV) {
                bw.write(String.join(",", profesor));
                bw.newLine();
            }
        }
    
        // Cargar recursos desde el CSV
        ArrayList<String[]> recursosCSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("recursos.csv"))) {
            String line = br.readLine(); // Saltar el header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                recursosCSV.add(values);
            }
        }
    
        // Actualizar el RUT del profesor en los recursos a "0"
        for (String[] recurso : recursosCSV) {
            if (recurso[2].equals(rut)) { // Suponiendo que el RUT del profesor está en la tercera columna
                recurso[2] = "0";
            }
        }
    
        // Escribir los recursos actualizados de vuelta al archivo CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("recursos.csv"))) {
            bw.write("ID,Nombre,RutProfesor,DescRec,CursoAlQuePertenece"); // Escribir el header
            bw.newLine();
            for (String[] recurso : recursosCSV) {
                bw.write(String.join(",", recurso));
                bw.newLine();
            }
        }
    
        System.out.println("Profesor eliminado exitosamente y recursos actualizados.");
    }
    

    //METODO ELIMINAR RECURSO
    public void eliminarRecurso() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String csvFile = "recursos.csv";
        ArrayList<String[]> recursosCSV = new ArrayList<>();
        
        // Leer el archivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                recursosCSV.add(values);
            }
        }
    
        // Seleccionar el curso
        System.out.println("Seleccione el curso del cual desea eliminar un recurso:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }
        System.out.print("Ingrese el número del curso: ");
        int posicionCurso = Integer.parseInt(lector.readLine()) - 1; // Se resta 1 porque los índices empiezan en 0
        
        if (posicionCurso < 0 || posicionCurso >= cursos.size()) {
            System.out.println("Curso no válido.");
            return;
        }
        
        Curso cursoSeleccionado = cursos.get(posicionCurso);
        
        // Mostrar recursos del curso seleccionado
        System.out.println("Los Recursos del curso " + cursoSeleccionado.getNombre() + " son:");
        for (String[] recurso : recursosCSV) {
            if (recurso[4].equals(String.valueOf(cursoSeleccionado.getCursoId()))) {
                System.out.println("ID del Recurso: " + recurso[0]);
                System.out.println("Nombre del Recurso: " + recurso[1] + "\n");
            }
        }
        
        System.out.print("Ingrese el ID del Recurso a eliminar: ");
        int idRecurso = Integer.parseInt(lector.readLine());
        
        boolean recursoEncontrado = false;
        Iterator<String[]> iterator = recursosCSV.iterator();
        while (iterator.hasNext()) {
            String[] recurso = iterator.next();
            if (recurso[4].equals(String.valueOf(cursoSeleccionado.getCursoId())) && recurso[0].equals(String.valueOf(idRecurso))) {
                iterator.remove();
                recursoEncontrado = true;
                break;
            }
        }
        
        if (recursoEncontrado) {
            // Actualizar el archivo CSV
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
                for (String[] recurso : recursosCSV) {
                    bw.write(String.join(",", recurso));
                    bw.newLine();
                }
            }
            System.out.println("Recurso eliminado exitosamente.");
        } else {
            System.out.println("Recurso no encontrado.");
        }
    }
    //METODOS MOSTRAR

    //METODO MOSTRAR ALUMNOS 
    public void mostrarAlumnos() throws IOException {
        System.out.println("\n\n----------------------------------------------------------------------------------");
        System.out.println("Los alumnos de la institucion " + getNombreInstitucion() + " son : ");
        
        try (BufferedReader br = new BufferedReader(new FileReader("alumnos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 5) {
                    String nombre = values[0];
                    String apellido = values[1];
                    String rut = values[3];
                    int cursoId = Integer.parseInt(values[4]);
                    Curso curso = buscarCurso(cursoId);
                    if (curso != null) {
                        System.out.println("Curso: " + curso.getNombre());
                        System.out.println("Nombre: " + nombre + ", Apellido: " + apellido + ", Rut: " + rut + ".");
                    }

                }
                System.out.println("----------------------------------------------------------------------------------\n");

            }
            
        }
    }
    //METODO MOSTRAR RECURSOS DE INSTITUCION
    public void mostrarRecursos() throws IOException {
        System.out.println("\n\n----------------------------------------------------------------------------------");
        System.out.println("Los recursos de la institucion " + getNombreInstitucion() + " son : ");
        
        try (BufferedReader br = new BufferedReader(new FileReader("recursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 5) {
                    int id = Integer.parseInt(values[0]);
                    String nombre = values[1];
                    String rutProfesor = values[2];
                    String descripcion = values[3];
                    int cursoId = Integer.parseInt(values[4]);
                    Curso curso = buscarCurso(cursoId);
                    if (curso != null) {
                        System.out.println("ID: " + id + ", Nombre: " + nombre + ", Profesor: " + rutProfesor + ", Descripción: " + descripcion + ", Curso: " + curso.getNombre() + ".");
                        System.out.println("----------------------------------------------------------------------------------\n");
                    }
                }
            }
        }
    }

    //METODO MOSTRAR RECURSOS DEL PROFESOR
    public void mostrarRecursosDeProfesor() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Seleccione el profesor del cual desea ver los recursos:");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println((i + 1) + ". " + profesores.get(i).getNombre() + " " + profesores.get(i).getApellido());
        }
        System.out.print("Ingrese el número del profesor: ");
        int posicionProfesor = Integer.parseInt(lector.readLine()) - 1;
        
        if (posicionProfesor < 0 || posicionProfesor >= profesores.size()) {
            System.out.println("Profesor no válido.");
            return;
        }
        
        Profesor profesorSeleccionado = profesores.get(posicionProfesor);
        
        System.out.println("Los Recursos del profesor "+ profesorSeleccionado.getNombre() +" "+ profesorSeleccionado.getApellido() +" son : ");
        for(Curso curso : cursos){
            for(Recurso recurso : curso.getRecursos()){
                if(recurso.getProfesor().equals(profesorSeleccionado)){
                    System.out.println("ID del Recurso : "+ recurso.getRecursoID());
                    System.out.println("Nombre del Recurso : "+ recurso.getNombreRecurso());
                    System.out.println("Descripcion del Recurso : "+ recurso.getDescripcionRec()+"\n");
                }
            }
        }
    }

    //METODO MOSTRAR PROFESOR
    public void mostrarProfesores() throws IOException {
        System.out.println("\n\n----------------------------------------------------------------------------------");
        System.out.println("Los profesores de la institucion " + getNombreInstitucion() + " son : ");
        
        try (BufferedReader br = new BufferedReader(new FileReader("profesores.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 4) {
                    String nombre = values[0];
                    String apellido = values[1];
                    String rut = values[3];
                    System.out.println("Nombre: " + nombre + ", Apellido: " + apellido + ", Rut: " + rut + ".");
                    System.out.println("----------------------------------------------------------------------------------\n");
                }
            }
        }
    }
    
    //METODO MOSTRAR CURSOS
    public void mostrarCursos() throws IOException {
        System.out.println("\n\n----------------------------------------------------------------------------------");
        System.out.println("Los cursos de la institucion " + getNombreInstitucion() + " son : ");
        
        try (BufferedReader br = new BufferedReader(new FileReader("cursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    int id = Integer.parseInt(values[0]);
                    String nombre = values[1];
                    System.out.println("ID: " + id + ", Nombre: " + nombre + ".");
                    System.out.println("----------------------------------------------------------------------------------\n");
                }
            }
        }
    }
    //METODO MOSTRAR TODOS LOS RECURSOS
    public void mostrarTodosLosRecursos() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("recursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 5) {
                    int idRecurso = Integer.parseInt(values[0]);
                    String nombreRecurso = values[1];
                    String rutProfesor = values[2];
                    String descripcionRecurso = values[3];
                    int idCursoPerteneciente = Integer.parseInt(values[4]);
                    
                    System.out.println("ID del Recurso: " + idRecurso);
                    System.out.println("Nombre del Recurso: " + nombreRecurso);
                    System.out.println("RUT del Profesor: " + rutProfesor);
                    System.out.println("Descripción del Recurso: " + descripcionRecurso);
                    System.out.println("ID del Curso Perteneciente: " + idCursoPerteneciente + "\n");
                }
            }
        }
    }

    //METODO MOSTRAR RECURSOS DE UN ALUMNO
    public void mostrarRecursoAlumno()throws IOException{
       BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Seleccione el curso del cual desea ver los recursos:");
            for (int i = 0; i < cursos.size(); i++) {
                System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
            }
            System.out.print("Ingrese el número del curso: ");
            int posicionCurso = Integer.parseInt(lector.readLine()) - 1;
            
            if (posicionCurso < 0 || posicionCurso >= cursos.size()) {
                System.out.println("Curso no válido.");
                return;
            }
            
            Curso cursoSeleccionado = cursos.get(posicionCurso);
            
            System.out.println("Los Recursos del curso "+ cursoSeleccionado.getNombre() +" son: ");
            for(Recurso recurso : cursoSeleccionado.getRecursos()){
                System.out.println("ID del Recurso: "+ recurso.getRecursoID());
                System.out.println("Nombre del Recurso: "+ recurso.getNombreRecurso()+"\n");
            }
            
            System.out.print("Ingrese el ID del Recurso que desea ver: ");
            int id = Integer.parseInt(lector.readLine());
            System.out.println("");
            Recurso recurso = cursoSeleccionado.buscarRecursoPorID(id);
            if(recurso != null){
                System.out.println("Nombre del Recurso: "+ recurso.getNombreRecurso());
                System.out.println("Descripcion del Recurso: "+ recurso.getDescripcionRec());
                System.out.println("Profesor del Recurso: "+ recurso.getProfesor().getNombre()+" "+ recurso.getProfesor().getApellido()+"\n");
            } else {
                System.out.println("Recurso no encontrado");
            }
        
    }

    public void mostrarCursoIdNombre()throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el Nombre o ID del curso: ");
        String leido = lector.readLine();

        Curso cursoEncontrado = null;

        try {
            int cursoId = Integer.parseInt(leido);
            cursoEncontrado = buscarCurso(cursoId); 

        }   catch (NumberFormatException e) {
        
        cursoEncontrado = buscarCurso(leido); 
        }
        if (cursoEncontrado != null) {
            System.out.println("\n\n----------------------------------------------------------------------------------");
            System.out.println("Detalles del curso:");
            System.out.println("ID del Curso: " + cursoEncontrado.getCursoId());
            System.out.println("Nombre del Curso: " + cursoEncontrado.getNombre());
            System.out.println("\nAlumnos del curso:");
            cursoEncontrado.mostrarNombreAlumnos();
            System.out.println("\nRecursos del curso:");
            cursoEncontrado.mostrarRecursos();
            } 
        else 
        {
        System.out.println("No se encontró un curso con el ID o Nombre proporcionado.");
        }
    }


    //METODO BUSCAR CURSO POR ID Y POR NOMBRE 


    public Curso buscarCurso(String nombre)
    {
        for(Curso curso: cursos)
        {
            if(curso.getNombre().equalsIgnoreCase(nombre))
            {
                return curso;
            }
        }
        return null;
    }

    private void actualizarCSVRecursos() throws IOException {
        try (FileWriter writer = new FileWriter("recursos.csv")) {
            writer.append("ID,Nombre,RutProfesor,DescRec,CursoAlQuePertenece\n");
            for (Curso curso : cursos) {
                for (Recurso recurso : curso.getRecursos()) {
                    writer.append(recurso.toCSV());
                    writer.append("\n");
                }
            }
        }
    }

    private void actualizarCSVRecursos(int cursoId, int recursoId) throws IOException {
        ArrayList<Recurso> recursosActualizados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("recursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 5) {
                    int id = Integer.parseInt(values[0]);
                    int idCursoPerteneciente = Integer.parseInt(values[4]);
                    if (!(id == recursoId && idCursoPerteneciente == cursoId)) {
                        recursosActualizados.add(new Recurso( values[1],values[3] ,id ,buscarProfesorPorRut(values[2]) ,idCursoPerteneciente));
                    }
                }
            }
        }

        try (FileWriter writer = new FileWriter("recursos.csv")) {
            writer.append("ID,Nombre,RutProfesor,DescRec,CursoAlQuePertenece\n");
            for (Recurso recurso : recursosActualizados) {
                writer.append(String.valueOf(recurso.getRecursoID())).append(",")
                      .append(recurso.getNombreRecurso()).append(",")
                      .append(recurso.getProfesor().getRut()).append(",")
                      .append(recurso.getDescripcionRec()).append(",")
                      .append(String.valueOf(recurso.getIdCursoPerteneciente())).append("\n");
            }
        }
    }

    //metodo para actualizar CSV
    private void actualizarCSVProfesores() throws IOException {
        try (FileWriter writer = new FileWriter("profesores.csv")) {
            writer.append("Nombre,Apellido,Edad,RUT\n");
            for (Profesor profesor : profesores) {
                writer.append(profesor.toCSV());
                writer.append("\n");
            }
        }
    }
    private void actualizarCSVAlumnos(ArrayList<Alumno> alumnos) throws IOException {
        try (FileWriter writer = new FileWriter("alumnos.csv")) {
            writer.append("Nombre,Apellido,Edad,Rut,CursoPerteneciente\n");
            for (Alumno alumno : alumnos) {
                writer.append(alumno.getNombre()).append(",")
                      .append(alumno.getApellido()).append(",")
                      .append(String.valueOf(alumno.getEdad())).append(",")
                      .append(alumno.getRut()).append(",")
                      .append(String.valueOf(alumno.getIdCursoPerteneciente())).append("\n");
            }
        }
    }

    private void cargarDatosDesdeCSV() throws IOException {
        // Cargar cursos
        try (BufferedReader br = new BufferedReader(new FileReader("cursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String nombre = values[1];
                cursos.add(new Curso(id, nombre));
            }
        }

        // Cargar alumnos
        try (BufferedReader br = new BufferedReader(new FileReader("alumnos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String nombre = values[0];
                String apellido = values[1];
                int edad = Integer.parseInt(values[2]);
                String rut = values[3];
                int idCurso = Integer.parseInt(values[4]);
                Alumno alumno = new Alumno(nombre, apellido, edad, rut, idCurso);

                // Aquí deberías agregar el alumno al curso correspondiente
                Curso curso = buscarCurso(idCurso);
                if (curso != null) {
                    curso.agregarAlumnoACurso(alumno);
                } else {
                    System.out.println("Curso no encontrado para el ID: " + idCurso);
                }
            }
        }

        // Cargar profesores
        try (BufferedReader br = new BufferedReader(new FileReader("profesores.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String nombre = values[0];
                String apellido = values[1];
                int edad = Integer.parseInt(values[2]);
                String rut = values[3];
                profesores.add(new Profesor(nombre, apellido, edad, rut));
            }
        }
    }

    private Curso buscarCurso(int idCurso) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("cursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                if (id == idCurso) {
                    String nombre = values[1];
                    return new Curso(id, nombre);
                }
            }
        }
        return null;
    }

    private ArrayList<Curso> cargarCursosDesdeCSV() throws IOException {
        ArrayList<Curso> cursos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("cursos.csv"))) {
            String line;
            br.readLine(); // Skip the header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    int id = Integer.parseInt(values[0]);
                    String nombre = values[1];
                    cursos.add(new Curso(id, nombre));
                }
            }
        }
        return cursos;
    }

    private ArrayList<Profesor> cargarProfesoresDesdeCSV() throws IOException {
        ArrayList<Profesor> profesores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("profesores.csv"))) {
            String line;
            br.readLine(); // Skip the header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 4) {
                    String nombre = values[0];
                    String apellido = values[1];
                    String rut = values[3];
                    profesores.add(new Profesor(nombre, apellido, rut));
                }
            }
        }
        return profesores;
    }

    private ArrayList<Alumno> cargarAlumnosDesdeCSV() throws IOException {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("alumnos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 4) {
                    String nombre = values[0];
                    String apellido = values[1];
                    int edad = Integer.parseInt(values[2]);
                    String rut = values[3];
                    int cursoId = Integer.parseInt(values[4]);
                    alumnos.add(new Alumno(nombre, apellido,edad,rut, cursoId));
                }
            }
        }
        return alumnos;
    }


    private void actualizarCSVCursos() throws IOException {
        try (FileWriter writer = new FileWriter("cursos.csv")) {
            writer.append("ID,Nombre\n");
            for (Curso curso : cursos) {
                writer.append(String.valueOf(curso.getCursoId())).append(",")
                      .append(curso.getNombre()).append("\n");
            }
        }
    }

    private ArrayList<Recurso> cargarRecursosDesdeCSV(int cursoId) throws IOException {
        ArrayList<Recurso> recursos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("recursos.csv"))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 5) {
                    int id = Integer.parseInt(values[0]);
                    String nombre = values[1];
                    String rutProfesor = values[2];
                    String descripcion = values[3];
                    int idCursoPerteneciente = Integer.parseInt(values[4]);
                    if (idCursoPerteneciente == cursoId) {
                        recursos.add(new Recurso(nombre,descripcion,id ,buscarProfesorPorRut(rutProfesor), idCursoPerteneciente));
                    }
                }
            }
        }
        return recursos;
    }
}

