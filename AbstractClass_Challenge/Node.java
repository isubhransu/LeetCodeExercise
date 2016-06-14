package AbstractClass_Challenge;

/**
 * Created by subhransumishra on 6/6/16.
 */

public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.next;
    }

    @Override
    ListItem prev() {
        return this.prev;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.next = item;
        return this.next;
    }

    @Override
    ListItem setPrev(ListItem item) {
        this.prev = item;
        return this.prev;
    }

    @Override
    int compareTo(ListItem item) {
        if(item != null) {
            return ((String) item.getVale()).compareTo((String) this.getVale());
        }else{
            return -1;
        }
    }
}
