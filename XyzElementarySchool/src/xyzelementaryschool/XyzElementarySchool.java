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
        for (int i = 0; i < Nombre.length; i++) {
            System.out.println("Escriba el nombre del Alumno: ");
            Nombre[i] = read();
            System.out.println("Escriba el apellido del Alumno: ");
            Apellido[i] = read();
            System.out.println("Ingrese la cantidad de notas a registrar para " + Nombre + Apellido);
            String notas = read();
            int no = Integer.parseInt(notas);
            for (int j = 0; j < no; j++) {

                do {
                    System.out.println("Ingrese la calificacion : " + j);
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
        for(int i = 0; i < Calificaciones.length; i++){
            pro += Calificaciones[i];
        }
        pro /= Calificaciones.length;
        return pro;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String cant = read();
        System.out.println("Ingrese el numero de alumnos");
        int n = Integer.parseInt(cant);
        
        
        double proNot[] = new double[n];
        double Calificaciones[] = new double[n];
        String Nombre[] = new String[n];
        String Apellido[] = new String[n];

        Inicio(Calificaciones, Nombre, Apellido, proNot);
    }

}
