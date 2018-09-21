package primary.string;

//实现 strStr() 函数。
//
//给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("ababc", "abc"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        // 这个和求next很像。next本质也是匹配。
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        int[] next = getNext(needle);
        int j = 0;
        int i = 0;
        for (; i < a.length && j < b.length;) {
            if (j == -1 || a[i] == b[j]) {
                j++; // j为-1时表示要移动的是i而不是j。
                i++; // a[i]=b[j]此时说明正在匹配，i和j都往前走。
            } else {
                j = next[j]; // 一旦发生不匹配，j就回溯到应该的位置。
                //如果j回溯到了0，还不匹配就会回溯到-1，然后i和j都会加1.
            }
        }
        if (j == b.length) {
            return i - j;
        }else
            return -1;
    }

    public static int[] getNext(String ps) {
        //next[j]的值表示当j!=i的时候，j下一步移动位置。
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1; //当j为0时，j不需要移动，需要移动的是i。

        int j = 0;
        int k = -1; //k用来控制前缀长度。
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) { //p[j]=p[k] 0到k-1和j-k到j-1已经匹配
                if(p[++j] == p[++k])
                    //因为只有不匹配会触发next，当前后两个字符相等的时候，说明前面那个也是不匹配的。
                    //然后前面的会再触发一次next。相当于就是next[k]。
                    next[j] = next[k];
                else
                    next[j] = k;
                //j为1时，肯定是0，因为前面就一个字母。
            } else //如果不相等，k要回溯。很像是前缀定位后缀，不相等了就回溯。
                k = next[k];
        }
        return next;
    }
}
