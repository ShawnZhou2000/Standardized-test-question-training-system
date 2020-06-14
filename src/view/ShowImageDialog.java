package view;
import java.awt.*;
import javax.swing.*;
public class ShowImageDialog extends JDialog {
    Image img;
    ShowImageDialog(Image img) { //构造方法
        class GiveImage extends JPanel { //内部类，专门为该对话框提供图片
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getBounds().width, getBounds().height, this);
            }
        }
        setTitle("显示图像对话框");
        this.img = img;
        setSize(500, 470);
        GiveImage image = new GiveImage();
        add(image);
        setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

