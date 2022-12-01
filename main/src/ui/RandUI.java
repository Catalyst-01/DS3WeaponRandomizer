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

        ImageCanvas weaponView = new ImageCanvas();

        baseFrame.add(weaponView);

        baseFrame.setLayout(new GridLayout(ROWS, COLS));

        baseFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        baseFrame.setResizable(false);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);
    }

}