package structures.TT_Tree;

public class TT_Tree <T extends Comparable<T>> {
    private TT_TreeNode<T> root;

    public TT_Tree() {
        root = null;
    }

    public boolean insert(T data) {
        if (root == null) {
            root = new TT_TreeNode<>();
            root.setData(1, data);
            root.setNElements(1);
            return true;
        }

        if (!this.find(data)) {
            TT_TreeNode<T> nodeLetter = findLeafNode(data);

            // Prípad keď nájdený list je 2-vrchol, prvok doňho vložíme
            if (nodeLetter.getNElements() == 1) {
                if (nodeLetter.getData(1).compareTo(data) == 1) {
                    nodeLetter.setData(2, nodeLetter.getData(1));
                    nodeLetter.setData(1, data);
                } else if (nodeLetter.getData(1).compareTo(data) == -1) {
                    nodeLetter.setNElements(2);
                    nodeLetter.setData(2, data);
                } else {
                    return false;
                }
                return true;

            // Prípad keď nájdený list je 3-vrchol
            } else {
                while (nodeLetter != null) {

                }
            }
        }
        
        return true;
    }

    public boolean find(T data) {
        TT_TreeNode<T> actNode = root;
        while (true) {
            if (actNode == null) {
                return false;
            }
            if (actNode.getNElements() == 2) {
                if (actNode.getData(1).compareTo(data) == 0 || actNode.getData(2).compareTo(data) == 0) {
                    return true;
                } else if (actNode.getData(1).compareTo(data) == 1) {
                    actNode = actNode.getLeftSon();
                    continue;
                } else if (actNode.getData(2).compareTo(data) == -1) {
                    actNode = actNode.getRightSon();
                    continue;
                } else if (actNode.getData(1).compareTo(data) == -1 && actNode.getData(2).compareTo(data) == 1) {
                    actNode = actNode.getMiddleSon();
                }
            } else {
                if (actNode.getData(1).compareTo(data) == 0) {
                    return true;
                } else if (actNode.getData(1).compareTo(data) == 1) {
                    actNode = actNode.getLeftSon();
                    continue;
                } else {
                    actNode = actNode.getRightSon();
                    continue;
                }
            }
        }
    }

    public boolean delete(T data) {
        return true;
    }

    private TT_TreeNode<T> findLeafNode(T data) {
        return root;
    }
}
