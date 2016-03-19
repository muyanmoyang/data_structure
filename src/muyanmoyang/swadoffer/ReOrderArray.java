package muyanmoyang.swadoffer;

/**
 * 调整数组的顺序，使所有奇数在偶数前面
 * 
 * @author hadoop
 * 
 */
public class ReOrderArray {
	public static void main(String[] args) {
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = i;
		}
		ReOrderArray r = new ReOrderArray();
		r.reOrderArray(array);
		for (int elem : array) {
			System.out.print(elem + "、");
		}
	}

	public void reOrderArray2(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			while (left < right && array[left] % 2 == 1) {
				left++;
			}
			while (left < right && array[right] % 2 == 0) {
				right--;
			}
			if (left < right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
			}
		}
	}

	public void reOrderArray(int[] array) {
		int[] even = new int[array.length];
		int count = 0;
		int evenCount = 0;
		int oddCount = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				array[oddCount++] = array[i];
			} else {
				even[evenCount] = array[i];
				evenCount++;
			}
		}
		for (int i = 0; i < evenCount; i++) {
			array[oddCount++] = even[i];
		}
	}
}
