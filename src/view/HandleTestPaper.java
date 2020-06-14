package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import data.*;
public class HandleTestPaper implements ActionListener{
    TestPaperView view;
    TestPaper testPaper;
    //需要处理的试卷
    Problem problem;
    //当前的题目.
    Toolkit tool;
    //处理图像
    public HandleTestPaper() {
        tool = Toolkit.getDefaultToolkit();
    }
    public void setView (TestPaperView view) {
        this.view = view;
    }
    public void setTestPaper (TestPaper testPaper) {
        this.testPaper = testPaper;
    }
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == view.nextProblem) {
            view.checked.setVisible(false);
            view.showAnswer.setVisible(false);
            view.ans.setVisible(false);
            view.time.start(); //开始计时
            if (testPaper != null) {
                problem = testPaper.nextProblem();
                handleProblem(problem);
            } else {
                JOptionPane.showMessageDialog(view, "没有试题", "提示", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == view.previousProblem) {
            view.checked.setVisible(false);
            view.showAnswer.setVisible(false);
            view.ans.setVisible(false);
            view.time.start(); //开始计时
            if (testPaper != null) {
                problem = testPaper.previousProblem();
                handleProblem(problem);
            } else {
                JOptionPane.showMessageDialog(view, "没有试题", "提示", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == view.aProblemSubmit) { //确认一道题目的答案
            String answer = "";
            if (view.choiceA.isSelected()) {
                answer = answer + "A";
            }
            if (view.choiceB.isSelected()) {
                answer = answer + "B";
            }
            if (view.choiceC.isSelected()) {
                answer = answer + "C";
            }
            if (view.choiceD.isSelected()) {
                answer = answer + "D";
            }
            if (problem == null) {
                JOptionPane.showMessageDialog(view, "没有试题", "消息对话框", JOptionPane.WARNING_MESSAGE);
                return;
            }
            view.choiceA.setVisible(false);
            view.choiceB.setVisible(false);
            view.choiceC.setVisible(false);
            view.choiceD.setVisible(false);
            view.aProblemSubmit.setVisible(false);
            view.checked.setText("你的选择是：" + answer);
            view.checked.setVisible(true);
            view.showAnswer.setText("查看正确答案");
            view.showAnswer.setVisible(true);
            problem.setUserAnswer(answer);
        }

        if (e.getSource() == view.showAnswer) {
            int id = IntegerationView.tabbedPane.getSelectedIndex();
            int index;
            String[] allAns;
            if (id == 0) {
                allAns = data.SeqInitTestPaper.getCorrectAns();
                index = gui.AppWindow.getTestPaper().getIndex();
            }
            else {
                allAns = data.RandomInitTestPaper.getCorrectAns();
                index = gui.AppWindow.getTestPaper2().getIndex();
            }
            String ans = allAns[index];
            view.showAnswer.setVisible(false);
            view.ans.setText("本题的正确答案是：" + ans);
            view.ans.setVisible(true);
        }

        if (e.getSource() == view.submit) {
            testPaper.acceptTeacher(view.teacher); //试卷让老师批阅
            view.renewJButton.setVisible(true);
            view.submit.setVisible(false);
            view.time.stop();
            view.showUsedTime.setText("交卷了");
        }
        if (e.getSource() == view.renewJButton) { //再来一套题目
            view.choiceA.setVisible(false);
            view.choiceB.setVisible(false);
            view.choiceC.setVisible(false);
            view.choiceD.setVisible(false);
            view.aProblemSubmit.setVisible(false);
            view.checked.setVisible(false);
            view.showAnswer.setVisible(false);
            view.showUsedTime.setText("");
            view.usedTime = view.totalTime;
            view.showUsedTime.setText("考试剩余时间: " + view.totalTime);
            view.showContent.setText(null);
            Image img = tool.getImage("图像管理/renew.jpg");
            handleImage(img);
            view.showImage.repaint();
            view.nextProblem.setVisible(true);
            view.previousProblem.setVisible(true);
            String problemSource = testPaper.getProblemSource(); //得到原始题库
            GiveTestPaper initTestPaper = new RandomInitTestPaper();
            testPaper = initTestPaper.getTestPaper(problemSource, testPaper.getProblemAmount());
            view.renewJButton.setVisible(false);
            view.submit.setVisible(true);
        }
        view.choiceA.setSelected(false);
        view.choiceB.setSelected(false);
        view.choiceC.setSelected(false);
        view.choiceD.setSelected(false);

    }
    private void handleProblem (Problem problem) {
        if (problem == null) {
            JOptionPane.showMessageDialog(view, "没有试题", "消息对话框", JOptionPane.WARNING_MESSAGE);
        }
        else {
            view.aProblemSubmit.setVisible(true);
            view.showContent.setText(problem.getContent());
            view.showContent.setVisible(true);
            if (problem.getIsChoice()) {
                handleChoice();
            } else if (problem.getIsJudge()) {
                handleJudge();
            }
            String imageName = problem.getImageName();
            //用户必须把图像存放到“图像管理”文件夹
            Image img = tool.getImage("图像管理/" + imageName);
            handleImage(img);
        }
    }
    private void handleJudge() {
        view.choiceA.setText(problem.getGiveChoiceA());
        view.choiceB.setText(problem.getGiveChoiceB());
        view.choiceA.setVisible(true);
        view.choiceB.setVisible(true);
        view.choiceC.setVisible(false);
        view.choiceD.setVisible(false);
    }
    private void handleChoice() {
        view.choiceA.setText(problem.getGiveChoiceA());
        view.choiceB.setText(problem.getGiveChoiceB());
        view.choiceC.setText(problem.getGiveChoiceC());
        view.choiceD.setText(problem.getGiveChoiceD());
        view.choiceA.setVisible(true) ;
        view.choiceB.setVisible(true) ;
        view.choiceC.setVisible(true) ;
        view.choiceD.setVisible(true) ;
    }
    private void handleImage(Image image) {
        view.showImage.setImage(image);
        view.showImage.repaint();
    }
}



