class Solution {
    public boolean isValid(String s) {
       Stack<Character> chars = new Stack<>();
       char[] charConv = s.toCharArray();
       for(int i = 0; i < charConv.length; i++)
       {
        if((charConv[i] == '(') || (charConv[i] == '{') || (charConv[i] == '['))
        {
            chars.push(charConv[i]);
        }
        else
        {
            if(chars.empty())
            {
                return false;
            }
            else if((charConv[i] == ')') && (chars.pop() != '('))
            {
                return false;
            }
            else if((charConv[i] == '}') && (chars.pop() != '{'))
            {
                return false;
            }
            else if((charConv[i] == ']') && (chars.pop() != '['))
            {
                return false;
            }
        }
       } 
       return chars.empty();
    }
}
