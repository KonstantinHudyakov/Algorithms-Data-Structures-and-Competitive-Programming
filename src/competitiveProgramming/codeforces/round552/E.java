package competitiveProgramming.codeforces.round552;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class E {
    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();

        int n = reader.nextInt();
        int k = reader.nextInt();

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> b.v - a.v);
        //Pair[] list = new Pair[n];

        for(int i = 1; i <= n; i++) {
            //list[i - 1] = new Pair(i, reader.nextInt());
            q.add(new Pair(i, reader.nextInt()));
        }

    //    Arrays.parallelSort(list, (a, b) -> b.v - a.v);

        int[] res = new int[n + 1];

        int ind = 0;
        int left, right;
        int curTeam = 1;
        while(!q.isEmpty()) {
            while(!q.isEmpty() && res[q.peek().ind] != 0)
                q.poll();
            if(q.isEmpty())
                break;
            Pair cur = q.poll();
            ind = cur.ind;
            res[ind] = curTeam;
            left = Math.max(1, ind - k);
            right = Math.min(n, ind + k);

            for(int j = ind - 1; j >= left; j--) {
                if(j <= 0)
                    break;
                if(res[j] != 0) {
                    left--;
                    continue;
                }
                res[j] = curTeam;
            }

            for(int j = ind + 1; j <= right; j++) {
                if(j > n)
                    break;
                if(res[j] != 0) {
                    right++;
                    continue;
                }
                res[j] = curTeam;
            }
            curTeam = curTeam == 1 ? 2 : 1;
        }

        for(int i = 1; i <= n; i++)
            System.out.print(res[i]);

    }

    private static class Pair {
        int ind;
        int v;

        public Pair(int ind, int v) {
            this.ind = ind;
            this.v = v;
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
