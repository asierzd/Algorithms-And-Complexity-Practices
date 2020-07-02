package P1;

public class Principal {
     public static int sumaPositivos1(int[] vector){ // O(n) worst case
        return sumaPositivos1Aux(vector,0,vector.length-1);
    }

    public static int sumaPositivos1Aux(int[] v, int i0, int iN){
         if (i0==iN){
             if (v[i0]>0) return v[i0]; else return 0;
         }else{
             int m=(i0+iN)/2;
             int iz=sumaPositivos1Aux(v,i0,m);
             int de=sumaPositivos1Aux(v,m+1,iN);
             return iz+de;
         }
    }

    public static int sumaPositivos2(int[] vector){ // O(logN) worst case
        int pos=buscarMaximo(vector,0,vector.length-1);
        int suma=0, max=vector[pos], i=pos;
        boolean fin=false;

        do {
            if (vector[i]>0){
                suma+=vector[i];
                i--;
            }else fin=true;

            if (i<0) i=vector.length-1;
            if (vector[i]<0) fin=true;

        }while (!fin && i!=pos);

        return suma;
    }

    public static int buscarMaximo(int[] v, int i0, int iN){

        if (i0==iN){
            return i0;
        }else if ((iN==i0+1)&&v[i0]>v[iN]){
            return i0;
        }else if ((iN==i0+1)&&v[i0]<v[iN]){
            return iN;
        }else{
            int k=(i0+iN)/2;
            if ( v[k]>v[k-1] && v[k]>v[k+1]){
                return k;
            }else if (v[i0]>v[k]){
                return buscarMaximo(v,i0,k-1);
            }else return buscarMaximo(v,k+1,iN);
        }

    }

}
