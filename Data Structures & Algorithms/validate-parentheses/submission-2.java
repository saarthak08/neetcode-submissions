class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i< s.length(); i++) {
            Character c = s.charAt(i);
            if(c=='[' || c=='{' || c=='(') {
                stack.offerFirst(c);
            }
            else {
                if(stack.isEmpty())  {
                    return false;
                }
                else if(c=='}' && stack.peekFirst()=='{') {
                   stack.pollFirst();
                } else if(c==']' && stack.peekFirst()=='[') {
                    stack.pollFirst();
                } else if(c==')' && stack.peekFirst()=='(') {
                    stack.pollFirst();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
