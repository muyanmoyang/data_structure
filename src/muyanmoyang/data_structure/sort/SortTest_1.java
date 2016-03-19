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
	//ѡ������
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
	//��������
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
	//ϣ������
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
			System.out.print(a[i] + "��");
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
	
	//������
	public static void buildHeap(int[] data , int lastIndex)
	{
		for(int i=(lastIndex-1)/2 ; i>=0 ; i--)//��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ 
		{
			int k = i ;//k���������жϵĽڵ� 
			while(k*2+1 <= lastIndex) //�����ǰk�ڵ���ӽڵ����  
			{
				int biggerIndex = k*2 + 1 ; //k�ڵ�����ӵ����� 
				if(biggerIndex < lastIndex)//���biggerIndexС��lastIndex����biggerIndex+1�����k�ڵ���Һ��Ӵ���
				{
					if(data[biggerIndex] < data[biggerIndex+1]) //�������ӽڵ��ֵ�ϴ�  
					{
						biggerIndex++;  //biggerIndex���Ǽ�¼�ϴ��ӽڵ������  
					}
				}
				if(data[k] < data[biggerIndex]) //���k�ڵ��ֵС����ϴ���ӽڵ��ֵ 
				{
					swap(data,k,biggerIndex) ;//��������  
					k = lastIndex ;//��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ 
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
		System.out.println("ԭ����:" + Arrays.toString(a)); 
		int arrayLength=a.length;  
		//ѭ������  
		for(int i=0;i<arrayLength-1;i++){  
			//����  
			buildHeap(a,arrayLength-1-i);  
			//�����Ѷ������һ��Ԫ��  
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
