

public class Recurso {
    private String nombreRecurso;
    private String descripcionRec;
    private int recursoID;
    private Profesor profesor;
    private int idCursoPerteneciente;


    public Recurso(String nombreRecurso,String descripcionRec, int RecursoID, Profesor profesor,int cursoPerteneciente){
        this.nombreRecurso = nombreRecurso;
        this.recursoID = RecursoID;
        this.descripcionRec = descripcionRec;
        this.profesor = profesor;
        this.idCursoPerteneciente = cursoPerteneciente;

    }

    public Recurso() {
    }

    public Recurso(int idRecurso, String nombreRecurso, String desc, int cursoId) {
        this.recursoID = idRecurso;
        this.nombreRecurso = nombreRecurso;
        this.descripcionRec = desc;
        this.idCursoPerteneciente = cursoId;
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
    
    public void eliminarProfesor() {
        this.profesor = null;
    }

    public String toCSV() {
        return recursoID + "," + nombreRecurso + "," + profesor.getRut()+ "," + descripcionRec + ","+ idCursoPerteneciente;
    }

    public int getIdCursoPerteneciente() {
        return idCursoPerteneciente;
    }

    public void setIdCursoPerteneciente(int cursoPerteneciente) {
        this.idCursoPerteneciente = cursoPerteneciente;
    }

    public Profesor getProfesorPorRut(String rut) {
        if(profesor != null && profesor.getRut().equals(rut)){
            return this.profesor;
        }
        return null;
    }
}



