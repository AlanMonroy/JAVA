import java.util.Scanner;

class ejemplo1{
    public static void main(String[] args) {

        /*final int constante= 40; //CONSTANTE
        byte edad = 35;  //de -128 a 127
        double flotante = 2.32131;

        System.out.println(edad);
        System.out.println(constante);
        System.out.println("Numero flotante: " + flotante);

        double raiz = Math.sqrt(flotante);*/

        double num1= 5.85f;
        int resultado = (int)Math.round(num1); //refundicion

        System.out.println(resultado);

        double base = 5;
        double exponente = 3;

        int exponencial = (int)Math.pow(base, exponente); //exponenecial

        System.out.println(exponencial);

        Scanner objectScan =  new Scanner(System.in); //instanciar una clase Scanner
        System.out.println("Introduce tu nombre, por favor.");
        String nombreUsuario = objectScan.nextLine();
        System.out.println("Introduce edad, por favor");
        int edadUsuario = objectScan.nextInt();

        System.out.println("Hola " + nombreUsuario + " . El proximo anio trendas " + (edadUsuario+1) + " anios.");
    } 
}