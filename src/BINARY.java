import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BINARY {
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
            int z = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            if(n<=3000&&z<=3000)
            {
                int b[] = new int[n];
                for (int i = 0; i < z; i++) {
                    for (int j = 0; j < n; j++) {
                        if(a[j]==0)
                        {
                            if(j!=n-1) {
                                if(a[j+1]==1) {
                                    b[j] = 1;
                                    b[j + 1] = 0;
                                    j++;
                                }
                                else
                                {
                                    b[j] = a[j];
                                }
                            }
                            else
                            {
                                b[j]=a[j];
                            }
                        }
                        else
                        {
                            b[j]=a[j];
                        }
                    }
                    for (int j = 0; j < n; j++) {
                        a[j] = b[j];
                    }
                }
                for (int i = 0; i < n; i++) {
                    System.out.print(a[i]+" ");
                }
                System.out.println();
            }
            else {
                for (int i = n - 1; i >= 0; i--) {
                    if (a[i] == 0) {
                        for (int j = i + 1, temp = 0; j < n && temp < z; j++, temp++) {
                            if (a[j] == 1) {
                                a[j] = 0;
                                a[j - 1] = 1;
                            } else {
                                break;
                            }
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
