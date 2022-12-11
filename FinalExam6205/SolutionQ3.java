package FinalExam6205;

// time complexity O(n) , space complexity O(n)
// time complexity O(n) , space complexity O(n)
class SolutionQ3 {
    public String minRemoveToMakeValid(String str) {
        // initilize the string builder
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (char ch : str.toCharArray()) {
            // when we meet '(', add the cout++
            if (ch == '(')
                cnt++;
            // when number of ')' is less than '(', then we don't add ')',
            // otherwise append the char to the stringbuilder
            if (!(ch == ')' && cnt == 0))
                sb.append(ch);
            // when we meet the ')' and there are '(' before,
            // decrease the number of the cnt
            if (ch == ')' && cnt > 0)
                cnt--;
        }
        // we need to reverse iterate the string because the length of the sb are changing
        for (int i = sb.length() - 1; i >= 0 && cnt != 0; i--) {
            // finally if there are more '(', remove the redunct '(' from the right
            if (sb.charAt(i) == '(') {
                cnt--;
                sb.deleteCharAt(i);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SolutionQ3 obj = new SolutionQ3();
        String res = obj.minRemoveToMakeValid("lee(t(c)o)de)");
        // the result should be "lee(t(co)de)" or "lee(t(c)ode)" or "lee(t(c)o)de"
        System.out.println(res);
    }

}



