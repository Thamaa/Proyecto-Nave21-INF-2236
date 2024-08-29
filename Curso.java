import java.io.*;
import java.util.*;
public class Curso {
    private int cursoId;
    private String nombre;
    private ArrayList<Recurso> recursos;
    private HashMap<Integer, Recurso> recursosMap;
    private ArrayList<Alumno> alumnos; //ESTA LISTA ES EXTRA Y NO PERTENECE ALA COLECCION ANIDADA
    private HashMap<String,Alumno> alumnosMap; //ESTA LISTA ES EXTRA Y NO PERTENECE ALA COLECCION ANIDADA

    public Curso(int cursoId, String nombre) {
        this.cursoId = cursoId;
        this.nombre = nombre;
        recursos = new ArrayList<>();
        recursosMap = new HashMap<>();
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

    public void setRecursosMap(HashMap<Integer, Recurso> recursosMap){
        this.recursosMap = recursosMap;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos){
        this.alumnos = alumnos;
    }

    public ArrayList<Recurso> getRecursos() {
        return recursos;
    }

    public HashMap<Integer, Recurso> getRecursosMap() {
        return recursosMap;
    }

    public HashMap<String, Alumno> getAlumnosMap() {
        return alumnosMap;
    }

    //agregar y buscar
    
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

    public void agregarRecurso(Recurso recurso){
        recursos.add(recurso);
    }
    

// METODOS MOSTRAR
    public void mostrarRecursos(){
        System.out.println("-----------------------------------");
        System.out.println("Los Recursos son :");
        if(recursos.isEmpty()){
            System.out.println("No hay recursos en este curso");
            System.out.println("-----------------------------\n");
        }
        for ( Recurso recurso : recursos){
            System.out.println("ID del Recurso: " + recurso.getRecursoID() + "\nNombre del Recurso: " + recurso.getNombreRecurso() + " Nombre Del Docente: " + recurso.getProfesor().getNombre()+" Apellido: "+ recurso.getProfesor().getApellido()+"\n");
        }
    }

    public void mostrarNombreAlumnos(){
        for(Alumno alumno : alumnos){
            System.out.println("Nombre: "+ alumno.getNombre() +", Apellido: "+ alumno.getApellido()+".");
        }
    }


    //Metodos crear
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
    //Eliminar Recurso de Curso
    public void eliminarRecursoDeCurso(Recurso recurso){
        recursos.remove(recurso);
    }

}
