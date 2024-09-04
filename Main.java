import java.io.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Institucion institucion = new Institucion("Papu College ");
        
        Alumno a1 = new Alumno("Pablo","Fuenzalida",20,"21.434.564-1");
        Alumno a2 = new Alumno("Gabriel","Gunther",21,"21.383.321-0");
        Alumno a3 = new Alumno("skibidi","diego",19,"21.878.090-4");




        //Creamos Profesores
        Profesor p1 = new Profesor("Claudio","Cubillos",58,"11.111.111-1");
        Profesor p2 = new Profesor("Rafael","Mellado",40,"11.111.111-2");

        // Creamos Curso
        Curso c1 = new Curso(1,"CuartoMedioB");
        //Creamos Recurso

        Recurso r1 = new Recurso("Matematicas 1", "Curso básico de matematicas",1,p1);
        Recurso r2 = new Recurso("Estructura de datos", "Curso sobre estructuras de datos en C",2,p2);

        
        institucion.agregarCurso(c1);
        institucion.agregarProfesor(p1);
        institucion.agregarProfesor(p2);

        c1.agregarAlumnoARecurso(a1);
        c1.agregarAlumnoARecurso(a2);
        c1.agregarAlumnoARecurso(a3);

        r1.agregarProfesorARecurso(p1);
        r2.agregarProfesorARecurso(p2);
        
        c1.agregarRecursoACurso(r1);
        c1.agregarRecursoACurso(r2);
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
                        System.out.println("| 3.- Mostrar Cursos                 |");
                        System.out.println("| 4.- Crear Profesor                 |");
                        System.out.println("| 5.- Eliminar Profesor              |");
                        System.out.println("| 6.- Mostrar Profesores             |");
                        System.out.println("| 7.- Agregar Profesor A Recurso     |");
                        System.out.println("| 8.- Agregar Recursos A Curso       |");
                        System.out.println("| 9.- Eliminar Recurso De Curso      |");
                        System.out.println("| 10.- Mostrar Recursos              |");
                        System.out.println("| 11.- Volver al menu                |");
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
                                //Agregar Profesor a Recurso
                                institucion.agregarProfesorARecurso();
                                lector.readLine();
                                break;
                            }
                            case 8:{
                                //Agregar Recursos A Curso
                                institucion.crearRecurso();
                                lector.readLine();
                                break;
                            }
                            case 9:{
                                //Eliminar Recurso De Curso
                                institucion.eliminarRecurso();
                                lector.readLine();
                                break;
                            }
                            case 10:{
                                //Mostrar Recursos
                                institucion.mostrarTodosLosRecursos();
                                lector.readLine();
                                break;
                            }
                            
                            case 11: {
                                //Saliendo del menu
                                System.out.println("Saliendo del menu.....");
                                break;
                            }
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }while(opcionAdministrador != 11);
                }
                break;
                    
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