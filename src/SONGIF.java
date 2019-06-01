import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class SONGIF {
    static int N;
    static int[] path;
    static ArrayList<Integer>[] al;
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
    private static void findPath(int u, int v, boolean[] visited, int[] p, int index) {
        visited[u] = true;
        p[index] = u;
        index++;

        if(index==N)
        {
            return;
        }
        for (int i = 0; i < al[u].size(); i++) {
            if(al[u].get(i)==v){
                p[index] = v;
                for (int j = 0; j <= index; j++) {
                    path[j] = p[j];
                }
                return;
            }
            else if(!visited[al[u].get(i)])
            {
                findPath(al[u].get(i),v,visited,p,index);
            }
        }
    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        int Q = sc.nextInt();
        long[] K = new long[N+1];
        long[] B = new long[N+1];
        al = new ArrayList[N+1];

        al[0] = new ArrayList<Integer>();
        for (int i = 1; i < N+1; i++) {
            K[i] = sc.nextLong();
            al[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < N+1; i++) {
            B[i] = sc.nextLong();
        }
        for (int i = 0; i < N-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            al[u].add(v);
            al[v].add(u);
        }
        for (int i = 0; i < Q; i++) {
            int t = sc.nextInt();
            int u = sc.nextInt();
            int v = sc.nextInt();

            path = new int[N+1];
            int[] p = new int[N+1];
            boolean[] visited = new boolean[N+1];
            if(u ==v)
            {
                path[0] = u;
            }else {
                findPath(u , v , visited, p, 0);
            }

            if(t==1)
            {
                long x = sc.nextLong();
                long y = sc.nextLong();
                for (int j = 0; j < N+1; j++) {
                    if(path[j]==0)
                    {
                        break;
                    }
                    else {
                        K[path[j]] += x;
                        B[path[j]] += y;
                    }
                }
            }
            else
            {
                long z = sc.nextLong();
                long max = (K[path[0]]*z)+B[path[0]];
                for (int j = 1; j < N; j++) {
                    if(path[j]==0)
                    {
                        break;
                    }
                    else
                    {
                        max = Math.max(max,(K[path[j]]*z)+B[path[j]]);
                    }
                }
                System.out.println(max);
            }
        }
    }
}
