package structures.TT_Tree;

public class TT_Tree <T extends Comparable<T>> {
    private TT_TreeNode<T> root;

    public TT_Tree() {
        root = null;
    }

    public boolean insert(T data) {
        if (root == null) {
            root = new TT_TreeNode<>();
            root.setData(0, data);
            root.setNElements(1);
            return true;
        }

        TT_TreeNode<T> dummyNode = new TT_TreeNode<>();
        if (!this.find(data)) {
            TT_TreeNode<T> nodeLetter = findLeafNode(data);

            // Prípad keď nájdený list je 2-vrchol, prvok doňho vložíme
            if (nodeLetter.getNElements() == 1) {
                if (nodeLetter.getData(0).compareTo(data) == 1) {
                    nodeLetter.setData(1, nodeLetter.getData(0));
                    nodeLetter.setData(0, data);
                } else if (nodeLetter.getData(0).compareTo(data) == -1) {
                    nodeLetter.setData(1, data);
                } else {
                    return false;
                }
                nodeLetter.setNElements(2);
                return true;

            // Prípad keď nájdený list je 3-vrchol
            } else {
                while (true) {
                    TT_TreeNode<T> minNode = new TT_TreeNode<>();
                    TT_TreeNode<T> maxNode = new TT_TreeNode<>();
                    TT_TreeNode<T> middleNode = new TT_TreeNode<>();
                    int coming;
                    // Rozdelenie 3-vrchola na vrcholy minNode a maxNode, stred môže byť potencionálne uložený do rodiča
                    if (nodeLetter.getData(0).compareTo(data) == 1) {
                        minNode.setData(0, data);
                        minNode.setNElements(1);
                        maxNode.setData(0, nodeLetter.getData(1));
                        maxNode.setNElements(1);
                        middleNode.setData(0, nodeLetter.getData(0));
                        middleNode.setNElements(1);
                        coming = 1;

                    } else if (nodeLetter.getData(1).compareTo(data) == -1){
                        maxNode.setData(0, data);
                        maxNode.setNElements(1);
                        minNode.setData(0, nodeLetter.getData(0));
                        minNode.setNElements(1);
                        middleNode.setData(0, nodeLetter.getData(1));
                        middleNode.setNElements(1);
                        coming = 2;
                    } else {
                        minNode.setData(0, nodeLetter.getData(0));
                        minNode.setNElements(1);
                        maxNode.setData(0, nodeLetter.getData(1));
                        maxNode.setNElements(1);
                        middleNode.setData(0, data);
                        middleNode.setNElements(1);
                        coming = 0;
                    }
                    minNode.setParent(nodeLetter.getParent());
                    maxNode.setParent(nodeLetter.getParent());

                    if (coming == 1) {
                        maxNode.setLeftSon(nodeLetter.getLeftSon());
                        maxNode.setRightSon(nodeLetter.getRightSon());

                        if (dummyNode.getLeftSon() != null) {
                            dummyNode.getLeftSon().setParent(minNode);
                            dummyNode.getRightSon().setParent(minNode);
                        }

                        minNode.setLeftSon(dummyNode.getLeftSon());
                        minNode.setRightSon(dummyNode.getRightSon());

                    } else if (coming == 2) {
                        minNode.setLeftSon(nodeLetter.getLeftSon());
                        minNode.setRightSon(nodeLetter.getMiddleSon());

                        if (dummyNode.getLeftSon() != null) {
                            dummyNode.getLeftSon().setParent(maxNode);
                            dummyNode.getRightSon().setParent(maxNode);
                        }

                        maxNode.setLeftSon(dummyNode.getLeftSon());
                        maxNode.setRightSon(dummyNode.getRightSon());



                    } else {
                        minNode.setLeftSon(nodeLetter.getLeftSon());
                        maxNode.setRightSon(nodeLetter.getRightSon());

                        if (dummyNode.getLeftSon() != null) {
                            dummyNode.getLeftSon().setParent(minNode);
                            dummyNode.getRightSon().setParent(maxNode);
                        }

                        minNode.setRightSon(dummyNode.getLeftSon());
                        maxNode.setLeftSon(dummyNode.getRightSon());
                    }



                    if (nodeLetter.hasParent()) {
                        TT_TreeNode<T> nodeLetterParent = nodeLetter.getParent();

                        if (nodeLetterParent.getNElements() == 1) {
                            if (nodeLetterParent.getData(0).compareTo(middleNode.getData(0)) == 1) {
                                nodeLetterParent.setData(1, nodeLetterParent.getData(0));
                                nodeLetterParent.setData(0, middleNode.getData(0));
                                
                                nodeLetterParent.setLeftSon(minNode);
                                nodeLetterParent.setMiddleSon(maxNode);

                            } else {
                                nodeLetterParent.setData(1, middleNode.getData(0));
                                
                                nodeLetterParent.setMiddleSon(minNode);
                                nodeLetterParent.setRightSon(maxNode);

                            }
                            nodeLetterParent.setNElements(2);
                            return true;
                        } else {
                            dummyNode.setLeftSon(minNode);
                            dummyNode.setRightSon(maxNode);
                            nodeLetter = nodeLetterParent;
                            data = middleNode.getData(0);
                            continue;
                        }
                    } else {
                        this.root = middleNode;
                        root.setLeftSon(minNode);
                        root.setRightSon(maxNode);
                        minNode.setParent(root);
                        maxNode.setParent(root);
                        return true;
                    }
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
                if (actNode.getData(0).compareTo(data) == 0 || actNode.getData(1).compareTo(data) == 0) {
                    return true;
                } else if (actNode.getData(0).compareTo(data) == 1) {
                    actNode = actNode.getLeftSon();
                    continue;
                } else if (actNode.getData(1).compareTo(data) == -1) {
                    actNode = actNode.getRightSon();
                    continue;
                } else if (actNode.getData(0).compareTo(data) == -1 && actNode.getData(1).compareTo(data) == 1) {
                    actNode = actNode.getMiddleSon();
                }
            } else {
                if (actNode.getData(0).compareTo(data) == 0) {
                    return true;
                } else if (actNode.getData(0).compareTo(data) == 1) {
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
        TT_TreeNode<T> actNode = root;
        TT_TreeNode<T> nextNode = null;
        TT_TreeNode<T> lastNode = null;

        while (actNode != null) {
            if (actNode.getNElements() == 1) {
                if (actNode.getData(0).compareTo(data) == 1) {
                    nextNode = actNode.getLeftSon();
                } else {
                    nextNode = actNode.getRightSon();
                }
            } else if (actNode.getNElements() == 2) {
                if (actNode.getData(0).compareTo(data) == 1) {
                    nextNode = actNode.getLeftSon();
                } else if (actNode.getData(1).compareTo(data) == -1) {
                    nextNode = actNode.getRightSon();
                } else if (actNode.getData(0).compareTo(data) == -1 && actNode.getData(1).compareTo(data) == 1) {
                    nextNode = actNode.getMiddleSon();
                }
            }
            lastNode = actNode;
            actNode = nextNode;
        }
        return lastNode;
    }
}
