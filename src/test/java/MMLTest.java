import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: MMLTest
 * @Date: 2020/8/12 14:40
 * @Operation:
 * @Description: ${description}
 */
public class MMLTest {

    private static Logger logger = LoggerFactory.getLogger(MMLTest.class);
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedReader brError;
        String cmd = "E:\\newland\\MML\\MMLCONV.exe";
        try {
            //执行exe  cmd可以为字符串(exe存放路径)也可为数组，调用exe时需要传入参数时，可以传数组调用(参数有顺序要求)
            Process p = Runtime.getRuntime().exec(cmd);
            String line = null;
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            brError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = br.readLine()) != null || (line = brError.readLine()) != null) {
                //输出exe输出的信息以及错误信息
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test2() {
        String cmd = "E:\\newland\\MML\\MMLCONV.exe";
        String name = "MMLCONV.exe";
        if (Desktop.isDesktopSupported()) { //是支持桌面类的
            Desktop desk = Desktop.getDesktop();
            try {
                // 打开哪个文件
                if(!isStart(name)) {
                    desk.open(new File(cmd));
                }
                RobotDemo robotDemo = new RobotDemo();
                Point p  = MouseInfo.getPointerInfo().getLocation();
                System.out.println(p.getX() + "---" +p.getY());
                Double x =  p.getX();
                Double y =  p.getY();
                robotDemo.move( x.intValue()*-1, y.intValue()*-1);
                robotDemo.move(450,850);
                robotDemo.delay(1000);
                robotDemo.click();
                robotDemo.delay(1000);

                robotDemo.enter();
                String syt = "E:\\newland\\MML\\test.log";
                robotDemo.delay(1000);
                robotDemo.setAndctrlVClipboardData(syt);
                robotDemo.delay(1000);
                robotDemo.enter();

            } catch (Exception e)
            {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4() throws Exception{
        StringBuilder reslut = new StringBuilder();
        String path = "E:\\newland\\MML\\";
        for (int i = 1;i <= 200 ;i++){
            String p = path + "test"+i+".log";
            new File(p).createNewFile();
            reslut.append(" \"").append(p).append("\"");
        }
        System.out.println(reslut);
    }

    @Test
    public void test5() throws Exception{
        String path = "E:\\newland\\MML\\";
        for (int i = 7;i <= 1000 ;i++){
            String p = path + "test"+i+"_log.MML";
            new File(p).delete();
        }
    }

    @Test
    public void test6() throws Exception{
        String path = "E:\\newland\\MML\\";
        String MMLExeAll = "E:\\newland\\MML\\MMLCONV.exe";
        String MMLExeName = "MMLCONV";
        String MMLExeNameAll = "MMLCONV.exe";
        //是否远程移动
        boolean isFTP = false;

        boolean isExist = isStart(MMLExeName);
        logger.info("程序{}是否已经启动{}",MMLExeNameAll,isExist);
        if(isExist){
            logger.info("关闭程序{}",MMLExeNameAll);
            close(MMLExeNameAll);
        }
        logger.info("启动程序[{}]",MMLExeNameAll);
        if (Desktop.isDesktopSupported()) {
            Desktop desk = Desktop.getDesktop();
            WinDef.HWND hwnd = null;
            try {
                // 打开哪个文件
                logger.info("获取窗口焦点");
                hwnd = getHWND(MMLExeAll);
                if (hwnd == null) {
                    desk.open(new File(MMLExeAll));
                    Thread.sleep(1000);
                    hwnd = getHWND(MMLExeAll);
                }
                if (hwnd == null) {
                    System.out.println("程序启动失败");
                    return;
                }
                FileModel fileModel = getFileAll(path);
                //分批执行文件路径集合
                List<String> exe = new ArrayList<>();
                //所有需要执行文件集合
                List<String> allFilePaths = fileModel.getAllFilePaths();
                //每批次文件路径
                StringBuilder exeFile = new StringBuilder();
                for (String filePath : allFilePaths){
                    StringBuilder exeFilePath = new StringBuilder();
                    exeFile.append(" \"").append(filePath).append("\"");
                    //每批次执行的路径长度不能超过250，超过这下一个批次
                    if(exeFilePath.length() + exeFile.length() > 250){
                        String re = exeFile.toString();
                        exe.add(re);
                        exeFile = exeFilePath;
                    }else {
                        exeFile.append(exeFilePath);
                    }
                }
                //最后一次不满足250的加入
                exe.add(exeFile.toString());

                logger.info("开始执行解密");
                int i = 1;
                AwtRobot awtRobot = new AwtRobot();
                for (String name : exe){
                    logger.info("批次[{}],路径[{}]",i,name);
                    ExporUtil.operate(awtRobot,name);
                    i++;
                }
                logger.info("解密结束");

                logger.info("校验解密结果是否全部完成");
                List<String> mmlFiles = getMMLfile(path);
                logger.info("获取所有的MML文件[{}]",mmlFiles.size());
                //案例结果结合
                Iterator<Map.Entry<String,String>> iterator = fileModel.getAllMMLName().entrySet().iterator();
                //重试集合
                List<String> revers = new ArrayList<>();
                while (iterator.hasNext()){
                    Map.Entry<String,String> entry = iterator.next();
                    String name = entry.getKey();
                    String value = entry.getValue();
                    //没有生成对应的MML文件，加入重试队列(对应的源文件路径)
                    if(!mmlFiles.contains(name)){
                        revers.add(value);
                    }
                }

                logger.info("需要重试的文件[{}]",revers.size());
                for(String name : revers){
                    logger.info("重试文件[{}]",name);
                    ExporUtil.operate(awtRobot,name);
                }

                mmlFiles = getMMLfile(path);
                logger.info("最终所有的MML文件[{}]",mmlFiles.size());
                fileModel.setAllResultMMLName(mmlFiles);


                logger.info("移动MML文件开始");

                try {
                    logger.info("移动MML文件到位置1开始");
                    if (!isFTP){

                    }else {

                    }
                }catch (Exception e){
                    logger.error("移动MML文件到位置1失败[{}]",e);
                }finally {
                    logger.info("移动MML文件到位置1结束");
                }


            } catch (Exception e) {
                logger.error("程序执行失败[{}]",e);
            }
        }else {
            logger.error("不支持桌面类的");
        }
    }


    @Test
    public void test3() {
        String cmd = "E:\\newland\\MML\\MMLCONV.exe";
        String name = "MMLCONV";
        WinDef.HWND hwnd = null;
//        while (true){
        if (Desktop.isDesktopSupported()) { //是支持桌面类的
            Desktop desk = Desktop.getDesktop();
            try {
                // 打开哪个文件
                hwnd = getHWND(name);
                if (hwnd == null) {
                    desk.open(new File(cmd));
                    Thread.sleep(1000);
                    hwnd = getHWND(name);
                }
                if (hwnd == null) {
                    System.out.println("程序启动失败");
                    return;
                }
                RobotDemo robotDemo = new RobotDemo();
                robotDemo.delay(1000);
                robotDemo.enter();
                //259
//                String path = "\"E:\\newland\\MML\\test7.log\" \"E:\\newland\\MML\\test8.log\" \"E:\\newland\\MML\\test9.log\" \"E:\\newland\\MML\\test10.log\" \"E:\\newland\\MML\\test11.log\" \"E:\\newland\\MML\\test12.log\" \"E:\\newland\\MML\\test13.log\" \"E:\\newland\\MML\\test14.log\" \"E:\\newland\\MML\\test15.log\" \"E:\\newlan";
//                System.out.println(path.length());
                String syt = "\"E:\\newland\\MML\\test7.log\" \"E:\\newland\\MML\\test8.log\" \"E:\\newland\\MML\\test9.log\" \"E:\\newland\\MML\\test10.log\" \"E:\\newland\\MML\\test11.log\" \"E:\\newland\\MML\\test12.log\" \"E:\\newland\\MML\\test13.log\" \"E:\\newland\\MML\\test14.log\" \"E:\\newland\\MML\\test15.log\"";
                robotDemo.delay(1000);
                robotDemo.setAndctrlVClipboardData(syt);
                robotDemo.delay(1000);
                robotDemo.enter();
                robotDemo.delay(1000);
                robotDemo.tab();
                robotDemo.delay(1000);
                robotDemo.tab();
                robotDemo.delay(1000);
                robotDemo.enter();
            } catch (Exception e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
//        }
//            WinDef.LRESULT lresult = User32.INSTANCE.SendMessageTimeout(hwnd,0X10,null,null,1,2,null);
//            System.out.println(lresult);
        }
    }

    public static boolean isStart (String keyWord ){
        keyWord = keyWord.toLowerCase();
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("cmd /c Tasklist | find /I \""+keyWord+"\"");
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = in.readLine()) != null) {
                s = s.toLowerCase();
                if (s.startsWith(keyWord)) {
                    System.out.println("==========>"+keyWord);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void close (String keyWord ){
        keyWord = keyWord.toLowerCase();
        Runtime runtime = Runtime.getRuntime();
        String cmd = "taskkill /f /t /im \""+keyWord+"\"";
        try {
            runtime.exec(cmd);
        } catch (IOException e) {
            logger.error("程序关闭失败[{}]，cmd[{}]",e,cmd);
        }
    }


    public static WinDef.HWND getHWND(String key) {
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow
                (null, key); // 第一个参数是Windows窗体的窗体类，第二个参数是窗体的标题。不熟悉windows编程的需要先找一些Windows窗体数据结构的知识来看看，还有windows消息循环处理，其他的东西不用看太多。
        if (hwnd == null) {
            System.out.println("Excel is not running");
        }else {
            User32.INSTANCE.ShowWindow(hwnd, 9);        // SW_RESTORE
            User32.INSTANCE.SetForegroundWindow(hwnd);
        }
        return hwnd;
    }

    /**
     * 获取文件夹下面所有文件集合（不递归）
     * @param path
     * @return
     */
    public static FileModel getFileAll(String path){
        FileModel fileModel = new FileModel();
        List<String> allFilePaths = new ArrayList<>();
        List<String> allFileName = new ArrayList<>();
        List<String> allMMLPaths = new ArrayList<>();
        Map<String,String> allMMLName = new HashMap<>();
        File file = new File(path);
        //单个文件
        if(file.isFile()){
            String filePath = path.substring(0,path.lastIndexOf(File.separator));
            String fileName = path.substring(path.lastIndexOf(File.separator)+1,path.length());
            String MMLName = fileName.replaceAll("\\.","_")+".MML";
            allFilePaths.add(path);
            allFileName.add(fileName);
            allMMLPaths.add(filePath+File.separator+MMLName);
            allMMLName.put(MMLName,path);
        }else if(file.isDirectory()) {
            //文件夹下所有文件（一级文件）
            File[] sourceName = file.listFiles();
            for (File source : sourceName){
                String fileName = source.getName();
                String filePath = source.getPath();
                String MMLName = fileName.replaceAll("\\.","_")+".MML";
                allFilePaths.add(path);
                allFileName.add(fileName);
                allMMLPaths.add(filePath+File.separator+MMLName);
                allMMLName.put(MMLName,path);
            }
        }
        fileModel.setAllFilePaths(allFilePaths);
        fileModel.setAllFileName(allFileName);
        fileModel.setAllMMLName(allMMLName);
        fileModel.setAllMMLPaths(allMMLPaths);
        return fileModel;
    }

    /**
     * 获取当前目录下所有的MML文件名称
     * @param path
     * @return
     */
    public static List<String> getMMLfile(String path){
        return getMMLfile(path,".MML");
    }

    /**
     * 获取当前目录下所有的type文件名称集合
     * @param path
     * @param type
     * @return
     */
    public static List<String> getMMLfile(String path,String type){
        List<String> result = new ArrayList<>();
        File file = new File(path);
        //单个文件
        if(file.isFile()){
            String fileType = path.substring(path.lastIndexOf("."),path.length());
            if(type.equals(fileType)){
                String fileName = path.substring(path.lastIndexOf(File.separator)+1,path.length());
                result.add(fileName);
            }
        }else if(file.isDirectory()) {
            //文件夹下所有文件（一级文件）
            File[] sourceName = file.listFiles();
            for (File source : sourceName){
                String filePath = source.getPath();
                String fileType = filePath.substring(filePath.lastIndexOf("."),filePath.length());
                if(type.equals(fileType)){
                    String fileName = path.substring(path.lastIndexOf(File.separator)+1,path.length());
                    result.add(fileName);
                }
            }
        }
        return result;
    }

    class RobotDemo {
        private Robot robot = null;

        public RobotDemo() {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //模拟Ctrl+Alt+Z的按下和抬起
        public void keyBoardDemo() {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_Z);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_Z);
        }

        //模拟鼠标移动
        public void move(int x ,int y) {
            robot.mouseMove(x, y);
        }
        //模拟鼠标的按下和抬起
        public void click() {
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }

        //模拟Center的按下和抬起
        public void enter() {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }

        public void pressKey(int keyvalue) {
            robot.keyPress(keyvalue); // 按下按键
            robot.keyRelease(keyvalue); // 释放按键

        }
        public void delay(int time){
            robot.delay(time);
        }

        //模拟tab
        public void tab() {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        public void setAndctrlVClipboardData(String string){
            StringSelection stringSelection = new StringSelection(string);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

    }
}
