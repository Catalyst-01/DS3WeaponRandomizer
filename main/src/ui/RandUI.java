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
        JFrame baseFrame = new JFrame("Dark Souls 3 - Weapon Randomizer");
        baseFrame.setLayout(new GridLayout(ROWS, COLS));

        // add image canvas
        ImageCanvas weaponView = new ImageCanvas();
        weaponView.setSize(80, 120);
        baseFrame.add(weaponView);

        // add bottom panel
        JPanel bottomPanel = new JPanel();

        JTextField wName = new JTextField("Dagger");
        wName.setColumns(50);
        wName.setHorizontalAlignment(JTextField.CENTER);

        Button randomizeButton = new Button("Randomize!");
        randomizeButton.addActionListener(a -> {
            int rwt = (int) (Math.random() * WeaponsID.WEAPONS.length);
            int rwi = (int) (Math.random() * WeaponsID.WEAPONS[rwt].length);
            weaponView.setCurrentWeapon(String.valueOf(rwt), WeaponsID.WEAPONS[rwt][rwi]);
            System.out.println(WeaponsID.WEAPONS[rwt][rwi]);
        });
        bottomPanel.add(wName);
        bottomPanel.add(randomizeButton);

        baseFrame.add(bottomPanel);
        baseFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        baseFrame.setResizable(false);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);
    }

}