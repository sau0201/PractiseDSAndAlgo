
class HowManyBsts {

    public static void main(String[] args) {
        System.out.println(how_many_BSTs(5));
        System.out.println(how_many_BSTs(6));
    }

    static long how_many_BSTs(int n) {
        long[] g = new long[n + 1];
        g[0] = 1l;
        g[1] = 1l;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                g[i] += g[j] * g[i - j - 1];
            }
        }
        return g[n];
    }
}