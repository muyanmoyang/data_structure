package muyanmoyang.swadoffer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * 打印1到最大的n位数 这里有个陷阱即n可能很大，会溢出
 */
public class OutPutOneToMaxNDigits2 {
 
    public void outPutOneToMaxNDigits(int n) {
        // 用nlist表示数n,nlist[0]表示n的最低位
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            nlist.add(0);
        }
        increment(nlist);
    }
 
    // 使数字每次+1然后输出
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
    // 输出数字，去掉最高位的0
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
    // 输出数字，将高位的0舍掉
    public void output(ArrayList<Integer> nlist) {
        Iterator<Integer> ite = nlist.iterator();
        int num;
        // 找到第一个为0的位置
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