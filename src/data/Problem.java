package data;
public class Problem {
    boolean isChoice;
    //是否为选择题
    boolean isJudge;
    //是否为判断题
    String content;
    //题目内容
    String giveChoiceA, giveChoiceB, giveChoiceC, giveChoiceD; //提供选择
    String imageName;
    //题目所带的图像文件的名字
    String correctAnswer= "QWEQ@ #$@!@#1QWEQ"; //题目的正确答案
    //用户回答的初始答案和correctAnswer不同，防止出题人忘记给正确答案
    String userAnswer ="" ;
    //初始值必须是不含任何字符的串
    public boolean getIsChoice() {
        return isChoice;
    }
    public void setIsChoice (boolean b) {
        isChoice = b;
    }
    public boolean getIsJudge() {
        return isJudge;
    }
    public void setIsJudge (boolean b) {
        isJudge = b;
    }
    public void setContent (String c) {
        content = c;
    }
    public String getContent() {
        return content;
    }
    public void setCorrectAnswer (String a) {
        correctAnswer = a;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public void setUserAnswer (String u) {
        userAnswer = u;
    }
    public String getUserAnswer () {
        return userAnswer ;
    }
    public void setGiveChoiceA(String a) {
        giveChoiceA = a;
    }
    public String getGiveChoiceA() {
        return giveChoiceA;
    }
    public void setGiveChoiceB (String b) {
        giveChoiceB = b;
    }
    public String getGiveChoiceB() {
        return giveChoiceB;
    }
    public void setGiveChoiceC(String c) {
        giveChoiceC = c;
    }
    public String getGiveChoiceC() {
        return giveChoiceC;
    }
    public void setGiveChoiceD (String d) {
        giveChoiceD = d;
    }
    public String getGiveChoiceD() {
        return giveChoiceD;
    }
    public void setImageName (String c) {
        imageName = c;
    }
    public String getImageName () {
        return imageName;
    }
}

