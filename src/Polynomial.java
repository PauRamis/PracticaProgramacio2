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
        /*Bucle que va rotant 'estat'
        Depenguent de l'estat feim una operació o un altre amb el caracter trobat*/
        char signe;
        int num = 0;
        int exponent;
        int maxExponent = 0;

        //Una funció que cerca les parts concretes dels monomis, caracter per caracter.
        //L'hauriem de cridar 3 vegades perque necessitam 3 variables
        maxExponent = trobarMonomis(s, null);

        //arPolinomi és un array de la longitut que tindrá el polinomi
        int[] arPolinomi = new int[maxExponent +1];


        trobarMonomis(s, maxExponent);

        //this.coef = arPolinomi;
    }

    /*s
    estat 0 = cercar signe --Després del signe->
    estat 1 = coeficent de X --Al trobar una X->
    estat 2 = cercar X --Després de la X->
    estat 3 = Cercar ^ --Després del ^->
    estat 4 = Cercar exponent --Al trobar un signe->> Repetir
    */
    private int trobarMonomis(String s, Integer varResult) {
        int state = 0;
        char signe;
        int num = 0;
        int exponent = 0;
        int maxExponent = 0;
        if (varResult != null){
            int[] arSecundari = new int[varResult];

        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //Els espais s'ignoren
            if (c == ' ') continue;

            if (state == 0) {
                if (c == '-') signe = '-';
                state = 1;
            }
            else if (state == 1) {
                if (c == 'x') state = 2;
                else num = num + c;
            }

            if (state == 2) {
                state = 3;
            }
            else if (state == 3) {
                state = 4;
            }
            else if (state == 4){
                if (c == '-' || c == '+'){
                    state = 0;
                    i--;
                } else
                    exponent = c;
                if (exponent > maxExponent) maxExponent = exponent;
            }
            if (varResult != null){
                arSecundari[exponent] = num;
            }
        }
        if (varResult == null) return maxExponent;
        return num;
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

            //Afegim el signe
            compilador = posarSigne(i, compilador);

            //sumam el compilador al polinomi que tornarem
            polinomi = polinomi + compilador;
        }

        //Si ha quedat buid, aleshores són tot 0.
        if (polinomi.equals("")) {
            polinomi = "0";
        }
        return polinomi;
    }

    private String posarSigne(int i, String compilador) {
        //Si el numero és 0 o és el primer no es posa signe
        if (coef[i] != 0 && coef[i] != coef[0]) {
            //Posam signe positiu o negatu
            if (coef[i] > 0) {
                compilador = " + " + compilador;
            } else {
                //Pels negatius, simplement volem espaiar el signe negatiu
                compilador = compilador.replace("-", " - ");
            }
        }
        return compilador;
    }

    private String ferX(int i, int length) {
        //length = 3
        //position = 0-2
        String lletra = "X";

        //Si es l'ultim caracter, no té X
        if (i == length - 1) {
            lletra = "";

            //Si l'exponent és 1, no es mostra.
        } else if (length - 1 - i == 1) {
            lletra = "x";
        } else {
            lletra = "x^" + (length - 1 - i);
        }

        return lletra;
    }
}
