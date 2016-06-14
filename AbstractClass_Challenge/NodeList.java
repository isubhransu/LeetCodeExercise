package AbstractClass_Challenge;

/**
 * Created by subhransumishra on 6/6/16.
 */
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
