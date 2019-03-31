package competitiveProgramming.codeforces.round550;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();

        int n = reader.nextInt();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        boolean flag = false;
        for(int i = 0; i < n; i++) {
            int temp = reader.nextInt();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if(map.get(temp) > 2) {
                flag = true;
            }
            list.add(temp);
        }
        if(flag) {
            System.out.println("No");
            return;
        }

        List<Integer> temp = new ArrayList<>();
        List<Integer> incr = new ArrayList<>();

        for(Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if(pair.getValue() == 2) {
                incr.add(pair.getKey());
                temp.add(pair.getKey());
            }
            else
                incr.add(pair.getKey());
        }

        List<Integer> decr = new ArrayList<>();
        for(int i = temp.size() - 1; i >= 0; i--)
            decr.add(temp.get(i));

        System.out.println("Yes");
        System.out.println(incr.size());
        for(int x : incr)
            System.out.print(x + " ");
        System.out.println();
        System.out.println(decr.size());
        for(int x : decr)
            System.out.print(x + " ");
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
