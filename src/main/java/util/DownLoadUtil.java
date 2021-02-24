package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 下载文件工具类
 *
 * @author qq3434569
 */
public class DownLoadUtil {

    private static Logger logger = LoggerFactory.getLogger(DownLoadUtil.class);

    /**
     * byte[] 转 file
     *
     * @param bytes 数据流
     * @param path  保存路径包括后缀，如c:\1.jpg
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static void byteToFile(byte[] bytes, String path) {
        try {
            // 根据绝对路径初始化文件
            File localFile = new File(path);
            if (!localFile.getParentFile().exists()) {
                localFile.getParentFile().mkdirs();
            }
            if (!localFile.exists()) {
                localFile.createNewFile();
            }
            // 输出流
            OutputStream os = new FileOutputStream(localFile);
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过链接下载
     *
     * @param link 下载地址 www.baidu.com
     * @param path 保存地址
     */
    public static void download(String link, String path) {
        try {
            URL url = new URL(link);
            URLConnection con = url.openConnection();
            InputStream inStream = con.getInputStream();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buf)) != -1) {
                outStream.write(buf, 0, len);
            }
            inStream.close();
            outStream.close();
            File file = new File(path);
            FileOutputStream op = new FileOutputStream(file);
            op.write(outStream.toByteArray());
            op.close();
            logger.info("从地址: " + link + " 下载文件到 " + path + "，成功");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        download("https://camo.githubusercontent.com/630f73326097842936af8d275a5f6af5f0e4388cfef1822499d9fffc04f2def6/687474703a2f2f636f64653463726166742e6769746875622e696f2f696d616765732f706f7374732f7765626d616769632e706e67", "D:/0.jpg");
        download("https://kf.centerm.com/file-service/files/agent/chatVideo/20201113003040113120.mp4", "D:/1.mp4");
    }
}
