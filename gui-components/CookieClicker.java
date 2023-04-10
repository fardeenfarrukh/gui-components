package Assignment5_000906029;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/**
 * Main Class Creates a Cookie clicker GUI with JButtons and a Save System that stores previously saved data.
 * @author Syed Fardeen
 */
public class CookieClicker {

    /**
     * count of cookies will increase everytime you click cookie button
     */
    static int cookieCount = 0;

    /**
     * initially you can add one cookie per click which can increase later on
     */
    static int cookieAdd = 1;

    /**
     * Load the program and the Cookie display
     * @param cookie_display
     */
    public static void loadProgram(JLabel cookie_display) {
        User user = loadUser();

        cookieCount = user.cookies;
        cookieAdd = user.CPC;
        cookie_display.setText("Current Cookies: " + cookieCount + " | CPC: " + cookieAdd);
    }
    /**
     * Main Function creats JButtonn's and JFrame
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        ImageIcon CookieIcon = new ImageIcon("D:\\Users\\Downloads\\Documents\\Mohawk College\\Programming Java\\CookieClicker\\cookieicon.png");
        JButton cookie = new JButton("Cookie", CookieIcon);
        cookie.setBounds(10, 10, 100, 100);

        JButton Upgrade1 = new JButton("Level 1: Upgrade CPC (1) | Cost: 50 Cookies");
        Upgrade1.setBounds(10, 200, 300, 40);

        JButton Upgrade2 = new JButton("Level 2: Upgrade CPC (2) | Cost: 100 Cookies");
        Upgrade2.setBounds(10, 250, 300, 40);

        JButton Upgrade3 = new JButton("Level 3: Upgrade CPC (5) | Cost: 250 Cookies");
        Upgrade3.setBounds(10, 300, 300, 40);

        JButton MaxUpgrade = new JButton("Max Level: 2X CPC | Cost: 100.000 Cookies");
        MaxUpgrade.setBounds(10, 350, 300, 40);

        JButton save = new JButton("Save");
        save.setBounds(350, 10, 100, 40);

        JLabel cookieDisplay = new JLabel("Current Cookies: " + cookieCount + " | CPC: " + cookieAdd);
        cookieDisplay.setBounds(10, 120, 300, 20);

        // Load Program
        loadProgram(cookieDisplay);

        cookie.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                cookieCount = cookieCount + cookieAdd;
                cookieDisplay.setText("Current Cookies: " + cookieCount + " | CPC: " + cookieAdd);
            }
        });

        Upgrade1.addActionListener(new ActionListener() {
            /**
             * When action is performed the cookie will change the Cookies per click to the designatd amout in the code.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cookieCount - 50 > 0) {
                    cookieCount = cookieCount - 50;
                    cookieAdd++;
                    cookieDisplay.setText("Current Cookies: " + cookieCount + " | CPC: " + cookieAdd);
                } else {
                    cookieDisplay.setText("Not enough cookies! (Click To Get Cookies)");
                }
            }
        });

        Upgrade2.addActionListener(new ActionListener() {
            /**
             * When action is performed the cookie will change the Cookies per click to the designatd amout in the code.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cookieCount - 100 > 0) {
                    cookieCount = cookieCount - 100;
                    cookieAdd = cookieAdd + 2;
                    cookieDisplay.setText("Current Cookies: " + cookieCount + " | CPC: " + cookieAdd);
                } else {
                    cookieDisplay.setText("Not enough cookies!");
                }
            }
        });

        Upgrade3.addActionListener(new ActionListener() {
            /**
             * When action is performed the cookie will change the Cookies per click to the designatd amout in the code.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cookieCount - 250 > 0) {
                    cookieCount = cookieCount - 250;
                    cookieAdd = cookieAdd + 5;
                    cookieDisplay.setText("Current Cookies: " + cookieCount + " | CPC: " + cookieAdd);
                } else {
                    cookieDisplay.setText("Not enough cookies!");
                }
            }
        });

        MaxUpgrade.addActionListener(new ActionListener() {
            /**
             * When action is performed the cookie will double the current amount of the cookies.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cookieCount - 100000 > 0) {
                    cookieCount = cookieCount - 100000;
                    cookieAdd = cookieAdd * 2;
                    cookieDisplay.setText("Current Cookies: " + cookieCount + " | CPC: " + cookieAdd);
                } else {
                    cookieDisplay.setText("Not enough cookies!");
                }
            }
        });

        save.addActionListener(new ActionListener() {
            /**
             * When action is performed the program will save its data so that it can be visited later at the same progress.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(cookieCount, cookieAdd);
                writeUser(user);
            }
        });

        frame.add(cookieDisplay);
        frame.add(cookie);
        frame.add(Upgrade1);
        frame.add(Upgrade2);
        frame.add(Upgrade3);
        frame.add(MaxUpgrade);
        frame.add(save);

        frame.setSize(500, 500);
        frame.setTitle("Cookie Clicker");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /**
     * Writes User file data to be saved.
     * @param user
     */

    public static void writeUser(User user) {
        try (FileOutputStream fos = new FileOutputStream("cookieClickerUser.ccu");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Loads User file save data
     * @return user
     */

    public static User loadUser() {
        try (FileInputStream fis = new FileInputStream("cookieClickerUser.ccu");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            User user = (User) ois.readObject();

            return user;
        } catch (IOException | ClassNotFoundException ex) {
            return new User(0, 1);
        }
    }
}


