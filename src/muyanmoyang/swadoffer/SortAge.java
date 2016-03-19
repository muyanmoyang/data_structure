package muyanmoyang.swadoffer;

/*
 *  对一个公司上万名员工的年龄进行排序
 */
public class SortAge {
	public static void main(String[] args) throws Exception {
		int[] ages = new int[10000] ;
		for(int i=0 ;i<10000; i++){
			ages[i] = (int) ((Math.random())*100 + 1) ;
		}
		int length = ages.length ;
		sortAge(ages, length);
		printSortAge(ages) ;
	}
	private static void printSortAge(int[] ages) {
		// TODO Auto-generated method stub
		for(int elem : ages){
			System.out.print(elem + "、");
		}
	
	}
	private static void sortAge(int ages[] , int length) throws Exception{
		if(ages == null || length <=0){
			return ;
		}
		int oldestAge = 100 ;
		int[] timesOfAge = new int[10000] ;
		for(int i=0; i<oldestAge; i++){
			timesOfAge[i] = 0 ;
		}
		for(int i=0; i<ages.length; i++){
			int age = ages[i] ;
			if(age <= 0 || age > oldestAge){
				throw new Exception("invalid age...") ;
			}
			timesOfAge[age] ++ ;
		}
		int index = 0 ;
		for(int i=0 ;i<=oldestAge; i++){
			for(int j=0; j<timesOfAge[i]; j++){
				ages[index] = i ;
				index ++ ;
			}
		}
	}
}	
