package competitiveProgramming.mpeiOlymp2019;

import java.io.DataInputStream;
import java.io.IOException;

public class D {
    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();

        int n = reader.nextInt();
        long t = reader.nextLong();

        int[] a = new int[n + 1];

        for(int i = 1; i <= n; i++)
            a[i] = reader.nextInt();

        long res = 0;

        while(t > 0) {
            long num = 0;
            long sum = 0;

            long cur = t;
            for(int i = 1; i <= n; i++) {
                if(a[i] <= cur) {
                    sum += a[i];
                    cur -= a[i];
                    num++;
                }
            }

            long cycles = t / sum;
            t = Math.max(0, t - cycles * sum);
            num = num * cycles;
            res += num;
        }

//        for(int i = 1; i <= n; i++) {
//            if(a[i] <= t) {
//                num++;
//                t -= a[i];
//            }
//        }
//
//        System.out.println(num);






    }

//    public static long sol(int[] a, int n, long t) {
//
//    }

































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
