package competitiveProgramming.mpeiOlymp2019;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class K {
    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();

        int n = reader.nextInt();

        int[][] matr = new int[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matr[i][j] = reader.nextInt();

        List<PriorityQueue<Pair>> rows = new ArrayList<>();
        for(int i = 0; i < n; i++)
            rows.add(new PriorityQueue<>((a, b) -> a.val - b.val));

        List<PriorityQueue<Pair>> cols = new ArrayList<>();
        for(int i = 0; i < n; i++)
            cols.add(new PriorityQueue<>((a, b) -> b.val - a.val));


        for(int i = 0; i < n; i++) {
            PriorityQueue<Pair> cur = rows.get(i);
            for(int j = 0; j < n; j++) {
                cur.add(new Pair(matr[i][j], j));
            }
        }

        for(int i = 0; i < n; i++) {
            PriorityQueue<Pair> cur = cols.get(i);
            for(int j = 0; j < n; j++) {
                cur.add(new Pair(matr[j][i], i));
            }
        }

        boolean[] delRows = new boolean[n];
        boolean[] delCols = new boolean[n];

        for(int i = 0; i < n - 2; i += 2) {
            int ind = findMin(rows);
            delRows[ind] = true;

            //Pair pair = rows.get(ind).peek();

            for(int j = 0; j < n; j++) {
                if(!cols.get(j).isEmpty() && cols.get(j).peek().ind == ind)
                    cols.get(j).poll();
            }

            int ind2 = findMax(cols);
            delCols[ind2] = true;

            for(int j = 0; j < n; j++) {
                if(!rows.get(j).isEmpty() && rows.get(j).peek().ind == ind2)
                    rows.get(j).poll();
            }

        }

        int ind = findMin(rows);
        delRows[ind] = true;

        //Pair pair = rows.get(ind).peek();

        for(int j = 0; j < n; j++) {
            if(!cols.get(j).isEmpty() && cols.get(j).peek().ind == ind)
                cols.get(j).poll();
        }

        int resRow = 0;
        for(int i = 0; i < n; i++) {
            if(!delRows[i]) {
                resRow = i;
                break;
            }
        }

        int resCol = 0;
        for(int i = 0; i < n; i++) {
            if(!delCols[i]) {
                resCol = i;
                break;
            }
        }

        System.out.println(matr[resRow][resCol]);

    }

    public static int findMax(List<PriorityQueue<Pair>> list) {
        int maxInd = 0;
        int maxVal = Integer.MIN_VALUE;
        for(int i = 1; i < list.size(); i++) {
            if(!list.get(i).isEmpty() && list.get(i).peek().val > maxVal) {
                maxInd = i;
                maxVal = list.get(i).peek().val;
            }
        }
        return maxInd;
    }

    public static int findMin(List<PriorityQueue<Pair>> list) {
        int minInd = 0;
        int minVal = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++) {
            if(!list.get(i).isEmpty() && list.get(i).peek().val < minVal) {
                minInd = i;
                minVal = list.get(i).peek().val;
            }
        }
        return minInd;
    }

    public static class Pair {
        int ind;
        int val;

        public Pair(int ind, int val) {
            this.ind = ind;
            this.val = val;
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
