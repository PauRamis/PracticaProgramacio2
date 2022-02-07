import java.sql.Struct;
import java.util.Objects;

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
        Polynomial p = (Polynomial) o;
        return this.toString().equals(p.toString());
    }

    // Torna la representació en forma de String del polinomi. Override d'un mètode de la classe Object
    @Override
    public String toString() {
        //Si l'array es nul, retornará "0"
        if (coef == null) return "0";

        String compilador = "";
        String polinomi = "";

         for (int i = 0; i < coef.length; i++) {

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



            //Si el numero és 0 o és el primer no es posa signe
            if (coef[i] != 0 && coef[i] != coef[0]){
                //Posam signe positiu o negatu
                if (coef[i] > 0){
                    compilador = " + " + compilador;
                }
                else {
                    //Pels negatius, simplement volem espaiar el signe negatiu
                    compilador = compilador.replace("-", " - ");
                }
            }


            polinomi = polinomi + compilador;
        }

        if (polinomi.equals("")){
            polinomi = "0";
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
            lletra = "x^"+ (length - 1 -i);
        }

        return lletra;
    }
}
