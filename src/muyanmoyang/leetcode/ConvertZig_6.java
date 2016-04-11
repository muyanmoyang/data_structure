package muyanmoyang.leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)
	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
 * @author hadoop
 *
 */
public class ConvertZig_6 {
	public static void main(String[] args) {
		ConvertZig_6 c = new ConvertZig_6() ;
		System.out.println(c.convert("PAYPALISHIRING",4)) ;
	}
	public String convert(String s, int numRows) {
		StringBuilder sb = new StringBuilder() ;
		if(s.equals("") || s.length()==0){
			return "" ;
		}
		if(numRows == 1 || numRows >= s.length()){
			return s ;
		}else{
			// 添加第一行
			for(int i=0; i<s.length(); i+=(2*numRows-2)){
				sb.append(s.charAt(i)) ;
			}
			if(numRows == 2){
				for(int i=numRows-1; i<s.length(); i+=(2*numRows-2)){
					sb.append(s.charAt(i)) ;
				}
			}
			if(numRows >2){
				for(int i=1; i<numRows-1; i++){ // 中间行
					int j = i;
					boolean flag = true ;
					sb.append(s.charAt(j)) ;
					while(true){
						if(flag){
							j += (numRows-i-1)*2 ;
							if(j<s.length()){
								sb.append(s.charAt(j)) ;
								flag = false ;
							}else{
								break ;
							}
						}else{
							j += i*2 ;
							if(j < s.length()){
								sb.append(s.charAt(j)) ;
								flag = true ;
							}else{
								break ;
							}
						}
					}
				}
				for(int i=numRows-1; i<s.length(); i+=(2*numRows-2)){
					sb.append(s.charAt(i)) ;
				}
			}
		}
		
		return sb.toString() ;
    }
}
