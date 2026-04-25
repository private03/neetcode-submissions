class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stackChars = new Stack<>();
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == '(' || array[i] == '{' || array[i] == '[' )
            {
                stackChars.push(array[i]);
            } 
            else {
                if(stackChars.isEmpty()){
                    return false; 
                }
                else if((array[i] == ')') && (stackChars.pop() != '('))
                {
                    return false;
                }
                else if((array[i] == '}') && (stackChars.pop() != '{'))
                {
                    return false;
                }
                else if((array[i] == ']') && (stackChars.pop() != '['))
                {
                    return false;
                } 
            }
        }
        return stackChars.empty();
        
    }
}
