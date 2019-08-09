public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            this.root = item;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(item));
            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(item).setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(item).setPrevious(item.previous());
                    item.setNext(item).setPrevious(item);
                } else {
                    item.setNext(this.root).setPrevious(item);
                    this.root = item;
                }
                return true;
            } else {
                System.out.println(item.getValue() + "already present");
                return false;
            }

        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting " + item.getValue());
        }
        ListItem currItem = this.root;
        while (currItem != null) {
            int comparison = currItem.compareTo(item);
            if (comparison == 0) {
                if (currItem == this.root) {
                    this.root = currItem.next();
                } else {
                    currItem.previous().setNext(currItem.next());
                    if (currItem.next() != null) {
                        currItem.next().setPrevious(currItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) {
                currItem = currItem.next();
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("Empty list");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }

    }


//    @Override
//    public void traverse(ListItem root) {
//        if (root == null) {
//            System.out.println(root.getValue());
//                traverse(root.next());;
//            }
//        }
//
//    }
//}


}
