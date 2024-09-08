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

    //METODOS AGREGAR Y BUSCAR

    public void agregarRecursoACurso(int recursoID) {
  
    }

    public void agregarRecursoACurso(Recurso recurso) {
        this.recursos.add(recurso);
    }

    
    public void agregarAlumnoARecurso(Alumno alumno) {
        this.alumnos.add(alumno);
        alumnosMap.put(alumno.getRut(),alumno);
    }

    public Alumno buscarAlumnoPorRut(String rut){
        return alumnosMap.get(rut);
    }

    public void agregarRecurso(Recurso recurso){
        recursos.add(recurso);
    }

    public Recurso buscarRecursoPorID(int id) {
        for (Recurso recurso : recursos) {
            if (recurso.getRecursoID() == id) {
                return recurso;
            }
        }
        return null;
    }

    //AGREGAR PROFESOR A RECURSO
    public void agregarProfesorARecurso(Recurso recurso, Profesor profesor) {
        recurso.agregarProfesorARecurso(profesor);
    }
    

// METODOS MOSTRAR

//MOSTRAR RECURSOS

    public void mostrarRecursos() {
        System.out.println("Los Recursos del curso son :");
        if (recursos.isEmpty()) {
            System.out.println("No hay recursos en este curso");
            System.out.println("----------------------------------------------------------------------------------\n");
        } else {
            for (Recurso recurso : recursos) {
                System.out.println("ID del Recurso: " + recurso.getRecursoID());
                System.out.println("Nombre del Recurso: " + recurso.getNombreRecurso());
                if (recurso.getProfesor() != null) {
                    System.out.println("Nombre Del Docente: " + recurso.getProfesor().getNombre() + " Apellido: " + recurso.getProfesor().getApellido());
                } else {
                    System.out.println("Actualmente este recurso no tiene un profesor asignado");
                }
                System.out.println();
            }
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    //MOSTRAR NOMBRES DE ALUMNOS
    public void mostrarNombreAlumnos(){
        for(Alumno alumno : alumnos){
            System.out.println("Nombre: "+ alumno.getNombre() +", Apellido: "+ alumno.getApellido()+ ", Rut: " +alumno.getRut()+ ".");
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
        
        Alumno nuevoAlumno = new Alumno(nombre, apellido, edad, rut);
        agregarAlumnoARecurso(nuevoAlumno);
    }



    //METODOS ELIMINAR
    public void eliminarProfesorDeRecursos(Profesor profesor) {
        for (Recurso recurso : recursos) {
            if (recurso.getProfesor() != null && recurso.getProfesor().equals(profesor)) {
                recurso.eliminarProfesor();
            }
        }
    }

    public void eliminarProfesorDeRecursos(String rutProfesor) 
    {
        for (Recurso recurso : recursos) 
        {
            Profesor profesor = recurso.getProfesor();
            if (profesor != null && profesor.getRut().equals(rutProfesor)) 
            {
                recurso.eliminarProfesor();
            }
        }
    }


    

    public void eliminarAlumnoDeCurso(Alumno alumno) {
        alumnos.remove(alumno);
        alumnosMap.remove(alumno.getRut());
    }

    //ELIMINAR RECUSO DE CURSO
    public void eliminarRecursoDeCurso(Recurso recurso){
        recursos.remove(recurso);
    }

    

}
