package wiprotraining;
public class UniqueElements {
    public static int[] findUniqueElements(int[] nums) {
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        int diffBit = xorResult & -xorResult;
        int unique1 = 0, unique2 = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                unique1 ^= num;
            } else {
                unique2 ^= num;
            }
        }

        return new int[] {unique1, unique2};
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] uniqueElements = findUniqueElements(nums);
        System.out.println("The two unique elements are: " + uniqueElements[0] + " and " + uniqueElements[1]);
    }
}

