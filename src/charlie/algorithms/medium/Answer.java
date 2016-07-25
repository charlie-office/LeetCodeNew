package charlie.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

}
