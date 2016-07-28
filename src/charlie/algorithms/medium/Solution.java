package charlie.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author charlie
 * @since 2016年6月26日
 * @version 1.0
 * 
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.countBits(5)));
	}
	
	
	/**
	 * [338. Counting Bits]
	 * Created On 2016年7月24日  下午5:21:58
	 */
	public int[] countBits(int num) {
		int[] bits = new  int[num + 1];
		int offset = 1;
		for(int i = 1; i <= num; i++){
			if(offset  * 2 == i){
				offset = offset << 1;
			}
			bits[i] = 1 + bits[i - offset];
		}
		return bits;
	}
	
	/**
	 * [136. Single Number]
	 * Created On 2016年7月24日  下午6:12:24
	 */
	public int singleNumber136(int[] nums) {
		int num = 0;
		for(int n : nums) num ^= n;
		return num;
	}

	/**
	 * [137. Single Number II]
	 * Created On 2016年7月24日  下午6:51:28
	 */
	public int singleNumber137(int[] nums) {
		int[] bits = new int[32];  
		int res = 0;  
		for(int i=0; i < 32; i++){  
			for(int j=0; j < nums.length; j++){  
				bits[i] += (nums[j] >> i) & 1;
			}
			res |= (bits[i] % 3) << i;
		}  
		return res;
	}
	
	/**
	 * [260. Single Number III]
	 * The methods of get rightmost set bit: diff &= -diff ; diff &= ~(diff - 1);
	 * Created On 2016年7月24日  下午6:38:53
	 */
	public int[] singleNumber(int[] nums) {
		// Pass 1 : 
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		// Get its last set bit
		diff &= -diff;
		
		// Pass 2 :
		int[] rets = {0, 0}; // this array stores the two numbers we will return
		for (int num : nums)
		{
			if ((num & diff) == 0) // the bit is not set
			{
				rets[0] ^= num;
			}
			else // the bit is set
			{
				rets[1] ^= num;
			}
		}
		return rets;
	}
	
	/**
	 * [238. Product of Array Except Self]
	 * Created On 2016年7月24日  下午8:13:00
	 */
	public int[] productExceptSelf(int[] nums) {
		long sum = 1;
		int count = 0;
		int[] M = new int[nums.length];
		for(int n : nums){
			if(n == 0){
				count ++;
			}else{
				sum *= n;
			}
		}
		if(count > 1) return M;
		for(int i = 0; i < nums.length; i++){
			if(count == 1){
				if(nums[i] == 0) {
					M[i] = (int) sum;
				}
			}else{
				M[i] = (int)(sum / nums[i]);
			}
		}
		return M;
	}
	
	/**
	 * [122. Best Time to Buy and Sell Stock II]
	 * Created On 2016年7月24日  下午8:45:00
	 */
	public int maxProfit(int[] prices) {
		int profit = 0;
		for(int i = 1; i < prices.length; i++){
			if(prices[i] > prices[i - 1]){
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}
	
	/**
	 * [357. Count Numbers with Unique Digits]
	 * Created On 2016年7月25日  下午3:56:34
	 */
	public int countNumbersWithUniqueDigits(int n) {
		int[] f = new int[11];
		f[0] = 1;
		f[1] = 10;
		int sum = 9;
		for(int i = 2; i <= 10; i++){
			sum *= (11 - i);
			f[i] = sum + f[i - 1];
		}
		if(n < 11){
			return f[n];
		}else{
			return f[10];
		}
	}
	
	/**
	 * [347. Top K Frequent Elements]
	 * using Bucket Sort
	 * Created On 2016年7月25日  下午4:17:06
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		int maxFrequency = 0;

		for (int n : nums) {
			int frequency = frequencyMap.getOrDefault(n, 0) + 1;
			frequencyMap.put(n, frequency);
			maxFrequency = maxFrequency < frequency ? frequency : maxFrequency;
		}

		// here i is the frequency and bucket.get(i) is the numbers that having this frequency
		List<List<Integer>> bucket = new ArrayList<>(maxFrequency);
		while (maxFrequency-- >= 0) {
			bucket.add(new ArrayList<>());
		}

		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			int frequency = entry.getValue();
			bucket.get(frequency).add(entry.getKey());
		}

		List<Integer> res = new ArrayList<>();
		for (int pos = bucket.size() - 1; pos >= 0 && res.size() < k; pos--) {
			res.addAll(bucket.get(pos));
		}
		return res;
	}
	
	/**
	 * [343. Integer Break]
	 * Created On 2016年7月25日  下午5:20:24
	 */
	public int integerBreak(int n) {
		int result = 1;
		if(n == 2) return 1;
		if(n == 3) return 2;
		while(n >= 2){
			int num = 3;
			if(n == 4 || n == 2) num = n;
			result *= num;
			n -= num;
		}
		return result;
	}
	
	/**
	 * [268. Missing Number]
	 * Created On 2016年7月25日  下午6:11:56
	 */
	public int missingNumber(int[] nums) {
		int num = nums.length;
		for(int i = 0; i < nums.length; i++){
			num ^= i ^ nums[i];
		}
		return num;
	}
	
	/**
	 * [319. Bulb Switcher]
	 * Created On 2016年7月25日  下午6:28:18
	 */
	public int bulbSwitch(int n) {
		return (int)Math.sqrt(n);
	}
	
	/**
	 * [144. Binary Tree Preorder Traversal]
	 * Created On 2016年7月26日  下午2:17:27
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preorder114(list, root);
		return list;
	}
	
	public void preorder114(List<Integer> list, TreeNode root){
		if(root != null){
			list.add(root.val);
			preorder114(list, root.left);
			preorder114(list, root.right);
		}
	}
	
	/**
	 * [94. Binary Tree Inorder Traversal]
	 * Created On 2016年7月26日  下午2:40:31
	 */
	//Recursive
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorder94(list, root);
		return list;
	}
	
	public void inorder94(List<Integer> list, TreeNode root){
		if(root != null){
			inorder94(list, root.left);
			list.add(root.val);
			inorder94(list, root.right);
		}
	}
	
	//Iterative
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}
		return list;
	}
	
	/**
	 * [145. Binary Tree Postorder Traversal]
	 * Created On 2016年7月26日  下午3:10:56
	 */
	//Recursive
	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		postorder145(list, root);
		return list;
	}
	
	public void postorder145(List<Integer> list, TreeNode root){
		if(root != null){
			postorder145(list, root.left);
			postorder145(list, root.right);
			list.add(root.val);
		}
	}
	
	//Iterative
	public List<Integer> postorderTraversal2(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<>();
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				stack.push(cur);
				list.addFirst(cur.val);
				cur = cur.right;
			}
			cur = stack.pop();
			cur = cur.left;
		}
		return list;
	}
	
	/**
	 * [318. Maximum Product of Word Lengths]
	 * Created On 2016年7月26日  下午3:43:53
	 */
	public int maxProduct(String[] words) {
		if(words == null || words.length == 0) return 0;
		int[] mask = new int[words.length];
		int[] len = new int[words.length];
		int max = 0;
		for(int i = 0; i < words.length; i++){
			len[i] = words[i].length();
			for(int j = 0; j < len[i]; j++){
				mask[i] |= 1 << (words[i].charAt(j) - 'a');
			}
			
			for(int j = 0; j < i; j++){
				if((mask[i] & mask[j]) == 0){
					int product = len[i] * len[j];
					max = max > product ? max : product;
				}
			}
		}
		return max;
	}
	
	/**
	 * [328. Odd Even Linked List]
	 * Created On 2016年7月26日  下午4:42:39
	 */
	public ListNode oddEvenList(ListNode head) {
		if(head == null) return head;
		ListNode oddhead = new ListNode(0);
		ListNode evenhead = new ListNode(0);
		ListNode odd = oddhead;
		ListNode even = evenhead;
		boolean flag = true;
		while(head != null){
			if(flag){
				odd.next = head;
				head = head.next;
				odd = odd.next;
				odd.next = null;
				flag = false;
			}else{
				even.next = head;
				head = head.next;
				even = even.next;
				even.next = null;
				flag = true;
			}
		}
		odd.next = evenhead.next;
		return oddhead.next;
	}
	
	
	
	/**
	 * [230. Kth Smallest Element in a BST]
	 * Created On 2016年7月26日  下午5:23:43
	 */
	//DFS in-order Recursive
	private static int number = 0;
	private static int count = 0;
	public int kthSmallest(TreeNode root, int k) {
		count = k;
		kthSmallest230(root);
		return number;
	}
	
	public void kthSmallest230(TreeNode root) {
		if (root.left != null) kthSmallest230(root.left);
		count--;
		if (count == 0) {
			number = root.val;
			return;
		}
		if (root.right != null) kthSmallest230(root.right);
	}
	
	/**
	 * [377. Combination Sum IV]
	 * Created On 2016年7月26日  下午5:35:18
	 */
	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for(int i = 1; i <= target; i++){
			for(int j = 0; j < nums.length && nums[j] <= i; j++){
				dp[i] += dp[i - nums[j]];
			}
		}
		return dp[target];
	}
	
	/**
	 * [216. Combination Sum III]
	 * Created On 2016年7月26日  下午6:05:51
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack216(list, new ArrayList<Integer>(), 1, n, k);
		return list;
	}
	
	public void backtrack216(List<List<Integer>> list, List<Integer> temp, int start, int target, int k){
		if(k == 0 && target == 0){
			list.add(new ArrayList<Integer>(temp));
		}else{
			for(int i = start; i <= 9 && target > 0 && k > 0; i++){
				temp.add(i);
				backtrack216(list, temp, i + 1, target - i, k - 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	/**
	 * [40. Combination Sum II]
	 * Created On 2016年7月27日  下午3:11:13
	 */
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack40(list, new ArrayList<Integer>(), candidates, 0, target);
		return list;
	}
	
	public void backtrack40(List<List<Integer>> list, List<Integer> temp, int[] candidates, int start, int target){
		if(target == 0){
			list.add(new ArrayList<Integer>(temp));
		}else{
			int pre = 0;
			for(int i = start; i < candidates.length && candidates[i] <= target; i++){
				if(i == start || (i != start && candidates[i] != pre)){
					pre = candidates[i];
					temp.add(candidates[i]);
					backtrack40(list, temp, candidates, i + 1, target - candidates[i]);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}
	
	/**
	 * [39. Combination Sum]
	 * Created On 2016年7月27日  下午2:25:29
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack39(list, new ArrayList<Integer>(), candidates, 0, target);
		return list;
	}
	
	public void backtrack39(List<List<Integer>> list, List<Integer> temp, int[] candidates, int start, int target){
		if(target == 0){
			list.add(new ArrayList<Integer>(temp));
			return;
		}else{
			for(int i = start; i < candidates.length && candidates[i] <= target; i++){
				temp.add(candidates[i]);
				backtrack39(list, temp, candidates, i, target - candidates[i]);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	/**
	 * [77. Combinations]
	 * Created On 2016年7月27日  下午3:36:59
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack77(list, new ArrayList<Integer>(), 1, n, k);
		return list;
	}
	
	public void backtrack77(List<List<Integer>> list, List<Integer> temp,int start, int limit, int k){
		if(k == 0){
			list.add(new ArrayList<Integer>(temp));
		}else{
			
			for(int i = start; i <= limit - k + 1; i++){
				temp.add(i);
				backtrack77(list, temp, i + 1, limit, k - 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	/**
	 * [17. Letter Combinations of a Phone Number]
	 * Created On 2016年7月27日  下午4:27:17
	 */
	public static char[] letterBegin = {'\u0000','\u0000','a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
	public static int[] letterNums = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if(digits == null || digits.length() == 0) return list;
		int[] digit = new int[digits.length()];
		for(int i = 0; i < digits.length(); i++){
			digit[i] = digits.charAt(i) - '0';
		}
		backtrack17(list, new StringBuilder(), digit, 0, digit.length);
		return list;
	}
	
	public void backtrack17(List<String> list, StringBuilder sb, int[] digit,int index, int len){
		if(len == 0){
			list.add(new String(sb));
		}else{
			int num = letterNums[digit[index]];
			if(num != 0){
				char begin = letterBegin[digit[index]];
				for(int i = 0; i < num; i++){
					sb.append((char)(begin + i));
					backtrack17(list, sb, digit, index + 1, len - 1);
					sb.deleteCharAt(sb.length() - 1);
				}
			}else{
				backtrack17(list, sb, digit, index + 1, len - 1);
			}
		}
	}
	
	/**
	 * [22. Generate Parentheses]
	 * Created On 2016年7月27日  下午5:30:14
	 */
	public List<String> generateParenthesis(int n) {
		List<String> list = new LinkedList<>();
		if(n <= 0) return list;
		backtrace22(list, new StringBuilder(), 0, 0, n);
		return list;
	}
	
	public void backtrace22(List<String> list, StringBuilder sb, int left, int right, int n){
		if(left == n && right == n){
			list.add(sb.toString());
		}else{
			int len = sb.length();
			if(left < n){
				sb.append('(');
				backtrace22(list, sb, left + 1, right, n);
				sb.setLength(len);
			}
			if(left > right){
				sb.append(')');
				backtrace22(list, sb, left, right + 1, n);
				sb.setLength(len);
			}
		}
	}
}
