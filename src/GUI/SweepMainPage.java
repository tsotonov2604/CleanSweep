package GUI;


import javax.swing.*;
import java.awt.*;

public class SweepMainPage extends JFrame{


    GroupLayout jPanel1Layout;
    private ButtonGroup buttonGroup1;
    private JButton cleanBtn;
    private JTextArea cleaningConsole;
    private JButton floorSelectBtn;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
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
    }


    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jPanel1Layout = new GroupLayout(jPanel1);
        initPanels();
        initButtons();
        packPanelOne();
        designLayout();
        pack();
    }

    private void designLayout() {
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(floorSelectBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(22, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
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
                                                .addComponent(scheduleBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(cleanBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(logoutBtn)
                                                .addGap(28, 28, 28))))
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
                                        .addComponent(registerBtn, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
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
        floorSelectBtn.setText("Select Floor Plan");
        scheduleBtn.setText("Schedule");
        logoutBtn.setText("Logout");
        registerBtn.setText("Register Sweep");
    }

    private void initPanels() {

        jPanel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Tahoma", 1, 12));
        jLabel1.setText("Sweep Connectivity:");

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
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SweepMainPage().setVisible(true);
            }
        });

    }

}
