package com.ds.algo.array;

/*
@Author : Yogesh Deshmukh
*/

public class ArrayRotation {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        // Function calling
        printArray(rotateArrayUsingTempArray(arr, 2));
        printArray(rotateArrayUsingTempVariable(arr,2));
        printArray(rotateArrayUsingJugglingAlgorithm(arr, 2));
    }
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static int[] rotateArrayUsingTempArray(int[] arr, int d){

        //Time Complexity - O(n) and Space Complexity - O(d)
        int[] diff = new int[d];
        for(int i=0;i<d;i++){
            diff[i] = arr[i];
        }
        int i=0, k=0;
        for( i=d,k=i-d;i<arr.length;i++,k++){
            arr[k] = arr[i];
        }
        for(i=0;i<d;i++,k++)
            arr[k]=diff[i];
        return arr;
    }

    public static int[] rotateArrayUsingTempVariable(int[] arr, int d){
        //Time Complexity - O(n*d) and Space Complexity - O(1)
        while(d-- >0){
            int temp=arr[0];
            for(int i=1;i<arr.length;i++){
                arr[i-1] = arr[i];
            }
            arr[arr.length-1] = temp;
        }
        return arr;
    }


    public static int[] rotateArrayUsingJugglingAlgorithm(int[] arr, int d){
        //Time Complexity -> O(n) and space Compelxity -> O(1)
        int n= arr.length;
        int i=0,j=0,k=0, temp =0;
        int gcdVal = gcd(d,n);

        for(i=0;i< gcdVal;i++){
            temp =arr[i];
            j=i;

            while(true){
                k = j+d;
                if(k>=n)
                    k=k-n;
                if(k==i) break;
                arr[j] = arr[k];
                j=k;
            }
            arr[j] = temp;
        }
        return arr;
    }

    private static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }

    public static int[] rotateArrayBlockSwapAlgorithm(int[] arr, int d){
        return null;
    }
}
