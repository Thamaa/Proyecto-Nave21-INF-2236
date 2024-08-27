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
}
