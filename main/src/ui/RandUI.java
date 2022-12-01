package ui;


import javax.swing.*;
import java.awt.*;

public class RandUI
{
    private RandUI() {}

    private static final int ROWS = 2;
    private static final int COLS = 1;
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 600;
    private static final String PATH_TO_WEAPONS = "main\\images\\weapons\\";

    public static void buildRandomizerUI()
    {
        JFrame baseFrame = new JFrame();

        // add image canvas
        ImageCanvas weaponView = new ImageCanvas();
        baseFrame.add(weaponView);

        // add button to randomize
        Button randomizeButton = new Button("Randomize!");
        randomizeButton.addActionListener(a -> {
            int rw = (int) (Math.random() * 2 + 1);

        });
        baseFrame.add(randomizeButton);

        baseFrame.setLayout(new GridLayout(ROWS, COLS));

        baseFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        baseFrame.setResizable(false);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);
    }

}