package muyanmoyang.swadoffer;

public class StringReplace {
	public static void main(String[] args) {
		StringReplace sr = new StringReplace() ;
		StringBuffer sb = new StringBuffer() ;
		sb.append(" ") ;
		sb.append("rewq") ;
		sb.append(" ") ;
		sb.append("grewgtrb") ;
		sb.append(" ") ;
		String str = sr.replaceSpace(sb) ;
		System.out.println(str);
	}
	 public String replaceSpace(StringBuffer str) {
    	 if(str == null){
			 System.out.println("×Ö·û´®Îª¿Õ......") ;
		 }
		 for(int i=0; i<str.length(); i++){
			 char tmp = str.charAt(i) ;
			 if(tmp == ' '){
				 str.replace(i,i+1, "%20") ;
			 }
		 }
		 return str + "" ;
    }
}
