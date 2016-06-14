package AbstractClass_Challenge;

/**
 * Created by subhransumishra on 6/6/16.
 */
public class MyLinkedList implements NodeList{

    private ListItem root = null;
    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            root = newItem;
            return true;
        }else{
            ListItem currentItem = root;
            while(currentItem != null){
                int compare = currentItem.compareTo(newItem);
                if(compare < 0){
                    //New Item is greater, move right if possible.
                    if(currentItem.next != null){
                        currentItem = currentItem.next;
                    }else{
                        currentItem.setNext(newItem);
                        newItem.setPrev(currentItem);
                        return true;
                    }
                }else
                    if(compare>0){
                        //New Item is less, place it there.
                        if(currentItem.prev() != null){
                            currentItem.prev().setNext(newItem);
                            newItem.setNext(currentItem);
                            return true;
                        }else {
                            currentItem.setPrev(newItem);
                            newItem.setNext(currentItem);
                            return true;
                        }
                    }
            }
        }
        return false;

    }

    @Override
    public boolean removeItem(ListItem item) {

        ListItem currentIten = getRoot();
        while(currentIten != null) {
            if(currentIten == item){
                currentIten.prev().setNext(currentIten.next());
                currentIten.next().setPrev(currentIten.prev());
                System.out.println("Item removed");
                return true;
            }
            currentIten.setNext(currentIten);
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        ListItem currentIten = getRoot();
        while(currentIten != null) {
            System.out.println(currentIten.getVale().toString());
            currentIten = currentIten.next();
        }

    }
}
