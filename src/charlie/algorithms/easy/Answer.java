/* Included Problems
 * [344. Reverse String]
 * 
 */
package charlie.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author charlie
 * @since 2016年6月26日
 * @version 1.0
 * 
 */
public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * [No. 292]
	 * [Name. Nim Game]
	 * Created On 2016年6月26日  下午7:57:05
	 */
	public boolean canWinNim(int n) {
	    return (n % 4 != 0);
	}
	
	/**
	 * [283. Move Zeroes]
	 * Created On 2016年6月27日  下午8:42:41
	 */
	public void moveZeroes(int[] nums) {
		int i = 0;
		for (int d : nums) {
			if (d != 0) {
				nums[i++] = d;
			}
		}
		
		Arrays.fill(nums, i, nums.length, 0);
	}
	
	/**
	 * [100. Same Tree]
	 * Created On 2016年6月27日  下午9:31:46
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    /**
     * [169. Majority Element]
     * Created On 2016年6月28日  下午9:34:35
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }
        int count = 1;
        int major = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != major){
                count--;
            } else {
                count++;
            }
            if (count == 0){
                major = nums[i];
                count = 1;
            }
        }
        return major;
    }
    
    /**
     * [350. Intersection of Two Arrays II]
     * Created On 2016年7月5日  下午5:00:50
     */
	public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pnt1 = 0;
        int pnt2 = 0;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        while((pnt1 < nums1.length) &&(pnt2< nums2.length)){
            if(nums1[pnt1]<nums2[pnt2]){
                pnt1++;
            }
            else{
                if(nums1[pnt1]>nums2[pnt2]){
                    pnt2++;
                }
                else{
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }
        int[] res = new int[myList.size()];
        for(int i = 0; i<res.length; i++){
            res[i] = (Integer)myList.get(i);
        }
        return res;
	}

}