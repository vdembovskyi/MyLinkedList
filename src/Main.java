public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(null);
        myLinkedList.traverse(myLinkedList.getRoot());


        String stringData = "TestWord1 TestWord2 TestWord3 TestWord4 TestWord5";

        String[] data = stringData.split(" ");
        for (String s : data) {
            myLinkedList.addItem(new Node(s));

            // create new item with value set to the string s
        }
        myLinkedList.traverse(myLinkedList.getRoot());


        SearchTree searchTree = new SearchTree(null);
    }

}
