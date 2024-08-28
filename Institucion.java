import java.io.*;
import java.util.ArrayList;

public class Institucion{
    private String nombreInstitucion;
    private ArrayList<Curso> cursos;
    private ArrayList<Profesor> profesores;

    public Institucion(String nombreInstitucion){
        this.nombreInstitucion = nombreInstitucion;
        this.cursos = new ArrayList<>();
        this.profesores = new ArrayList<>();
    }

    public void setNombreInstitucion(String nombreInstitucion){
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getNombreInstitucion(){
        return nombreInstitucion;
    }

    public void agregarCurso(Curso curso){
        this.cursos.add(curso);
    }

    public void agregarProfesor(Profesor profesor){
        this.profesores.add(profesor);
    }

    public void mostrarCursos(){
        System.out.println("\n\n||Los cursos de la institucion "+ getNombreInstitucion() +" son : ");
        for(Curso curso : cursos){
            System.out.println("ID del Curso : "+ curso.getCursoId());
            System.out.println("Nombre del curso : "+ curso.getNombre());
            System.out.print("\nAlumnos del curso:\n");
            curso.mostrarNombreAlumnos();
            System.out.println("");
            curso.mostrarRecursos();
            
        }
    }

    public void crearCurso()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int id = cursos.size() + 1;

        System.out.println("\n\nEl ID del curso será: " + id);
        System.out.print("Ingrese el nombre del curso: ");
        String nombre = lector.readLine();

        Curso nuevoCurso = new Curso(id, nombre);

        agregarCurso(nuevoCurso);
        System.out.println("Curso creado exitosamente");
    }

    public void eliminarCurso()throws IOException
    {   
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\nLos cursos de la institucion "+ getNombreInstitucion() +" son : ");
        for(Curso curso : cursos){
            System.out.println("ID del Curso : "+ curso.getCursoId());
            System.out.println("Nombre del curso : "+ curso.getNombre()+"\n");
        }
        
        System.out.print("Ingrese el ID del curso a eliminar: ");
        int id = Integer.parseInt(lector.readLine());

        for(int i = 0; i < cursos.size(); i++)
        {
            if(cursos.get(i).getCursoId() == id)
            {
                cursos.remove(i);
                System.out.println("Curso eliminado exitosamente");
            }
            else
            {
                System.out.println("ID invalido");

            }
        }
    }
    public Curso getCursoInteractivo(int id){
            for(Curso curso : cursos){
                if(curso.getCursoId() == id){
                    return curso;
                }
            }
            return null;
        }
    
    public void crearProfesor()throws IOException{
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

    public void mostrarProfesores(){
        System.out.println("\n\n||Los profesores de la institucion "+ getNombreInstitucion() +" son : ");
        for(Profesor profesor : profesores){
            System.out.println("Nombre del profesor : "+ profesor.getNombre());
            System.out.println("Apellido del profesor : "+ profesor.getApellido());
            System.out.println("Edad del profesor : "+ profesor.getEdad());
            System.out.println("Rut del profesor : "+ profesor.getRut()+"\n");
        }
    }

    /*public void eliminarProfesor()throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\nLos profesores de la institucion "+ getNombreInstitucion() +" son : ");
        for(Profesor profesor : profesores){
            System.out.println("Nombre del profesor : "+ profesor.getNombre());
            System.out.println("Apellido del profesor : "+ profesor.getApellido()+"\n");
        }
        
        System.out.print("Ingrese el nombre del profesor a eliminar: ");
        String nombre = lector.readLine();
        System.out.print("Ingrese el apellido del profesor a eliminar: ");
        String apellido = lector.readLine();
        Profesor profesor = buscarProfesorPorNombre(nombre, apellido);
        if(profesor != null){
            profesores.remove(profesor);
            System.out.println("Profesor eliminado exitosamente");
        }else{
            System.out.println("Profesor no encontrado");
        }
    }*/

    public void crearRecurso() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Select a course
        System.out.println("Seleccione el curso al cual desea agregar un recurso:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }
        System.out.print("Ingrese el número del curso: ");
        int cursoIndex = Integer.parseInt(lector.readLine()) - 1;
        
        if (cursoIndex < 0 || cursoIndex >= cursos.size()) {
            System.out.println("Curso no válido.");
            return;
        }
        
        Curso cursoSeleccionado = cursos.get(cursoIndex);
        
        // Select a professor
        System.out.println("Seleccione el profesor para el recurso:");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println((i + 1) + ". " + profesores.get(i).getNombre() + " " + profesores.get(i).getApellido());
        }
        System.out.print("Ingrese el número del profesor: ");
        int profesorIndex = Integer.parseInt(lector.readLine()) - 1;
        
        if (profesorIndex < 0 || profesorIndex >= profesores.size()) {
            System.out.println("Profesor no válido.");
            return;
        }
        
        Profesor profesorSeleccionado = profesores.get(profesorIndex);
        
        // Create the resource
        int id = cursoSeleccionado.getRecursos().size() + 1;
        System.out.println("El ID del Recurso será: " + id);

        System.out.print("Ingrese el nombre del Recurso: ");
        String nombreRecurso = lector.readLine();
        
        System.out.print("Ingrese la descripcion del Recurso: ");
        String descripcionRecurso = lector.readLine();
        
        Recurso nuevoRecurso = new Recurso(nombreRecurso, descripcionRecurso, id, profesorSeleccionado);
        
        // Add the resource to the selected course
        cursoSeleccionado.agregarRecurso(nuevoRecurso);
        
        System.out.println("Recurso agregado exitosamente al curso " + cursoSeleccionado.getNombre());
    }

//MOSTAR NOTAS POR ALUMNO
    /*public void mostrarNotasPorAlumno()throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese rut para ver calificaiones :");
        String rutBuscar = lector.readLine();

        ArrayList<Float> notas = ObtenerNotasPorRutAlumno(rut);

        if (notas.isEmpty()) {
            System.out.println("El alumno con RUT " + rut + " no tiene notas registradas o no existe.");
        } else {
            System.out.println("Notas del alumno con RUT " + rut + ":");
            for (double nota : notas) {
                System.out.println(nota);
            }
        }
        
    }
*/

}


