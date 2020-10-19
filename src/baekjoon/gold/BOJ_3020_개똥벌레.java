package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//백준_개똥벌레_3020_골드5
public class BOJ_3020_개똥벌레 {
	static int N, H;
	// bottom : 석순, top : 종유석
	static int[] bottom, count;
	static Integer[] top;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		bottom = new int[N / 2];
		top = new Integer[N / 2];
		count = new int[H+1];

		for (int i = 0; i < N / 2; i++) {
			bottom[i] = Integer.parseInt(br.readLine().trim());
			top[i] = Integer.parseInt(br.readLine().trim());
		}

		// 오름차순정렬
		Arrays.sort(bottom);
		// 내림차순정렬
		Arrays.sort(top, Collections.reverseOrder());
		
		int b=0;
		int t=0;
		int min_count=N/2;
		for (int i = 1; i <= H; i++) {
			while(b<N/2&&bottom[b]<i) {
				b++;
			}
			while(t<N/2&&H-top[t]<i) {
				t++;
			}
			count[i]=N/2-b+t;
			min_count = Math.min(min_count, count[i]);
		}
		
		int num = 0;
		for (int i = 1; i <= H; i++) {
			if(min_count==count[i]) {
				num++;
			}
		}
		System.out.println(min_count+" "+num);
	}
}

//내일 공부

//import java.io.*;
//import java.util.*;
//class Main{
//    public static void main(String[] args)throws Exception{
//    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer reader=new StringTokenizer(br.readLine());
//    	int n=Integer.parseInt(reader.nextToken());
//    	int h=Integer.parseInt(reader.nextToken());
//    	int[] down=new int[h+1];   	
//    	for(int i=0;i<n;i++){
//            int j=Integer.parseInt(br.readLine());
//    		if(i%2==0){
//    			down[h-j]--;
//    		}else{
//    			down[j]++;
//    		}
//    	}
//    	int min=down[h]+(n/2);    	
//    	int count=1;
//    	for(int i=1,k=min;i<h;i++){
//            k+=down[h-i];            
//    		if(min>k){
//    			min=k;
//    			count=1;    			
//    		}else if(min==k){
//    			count+=1;
//    		}
//    	}
//    	System.out.print(min+" "+count);
//    }
//}
