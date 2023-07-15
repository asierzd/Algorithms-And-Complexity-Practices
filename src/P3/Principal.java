package P3;
import java.util.*;

public class Principal{
	
    // This method receives a set of candidates and a inventary.
    // It selects the best objects and inserts them into the inventary. Returns the solution.
    public static ArrayList<Objeto> llenarInventario(ArrayList<Objeto> candidatos, Inventario inventario){
        ArrayList<Objeto> solucion = new ArrayList<>();
        Objeto candidatoActual;

        while (!candidatos.isEmpty()){
            candidatoActual = seleccionarCandidato(candidatos);
            candidatos.remove(candidatoActual);
            if (esCandidatoFactible(candidatoActual, inventario))
                solucion.add(candidatoActual);
        }

        return solucion;
    }

    // This method selects the most valued object.
    private static Objeto seleccionarCandidato(ArrayList<Objeto> candidatos) {
		Objeto mejor = null;
		for(Objeto objeto:candidatos)
			if((mejor==null) || (mejor.getValor() < objeto.getValor()) || 
              ((mejor.getValor() == objeto.getValor()) && (mejor.getAlto() * mejor.getAncho() > objeto.getAncho() * objeto.getAlto())) 
              ){
				mejor = objeto;
			}
		return mejor;
	}

    // This method selects a feasible candidate for insertion, if so, it is inserted, and returns it.
    private static boolean esCandidatoFactible(Objeto candidato, Inventario inventario){
		boolean feasible = false;

		for(int j = 0; j < inventario.getN() && !feasible; j++){
			for (int i = 0; i < inventario.getN() && !feasible; i++){
				if(inventario.getCelda(i,j) == (-1) && (candidato.getAncho()+i <= inventario.getN() && candidato.getAlto()+j <= inventario.getN())){
					feasible = esCandidatoAux(candidato, inventario, j, i, 1);
					if(feasible){
						for (int q = j; q < j + candidato.getAlto(); q++){
							for (int w = i; w < i + candidato.getAncho(); w++){
								inventario.setCelda(w, q, candidato.getId());
							}
						}
					}
				}
			}
		}
		return feasible;
	}

	private static boolean esCandidatoAux(Objeto candidato, Inventario inventario,int fila,int columna, int contF){
		int contC = 0;
		boolean feasible = false;
		for (int i = columna; i < columna + candidato.getAncho(); i++){
			if (inventario.getCelda(i, fila) == (-1)) {
				contC++;
				if (contC == candidato.getAncho()){
					if (candidato.getAlto() == contF){
						feasible = true;
					}else{
                        contF++; 
                        feasible = esCandidatoAux(candidato, inventario, fila + 1, columna, contF);
                    }
				}
			}
		}
		return feasible;
	}


}
