import java.util.*;

public class Ajedrez {
    public static void main(String[]args){

        System.out.println("|♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙|");
        System.out.println("|♖♘♗♕♔  Bienvenido al juego del Ajedrez   ♚♛♝♞♜|");
        System.out.println("|♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙♙|");

        setColor();
        int pieza = setPieza();
        compararPiezas(pieza);
        sc.close();
    }

    private static Scanner sc=new Scanner(System.in);
    private static boolean blancas=false;
    private static boolean negras=false;
    /*
    Metodo para elegir color. Hemos utilizado un método que nos devuelva dos variables de tipo booleano, que dependiendo
    si introducimos "Blanco" o "Negro", nos devolverá la variable de cada color con valor true. También hemos controlado
    los errores, por lo que si introduces algo diferente de "Blanco","B","N","Negro" (independientemente de si lo pone-
    mos en mayúsculas o en minúsculas) te saldrá un mensaje de color no válido y te volvera a pedir que introduzcas un
    color.
     */
    public static boolean setColor(){
        String color;
        boolean trying_color;

        do{
            System.out.println("\n¿De qué color es tu pieza? Blanca/Negra.");
            Scanner color_scan = new Scanner(System.in);
            color = color_scan.next();

            if(color.equalsIgnoreCase("Blanca")||color.equalsIgnoreCase("B")){
                return blancas=true;
            }
            else if(color.equalsIgnoreCase("Negra")||color.equalsIgnoreCase("N")){
                return negras=true;
            }
            else{
                System.out.println("No has elegido un color válido!!\n");
                trying_color = false;
            }
        }while (!trying_color);

        return false;
    }
    /*
    Metodo para introducir la pieza deseada.
     */
    public static int setPieza(){
        Scanner pieza_scan = new Scanner(System.in);
        boolean trying;
        String pieza = null;

        do {
            trying = true;
                System.out.println("Elige la pieza que deseas: ");
                System.out.println("1. ♙ Peón");
                System.out.println("2. ♘ Caballo");
                System.out.println("3. ♗ Alfil");
                System.out.println("4. ♖ Torre");
                System.out.println("5. ♕ Dama");
                System.out.println("6. ♔ Rey");
                System.out.print("-->");
            try{
                pieza = pieza_scan.nextLine();
                if(!pieza.matches("1|2|3|4|5|6")){
                    throw new Exception("Has introducido un valor no válido, vuelve a intentarlo.\n");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                trying = false;
            }
        }while(!trying);

        return Integer.parseInt(pieza);
    }

    //metodo validar pieza
    public static void compararPiezas(int pieza){
        String pos;
        boolean error;

        if (pieza == 1)/*Peon*/{
            pos = setPosicion();
            while (!checkPosicion(pos)){
                pos=setPosicion();
                checkPosicion(pos);
            }
            peon(pos);
        }else if (pieza == 2 )/*Caballo*/{
            pos = setPosicion();
            while(!checkPosicion(pos)){
                pos=setPosicion();
                checkPosicion(pos);
            }
            caballo(pos);
        }else if (pieza == 3)/*Alfil*/{
            pos = setPosicion();
            while(!checkPosicion(pos)){
                pos=setPosicion();
                checkPosicion(pos);
            }
            alf_down_left(pos);
            alf_down_right(pos);
            alf_up_left(pos);
            alf_up_right(pos);
        }else if (pieza == 4)/*Torre*/{
            pos = setPosicion();
            while (!checkPosicion(pos)){
                pos=setPosicion();
                checkPosicion(pos);
            }
            torre(pos);
        }else if (pieza == 5)/*Dama*/{
            pos = setPosicion();
            while (!checkPosicion(pos)){
                pos=setPosicion();
                checkPosicion(pos);
            }
            dama(pos);
        }else if (pieza == 6)/*Rey*/{
            pos = setPosicion();
            while (!checkPosicion(pos)){
                pos=setPosicion();
                checkPosicion(pos);
            }
            rey(pos);
        }else{
            System.out.println("Pieza no valida");
        }
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

    //metodo para establecer posicion inicial en el tablero
    public static String setPosicion(){
        System.out.println("-------------------------------------");
        String[][] tablero=getTablero();
        for(String[] ints : tablero){
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("\n¿En qué posición se encuentra tu pieza?");

        return sc.next().toLowerCase(Locale.ROOT);
    }

    //metodo para validar la posicion dada
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
                System.out.println("El peon al estar en la última fila del tablero se convierte en otra pieza.");
            }
            else{
                int movPeon = Integer.parseInt(posicion.charAt(1)+"")+1;
                if(movPeon==8){
                    System.out.println("Tu peón se podrá mover a: " + posicion.charAt(0) + "" + movPeon);
                    System.out.println("Tu peón ha alcanzado la última fila del tablero, por lo que se convierte en otra pieza.");
                }
                else {
                    System.out.println("Tu peón se podrá mover a: " + posicion.charAt(0) + "" + movPeon);
                }
            }

        }
        else if (negras){
            if(posicion.matches("a1|b1|c1|d1|e1|f1|g1|h1")){
                System.out.println("El peon al estar en la primera fila del tablero se convierte en otra pieza.");
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
                    System.out.println("Tu peón ha alcanzado la primera fila del tablero, por lo que se convierte en otra pieza.");
                }
                else {
                    System.out.println("Tu peón se podrá mover a: " + posicion.charAt(0) + "" + movPeon);
                }
            }
        }
    }

    //metodo para los movimientos del caballo
    public static void caballo(String posicion) {
        String column = String.valueOf(posicion.charAt(0));
        String row = String.valueOf(posicion.charAt(1));

        int y = column.charAt(0) - 'a';
        int x = Integer.parseInt(row) - 1;

        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        List<String> positions = new ArrayList<>();

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                column = (char) ('a' + newY) + "";
                row =(newX + 1) + "";
                String position = column + row;
                positions.add(position);
            }
        }
        System.out.println("Posiciones posibles del caballo desde la posición " + posicion.charAt(0) + posicion.charAt(1) + ":");
        for (String position : positions) {
            System.out.println(position);
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

    public static void torre(String torre){
        String[][] tablero = getTablero();

        for (int i = 0; i<tablero.length; i++){
            for (int j = 0; j< tablero.length; j++){
                if (torre.equalsIgnoreCase(tablero[i][j])){
                    System.out.print("Movimientos hacia arriba --> ");
                    for (int i3 = i; i3>=0; ){
                        --i3;
                        try{
                            System.out.print(tablero[i3][j] + " ");
                        }catch (ArrayIndexOutOfBoundsException e){
                            System.out.print("");
                        }
                    }
                    System.out.println("\n");

                    System.out.print("Movimientos hacia abajo --> ");
                    for (int i2 = i; i2<tablero.length;){
                        i2++;
                        try{
                            System.out.print(tablero[i2][j] + " ");
                        }catch (ArrayIndexOutOfBoundsException e){
                            System.out.print("");
                        }
                    }
                    System.out.println("\n");

                    System.out.print("Movimientos hacia izquierda --> ");
                    for (int j2 = j; j2>=0;){
                        --j2;
                        try{
                            System.out.print(tablero[i][j2] + " ");
                        }catch (ArrayIndexOutOfBoundsException e){
                            System.out.print("");
                        }
                    }
                    System.out.println("\n");


                    System.out.print("Movimientos hacia derecha --> ");
                    for (int j3 = j; j3<tablero.length;){
                        ++j3;
                        try{
                            System.out.print(tablero[i][j3] + " ");
                        }catch (ArrayIndexOutOfBoundsException e){
                            System.out.print("");
                        }
                    }
                    System.out.println("\n");
                }
            }
        }
    }

    public static void rey(String posicion) {
        char ch1 = posicion.charAt(0);
        char ch2 = posicion.charAt(1);

        System.out.println("El Rey podrá realizar los siguientes movimientos: ");
        //Up left
        System.out.print("Movimientos diagonal superior (izq.) --> ");
        if(ch1>97 && ch2<56){
            System.out.print(""+(char)(ch1-1)+(char)(ch2+1));
        }
        System.out.println("\n");
        //Go forward
        System.out.print("Movimientos hacia arriba --> ");
        if(ch2<56){
            System.out.print(""+ch1+(char)(ch2+1));
        }
        System.out.println("\n");
        //Up right
        System.out.print("Movimientos diagonal superior (der.) --> ");
        if(ch1<104 && ch2<56){
            System.out.print(""+(char)(ch1+1)+(char)(ch2+1));
        }
        System.out.println("\n");
        //Left
        System.out.print("Movimiento hacia izquierda --> ");
        if(ch1>97){
            System.out.print(""+(char)(ch1-1)+ch2);
        }
        System.out.println("\n");
        //Right
        System.out.print("Movimiento hacia derecha --> ");
        if(ch1<104){
            System.out.print(""+(char)(ch1+1)+ch2);
        }
        System.out.println("\n");
        //Back left
        System.out.print("Movimientos diagonal inferior (izq.) --> ");
        if(ch1>97 && ch2>49){
            System.out.print(""+(char)(ch1-1)+(char)(ch2-1));
        }
        System.out.println("\n");
        //Back
        System.out.print("Movimientos hacia abajo --> ");
        if(ch2>49){
            System.out.print(""+ch1+(char)(ch2-1));
        }
        System.out.println("\n");
        //Back right
        System.out.print("Movimientos diagonal inferior (der.) --> ");
        if(ch1<104 && ch2>49){
            System.out.print(""+(char)(ch1+1)+(char)(ch2-1));
        }
        System.out.println("\n");
    }

    public static void dama(String posicion){
        char ch1 = posicion.charAt(0);
        char ch2 = posicion.charAt(1);
        int i;

        //Up left
        alf_up_left(posicion);
        //Go forward
        System.out.print("Movimientos hacia arriba --> ");
        for(i=ch2+1;i<57;i++){
            System.out.print(""+ch1+(char)i+" ");
        }
        System.out.println("\n");
        //Up right
        alf_up_right(posicion);
        //Left
        System.out.print("Movimiento hacia izquierda --> ");
        for(i=ch1-1;i>96;i--){
            System.out.print(""+(char)i+ch2+" ");
        }
        System.out.println("\n");
        //Right
        System.out.print("Movimiento hacia derecha --> ");
        for(i=ch1+1;i<105;i++){
            System.out.print(""+(char)i+ch2+" ");
        }
        System.out.println("\n");
        //Back left
        alf_down_left(posicion);
        //Back
        System.out.print("Movimientos hacia abajo --> ");
        for(i=ch2-1;i>48;i--){
            System.out.print(""+ch1+(char)i+" ");
        }
        System.out.println("\n");
        //Back right
        alf_down_right(posicion);
    }
}