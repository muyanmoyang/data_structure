package muyanmoyang.swadoffer;


/**
 * LCS：最大公共子序列
 * 
 * @author hadoop
 * 
 */
public class LCS {
	public static void main(String[] args) throws InterruptedException {
		String s1 = "ABCBDAB";
		String s2 = "BDCABA";
		StringBuffer result = LCS(s1, s2);
		System.out.println(result.reverse());
	}

	public static StringBuffer LCS(String s1, String s2) throws InterruptedException {
		int[][] matrix_lcs = new int[s1.length() + 1][s2.length() + 1];
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		int sum = 0;
		for (int i = 0; i <= ch1.length; i++) {
			for (int j = 0; j <= ch2.length; j++) {
				if (i == 0 || j == 0) {
					matrix_lcs[i][j] = 0;
				} else if (ch1[i-1] == ch2[j-1]) {
					matrix_lcs[i][j] = matrix_lcs[i - 1][j - 1] + 1;
				} else {
					if (matrix_lcs[i][j - 1] < matrix_lcs[i - 1][j]) {
						matrix_lcs[i][j] = matrix_lcs[i - 1][j];
					} else {
						matrix_lcs[i][j] = matrix_lcs[i][j - 1];
					}
				}
			}
		}
		/*
		 * 打印二维数组
		 */
		for (int i = 0; i < matrix_lcs.length; i++) {
			for (int j = 0; j < matrix_lcs[i].length; j++) {
				System.out.print(matrix_lcs[i][j] + " ");
			}
			System.out.println();
		}
		/*
		 * 从二维数组中找出LCS
		 */
		// String result = "" ;
		StringBuffer result = new StringBuffer();
		int i = matrix_lcs.length - 1;
		int j = matrix_lcs[0].length - 1;
		System.out.println("i=" + i + "///// j=" + j) ;
		for (;j >= 1 && i >= 1;) {
			System.out.println(ch1[i-1] + " : " + ch2[j-1]) ;
//			Thread.sleep(1000) ;
			if (ch1[i-1] == ch2[j-1]) {
				result.append(ch1[i-1]);
				i -- ;
				j -- ;
			} else{
				if (matrix_lcs[i][j-1] > matrix_lcs[i-1][j]){
					j--;
				}
//				if(matrix_lcs[i][j-1] == matrix_lcs[i-1][j]){
//					j -- ;
//				}
				else{
					i--;
				}
			}
		}
		return result;
	}
}
