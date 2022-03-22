/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzelementaryschool;

import java.util.Scanner;

/**
 *
 * @author hldua
 */
public class XyzElementarySchool {

    public static String read() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void Inicio(double Calificaciones[], String Nombre[], String Apellido[], double proNot[]) {
        for (int i = 0; i < Calificaciones.length; i++) {
            System.out.println("Escriba el nombre del Alumno "+(i + 1));
            Nombre[i] = read();
            System.out.println("Escriba el apellido del Alumno "+(i + 1));
            Apellido[i] = read();
            System.out.println("Ingrese la cantidad de notas a registrar para " + Nombre[i] + " " + Apellido[i]);
            String notas = read();
            int no = Integer.parseInt(notas);
            for (int j = 0; j < no; j++) {

                do {
                    System.out.println("Ingrese la calificacion " + (j + 1) + " : ");
                    String k = read();
                    Calificaciones[j] = Double.parseDouble(k);
                    if (Calificaciones[j] < 0 || Calificaciones[j] > 10) {
                        System.out.println("la nota debe estar comprendida entre 0 y 10");
                        continue;
                    }
                    break;

                } while (true);

            }
            proNot[i] = Promedio(Calificaciones);

        }

    }

    public static double Promedio(double Calificaciones[]) {
        double pro = 0;
        for (int i = 0; i < Calificaciones.length; i++) {
            pro += Calificaciones[i];
        }
        pro /= Calificaciones.length;
        return pro;
    }

    public static void informe(double[] Calificaciones, double[] proNot, String[] Nombre, String[] Apellido) {

        String alumnoMayor = notaMayor(Calificaciones, Nombre, Apellido);
        String alumnoMenor = notaMenor(Calificaciones, Nombre, Apellido);

        System.out.println("El alumno con la mayor nota es: " + alumnoMayor);
        System.out.println("El alumno con la menor nota es: " + alumnoMenor);

        promedioAlto(proNot, Nombre, Apellido);
        promedioBajo(proNot, Nombre, Apellido);

    }

    public static String[] completeName(String[] Nombre, String[] Apellido) {
        String[] comNa = new String[Nombre.length + Apellido.length];

        System.arraycopy(Nombre, 0, comNa, 0, Nombre.length);
        System.arraycopy(Apellido, 0, comNa, Nombre.length, Apellido.length);

        return comNa;
    }

    public static String notaMayor(double Calificaciones[], String Nombre[], String Apellido[]) {
        String[] nombreCompleto = completeName(Nombre, Apellido);
        String alumno = " ";

        double menor = Calificaciones[0];
        for (int i = 0; i < Calificaciones.length; i++) {
            if (Calificaciones[i] < menor) {
                menor = Calificaciones[i];
                alumno = nombreCompleto[i];
            }
        }
        return alumno;
    }

    public static String notaMenor(double Calificaciones[], String Nombre[], String Apellido[]) {
        String[] nombreCompleto = completeName(Nombre, Apellido);
        String alumno = " ";
        double mayor = Calificaciones[0];
        for (int i = 0; i < Calificaciones.length; i++) {
            if (Calificaciones[i] > mayor) {
                mayor = Calificaciones[i];
                alumno = nombreCompleto[i];
            }
        }
        return alumno;
    }

    public static void promedioAlto(double proNot[], String Nombre[], String Apellido[]) {

        String[] nombreCompleto = completeName(Nombre, Apellido);

        System.out.println("Los siguientes alumnos pasaron la materia con promedio Mayor a 7 ");
        for (int i = 0; i < Nombre.length; i++) {
            if (proNot[i] >= 7) {

                System.out.println(nombreCompleto[i]);

            }

        }

    }

    public static void promedioBajo(double proNot[], String Nombre[], String Apellido[]) {

        String[] nombreCompleto = completeName(Nombre, Apellido);

        System.out.println("Los siguientes alumnos perdieron la materia con promedio Menor a 7 ");
        for (int i = 0; i < Nombre.length; i++) {
            if (proNot[i] < 7) {

                System.out.println(nombreCompleto[i]);

            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Ingrese el numero de alumnos");
        String cant = read();
        int n = Integer.parseInt(cant);

        double proNot[] = new double[n];
        double Calificaciones[] = new double[n];

        String Nombre[] = new String[n];
        String Apellido[] = new String[n];

        Inicio(Calificaciones, Nombre, Apellido, proNot);
        informe(Calificaciones, proNot, Nombre, Apellido);
    }
}
