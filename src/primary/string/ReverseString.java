package primary.string;
//请编写一个函数，其功能是将输入的字符串反转过来。
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString2("hello"));
    }

    public static String reverseString(String s) {
        //弄一个新字符串
        StringBuilder resb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--) {
            resb.append(s.charAt(i));
        }
        return resb.toString();
        //StringBuilder速度真得很慢，这种情况用char[]会更好
    }

    public static String reverseString2(String s){
        //首尾两指针互换。
        char[] a = s.toCharArray();
        char temp = 0;
        for(int i = 0; i < s.length()/2; i++) {
            temp = a[i];
            a[i] = a[s.length() - 1 - i];
            a[s.length() - 1 - i] = temp;
        }
        return new String(a);
    }
}
