
/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - BinaryTree class
 */

import java.util.Iterator;

public class BinaryTree implements Iterable<Player> {

    private BinNode root;

    public BinaryTree() {
        root = null;
    }
    public BinNode getRoot()
    {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // TODO: add the given player to the binary tree based on the player's game score
    public void add(final Player player) {
        BinNode current=root;
        BinNode parent= null; //to store the parent node of current node

        if (root==null)// if the tree has no nodes
        {
            root=new BinNode(player);
            return;
        }
        //traversing the tree
        while (current!=null)
        {
            parent = current;
            //checking the position here of our player according to the score
            if (player.getScore()<current.getPlayer().getScore())
                current=current.getLeft();
            else
                current=current.getRight();
        }
        //constructing a new node and setting it
        if (player.getScore()<parent.getPlayer().getScore())
            parent.setLeft(new BinNode(player));
        else
            parent.setRight(new BinNode(player));
    }
    private void getDescending(BinNode root, StringBuilder order)
    {
        if (root==null)
            return;
        getDescending(root.getRight(),order);
        order.append(root.getPlayer().toString()).append("\n");
        getDescending(root.getLeft(),order);
    }

    // TODO: return a string representation of the binary tree showing all players (one per line) in descending order of scores
    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        getDescending(root,sb); // placeholder
        return  sb.toString();
    }


    // TODO: return an iterator for the binary tree to be used to save the tree in persistent media.
    @Override
    public Iterator<Player> iterator() {
        return new BSTIterator(root);
    }
}