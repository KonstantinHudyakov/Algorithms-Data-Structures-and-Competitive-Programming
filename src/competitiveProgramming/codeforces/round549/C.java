package competitiveProgramming.codeforces.round549;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C {
    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();
        int n = reader.nextInt();

        int[] p = new int[n + 1];
        int[] c = new int[n + 1];

        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> dop = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            dop.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++) {
            p[i] = reader.nextInt();
            c[i] = reader.nextInt();
            if(p[i] != -1)
                list.get(p[i]).add(i);
        }

        boolean flag = false;
        int count = 0;
        Set<Integer> deleted = new HashSet<>();
        while(!flag) {
            flag = true;
            for(int i = 1; i <= n; i++) {
                if(deleted.contains(i))
                    continue;
                if(!check(list, dop, p, c, i)) {
                    System.out.print(i + " ");
                    deleted.add(i);
                    for(int x : list.get(i)) {
                        p[x] = p[i];
                    }
                    list.get(p[i]).add(i);
                    flag = false;
                    count++;
                }
            }
        }
        if(count == 0)
            System.out.println(-1);

    }

    public static boolean check(List<List<Integer>> list, List<List<Integer>> dop, int[] p, int[] c, int v) {
        if(c[v] == 1) {
            for(int x : list.get(v)) {
                if(c[x] == 0)
                    return true;
            }
            for(int l : dop.get(v)) {
                for(int x : list.get(l)) {
                    if(c[x] == 0)
                        return true;
                }
            }
            return false;
        }
        return true;
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
