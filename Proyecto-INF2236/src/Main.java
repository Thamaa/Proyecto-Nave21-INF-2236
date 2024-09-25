import java.io.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Institucion institucion = new Institucion("Colegio Los Leones");
        int opcion;
        int opcionAdministrador;
        int opcionCurso;
        int opcionAlumno;
        int opcionProfesor;

        do {
            System.out.println(" -------------------------");
            System.out.println("|     Menu Principal      |");
            System.out.println(" -------------------------");
            System.out.println("| 1.- Administrador       |");
            System.out.println("| 2.- Curso               |");
            System.out.println("| 3.- Profesor            |");
            System.out.println("| 4.- Alumno              |");
            System.out.println(" -------------------------");
            System.out.print("Seleccione una opcion: ");
            String leido = lector.readLine();
            opcion = Integer.parseInt(leido);

            switch(opcion)
            {
                case 1:
                {
                    do {
                        System.out.println("\n\n ------------------------------------");
                        System.out.println("| Bienvenido al menu Administrador!! |");
                        System.out.println(" ------------------------------------");
                        System.out.println("| 1.- Agregar Curso                  |");
                        System.out.println("| 2.- Eliminar Curso                 |");
                        System.out.println("| 3.- Mostrar todos los Cursos       |");
                        System.out.println("| 4.- Crear Profesor                 |");
                        System.out.println("| 5.- Eliminar Profesor              |");
                        System.out.println("| 6.- Mostrar Profesores             |");
                        System.out.println("| 7.- Crear y Agregar Alumno a curso |");
                        System.out.println("| 8.- Agregar Profesor A Recurso     |");
                        System.out.println("| 9.- Agregar Recursos A Curso       |");
                        System.out.println("| 10.- Eliminar Recurso De Curso     |");
                        System.out.println("| 11.- Eliminar Alumno               |");
                        System.out.println("| 12.- Mostrar Recursos              |");
                        System.out.println("| 13.- Mostrar Alumnos Por Curso     |");
                        System.out.println("| 14.- Buscar Curso                  |");
                        System.out.println("| 15.- Asignar Profesor A Recurso    |");
                        System.out.println("| 16.- Volver al menu                |");
                        System.out.println(" ------------------------------------");
                        System.out.print("Seleccione una opcion: ");
                        leido = lector.readLine();
                        opcionAdministrador = Integer.parseInt(leido);
                        switch(opcionAdministrador) 
                        {
                            case 1: {
                                //Crear Curso
                                
                                institucion.crearCurso();
                                lector.readLine(); 
                                break;
                            }

                            case 2: {
                                //Eliminar Curso
                                institucion.eliminarCurso();
                                lector.readLine();
                                break;
                            }
                            case 3: {
                                //Mostrar Cursos
                                institucion.mostrarCursos();
                                lector.readLine();
                                break;
                            }
                            case 4: {
                                //Crear Profesor
                                institucion.crearProfesor();
                                lector.readLine();
                                break;
                            }
                            case 5:{
                                //Eliminar Profesor
                                institucion.eliminarProfesor();
                                lector.readLine();
                                break;
                            }
                            case 6:{
                                //Mostrar Profesores
                                institucion.mostrarProfesores();
                                lector.readLine();
                                break;
                            }
                            case 7:{
                                //Mostrar Profesores
                                institucion.agregarAlumno();
                                lector.readLine();
                                break;
                            }
                            case 8:{
                                //Agregar Profesor a Recurso
                                institucion.agregarProfesorARecurso();
                                lector.readLine();
                                break;
                            }
                            case 9:{
                                //Agregar Recursos A Curso
                                institucion.crearRecurso();
                                lector.readLine();
                                break;
                            }
                            case 10:{
                                //Eliminar Recurso De Curso
                                institucion.eliminarRecurso();
                                lector.readLine();
                                break;
                            }
                            case 11:{
                                //Eliminar Recurso De Curso
                                institucion.eliminarAlumno();
                                lector.readLine();
                                break;
                            }
                            case 12:{
                                //Mostrar Recursos
                                institucion.mostrarTodosLosRecursos();
                                lector.readLine();
                                break;
                            }
                            case 13:{
                                //Mostrar Recursos
                                institucion.mostrarAlumnos();
                                lector.readLine();
                                break;
                            }
                            
                            case 14: {
                                institucion.mostrarCursoIdNombre();
                                lector.readLine();
                                break;

                            }
                            
                            
                            case 15:{
                                institucion.asignarProfesorARecurso();
                                lector.readLine();
                                break;
                            }
                            case 16:{
                                //Saliendo del menu
                                System.out.println("Saliendo del menu.....");
                                break;
                            }

                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }while(opcionAdministrador != 15);
                    break;
                }
                    
                case 2:
                {
                    do 
                    {
                        System.out.println("\n\n ----------------------------");
                        System.out.println("| Bienvenido al menu Curso!! |");
                        System.out.println(" ----------------------------");
                        System.out.println("| 1.- Agregar Curso           |");
                        System.out.println("| 2.- Eliminar Curso          |");
                        System.out.println("| 3.- Mostrar Cursos          |");
                        System.out.println("| 4.- Volver al menu principal|");
                        System.out.println(" ----------------------------");
                        System.out.print("Seleccione una opcion: ");
                        leido = lector.readLine();
                        opcionCurso = Integer.parseInt(leido);
                        switch(opcionCurso) {
                            case 1: {
                                //Crear Curso
                                institucion.crearCurso();
                                lector.readLine();

                                break;
                            }

                            case 2: {
                                //Eliminar Curso
                                institucion.eliminarCurso();
                                lector.readLine();

                                break;
                            }
                            case 3: {
                                //Mostrar Cursos
                                institucion.mostrarCursos();
                                lector.readLine();
                                
                                break;
                            }
                            case 4: {
                                //Saliendo del menu
                                System.out.println("Saliendo del menu.....");
                                break;
                            }
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }while(opcionCurso != 4);
                }
                break;

                
                case 3:
                {
                    do 
                    {
                        System.out.println("\n\n -----------------------------------");
                        System.out.println("| Bienvenido al menu Profesor       |");
                        System.out.println(" -----------------------------------");
                        System.out.println("| 1.- Mostrar Cursos                |");
                        System.out.println("| 2.- Mostrar Recursos              |");
                        System.out.println("| 3.- Volver al menu                |");
                        System.out.println(" -----------------------------------");
                        System.out.print("Seleccione una opcion: ");
                        leido = lector.readLine();
                        opcionProfesor = Integer.parseInt(leido);
                        switch(opcionProfesor) {
                            case 1: {
                                //Mostrar Cursos
                                institucion.mostrarCursos();
                                lector.readLine();
                                break;
                            }

                            case 2: {
                                //mostrar recursos
                                institucion.mostrarRecursosDeProfesor();
                                lector.readLine();
                                break;
                            }
                            case 3:{
                                //Saliendo del menu
                                System.out.println("Saliendo del menu.....");
                                break;
                            }
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }while(opcionProfesor != 3);
                    break;
                }

                case 4:
                {
                    do {
                        System.out.println("\n\n -----------------------------");
                        System.out.println("| Bienvenido al menu Alumno     |");
                        System.out.println(" -------------------------------");
                        System.out.println("| 1.- Mostrar Recursos          |");
                        System.out.println("| 2.- Volver al menu            |");
                        System.out.println(" -------------------------------");
                        System.out.print("Seleccione una opcion: ");
                        leido = lector.readLine();
                        opcionAlumno = Integer.parseInt(leido);
                        switch(opcionAlumno) {
                            case 1: {
                                //mostrar recurso
                                institucion.mostrarRecursoAlumno();
                                lector.readLine();
                                break;
                            }

                            case 2:{
                                //Saliendo del menu
                                System.out.println("Saliendo del menu.....");
                                break;
                            }
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }while(opcionAlumno != 2);
                    break;
                }
                default:
                    System.out.println("Opción no válida.");
                    break;

            }
        }while(opcion != 4);
    }
}