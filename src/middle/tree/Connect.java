package middle.tree;
//每个节点的右向指针
public class Connect {
    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(1);
        a.left = new TreeLinkNode(2);
        a.right = new TreeLinkNode(3);
        connect(a);
        System.out.println(a);

    }

    public static void connect(TreeLinkNode root) {
        //让左节点指向右节点，让右节点指向自己next节点的左节点。
        if (root == null) {
            return;
        }
        TreeLinkNode temp = root;

        while(root!=null) {
            if (root.left == null) {
                break;
            }
            root.left.next = root.right;
            if (root.next == null) {
                root.right.next = null;
            } else {
                root.right.next = root.next.left.next;
            }
            root = root.next;
        }
        if(temp!=null)
            connect(temp.left);
    }
}
