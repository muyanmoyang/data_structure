package muyanmoyang.swadoffer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * ��ӡ1������nλ�� �����и����弴n���ܴܺ󣬻����
 */
public class OutPutOneToMaxNDigits {
 
    public void outPutOneToMaxNDigits(int n) {
        // ��nlist��ʾ��n,nlist[0]��ʾn�����λ
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            nlist.add(0);
        }
        increment(nlist);
    }
 
    // ʹ����ÿ��+1Ȼ�����
    public void increment(ArrayList<Integer> nlist) {
        int carrybit = 0;
        boolean end = false;
        while (true) {
            for (int i = nlist.size() - 1; i >= 0; i--) {
                int digit = nlist.get(i);
                int sum = digit + carrybit;
                if (i == (nlist.size() - 1)) {
                    sum += 1;
                }
                if (sum >= 10) {
                    if (i == 0) {   // ���λ������λ���ﵽ���ֵ��ֹͣ���
                        end = true;
                    }
                    sum = sum - 10;
                    carrybit = 1;
                } else {
                    carrybit = 0;
                }
                nlist.set(i, sum);
            }
            output(nlist);
            if (end) {
                break;
            }
        }
    }
 
    // ������֣�����λ��0���
    public void output(ArrayList<Integer> nlist) {
        Iterator<Integer> ite = nlist.iterator();
        int num;
        // �ҵ���һ��Ϊ0��λ��
        boolean first = false;
        while (ite.hasNext()) {
            if (first) {
                System.out.print(ite.next());
                continue;
            }
            if ((num = ite.next()) != 0) {
                first = true;
                System.out.print(num);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        OutPutOneToMaxNDigits opt = new OutPutOneToMaxNDigits();
        opt.outPutOneToMaxNDigits(2);
         
    }
}