package primary.string;
//实现 atoi，将字符串转为整数。
//
//在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
//
//字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
//
//当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
//
//若函数不能执行有效的转换，返回 0。
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("-   234"));
    }

    public static int myAtoi(String str){
        if (str.isEmpty()) {
            return 0;
        }
        int res = 0;
        int flag = 1;
        int countflag = 0;//符号位只能出现一次
        int countspace = 0;
        char[] a = str.toCharArray();
        for(int i = 0; i < a.length; i++) {
            if (countspace!=1 && a[i] == ' ') {

                continue;
            }
            if(countflag != 1 && a[i] == '-'){
                flag = -1;
                countflag = 1;
                countspace = 1;
                continue;
            }
            if(countflag != 1 && a[i] == '+'){
                countflag = 1;
                countspace = 1;
                continue;
            }
            if (a[i] > '9' || a[i] < '0') {
                return res * flag;
            } else {
                countflag = 1;
                countspace = 1;
                int temp = res * 10 + a[i] - '0';
                if(temp/100 != res/10)//后面加的数字相当于忽略了
                    return flag == -1?Integer.MIN_VALUE:Integer.MAX_VALUE;
                res = res * 10 + a[i] - '0';
            }

        }
        return res * flag;
    }
}
