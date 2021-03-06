package charlie.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

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
	 * [338. Counting Bits]
	 * Created On 2016年7月24日  下午5:21:58
	 */
	public int[] countBits(int num) {
		int[] f = new int[num + 1];
		for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
		return f;
	}
	
	
	/**
	 * [137. Single Number II]
	 * 每次循环先计算 x2，即出现两次的 1 的分布，然后计算出现一次的 1 的分布，
	 * 接着 二者进行与操作得到出现三次的 1 的分布情况，然后对 mask 取反，
	 * 再与 x1、x2进行与操作，这样的目的是将出现了三次的位置清零
	 * Created On 2016年7月24日  下午6:51:28
	 */
	public int singleNumber137(int[] nums) {
		int x1 = 0;   
		int x2 = 0; 
		int mask = 0;	
		for (int i : nums) {
			x2 ^= x1 & i;
			x1 ^= i;
			mask = ~(x1 & x2);
			x2 &= mask;
			x1 &= mask;
		}	
		return x1; 
	}
	
	/**
	 * [260. Single Number III]
	 * Created On 2016年7月24日  下午6:42:43
	 */
	public int[] singleNumber(int[] nums) {
		int result[] = new int[2];        
		int xor = nums[0];
		for (int i=1; i<nums.length; i++)
		{
			xor ^= nums[i];
		}
		
		int bit = xor & ~(xor-1);
		int num1 = 0;
		int num2 = 0;
		
		for (int num : nums)
		{
			if ((num & bit) > 0)
			{
				num1 ^= num;
			}
			else
			{
				num2 ^= num;
			}
		}
		
		result[0] = num1;
		result[1] = num2;
		return result;
	}
	
	/**
	 * [238. Product of Array Except Self]
	 * Created On 2016年7月24日  下午8:13:00
	 */
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}

	/**
	 * [357. Count Numbers with Unique Digits]
	 * Created On 2016年7月25日  下午4:15:35
	 */
	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		int ans = 10, base = 9;
		for (int i = 2; i <= n && i <= 10; i++) {
			base = base * (9 - i + 2);
			ans += base;
		}
		return ans;
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		Arrays.sort(nums);
		PriorityQueue<Element> vals = new PriorityQueue<Element>(k, new ElementComparator());
		for(int i = 0; i < nums.length; i++) {
			int start = nums[i];
			int count = 1;
			while(i < nums.length-1 && nums[i+1] == start ) {
				count++;
				i++;
			}
			vals.add(new Element(start, count));
		}
		List<Integer> res = new ArrayList<Integer>(k);
		for (int i = 0; i < k; i++) {
			res.add(vals.poll().key);
		}
		return res;
	}
	
	class ElementComparator implements Comparator<Element>
	{
		 public int compare(Element c1, Element c2)
		 {
			Integer a1 = c1.value;
			Integer a2 = c2.value;
			 
			if(a1 > a2) {
				return -1;
			}
			else if(a2 > a1)
				return 1;
			return 0;
		 }
	 }
	
	public class Element {
		int key, value;
		
		Element(int key, int val) {
			this.key = key;
			this.value = val;
		}
		public int compareTo(Element e) {
			
			if(this.value > e.value)
				return 1;
				
			else if(e.value > this.value)
				return -1;
			return 0;
		}

	}
	
	/**
	 * [343. Integer Break]
	 * Created On 2016年7月25日  下午5:20:24
	 */
	public int integerBreak(int n) {
		if(n==2) return 1;
		if(n==3) return 2;
		int product = 1;
		while(n>4){
			product*=3;
			n-=3;
		}
		product*=n;
		
		return product;
	}
	
	
	/**
	 * [144. Binary Tree Preorder Traversal]
	 * Created On 2016年7月26日  下午2:17:27
	 */
	//Morris
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> l=new ArrayList<Integer>();
		if(root==null) return l;
		TreeNode pre,cur=root;
		while(cur!=null){
			if(cur.left==null){
				l.add(cur.val);
				cur=cur.right;
			}else{
				pre=cur.left;
				while(pre.right!=null&&pre.right!=cur){
					pre=pre.right;
				}
				if(pre.right==null){
					pre.right=cur;
					l.add(cur.val);
					cur=cur.left;
				}else{
					pre.right=null;
					cur=cur.right;
				}
			}
		}
		return l;
	}
	//Iterative
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();
		if(root == null) return l;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			root = stack.pop();
			l.add(root.val);
			if(root.right!=null) stack.push(root.right);
			if(root.left!=null) stack.push(root.left);
		}
		return l;
	}
	
	/**
	 * [94. Binary Tree Inorder Traversal]
	 * Created On 2016年7月26日  下午2:40:31
	 */
	//Morris
	public List<Integer> inorderTraversal(TreeNode root) {
		TreeNode node = root;
		List<Integer> list = new ArrayList<Integer>();
		while (node != null) {
			// POINT 1
			if (node.left == null) {
				list.add(node.val);
				node = node.right;
			} else {
				TreeNode temp = node.left;
				while (temp.right != null && temp.right != node) temp = temp.right;
				// POINT 2
				if (temp.right == node) {
					temp.right = null;
					list.add(node.val);
					node = node.right;
				// POINT 3
				} else {
					temp.right = node;
					node = node.left;
				}
			}
		}
		return list;
	}
	
	/**
	 * [328. Odd Even Linked List]
	 * Created On 2016年7月26日  下午4:42:39
	 */
	public ListNode oddEvenList(ListNode head) {
		if (head != null) {
			ListNode odd = head, even = head.next, evenHead = even; 
		
			while (even != null && even.next != null) {
				odd.next = odd.next.next; 
				even.next = even.next.next; 
				odd = odd.next;
				even = even.next;
			}
			odd.next = evenHead; 
		}
		return head;
	}
	
	/**
	 * [230. Kth Smallest Element in a BST]
	 * Created On 2016年7月26日  下午5:23:43
	 */
	//Binary Search (DFS)
	public int kthSmallest1(TreeNode root, int k) {
		int count = countNodes(root.left); 
		if (k <= count) {
			return kthSmallest1(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest1(root.right, k - count - 1); // 1 is counted as current node
		}
		
		return root.val;
	}
	
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	//DFS in-order Iterative
	public int kthSmallest2(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<>();
		
		while (root != null) {
			st.push(root);
			root = root.left;
		}
			
		while (k != 0) {
			TreeNode n = st.pop();
			k--;
			if (k == 0) return n.val;
			TreeNode right = n.right;
			while (right != null) {
				st.push(right);
				right = right.left;
			}
		}
		
		return -1; // never hit if k is valid
	}
	
	
	/**
	 * [40. Combination Sum II]
	 * Created On 2016年7月27日  下午3:32:37
	 */
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack40(list, new ArrayList<>(), nums, target, 0);
		return list;
		
	}

	private void backtrack40(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<>(tempList));
		else{
			for(int i = start; i < nums.length; i++){
				if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
				tempList.add(nums[i]);
				backtrack40(list, tempList, nums, remain - nums[i], i + 1);
				tempList.remove(tempList.size() - 1); 
			}
		}
	}
	
	/**
	 * [77. Combinations]
	 * Created On 2016年7月27日  下午3:36:59
	 */
	//Iterative
	public List<List<Integer>> combine(int n, int k) {
		if (n == 0 || k == 0 || k > n) return Collections.emptyList();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 1; i <= n + 1 - k; i++) res.add(Arrays.asList(i));
		for (int i = 2; i <= k; i++) {
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for (List<Integer> list : res) {
				for (int m = list.get(list.size() - 1) + 1; m <= n - (k - i); m++) {
					List<Integer> newList = new ArrayList<Integer>(list);
					newList.add(m);
					tmp.add(newList);
				}
			}
			res = tmp;
		}
		return res;
	}
	
	/**
	 * [17. Letter Combinations of a Phone Number]
	 * Created On 2016年7月27日  下午4:27:17
	 */
	public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.length() == 0) return ans;
		
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
	
	/**
	 * [337. House Robber III]
	 * Created On 2016年7月28日 下午4:31:58
	 */
	public int rob(TreeNode root) {
		int[] res = robSub(root);
		return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
		if (root == null) {
			return new int[2];
		}
		
		int[] left = robSub(root.left);
		int[] right = robSub(root.right);
		
		int[] res = new int[2];
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);// not rob current
		res[1] = root.val + left[0] + right[0]; //rob current
		
		return res;
	}
	
	/**
	 * [96. Unique Binary Search Trees]
	 * Dynamic Programming
	 * The Recursive Formula: G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-1) * G(0) 
	 * Created On 2016年7月28日 下午6:10:03
	 */
	public int numTrees(int n) {
		int [] G = new int[n+1];
		G[0] = G[1] = 1;
		
		for(int i=2; i<=n; ++i) {
			for(int j=1; j<=i; ++j) {
				G[i] += G[j-1] * G[i-j];
			}
		}

		return G[n];
	}
	
	/**
	 * [241. Different Ways to Add Parentheses]
	 * Created On 2016年7月29日 下午1:02:55
	 */
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> ret = new LinkedList<Integer>();
		for (int i=0; i<input.length(); i++) {
			if (input.charAt(i) == '-' ||
				input.charAt(i) == '*' ||
				input.charAt(i) == '+' ) {
				String part1 = input.substring(0, i);
				String part2 = input.substring(i+1);
				List<Integer> part1Ret = diffWaysToCompute(part1);
				List<Integer> part2Ret = diffWaysToCompute(part2);
				for (Integer p1 :   part1Ret) {
					for (Integer p2 :   part2Ret) {
						int c = 0;
						switch (input.charAt(i)) {
							case '+': c = p1+p2;
								break;
							case '-': c = p1-p2;
								break;
							case '*': c = p1*p2;
								break;
						}
						ret.add(c);
					}
				}
			}
		}
		if (ret.size() == 0) {
			ret.add(Integer.valueOf(input));
		}
		return ret;
	}
	
	/**
	 * [46. Permutations]
	 * Created On 2016年7月30日 下午4:23:57
	 */
	public List<List<Integer>> permute(int[] num) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		for (int n : num) {
			for (int size = res.size(); size > 0; size--) {
				List<Integer> r = res.pollFirst();
				for (int i = 0; i <= r.size(); i++) {
					List<Integer> t = new ArrayList<Integer>(r);
					t.add(i, n);
					res.add(t);
				}
			}
		}
		return res;
	}
	
	/**
	 * [63. Unique Paths II]
	 * Created On 2016年7月31日 下午6:10:34
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		
		//flip upper left cell (the start cell): 1 => 0 or 0 => 1
		obstacleGrid[0][0] ^= 1;
		
		//first row: if 1, then 0; otherwise, left cell
		for(int i = 1; i < n; i++)
			obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
		
		//first column: if 1, then 0; otherwise, top cell
		for(int i = 1; i < m; i++)
			obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
			
		//rest: if 1, then 0; otherwise, left cell + top cell
		for(int i = 1; i < m; i++)
			for(int j = 1; j < n; j++)
				obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				
		//return lower right cell (the end cell)
		return obstacleGrid[m - 1][n - 1];
	}
	
	/**
	 * [153. Find Minimum in Rotated Sorted Array]
	 * Created On 2016年8月14日 下午3:20:50
	 */
	public int findMin(int[] nums) {
		int left = 0,  right = nums.length - 1;
		while(left < right) {
			if(nums[left] < nums[right]) 
				return nums[left];
			int mid = (left + right)/2;
			if(nums[mid] > nums[right])
				left = mid + 1;
			else
				right = mid;
		}
		return nums[left];
	}
}
