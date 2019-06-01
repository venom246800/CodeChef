import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class ADAPWN {
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
        while (t-->0) {

            int n = sc.nextInt();
            String[] strArr = new String[n];

            int[][] originalArray = new int[n + 2][n + 2];
            int[][] answerArray = new int[n + 2][n + 2];

            int mustInt = 0;

            //black pieces
            int[][] canList = new int[n * n][2];
            int canInt = 0;

            //white pieces
            int[][] canList2 = new int[n * n][2];
            int canInt2 = 0;

            int flag = 0;

            for (int row = 1; row <= n; row++) {
                strArr[row-1] = sc.next();

                for (int col = 1; col <= n; col++) {
                    if(strArr[row-1].charAt(col-1)=='O')
                    {
                        if(originalArray[row-1][col-1]==0&&originalArray[row-1][col+1]==0)
                        {
                            originalArray[row][col]=1;
                        }
                        else if(originalArray[row-1][col-1]==1||originalArray[row-1][col+1]==1){
                            originalArray[row][col]=2;
                            mustInt++;
                            answerArray[row][col]=1;
                        }
                        else
                        {
                            originalArray[row][col]=3;

                            //black pieces
                            if((row+col)%2==0) {
                                canList[canInt][0] = row;
                                canList[canInt][1] = col;
                                canInt++;
                            }

                            //white pieces
                            else {
                                canList2[canInt2][0] = row;
                                canList2[canInt2][1] = col;
                                canInt2++;
                            }
                        }
                    }
                    else {
                        flag=1;
                    }
                }
            }
            if(n==1)
            {
                System.out.println(0);
            }
            else if(flag==0){
                int answerCount = n/2;
                answerCount*=n;
                System.out.println(answerCount);
                for (int i = 2; i <= n; i+=2) {
                    for (int j = 1; j <= n; j++) {
                        String string = (j!=n)?"R":"L";
                        System.out.println(i+" "+j+" "+string);
                    }
                }
            }
            else
            {
                int maximumValue = (int)Math.pow(2,canInt);
                int totalSafe = 0;
                int[][] blackRem = new int[n+2][n+2];

                for (int binCom = maximumValue-1; binCom >= 0; binCom--) {

                    int[][] tem = new int[n+2][n+2];
                    int[] binary = new int[100];
                    int index = 0;
                    int temp = binCom;
                    int testSafe = 0;

                    while (temp>0)
                    {
                        binary[index] = temp%2;
                        index++;
                        temp/=2;
                    }

                    for (int j = canInt-1,i=0; j >= 0;j--,i++) {
                        if(binary[j]==1)
                        {
                            testSafe++;
                            int ax = canList[i][0];
                            int bx = canList[i][1];
                            tem[ax][bx]=1;
                            if(     tem[ax-1][bx-1]==1||
                                    tem[ax-1][bx+1]==1||
                                    tem[ax+1][bx-1]==1||
                                    tem[ax+1][bx+1]==1)
                            {
                                testSafe=0;
                                break;
                            }
                        }
                        temp/=2;
                    }
                    if(totalSafe<testSafe)
                    {
                        totalSafe=testSafe;
                        for (int row = 0; row < n+2; row++) {
                            for (int col = 0; col < n+2; col++) {
                                blackRem[row][col] = tem[row][col];
                            }
                        }
                    }
                }

                int maximumValue2 = (int)Math.pow(2,canInt2);
                int totalSafe2 = 0;
                int[][] whiteRem = new int[n+2][n+2];

                for (int binCom = maximumValue2-1; binCom >= 0; binCom--) {

                    int[][] tem = new int[n+2][n+2];
                    int[] binary = new int[100];
                    int index = 0;
                    int temp = binCom;
                    int testSafe = 0;
                    while (temp>0)
                    {
                        binary[index] = temp%2;
                        index++;
                        temp/=2;
                    }

                    for (int j = canInt2-1,i=0; j >= 0;j--,i++) {
                        if(binary[j]==1)
                        {
                            testSafe++;
                            int ax = canList2[i][0];
                            int bx = canList2[i][1];
                            tem[ax][bx]=1;
                            if(     tem[ax-1][bx-1]==1||
                                    tem[ax-1][bx+1]==1||
                                    tem[ax+1][bx-1]==1||
                                    tem[ax+1][bx+1]==1)
                            {
                                testSafe=0;
                                break;
                            }
                        }
                        temp/=2;
                    }
                    if(totalSafe2<testSafe)
                    {
                        totalSafe2=testSafe;
                        for (int row = 0; row < n+2; row++) {
                            for (int col = 0; col < n+2; col++) {
                                whiteRem[row][col] = tem[row][col];
                            }
                        }
                    }
                }
                for (int i = 0; i < canInt; i++) {
                    int y = canList[i][0];
                    int z = canList[i][1];
                    if(blackRem[y][z]==0)
                    {
                        answerArray[y][z]=1;
                    }
                }
                for (int i = 0; i < canInt2; i++) {
                    int y = canList2[i][0];
                    int z = canList2[i][1];
                    if(whiteRem[y][z]==0)
                    {
                        answerArray[y][z]=1;
                    }
                }
                int answer=mustInt+(canInt-totalSafe)+(canInt2-totalSafe2);
                System.out.println(answer);
                for (int i = n; i >=1 ; i--) {
                    for (int j = n; j >= 1; j--) {
                        if(answerArray[i][j]!=0)
                        {
                            if(originalArray[i-1][j-1]!=0)
                            {
                                System.out.println(i+" "+j+" L");
                            }
                            else {
                                System.out.println(i+" "+j+" R");
                            }
                        }
                    }
                }
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if(originalArray[i][j]!=0&&answerArray[i][j]==0)
                        {
                            System.out.print("1");
                        }
                        else {
                            System.out.print("0");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
