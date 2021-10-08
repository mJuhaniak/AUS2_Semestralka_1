package structures.TT_Tree;

public class TT_Tree <T extends Comparable<T>>{
    private TT_TreeNode<T> root;

    public <T> TT_Tree() {
        root = null;
    }

    public boolean insert(T data) {
        if (root == null) {
            root = new TT_TreeNode<>();
            root.setData(data, 1);
            root.setnElements(1);
        }
        if (root.getnElements() == 1) {
            
        }
        while (true) {

            break;
        }
        return true;
    }

    public boolean find(TT_Data data) {
        return true;
    }

    public boolean delete(TT_Data data) {
        return true;
    }
}
