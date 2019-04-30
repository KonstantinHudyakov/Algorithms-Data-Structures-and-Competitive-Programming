package competitiveProgramming.mpeiOlymp2019;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class J {
    public static int cycles = 0;

    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();

        int n = reader.nextInt();
        int m = reader.nextInt();

        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            adj.add(new HashSet<>());

        for(int i = 0; i < m; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            adj.get(u).add(v);
        }


        for(int i = 1; i <= n; i++) {
            int[] visited = new int[n + 1];
            cycles = 0;
            dfs(i, visited, adj);
            for(int j = 1; j <= n; j++) {
                if(visited[j] == 0)
                    dfs(j, visited,adj);
            }

            if(cycles <= 1) {
                System.out.println("YES");
                return;
            }

        }

        System.out.println("NO");



    }

    static void dfs(int u, int[] visited, List<Set<Integer>> adj) {
        visited[u] = 2;

        for(int x : adj.get(u)) {
            if(visited[x] == 0)
                dfs(x, visited, adj);
            else if(visited[x] == 2)
                cycles++;
        }
        visited[u] = 1;
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
