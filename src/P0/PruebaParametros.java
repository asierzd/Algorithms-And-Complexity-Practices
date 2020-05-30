package P0;

public class PruebaParametros {

    public PruebaParametros(){

        int primitivoInt = 4;
        Entero objetoEntero = new Entero(4);

        System.out.println("--------------------------------------------");
        System.out.println("Prueba de enteros por valor y por referencia");
        System.out.println("--------------------------------------------");
        System.out.println("   Antes de llamar al método:");
        System.out.println("        primitivo int: " + primitivoInt + ". objetoEntero: " + objetoEntero.getValor());

        enteros(primitivoInt, objetoEntero);
        System.out.println("   Despues de llamar al método:");
        System.out.println("        primitivo int: " + primitivoInt + ". objetoEntero: " + objetoEntero.getValor());


        int[] arrayInt = {1,2,3,4};

        System.out.println("---------------------------");
        System.out.println("Prueba de arrays de enteros");
        System.out.println("---------------------------");
        System.out.println("   Antes de llamar al método:");
        System.out.print("        array int: ");
        imprimeArray(arrayInt);

        vector(arrayInt);
        System.out.println("   Despues de llamar al método:");
        System.out.print("        array int: ");
        imprimeArray(arrayInt);
    }


    private void enteros(int primitivoInt, Entero objetoEntero)
    {
        // Este bloque prueba que los tipos primitivos se pasan por valor, y las modificaciones dentro del método no tienen
        // efecto al salir del mismo. Tambien prueba que las modificaciones de las propiedades de un objeto dentro de un método
        // sí que persisten al terminar el mismo. Ahora bien, si lo que se modifica es el objeto en sí, esto no persiste (dado
        // que los parámetros en sí son todos por valor en Java)
        System.out.println("   Dentro del método");
        primitivoInt = primitivoInt +1;
        objetoEntero.setValor(objetoEntero.getValor() + 1);
        System.out.println("        primitivo int: " + primitivoInt + ". objetoEntero: " + objetoEntero.getValor());

        //El siguiente bloque demuestra que el Objeto Entero, en si, se pasa por valor, ya que al modificarlo (no el contenido
        //, sino el propio objeto), no tiene efecto al salir del método
        objetoEntero = new Entero(22);
        System.out.println("        objetoEntero (modificado dentro del método): " + objetoEntero.getValor());

    }



    private void vector(int[] arrayInt)
    {
        //Este primer bloque prueba que el contenido del array, si se modifica en el método, permanece modificado al salir del mismo
        System.out.println("   Dentro del método");
        for (int i=0; i<arrayInt.length; i++) {
            arrayInt[i] = arrayInt[i] + 1;
        }
        System.out.print("        array int: ");
        imprimeArray(arrayInt);

        //El siguiente bloque demuestra que el array, en si, se pasa por valor, ya que al modificar la variable arrayInt (no el contenido
        // de sus posiciones), no tiene efecto al salir del método
        int[] array2Int = new int[4];
        array2Int[0]=8;
        array2Int[1]=9;
        array2Int[2]=10;
        array2Int[3]=11;
        arrayInt=array2Int;
        System.out.print("        array int despues de asignarle array2Int: ");
        imprimeArray(arrayInt);

    }

    private void imprimeArray(int[] array){
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        new PruebaParametros();
    }

}
