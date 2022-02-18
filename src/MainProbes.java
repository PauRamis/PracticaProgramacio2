public class MainProbes {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(new float[]{5, 2, 10});
        Polynomial p2 = new Polynomial(new float[]{-5, 0, 8});
        System.out.println(p1.add(p2).toString());
    }
}

