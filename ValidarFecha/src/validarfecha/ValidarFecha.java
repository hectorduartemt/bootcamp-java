/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validarfecha;

import java.util.Scanner;

/**
 *
 * @author hldua
 */
public class ValidarFecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in); // Inicializamos Scanner para capturar datos desde el teclado
        System.out.println("Ingrese el dia: ");
        int dia = sc.nextInt();
        System.out.println("Ingrese el Mes: ");
        int mes = sc.nextInt();
        System.out.println("Ingrese el año: ");
        int anio = sc.nextInt();

        if (anio >= 1900 && anio <= 2099) {
            if (mes >= 1 && mes <= 12) {
                if (mes == 2 && (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
                    if (dia >= 1 && dia <= 29) {
                        System.out.println("La fecha es valida");
                    } else {
                        System.out.println("Fecha NO es valida");
                    }

                } else if (mes == 2) {
                    if (dia >= 1 && dia <= 28) {
                        System.out.println("La fecha es valida");
                    } else {
                        System.out.println("Fecha NO es valida");
                    }
                } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    if (dia >= 1 && dia <= 31) {
                        System.out.println("La fecha es valida");
                    } else {
                        System.out.println("Fecha NO es valida");
                    }
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    if (dia >= 1 && dia <= 30) {
                        System.out.println("La fecha es valida");
                    } else {
                        System.out.println("Fecha NO es valida");
                    }
                } else {
                    System.out.println("Fecha NO es valida");
                }
            } else {
                System.out.println("Fecha NO es valida");
            }
        }
    }

}
