package competitiveProgramming.codeforces.round551;

import java.io.DataInputStream;
import java.io.IOException;

public class B {
    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();

        int n = reader.nextInt();
        int m = reader.nextInt();
        int h = reader.nextInt();

        int[] front = new int[m + 1];
        int[] left = new int[n + 1];
        int[][] top = new int[n + 1][m + 1];

        for(int i = 1; i <= m; i++)
            front[i] = reader.nextInt();
        for(int i = 1; i <= n; i++)
            left[i] = reader.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                top[i][j] = reader.nextInt();

        int[][] res = new int[n + 1][m + 1];

//        for(int i = 1; i <= n; i++) {
//            if(top[i][1] == 0)
//                res[i][1] = 0;
//            else
//                res[i][1] = left[i];
//        }
//
//        for(int i = 1; i <= n; i++) {
//            if(top[i][m] == 0)
//                res[i][m] = 0;
//            else
//                res[i][m] = left[i];
//        }
//
//        for(int i = 1; i <= m; i++) {
//            if(top[1][i] == 0)
//                res[1][i] = 0;
//            else
//                res[1][i] = front[i];
//        }
//
//        for(int i = 1; i <= m; i++) {
//            if(top[n][i] == 0)
//                res[n][i] = 0;
//            else
//                res[n][i] = front[i];
//        }
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(top[i][j] == 0)
                    res[i][j] = 0;
                else
                    res[i][j] = Math.min(front[j], left[i]);
            }
        }

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                System.out.print(res[i][j] + " ");
            System.out.println();
        }











    }







    private static class FastReader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
