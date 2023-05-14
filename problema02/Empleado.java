package Problema2;

import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {
    private String nombre;
    private double salario;
    private int edad;

    public Empleado() {
    }

    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString() {
        return String.format(
                "\nNombre: " + nombre +
                "\nSalario: " + salario +
                "\nEdad: " + edad +
                "\n");
    }
}
class Ejecutor {

    static ArrayList<Empleado> empleados = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Agregar un empleado.");
            System.out.println("2. Mostrar información de los empleados.");
            System.out.println("3. Calcular aumento de salario.");
            System.out.println("0. Salir.");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    agregarempleado();
                    break;
                case 2:
                    mostrarInformacion();
                    break;
                case 3:
                    CalcularAumento();
                    break;
                case 0:
                    System.out.println(" ¡Vuelva Pronto! ");
                    System.exit(0);
                default:
                    System.out.println("Opcion incorrecta, intente nuevamente");
                    break;
            }
        }
    }

    public static void agregarempleado() {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = sc.next();
        System.out.print("Ingrese el salario del empleado: ");
        double salario = sc.nextDouble();
        System.out.print("Ingrese la edad del empleado: ");
        int edad = sc.nextInt();
        Empleado empleado = new Empleado(nombre, salario, edad);
        empleados.add(empleado);
    }

    public static void mostrarInformacion() {
        if (empleados.size() == 0) {
            System.out.println("No hay empleados registrados");
        } else {
            for (Empleado empleado : empleados ) {
                System.out.println(empleado.toString());
            }
        }
    }

    public static void CalcularAumento() {
        if (empleados.size() == 0) {
            System.out.println("No hay empleados registrados");
        }
        double totalSalario = 0;
        for (Empleado empleado : empleados) {
            totalSalario += empleado.getSalario();
        }
        double salarioPromedio = totalSalario / empleados.size();

        System.out.print("Ingresa el porcentaje del aumento: ");
        double aumento = sc.nextDouble();

        for (Empleado empleado : empleados) {
            if (empleado.getSalario() < salarioPromedio) {
                double aum = empleado.getSalario() * aumento / 100;
                empleado.setSalario(empleado.getSalario() + aum);
                System.out.println("El salario de " + empleado.toString() +" se ha actualizado");
            }
        }
    }
}