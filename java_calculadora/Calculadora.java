import java.util.Scanner;

public class Calculadora{
public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    boolean continuar = true;

    while (continuar) {
        System.out.println("Calculadora Avanzada");
        System.out.println("Elija una operación: ");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Módulo");
        System.out.println("6. Potencia");
        System.out.println("7. Raíz cuadrada");
        System.out.println("8. Logaritmo natural");
        System.out.println("9. Logaritmo base 10");
        System.out.println("10. Valor absoluto");
        System.out.println("11. Seno");
        System.out.println("12. Salir");

        int operacion = scanner.nextInt();

        if (operacion == 12) {
            continuar = false;
            System.out.println("Saliendo...");
            break;
        }

        double num1 = 0, num2 = 0;
        if (operacion >= 1 && operacion <= 6) {
            System.out.print("Ingrese el primer número: ");
            num1 = scanner.nextDouble();
            
            System.out.print("Ingrese el segundo número: ");
            num2 = scanner.nextDouble();
        } else if (operacion >= 7 && operacion <= 11) {
            System.out.print("Ingrese un número: ");
            num1 = scanner.nextDouble();
        }

        double resultado = 0;

        switch (operacion) {
            case 1: 
                resultado = num1 + num2;
                System.out.println("Resultado: " + num1 + " + " + num2 + " = " + resultado);
                break;
            case 2: 
                resultado = num1 - num2;
                System.out.println("Resultado: " + num1 + " - " + num2 + " = " + resultado);
                break;
            case 3: 
                resultado = num1 * num2;
                System.out.println("Resultado: " + num1 + " * " + num2 + " = " + resultado);
                break;
            case 4:
                if (num2 != 0) { 
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + num1 + " / " + num2 + " = " + resultado);
                } else {
                    System.out.println("Error: División por cero no permitida.");
                }
                break;
            case 5: 
                resultado = num1 % num2;
                System.out.println("Resultado: " + num1 + " % " + num2 + " = " + resultado);
                break;
            case 6:
                resultado = Math.pow(num1, num2);
                System.out.println("Resultado: " + num1 + " ^ " + num2 + " = " + resultado);
                break;
            case 7: 
                if (num1 >= 0) {
                    resultado = Math.sqrt(num1);
                    System.out.println("Resultado: √" + num1 + " = " + resultado);
                } else {
                    System.out.println("Error: La raíz cuadrada de un número negativo no es un número real.");
                }
                break;
            case 8:
                if (num1 > 0) {
                    resultado = Math.log(num1);
                    System.out.println("Resultado: ln(" + num1 + ") = " + resultado);
                } else {
                    System.out.println("Error: Logaritmo natural solo está definido para números positivos.");
                }
                break;
            case 9:
                if (num1 > 0) {
                    resultado = Math.log10(num1);
                    System.out.println("Resultado: log10(" + num1 + ") = " + resultado);
                } else {
                    System.out.println("Error: Logaritmo base 10 solo está definido para números positivos.");
                }
                break;
            case 10: 
                resultado = Math.abs(num1);
                System.out.println("Resultado: |" + num1 + "| = " + resultado);
                break;
            case 11:
                resultado = Math.sin(Math.toRadians(num1));
                System.out.println("Resultado: sin(" + num1 + ") = " + resultado);
                break;
            default:
                System.out.println("Operación no válida.");
                break;
        }
    }

    scanner.close();
}
}