import java.util.Arrays;
import java.util.Scanner;

public class Ajedrez {
    public static void main(String[]args){

        System.out.println("Bienvenido al juego del Ajedrez.");
        System.out.println();
        String pieza=setPieza();
        String [] piezas={"Peon","Torre","Alfil","Caballo","Rey","Dama"};
        for(int i=0;i<piezas.length;i++){
            if(piezas[i].equalsIgnoreCase(pieza)){

            }
        }
        setColor();
    }
    private static Scanner sc=new Scanner(System.in);
    private static String color;
    private static boolean blancas=false;
    private static boolean negras=false;

    public static String setPieza(){

        System.out.println("En primer lugar, elige la pieza que deseas.");
        return sc.nextLine();
    }

    public static boolean setColor(){

        System.out.println("A continuación, elige el color de la pieza que quieras jugar. Blancas/Negras.");
        color=sc.nextLine();

        if(color.equalsIgnoreCase("Blancas")){
            return blancas=true;
        }
        else if(color.equalsIgnoreCase("Negras")){
            return negras=true;
        }
        return false;
    }

    public static String[][] getTablero(){
        String[][]tablero = {
                {"a8", "b8", "c8", "d8", "e8", "g8", "h8"},
                {"a8", "b8", "c8", "d8", "e8", "g8", "h8"},
                {"a8", "b8", "c8", "d8", "e8", "g8", "h8"},
                {"a8", "b8", "c8", "d8", "e8", "g8", "h8"},
                {"a8", "b8", "c8", "d8", "e8", "g8", "h8"},
                {"a8", "b8", "c8", "d8", "e8", "g8", "h8"},
                {"a8", "b8", "c8", "d8", "e8", "g8", "h8"},
                {"a8", "b8", "c8", "d8", "e8", "g8", "h8"}
        };

        return tablero;
    }

}
