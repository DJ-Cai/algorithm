package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class LC354_����˹�����ŷ� {
	
	public static void main(String[] args) {
		int res = maxEnvelopes(new int[][] {{5,4},{6,4},{6,7},{2,3}});
		System.out.println(res);
	}
    public static int maxEnvelopes(int[][] envelopes) {
    	if(envelopes == null ||  envelopes.length == 0 ||envelopes[0].length == 0 ){
            return 0;
        }

        //���������������к��񣬾������˸���
        //�����������򣬸߰��������������Ը�Ϊ��׼�������������
        //��õ���ǰ����ϱ�׼���ŷ⣬���ܷŽ�������ϱ�׼���ŷ��У�������������ǽ�
        //[PS:ע�Ͳ�������debug���̣�һ��ʼ��Ϊ����ֵӦ����4�����������̶���ӡ�����ˣ�����Ҫ���������]

        //1�������鰴�������ά�Ƚ�������
        Arrays.sort(envelopes , new Comparator<int[]>(){
            public int compare(int[] a1 , int[] a2){
                //����Ȱ��߽����ţ����Ȱ���������
                return a1[0] == a2[0] ? a2[1] - a1[1] : a1[0] - a2[0];
            }
        });
//        for(int i = 0 ; i < envelopes.length ; i++) {
//        	System.out.println("envelopes["+i+"] :" + envelopes[i][0] + " " + envelopes[i][1]);
//        }
        
        
        //2���ź����Ժ󣬰������������������
        int[] temp = new int[envelopes.length];
        for(int i = 0 ; i < temp.length ; i++){
            temp[i] = envelopes[i][1];
        }
//        for(int i = 0 ; i < temp.length ; i++) {
//        	System.out.println("temp[" + i + "] : " + temp[i]);
//        }
        return Longest(temp);


    }

    public static int Longest(int[] arr){
        if(arr == null || arr.length == 0){
            return 0 ;
        }
        //���壺�Ե�ǰԪ��Ϊ��β������������еĳ���
        int[] temp = new int[arr.length];
        //ע���1������������У����Ϊ�Լ�һ��Ԫ�أ����г�ʼ��Ϊ1 
        Arrays.fill(temp,1);
        
        for(int i = 1 ; i < arr.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[i] > arr[j]){
                    temp[i] = Math.max(temp[i],temp[j] + 1);
                }
            }
        }
        //ע���2���������ǵĶ��壬����temp���鸳ֵ��ɺ���Ҫ���������ֵ
        int res = 0 ;
        for(int i = 0 ; i < temp.length ; i++) {
        	// System.out.println("temp[" + i + "] : " + temp[i]);
        	res= Math.max(res, temp[i]);
        }
        return res;
    }
}
