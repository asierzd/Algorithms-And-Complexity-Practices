package P1;

public class Principal {
     public static int sumaPositivos1(int[] vector){ // O(n) worst case
        return sumaPositivosAux(vector,0,vector.length-1);
    }

    public static int sumaPositivosAux(int[] v, int i0, int iN){
         if (i0==iN){
             if (v[i0]>0) return v[i0]; else return 0;
         }else{
             int m=(i0+iN)/2;
             int iz=sumaPositivosAux(v,i0,m);
             int de=sumaPositivosAux(v,m+1,iN);
             return iz+de;
         }
    }

    public static int sumaPositivos2(int[] vector){
        return -1;
    }

}
