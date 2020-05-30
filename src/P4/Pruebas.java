package P4;

public class Pruebas {
    private static String[] nums = {"13456754321","121","1234531", "93080298359740385912", "20", "243689624371649643117776", "1782", "57", "32062308550805015446", "98367962949352308226", "5", "6923241844", "73", "41860629334175935408658681", "5183349881968261379", "20102", "988218260679", "", "33084403482789926668435", "15415893665760235", "7443524", "2320","330333", "111011","1011","987654325512345678","20005","2000500"};
    private static int[] pos={2,1, 2, 13, 2, 3, 2, 2, 0, 0, 0, 9, 0, 6, 0, 0, 0, 0, 5, 16, 0,0,0,2,4,17,1,4};
    private static int[] resul={6,0, 4, 15, 1, 22, 3, 1, 13, 14, 0, 8, 1, 21, 14, 0, 8, 0, 19, 15, 5, 3,1,1,2,12,3,4};

    private static void probarTest(){
        boolean exito=true;
        for (int i=0;i<nums.length;i++) {
            int l=Principal.minCambios(nums[i],pos[i]);
            if (l!=resul[i]) {
                System.out.println("NO FUNCIONA TU ALGORITMO EN ESTE CASO");
                System.out.println ("número: " + nums[i]+ "; posición:" + pos[i]);
                System.out.println("Número mínimo de pulsaciones de teclas es " + resul[i] + ". Tu algoritmo devuelve " + l);
                System.out.println();
                exito=false;
            }
        }
        if (exito)
            System.out.println("HAN TENIDO ÉXITO TODOS LOS TESTS. DISEÑA NUEVOS TESTS Y ASEGURATE QUE FUNCIONA TU ALGORITMO CORRECTAMENTE");
    }


    public static void main(String[] args){
        System.out.println("TESTS");
        probarTest();
    }

}