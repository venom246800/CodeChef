import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class REDONE {
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
    static long Max = 1_000_000_007L;
    static long arr[] = new long[1_000_001];
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        arr[0] = 0L;
        arr[1] = 1L;
        for (int i = 2; i <= 1_000_000; i++) {
            arr[i] = fun(arr[i-1],(long)i);
        }
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            System.out.println(arr[n]);
        }
    }

    private static long fun(long last, long cur) {
        return (((last*((cur+1)%Max))%Max)+cur)%Max;
    }
}
