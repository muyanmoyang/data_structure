package muyanmoyang.data_structure.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SortTest_1 {
	//选择排序
	public static void sort(int[] a)
	{
		for(int i=0; i<a.length ; i++)
		{
			int min = i ;
			for(int j=i+1; j<a.length ; j++)
			{
				if(a[j]<a[min])
				{
					min = j ;
				}
			}
			swap(a, i, min); 
		}
	}
	//插入排序
	public static void sort2(int[] a)
	{
		for(int i=1; i<a.length ; i++)
		{
			for(int j=i ;j>0 && less(a[j],a[j-1]); j--)
			{
				swap(a,j,j-1) ;
			}
		}
	}
	//希尔排序
	public static void sort3(int[] a)
	{
		int h = 1 ;
		while(h < a.length/3) 
		{
			h = 3*h + 1 ;
		}
		while(h >=1)
		{
			for(int i=h; i<a.length ; i++)
			{
				for(int j=i ;j>=h && (a[j]<a[j-h]); j-=h)
				{
					exch(a, j, j-h); 
				}
			}
			h = h/3 ;
		}
	}
	
	private static boolean less(int v, int w)
	{
		return  (v < w) ;
	}
	private static void exch(int[] a , int i, int j)
	{
		int t = a[i] ; 
		a[i] = a[j] ;
		a[j] = t ;
	}
	private static void show(int[] a)
	{
		for(int i=0; i<a.length ; i++)
		{
			System.out.print(a[i] + "、");
		}
		System.out.println();
	}
	public static boolean isSorted(int[] a)
	{
		for(int i=0; i<a.length ; i++)
		{
			if(less(a[i],a[i-1]))
			{
				return false ;
			}
		}
		return true ;
	}
	
	//堆排序
	public static void buildHeap(int[] data , int lastIndex)
	{
		for(int i=(lastIndex-1)/2 ; i>=0 ; i--)//从lastIndex处节点（最后一个节点）的父节点开始 
		{
			int k = i ;//k保存正在判断的节点 
			while(k*2+1 <= lastIndex) //如果当前k节点的子节点存在  
			{
				int biggerIndex = k*2 + 1 ; //k节点的左孩子的索引 
				if(biggerIndex < lastIndex)//如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右孩子存在
				{
					if(data[biggerIndex] < data[biggerIndex+1]) //若果右子节点的值较大  
					{
						biggerIndex++;  //biggerIndex总是记录较大子节点的索引  
					}
				}
				if(data[k] < data[biggerIndex]) //如果k节点的值小于其较大的子节点的值 
				{
					swap(data,k,biggerIndex) ;//交换他们  
					k = lastIndex ;//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值 
				}else
				{
					break ;
				}
			}
		}
	}

	private static void swap(int[] data, int i, int j) {  
		int tmp=data[i];  
		data[i]=data[j];  
		data[j]=tmp;  
	}
	
	public static ArrayList<Integer> generateRandomNum() throws IOException
	{
		FileWriter writer = new FileWriter(new File("H:/myeclipseWorkspace/data_structure/randomNum.txt")) ;
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		
		for(int i=0 ; i<10 ; i++)
		{
			list.add((int)(Math.random()*10000));
			writer.write(list.get(i)); 
			writer.flush();
		}
		writer.close(); 
		return list ;
	}
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis() ;
		ArrayList<Integer> list = generateRandomNum() ;
		int[] a = new int[list.size()];
		for(int i=0 ;i<list.size() ; i++)
		{
			a[i] = list.get(i) ;
		}
		System.out.println("原数组:" + Arrays.toString(a)); 
		int arrayLength=a.length;  
		//循环建堆  
		for(int i=0;i<arrayLength-1;i++){  
			//建堆  
			buildHeap(a,arrayLength-1-i);  
			//交换堆顶和最后一个元素  
			swap(a,0,arrayLength-1-i);  
			System.out.println(Arrays.toString(a));  
		}
		
//		sort(a) ;
//		assert isSorted(a) ;
//		show(a); 
		long end = System.currentTimeMillis() ;
		System.out.println("time :" + (end - start) + "ms");
	}
}
