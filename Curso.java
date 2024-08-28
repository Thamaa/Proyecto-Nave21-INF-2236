import java.io.*;
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
    


    public List<Float> getNotasPorRutAlumno(String rut)
    {
        Alumno alumno = buscarAlumnoPorRut(rut);
        if(alumno != null)
        {
            return alumno.getNotas();
        }
        else
        {
            System.out.println("Alumno no encontrado");

        }
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
    /*public void crearRecurso()throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));       
        int id = recursos.size() + 1;
        System.out.println("El ID del Recurso será: " + id);
        
        System.out.print("Ingrese el nombre del Recurso: ");
        String nombreRecurso = lector.readLine();
        
        System.out.print("Ingrese la descripcion del Recurso: ");
        String descripcionRecurso = lector.readLine();
        
        System.out.println("Ingrese el nombre del Profesor:");
        String nombreProfesor = lector.readLine();
        
        System.out.println("Ingrese el apellido del Profesor:");
        String apellidoProfesor = lector.readLine();

        System.out.println("Ingrese el apellido del Profesor:");
        String edadProfesorString = lector.readLine();
        int edadProfesor = Integer.parseInt(edadProfesorString);

        System.out.println("Ingrese el apellido del Profesor:");
        String rutString = lector.readLine();

        Profesor profesor = new Profesor(nombreProfesor, apellidoProfesor, edadProfesor, rutString);

        Recurso nuevoRecurso = new Recurso( nombreRecurso,descripcionRecurso, id,profesor);
        agregarRecursoACurso(nuevoRecurso);

    }*/

    public void eliminarRecurso()throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Los Recursos del curso "+ getNombre() +" son : ");
        for(Recurso recurso : recursos){
            System.out.println("ID del Recurso : "+ recurso.getRecursoID());
            System.out.println("Nombre del Recurso : "+ recurso.getNombreRecurso()+"\n");
        }
        
        System.out.print("Ingrese el ID del Recurso a eliminar: ");
        int id = Integer.parseInt(lector.readLine());
        Recurso recurso = buscarRecursoPorID(id);
        if(recurso != null){
            recursos.remove(recurso);
            recursosMap.remove(id);
            System.out.println("Recurso eliminado exitosamente");
        }else{
            System.out.println("Recurso no encontrado");
        }
    }
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

}
