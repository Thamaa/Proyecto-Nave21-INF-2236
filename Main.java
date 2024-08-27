import java.io.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Institucion institucion = new Institucion("Papu College ");
        
        Alumno a1 = new Alumno("Pablo","Fuenzalida",20,"21.434.564-1");
        Alumno a2 = new Alumno("Gabriel","Gunther",21,"21.383.321-0");
        Alumno a3 = new Alumno("Marcelo","Gallardo",19,"21.878.090-4");

        //Creamos Profesores
        Profesor p1 = new Profesor("Claudio","Cubillos",58,"10.677.234-1");
        Profesor p2 = new Profesor("Rafael","Mellado",40,"16.334.324-3");

        // Creamos Curso
        Curso c1 = new Curso(1,"CuartoMedioB");
        //Creamos Recurso

        Recurso r1 = new Recurso("Matematicas 1", "Curso básico de matematicas",1,p1);
        Recurso r2 = new Recurso("Estructura de datos", "Curso sobre estructuras de datos en C",2,p2);

        
        institucion.agregarCurso(c1);

        c1.agregarAlumnoARecurso(a1);
        c1.agregarAlumnoARecurso(a2);
        c1.agregarAlumnoARecurso(a3);

        r1.agregarProfesorARecurso(p1);
        r2.agregarProfesorARecurso(p2);
        
        c1.agregarRecursoACurso(r1);
        c1.agregarRecursoACurso(r2);

        while(true)
        {
                System.out.println(" -------------------------");
                System.out.println("|     Menu de Opciones    |");
                System.out.println(" -------------------------");
                System.out.println("| 1.- Curso               |");
                System.out.println("| 2.- Profesor            |");
                System.out.println("| 3.- Alumno              |");
                System.out.println(" -------------------------");
                System.out.print("Seleccione una opcion: ");
                String leido = lector.readLine();
                int opcion = Integer.parseInt(leido);

                switch(opcion)
                {
                    case 1:
                    {
                        System.out.println("\n\n ----------------------------");
                        System.out.println("| Bienvenido al menu Curso!! |");
                        System.out.println(" ----------------------------");
                        System.out.println("| 1.- Agregar Curso          |");
                        System.out.println("| 2.- Eliminar Curso         |");
                        System.out.println("| 3.- Mostrar Cursos         |");
                        System.out.println("| 4.- Mostrar Recursos       |");
                        System.out.println(" ----------------------------");
                        System.out.print("Seleccione una opcion: ");
                        leido = lector.readLine();
                        opcion = Integer.parseInt(leido);

                        switch(opcion)
                        {
                            case 1:
                                {
                                    
                                    break;
                                }
                            
                            case 2:
                                {
                                    break;
                                }
                            case 3:
                                {
                                    institucion.mostrarCursos();
                                    lector.readLine();
                                    break;
                                }
                            case 4:
                                {
                                    break;
                                }
                                default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }

                    case 2:
                    {
                        System.out.println(" \n-------------------------------");
                        System.out.println("| Bienvenido al menu Profesor !!|");
                        System.out.println(" -------------------------------");
                        System.out.println("| 1.- Agregar Profesor          |");
                        System.out.println(" -------------------------------");
                        break;
                    }

                    case 3:
                    {
                        System.out.println(" \n-----------------------------");
                        System.out.println("| Bienvenido al menu Alumno !!|");
                        System.out.println(" -----------------------------");
                        System.out.println("| 1.- Agregar Alumno          |");
                        System.out.println("| 2.- Eliminar Alumno         |");
                        System.out.println(" -----------------------------");
                        break;    
                    }
          
            }
        }
    }
}



