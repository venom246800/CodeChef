import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class WTBTR {
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
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            double x[] = new double[n];
            double y[] = new double[n];
            double arr1[] = new double[n];
            double arr2[] = new double[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
                arr1[i] = x[i]+y[i];
                arr2[i] = x[i]-y[i];
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            double min = Math.abs((arr1[0]-arr1[1])/2);
            min = Math.min(Math.abs((arr2[0]-arr2[1])/2),min);
            for (int i = 1; i < n-1; i++) {
                min = Math.min(Math.abs((arr1[i]-arr1[i+1])/2),min);
                min = Math.min(Math.abs((arr2[i]-arr2[i+1])/2),min);
                if(min==0.0)
                {
                    break;
                }
            }
            System.out.println(min);
        }
    }
}