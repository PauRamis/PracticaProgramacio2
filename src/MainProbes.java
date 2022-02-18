public class MainProbes {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(new float[]{1, 2, 4});
        Polynomial p2 = new Polynomial(new float[]{8, 5, 4, 0, 9});
        System.out.println(p1.add(p2).toString());
    }
}

