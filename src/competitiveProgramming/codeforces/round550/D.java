package competitiveProgramming.codeforces.round550;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

//not solved
public class D {
    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();

        int n = reader.nextInt();
        if(n == 1) {
            System.out.println(0);
            return;
        }
        List<Integer> list = new ArrayList<>();
        int maxStart = 0;
        int maxLen = 1;
        int curLen = 1;
        int cur = reader.nextInt();
        int maxCur = cur;
        list.add(cur);
        for(int i = 1; i < n; i++) {
            int temp = reader.nextInt();
            if(temp == cur) {
                curLen++;
                if(curLen > maxLen) {
                    maxLen = curLen;
                    maxStart = i - curLen + 1;
                    maxCur = cur;
                }
            }
            else {
                curLen = 1;
                cur = temp;
            }
            list.add(temp);
        }

        int left = maxStart - 1;
        int right = maxStart + maxLen;

        List<Integer> t = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        while(left >= 0) {
            if(list.get(left) == maxCur) {
                left--;
                continue;
            }
            if(list.get(left) > maxCur) {
                t.add(2);
                l.add(left);
                r.add(left + 1);
            }
            else {
                t.add(1);
                l.add(left);
                r.add(left + 1);
            }
            left--;
        }

        while(right < n) {
            if(list.get(right) == maxCur) {
                right++;
                continue;
            }
            if(list.get(right) > maxCur) {
                t.add(2);
                l.add(right);
                r.add(right - 1);
            }
            else {
                t.add(1);
                l.add(right);
                r.add(right - 1);
            }
            right++;
        }

        System.out.println(t.size());

        for(int i = 0; i < t.size(); i++) {
            System.out.println(t.get(i) + " " + (l.get(i) + 1) + " " + (r.get(i) + 1));
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
