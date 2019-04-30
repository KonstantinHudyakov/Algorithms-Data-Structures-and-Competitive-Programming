package competitiveProgramming.mpeiOlymp2019;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class H {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        String s = line[2];

        String[] words = s.split("\\d+");
        String[] nums = s.split("\\D+");

        int[] col = new int[10];

        for(String x : words) {
            if(x.equals("zero"))
                col[0]++;
            else if(x.equals("one"))
                col[1]++;
            else if(x.equals("two"))
                col[2]++;
            else if(x.equals("three"))
                col[3]++;
            else if(x.equals("four"))
                col[4]++;
            else if(x.equals("five"))
                col[5]++;
            else if(x.equals("six"))
                col[6]++;
            else if(x.equals("seven"))
                col[7]++;
            else if(x.equals("eight"))
                col[8]++;
            else if(x.equals("nine"))
                col[9]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);

        int maxSize = String.valueOf(m).length();

        for(String x : nums) {
            char[] c = x.toCharArray();
            for(int i = 0; i < c.length;) {
                int cur = 0;
                int j = i;
                for(; j < c.length && j < i + maxSize; j++)  {
                    cur *= 10;
                    cur += Character.digit(c[j], 10);
                }
                if(cur <= m)
                    q.add(cur);
                else {
                    q.add(cur / 10);
                    j--;
                }
                i = j;
            }
        }

        while(!q.isEmpty() && q.peek() == 0)
            System.out.print(q.poll() + " ");
        for(int i = 0; i < col[0]; i++)
            System.out.print("zero ");

        while(!q.isEmpty() && q.peek() == 1)
            System.out.print(q.poll() + " ");
        for(int i = 0; i < col[1]; i++)
            System.out.print("one ");

        while(!q.isEmpty() && q.peek() == 2)
            System.out.print(q.poll() + " ");
        for(int i = 0; i < col[2]; i++)
            System.out.print("two ");

        while(!q.isEmpty() && q.peek() == 3)
            System.out.print(q.poll() + " ");
        for(int i = 0; i < col[3]; i++)
            System.out.print("three ");

        while(!q.isEmpty() && q.peek() == 4)
            System.out.print(q.poll() + " ");
        for(int i = 0; i < col[4]; i++)
            System.out.print("four ");

        while(!q.isEmpty() && q.peek() == 5)
            System.out.print(q.poll() + " ");
        for(int i = 0; i < col[5]; i++)
            System.out.print("five ");

        while(!q.isEmpty() && q.peek() == 6)
            System.out.print(q.poll() + " ");
        for(int i = 0; i < col[6]; i++)
            System.out.print("six ");

        while(!q.isEmpty() && q.peek() == 7)
            System.out.print(q.poll() + " ");
        for(int i = 0; i < col[7]; i++)
            System.out.print("seven ");

        while(!q.isEmpty() && q.peek() == 8)
            System.out.print(q.poll() + " ");
        for(int i = 0; i < col[8]; i++)
            System.out.print("eight ");

        while(!q.isEmpty() && q.peek() == 9)
            System.out.print(q.poll() + " ");
        for(int i = 0; i < col[9]; i++)
            System.out.print("nine ");

        while(!q.isEmpty())
            System.out.print(q.poll() + " ");
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
