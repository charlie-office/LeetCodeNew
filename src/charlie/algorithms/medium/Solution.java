package charlie.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
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
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(s.longestPalindrome_DP("leve"));
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

    /**
     * [213. House Robber II]
     * Created On 2016年7月28日 下午3:44:07
     */
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob213(nums, 0, nums.length - 1), rob213(nums, 1, nums.length));
    }

    public int rob213(int[] nums, int start, int end){
        int odd = 0;
        int even = 0;
        for(int i = start; i < end; i++){
            if(i % 2 == 1)
                odd = odd + nums[i] > even ? odd + nums[i] : even ;
            else
                even = even + nums[i] > odd ? even + nums[i] : odd;
        }
        return odd > even ? odd : even;
    }

    /**
     * [337. House Robber III]
     * Created On 2016年7月28日 下午4:31:58
     */
    public int rob(TreeNode root) {
        int[] money = rob337(root);
        return Math.max(money[0], money[1]);
    }

    private int[] rob337(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] l = rob337(root.left);
        int[] r = rob337(root.right);
        int[] money = new int[2];
        money[0] = (l[0] > l[1] ? l[0] : l[1]) + (r[0] > r[1] ? r[0] : r[1]); // not rob current
        money[1] = root.val + l[0] + r[0]; //rob current
        return money;
    }

    /**
     * [96. Unique Binary Search Trees]
     * Created On 2016年7月28日 下午6:10:03
     */
    public int numTrees(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 2;
        for(int i = 3; i <= n; i++){
            num[i] = 2 * num[i - 1];
            for(int j = 1; j < i; j++){
                num[i] += num[j] * num[i - 1 - j];
            }
        }
        return num[n];
    }

    /**
     * [108. Convert Sorted Array to Binary Search Tree]
     * Created On 2016年7月28日 下午7:01:31
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = createTreeNodeDFS(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode createTreeNodeDFS(int[] nums, int left, int right){
        int mid = left + (right - left)/2;
        TreeNode root = null;
        if(left <= right){
            root = new TreeNode(nums[mid]);
            root.left = createTreeNodeDFS(nums, left, mid - 1);
            root.right = createTreeNodeDFS(nums, mid + 1, right);
        }
        return root;
    }

    /**
     * [35. Search Insert Position]
     * Created On 2016年7月28日 下午7:20:28
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * [123. Best Time to Buy and Sell Stock III]
     * Solution 1:
     * Four variables represent your profit after executing corresponding transaction
     * Using only two variables is the solution for Best Time to Buy and Sell Stock I
     * Solution 2:
     * Divide and Conquer
     * Created On 2016年7月29日 下午3:02:26
     */
    public int maxProfit123(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;;
        int sell1 = 0, sell2 = 0;
        for(int i = 0; i < prices.length; i++){
            buy1 = Math.max(buy1, -prices[i]);// the max profit after you buy first stock
            sell1 = Math.max(sell1, prices[i] + buy1);// the max profit after you sell it
            buy2 = Math.max(buy2,  sell1 - prices[i]);// the max profit after you buy the second stock
            sell2 = Math.max(sell2, buy2 + prices[i]);// the max profit after you sell the second stock
        }
        return sell2;
    }

    public int maxProfit123_DivideAndConquer(int[] prices) {
        if(prices.length < 2) return 0;
        int[] preProfit = new int[prices.length];
        int[] postProfit = new int[prices.length];

        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(min > prices[i]) min = prices[i];
            maxProfit = Math.max(maxProfit, prices[i] - min);
            preProfit[i] = maxProfit;
        }

        maxProfit = 0;
        int max = Integer.MIN_VALUE;
        for(int i = prices.length - 1; i >= 0; i--){
            if(max < prices[i]) max = prices[i];
            maxProfit = Math.max(maxProfit, max - prices[i]);
            postProfit[i] = maxProfit;
        }

        maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }
        return maxProfit;
    }

    /**
     * [188. Best Time to Buy and Sell Stock IV]
     * Created On 2016年7月29日 下午5:16:45
     */
    public int maxProfit(int k, int[] prices) {
        int profit = 0;
        return profit;
    }

    /**
     * [309. Best Time to Buy and Sell Stock with Cooldown]
     * Created On 2016年7月28日 下午8:00:56
     */
    public int maxProfit309(int[] prices) {
        int buy1 = 0, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for(int price : prices){
            buy1 = buy2;
            buy2 = Math.max(sell1 - price, buy1);
            sell1 = sell2;
            sell2 = Math.max(buy1 + price, sell1);
        }
        return sell2;
    }

    /**
     * [241. Different Ways to Add Parentheses]
     * Created On 2016年7月29日 下午1:02:55
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int index =  -1;
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                nums.add(Integer.parseInt(input.substring(index + 1, i)));
                index = i;
                ops.add(ch);
            }
        }
        nums.add(Integer.parseInt(input.substring(index + 1)));
        List<Integer> list = divideAndConquer241(nums, ops, 0, nums.size() - 1);
        return list;
    }

    private List<Integer> divideAndConquer241(List<Integer> nums, List<Character> ops, int left, int right){
        List<Integer> list = new ArrayList<>();
        if(left < right){
            for(int i = left; i < right; i++){
                List<Integer> l = divideAndConquer241(nums, ops, left, i);
                List<Integer> r = divideAndConquer241(nums, ops, i + 1, right);
                for(int tl = 0; tl < l.size(); tl ++){
                    for(int tr = 0; tr < r.size(); tr ++){
                        switch(ops.get(i)){
                            case '+': list.add(l.get(tl) + r.get(tr)); break;
                            case '-': list.add(l.get(tl) - r.get(tr)); break;
                            case '*': list.add(l.get(tl) * r.get(tr)); break;
                        }
                    }
                }
            }
        }else if(left == right){
            list.add(nums.get(left));
        }
        return list;
    }

    /**
     * [89. Gray Code]
     * Created On 2016年7月30日 下午4:08:40
     */
    //Binary to gray code
    public List<Integer> grayCode1(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 1 << n; i++){
            list.add(i ^ i >> 1);
        }
        return list;
    }

    //Mirror arrangement
    public List<Integer> grayCode2(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = 0; i < n; i++){
            int highBit = 1 << i;
            int len = list.size();
            for(int j = len - 1; j >= 0; j--){
                list.add(highBit + list.get(j));
            }
        }
        return list;
    }

    /**
     * [46. Permutations]
     * Backtracking : using visited array
     * Created On 2016年7月30日 下午4:23:57
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        int[] visited = new int[nums.length];
        backtrack46(list, new LinkedList<Integer>(), nums, visited, 0);
        return list;
    }

    private void backtrack46(List<List<Integer>> list, LinkedList<Integer> temp, int[] nums, int[] visited, int count){
        if(count == nums.length){
            list.add(new LinkedList<Integer>(temp));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(visited[i] == 0){
                    visited[i] = 1;
                    temp.add(nums[i]);
                    backtrack46(list, temp, nums, visited, count + 1);
                    temp.removeLast();
                    visited[i] = 0;
                }
            }
        }
    }

    /**
     * [47. Permutations II]
     * Created On 2016年7月30日 下午5:16:55
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        backtrack47(list, new ArrayList<Integer>(), nums, visited, 0);
        return list;
    }

    private void backtrack47(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums, int[] visited, int count){
        if(count == nums.length){
            list.add(new ArrayList<Integer>(temp));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) continue;
                if(visited[i] == 0){
                    visited[i] = 1;
                    temp.add(nums[i]);
                    backtrack47(list, temp, nums, visited, count + 1);
                    temp.remove(temp.size() - 1);
                    visited[i] = 0;
                }
            }
        }
    }

    /**
     * [31. Next Permutation]
     * Created On 2016年7月30日 下午7:53:29
     */
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                int j = 0;
                for (j = nums.length - 1; j >= i; --j) {
                    if (nums[j] > nums[i]) break;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    /**
     * [60. Permutation Sequence]
     * Created On 2016年7月30日 下午9:33:53
     */
    public String getPermutation(int n, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        int factorial = 1;
        for(int i = 1; i <= n; i++){
            list.add(i);
            factorial *= i;
        }

        k = k - 1; // 只需要减去一次，不需要迭代

        StringBuilder sb = new StringBuilder();
        for(int i = n; i >= 1; i--){
            factorial = factorial / i;
            int pos = k / factorial;
            k = k % factorial;
            sb.append(list.get(pos));
            list.remove(pos);
        }
        return sb.toString();
    }

    /**
     * [62. Unique Paths]
     * Created On 2016年7月30日 下午9:33:53
     */
    //Combination number
    public int uniquePaths(int m, int n) {
        int min = Math.min(m - 1, n - 1);
        if(min == 0) return 1;
        long M = m + n - 2;
        long N = min;
        for(int i = 1; i < min; i++){
            N *= i;
            M *= (m + n - i - 2);
        }
        return (int)(M / N);
    }

    //Dynamic Programming
    public int uniquePaths_DP(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }

        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j -1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * [63. Unique Paths II]
     * Created On 2016年7月31日 下午5:22:50
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;

        int[][] dp = new int[M][N];
        for(int i = 0; i < M; i++){
            dp[i][0] = 1;
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                break;
            }
        }
        for(int i = 0; i < N; i++){
            dp[0][i] = 1;
            if(obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
                break;
            }
        }
        for(int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j -1];
                }
            }
        }

        return dp[M - 1][N - 1];
    }

    /**
     * [53. Maximum Subarray]
     * Created On 2016年7月31日 下午8:25:08
     */
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i = 0; i < nums.length; i++){
            tmp = Math.max(tmp + nums[i], nums[i]);
            res = Math.max(res,tmp);
        }
        return res;
    }

    /**
     * [378. Kth Smallest Element in a Sorted Matrix]
     * Created On 2016年8月14日 下午3:19:27
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                queue.offer(matrix[i][j]);
            }
        }
        int min = 0;
        for(int i = 0; i < k; i++){
            min = queue.poll();
            if(i != k - 1) continue;
        }
        return min;
    }

    /**
     * [153. Find Minimum in Rotated Sorted Array]
     * Created On 2016年8月14日 下午3:20:50
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left;
        while(nums[left] > nums[right]){
            mid = left + (right - left)/2;
            if(nums[mid] >= nums[left]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }
        }
        return nums[mid];
    }



    /**
     * [69. Sqrt(x)]
     * Created On 2016年8月14日 下午3:22:01
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while(left <= right){
            int mid = left + (right - left) /2;
            long prod = mid * mid;
            if(prod == x){
                return mid;
            }else if(prod > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * [367. Valid Perfect Square]
     * Created On 2016年8月14日 下午4:29:51
     */
    //Binary Search
    public boolean isPerfectSquare_1(int num){
        int left = 0;
        int right = num;
        while(left <= right){
            int mid = left + (right - left) /2;
            long prod = (long)mid * mid;
            if(prod == num){
                return true;
            }else if(prod > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

    //Math: 1 + 3 + ... + (2n - 1) =  (2n - 1 + 1 )*n/2 = n * n
    public boolean isPerfectSquare_2(int num){
        int i = 1;
        while(num > 0){
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    /**
     * [74. Search a 2D Matrix]
     * Created On 2016年8月14日 下午6:14:10
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int low = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(matrix[mid/n][mid%n] == target) return true;
            else if(matrix[mid/n][mid%n] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    /**
     * [240. Search a 2D Matrix II]
     * Created On 2016年8月14日 下午7:39:05
     */
    public boolean searchMatrix_II(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while(row < m && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    /**
     * [64. Minimum Path Sum]
     * Created On 2016年8月14日 下午7:51:01
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[] dp = new int[grid[0].length];
        for(int i = 0; i < dp.length; i++){
            dp[i] = (i == 0) ? grid[0][i] : grid[0][i] + dp[i - 1];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                dp[j] = (j == 0) ? dp[j] + grid[i][j] : Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * [174. Dungeon Game]
     * Created On 2016年8月14日 下午8:29:39
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for(int i = m - 2; i >= 0; i--){
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }

        for(int i = n - 2; i >= 0; i--){
            dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] - dungeon[m - 1][i]);
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                dp[i][j] = Math.max(1,Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    /**
     * [113. Path Sum II]
     * Created On 2016年8月14日 下午10:27:55
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        pathDFS(root, 0, sum, new ArrayList<Integer>(), list);
        return list;
    }

    public void pathDFS(TreeNode root, int sum, int target, List<Integer> temp, List<List<Integer>> list){
        if(root == null) return;
        if(root.val + sum == target && root.left == null && root.right == null){
            ArrayList<Integer> l = new ArrayList<Integer>(temp);
            l.add(root.val);
            list.add(l);
        }else{
            temp.add(root.val);
            pathDFS(root.left, sum + root.val, target, temp, list);
            pathDFS(root.right, sum + root.val, target, temp, list);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * [199. Binary Tree Right Side View]
     * Created On 2016年8月15日 上午12:13:48
     */

    //Recursive
    public List<Integer> rightSideView_R(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        rightSideViewDFS(root, list, 1);
        return list;
    }
    public void rightSideViewDFS(TreeNode root, List<Integer> list, int k){
        if(root != null){
            if(list.size() < k) list.add(root.val);
            rightSideViewDFS(root.right, list, k + 1);
            rightSideViewDFS(root.left, list, k + 1);
        }
    }

    //Iterative
    public List<Integer> rightSideView_I(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode tmp = null;
            for(int i = 0; i < size; i++){
                tmp = queue.poll();
                if(tmp.left != null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
            }
            res.add(tmp.val);
        }
        return res;
    }

    /**
     * [116. Populating Next Right Pointers in Each Node]
     * Created On 2016年8月15日 下午1:57:14
     */
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeLinkNode cur = null;
            TreeLinkNode next = null;
            for(int i = 0; i < size; i++){
                cur = queue.poll();
                if(i != size - 1) {
                    next = queue.peek();
                    cur.next = next;
                }
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
    }

    /**
     * [54. Spiral Matrix]
     * Created On 2016年8月15日 下午3:25:21
     */
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;
        while(left <= right && top <= bottom){
            for(int i = left; i <= right && top <= bottom; i++){
                list.add(matrix[top][i]);
            }
            top ++;
            for(int i = top; i <= bottom && left <= right; i++){
                list.add(matrix[i][right]);
            }
            right--;
            for(int i = right; i >= left && top <= bottom; i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i = bottom; i >= top && left <= right; i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }

    /**
     * [59. Spiral Matrix II]
     * Created On 2016年8月15日 下午4:00:16
     */
    public int[][] generateMatrix(int n) {
        if(n <= 0) return new int[][]{{}};
        int[][] nums = new int[n][n];
        int left = 0, right = n - 1;
        int up = 0, down = n - 1;
        int count = 0;
        while(left <= right && up <= down){
            for(int i = left; i <= right && up <= down; i++){
                nums[up][i] = ++count;
            }
            up++;
            for(int i = up; i <= down && left <= right; i++){
                nums[i][right] = ++count;
            }
            right--;
            for(int i = right; i >= left && up <= down; i--){
                nums[down][i] = ++count;
            }
            down--;
            for(int i = down; i >= up && left <= right; i--){
                nums[i][left] = ++ count;
            }
            left++;
        }
        return nums;
    }

    /**
     * [48. Rotate Image]
     * Created On 2016年8月15日 下午4:42:22
     */
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        int low = 0, high = n - 1;
        while(low <= high){
            for(int i = 0; i < high - low; i++){
                int tmp = matrix[low][low + i];
                matrix[low][low + i] = matrix[high - i][low];
                matrix[high - i][low] = matrix[high][high - i];
                matrix[high][high - i] = matrix[low + i][high];
                matrix[low + i][high] = tmp;
            }
            low ++;
            high --;
        }
    }

    /**
     * [75. Sort Colors]
     * Created On 2016-08-18 13:47:19
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int red = 0;
        int blue = nums.length - 1;
        int index = 0;
        while(index <= blue){
            if(nums[index] == 0){
                int tmp = nums[red];
                nums[red] = nums[index];
                nums[index] = tmp;
                red ++;
            }
            if(nums[index] == 2){
                int tmp = nums[blue];
                nums[blue] = nums[index];
                nums[index] = tmp;
                blue --;
                index --;
            }
            index ++;
        }
    }

    /**
     * [78. Subsets]
     * Created On 2016-08-18 15:29:54
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++){
            backtrace78(res, list, nums, i, 0);
        }
        return res;
    }

    private void  backtrace78(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int begin){
        if(list.size() == target){
            res.add(new ArrayList<>(list));
        }else{
            if(begin < nums.length){
                list.add(nums[begin]);
                backtrace78(res, list, nums, target, begin + 1);
                list.remove(list.size() - 1);
                backtrace78(res, list, nums, target, begin + 1);
            }

        }
    }

    /**
     * [90. Subsets II]
     * Created On 2016-08-18 15:58:38
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        backtrace90(res, list, nums, 0);
        return res;
    }

    private void backtrace90(List<List<Integer>> res, List<Integer> list, int[] nums, int begin){
        res.add(new ArrayList<>(list));
        for(int i = begin; i < nums.length; i++){
            if(i > begin && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backtrace90(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * [11. Container With Most Water]
     * Created On 2016-08-18 16:25:39
     */
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) return 0;
        int res = 0;
        int low = 0, high = height.length - 1;
        while (low < high){
            int h = height[low] < height[high] ? height[low] : height[high];
            int tmp = (high - low) * h;
            res = res > tmp ? res : tmp;
            while(height[low] <= h && low < high) low++;
            while(height[high] <= h && high > low) high--;
        }
        return res;
    }

    /**
     * [42. Trapping Rain Water]
     * Created On 2016-08-18 17:14:57
     */
    //Two Pointer
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int res = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int mn = Math.min(height[left], height[right]);
            if (height[left] == mn) {
                ++left;
                while (left < right && height[left] < mn) {
                    res += (mn - height[left]);
                    ++left;
                }
            } else {
                --right;
                while (left < right && height[right] < mn) {
                    res += (mn - height[right]);
                    --right;
                }
            }
        }
        return res;
    }




    /**
     * [120. Triangle]
     * Created On 2016-08-18 17:57:12
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int len = triangle.size();
        int[] dp = new int[len];
        for(int i = 0; i < len; i++){
            dp[i] = triangle.get(len - 1).get(i);
        }
        for(int i = len - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }


    /**
     * [129. Sum Root to Leaf Numbers]
     * Created On 2016-08-18 17:56:06
     */
    public int sumNumbers(TreeNode root) {
        return  sumNumbersDFS(root, 0);
    }

    private int sumNumbersDFS(TreeNode root, int sum){
        if(root == null) return 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) return sum;
        return sumNumbersDFS(root.left, sum) + sumNumbersDFS(root.right, sum);
    }

    /**
     * [3. Longest Substring Without Repeating Characters]
     * Created On 2016-08-24 17:04:13
     */
    //Hash
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] mark = new int[256];
        Arrays.fill(mark, -1);
        int len = s.length();
        int res = 0, left = 0;
        for(int right = 0; right < len; right ++){
            char tmp = s.charAt(right);
            if(mark[tmp] > -1){
                left = left > mark[tmp] + 1? left : mark[tmp] + 1;
            }
            mark[tmp] = right;
            res = res > (right - left + 1) ? res: right - left + 1;
        }
        return res;
    }

    /**
     * [5. Longest Palindromic Substring]
     * Created On 2016-08-24 19:33:10
     */
    //Danamic Programming
    public String longestPalindrome_DP(String s) {
        if(s == null || s.length() == 0) return "";
        int len = s.length();
        int plen = 0;
        boolean[][] dp = new boolean[len][len];
        int left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                dp[j][i] = (s.charAt(i) == s.charAt(j) && ((i - j) < 2 || dp[j + 1][i - 1]));
                if(dp[j][i] && plen < i - j + 1){
                    plen = i - j + 1;
                    left = j;
                    right = i;
                }
            }
            dp[i][i] = true;
        }
        return s.substring(left, right + 1);
    }
    //Manacher‘s Algorithm
    public String longestPalindrome(String s) {
        return "";
    }
}
