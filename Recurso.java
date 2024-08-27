

public class Recurso {
    private String nombreRecurso;
    private String descripcionRec;
    private int recursoID;
    private Profesor profesor;


    public Recurso(String nombreRecurso,String descripcionRec, int RecursoID, Profesor profesor){
        this.nombreRecurso = nombreRecurso;
        this.recursoID = RecursoID;
        this.descripcionRec = descripcionRec;
        this.profesor = profesor;

    }

    public void setRecursoID(int RecursoID){
        this.recursoID = RecursoID;
    }

    public int getRecursoID(){
        return recursoID;
    }

    public void setDescripcionRec(String descripcionRec){
        this.descripcionRec = descripcionRec;
    }

    public String getDescripcionRec(){
        return descripcionRec;
    }

    public void agregarProfesorARecurso(Profesor profesor){
        this.profesor = profesor;
    }

    public Profesor getProfesor(){
        return profesor;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getNombreRecurso(){
        return nombreRecurso;
    }
    


}
