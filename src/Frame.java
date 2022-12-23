import javax.swing.*;
import java.awt.*;

public class Frame {
    JFrame frame = new JFrame("Test");
    JPanel grid = new JPanel(new GridLayout(10, 3, 20, 20) );
    JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));
    Container container = frame.getContentPane();

    private static JLabel label   = null;

    static JDialog modalReplace = new JDialog();
    static String[] butName = { "dungeon1", "dungeon2", "dungeon3", "dungeon4", "dungeon5", "dungeon6", "dungeon7", "dungeon8", "dungeon9", "dungeon10",
            "quest1", "quest2", "quest3", "quest4", "quest5", "quest6", "quest7", "quest8", "quest9", "quest10",
            "quest11", "quest12", "quest13", "quest14", "quest15", "quest16", "quest17", "quest18", "quest19", "quest20" };

    public void frameCreator() {
        frame.setSize(new Dimension(1024, 768));
        frame.setMinimumSize(new Dimension(1024, 768));
        frame.setMaximumSize(new Dimension(1024, 768));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        flow.add(grid);

        container.add(flow, BorderLayout.WEST);

        modalFrame();
    }
    public void buttonsCreator(){
        for (int i = 0; i < 30; ++i) {
            JButton b = new JButton((butName[i]));
            b.setFocusPainted(false);
            int finalI = i;
            b.addActionListener(e -> new JsonManager().setClick(Integer.parseInt(String.valueOf(finalI))));
            grid.add(b);
        }
    }

    public void modalFrame(){
        label = new JLabel("Значение уже существует. Перезаписать?");
        label.setFont(new Font("Roboto", Font.BOLD, 14));

        JButton modalBut1 = new JButton("Да");
        JButton modalBut2 = new JButton("Нет");
        modalBut1.setFocusPainted(false);
        modalBut2.setFocusPainted(false);
        modalBut1.addActionListener(e -> new JsonManager().jsonReplace());
        modalBut2.addActionListener(e -> Frame.modalReplace.setVisible(false));

        modalReplace.setVisible(false);
        modalReplace.setLocationRelativeTo(null);
        modalReplace.setSize(350, 100);
        modalReplace.setLocation(960-175, 509-50);
        modalReplace.setLayout(new FlowLayout(FlowLayout.CENTER));
        modalReplace.add(label);
        modalReplace.add(modalBut1);
        modalReplace.add(modalBut2);
    }

    void frameInit() {
        frameCreator();
        buttonsCreator();
    }

    public static String[] getButName() {
        return butName;
    }

    public static void setButName(String[] butName) {
        Frame.butName = butName;
    }
}

