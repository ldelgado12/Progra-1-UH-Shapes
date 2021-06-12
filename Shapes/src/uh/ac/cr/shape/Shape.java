package uh.ac.cr.shape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Shape {

    Scanner scanner;
    int answer;
    int lengthDesired;
    String continuar = "s";

    public static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public Shape() {
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        int opcion;
        do {
            ShowMenu();
            opcion = answer;
            procesarOpcion(opcion);
        } while (opcion != 6);

    }

    public void ShowMenu() {

        System.out.println("Por favor seleccione alguna de las siguientes opciones:");
        System.out.println("1. diamante");
        System.out.println("2. cuadrado");
        System.out.println("3. rectangulo");
        System.out.println("4. circulo");
        System.out.println("5. corazon");
        System.out.println("6. Salir");
        System.out.println("Ingrese el numero de la operacion que desea");
        this.answer = this.scanner.nextInt();

    }

    public void procesarOpcion(int pOpcion) throws IOException {
        switch (pOpcion)
        {
            case 1:
                printDiamond();
                break;
            case 2:
                printSquare();
                break;
            case 3:
                printRectangle();
                break;
            case 4:
                printCircle();
                break;
            case 5:
                printHeart();
                break;
            case 6:
                System.out.println("Gracias");
                break;
            default:
                System.out.println("Opcion Invalida");
        }
    }

    public void printDiamond( ) throws IOException {


            System.out.println("Ingrese el alto, en términos de símbolos, de la figura rombo que desea imprimir. (El número debe ser par y natural)");
            lengthDesired = scanner.nextInt();

            //Creating a new line, just an visual printing.
            System.out.println();

            //Calculating number of rows that should be printed.
            int rowsToPrint = lengthDesired / 2 + 1;

            //For loop to print all the blanks required before printing the * on the next for loop.
            for (int actualRow = 1; actualRow <= rowsToPrint; actualRow++) {
                //Blank spaces to print
                for (int blank = 1; blank <= rowsToPrint - actualRow; blank++) {
                    System.out.print(" ");
                }
                //Printing all the * required.
                for (int symbol = 1; symbol <= (2 * actualRow) - 1; symbol++) {
                    System.out.print("*");
                }
                System.out.println("");
            }

            //Printing second half of the shape.
            rowsToPrint--;
            for (int actualRow = 1; actualRow <= rowsToPrint; actualRow++) {
                //For loop to print all the blanks required before printing the * on the next for loop.
                for (int blank = 1; blank <= actualRow; blank++) {
                    System.out.print(" ");
                }
                //Printing all the * required.
                for (int symbol = 1; symbol <= (rowsToPrint - actualRow) * 2 + 1; symbol++) {
                    System.out.print("*");
                }
                System.out.println();
            }
    }

    //funcion para imprimir el corazon
    public void
    printHeart(){

        System.out.println();

        // el tamano del ancho del corazon en cada uno de sus tops
        int size = 4;

        /**
         * PRIMERA parte del corazon
         * se introduce el tamano deseado por el usuario para el tope del corazon
         */
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y <= 4*size; y++)
            {
                /**
                 * utilizando la utileria de math, sqrt para redonder los numeros
                 * .pow para aplicar los calculos del tamano asignados a x para el primer tope del corazon
                 * "y" para el segundo tope del corazon
                 */
                double dist1 = Math.sqrt(Math.pow(x - size, 2) + Math.pow(y - size, 2));
                double dist2 = Math.sqrt(Math.pow(x - size, 2) + Math.pow(y - 3*size, 2));
                /**
                 * si la primer distancia (aplicada en el calculo anterior) es menor al tamano deseado
                 * ademas la distancia 2 tambien es menor al tamano deseado entonces imprimir el x
                 * sino que imprima un espacio(aqui se hace la montanita del corazon)
                 */
                if (dist1 < size + 0.5 || dist2 < size + 0.5) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        /**
         * SEGUNDA parte del corazon
         * Una vez que el tamano del corazon llega a su maximo empieza a imprimir espacios vacios con el y < x
         * ademas de ir completando el corazon el tamano el calculo de la x
         */
        for (int x = 1; x < 2*size; x++)
        {
            for (int y = 0; y < x; y++) {
                System.out.print(" ");
            }
            for (int y = 0; y < 4*size + 1 - 2*x; y++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }


    //funcion para imprimir el cuadrado
    public void printSquare(){
        //todo

        //tamano del cuadro
        System.out.println("El tamano del cuadro");
        lengthDesired = scanner.nextInt();

        //se le indica al ancho y largo que se impriman
        for(int i=1; i<=lengthDesired; i++){
            for(int j=1; j<=lengthDesired; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    //funcion para imprimir el rectangulo
    public void printRectangle(){
        //todo

        //largo y ancho del rectangulo
        int widthDesired, heighDesired;

        System.out.println("ancho");
        widthDesired = scanner.nextInt();
        System.out.println("alto");
        heighDesired = scanner.nextInt();


        for(int i=1; i<=widthDesired; i++){
            for(int j=1; j<=heighDesired; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    //imprimir el circulo
    public void printCircle(){

        //tamano deseado del circulo
        System.out.println("tamano del circulo");
        lengthDesired = scanner.nextInt();

        // distancia desde el centro
        double dist;

        // movimiento horizontal
        for (int i = 0; i <= 2 * lengthDesired; i++) {

            // movimiento vertical
            for (int j = 0; j <= 2 * lengthDesired; j++) {
                dist = Math.sqrt((i - lengthDesired) * (i - lengthDesired) +
                        (j - lengthDesired) * (j - lengthDesired));

                /**
                 * radio -0.5 y radio + 0.5 para imprimir una *
                 */
                if (dist > lengthDesired - 0.5 && dist < lengthDesired + 0.5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.print("\n");
        }
    }

}
