package competitiveProgramming.yandexInternshipContest;

import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class D {

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();

        long n = reader.nextLong();
        int k = reader.nextInt();

        String num = String.valueOf(n);
        int length = num.length();

        BigDecimal all = BigDecimal.valueOf(binomialCoeff(length, 2));
        all = all.pow(k);
        long count = 0;

        StringBuilder number = new StringBuilder(num);
        for(int i = 0; i < num.length() - 1; i++) {
            for(int j = i + 1; j < num.length(); j++) {
                StringBuilder cur = swap(number, i, j);
                if(check(cur))
                    count++;
            }
        }

        BigDecimal good = BigDecimal.valueOf(count);
        good = good.multiply(BigDecimal.valueOf(k));

        System.out.println((double) good.divide(all, MathContext.DECIMAL128).doubleValue());


    }

    private static StringBuilder swap(StringBuilder s, int a, int b) {
        StringBuilder builder = new StringBuilder(s);
        char ch = builder.charAt(a);
        builder.setCharAt(a, builder.charAt(b));
        builder.setCharAt(b, ch);
        return builder;
    }

    private static boolean check(StringBuilder s) {
        int num = Integer.parseInt(s.toString());
        return num % 5 == 0 || num % 6 == 0 || num % 10 == 0;
    }

    static long binomialCoeff(int n, int k) {
        long res = 1;

        if (k > n - k) {
            k = n - k;
        }

        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
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
