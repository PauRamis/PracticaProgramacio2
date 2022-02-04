import java.sql.Struct;

public class Polynomial {

    // Constructor per defecte. Genera un polinomi zero
    public Polynomial() {
    }

    // Constructor a partir dels coeficients del polinomi en forma d'array
    public Polynomial(float[] cfs) {
        String compilador = "";
        for (int i = 0; i < cfs.length; i++) {
            if (cfs[i] == 0) {
                compilador = "0";
            } else {
                if (cfs[i] == 1) compilador = ferX(i, cfs.length);
                else compilador = Math.round(cfs[i]) + ferX(i, cfs.length);
            }
            System.out.print(compilador);
            if (i != cfs.length - 1 && cfs[i] != 0) System.out.print(" + ");
        }
    }

    private String ferX(int i, int length) {
        //length = 3
        //position = 0-2
        String lletra = "X";

        //Si es l'ultim caracter, no té X
        if (i == length - 1){
            lletra = "";

            //Si l'exponent és 1, no es mostra.
        } else if (length - 1 -i == 1){
            lletra = "X";
        } else {
            lletra = "X"+ (length - 1 -i);
        }

        return lletra;
    }

    // Constructor a partir d'un string
    public Polynomial(String s) {
    }

    // Suma el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial add(Polynomial p) {
        return null;
    }

    // Multiplica el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial mult(Polynomial p2) {
        return null;
    }

    // Divideix el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    // Torna el quocient i també el residu (ambdós polinomis)
    public Polynomial[] div(Polynomial p2) {
        return null;
    }

    // Troba les arrels del polinomi, ordenades de menor a major
    public float[] roots() {
        return null;
    }

    // Torna "true" si els polinomis són iguals. Això és un override d'un mètode de la classe Object
    @Override
    public boolean equals(Object o) {
        return false;
    }

    // Torna la representació en forma de String del polinomi. Override d'un mètode de la classe Object
    @Override
    public String toString() {

        return "";
    }
}
