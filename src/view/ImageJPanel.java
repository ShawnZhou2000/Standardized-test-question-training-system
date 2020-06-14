package view;

import javax. swing. *;
import java.awt.*;
import java.awt.event.*;
public class ImageJPanel extends JPanel implements MouseListener {
    Image image;
    ImageJPanel() {
        setOpaque(false);
        setBorder(null);
        setToolTipText("单击图像单独调整观看");
        addMouseListener(this);
    }
    public void setImage (Image img) {
        image = img;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getBounds().width, getBounds().height, this);
    }
    public void mousePressed (MouseEvent e) {
        ShowImageDialog showImageDialog = new ShowImageDialog(image);
        showImageDialog.setVisible(true);
    }
    public void mouseReleased (MouseEvent e) { }
    public void mouseEntered (MouseEvent e) { }
    public void mouseExited (MouseEvent e) {}
    public void mouseClicked (MouseEvent e) { }
}
