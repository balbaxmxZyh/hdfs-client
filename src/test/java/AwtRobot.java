import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @Author: zhangyh
 * @ClassName: AwtRobot
 * @Date: 2020/8/13 10:44
 * @Operation:
 * @Description: ${description}
 */
public class AwtRobot {
    private static Logger logger = LoggerFactory.getLogger(AwtRobot.class);

    private Robot robot = null;

    public AwtRobot() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            logger.error("创建Robot失败[{}]",e);
        }
    }

    /**
     * 模拟Ctrl+Alt+Z的按下和抬起
     */
    public void keyBoard() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_Z);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_Z);
    }

    /**
     * 模拟鼠标移动
     * @param x
     * @param y
     */
    public void move(int x ,int y) {
        robot.mouseMove(x, y);
    }

    /**
     * 模拟鼠标的按下和抬起
     */
    public void click() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    /**
     * 模拟Center的按下和抬起
     */
    public void enter() {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    /**
     * 按键
     * @param keyvalue
     */
    public void pressKey(int keyvalue) {
        robot.keyPress(keyvalue); // 按下按键
        robot.keyRelease(keyvalue); // 释放按键

    }

    /**
     * 等待time毫秒
     * @param time
     */
    public void delay(int time){
        robot.delay(time);
    }

    /**
     * 模拟tab
     */
    public void tab() {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    /**
     * 复制内容并且粘贴
     * @param string
     */
    public void setAndctrlVClipboardData(String string){
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
}
