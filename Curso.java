import java.util.*;

public class Curso {
    private int cursoId;
    private String nombre;
    private ArrayList<Recurso> recursos;
    private HashMap<Integer, Recurso> recursosMap;
    private ArrayList<Alumno> alumnos; //ESTA LISTA ES EXTRA Y NO PERTENECE ALA COLECCION ANIDADA
    private Map<String,Alumno> alumnosMap; //ESTA LISTA ES EXTRA Y NO PERTENECE ALA COLECCION ANIDADA

    public Curso(int cursoId, String nombre) {
        this.cursoId = cursoId;
        this.nombre = nombre;
        recursos = new ArrayList<>();
        recursosMap = new HashMap<>();
        alumnos = new ArrayList<>();
        alumnosMap = new HashMap<>();
    }

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

    public void setRecursosMap(HashMap<Integer, Recurso> recursosMap){
        this.recursosMap = recursosMap;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos){
        this.alumnos = alumnos;
    }
    
    public void agregarRecursoACurso(Recurso recurso){
        recursosMap.put(recurso.getRecursoID(), recurso);
        this.recursos.add(recurso);
    }

    public Recurso buscarRecursoPorID(Integer recurID){
        return recursosMap.get(recurID);
    }
    
    public void agregarAlumnoARecurso(Alumno alumno) {
        this.alumnos.add(alumno);
        alumnosMap.put(alumno.getRut(),alumno);
    }

    public Alumno buscarAlumnoPorRut(String rut){
        return alumnosMap.get(rut);
    }

// METODOS MOSTRAR
   
    public void mostrarRecursos(){
        System.out.println("-----------------------------------");
        System.out.println("Los Recursos son :");
        for ( Recurso recurso : recursos){
            System.out.println("ID del Recurso: " + recurso.getRecursoID() + "\nNombre del Recurso: " + recurso.getNombreRecurso() + " Nombre Del Docente: " + recurso.getProfesor().getNombre()+" Apellido: "+ recurso.getProfesor().getApellido()+"\n");
        }
    }

    public void mostrarNombreAlumnos(){
        for(Alumno alumno : alumnos){
            System.out.println("Nombre: "+ alumno.getNombre() +", Apellido: "+ alumno.getApellido()+".");
        }

    }



}
