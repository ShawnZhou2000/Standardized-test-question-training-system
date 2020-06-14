package gui;
import data.*;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import view.TestPaperView;
import view.IntegerationView;
public class AppWindow {
    static TestPaper testPaper, testPaper2;

    public static TestPaper getTestPaper() {
        return testPaper;
    }

    public static TestPaper getTestPaper2() {
        return testPaper2;
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        String testName = "";
        IntegerationView integrationView = new IntegerationView();
        GiveTestPaper initTestPaper = new SeqInitTestPaper();
        //创建初始试卷对象
        testPaper = initTestPaper.getTestPaper("题库/testxls.xls",20); //得到有20个题目的试卷
        testPaper.setId(1); // 设置试卷id
        TestPaperView testView = new TestPaperView();
        testView.setTestPaper(testPaper); //设置试卷
        testView.setTeacher(new TeacherTwo());//设置阅卷老师.
        testName = "网络热梗小测试（顺序）";
        testView.setTestName(testName);
        testView.setTotalTime(10);//考试时间10分钟
        integrationView.addTestPaperView(testName, testView);

        //创建初始试卷对象
        GiveTestPaper initTestPaper2 = new RandomInitTestPaper();
        testPaper2 = initTestPaper2.getTestPaper("题库/testxls.xls",10);
        testPaper2.setId(2); // 设置试卷id
        testView = new TestPaperView();
        testView.setTestPaper(testPaper2);
        testView.setTeacher(new TeacherOne());
        testName = "网络热梗小测试（乱序）";
        testView.setTestName(testName);
        testView.setTotalTime(5);
        integrationView.addTestPaperView(testName , testView);
    }
}
