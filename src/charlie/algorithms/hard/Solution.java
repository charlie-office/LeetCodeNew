/* Solved Problems
 * [. ]
 */
package charlie.algorithms.hard;

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
		int[] bits = s.countBits(5);
		s.printArray(bits);
	}
	
	/**
	 * 用于测试，打印int类型数组
	 * Created On 2016年7月24日  下午5:54:16
	 */
	public void printArray(int[] arr){
		System.out.print("[ ");
		for(int num : arr){
			System.out.print(num + " ");
		}
		System.out.println("]");
	}
	
	/**
	 * 用于测试，打印char类型数组
	 * Created On 2016年7月24日  下午5:54:16
	 */
	public void printArray(char[] arr){
		System.out.print("[ ");
		for(char ch : arr){
			System.out.print(ch + " ");
		}
		System.out.println("]");
	}
	
	/**
	 * 用于测试，打印String类型数组
	 * Created On 2016年7月24日  下午5:54:16
	 */
	public void printArray(String[] arr){
		System.out.println("String Array = [ ");
		for(String str : arr){
			System.out.println(str);
		}
		System.out.println("]");
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
}
