import java.io.*;
import java.util.*;
public class Curso {
    private int cursoId;
    private String nombre;
    private ArrayList<Recurso> recursos;
    private ArrayList<Alumno> alumnos; 
    private HashMap<String,Alumno> alumnosMap;

    public Curso(int cursoId, String nombre) {
        this.cursoId = cursoId;
        this.nombre = nombre;
        recursos = new ArrayList<>();
        alumnos = new ArrayList<>();
        alumnosMap = new HashMap<>();
    }

    //SETTERS Y GETTERS

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getCursoId(){
        return cursoId;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setRecursos(ArrayList<Recurso> recursos){
        this.recursos = recursos;
    }
    public void getRecursos(ArrayList<Recurso> recursos){
        this.recursos = recursos;
    }

    public ArrayList<Alumno> getAlumnos(){
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos){
        this.alumnos = alumnos;
    }

    public ArrayList<Recurso> getRecursos() {
        return recursos;
    }

    public void setAlumnosMap(HashMap<String, Alumno> alumnosMap) {
        this.alumnosMap = alumnosMap;
    }


    public HashMap<String, Alumno> getAlumnosMap() {
        return alumnosMap;
    }

    public boolean idExistsInRecursos(int id) {
        for (Recurso recurso : recursos) {
            if (recurso.getRecursoID() == id) {
                return true;
            }
        }
        return false;
    }

    //METODOS AGREGAR Y BUSCAR

    public void agregarRecursoACurso(Recurso recurso) throws IOException {
        // Verificar si el ID ya existe en el archivo CSV
        if (!CSVUtil.idExistsInCSV("recursos.csv", recurso.getRecursoID())) {
            CSVUtil.appendToCSV("recursos.csv", recurso.toCSV());
            recursos.add(recurso);
        } else {
            System.out.println("El recurso con ID " + recurso.getRecursoID() + " ya existe en el archivo CSV.");
        }
    }

    
    public void agregarAlumnoACurso(Alumno alumno)throws IOException {
        this.alumnos.add(alumno);
        alumnosMap.put(alumno.getRut(), alumno);
        // Escribir el alumno en el archivo CSV
        if (!CSVUtil.rutExistsInCSV("alumnos.csv", alumno.getRut())) {
            CSVUtil.appendToCSV("alumnos.csv", alumno.toCSV());
        }

    }

    public Alumno buscarAlumnoPorRut(String rut){
        return alumnosMap.get(rut);
    }

    public void agregarRecurso(Recurso recurso) throws IOException {
        // Verificar si el ID ya existe en el archivo CSV
        if(!CSVUtil.idExistsInCSV("recursos.csv", recurso.getRecursoID())) {
            CSVUtil.appendToCSV("recursos.csv", recurso.toCSV());
            recursos.add(recurso);
        }

        
    }

    public Recurso buscarRecursoPorID(int id) {
        for (Recurso recurso : recursos) {
            if (recurso.getRecursoID() == id) {
                return recurso;
            }
        }
        return null;
    }

    // Método para convertir el objeto a una cadena CSV
    public String toCSV() {
        return cursoId + "," + nombre + "," + alumnos.size() + "," + recursos.size();
    }


    //AGREGAR PROFESOR A RECURSO
    public void agregarProfesorARecurso(Recurso recurso, Profesor profesor) {
        recurso.agregarProfesorARecurso(profesor);
    }
    
public Profesor buscarProfesor(String rutProfesor) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("profesores.csv"))) {
        String line;
        br.readLine(); // Saltar la cabecera
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length >= 4 && values[3].equals(rutProfesor)) {
            String nombre = values[0];
            String apellido = values[1];
            int edad = Integer.parseInt(values[2]);
            String rut = values[3];
            return new Profesor(nombre, apellido,edad, rut);
            }
        }
    }
    return null; // Retorna null si no se encuentra el profesor
}

// METODOS MOSTRAR

//MOSTRAR RECURSOS

public void mostrarRecursos() throws IOException {
    System.out.println("Los Recursos del curso son :");
    
    boolean hayRecursos = false;
    
    // Leer recursos desde el archivo CSV y mostrar los que pertenecen al curso actual
    try (BufferedReader br = new BufferedReader(new FileReader("recursos.csv"))) {
        String line;
        br.readLine(); // Saltar la cabecera
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length >= 5) {
                int idRecurso = Integer.parseInt(values[0]);
                String nombreRecurso = values[1];
                String rutProfesor = values[2];
                String descripcion = values[3];
                int cursoId = Integer.parseInt(values[4]);
                
                if (cursoId == this.cursoId) {
                    hayRecursos = true;
                    System.out.println("ID del Recurso: " + idRecurso);
                    System.out.println("Nombre del Recurso: " + nombreRecurso);
                    if (!rutProfesor.isEmpty()) {
                        Profesor profesor = buscarProfesor(rutProfesor);
                        if (profesor != null) {
                            System.out.println("Nombre Del Docente: " + profesor.getNombre() + " Apellido: " + profesor.getApellido());
                        } else {
                            System.out.println("Actualmente este recurso no tiene un profesor asignado");
                        }
                    } else {
                        System.out.println("Actualmente este recurso no tiene un profesor asignado");
                    }
                    System.out.println();
                }
            }
        }
    }
    
    if (!hayRecursos) {
        System.out.println("No hay recursos en este curso");
    }
    
    System.out.println("----------------------------------------------------------------------------------");
}

    //MOSTRAR NOMBRES DE ALUMNOS
    public void mostrarNombreAlumnos() throws IOException {
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
                    if (cursoId == this.cursoId) {
                        System.out.println("Nombre: " + nombre + ", Apellido: " + apellido + ", Rut: " + rut + ".");
                    }
                }
            }
        }
    }


    //METODOS CREAR

    //CREAR ALUMNO
    public void crearAlumno()throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = lector.readLine();
        
        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = lector.readLine();
        
        System.out.print("Ingrese la edad del alumno: ");
        String edadString = lector.readLine();
        int edad = Integer.parseInt(edadString);
        
        System.out.print("Ingrese el rut del alumno: ");
        String rut = lector.readLine();
        
        Alumno nuevoAlumno = new Alumno(nombre, apellido, edad, rut, this.cursoId);
        agregarAlumnoACurso(nuevoAlumno);
    }



    //METODOS ELIMINAR
    public void eliminarProfesorDeRecursos(Profesor profesor) throws IOException {
        for (Recurso recurso : recursos) {
            if (recurso.getProfesor() != null && recurso.getProfesor().equals(profesor)) {
                recurso.eliminarProfesor();
            }
        }
        // Actualizar el archivo CSV
        actualizarCSVRecursos();
    }

    public void eliminarProfesorDeRecursos(String rutProfesor) throws IOException {
        for (Recurso recurso : recursos) {
            Profesor profesor = recurso.getProfesor();
            if (profesor != null && profesor.getRut().equals(rutProfesor)) {
                recurso.eliminarProfesor();
            }
        }
        // Actualizar el archivo CSV
        actualizarCSVRecursos();
    }

    public void eliminarRecurso(int recursoID) throws IOException {
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i).getRecursoID() == recursoID) {
                recursos.remove(i);
                System.out.println("Recurso eliminado exitosamente");

                // Actualizar el archivo CSV
                actualizarCSVRecursos();
                return;
            }
        }
        System.out.println("No se encontró un recurso con el ID especificado.");
    }
    

    public void eliminarAlumnoDeCurso(Alumno alumno) throws IOException {
        alumnos.remove(alumno);
        alumnosMap.remove(alumno.getRut());
        // Actualizar el archivo CSV
        actualizarCSV("alumnos.csv", alumnos);
    }

    //ELIMINAR RECUSO DE CURSO
    public void eliminarRecursoDeCurso(Recurso recurso){
        recursos.remove(recurso);
    }

    private void actualizarCSVRecursos() throws IOException {
        try (FileWriter writer = new FileWriter("recursos.csv")) {
            writer.append("ID,Nombre,Profesor\n");
            for (Recurso recurso : recursos) {
                writer.append(recurso.toCSV());
                writer.append("\n");
            }
        }
    }

    private void actualizarCSV(String fileName, ArrayList<Alumno> alumnos) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Nombre,Apellido,Edad,RUT\n");
            for (Alumno alumno : alumnos) {
                writer.append(alumno.toCSV());
                writer.append("\n");
            }
        }
    }

}
