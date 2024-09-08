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

    public void setCursos(ArrayList<Curso> cursos){
        this.cursos = cursos;
    }

    public ArrayList<Curso> getCursos(){
        return cursos;
    }

    public void setProfesores(ArrayList<Profesor> profesores){
        this.profesores = profesores;
    }

    public ArrayList<Profesor> getProfesores(){
        return profesores;
    }


    //METODOS CREAR

    //METODO CREAR CURSO
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

    //METODO CREAR ALUMNO
    public void crearYAgregarAlumnoACurso()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = lector.readLine();
        
        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = lector.readLine();
        
        System.out.print("Ingrese la edad del alumno: ");
        int edad = Integer.parseInt(lector.readLine());
        
        System.out.print("Ingrese el rut del alumno: ");
        String rut = lector.readLine();
        
        
        Alumno nuevoAlumno = new Alumno(nombre, apellido, edad, rut);

        System.out.println("Seleccione el curso al cual desea agregar el alumno:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }
        System.out.print("Ingrese el número del curso: ");
        int posicionCurso = Integer.parseInt(lector.readLine()) - 1;

        if (posicionCurso < 0 || posicionCurso >= cursos.size()) {
            System.out.println("Curso no válido.");
            return;
        }

        Curso cursoSeleccionado = cursos.get(posicionCurso);
        
        for (Curso cursoActual : cursos) {
            if (cursoActual.getNombre().equals(cursoSeleccionado.getNombre())) {
                cursoActual.agregarAlumnoARecurso(nuevoAlumno);
                System.out.println("Alumno creado exitosamente");
                return;
            }
        }
        
        System.out.println("No se encontró el curso especificado.");
    }


    //METODO AGREGAR PROFESOR A RECURSO 
    public void agregarProfesorARecurso() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        // Mostrar los profesores disponibles
        System.out.println("\n\nLos profesores de la institución " + getNombreInstitucion() + " son:");
        for (Profesor profesor : profesores) {
            System.out.println("Nombre: " + profesor.getNombre() + " " + profesor.getApellido() + " | RUT: " + profesor.getRut());
        }
    
        System.out.print("\nIngrese el RUT del profesor: ");
        String rutBuscado = lector.readLine();
    
        Profesor profesorSeleccionado = null;
        for (Profesor profesor : profesores) {
            if (profesor.getRut().equals(rutBuscado)) {
                profesorSeleccionado = profesor;
                break;
            }
        }
    
        if (profesorSeleccionado == null) {
            System.out.println("No se encontró un profesor con el RUT especificado.");
            return;
        }
    
        // Mostrar los cursos disponibles
        System.out.println("\nSeleccione el curso al cual desea asignar el recurso:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }
        System.out.print("Ingrese el número del curso: ");
        int posicionCurso = Integer.parseInt(lector.readLine()) - 1;
    
        if (posicionCurso < 0 || posicionCurso >= cursos.size()) {
            System.out.println("Curso no válido.");
            return;
        }
    
        Curso cursoSeleccionado = cursos.get(posicionCurso);
    
        // Mostrar los recursos disponibles en el curso seleccionado
        System.out.println("\nLos recursos del curso " + cursoSeleccionado.getNombre() + " son:");
        for (Recurso recurso : cursoSeleccionado.getRecursos()) {
            System.out.println("ID del Recurso: " + recurso.getRecursoID() + " | Nombre del Recurso: " + recurso.getNombreRecurso());
        }
    
        System.out.print("Ingrese el ID del recurso al cual desea asignar el profesor: ");
        int idRecurso = Integer.parseInt(lector.readLine());
    
        Recurso recursoSeleccionado = cursoSeleccionado.buscarRecursoPorID(idRecurso);
        if (recursoSeleccionado == null) {
            System.out.println("No se encontró un recurso con el ID especificado.");
            return;
        }
    
        // Verificar si el recurso ya tiene un profesor asignado
        if (recursoSeleccionado.getProfesor() != null) {
            System.out.println("Este recurso ya tiene profesor.");
            return;
        }
    
        // Asignar el profesor al recurso
        recursoSeleccionado.agregarProfesorARecurso(profesorSeleccionado);
        System.out.println("Profesor asignado exitosamente al recurso.");
    }
    // METODOS CREAR PROFESOR
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


    //METODOS CREAR RECURSO
    public void crearRecurso() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
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
        
        System.out.println("Seleccione el profesor para el recurso:");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println((i + 1) + ". " + profesores.get(i).getNombre() + " " + profesores.get(i).getApellido());
        }
        System.out.print("Ingrese el número del profesor: ");
        int profeElegido = Integer.parseInt(lector.readLine()) - 1;
        
        if (profeElegido < 0 || profeElegido >= profesores.size()) {
            System.out.println("Profesor no válido.");
            return;
        }
        
        Profesor profesorSeleccionado = profesores.get(profeElegido);
        
        System.out.print("Ingrese el ID del Recurso: ");
        int id = Integer.parseInt(lector.readLine());
        
        // Aca se verifica que el ID no choque con ningún otro recurso en otros cursos
        for (Curso curso : cursos) {
            for (Recurso recurso : curso.getRecursos()) {
                if (recurso.getRecursoID() == id) {
                    System.out.println("El ID del recurso ya está en uso en otro curso. Por favor, elija otro ID.");
                    return;
                }
            }
        }
        //Aca se asignan los valores al recurso nuevo 
        System.out.print("Ingrese el nombre del Recurso: ");
        String nombreRecurso = lector.readLine();
        
        System.out.print("Ingrese la descripcion del Recurso: ");
        String descripcionRecurso = lector.readLine();
        
        Recurso nuevoRecurso = new Recurso(nombreRecurso, descripcionRecurso, id, profesorSeleccionado);
        
        cursoSeleccionado.agregarRecurso(nuevoRecurso);
        
        System.out.println("Recurso agregado exitosamente al curso " + cursoSeleccionado.getNombre());
    }

    //METODOS ELIMINAR

    //METODO ELIMINAR ALUMNO
    public void eliminarAlumno()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\nLos alumnos de la institucion "+ getNombreInstitucion() +" son : ");
        for(Curso curso : cursos){
            System.out.println("Curso : "+ curso.getNombre());
            curso.mostrarNombreAlumnos();
            System.out.println("----------------------------------------------------------------------------------\n");
        }
        
        System.out.print("Ingrese el rut del alumno a eliminar: ");
        String rut = lector.readLine();
        
        
        for(Curso curso : cursos){
            for(Alumno alumno : curso.getAlumnos()){
                if(alumno.getRut().equals(rut)){
                    curso.eliminarAlumnoDeCurso(alumno);
                    System.out.println("Alumno eliminado exitosamente");
                    return;
                }
            }
        }
        
        System.out.println("No se encontró un alumno con el nombre y apellido especificado.");
    }

    //METODO ELIMINAR CURSO
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
    //METODO ELIMINAR PROFESOR
    public void eliminarProfesor() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\nLos profesores de la institución " + getNombreInstitucion() + " son:");
        for (Profesor profesor : profesores) {
            System.out.println("Nombre: " + profesor.getNombre() + " " + profesor.getApellido() + " | RUT: " + profesor.getRut());
        }
    
        System.out.print("\nIngrese el RUT del profesor a eliminar: ");
        String rutBuscado = lector.readLine();
    
        boolean profesorEliminado = false;
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getRut().equals(rutBuscado)) {
                Profesor profesorAEliminar = profesores.get(i);
                profesores.remove(i);
                profesorEliminado = true;
                System.out.println("Profesor eliminado exitosamente.");
    
                // Eliminar al profesor de los recursos en cada curso
                for (Curso curso : cursos) {
                    curso.eliminarProfesorDeRecursos(profesorAEliminar);
                }
                break;
            }
        }
        if (!profesorEliminado) {
            System.out.println("No se encontró un profesor con el RUT especificado.");
        }
    }

    //METODO ELIMINAR RECURSO
    public void eliminarRecurso() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        // Aca se selecciona el curso
        System.out.println("Seleccione el curso del cual desea eliminar un recurso:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }
        System.out.print("Ingrese el número del curso: ");
        int posicionCurso = Integer.parseInt(lector.readLine()) - 1; // Se resta 1 porque los índices empiezan en 0
        
        //se valida input del usuario
        if (posicionCurso < 0 || posicionCurso >= cursos.size()) {
            System.out.println("Curso no válido.");
            return;
        }
        
        //se le asigna a la variable el curso que se seleccionó
        Curso cursoSeleccionado = cursos.get(posicionCurso);
        
        System.out.println("Los Recursos del curso " + cursoSeleccionado.getNombre() + " son : ");
        for (Recurso recurso : cursoSeleccionado.getRecursos()) {
            System.out.println("ID del Recurso : " + recurso.getRecursoID());
            System.out.println("Nombre del Recurso : " + recurso.getNombreRecurso() + "\n");
        }
        
        System.out.print("Ingrese el ID del Recurso a eliminar: ");
        int id = Integer.parseInt(lector.readLine());
        
        Recurso recurso = cursoSeleccionado.buscarRecursoPorID(id);
        if (recurso != null) {
            // Aca se elimina el recurso del curso
            cursoSeleccionado.eliminarRecursoDeCurso(recurso);
            System.out.println("Recurso eliminado exitosamente");
        } else {
            System.out.println("Recurso no encontrado");
        }
    }

    //METODOS MOSTRAR

    //METODO MOSTRAR ALUMNOS 
    public void mostrarAlumnos() {
        System.out.println("\n\n----------------------------------------------------------------------------------");
        System.out.println("Los alumnos de la institucion "+ getNombreInstitucion() +" son : ");
        for(Curso curso : cursos){
            System.out.println("Curso : "+ curso.getNombre());
            curso.mostrarNombreAlumnos();
            System.out.println("----------------------------------------------------------------------------------\n");
        }
    }

    //METODO MOSTRAR RECURSOS DEL PROFESOR
    public void mostrarRecursosDeProfesor() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Seleccione el profesor del cual desea ver los recursos:");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println((i + 1) + ". " + profesores.get(i).getNombre() + " " + profesores.get(i).getApellido());
        }
        System.out.print("Ingrese el número del profesor: ");
        int posicionProfesor = Integer.parseInt(lector.readLine()) - 1;
        
        if (posicionProfesor < 0 || posicionProfesor >= profesores.size()) {
            System.out.println("Profesor no válido.");
            return;
        }
        
        Profesor profesorSeleccionado = profesores.get(posicionProfesor);
        
        System.out.println("Los Recursos del profesor "+ profesorSeleccionado.getNombre() +" "+ profesorSeleccionado.getApellido() +" son : ");
        for(Curso curso : cursos){
            for(Recurso recurso : curso.getRecursos()){
                if(recurso.getProfesor().equals(profesorSeleccionado)){
                    System.out.println("ID del Recurso : "+ recurso.getRecursoID());
                    System.out.println("Nombre del Recurso : "+ recurso.getNombreRecurso());
                    System.out.println("Descripcion del Recurso : "+ recurso.getDescripcionRec()+"\n");
                }
            }
        }
    }

    //METODO MOSTRAR PROFESOR
    public void mostrarProfesores(){
        System.out.println("\n\n||Los profesores de la institucion "+ getNombreInstitucion() +" son : ");
        for(Profesor profesor : profesores){
            System.out.println("Nombre del profesor : "+ profesor.getNombre());
            System.out.println("Apellido del profesor : "+ profesor.getApellido());
            System.out.println("Edad del profesor : "+ profesor.getEdad());
            System.out.println("Rut del profesor : "+ profesor.getRut()+"\n");
        }
    }
    
    //METODO MOSTRAR CURSOS
    public void mostrarCursos(){
        System.out.println("\n\n----------------------------------------------------------------------------------");
        System.out.println("Los cursos de la institucion "+ getNombreInstitucion() +" son : ");
        for(Curso curso : cursos){
            System.out.println("ID del Curso : "+ curso.getCursoId());
            System.out.println("Nombre del curso : "+ curso.getNombre());
            System.out.print("\nAlumnos del curso:\n");
            curso.mostrarNombreAlumnos();
            System.out.println("");
            curso.mostrarRecursos();
            
        }
    }
    //METODO MOSTRAR TODOS LOS RECURSOS
    public void mostrarTodosLosRecursos(){
        for(Curso curso : cursos){
            for(Recurso recurso : curso.getRecursos()){
                System.out.println("ID del Recurso : "+ recurso.getRecursoID());
                System.out.println("Nombre del Recurso : "+ recurso.getNombreRecurso());
                System.out.println("Descripcion del Recurso : "+ recurso.getDescripcionRec()+"\n");
                
            }
        }
    }

    //METODO MOSTRAR RECURSOS DE UN ALUMNO
    public void mostrarRecursoAlumno()throws IOException{
       BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Seleccione el curso del cual desea ver los recursos:");
            for (int i = 0; i < cursos.size(); i++) {
                System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
            }
            System.out.print("Ingrese el número del curso: ");
            int posicionCurso = Integer.parseInt(lector.readLine()) - 1;
            
            if (posicionCurso < 0 || posicionCurso >= cursos.size()) {
                System.out.println("Curso no válido.");
                return;
            }
            
            Curso cursoSeleccionado = cursos.get(posicionCurso);
            
            System.out.println("Los Recursos del curso "+ cursoSeleccionado.getNombre() +" son: ");
            for(Recurso recurso : cursoSeleccionado.getRecursos()){
                System.out.println("ID del Recurso: "+ recurso.getRecursoID());
                System.out.println("Nombre del Recurso: "+ recurso.getNombreRecurso()+"\n");
            }
            
            System.out.print("Ingrese el ID del Recurso que desea ver: ");
            int id = Integer.parseInt(lector.readLine());
            System.out.println("");
            Recurso recurso = cursoSeleccionado.buscarRecursoPorID(id);
            if(recurso != null){
                System.out.println("Nombre del Recurso: "+ recurso.getNombreRecurso());
                System.out.println("Descripcion del Recurso: "+ recurso.getDescripcionRec());
                System.out.println("Profesor del Recurso: "+ recurso.getProfesor().getNombre()+" "+ recurso.getProfesor().getApellido()+"\n");
            } else {
                System.out.println("Recurso no encontrado");
            }
        
    }

    public void mostrarCursoIdNombre()throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el Nombre o ID del curso: ");
        String leido = lector.readLine();

        Curso cursoEncontrado = null;

        try {
            int cursoId = Integer.parseInt(leido);
            cursoEncontrado = buscarCurso(cursoId); 

        }   catch (NumberFormatException e) {
        
        cursoEncontrado = buscarCurso(leido); 
        }
        if (cursoEncontrado != null) {
            System.out.println("\n\n----------------------------------------------------------------------------------");
            System.out.println("Detalles del curso:");
            System.out.println("ID del Curso: " + cursoEncontrado.getCursoId());
            System.out.println("Nombre del Curso: " + cursoEncontrado.getNombre());
            System.out.println("\nAlumnos del curso:");
            cursoEncontrado.mostrarNombreAlumnos();
            System.out.println("\nRecursos del curso:");
            cursoEncontrado.mostrarRecursos();
            } 
        else 
        {
        System.out.println("No se encontró un curso con el ID o Nombre proporcionado.");
        }
    }

    //METODO BUSCAR CURSO POR ID Y POR NOMBRE 

    public Curso buscarCurso(int cursoId)
    {
        for(Curso curso: cursos)
        {
            if(curso.getCursoId() == cursoId)
            {
                return curso;
            }
        }
        return null;
    }

    public Curso buscarCurso(String nombre)
    {
        for(Curso curso: cursos)
        {
            if(curso.getNombre().equalsIgnoreCase(nombre))
            {
                return curso;
            }
        }
        return null;
    }
}


