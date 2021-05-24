public class Test1 {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        if(n == 1) return 1;
        StringBuffer sb = new StringBuffer();
        int res = 0, ans = 0, result = 0;
        for(int i = 0 ; i < n ; i++) {
            if(sb.length() == 0) {
                sb.append(s.charAt(i));
                res = 1;
                continue;
            }else {
                String temp = sb.toString();
                int j;
                for(j = 0 ; j < temp.length() ; j++) {
                    if(temp.charAt(j) == s.charAt(i)) {
                        break;
                    }
                }
                if(j == temp.length()) {
                    sb.append(s.charAt(i));
                    res++;
                }else {
                    sb = new StringBuffer();
                    i -= temp.length()-1;
                    sb.append(s.charAt(i));
                    ans = res;
                    res = 1;
                }
                result = Math.max(result,Math.max(ans,res));
            }
        }
        return result;
    }
}
