package primary.string;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("sdsdsdsd"));
    }

    public static boolean isPalindrome(String s) {
        //很多种方法。这里使用两边对称法。
        s = s.toLowerCase();

        char[] a = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i<j) {
            if(!(a[i]<='9' && a[i]>='0') && !(a[i]<='z' && a[i]>='a')) {
                i++;
                continue;
            }
            if (!(a[j]<='9' && a[j]>='0') && !(a[j]<='z' && a[j]>='a')) {
                j--;
                continue;
            }
            if (a[i] != a[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
