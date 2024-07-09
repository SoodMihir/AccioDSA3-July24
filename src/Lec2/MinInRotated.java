package Lec2;

//Java program to find minimum element in a sorted and
//rotated array
import java.io.*;
import java.lang.*;
import java.util.*;

class Solution
{
 static int findMin(int arr[], int lo, int hi)
 {
     if(arr.length==1){
        return arr[0]; 
     } else if(arr[lo]<arr[hi]){
         // array is already sorted
         return arr[0];
     }

     while(lo<=hi){
         int mid = lo + (hi-lo)/2;
         // is mid the greatest? -> mid+1 is the smallest
         if(arr[mid]>arr[mid+1]){
             return arr[mid+1];
         }

         // is mid the smallest? mid-1 is the greatest
         else if(arr[mid]<arr[mid-1]){
             return arr[mid];
         }

         // is left side sorted
         // Minimum will be in non sorted part
         else if(arr[0]<arr[mid]){
             lo = mid+1;
         } else {
             // right side is sorted -> ans is in left side
             hi = mid-1;
         }
     }
     return -1;
 }
}
class Main {
 

 // Driver Program
 public static void main(String[] args)
 {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int arr[] = new int[n];
     for(int i=0; i<n; i++)
     arr[i] = sc.nextInt();
     System.out.println(Solution.findMin(arr, 0, n - 1));
 }
}