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
import java.util.Map;
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
		int[] nums1 = {1,0,0,0};
		int[] nums2 = {3,5,6};
		s.merge(nums1, 1, nums2, 3);
		for(int num : nums1){
			System.out.println(num);
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
			if (Math.abs(height110(root.left) - height110(root.right)) > 1){
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
	
	
	/**
	 * [118. Pascal's Triangle]
	 * Created On 2016年7月14日  下午2:37:35
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i < numRows; i++){
			List<Integer> temp = new ArrayList<>();
			if(i == 0){
				temp.add(1);
			}else{
				List<Integer> pre = (List<Integer>)list.get(i - 1);
				temp.add(1);
				for(int j = 1; j < pre.size(); j++){
					temp.add(pre.get(j) + pre.get(j - 1));
				}
				temp.add(1);
			}
			list.add(temp);
		}
		return list;
	}
	
	/**
	 * [119. Pascal's Triangle II]
	 * Created On 2016年7月14日  下午2:50:16
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i <= rowIndex; i++){
			
			if(i == 0){
				list.add(1);
			}else{
				for(int j = list.size() - 1; j >= 1; j--){
					list.set(j, list.get(j) + list.get(j - 1));
				}
				list.add(1);
			}
		}
		return list;
	}
	
	/**
	 * [172. Factorial Trailing Zeroes]
	 * Created On 2016年7月14日  下午3:44:48
	 */
	public int trailingZeroes(int n) {
		int count = 0;
		while(n >= 5){
			n /= 5;
			count += n;
		}
		return count;
	}
	
	/**
	 * [374. Guess Number Higher or Lower]
	 * Created On 2016年7月14日  下午3:45:27
	 */
	public int guessNumber(int n) {
		int left = 1;
		int right = n;
		
		while(left <= right){
			int mid = left + (right - left)/2;
			if(guess(mid) == 0){
				return mid;
			}else if(guess(mid) == -1){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return left;
	}
	
	public int guess(int num){
		return -1;
	}
	
	/**
	 * [112. Path Sum]
	 * Created On 2016年7月17日  下午5:18:16
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null){
			return false;
		}
		if(root.val == sum && root.left == null && root.right == null){
			return true;
		}else{
			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		}
	}
	
	/**
	 * [9. Palindrome Number]
	 * Created On 2016年7月17日  下午5:47:10
	 */
	public boolean isPalindrome(int x) {
		if(x < 0) 
			return false;
		else if( x < 10) 
			return true;
		else{
			int num = 0;
			int tmp = x;
			while(tmp >= 10){
				num = num * 10 + tmp % 10;
				tmp = tmp / 10;
			}
			num = num * 10 + tmp;
			if(num == x) return true;
			else return false;
		}
	}
	
	/**
	 * [36. Valid Sudoku]
	 * Created On 2016年7月17日  下午6:07:24
	 */
	public boolean isValidSudoku(char[][] board) {
		int[] count = new int[9];
		for(int i = 0; i < 9; i ++){
			Arrays.fill(count, 0);
			for(int j = 0; j < 9; j ++){
				if(board[i][j] <= '9' && board[i][j] >= '1'){
					if(count[board[i][j] - '1'] == 1){
						return false;
					}else{
						count[board[i][j] - '1'] = 1;
					}
				}
			}
		}
		
		for(int i = 0; i < 9; i ++){
			Arrays.fill(count, 0);
			for(int j = 0; j < 9; j ++){
				if(board[j][i] <= '9' && board[j][i] >= '1'){
					if(count[board[j][i] - '1'] == 1){
						return false;
					}else{
						count[board[j][i] - '1'] = 1;
					}
				}
			}
		}
		
		for(int i = 0; i < 9; i ++){
			Arrays.fill(count, 0);
			for(int j = 0; j < 9; j ++){
				int row = (i/3) * 3 + j/3;
				int col = (i%3) * 3 + j%3;
				if(board[row][col] <= '9' && board[row][col] >= '1'){
					if(count[board[row][col] - '1'] == 1){
						return false;
					}else{
						count[board[row][col] - '1'] = 1;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * [111. Minimum Depth of Binary Tree]
	 * Created On 2016年7月18日  下午9:11:29
	 */
	public int minDepth(TreeNode root) {
		if(root == null){
			return 0;
		}else{
			return minDepth111(root);
		}
	}
	
	public int minDepth111(TreeNode root){
		if(root.left == null && root.right == null){
			return  1;
		}else if(root.left == null){
			return minDepth(root.right) + 1;
		}else if(root.right == null){
			return minDepth(root.left) + 1;
		}else{
			int lh = minDepth(root.left);
			int rh = minDepth(root.right);
			return lh < rh ? lh + 1 : rh + 1;
		}
	}
	
	/**
	 * [299. Bulls and Cows]
	 * Created On 2016年7月18日  下午9:43:46
	 */
	public String getHint(String secret, String guess) {
		int[] snum = new int[10];
		int[] gnum = new int[10];
		int bull = 0;
		int cow = 0;
		char[] s = secret.toCharArray();
		char[] g = guess.toCharArray();
		for(int i = 0; i < s.length; i ++){
			if(s[i] == g[i]){
				bull ++;
			}else{
				snum[s[i] - '0'] ++;
				gnum[g[i] - '0'] ++;
			}
		}
		
		for(int i = 0; i < 10; i++){
			int min = snum[i] < gnum[i] ? snum[i] : gnum[i];
			cow += min;
		}
		
		return bull + "A" + cow + "B";
	}
	
	
	/**
	 * [205. Isomorphic Strings]
	 * Created On 2016年7月19日  下午3:48:21
	 */
	public boolean isIsomorphic(String s, String t) {
		Map<Character,Character> map = new HashMap<>();
		char[] sch = s.toCharArray();
		char[] tch = t.toCharArray();
		for(int i = 0; i < sch.length; i ++){
			if(!map.containsKey(sch[i]) && !map.containsValue(tch[i])){
				map.put(sch[i], tch[i]);
			}else if(map.containsKey(sch[i]) && map.containsValue(tch[i]) && map.get(sch[i]) == tch[i]){
				
			}else{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * [219. Contains Duplicate II]
	 * Created On 2016年7月19日  下午4:31:29
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], i);
			} else {
				if(i - map.get(nums[i]) <= k){
					return true;
				}else{
					map.put(nums[i], i);
				}
			}
		}
		return false;
	}
	
	
	/**
	 * [223. Rectangle Area]
	 * Created On 2016年7月19日  下午4:54:18
	 */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int lx = Math.max(A, E);
		int ly = Math.max(B, F);
		int rx = Math.min(C, G);
		int ry = Math.min(D, H);
		
		int area1 = (C - A) * (D - B);
		int area2 = (H - F) * (G - E);
		int area3 = (rx - lx) * (ry - ly);
		if(lx >= rx || ly >= ry){
			area3 = 0;
		}
		return area1 + area2 - area3;
	}
	
	/**
	 * [168. Excel Sheet Column Title]
	 * Created On 2016年7月20日  下午8:48:27
	 */
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while(n != 0){
			sb.append((char)('A' + (n - 1)%26));
			n = (n - 1)/26;
		}
		return sb.reverse().toString();
	}
	
	/**
	 * [125. Valid Palindrome]
	 * Created On 2016年7月20日  下午9:18:38
	 */
	public boolean isPalindrome(String s) {
		if(s == null || s.length() <= 1) return true;
		char[] ch = s.toLowerCase().toCharArray();
		int left = 0;
		int right = ch.length - 1;
		while(left < right){
			while(left < right && !isAlphanumeric125(ch[left])){
				left ++;
			}
			while(right > left && !isAlphanumeric125(ch[right])){
				right --;
			}
			if(ch[left] != ch[right]){
				return false;
			}else{
				left ++;
				right --;
			}
		}
		return true;
	}
	public boolean isAlphanumeric125(char ch){
		if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
			return true;
		}
		return false;
	}
	
	/**
	 * [165. Compare Version Numbers]
	 * Created On 2016年7月20日  下午9:43:30
	 */
	public int compareVersion(String version1, String version2) {
		String[] vers1 = (version1).split("\\.");
		String[] vers2 = (version2).split("\\.");
		
		int index = 0;
		while(index < vers1.length && index < vers2.length){
			int v1 = Integer.valueOf(vers1[index]);
			int v2 = Integer.valueOf(vers2[index]);
			if(v1 < v2){
				return -1;
			}else if(v1 > v2){
				return 1;
			}
			index ++;
		}
		while(index < vers1.length){
			int v1 = Integer.valueOf(vers1[index]);
			if(v1 > 0){
				return 1;
			}
			index ++;
		}
		while(index < vers2.length){
			int v2 = Integer.valueOf(vers2[index]);
			if(v2 > 0){
				return -1;
			}
			index ++;
		}
		return 0;
	}
	
	
	/**
	 * [278. First Bad Version]
	 * Created On 2016年7月21日  上午10:17:10
	 */
	public int firstBadVersion(int n) {
	    int start = 1, end = n;
	    while (start < end) {
	        int mid = start + (end-start) / 2;
	        if (!isBadVersion(mid)) start = mid + 1;
	        else end = mid;            
	    }        
	    return start;
	}
	
	public boolean isBadVersion(int version){
		return false;
	}
	
	/**
	 * [160. Intersection of Two Linked Lists]
	 * Created On 2016年7月22日  下午3:25:08
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		ListNode a = headA;
		ListNode b = headB;
		while(a != b){
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		
		return a;
	}
	
	
	/**
	 * [88. Merge Sorted Array]
	 * Created On 2016年7月22日  下午3:39:11
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = 0;
		for(int i = 0; i < n; i++){
			for(; index < i + m; index++){
				if(nums2[i] < nums1[index]){
					break;
				}
			}
			
			for(int k = i + m; k > index; k--){
				nums1[k] = nums1[k - 1];
			}
			nums1[index] = nums2[i];
			index ++;
		}
	}
	
	/**
	 * [257. Binary Tree Paths]
	 * Created On 2016年7月22日  下午4:27:03
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		if(root != null) binaryTreePaths257(root,"",list);
		return list;
	}
	
	public void binaryTreePaths257(TreeNode root, String prefix, List<String> list){
		if(root.left == null && root.right == null) list.add(prefix + root.val);
		if(root.left != null) binaryTreePaths257(root.left, prefix + root.val + "->", list);
		if(root.right != null) binaryTreePaths257(root.right, prefix  + root.val + "->", list);
	}
	
	/**
	 * [290. Word Pattern]
	 * Created On 2016年7月22日  下午5:01:57
	 */
	public boolean wordPattern(String pattern, String str) {
		String[] s = str.split(" ");
		char[] ch = pattern.toCharArray();
		if(s.length != ch.length) return false;
		Map<Character, String> mapCh = new HashMap<>();
		Map<String, Character> mapS = new HashMap<>();
		for(int i = 0; i < s.length; i++){
			if(!mapCh.containsKey(ch[i]) && !mapS.containsKey(s[i])){
				mapCh.put(ch[i], s[i]);
				mapS.put(s[i], ch[i]);
			}else {
				if(mapCh.containsKey(ch[i]) ^ mapS.containsKey(s[i]))
				return false;
			}
		}
		return true;
	}
	
	/**
	 * [19. Remove Nth Node From End of List]
	 * Created On 2016年7月22日  下午5:34:12
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head != null) {
			if(removeNthFromEnd19(head, n) == n) head = head.next;
		}
		return head;
	}
	
	public int removeNthFromEnd19(ListNode node,int n){
		if(node.next == null){
			return 1;
		}else{
			int num = removeNthFromEnd19(node.next, n);
			if(num == n){
				node.next = node.next.next;
			}
			return ++num;
		}
	}
}

