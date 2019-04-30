package competitiveProgramming.mpeiOlymp2019;

import java.io.DataInputStream;
import java.io.IOException;

public class F {
    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();

        int n = reader.nextInt();
        int m = reader.nextInt();

        long[] a = new long[2 * n];
        int c = reader.nextInt();
        int p = reader.nextInt();
        a[0] = c * p;
        a[1] = a[0] + 1;

        for(int i = 2; i < 2 * n; i += 2) {
            c = reader.nextInt();
            p = reader.nextInt();

            a[i] = a[i - 1] + c * p;
            a[i + 1] = a[i] + 1;
        }

        int[] q = new int[m];
        for(int i = 0; i < m; i++)
            q[i] = reader.nextInt();

        for(int x : q) {
            int res = binarySearch(a, x);

            if(res % 2 == 0)
                System.out.println(res / 2 + 1);
            else
                System.out.println(-1);
        }

    }

    public static int binarySearch(long[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(a[mid + 1] >= target && a[mid] < target)
                return mid + 1;
            else if(a[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
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
