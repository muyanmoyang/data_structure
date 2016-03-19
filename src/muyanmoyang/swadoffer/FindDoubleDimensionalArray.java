package muyanmoyang.swadoffer;

public class FindDoubleDimensionalArray {
	public static void main(String[] args) {
		FindDoubleDimensionalArray f = new FindDoubleDimensionalArray() ;
		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}} ; 
		System.out.println(f.Find(array, 1)) ;
	}
	public boolean Find(int [][] array,int target) {
		int rows = array.length ; // 二维数组的行数
		int columns = array[0].length ; // 二维数组的列数
		boolean find = false ;
		if(array!=null && rows >0 && columns>0){
			int row = 0 ;
			int column = columns-1 ;
			while(row < rows && column >=0){
				int tmpValue = array[row][column] ;
				if(target > tmpValue){
					++ row ;
				}else if(target < tmpValue){
					-- column ;
				}else{
					find = true ;
					break ;
				}
			}
		}
		return find ;
	}
}
