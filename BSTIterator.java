import java.util.Iterator;

public class BSTIterator implements Iterator<Player> {

    private Stack<BinNode> s;
    public BSTIterator(BinNode root)
    {
        s = new Stack<>();
        while(root!=null)
        {
            s.push(root);
            root=root.getLeft();
        }

    }
    @Override
    public boolean hasNext() {
        return !s.isEmpty();
    }

    @Override
    public Player next() {
        BinNode temp=s.pop();
        Player player=temp.getPlayer();
        if (temp.getRight()!=null)
        {
            temp=temp.getRight();
            while(temp!=null)
            {
                s.push(temp);
                temp=temp.getRight();
            }
        }
        return player;
    }
}
