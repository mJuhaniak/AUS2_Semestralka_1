package structures.TT_Tree;

import java.util.ArrayList;

public class TT_TreeNode <T extends Comparable<T>> {
    private TT_TreeNode parent;
    private TT_TreeNode leftSon;
    private TT_TreeNode rightSon;
    private TT_TreeNode middleSon;
    private ArrayList<T> data;
    private int nElements;

    public TT_TreeNode() {
        this.data = new ArrayList<>(2);
        this.parent = null;
        this.leftSon = null;
        this.rightSon = null;
        this.middleSon = null;
        nElements = 0;
    }

    public TT_TreeNode getParent() {
        return parent;
    }

    public void setParent(TT_TreeNode parent) {
        this.parent = parent;
    }

    public TT_TreeNode getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(TT_TreeNode leftSon) {
        this.leftSon = leftSon;
    }

    public TT_TreeNode getRightSon() {
        return rightSon;
    }

    public void setRightSon(TT_TreeNode rightSon) {
        this.rightSon = rightSon;
    }

    public TT_TreeNode getMiddleSon() {
        return middleSon;
    }

    public void setMiddleSon(TT_TreeNode middleSon) {
        this.middleSon = middleSon;
    }

    public int getnElements() {
        return nElements;
    }

    public void setnElements(int nElements) {
        this.nElements = nElements;
    }

    public T getData(int n) {
        return data.get(n);
    }

    public void setData(T data, int index) {
        this.data.set(index, data);
    }
}
