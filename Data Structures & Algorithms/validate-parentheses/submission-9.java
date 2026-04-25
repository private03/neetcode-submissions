
class Solution {
    Stack<Character> theStack = new Stack<>();
    public boolean isValid(String s) {
        int sizeofString = s.length();
        int numberofOpenings = 0;
        int numberofClosing = 0;
        if(sizeofString % 2 != 0)
        {
            return false;
        }
        else if(!s.contains("}") && !s.contains(")") && !s.contains("]"))
        {
            return false;
        } 
        boolean result = true;
        for (int i = 0; i < s.length(); i++)
        {
            theStack.push(s.charAt(i));
            if( s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' )
            {
               numberofOpenings++; 
            }
            
            if(s.charAt(i) == ')') 
            {
                System.out.println((i-1));
                System.out.println(theStack.lastIndexOf('(')); 
                if((theStack.lastIndexOf('(') != (sizeofString- (1+i))) && (theStack.lastIndexOf('(') != i-1 ))
                { result = false; }
                numberofClosing++;
            } 
            else if (s.charAt(i) == ']') 
            {
                System.out.println((i-1));
                System.out.println(theStack.lastIndexOf('[')); 
                if((theStack.lastIndexOf('[') != (sizeofString- (1+i))) && (theStack.lastIndexOf('[') != i-1 ))
                { result = false; }
                numberofClosing++;
            }
            else if (s.charAt(i) == '}')
            {
                System.out.println((i-1));
                System.out.println(theStack.lastIndexOf('{')); 
                if((theStack.lastIndexOf('{') != (sizeofString- (1+i))) && (theStack.lastIndexOf('{') != i-1 ))
                { result = false; }
                numberofClosing++;
            }
            else if (s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')')
            {
                return false;
            }

            
            
        }

        if(numberofOpenings != numberofClosing)
            {
                return false;
            }
        return result;
    }
}
