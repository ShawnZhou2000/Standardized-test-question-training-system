package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
public class IntegerationView extends JFrame {
    static JTabbedPane tabbedPane; //用选项卡集成TestPaperView视图
    public IntegerationView() {
        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);//卡在左侧
        tabbedPane.validate();
        add(tabbedPane, BorderLayout.CENTER);
        setBounds(100, 100, 1200, 560);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("标准化试题训练系统");
        setVisible(true);
    }
    public void addTestPaperView(String cardName, TestPaperView view) {
        tabbedPane.add(cardName, view);
//        tabbedPane.getSelectedIndex()
        validate();
    }
}
