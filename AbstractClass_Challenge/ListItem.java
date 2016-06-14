package AbstractClass_Challenge;

import java.util.Objects;

/**
 * Created by subhransumishra on 6/6/16.
 */

public abstract class ListItem {
    protected ListItem next = null;
    protected ListItem prev = null;
    protected Object vale;

    public ListItem(Object value) {
        this.vale = value;
    }

    abstract ListItem next();
    abstract ListItem prev();
    abstract ListItem setNext(ListItem item);
    abstract ListItem setPrev(ListItem item);

    abstract int compareTo(ListItem item);


    public Object getVale() {
        return vale;
    }

    public void setVale(Object vale) {
        this.vale = vale;
    }
}
