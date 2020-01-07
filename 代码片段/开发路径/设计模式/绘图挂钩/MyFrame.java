import javax.swing.*;
import java.awt.*;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/8  15:02
 * @版本：
 */
public class MyFrame extends JFrame {
    public MyFrame (String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300,300);
        this.setVisible(true);
    }
    /* @Author Light
     * @Description //TODO  Window 中的钩子方法
     * @Date 15:07 2019/9/8
     * @Param
     * @return
     **/
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        String msg = "I Like Move";
        graphics.drawString(msg,100,100);
    }

    public static void main(String[] args) {
        new MyFrame("Head First Design Patterns");
    }
}
