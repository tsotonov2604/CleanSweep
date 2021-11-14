package GUI;


import move.Grid;
import move.Simulation;
import move.Sweep;
import schedule.Schedule;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class SweepMainPage extends JFrame{


    private static Sweep sweep;
    private static Grid grid;
    private static int cleanedAreas = 4;

    private Simulation simulation;
    private GroupLayout jPanel1Layout;
    private ButtonGroup buttonGroup1;
    private JButton cleanBtn;
    private JTextArea cleaningConsole;
    private JButton floorSelectBtn;
    private JLabel jLabel1;
    private JLabel floorPlanImg;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel batteryPercentage;
    private JLabel dirtTxt;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JRadioButton offBtn;
    private JRadioButton onBtn;
    private JButton scheduleBtn;
    private JButton registerBtn;
    private JButton logoutBtn;

    private SweepMainPage() {
        initComponents();
        simulation = Simulation.createInstance();
    }


    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        floorPlanImg = new JLabel();
        onBtn = new JRadioButton();
        offBtn = new JRadioButton();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        cleanBtn = new JButton();
        floorSelectBtn = new JButton();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        cleaningConsole = new JTextArea();
        scheduleBtn = new JButton();
        logoutBtn = new JButton();
        registerBtn = new JButton();
        jLabel3 = new JLabel();
        batteryPercentage = new JLabel();
        jLabel4 = new javax.swing.JLabel();
        dirtTxt = new javax.swing.JLabel();

        cleaningConsole.setEditable(false);
        cleaningConsole.setColumns(20);
        cleaningConsole.setRows(5);
        jScrollPane1.setViewportView(cleaningConsole);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jPanel1Layout = new GroupLayout(jPanel1);
        initPanels();
        initButtons();
        packPanelOne();
        designLayout();
        pack();
    }

    private void designLayout() {

       GroupLayout.ParallelGroup panel1Group = jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)));

       panel1Group.addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(floorSelectBtn)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE));

       panel1Group.addGroup(jPanel1Layout.createSequentialGroup()
               .addComponent(jLabel1)
               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(onBtn)
               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(offBtn)
               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(registerBtn)
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGap(18, 18, 18)
               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                       .addComponent(jLabel3)
                       .addComponent(batteryPercentage))
               .addGap(18, 18, 18)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                       .addComponent(jLabel4)
                       .addComponent(dirtTxt))
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(scheduleBtn)
               .addGap(18, 18, 18)
               .addComponent(cleanBtn)
               .addGap(18, 18, 18)
               .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
               .addGap(50, 50, 50)
               .addComponent(logoutBtn)
               .addGap(28, 28, 28));

        jPanel1Layout.setVerticalGroup(panel1Group);


        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(floorPlanImg, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(floorPlanImg, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setVisible(false);
        batteryPercentage.setVisible(false);
        dirtTxt.setVisible(false);
        jLabel4.setVisible(false);

    }


    private void packPanelOne() {

        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(offBtn)
                                                        .addComponent(onBtn)))
                                        .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING)
                                        .addComponent(scheduleBtn, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cleanBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(logoutBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(registerBtn, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(dirtTxt)
                                                        .addComponent(batteryPercentage))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(floorSelectBtn))
                                .addGap(58, 58, 58))
        );


    }


    private void initButtons() {
        buttonGroup1.add(onBtn);
        onBtn.setText("Turn On");
        buttonGroup1.add(offBtn);
        offBtn.setText("Turn Off");
        cleanBtn.setText("Clean");
        cleanBtn.setVisible(false);
        floorSelectBtn.setText("Select Floor Plan");
        scheduleBtn.setText("Schedule");
        logoutBtn.setText("Logout");
        registerBtn.setText("Register Sweep");
        jLabel4.setText("Dirt Bag:");
        dirtTxt.setText("0");



        registerBtn.addActionListener(evt -> registerBtnActionPerformed(evt));
        floorSelectBtn.addActionListener(evt -> floorSelectBtnActionPerformed(evt));
        scheduleBtn.addActionListener(evt -> scheduleBtnActionPerformed(evt));
        logoutBtn.addActionListener(evt -> logoutBtnActionPerformed(evt));
        onBtn.addActionListener(evt -> onBtnActionPerformed(evt));
        offBtn.addActionListener(evt -> offBtnActionPerformed(evt));
        cleanBtn.addActionListener(evt -> cleanBtnActionPerformed(evt));


    }

    private void initPanels() {

        jPanel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Arial", Font.BOLD, 12));
        jLabel1.setText("Sweep Connectivity:");
        jLabel3.setText("Battery:");
        batteryPercentage.setText("100%");
        jSeparator2.setOrientation(SwingConstants.VERTICAL);


        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 422, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 525, Short.MAX_VALUE)
        );

    }

    public static void createPage(){
        EventQueue.invokeLater(() -> new SweepMainPage().setVisible(true));
    }

    private void registerBtnActionPerformed(ActionEvent evt) {
        if (sweep == null) {
            sweep = new Sweep(0,9,simulation.getGrid());
            JOptionPane.showMessageDialog(this,sweep.getSerialNumber(),"Serial Number Registered",JOptionPane.INFORMATION_MESSAGE);
            cleaningConsole.append("\n"+sweep.getSerialNumber());
            offBtn.setSelected(true);
//            jLabel3.setVisible(true);
//            batteryPercentage.setVisible(true);
            cleanBtn.setVisible(true);
//            jLabel4.setVisible(false);
//            dirtTxt.setVisible(false;
        }
        else{
            JOptionPane.showMessageDialog(this,sweep.getSerialNumber()+" : "+"Already registered!","ERROR!",JOptionPane.ERROR_MESSAGE);
        }


    }


    private void floorSelectBtnActionPerformed(ActionEvent evt) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                String filePath = fileChooser.getSelectedFile().getPath();
                System.out.println(filePath);
                BufferedImage img = ImageIO.read(new File(filePath));
                ImageIcon icon = new ImageIcon(img.getScaledInstance(500, 500, Image.SCALE_DEFAULT));
                floorPlanImg.setIcon(icon);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Couldn't load floor....","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void scheduleBtnActionPerformed(ActionEvent evt) {
        JLabel label = new JLabel("Selected Date:");
        final JTextField text = new JTextField(20);
        JButton b = new JButton("popup");
        JPanel p = new JPanel();
        p.add(label);
        p.add(text);
        p.add(b);
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                text.setText(new Schedule(f).setPickedDate());
                cleaningConsole.append("\nScheduled for "+text.getText());
            }
        });


    }

    private void logoutBtnActionPerformed(ActionEvent evt) {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void onBtnActionPerformed(ActionEvent evt) {
        if(sweep != null) {
            cleaningConsole.append("\nSweep turned ON");
        }
        else {
            JOptionPane.showMessageDialog(this,"MUST REGISTER A SWEEP","ERROR!",JOptionPane.ERROR_MESSAGE);
            buttonGroup1.clearSelection();
        }
    }

    private void offBtnActionPerformed(ActionEvent evt) {
        if(sweep != null) {
            cleaningConsole.append("\nSweep turned OFF");
        }
        else {
            JOptionPane.showMessageDialog(this,"MUST REGISTER A SWEEP","ERROR!",JOptionPane.ERROR_MESSAGE);
            buttonGroup1.clearSelection();
        }
    }


    private void cleanBtnActionPerformed(ActionEvent evt) {

        onBtn.setSelected(true);
        simulation.addSweep(sweep);
        String s = simulation.startSimulation();
        cleaningConsole.append(s);
        cleanNext();
        //delayMovement();

    }

    private void delayMovement(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                delay();
            }
        };
        Timer timer = new Timer("Returning");
        timer.schedule(timerTask,3000L);
    }
    private void delay() {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                sweep.charge();
                cleanNext();

            }
        };

        Timer timer = new Timer("Charging");
        timer.schedule(timerTask,5000L);


    }

    private synchronized void cleanNext() {
        if(cleanedAreas > 0) {
            String s ="";
            switch (cleanedAreas){
                case 4: s=simulation.cleanAreaOne(); break;
                case 3: s=simulation.cleanAreaTwo(); break;
                case 2: s=simulation.cleanAreaThree(); break;
                case 1: s=simulation.cleanAreaFour();break;
            }
            cleanedAreas--;
            cleaningConsole.append("\n");
            cleaningConsole.append(s);
            cleaningConsole.append("returning to charging station...");
            cleaningConsole.append("\n Battery is "+sweep.getBattery().getBatteryPercentage());
            cleaningConsole.append("\n Bag has "+sweep.dirtSensor.Capacity);
            cleaningConsole.append("\ncharging and emptying bag...");
            System.out.println(cleanedAreas+" : Areas");
            delayMovement();

        }
    }


}
