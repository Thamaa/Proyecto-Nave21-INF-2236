public class Alumno extends Persona {

    private int idCursoPerteneciente;
    public Alumno(String nombre, String apellido, int edad, String rut, int idCursoPerteneciente) {
        super(nombre, apellido, edad, rut);
        this.idCursoPerteneciente = idCursoPerteneciente;
    }
    public String toCSV() {
        return getNombre() + "," + getApellido() + "," + getEdad() + "," + getRut() +"," + getIdCursoPerteneciente();
    }

    public int getIdCursoPerteneciente() {
        return idCursoPerteneciente;
    }

    public void setIdCursoPerteneciente(int idCursoPerteneciente) {
        this.idCursoPerteneciente = idCursoPerteneciente;
    }

}
