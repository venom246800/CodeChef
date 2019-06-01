import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TREDEG {
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
    }
    static long mod = 998244353;
    static long power(long x, long y, long p)
    {
        long res = 1;
        x = x % p;
        while (y > 0)
        {
            if((y & 1)==1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] power = {power(3,k,mod),//0
                    power(4,k,mod),//1
                    power(5,k,mod),//2
                    power(6,k,mod),//3
                    power(8,k,mod),//4
                    power(9,k,mod),//5
                    power(10,k,mod),//6
                    power(12,k,mod),//7
                    power(16,k,mod),//8
                    power(18,k,mod),//9
                    power(24,k,mod),//10
                    power(32,k,mod)//11
            };
            if(n<=7)
            {
                if(n==2)
                {
                    System.out.println("1");
                }
                else if(n==3)
                {
                    long ans = power(2,k,mod);
                    System.out.println(ans);
                }
                else if(n==4)
                {
                    long ans = 1, ans2 = 1;
                    ans = power[1];
                    ans2 = power[0];

                    ans *= 12;
                    ans %= mod;
                    ans2 *= 4;
                    ans2 %= mod;

                    ans = (ans+ans2)%mod;
                    ans = (ans*935854081)%mod;
                    System.out.println(ans);
                }
                else if(n==5)
                {
                    long ans = 1, ans2 = 1, ans3 =1;
                    ans = power[4];
                    ans2 = power[3];
                    ans3 = power[1];

                    ans *= 60;
                    ans %= mod;
                    ans2 *= 60;
                    ans2 %= mod;
                    ans3 *= 5;
                    ans3 %= mod;

                    ans = (ans+ans2+ans3)%mod;
                    ans = (ans*862483121)%mod;
                    System.out.println(ans);
                }
                else if(n==6)
                {
                    long ans = 1, ans2 = 1, ans3 =1, ans4 =1, ans5 =1, ans6 = 1;

                    ans = power[8];
                    ans2 = power[7];
                    ans3 = power[7];
                    ans4 = power[4];
                    ans5 = power[5];
                    ans6 = power[2];
                    ans *= 360;
                    ans %= mod;
                    ans2 *= 360;
                    ans2 %= mod;
                    ans3 *= 360;
                    ans3 %= mod;
                    ans4 *= 120;
                    ans4 %= mod;
                    ans5 *= 90;
                    ans5 %= mod;
                    ans6 *= 6;
                    ans6 %= mod;

                    ans = (ans+ans2+ans3+ans4+ans5+ans6)%mod;
                    ans = (ans*800290033)%mod;
                    System.out.println(ans);
                }
                else if(n==7)
                {
                    long ans = 1, ans2 = 1, ans3 =1, ans4 =1, ans5 =1,
                            ans6 = 1, ans7 = 1, ans8 = 1, ans9 = 1,
                            ans10 = 1, ans11 =1;
                    ans = power[11];
                    ans2 = power[10];
                    ans3 = power[10];
                    ans4 = power[8];
                    ans5 = power[8];
                    ans6 = power[9];
                    ans7 = power[10];
                    ans8 = power[7];
                    ans9 = power[6];
                    ans10 = power[9];
                    ans11 = power[3];
                    ans *= 2520;
                    ans %= mod;
                    ans2 *= 2520;
                    ans2 %= mod;
                    ans3 *= 5040;
                    ans3 %= mod;
                    ans4 *= 840;
                    ans4 %= mod;
                    ans5 *= 1260;
                    ans5 %= mod;
                    ans6 *= 2520;
                    ans6 %= mod;
                    ans7 *= 840;
                    ans7 %= mod;
                    ans8 *= 420;
                    ans8 %= mod;
                    ans9 *= 210;
                    ans9 %= mod;
                    ans10 *= 630;
                    ans10 %= mod;
                    ans11 *= 7;
                    ans11 %= mod;
                    ans = (ans+ans2+ans3+ans4+ans5+ans6+ans7+ans8+ans9+ans10+ans11)%mod;
                    ans = (ans*627741094)%mod;
                    System.out.println(ans);
                }
            }
            else
            {
                System.out.println("0");
            }
        }
    }
}
