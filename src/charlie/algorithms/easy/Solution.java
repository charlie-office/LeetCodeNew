/* Solved Problems
 * [344. Reverse String]
 * [292. Nim Game]
 * [258. Add Digits]
 * [104. Maximum Depth of Binary Tree]
 * [226. Invert Binary Tree]
 * 
 */
package charlie.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author charlie
 * @since 2016年6月26日
 * @version 1.0
 * 
 */
public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = {0,1,0,3,12};
		for(int n : nums){
			System.out.println(n);
		}
		s.moveZeroes(nums);
		for(int n : nums){
			System.out.println(n);
		}
		
	}
	
	
	/**
	 * [344. Reverse String]
	 * Created On 2016年6月26日  下午7:31:06
	 */
	public String reverseString(String s) {
		if(s == null || s.length() == 0){
			return s;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--){
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	/**
	 * [344. Reverse String]
	 * Created On 2016年6月26日  下午7:31:06
	 */
	public String reverseString_StringAPI(String s) {
		if(s == null || s.length() == 0){
			return s;
		}
		return new StringBuilder(s).reverse().toString();
	}
	
	/**
	 * [292. Nim Game]
	 * Created On 2016年6月26日  下午7:52:53
	 */
	public boolean canWinNim(int n){
		if(n % 4 == 0) return false;
		else return true;
	}
	
	/**
	 * [258. Add Digits]
	 * Created On 2016年6月26日  下午7:59:18
	 */
	public int addDigits(int num) {
		int mod = num % 9;
		return (num == 0)? 0 : ((mod == 0)? 9 : mod + 1); 
	}
	
	/**
	 * [104. Maximum Depth of Binary Tree]
	 * Created On 2016年6月26日  下午8:10:29
	 */
	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return (left > right)? left + 1: right + 1;
	}
	
	/**
	 * [226. Invert Binary Tree]
	 * Created On 2016年6月26日  下午8:27:03
	 */
	public TreeNode invertTree(TreeNode root) {
		if(root == null) 
			return root;
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	
	/**
	 * [283. Move Zeroes]
	 * Created On 2016年6月27日  下午7:49:00
	 */
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length == 0)
			return ;
		int left = 0;
		int right = nums.length - 1;
		while(left < right){
			while(left < nums.length && nums[left] != 0){
				left ++;
			}
			while(right >= 0 && nums[right] == 0){
				right --;
			}
			if(left < right){
				for(int i = left; i < right ; i++){
					nums[i] = nums[i + 1];
				}
				nums[right] = 0;
			}
		}
	}
	
	/**
	 * [349. Intersection of Two Arrays]
	 * Created On 2016年6月27日  下午8:46:18
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0)
			return nums1;
		if(nums2 == null || nums2.length == 0)
			return nums2;
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		for(int n : nums1){
			if(!set1.contains(n)){
				set1.add(n);
			}
		}
		for(int n : nums2){
			if(set1.contains(n)){
				set2.add(n);
			}
		}
		int[] nums = new int[set2.size()];
		int i = 0;
		for(int n : set2){
			nums[i] = n;
			i ++;
		}
		return nums;
	}
	
	
	/**
	 * [100. Same Tree]
	 * Created On 2016年6月27日  下午9:21:26
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		if(p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		else
			return false;
	}
	
	/**
	 * [242. Valid Anagram]
	 * Created On 2016年6月27日  下午9:33:26
	 */
	public boolean isAnagram(String s, String t) {
		int slen = 0;
		int tlen = 0;
		if(s == null || s.length() == 0)
			slen = 0;
		else
			slen = s.length();
		if(t == null || t.length() == 0)
			tlen = 0;
		else 
			tlen = t.length();
		if(slen == 0 && tlen == 0)
			return true;
		if(slen != tlen)
			return false;
		HashMap<Character,Integer> map = new HashMap<>();
		for(char ch : s.toCharArray()){
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch) + 1);
			}else{
				map.put(ch, 1);
			}
		}
		for(char ch : t.toCharArray()){
			if(map.containsKey(ch)){
				if(map.get(ch) - 1 == 0){
					map.remove(ch);
				}
				else {
					map.put(ch, map.get(ch) - 1);
				}
			}
		}
		return map.size() > 0 ? false : true;
	}
	
	/**
	 * [171. Excel Sheet Column Number]
	 * Created On 2016年6月28日  下午9:13:59
	 */
	public int titleToNumber(String s) {
		int num = 0;
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			num = num * 26 +  (ch - 'A' + 1);
		}
		return num;
	}
	
	/**
	 * [169. Majority Element]
	 * Created On 2016年6月28日  下午9:19:37
	 */
	public int majorityElement(int[] nums) {
		int n = 0;
		int count = 0;
		int mid = nums.length / 2;
		for(int num:nums){

			if(count == 0){
				n = num;
				count ++;
			}else if(n == num){
				count ++;
			}else if(n != num){
				count --;
			}
			
			if(count > mid )
				return n;
		}
		return n;
	}
	
	/**
	 * [217. Contains Duplicate]
	 * Created On 2016年7月5日  下午4:21:23
	 */
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0)
			return false;
		Arrays.sort(nums);
		if(nums.length == 1)
			return false;
		int temp = nums[0];
		for(int i = 1; i < nums.length; i++){
			if(nums[i] != temp){
				temp = nums[i];
			}else{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * [350. Intersection of Two Arrays II]
	 * Created On 2016年7月5日  下午4:35:19
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int n : nums1){
			if(map.containsKey(n)){
				map.put(n,map.get(n) + 1);
			}else{
				map.put(n,1);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int n : nums2){
			if(map.containsKey(n)){
				if(map.get(n) > 1){
					list.add(n);
					map.put(n, map.get(n) - 1);
				}else{
					list.add(n);
					map.remove(n);
				}
			}
		}
		int[] rs = new int[list.size()];
		for(int i = 0; i < list.size(); i++){
			rs[i] = list.get(i);
		}
		return rs;
		
	}
}

