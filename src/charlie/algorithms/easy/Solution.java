/* Solved Problems
 * [344. Reverse String]
 * [292. Nim Game]
 * [258. Add Digits]
 * [104. Maximum Depth of Binary Tree]
 * [226. Invert Binary Tree]
 * 
 */
package charlie.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

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
		int[] num = {1,1,1};
		System.out.println(s.rob(num));		
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
	
	/**
	 * [231. Power of Two]
	 * Created On 2016年7月9日  下午8:51:26
	 */
	public boolean isPowerOfTwo(int n) {
		if(n <= 0 || (n&(n-1)) != 0){
			return false;
		}
		return true;
	}
	
	/**
	 * [206. Reverse Linked List]
	 * Created On 2016年7月10日  下午4:00:26
	 */
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		while(head != null){
			ListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		return pre;
	}
	
	/**
	 * [191. Number of 1 Bits]
	 * Created On 2016年7月10日  下午4:19:53
	 */
	public int hammingWeight(int n) {
		int count = 0;
		while(n != 0){
			n = n & (n - 1);
			count ++;
		}
		return count;
	}
	
	/**
	 * [235. Lowest Common Ancestor of a Binary Search Tree]
	 * Created On 2016年7月10日  下午4:47:59
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val < root.val && q.val < root.val){
			root = lowestCommonAncestor(root.left,p,q);
		}
		if(p.val > root.val && q.val > root.val){
			root = lowestCommonAncestor(root.right,p,q);
		}
		return root;
	}
	
	/**
	 * [263. Ugly Number]
	 * Created On 2016年7月10日  下午5:14:04
	 */
	public boolean isUgly(int num) {
		while(num > 1 && num % 2 == 0){
			num = num / 2;
		}
		while(num > 1 && num % 3 == 0){
			num = num / 3;
		}
		while(num > 1 && num % 5 == 0){
			num = num / 5;
		}
		return num == 1 ;
	}
	
	/**
	 * [83. Remove Duplicates from Sorted List]
	 * Created On 2016年7月10日  下午5:32:26
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null){
			if(cur.val != pre.val){
				pre = cur;
			}else{
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return head;
	}
	
	/**
	 * [70. Climbing Stairs]
	 * Created On 2016年7月10日  下午5:46:09
	 */
	public int climbStairs(int n) {
		int t1 = 1;
		int t2 = 2;
		int t = 3;
		int t3 = 0;
		if(n == 1){
			return t1;
		}else if(n == 2){
			return t2;
		}else{
			while(t < n){
				t3 = t1 + t2;
				t1 = t2;
				t2 = t3;
			}
			return t3;
		}
	}
	
	/**
	 * [121. Best Time to Buy and Sell Stock]
	 * Created On 2016年7月10日  下午6:07:02
	 */
	public int maxProfit(int[] prices) {
		int profit = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			}
			profit = (prices[i] - min > profit) ? prices[i] - min : profit;
		}
		return profit;
	}
	
	/**
	 * [141. Linked List Cycle]
	 * Created On 2016年7月10日  下午6:53:51
	 */
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null){
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next.next;
		while(fast != null){
			if(slow == fast){
				return true;
			}else{
				slow = slow.next;
				if(fast.next == null){
					return false;
				}else{
					fast = fast.next.next;
				}
				
			}
		}
		return false;
	}
	
	/**
	 * [21. Merge Two Sorted Lists]
	 * Created On 2016年7月10日  下午7:05:19
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		head.next = null;
		ListNode temp = head;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				temp.next = l1;
				l1 = l1.next;
			}else{
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		if(l1 != null) temp.next = l1;
		if(l2 != null) temp.next = l2;
		return head.next;
	}
	
	/**
	 * [345. Reverse Vowels of a String]
	 * Created On 2016年7月10日  下午7:21:54
	 */
	public String reverseVowels(String s) {
		if(s == null || s.length() == 0) return s;
		int len = s.length();
		int index = len - 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++){
			char ch = s.charAt(i);
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
					|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
				
				for(int j = index; j >= 0 ; j --){
					char rch = s.charAt(j);
					if(rch == 'a' || rch == 'e' || rch == 'i' || rch == 'o' || rch == 'u' 
							|| rch == 'A' || rch == 'E' || rch == 'I' || rch == 'O' || rch == 'U'){
						sb.append(rch);
						j --;
						index = j;
						break;
					}
				}
			}else{
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	/**
	 * [24. Swap Nodes in Pairs]
	 * Created On 2016年7月11日  下午8:05:05
	 */
	public ListNode swapPairs(ListNode head) {
		if(head == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode pre = head.next;
		ListNode cur = null;
		while(pre != null && pre.next != null){
			cur = pre.next;
			head.next = cur;
			pre.next = cur.next;
			cur.next = pre;
			head = pre;
			pre = pre.next;
		}
		return dummy.next;
	}
	
	/**
	 * [198. House Robber]
	 * Created On 2016年7月11日  下午8:38:35
	 */
	public int rob(int[] nums) {
		int rob = 0; //max monney can get if rob current house
		int notrob = 0; //max money can get if not rob current house
		for(int i=0; i<nums.length; i++) {
			int currob = notrob + nums[i]; //if rob current value, previous house must not be robbed
			notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
			rob = currob;
		}
		return Math.max(rob, notrob);
	}
	
	
	/**
	 * [342. Power of Four]
	 * Created On 2016年7月12日  下午8:40:33
	 */
	public boolean isPowerOfFour(int num) {
		if(num <= 0 ||(num & (num - 1)) != 0){
			return false;
		}else{
			int count = 0;
			while(num != 1){
				count++;
				num = num >> 1;
			}
			if(count % 2 == 0){
				return true;
			}else{
				return false;
			}
		}
	}
	
	/**
	 * [27. Remove Element]
	 * Created On 2016年7月12日  下午9:29:51
	 */
	public int removeElement(int[] nums, int val) {
		int index = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val){
				nums[index] = nums[i];
				index ++;
			}
		}
		return index;
	}
	
	
	/**
	 * [66. Plus One]
	 * Created On 2016年7月12日  下午9:37:41
	 */
	public int[] plusOne(int[] digits) {
		List<Integer> list = new ArrayList<>();
		int bit = 1;
		for(int i = digits.length - 1; i >=0 ; i --){
			if(digits[i] + bit > 9){
				list.add(digits[i] + bit - 10);
				bit = 1;
			}else{
				list.add(digits[i] + bit);
				bit = 0;
			}
		}
		if(bit == 1) list.add(bit);
		int[] nums = new int[list.size()];
		for(int i = 0; i < list.size(); i++){
			nums[i] = list.get(list.size() - i - 1);
		}
		return nums;
	}
	
	/**
	 * [101. Symmetric Tree]
	 * Created On 2016年7月13日  下午9:21:30
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return isMirror101(root.left, root.right);
	}
	
	public boolean isMirror101(TreeNode p,TreeNode q){
		if(p == null && q == null) return true;
		if(p != null && q != null){
			return p.val == q.val && isMirror101(p.left,q.right) && isMirror101(p.right, q.left);
		}
		return false;
	}
	
	/**
	 * [110. Balanced Binary Tree]
	 * Created On 2016年7月13日  下午9:42:01
	 */
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}else{
			if (Math.abs(height110(root.left) - height110(root.right)) <= 1){
				return false;
			}else{
				return isBalanced(root.left) && isBalanced(root.right);
			}
		}
	}
	
	public int height110(TreeNode root){
		if(root == null) {
			return 0;
		}
		else{
			int lh = height110(root.left);
			int rh = height110(root.right);
			return lh > rh ? lh + 1: rh + 1;
		}
	}
	
}

