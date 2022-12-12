import java.util.Scanner;

public class Ajedrez {
    public static void main(String[]args){

        System.out.println("Bienvenido al juego del Ajedrez.");
        setPieza();
        setColor();
    }
    private static String[][] tablero=new String[8][8];
    private static Scanner sc=new Scanner(System.in);
    private static String color;
    private static boolean blancas=false;
    private static boolean negras=false;

    public static String setPieza(){

        System.out.println("En primer lugar, elige la pieza que deseas.");
        return sc.nextLine();
    }

    public static boolean setColor(){

        System.out.println("En primer lugar, elige el color de la pieza que quieras jugar. Blancas/Negras.");
        color=sc.nextLine();

        if(color.equalsIgnoreCase("Blancas")){
            return blancas=true;
        }
        else if(color.equalsIgnoreCase("Negras")){
            return negras=true;
        }
        return false;
    }

}
