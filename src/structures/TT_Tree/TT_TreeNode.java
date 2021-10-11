package structures.TT_Tree;

import java.util.ArrayList;

public class TT_TreeNode <T extends Comparable<T>> {
    private TT_TreeNode<T> parent;
    private TT_TreeNode<T> leftSon;
    private TT_TreeNode<T> middleSon;
    private TT_TreeNode<T> rightSon;
    private ArrayList<T> data;
    private int nElements;

    public TT_TreeNode() {
        this.data = new ArrayList<>(2);
        this.data.add(null);
        this.data.add(null);
        this.parent = null;
        nElements = 0;
    }

    public T getData(int n) {
        return this.data.get(n);
    }

    public void setData(int n, T data) {
        this.data.set(n, data);
    }

    public int getNElements() {
        return nElements;
    }

    public void setNElements(int nElements) {
        this.nElements = nElements;
    }

    public TT_TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TT_TreeNode<T> parent) {
        this.parent = parent;
    }

    public TT_TreeNode<T> getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(TT_TreeNode<T> leftSon) {
        this.leftSon = leftSon;
    }

    public TT_TreeNode<T> getRightSon() {
        return rightSon;
    }

    public void setRightSon(TT_TreeNode<T> rightSon) {
        this.rightSon = rightSon;
    }

    public TT_TreeNode<T> getMiddleSon() {
        return middleSon;
    }

    public void setMiddleSon(TT_TreeNode<T> middleSon) {
        this.middleSon = middleSon;
    }
}
