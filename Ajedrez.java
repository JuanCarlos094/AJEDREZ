import java.util.Arrays;
import java.util.Scanner;

public class Ajedrez {
    public static void main(String[]args){

        System.out.println("-------------------------------------");
        System.out.println("Bienvenido al juego del Ajedrez.");
        System.out.println("-------------------------------------");

        String pieza = setPieza();
        setColor();
        compararPiezas(pieza);

    }
    
    private static Scanner sc=new Scanner(System.in);
    private static boolean blancas=false;
    private static boolean negras=false;


    //metodo validar pieza
    public static void compararPiezas(String pieza){
        String[] allpieces = {"peon", "caballo", "alfil", "torre", "reina", "rey"};
        
        String pos;

        if (pieza.equalsIgnoreCase(allpieces[0])){
            pos = setPosicion();
            if(checkPosicion(pos) == true){
                peon(pos);
            }
        }else if (pieza.equalsIgnoreCase(allpieces[1])){
            
            //Aqui se llamaria al metodo que corresponde a la pieza con la que coincide
        
        }else if (pieza.equalsIgnoreCase(allpieces[2])){
            pos = setPosicion();
            if(checkPosicion(pos) == true){
                alf_down_left(pos);
                alf_down_right(pos);
                alf_up_left(pos);
                alf_up_right(pos);
            }
        
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
    
   
    //metodo introduccion pieza
    public static String setPieza(){

        System.out.print("En primer lugar, elige la pieza que deseas: ");
        return sc.nextLine();
    }


    //metodo mostrar tablero
    public static String[][] getTablero(){

        return new String[][]{
                {"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
                {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
                {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"},
                {"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"},
                {"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"},
                {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"},
                {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"},
                {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"},
        };
    }


    public static boolean setColor(){
        System.out.println("¿De qué color es tu pieza? Blanca/Negra.");
        String color =sc.next();
        if(color.equalsIgnoreCase("Blanca")){
            return blancas=true;
        }
        else if(color.equalsIgnoreCase("Negra")){
            return negras=true;
        }
        else{
            System.out.println("No has elegido un color válido.");
        }
        return false;
    }


    //metodo para establecer posicion inicial en el tablero
    public static String setPosicion(){
        System.out.println("-------------------------------------");
        String[][] tablero=getTablero();
        for(String[] ints : tablero){
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("\n¿En qué posición se encuentra tu pieza?");
        
        return sc.next();
    }

    public static boolean checkPosicion(String pos){
        
        String[][] tablero = getTablero();

        for (int i = 0; i<tablero.length; i++){
            for(int j = 0; j<tablero.length; j++){
                if(pos.equalsIgnoreCase(tablero[i][j])){
                    return true;
                }
            }
        }
        return false;
    }

    
    //metodo movimientos peon
    public static void peon(String posicion){
        if(blancas){

            if(posicion.matches("a1|b1|c1|d1|e1|f1|g1|h1")){
                System.out.println("Un peón blanco no puede estar en la primera fila del tablero.");
            }
            else if(posicion.matches("a2|b2|c2|d2|e2|f2|g2|h2")){
                int movPeon = Integer.parseInt(posicion.charAt(1)+"")+1;
                int movPeon1 = Integer.parseInt(posicion.charAt(1)+"")+2;
                System.out.println("Tu peón se podrá mover a: " + posicion.charAt(0) + "" + movPeon + " o " + posicion.charAt(0) + movPeon1 + " al ser el primer movimiento.");
            }
            else if(posicion.matches("a8|b8|c8|d8|e8|f8|g8|h8")){
                System.out.println("El peon al estar en la última fila del tablero se convierte en una dama.");
            }
            else{
                int movPeon = Integer.parseInt(posicion.charAt(1)+"")+1;
                if(movPeon==8){
                    System.out.println("Tu peón se podrá mover a: " + posicion.charAt(0) + "" + movPeon);
                    System.out.println("Tu peón ha alcanzado la última fila del tablero, por lo que se convierte en dama.");
                }
                else {
                    System.out.println("Tu peón se podrá mover a: " + posicion.charAt(0) + "" + movPeon);
                }
            }

        }
        else if (negras){
            if(posicion.matches("a1|b1|c1|d1|e1|f1|g1|h1")){
                System.out.println("El peon al estar en la primera fila del tablero se convierte en una dama.");
            }
            else if(posicion.matches("a7|b7|c7|d7|e7|f7|g7|h7")){
                int movPeon = Integer.parseInt(posicion.charAt(1)+"")-1;
                int movPeon1 = Integer.parseInt(posicion.charAt(1)+"")-2;
                System.out.println("Tu peón se podrá mover a: " + posicion.charAt(0) + "" + movPeon + ", o: " + posicion.charAt(0) + movPeon1 + " al ser el primer movimiento.");
            }
            else if(posicion.matches("a8|b8|c8|d8|e8|f8|g8|h8")){
                System.out.println("Un peón negro no puede estar en la última fila del tablero.");
            }
            else{
                int movPeon = Integer.parseInt(posicion.charAt(1)+"")-1;
                if(movPeon==1){
                    System.out.println("Tu peón se podrá mover a: " + posicion.charAt(0) + "" + movPeon);
                    System.out.println("Tu peón ha alcanzado la primera fila del tablero, por lo que se convierte en dama.");
                }
                else {
                    System.out.println("Tu peón se podrá mover a: " + posicion.charAt(0) + "" + movPeon);
                }
            }
        }
    }



    //metodos para movimientos del alfil segun direccion/sentido diagional
    public static void alf_down_left (String alf){
        char ch1 = alf.charAt(0);
        char ch2 = alf.charAt(1);
        ch1--;

        System.out.print("Movimientos diagonal inferior (izq.) --> ");
        for (;ch1>96; ch1--){
            --ch2;
            if (ch2 == 48){
                 break;
            }
            String str = "" + ch1 + ch2;
            System.out.print(str + " ");
        }

        System.out.println("\n");

    }

    public static void alf_down_right (String alf){
        char ch1 = alf.charAt(0);
        char ch2 = alf.charAt(1);
        ch1++;

        System.out.print("Movimientos diagonal inferior (der.) --> ");
        for (;ch1<105; ch1++){
            --ch2;
            if (ch2 == 48){
                break;
            }
            String str = "" + ch1 + ch2;
            System.out.print(str + " ");
        }

        System.out.println("\n");
    }


    public static void alf_up_right (String alf){
        char ch1 = alf.charAt(0);
        char ch2 = alf.charAt(1);
        ch1++;

        System.out.print("Movimientos diagonal superior (der.) --> ");
        for (;ch1<105; ch1++){
            ++ch2;
            if (ch2 == 57){
                break;
            }
            String str = "" + ch1 + ch2;
            System.out.print(str + " ");
        }

        System.out.println("\n");
    }


    public static void alf_up_left (String alf){
        char ch1 = alf.charAt(0);
        char ch2 = alf.charAt(1);
        ch1--;
        
        System.out.print("Movimientos diagonal superior (izq.) --> ");
        for(; ch1>96; ch1--){
            ++ch2;
            if(ch2 == 57){
                break;
            }
            String str = "" + ch1 + ch2;
            System.out.print(str + " ");
        }

        System.out.println("\n");
    }

}
