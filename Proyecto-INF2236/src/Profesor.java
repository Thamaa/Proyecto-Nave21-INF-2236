public class Profesor extends Persona {
    public Profesor(String nombre, String apellido, int edad, String rut) {
        super(nombre, apellido, edad, rut);
    }
    public Profesor(String nombre, String apellido, String rut) {
        super(nombre, apellido, rut);
    }
    public String toCSV() {
        return getNombre() + "," + getApellido() + "," + getEdad() + "," + getRut();
    }
}
