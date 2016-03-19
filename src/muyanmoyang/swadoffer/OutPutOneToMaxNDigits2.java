package muyanmoyang.swadoffer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * ��ӡ1������nλ�� �����и����弴n���ܴܺ󣬻����
 */
public class OutPutOneToMaxNDigits2 {
 
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
        boolean stop = false;
        while(true){
        	for(int i=nlist.size()-1; i>=0; i--){
        		int sum = nlist.get(i) + carrybit ;
        		if(i == nlist.size()-1){
        			sum += 1 ;
        		}
        		if(sum >= 10){
        			if(i == 0){
        				stop = true ;
        			}
        			sum = sum - 10 ;
        			carrybit = 1 ;
        		}else{
        			carrybit = 0 ;
        		}
        		nlist.set(i, sum) ;
        	}
        	output(nlist) ;
        	if(stop){
        		break ;
        	}
        }
    }
    // ������֣�ȥ�����λ��0
    public void output2(ArrayList<Integer> nlist){
    	Iterator<Integer> it = nlist.iterator() ;
    	boolean firstFlag = false ;
    	int num ;
    	while(it.hasNext()){
    		if(firstFlag){
    			System.out.println(it.next()); 
    			continue;
    		}
    		if((num = it.next()) != 0){
    			firstFlag = true ;
    			System.out.print(num);
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
        OutPutOneToMaxNDigits2 opt = new OutPutOneToMaxNDigits2();
        opt.outPutOneToMaxNDigits(2);
         
    }
}