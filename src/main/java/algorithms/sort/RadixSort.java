package algorithms.sort;

import java.util.Scanner;

public class RadixSort {
	
	public static void main(String[] args){
		int a[];
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		a = new int[n];
		
		for (int i = 0; i < n; i++){
			a[i] = scanner.nextInt();
		}
		
		sort(a,2);
		print(a);
	}
	
	public static void sort(int[] a, int d){  //d����������λ��
		
		int n = 1;	//LSD: least significant digit
		int[][] temp = new int[10][a.length];  //��һά��ʾ����0-9
		int[] order = new int[10];  //order[i]��ʾ��λ��i�����ĸ���
		
		for (int m = 0; m < d; m++){	//�ؼ���λ
			for (int i = 0; i < a.length; i++){
				int lsd = (a[i]/n)%10;
				temp[lsd][order[lsd]] = a[i];
				order[lsd]++;
			}
			int k = 0;
			for (int i = 0; i < 10; i++){
				if (order[i] != 0){
					for (int j = 0; j < order[i]; j++){
						a[k] = temp[i][j];	//��a[]���ݹؼ���λ��������
						k++;
					}
				}
				order[i] = 0;
			}
			n*=10;
		}
	}
	
	public static void print(int a[]){  
        for(int i=0; i<a.length; i++){  
            System.out.print(a[i]+" ");  
        }  
        System.out.println("");
	}
}
