/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - Leaderboard class
 * Name(s):
 */

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class Leaderboard {

    private static final String FILE_NAME = "players.csv";
    private BinaryTree boards[];

    // TODO: finish the implementation of the method
    public Leaderboard() throws IOException {
        // TODO: initialize one BinaryTree for each game (must use "boards" instance variable)
        boards=new BinaryTree[3];
        for(int i=0;i<3;i++)
            boards[i]=new BinaryTree();

        // TODO: add all players in "players.csv" to the right BinaryTree based on the games that they are playing
        BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\dell\\Downloads\\Game Leader Board\\players.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            boards[Integer.parseInt(data[1])].add(new Player(data[0],Integer.parseInt(data[2])));
        }
        csvReader.close();
    }

    // TODO: add the player with the given name and score to the correct binary tree depending on the informed game parameter (to simplify, assume that the given player is NOT currently in the binary tree)
    public void add(final String name, final Game game, int score) {
        boards[game.getValue()].add(new Player(name,score));
    }

    // TODO: display the BinaryTree associated with the given game
    public void list(final Game game) {
        System.out.println(boards[game.getValue()].toString());
    }

    void printPostorder(BinNode node,StringBuilder sb,int game)
    {
        if (node == null)
            return;
        printPostorder(node.getLeft(),sb,game);
        printPostorder(node.getRight(),sb,game);
        sb.append(node.getPlayer().getName());
        sb.append(',');
        sb.append(game);
        sb.append(',');
        sb.append(node.getPlayer().getScore());
        sb.append("\n");
    }

    // TODO: save all binary trees into "players.csv"
    public void save() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("players.csv"));
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<3;i++)
        {
           printPostorder(boards[i].getRoot(),sb,i);
        }
        writer.write(sb.toString());
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        Leaderboard lb = new Leaderboard();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Options: [list | add | save | exit]");
            System.out.print("? ");
            String option = sc.nextLine();
            if (option.equals("list")) {
                System.out.println("game? ");
                Game game = Game.values()[Integer.parseInt(sc.nextLine())];
                lb.list(game);
            }
            else if (option.equals("add")) {
                System.out.println("name? ");
                String name = sc.nextLine();
                System.out.println("game? ");
                Game game = Game.values()[Integer.parseInt(sc.nextLine())];
                System.out.println("score? ");
                int score = Integer.parseInt(sc.nextLine());
                lb.add(name, game, score);
            }
            else if (option.equals("save"))
                lb.save();
            else
                break;
        }
    }
}