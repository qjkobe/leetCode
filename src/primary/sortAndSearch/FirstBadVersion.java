package primary.sortAndSearch;

//你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
public class FirstBadVersion {
    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        //二分，要保证前一个是正确的后一个是错误的。
        int lo = 1;
        int hi = n;
        if (lo == hi) {
            return 1;
        }
        if (isBadVersion(1)) {
            return 1;
        }
        while (lo < hi) {
            int mid = lo+(hi-lo)/2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static boolean isBadVersion(int version) {
        return true;
    }
}
