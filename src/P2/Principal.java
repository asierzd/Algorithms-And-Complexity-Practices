package P2;

public class Principal {

    public static int numMinMutaciones(String cadena1, String cadena2) {
        return numMinMutacionesAux(cadena1, cadena2, 0, Integer.MAX_VALUE);
    }

    private static int numMinMutacionesAux(String cadenaOrgn, String cadenaObj, int act, int best) {
    
        // Solution if it has to pathed both strings
        if (cadenaObj.length() == 0 && cadenaOrgn.length() == 0) 
            best = Math.min(best, act);
        else // If a string has finished path save solution
            if (cadenaObj.length() == 0 || cadenaOrgn.length() == 0) 
                best = Math.min(best, act + Math.abs(cadenaOrgn.length() - cadenaObj.length()));  
            else // If both strings have length >=1
                if (act < best) { // Bound 
                    // Start checking first char of substrings
                    if (cadenaOrgn.charAt(0) == cadenaObj.charAt(0))
                        // If they are equal, note and delete the first char, save solution
                        best = Math.min(numMinMutacionesAux(cadenaOrgn.substring(1), cadenaObj.substring(1), act, best), best);
                    else { // If first chars are not equal
                        if (cadenaOrgn.length() == 1)
                            best = Math.min(numMinMutacionesAux(cadenaObj.substring(0, 1), cadenaObj, act + 1, best), best );
                        else // Change char and save solution
                            best = Math.min(numMinMutacionesAux(cadenaObj.charAt(0) + cadenaOrgn.substring(1), cadenaObj, act + 1, best), best);
                        // Insert char and save solution
                        best = Math.min(numMinMutacionesAux(cadenaObj.charAt(0) + cadenaOrgn, cadenaObj, act + 1, best), best);
                        // Delete char and save solution
                        best = Math.min(numMinMutacionesAux(cadenaOrgn.substring(1), cadenaObj, act + 1, best), best);
                    }
                }
        return best;
    }


}
