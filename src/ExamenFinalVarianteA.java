import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamenFinalVarianteA {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Estudiante> estudiantes = new ArrayList<>();

    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n====================");
            System.out.println("       Menu");
            System.out.println("====================");;
            System.out.println("1. Calculadora basica");
            System.out.println("2. Lista de estudiantes");
            System.out.println("3. Gestion de estudiantes");
            System.out.println("4. Salir");
            System.out.println("====================");
            System.out.print("Ingrese su opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    menu.calculadoraBasica();
                    break;
                case 2:
                    menu.listaDeEstudiantes();
                    break;
                case 3:
                    menu.gestionDeEstudiantes();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Cerrando el programa...");
                    break;
                default:
                    System.out.println("Error: Opcion no valida. Por favor, seleccione otra Opcion.");
                    break;
            }
        }

        scanner.close();
    }
}

class Estudiante {
    private String nombre;
    private double calificacion;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.calificacion = -1; // Indica que la calificación no ha sido asignada
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}

class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Estudiante> estudiantes = new ArrayList<>();


    public void calculadoraBasica() {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();
        System.out.print("Ingrese la operación (+, -, *, /): ");
        char operacion = scanner.next().charAt(0);

        double resultado = 0;
        boolean operacionValida = true;

        switch (operacion) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Error: No se puede Dividir por Cero");
                    operacionValida = false;
                }
                break;
            default:
                System.out.println("Operación no válida.");
                operacionValida = false;
                break;
        }

        if (operacionValida) {
            System.out.println("El resultado es: " + resultado);
        }
    }


    public void listaDeEstudiantes() {
        System.out.println("Lista de estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println("Nombre: " + estudiante.getNombre() + ", Calificación: " + (estudiante.getCalificacion() == -1 ? "No asignada" : estudiante.getCalificacion()));
        }
    }

    public void gestionDeEstudiantes() {
        boolean gestionSalir = false;

        while (!gestionSalir) {
            System.out.println("\n====================");
            System.out.println("  Gestion de estudiantes");
            System.out.println("====================");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Ingresar calificación de estudiante");
            System.out.println("4. Volver al menú principal");
            System.out.println("====================");
            System.out.print("Ingrese su opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    eliminarEstudiante();
                    break;
                case 3:
                    ingresarCalificacionEstudiante();
                    break;
                case 4:
                    gestionSalir = true;
                    break;
                default:
                    System.out.println("Error: Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private void agregarEstudiante() {
        System.out.print("Ingrese el nombre del estudiante a agregar: ");
        String nombre = scanner.nextLine();
        estudiantes.add(new Estudiante(nombre));
        System.out.println("Estudiante \"" + nombre + "\" agregado correctamente.");
    }

    private void eliminarEstudiante() {
        System.out.print("Ingrese el nombre del estudiante a eliminar: ");
        String nombre = scanner.nextLine();
        boolean encontrado = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equals(nombre)) {
                estudiantes.remove(estudiante);
                System.out.println("Estudiante \"" + nombre + "\" eliminado correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Error: Estudiante no encontrado.");
        }
    }

    private void ingresarCalificacionEstudiante() {
        System.out.print("Ingrese el nombre del estudiante para asignar calificación: ");
        String nombre = scanner.nextLine();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equals(nombre)) {
                System.out.print("Ingrese la calificación: ");
                double calificacion = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                estudiante.setCalificacion(calificacion);
                System.out.println("Calificación asignada correctamente a \"" + nombre + "\".");
                return;
            }
        }
        System.out.println("Error: Estudiante no encontrado.");
    }
}