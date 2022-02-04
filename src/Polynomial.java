import java.sql.Struct;

public class Polynomial {
    float[] coef;

    // Constructor per defecte. Genera un polinomi zero
    public Polynomial() {
    }

    // Constructor a partir dels coeficients del polinomi en forma d'array
    public Polynomial(float[] cfs) {
        this.coef = cfs;
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
        String compilador = "";
        String polinomi = "";
        if (coef.length == 1 && coef[0] == 0){
            polinomi = "0";
        }
        else for (int i = 0; i < coef.length; i++) {

            //Si el numero és 0, no és posa res
            if (coef[i] == 0) {
                compilador = "";
            }
            //Si el numero és 1, només es posa la X
            else if (coef[i] == 1) {
                 compilador = ferX(i, coef.length);
            }
            //Els altres casos, és posa el numero més la X
            else compilador = Math.round(coef[i]) + ferX(i, coef.length);

            //Si el numero és 0 o no n'hi ha més després, no es posa "+"
            if (i != coef.length - 1 && coef[i] != 0) compilador = compilador +" + ";

            polinomi = polinomi + compilador;
        }
        return polinomi;
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
            lletra = "x";
        } else {
            lletra = "x"+ (length - 1 -i);
        }

        return lletra;
    }
}
