/* Included Problems
 * [344. Reverse String]
 * 
 */
package charlie.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
	
	/**
	 * [326. Power of Three]
	 * Created On 2016年7月10日  下午3:51:41
	 */
	public boolean isPowerOfThree(int n) {
		// 1162261467 is 3^19,  3^20 is bigger than int  
		return ( n>0 && 1162261467 % n == 0);
	}
	
	/**
	 * [231. Power of Two]
	 * Created On 2016年7月10日  下午3:59:29
	 */
	public boolean isPowerOfTwo(int n) {
		return n > 0 && n == (n & -n);
	}
	
	/**
	 * [206. Reverse Linked List]
	 * Created On 2016年7月10日  下午4:12:48
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	/**
	 * [235. Lowest Common Ancestor of a Binary Search Tree]
	 * Created On 2016年7月10日  下午5:06:41
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if ((p.val - root.val) * (root.val - q.val) >= 0) 
			return root;
		return (p.val > root.val) ? lowestCommonAncestor(root.right, p, q) : lowestCommonAncestor(root.left, p, q);
	}
	
	/**
	 * [70. Climbing Stairs]
	 * Created On 2016年7月10日  下午6:02:33
	 */
	public int climbStairs(int n) {
		int[] dp = {0, 1, 2};
		for(int i = 3; i <= n; i++) {
			dp[i%3] = dp[(i-1)%3] + dp[(i-2)%3];
		}
		return dp[n%3];
	}
	
	/**
	 * [121. Best Time to Buy and Sell Stock]
	 * Created On 2016年7月10日  下午6:07:02
	 */
	public int maxProfit(int[] prices) {
		int profit = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(prices[i], min);
			profit = Math.max(prices[i] - min, profit);
		}
		return profit;
	}
	
	/**
	 * [345. Reverse Vowels of a String]
	 * Created On 2016年7月10日  下午7:21:54
	 */
	public String reverseVowels(String s) {
		char[] ch = s.toCharArray();
		
		char tmp;
		int p1 = 0 , p2 = s.length()-1;
		
		loop: 
		while(p1 < p2){
			while(ch[p1] != 'a' && ch[p1] != 'e' && ch[p1] != 'i' && ch[p1] != 'o' && ch[p1] != 'u' && ch[p1] != 'A' && ch[p1] != 'E' && ch[p1] != 'I' && ch[p1] != 'O' && ch[p1] != 'U'){
				p1 ++;
				if(p1 >= p2)
					break loop;
			}
			
			while(ch[p2] != 'a' && ch[p2] != 'e' && ch[p2] != 'i' && ch[p2] != 'o' && ch[p2] != 'u' && ch[p2] != 'A' && ch[p2] != 'E' && ch[p2] != 'I' && ch[p2] != 'O' && ch[p2] != 'U'){
				p2 --;
				if(p1 >= p2)
					break loop;
			}
				
			tmp = ch[p1];
			ch[p1] = ch[p2];
			ch[p2] = tmp;
			
			p1 ++;
			p2 --;
		}
		return new String(ch); 
	}
	
	/**
	 * [198. House Robber]
	 * Created On 2016年7月11日  下午8:38:35
	 */
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		nums[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++) {
			nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
		}
		return nums[nums.length - 1];
	}
	
	/**
	 * [342. Power of Four]
	 * Created On 2016年7月12日  下午8:50:15
	 */
	public boolean isPowerOfFour(int num) {
		return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
		//0x55555555 is to get rid of those power of 2 but not power of 4
		//so that the single 1 bit always appears at the odd position 
	}
	
	/**
	 * [66. Plus One]
	 * Created On 2016年7月12日  下午9:37:41
	 */
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		for(int i=n-1; i>=0; i--) {
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			
			digits[i] = 0;
		}
		
		int[] newNumber = new int [n+1];
		newNumber[0] = 1;
		
		return newNumber;
	}
	
	/**
	 * [101. Symmetric Tree]
	 * Created On 2016年7月13日  下午9:40:58
	 */
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if (t1 == null && t2 == null) continue;
			if (t1 == null || t2 == null) return false;
			if (t1.val != t2.val) return false;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}
	
	/**
	 * [110. Balanced Binary Tree]
	 * Created On 2016年7月13日  下午9:42:01
	 */
	//The point to solve it by using recursive is to use integer value as 
	//both height counter and a flag to mark unbalance. I'm feeling it's a middle level problem to solve.
	public boolean isBalanced(TreeNode root) {
		return root == null || height(root) != -1;
	}
	public int height(TreeNode root){
		if(root.left == null && root.right == null)
			return 1;
		int lH = 0, rH = 0;
		if(root.left != null) lH = height(root.left);
		if(root.right != null) rH = height(root.right);
		if(lH == -1 || rH == -1) return -1;
		if(Math.abs(lH - rH) > 1) return -1;
		return Math.max(lH, rH) + 1;
	}
	
	/**
	 * [119. Pascal's Triangle II]
	 * Created On 2016年7月14日  下午2:50:16
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		int curr[] = new int[rowIndex + 1];
		int prev[] = new int[rowIndex + 1];
		prev[0] = 1;
		
		for(int row = 1; row <= rowIndex; row++) {
			curr[0] = 1;
			curr[row] = 1;
			
			for(int i = 1; i < row; i++)
				curr[i] = prev[i] + prev[i - 1];
			
			int[] swap = curr;
			curr = prev;
			prev = swap;
		} 
		
		for(int i = 0; i <= rowIndex; i++)
			res.add(prev[i]);
			
		return res;
	}
	
	/**
	 * [9. Palindrome Number]
	 * Created On 2016年7月17日  下午6:00:54
	 */
	public boolean isPalindrome(int x) {
		if (x<0 || (x!=0 && x%10==0)) return false;
		int rev = 0;
		while (x>rev){
			rev = rev*10 + x%10;
			x = x/10;
		}
		return (x==rev || x==rev/10);
	}
	
	/**
	 * [111. Minimum Depth of Binary Tree]
	 * Created On 2016年7月18日  下午9:11:29
	 */
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null) return 1 + minDepth(root.right);
		if(root.right == null) return 1 + minDepth(root.left);
		return 1 + Math.min(minDepth(root.left),minDepth(root.right));
	}
	
	/**
	 * [205. Isomorphic Strings]
	 * Created On 2016年7月19日  下午3:48:21
	 */
	public boolean isIsomorphic(String sString, String tString) {

		char[] s = sString.toCharArray();
		char[] t = tString.toCharArray();

		int length = s.length;
		if(length != t.length) return false;

		char[] sm = new char[256];
		char[] tm = new char[256];

		for(int i=0; i<length; i++){
			char sc = s[i];
			char tc = t[i];
			if(sm[sc] == 0 && tm[tc] == 0){
				sm[sc] = tc;
				tm[tc] = sc;
			}else{
				if(sm[sc] != tc || tm[tc] != sc){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * [219. Contains Duplicate II]
	 * Created On 2016年7月19日  下午4:31:29
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(i > k) set.remove(nums[i-k-1]);
			if(!set.add(nums[i])) return true;
		}
		return false;
	}
	
	/**
	 * [168. Excel Sheet Column Title]
	 * Created On 2016年7月20日  下午9:14:18
	 */
	public String convertToTitle(int n) {
		StringBuilder result = new StringBuilder();

		while(n>0){
			n--;
			result.insert(0, (char)('A' + n % 26));
			n /= 26;
		}

		return result.toString();
	}
	
	/**
	 * [165. Compare Version Numbers]
	 * Created On 2016年7月21日  上午10:10:23
	 */
	public int compareVersion(String version1, String version2) {
		int temp1 = 0,temp2 = 0;
		int len1 = version1.length(),len2 = version2.length();
		int i = 0,j = 0;
		while(i<len1 || j<len2) {
			temp1 = 0;
			temp2 = 0;
			while(i<len1 && version1.charAt(i) != '.') {
				temp1 = temp1*10 + version1.charAt(i++)-'0';
				
			}
			while(j<len2 && version2.charAt(j) != '.') {
				temp2 = temp2*10 + version2.charAt(j++)-'0';
				
			}
			if(temp1>temp2) return 1;
			else if(temp1<temp2) return -1;
			else {
				i++;
				j++;
				
			}
			
		}
		return 0;
		
	}
	
	/**
	 * [88. Merge Sorted Array]
	 * Created On 2016年7月22日  下午3:39:11
	 */
	public void merge(int A[], int m, int B[], int n) {
		int length = m+n;
		while(n > 0) 
			A[--length] = (m == 0 || A[m-1] < B[n-1]) ? B[--n] : A[--m];
	}
	/**
	 * [257. Binary Tree Paths]
	 * Created On 2016年7月22日  下午4:27:03
	 */
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> rst = new ArrayList<String>();
		if(root == null) return rst;
		StringBuilder sb = new StringBuilder();
		helper(rst, sb, root);
		return rst;
	}
	
	public void helper(List<String> rst, StringBuilder sb, TreeNode root){
		if(root == null) return;
		int tmp = sb.length();
		if(root.left == null && root.right == null){
			sb.append(root.val);
			rst.add(sb.toString());
			sb.delete(tmp , sb.length());
			return;
		}
		sb.append(root.val + "->");
		helper(rst, sb, root.left);
		helper(rst, sb, root.right);
		sb.delete(tmp , sb.length());
		return;
	}
	
	/**
	 * [19. Remove Nth Node From End of List]
	 * Created On 2016年7月22日  下午5:34:12
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode start = new ListNode(0);
		ListNode slow = start, fast = start;
		slow.next = head;
		
		//Move fast in front so that the gap between slow and fast becomes n
		for(int i=1; i<=n+1; i++)   {
			fast = fast.next;
		}
		//Move fast to the end, maintaining the gap
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		//Skip the desired node
		slow.next = slow.next.next;
		return start.next;
	}
}