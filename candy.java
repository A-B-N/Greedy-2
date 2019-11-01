//Time Complexity:O(n)
//SPace Complexity:O(n)
//Approach- Will initially fill the candies array with 1, so that each child will get at least 1 candy. Then I'll iterate through the ratings array in the forward direction and update the candies array in such a way that if the current element is greater than its previous, I'll update its value to be equal to the previous element's value+1. Then I'll again iterate through the array in the reverse direction corresponding to the right neighbor.Here again I'll update the value to be equal to the maximum of the next element's value +1 and its current value.Then I'll take a sum of the entire array and return the sum.
//This code was executed successfully anf got accepted in leetcode.

class Solution {
    public int candy(int[] ratings) {
        int[] candies=new int[ratings.length];
        Arrays.fill(candies,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }
        int sum=0;
        for(int candy:candies){
            sum+=candy;
        }
        return sum;
    }
}