public class MainProbes {
    public static void main(String[] args) {
        /*
        float cfs[] = new float[]{-6, 0, 0, 20, -8};

        String compilador = "";
        for (int i = 0; i < cfs.length; i++) {
            if (cfs[i] == 0) {
                compilador = "";
            } else {
                if (cfs[i] == 1) compilador = ferX(i, cfs.length);
                else compilador = Math.round(cfs[i]) + ferX(i, cfs.length);
            }
            System.out.print(compilador);
            if (i != cfs.length - 1 && cfs[i] != 0) System.out.print(" + ");
        }*/
        int[] arPolinomi = new int[3+1];
        System.out.println(arPolinomi[1]);
        ferX(2,2);

    }

    private static String ferX(int i, int length) {
        //length = 3
        //position = 0-2
        String lletra = "X";

        //Si es l'ultim caracter, no té X
        if (i == length - 1) {
            lletra = "";

            //Si l'exponent és 1, no es mostra.
        } else if (length - 1 - i == 1) {
            lletra = "X";


            //L'exponent és igual a la longitut menys la seva posició, menys 1
        } else {
            lletra = "X" + (length - 1 - i);
        }

        return lletra;
    }
}

