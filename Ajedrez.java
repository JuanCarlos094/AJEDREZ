import java.util.Scanner;
public class Ajedrez {
    public static void main(String[]args){
        String pieza = setPieza();
        compararPiezas(pieza);


    }

    public static String setPieza(){
        String p;
        Scanner sc = new Scanner(System.in);
        System.out.print("Elige una pieza a poner en el tablero: ");
        return p = sc.next();
    }

    public static void compararPiezas(String pieza){
        String[] allpieces = {"peon", "caballo", "alfil", "torre", "reina", "rey"};

        if (pieza.equalsIgnoreCase(allpieces[0])){
                //Aqui se llamaria al metodo que corresponde a la pieza con la que coincide
        }else if (pieza.equalsIgnoreCase(allpieces[1])){
            //Aqui se llamaria al metodo que corresponde a la pieza con la que coincide
        }else if (pieza.equalsIgnoreCase(allpieces[2])){
            //Aqui se llamaria al metodo que corresponde a la pieza con la que coincide
        }else if (pieza.equalsIgnoreCase(allpieces[3])){
            //Aqui se llamaria al metodo que corresponde a la pieza con la que coincide
        }else if (pieza.equalsIgnoreCase(allpieces[4])){
            //Aqui se llamaria al metodo que corresponde a la pieza con la que coincide
        }else if (pieza.equalsIgnoreCase(allpieces[5])){
            //Aqui se llamaria al metodo que corresponde a la pieza con la que coincide
        }else{
            System.out.println("Pieza no valida");
        }


    }




}
