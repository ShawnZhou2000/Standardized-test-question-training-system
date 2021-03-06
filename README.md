# Java课程设计 标准化试题训练系统
## 特别感谢

本项目使用Java Swing框架制作GUI界面，采用了BeautyEye外观实现。感谢原作者Jack Jiang的开源。

源码出处：[https://github.com/JackJiang2011/beautyeye](https://github.com/JackJiang2011/beautyeye)

## 下载与运行

需保证运行环境内有Java配置。

获取项目：

```
git clone https://github.com/ShawnZhou2000/Standardized-test-question-training-system.git
```

或点击Download Zip打包下载到本地。

运行项目：

```
在项目文件夹目录下，使用控制台运行：
java -jar testsys.jar
```

## 开发环境

IDE：IntelliJ IDEA Community Edition 2020.1.1 x64（基于Windows 10 Home Version 1909操作系统）

Java版本：Java jdk-11.0.1

Excel版本：Microsoft Office Excel 2019

BeautyEye版本：BeautyEye v3.7

## 设计任务与目标

设计GUI界面的标准化试题训练系统。具体要求如下：

① 使用Microsoft Excel工作簿存放标准化试题，形成题库。

② 程序每次从题库随机抽取若干道题目形成一张试卷， 用户可以依次做试卷上的题目,允许用户向前、向后翻阅试卷上的题目。

③ 用户每次做完一个题目必须确定该题目的答案，否则无效。

④ 有计时功能，比如指定一张试卷限用时10分钟，时间一到用户再无法答题，提示用户提交试卷。

⑤ 用户一旦提交试卷，程序将给出试卷的分值。

⑥ 为了达到反复训练的目的，用户提交试卷后可以继续让程序再出一套试卷。

⑦ 编写几个实现Teacher接口的类,使得AppWindow可以使用这些类的实例评判试卷。

⑧ 编写几个实现GiveTestPaper接口的类，使得AppWindow可以使用这些类的实例得到试卷(比如按顺序从题库中获得若干试题，或抽取题库中题号能被3除尽的试题等)。

⑨ 当考试剩余时间不多时(比如剩余时间少于全部用时的5%)将弹出一个警示对话框警示用户。

⑩ 增加用户查看试题正确答案的功能。当用户回答某试题答案后可以看见一个按钮，单击该按钮可以查看该试题的正确答案，然后该按钮又变得不可见。

## 题库要求

题目数据使用Excel工作簿给出，对工作簿的表结构要求如下：

Sheet表-共7列(A、B、C、D、E、F、G)，各列的取值规则如下(不可再改变其取值规则)。

- A列:试题内容。例如“这个标志是何含义?

- B列:正确答案。试题的正确答案只可以是A、B、C、D字母的组合(不区分大小

写)，例如B、ABC、C、D。

- C列:选择项目。例如“A.沿左侧车道掉头”。

- D列:选择项目。例如“B.该路口不能掉头”。

- E列:选择项目。例如“C.选择中间车道掉头”。

- F列:选择项目。例如“D.多股铁路与道路相交”。

- G列:题目类型。题目的类型只可以是“p”“x”“p#图像文件名字”或“x#图像文件名字”(字母p、x不区分大小写)，例如xthello.jpg、p#java001.jpg。

类型p表示试题类型是判断题，类型x表示试题类型是选择题，类型p#表示试题类型是判断题并带有图像，x#表示试题类型是选择题并带有图像。

- Excel中Sheet表的第一行不是试题，是试题的说明，说明文字可任意给定。

在项目根目录下建立了一个名字为“题库”的文件夹，存放Excel工作簿；以及名字为“图像管理”的文件夹，存放需要的图像文件。为了便于软件的管理以及编写，对于不需要图像的试题，程序统-用默认的图像，该默认图像的名字固定为`havenot.jpg`。另外，程序还需要一个名字是`renew.jpg`的图像，当用户重新选择试卷时用该图像友好地提示用户,因此必须将`havenot.jpg`和`renew.jpg` 图像保存到“图像管理”文件夹中(图像的外观可自己指定)。

## 项目特性

本系统采用共同的一套题库，两种试题分别模拟了顺序练习和乱序测试。其中顺序练习有全部的20题，时间10分钟，乱序测试随机抽取了10题，时间5分钟。当剩余时间不足20%时，会弹出时间不足提示框。当剩余时间归零时，系统提示考试结束，此时无法继续做题，只能交卷。题库来源为网络收集，围绕网络流行语展开。

- 在选择答案点击确定后，可以看到自己的选择，同时可以点击查看正确答案。
- 点击图片可以显示一个弹出对话框，允许查看原图像。
- 当时间不足时会出现弹框，提醒时间不足或时间耗尽。
- 交卷后，系统会为你自动评判成绩。