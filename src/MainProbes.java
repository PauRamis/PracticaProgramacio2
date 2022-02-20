public class MainProbes {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(new float[]{1, 0});
        Polynomial p2 = new Polynomial(new float[]{1, 1});
        System.out.println(p1.mult(p2).toString());
    }
}

