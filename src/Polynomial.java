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
        int maxExponent = trobarMonomis(s, null);
        float[] arrayResult = new float[maxExponent + 1];

        //Tornam a cridar la funció, aquesta vegada per omplir l'array

        trobarMonomis(s, arrayResult);

        //L'arrayResult es el que li hem de passar al toStrings
        this.coef = arrayResult;
    }

    //Una funció que cerca les parts concretes dels monomis, caracter per caracter.
    //L'hauriem de cridar 2 vegades perque necessitam la longitut i el contingut
    private int trobarMonomis(String s, float[] arrayResult) {
        //Bucle que va rotant 'state'. Depenguent de l'estat feim una operació o un altre amb el caracter trobat
        int state = 0;
        char signe = ' ';
        String num = "";
        String exponent = "0";
        int maxExponent = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //Els espais s'ignoren
            if (c == ' ') continue;

            //Cercam signe i continue amb estat 1, si no hi es, seguim amb estat 1 igualment.
            if (state == 0) {
                if (c == '-') {
                    signe = '-';
                    state = 1;
                    continue;
                }
                state = 1;
            }

            //Cercam coeficient
            else if (state == 1) {
                if (c == 'x') {
                    state = 2;
                    if (num.equals("")) num = "1";
                    if (signe == '-') {
                        num = signe + num;
                        signe = ' ';
                    }
                } else {
                    num += c;
                }
            }
            //Si despues de la X no hay un ^, grado 1 y al array
            if (c == 'x' && s.charAt(i + 1) != '^') {
                exponent = "1";
                state = 4;
            }

            //Cercam X i el signe ^
            if (state == 2) {
                if (c == 'x')
                    state = 3;
            } else if (state == 3) {
                state = 4;
            }

            //Cercam exponent, i ho ficam a l'array
            else if (state == 4 || i == s.length() - 1) {
                if (c != 'x' && state == 4) exponent += c;
                int nExponent = Integer.parseInt(exponent);
                if (nExponent > maxExponent) maxExponent = nExponent;
                if (arrayResult != null) {
                    float numInt = Float.parseFloat(num);
                    if (signe == '-') numInt = numInt * -1;
                    arrayResult[arrayResult.length - nExponent - 1] += numInt;
                }
                state = 0;
                num = "";
                exponent = "0";
            }
        }
        if (arrayResult == null) return maxExponent;
        return 1;
    }

    // Suma el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial add(Polynomial p) {
        int maxLength;
        if (this.coef.length > p.coef.length)
            maxLength = this.coef.length;
        else
            maxLength = p.coef.length;
        float[] tempAr = new float[maxLength];

        //Els hem de sumar dins el mateix array de dreta a esquerra
        for (int i = 0; i < this.coef.length; i++) {
            tempAr[maxLength - i - 1] += this.coef[this.coef.length - i - 1];
        }
        for (int i = 0; i < p.coef.length; i++) {
            tempAr[maxLength - i - 1] += p.coef[p.coef.length - i - 1];
        }

        return new Polynomial(tempAr);
    }

    // Multiplica el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial mult(Polynomial p2) {

        //La longitut sirá la suma dels exponents maxims, o la longitut -1 cadascun.
        int maxLength = this.coef.length + p2.coef.length;
        int exponent;
        float[] tempAr = new float[maxLength];

        //Ara els multiplicarem
        for (int i = 0; i < p2.coef.length; i++) {
            for (int j = 0; j < this.coef.length; j++) {

                //Calculam l'exponent que tindrá el numero
                exponent = this.coef.length + p2.coef.length - 2 - i - j;

                //Calculam el numero
                tempAr[maxLength - exponent - 1] += this.coef[j] * p2.coef[i];
            }
        }

        return new Polynomial(tempAr);
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
                continue;
            }
            //Si el numero és 1, només es posa la X
            else if (coef[i] == 1 || coef[i] == -1) {
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
        //firstNumber será el primer numero que no és 0
        int firstNumber = (int) coef[0];
        int incremental = 0;
        while (firstNumber == 0) {
            incremental++;
            firstNumber = (int) coef[incremental];
        }

        //Si es el primer numero, no es posa signe
        if (coef[i] == firstNumber)
            return compilador;


        //Si el numero és 0 no es posa signe
        if (coef[i] != 0 && coef[i] != coef[0]) {
            //Posam signe positiu o negatu
            if (coef[i] > 0) {
                compilador = " + " + compilador;
            } else {
                //Pels negatius, simplement volem espaiar el signe negatiu
                compilador = compilador.replace("-", "");
                compilador = " - " + compilador;

            }
        }
        return compilador;
    }

    //Funcio que posa la x i el seu exponent, si en necesita
    private String ferX(int i, int length) {
        String lletra;

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
