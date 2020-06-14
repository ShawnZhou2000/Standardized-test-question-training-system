package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event. *;
import data.*;
public class TestPaperView extends JPanel implements ActionListener {
    TestPaper testPaper;
    //本视图需要显示的试卷
    public Teacher teacher ;
    //批卷老师
    public JTextArea showContent;
    //显示试题内容
    public ImageJPanel showImage;
    //显示试题的图像
    public JCheckBox choiceA, choiceB, choiceC, choiceD; //显示选项内容
    public JButton nextProblem, previousProblem;//选择“上-题目”“下一题目”的按钮
    public JButton aProblemSubmit;
    //确认某道题的回答或选择
    public JButton renewJButton;
    //重新开始
    public JButton submit;
    //交卷
    HandleTestPaper handleTestPaper;
    //负责处理testPaper试卷中的数据
    public int totalTime = 0;
    //考试用时(单位:分)
    public int usedTime = totalTime ;
    public javax.swing.Timer time;
    //考试计时器
    public JLabel showUsedTime;
    //显示用时
    public JLabel testName;
    //显示考试名称
    public JLabel checked;
    //显示查看答案按钮
    public JButton showAnswer;
    //显示答案
    public JLabel ans;
    public TestPaperView() {
        time = new Timer(30 * 1000, this);
        //每隔1分钟计时一次(触发Act ionEvent), 本容器作为其监视器
        initView();
        registerListener();
    }
    public void setTeacher (Teacher teacher) {
        this.teacher = teacher;
    }
    public void initView() {
        setLayout(new BorderLayout());
        showImage = new ImageJPanel() ;
        showContent = new JTextArea(12,12) ;
        showContent.setToolTipText("如果题中有图像，在图上单击鼠标可调整观看") ;
        showContent.setForeground(Color.blue);
        showContent.setWrapStyleWord (true);
        showContent.setLineWrap(true); //回行 自动
        showContent.setFont(new Font ("微软雅黑" , Font.PLAIN, 18)) ;
        choiceA = new JCheckBox("A:");
        choiceB = new JCheckBox("B:");
        choiceC = new JCheckBox("C:");
        choiceD = new JCheckBox("D:");
        choiceA.setVisible(false);
        choiceB.setVisible(false);
        choiceC.setVisible(false);
        choiceD.setVisible(false);
        nextProblem = new JButton("下一题");
        previousProblem = new JButton("上一题");
        aProblemSubmit = new JButton ("确认");
        aProblemSubmit.setVisible(false);
        renewJButton = new JButton("再来一次");
        renewJButton. setVisible(false) ;
        submit = new JButton("交卷");
        JPanel pNorth = new JPanel();
        pNorth.setBackground(Color.LIGHT_GRAY);
        showUsedTime = new JLabel();
        testName = new JLabel();
        testName.setFont(new Font("微软雅黑", Font.PLAIN,18));
        checked = new JLabel();
        checked.setVisible(false);
        showAnswer = new JButton();
        showAnswer.setVisible(false);
        ans = new JLabel();
        ans.setVisible(false);
        pNorth.add(testName);
        pNorth.add(new JLabel("单击下一题或上一题按钮开始考试"));
        pNorth.add(submit);
        pNorth.add(renewJButton);
        pNorth.add(showUsedTime);
        add(pNorth, BorderLayout.NORTH);
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new GridLayout(1,2));
        pCenter.add(new JScrollPane(showContent));
        pCenter.add(showImage);
        add(pCenter, BorderLayout.CENTER);
        JPanel pSouth = new JPanel();
        pSouth.setLayout (new GridLayout(2,1)) ;
        JPanel oneInPSouth = new JPanel();
        JPanel twoInPSouth = new JPanel();
//        oneInPSouth.setBackground(Color.LIGHT_GRAY);
        oneInPSouth.add(choiceA);
        oneInPSouth.add(choiceB);
        oneInPSouth.add(choiceC);
        oneInPSouth.add(choiceD);
        oneInPSouth.add(aProblemSubmit);
        oneInPSouth.add(checked);
        oneInPSouth.add(showAnswer);
        oneInPSouth.add(ans);
        twoInPSouth.add(previousProblem);
        twoInPSouth.add(nextProblem);
        pSouth.add(oneInPSouth) ;
        pSouth.add(twoInPSouth) ;
        add(pSouth, BorderLayout.SOUTH);
        validate();
    }
    public void registerListener() {
        handleTestPaper = new HandleTestPaper();
        nextProblem.addActionListener(handleTestPaper);
        previousProblem.addActionListener(handleTestPaper);
        aProblemSubmit.addActionListener(handleTestPaper);
        submit.addActionListener(handleTestPaper);
        renewJButton.addActionListener(handleTestPaper);
        showAnswer.addActionListener(handleTestPaper);
        handleTestPaper.setView(this);
    }
    public void setTestPaper (TestPaper testPaper) {
        this.testPaper = testPaper;
        handleTestPaper.setTestPaper(testPaper);
    }
    public void actionPerformed(ActionEvent e) {
        showUsedTime.setText("考试剩余时间: " + usedTime + "分钟");
        if (usedTime == 0) {
            time.stop();
            showUsedTime.setText("请交卷");
            JOptionPane.showMessageDialog(this, "考试时间已经耗尽！", "提示", JOptionPane.WARNING_MESSAGE);
            nextProblem.setVisible(false);
            previousProblem.setVisible(false);
        }
        if (usedTime <= ((double)totalTime * 0.2)) {
            JOptionPane.showMessageDialog(this, "请注意考试时间，剩余时间不足20%！", "提示", JOptionPane.WARNING_MESSAGE);
        }
        usedTime--;
    }
    public void setTestName(String name) {
        testName.setText("[" + name + "]");
    }
    public void setTotalTime(int n) {
        totalTime = n;
        usedTime = n;
        showUsedTime.setText ("考试剩余时间: " + usedTime + "分钟") ;
    }
}


