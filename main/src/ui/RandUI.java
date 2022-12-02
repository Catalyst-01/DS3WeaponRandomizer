package ui;


import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RandUI
{
    private RandUI() {}

    private static final int ROWS = 2;
    private static final int COLS = 1;
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 600;
    private static final String[] WEAPON_CATEGORIES = {"All", "Daggers", "Straight Swords", "Greatswords", "Ultra Greatswords", "Curved Swords", "Curved Greatswords", "Katanas", "Thrusting Swords", "Axes", "Greataxes", "Hammers", "Great Hammers", "Fists & Claws", "Spears & Pikes", "Halberds", "Reapers", "Whips & Flails", "Bows", "Greatbows", "Crossbows", "Staves", "Flames, Talismans, & Chimes"};

    public static void buildRandomizerUI()
    {
        JFrame baseFrame = new JFrame("Dark Souls 3 - Weapon Randomizer");
        baseFrame.setLayout(new GridLayout(ROWS, COLS));

        // add image canvas
        ImageCanvas weaponView = new ImageCanvas();
        weaponView.setSize(80, 120);
        baseFrame.add(weaponView);

        // create weapon name field
        JTextField wName = new JTextField("Dagger");
        wName.setColumns(50);
        wName.setHorizontalAlignment(JTextField.CENTER);

        // create dropdown by weapon category
        final JComboBox<String> categoryDropDown = new JComboBox<>(WEAPON_CATEGORIES);
        categoryDropDown.setVisible(true);

        // create randomize button
        Button randomizeButton = new Button("Randomize!");
        randomizeButton.addActionListener(a ->
        {
            int rwt, rwi;
            do {
                if (categoryDropDown.getSelectedIndex() == 0)
                    rwt = (int) (Math.random() * WeaponsID.WEAPONS.length);
                else
                    rwt = categoryDropDown.getSelectedIndex() - 1;
                rwi = (int) (Math.random() * WeaponsID.WEAPONS[rwt].length);
            } while (WeaponsID.WEAPONS[rwt][rwi].equals(weaponView.getCurrentWeapon()));

            weaponView.setCurrentWeapon(String.valueOf(rwt), WeaponsID.WEAPONS[rwt][rwi]);
            wName.setText(WeaponsID.WEAPONS[rwt][rwi]);
        });

        // add to bottom panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 1));
        bottomPanel.add(wName);
        bottomPanel.add(categoryDropDown);
        bottomPanel.add(randomizeButton);

        baseFrame.add(bottomPanel);
        baseFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        baseFrame.setResizable(false);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);
    }

}