class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        for(char c : sentence.toCharArray()){
            set.add(c);
        }
        if(set.size()==26){
        return true;
        }
        else{
            return false;
        } 
        
    }
}