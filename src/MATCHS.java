import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MATCHS {
    static boolean count = false;
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        try {
            FastReader sc = new FastReader();
            int t = sc.nextInt();
            while (t-- > 0) {
                count = false;
                long m = sc.nextLong();
                long n = sc.nextLong();
                calculate(Math.max(m, n), Math.min(m, n));
                if (count) {
                    System.out.println("Ari");
                } else {
                    System.out.println("Rich");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(""+e);
        }
    }
    private static void calculate(long m, long n) {
        System.out.println(m+" "+n);
        long temp = m%n;
        count = !count;
        if(temp==0L||temp!=(m-n))
        {
            return;
        }
        calculate(n,temp);
    }
}
