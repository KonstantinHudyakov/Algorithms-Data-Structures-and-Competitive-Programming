package competitiveProgramming.mpeiOlymp2019;

import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class I {

    public static int mod = 1000000007;
    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();

        int n = reader.nextInt();
        int k = reader.nextInt();

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            list.add(new ArrayList<>());

        for(int i = 0; i < n - 1; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            int c = reader.nextInt();
            if(c == 1)
                continue;
            list.get(u).add(v);
            list.get(v).add(u);
        }

        List<Integer> comps = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();

        for(int i = 1; i <= n; i++) {
            int size = visited.size();
            if(!visited.contains(i))
                dfs(i, list, visited);
            int afterSize = visited.size();
            if(afterSize - size > 0)
                comps.add(afterSize - size);
        }

        BigInteger res = BigInteger.ZERO;

        for(int x : comps) {
            BigInteger cur = BigInteger.valueOf(x);
            BigInteger powed = cur.pow(k);

            res = res.add(powed);
        }

        long all = BigInteger.valueOf(n).pow(k).remainder(BigInteger.valueOf(mod)).longValue();
        System.out.println((all - res.longValue()) % mod);

    }

    public static void dfs(int u, List<List<Integer>> list, Set<Integer> visited) {
        visited.add(u);

        for(int x : list.get(u)) {
            if(!visited.contains(x))
                dfs(x, list, visited);
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
