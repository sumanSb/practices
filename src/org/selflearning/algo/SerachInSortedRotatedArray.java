package org.selflearning.algo;

public class SerachInSortedRotatedArray {
	public static void main(String[] args) {
		int[] array = {4};
		int target = 5;
		int res = new SerachInSortedRotatedArray().search(array, target);
		System.out.println("Result => "+res);
		
	}

    public int search(int[] nums, int target) {//4,5,6,7,0,1,2
    	 int n = nums.length-1;
         int p = getPivot(nums,0,n);
         
         if(p==-1){
             return binarySearch(nums,0,n,target);
         }
         if(nums[p]==target){
             return p;
         }
         if(nums[0]<=target){
             return binarySearch(nums,0,p-1,target);
         }
         return binarySearch(nums,p+1,n,target);
        
    }
    public int binarySearch(int[] nums, int l, int r, int target){
        int mid =0;//1,2,3,4,5
        if(l>r){
            return -1;
        }
        while(l<=r){
            mid= (l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(target>nums[mid]){
                l=mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return -1;
     }
     public int getPivot(int[] nums, int l , int r){//4,5,6,7,0,1,2
        int mid =0;
     	if(l==r)
     		return l;
     	if(r<l)
     		return -1;
     	while(l<=r) {
     		mid = (l+r)/2;
     		if(mid<r && nums[mid]>nums[mid+1]) {
     			return mid;
     		}
     		if(mid>l && nums[mid]<nums[mid-1]) {
     			return mid-1;
     		}
     		if(nums[l]>=nums[mid]) {
     			r = mid-1;
     		}
     		else
     			l = mid+1;
     	}
     	
         return -1;
     
     }
     
}
