package solutions;
import java.util.Stack;

class StackSolution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        char[] chars = s.toCharArray();
        for(char ch: chars){
            if (ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);}
            else{
                if (stack.isEmpty())
                    return false;

                char top=stack.pop();
                if (ch==')'&& top!='(') return false;
                if (ch==']'&& top!='[') return false;
                if(ch=='}'&& top!='{') return false;

            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        StackSolution solution= new StackSolution();
        String[] testCases={"([)]",
                "()[]{}",
                "(]",
                "([])",
                "([)]"
        };
        for(String testcase:testCases){
            boolean result=solution.isValid(testcase);
            System.out.printf("Input string %s => Result: %b%n",testcase,result);
        }
    }
}
