import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

public class Windowgame {
    static JTextArea story = new JTextArea();
    static JTextField text = new JTextField(1);
    static JPanel panel = new JPanel();
    static boolean enter = false;
    static String x;
    static boolean key1 = false;
    static boolean unlockdoor1 = false;
    static boolean key2 = false;
    static boolean unlockdoor2 = false;
    static boolean findkey2 = false;
    static boolean almost = false;
    static void switchone() {
        switch (x) {
            case "look around":
                story.setText("The room appears to be empty except for some trash on the ground.");
                if (key1 == false) {
                    story.append("\nRustling through the trash, you find a key!");
                    key1 = true;
                }
                story.append("\nThere is a door on the opposite side of the room");
                break;
            case "open door":
            case "look at door":
            case "walk to door":
            case "use door":
            case "inspect door":
            case "door":
            case "walk through door":
            case "enter door":
            case "enter doorway":
            case "look door":
            case "interact door":
            case "walk through doorway":
                if (unlockdoor1 == true) {
                    story.setText("You walk through the door. On the other side, there is a medium size room. There is a door near the opposite wall to the right. There is a desk and a few shelves in the room.");
                } else if (key1 == true) {
                    story.setText("You unlock the door.");
                    unlockdoor1 = true;
                } else {
                    story.setText("The door seems to be made of a sturdy metal. It is locked, and you have no tool to force it open.");
                }
                break;
            default:
            story.setText("That is not an available action");
                break;
        }
        enter = false;
    }
    static void switchtwo() {
        switch(x) {
            case "look around":
            story.setText("There are some empty shelves to your right.\nOn the opposite side of the room you notice a desk with a few papers on it.\nTo your left is an empty wall.");
            break;
            case "shelves":
            case "inspect shelves":
            case "look at shelves":
            case "use shelves":
            case "look shelves":
            if (findkey2 == true && key2 == false) {
                story.setText("Looking closer, you notice a key taped to the bottom of the lowest shelf.");
                key2 = true;
            } else {
                story.setText("The shelves are empty, with a fine layer of dust. You wonder why there are even shelves here if they are used for nothing.");
            }
            break;
            case "inspect desk":
            case "look at desk":
            case "look at papers":
            case "use desk":
            case "desk":
            case "papers":
            case "inspect papers":
            case "interact papers":
            case "interact desk":
            case "use papers":
            case "look desk":
            case "look papers":
            story.setText("There is a plain, metal desk. The papers lying on it are covered in symbols, but you don't understand them.");
            break;
            case "open door":
            case "look at door":
            case "walk to door":
            case "use door":
            case "inspect door":
            case "door":
            case "walk through door":
            case "enter door":
            case "enter doorway":
            case "look door":
            case "interact door":
            case "walk through doorway":
            if (unlockdoor2 == true && almost == false) {
                story.setText("You open the door, but see nothing. As you stare into the void, it stares back into you. This isn't your first experience, this won't be your last.\nSoon you will hide the keys again, and soon you will lock yourself once more in the room, trying to forget the void you find yourself trapped in.\nAre you ready to start again?");
                almost = true;
            } else if (key2 == true){
                story.setText("You unlock the door with a loud thunk. It seems like it is slightly rusted, and hasn't been used in a long time.");
                unlockdoor2 = true;
            } else {
                story.setText("Another hard metal door. Needless to say, you can't force it open either. They key might be around here if you look closer.");
            findkey2 = true;
            }
            break;
            default:
            story.setText("That is not an available action.");
            break;
        }
    }
    static KeyListener listener = new KeyAdapter() {
        public void keyPressed(KeyEvent ev) {
            int keyCode = ev.getKeyCode();
            if (keyCode == KeyEvent.VK_ENTER) {
                x = text.getText();
                text.setText("");
                if (almost == true) {
                    story.setText("As if you had a choice in the matter.");
                    story.append("\nThe end! I hope you enjoyed my first game. (★ ≧ ▽ ^ ))★ ☆");
                    end = true;
                } else if (unlockdoor1 == true) {
                    switchtwo();
                } else {
                    switchone();
                }
            }
        }
    };
    public static void main(String args[]) {
        setup();
        firstroom();
        while (end == false) {
            if (end == true) {
                return;
            }
        }
    }

    public static void setup() {
        JFrame frame = new JFrame("Varus");
        frame.setSize(1000, 1000);
        panel.setLayout(new GridLayout(2, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        story.setBackground(new java.awt.Color(0, 0, 0));
        story.setForeground(Color.white);
        story.setCaretColor(Color.white);
        story.setEditable(false);
        panel.add(story);
        text.setBackground(new java.awt.Color(0, 0, 0));
        text.setForeground(Color.white);
        text.setCaretColor(Color.white);
        text.setSize(100, 1);
        text.setLocation(0, 0);
        panel.setBackground(Color.black);
        text.addKeyListener(listener);
        panel.add(text);
        frame.add(panel);
        frame.setVisible(true);
        
    }
    public static boolean end = false;
    public static void firstroom() {
        story.setText("You wake up in a dimly lit room.");
        story.append("\nSurrounding you are walls made of concrete.");
        story.append("\nYou notice a door on the opposite side of the room.");
        return;
    }
}
