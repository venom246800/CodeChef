import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class ADAROKS2 {
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
            String StrArr[] = new String[n];
            String str = "";
            int flag[] = {0,1,3,4,7,9,13};
            int count = 0;
            str += "O";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < flag[count]; j++,i++) {
                    str += ".";
                }
                str += "O";
                count++;
                if(count==7)
                {
                    break;
                }
            }
            for (int i = str.length()-1; i < n; i++) {
                str+=".";
            }
            for (int i = 0; i < n; i++) {
                StrArr[i] = str.substring(n-i,n)+str.substring(0,n-i);
                System.out.println(StrArr[i]);
            }
        }
    }
}