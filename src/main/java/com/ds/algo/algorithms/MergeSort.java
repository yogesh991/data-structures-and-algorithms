package com.ds.algo.algorithms;/* 
@Author : Yogesh Deshmukh
*/


/* Merge Sort ->  Divide and Conquer Algorithm
*
* Time Complexity -> O(nlogn) and Space Complexity -> O(n) for Arrays and O(1) in case of LinkedLists
*
* */
public class MergeSort {

    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void mergeSort(int []arr, int left, int right){
        if(right > left){
            int mid = (right+left)/2;

            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,left);

            merge(arr,left, mid, right);
        }
    }

    public static void merge(int arr[], int left, int middle, int right){
        int n1 = middle-left+1;
        int n2 = right-middle;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0;i<n1;i++)
            L[i]=arr[left+i];

        for(int j=0;j<n2;j++)
            R[j] = arr[middle + j + 1];

        int i=0,j=0,k=left;

        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = L[i];
            k++;
            i++;
        }

        while(j<n2){
            arr[k] = R[j];
            k++;
            j++;
        }

    }
}
