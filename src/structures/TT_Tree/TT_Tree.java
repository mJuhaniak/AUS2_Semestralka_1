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
        if (this.find(data) == null) {
            TT_TreeNode<T> nodeLetter = findLeafNode(data);

            // Prípad keď nájdený list je 2-vrchol, prvok doňho vložíme
            if (nodeLetter.getNElements() == 1) {
                if (nodeLetter.getData(0).compareTo(data) == 1) {
                    nodeLetter.setData(1, nodeLetter.getData(0));
                    nodeLetter.setData(0, data);
                } else if (nodeLetter.getData(0).compareTo(data) == -1) {
                    nodeLetter.setData(1, data);
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

                        if (!nodeLetter.isLeaf()) {
                            nodeLetter.getLeftSon().setParent(maxNode);
                            nodeLetter.getRightSon().setParent(maxNode);
                        }

                        if (dummyNode.getLeftSon() != null) {
                            dummyNode.getLeftSon().setParent(minNode);
                            dummyNode.getRightSon().setParent(minNode);
                        }

                        minNode.setLeftSon(dummyNode.getLeftSon());
                        minNode.setRightSon(dummyNode.getRightSon());

                    } else if (coming == 2) {
                        minNode.setLeftSon(nodeLetter.getLeftSon());
                        minNode.setRightSon(nodeLetter.getMiddleSon());

                        if (!nodeLetter.isLeaf()) {
                            nodeLetter.getLeftSon().setParent(minNode);
                            nodeLetter.getRightSon().setParent(minNode);
                        }

                        if (dummyNode.getLeftSon() != null) {
                            dummyNode.getLeftSon().setParent(maxNode);
                            dummyNode.getRightSon().setParent(maxNode);
                        }

                        maxNode.setLeftSon(dummyNode.getLeftSon());
                        maxNode.setRightSon(dummyNode.getRightSon());

                    } else {
                        minNode.setLeftSon(nodeLetter.getLeftSon());
                        maxNode.setRightSon(nodeLetter.getRightSon());

                        if (!nodeLetter.isLeaf()) {
                            nodeLetter.getLeftSon().setParent(maxNode);
                            nodeLetter.getRightSon().setParent(maxNode);
                        }
                        if (dummyNode.getLeftSon() != null) {
                            dummyNode.getLeftSon().setParent(minNode);
                            dummyNode.getRightSon().setParent(maxNode);
                        }

                        minNode.setRightSon(dummyNode.getLeftSon());
                        maxNode.setLeftSon(dummyNode.getRightSon());
                    }

                    // Prípad keď nájdený list od ktorého vkladáme prvok má otca
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
                            //middleNode.setParent(nodeLetterParent);
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
        } else {
            return false;
        }
    }

    public TT_TreeNode<T> find(T data) {
        TT_TreeNode<T> actNode = root;
        while (true) {
            if (actNode == null) {
                return null;
            }
            if (actNode.getNElements() == 2) {
                if (actNode.getData(0).compareTo(data) == 0 || actNode.getData(1).compareTo(data) == 0) {
                    return actNode;
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
                    return actNode;
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
        TT_TreeNode<T> actNode = this.find(data);

        if (actNode != null) {
            if (actNode.isLeaf()) {
                if (actNode == root && actNode.getNElements() == 1) {
                    root = null;
                    return true;
                }
                if (actNode.getNElements() == 2) {
                    if (actNode.getData(0).compareTo(data) == 0) {
                        actNode.setData(0, actNode.getData(1));
                    }
                    actNode.setData(1, null);
                    actNode.setNElements(1);
                    return true;
                }
            }

            TT_TreeNode<T> compareNode = findSubNode(actNode, data);
            // Prípad že in-order nasledovník je v liste s dvoma prvkami
            if (compareNode.getNElements() == 2) {

                if (actNode.getData(0).compareTo(data) == 0) {
                    actNode.setData(0, compareNode.getData(0));
                } else {
                    actNode.setData(1, compareNode.getData(0));
                }

                compareNode.setData(0, compareNode.getData(1));
                compareNode.setData(1, null);
                return true;
            } else {
                if (actNode.getData(0).compareTo(data) == 0) {
                    actNode.setData(0, compareNode.getData(0));
                } else {
                    actNode.setData(1, compareNode.getData(0));
                }
                compareNode.setData(0, null);
                compareNode.setNElements(0);
            }

            while (compareNode.getNElements() == 0) {
                // Prípad keď v je prázdny koreň s jedným synom - prázdny node je vytlačený hore
                if (compareNode == this.root && compareNode.getNSons() == 1) {
                    this.root = compareNode.getLeftSon();
                    this.root.setParent(null);
                    return true;
                }

                TT_TreeNode<T> brotherNode = findBrother(compareNode);
                TT_TreeNode<T> parentNode = compareNode.getParent();

                // Prípad keď prázdny vrchol má priameho brata s dvomi prvkami
                if (brotherNode.getNElements() == 2) {
                    T newKey;
                    if (parentNode.getNElements() == 2 && (parentNode.getRightSon() == compareNode ||
                            parentNode.getRightSon() == brotherNode)) {

                        newKey = parentNode.getData(1);
                        if (parentNode.getRightSon() == compareNode) {
                            parentNode.setData(1, brotherNode.getData(1));
                        } else {
                            parentNode.setData(1, brotherNode.getData(0));
                            brotherNode.setData(0, brotherNode.getData(1));
                        }

                    } else {
                        newKey = parentNode.getData(0);
                        if (parentNode.getRightSon() == brotherNode) {
                            parentNode.setData(0, brotherNode.getData(0));
                            brotherNode.setData(0, brotherNode.getData(1));
                        } else {
                            parentNode.setData(0, brotherNode.getData(1));
                        }
                    }
                    brotherNode.setData(1, null);
                    brotherNode.setNElements(1);
                    compareNode.setData(0, newKey);
                    compareNode.setNElements(1);

                    // Zmena vzťahov v prípade, že dané vrcholy sú interné
                    if (!compareNode.isLeaf()) {
                        if (compareNode.getLeftSon().getData(0).compareTo(brotherNode.getRightSon().getData(0)) == 1) {
                            compareNode.setRightSon(compareNode.getLeftSon());
                            compareNode.setLeftSon(brotherNode.getRightSon());
                            brotherNode.setRightSon(brotherNode.getMiddleSon());
                        } else {
                            compareNode.setRightSon(brotherNode.getLeftSon());
                            brotherNode.setLeftSon(brotherNode.getMiddleSon());
                        }
                    }

                    // Prípad keď prázdny vrchol má priameho brata s jedným prvkom
                } else {
                    T newKey;
                    if (parentNode.getNElements() == 2 && (parentNode.getRightSon() == compareNode ||
                            parentNode.getRightSon() == brotherNode)) {
                        newKey = parentNode.getData(1);
                        if (parentNode.getRightSon() == brotherNode) {
                            brotherNode.setData(1, brotherNode.getData(0));
                            brotherNode.setData(0, newKey);
                        } else {
                            brotherNode.setData(1, newKey);
                        }
                        parentNode.setRightSon(brotherNode);

                    } else  {
                        newKey = parentNode.getData(0);
                        if (parentNode.getLeftSon() == brotherNode) {
                            brotherNode.setData(1, parentNode.getData(0));
                        } else {
                            brotherNode.setData(1, brotherNode.getData(0));
                            brotherNode.setData(0, newKey);
                        }
                        parentNode.setLeftSon(brotherNode);

                        if (parentNode.getNElements() == 1) {
                            parentNode.setData(0, null);
                            parentNode.setNElements(0);
                            compareNode = parentNode;
                            continue;
                        }
                    }
                    brotherNode.setNElements(2);
                    parentNode.setMiddleSon(null);
                    parentNode.setData(1, null);
                    parentNode.setNElements(1);
                    compareNode.setNElements(1);

                    // Zmena vzťahov v prípade, že dané vrcholy sú interné
                    if (!compareNode.isLeaf()) {
                        if (compareNode.getLeftSon().getData(0).compareTo(brotherNode.getRightSon().getData(0)) == 1) {
                            brotherNode.setMiddleSon(brotherNode.getRightSon());
                            brotherNode.setRightSon(compareNode.getLeftSon());
                        } else {
                            brotherNode.setMiddleSon(brotherNode.getLeftSon());
                            brotherNode.setLeftSon(compareNode.getLeftSon());
                        }
                        compareNode.setLeftSon(brotherNode);
                    }
                }
            }
            return true;
        }
        return false;
    }

    private TT_TreeNode<T> findBrother(TT_TreeNode<T> compareNode) {
        TT_TreeNode<T> resultNode = null;
        TT_TreeNode<T> fatherNode = compareNode.getParent();

        if (fatherNode.getNElements() == 1) {
            if (compareNode == fatherNode.getLeftSon()) {
                resultNode = fatherNode.getRightSon();
            } else {
                resultNode = fatherNode.getLeftSon();
            }
        } else {
            if (compareNode == fatherNode.getLeftSon() || compareNode == fatherNode.getRightSon()) {
                resultNode = fatherNode.getMiddleSon();
            } else {
                if (fatherNode.getLeftSon().getNElements() == 2) {
                    resultNode = fatherNode.getLeftSon();
                } else {
                    resultNode = fatherNode.getRightSon();
                }
            }
        }

        return resultNode;
    }

    private TT_TreeNode<T> findSubNode(TT_TreeNode<T> actNode, T data) {
        TT_TreeNode<T> dummy;
        TT_TreeNode<T> resultSubNode = null;

        // V prípade že ide o list s jedným prvkom
        if (actNode.isLeaf()) {
            return actNode;
        }

        // V prípade, že nejde o list in-order nasledovníkom bude najľavejší syn pravého syna aktuálneho vrcholu
        if (actNode.getNElements() == 2 && data.compareTo(actNode.getData(0)) == 0) {
            dummy = actNode.getMiddleSon();
        } else {
            dummy = actNode.getRightSon();
        }

        while (dummy != null) {
            resultSubNode = dummy;
            dummy = dummy.getLeftSon();
        }

        return resultSubNode;
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
