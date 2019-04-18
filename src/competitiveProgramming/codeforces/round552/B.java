package competitiveProgramming.codeforces.round552;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();

        int n = reader.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++)
            list.add(reader.nextInt());

        Set<Integer> set = new HashSet<>(list);

        if(set.size() > 3) {
            System.out.println(-1);
            return;
        }


        if(set.size() == 1) {
            System.out.println(0);
        }
        else if(set.size() == 2) {
            Iterator<Integer> it = set.iterator();
            int x = it.next();
            int y = it.next();

            int s = Math.abs(x - y);
            if(s % 2 == 0)
                System.out.println(s / 2);
            else
                System.out.println(s);
        }
        else {
            Iterator<Integer> it = set.iterator();
            int x = it.next();
            int y = it.next();
            int z = it.next();

            int[] a = new int[] {x, y, z};
            Arrays.sort(a);

            if(a[2] - a[1] == a[1] - a[0])
                System.out.println(a[2] - a[1]);
            else
                System.out.println(-1);
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
