import java.io.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Institucion institucion = new Institucion("Colegio Los Leones");
        Alumno a1 = new Alumno("Pablo","Fuenzalida",20,"21.434.564-1");
        Alumno a2 = new Alumno("Gabriel","Gunther",21,"21.383.321-0");
        Alumno a3 = new Alumno("Diego","Skibidi",19,"21.878.090-4");

        Alumno a4 = new Alumno("Samuel","Ortega",17,"21.432.566-0");
        Alumno a5 = new Alumno("Francisco","Ortega",17,"21.434.564-1");
        Alumno a6 = new Alumno("Marcelo","Gallardo",18,"21.234.757-4");


        //Creamos Profesores
        Profesor p1 = new Profesor("Claudio","Cubillos",58,"11.111.111-1");
        Profesor p2 = new Profesor("Rafael","Mellado",40,"11.111.111-2");

        // Creamos Curso
        Curso c1 = new Curso(1,"CuartoMedioB");

        Curso c2 = new Curso(2,"TerceroMedioA");
        //Creamos Recurso

        Recurso r1 = new Recurso("Matematicas 1", "Curso básico de matematicas",1,p1);
        Recurso r2 = new Recurso("Estructura de datos", "Curso sobre estructuras de datos en C",2,p2);

        Recurso r3 = new Recurso("Matematicas 2", "Curso avanzado de matematicas",3,p2);
        Recurso r4 = new Recurso("Programacion Avanzada", "Curso sobre POO",4,p1);

        
        institucion.agregarCurso(c1);
        institucion.agregarProfesor(p1);
        institucion.agregarProfesor(p2);

        institucion.agregarCurso(c2);

        c1.agregarAlumnoARecurso(a1);
        c1.agregarAlumnoARecurso(a2);
        c1.agregarAlumnoARecurso(a3);

        c2.agregarAlumnoARecurso(a4);
        c2.agregarAlumnoARecurso(a5); 
        c2.agregarAlumnoARecurso(a6);

        r1.agregarProfesorARecurso(p1);
        r2.agregarProfesorARecurso(p2);
        
        c1.agregarRecursoACurso(r1);
        c1.agregarRecursoACurso(r2);

        c2.agregarRecursoACurso(r3);
        c2.agregarRecursoACurso(r4);
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
                        System.out.println("| 15.- Volver al menu                |");
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
                                institucion.crearYAgregarAlumnoACurso();
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
                                //Saliendo del menu
                                System.out.println("Saliendo del menu.....");
                                break;
                            }
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }while(opcionAdministrador != 14);
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