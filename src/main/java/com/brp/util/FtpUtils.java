package com.brp.util;

import org.apache.commons.net.ftp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * FTP 工具类
 * Created by Administrator on 2016/8/19.
 */
public class FtpUtils {
    private static final Logger LOG = LoggerFactory.getLogger(FtpUtils.class);

    private static String hostname="10.3.45.153";
    private static Integer port=21;
    private static String username="crm";
    private static String password="rfd.com";
    private static FTPClient ftp=getConnectionFTP();

   /* static {
        try {
            hostname=ConfigUtils.getString("ftp.hostname");
            username= ConfigUtils.getString("ftp.username");
            password=ConfigUtils.getString("ftp.password");
            port =ConfigUtils.getInt("ftp.port");
        } catch (Exception e) {
            LOG.error("init fail",e);
            e.printStackTrace();
        }
    }*/

    /**
     * 获得连接-FTP方式
     */
    public static FTPClient getConnectionFTP() {
        //创建FTPClient对象
        FTPClient ftp = new FTPClient();
        try {
            //连接FTP服务器
            ftp.connect(hostname, port);
            //下面三行代码必须要，而且不能改变编码格式，否则不能正确下载中文文件
            ftp.setControlEncoding("UTF-8");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");
            //登录ftp
            ftp.login(username, password);
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                ftp.disconnect();
                LOG.error("连接FTP服务器失败");
            }
        } catch (IOException e) {
            LOG.error("连接FTP服务器失败");
            e.printStackTrace();
        }
        return ftp;
    }

    /**
     * 关闭连接-FTP方式
     * @return boolean
     */
    public static boolean closeFTP() {
        if (ftp.isConnected()) {
            try {
                ftp.disconnect();
                return true;
            } catch (Exception e) {
                LOG.error("关闭FTP服务器失败");
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 上传文件-FTP方式
     * @param path FTP服务器上传地址
     * @param fileName 本地文件路径
     * @param inputStream 输入流
     * @return boolean
     */
    public static boolean uploadFile(String path, String fileName, InputStream inputStream) {
        boolean success = false;
        try {
            ftp.changeWorkingDirectory(path);//转移到指定FTP服务器目录
            FTPFile[] fs = ftp.listFiles();//得到目录的相应文件列表
            fileName = changeName(fileName, fs);
            fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
            path = new String(path.getBytes("UTF-8"), "ISO-8859-1");
            //转到指定上传目录
            ftp.changeWorkingDirectory(path);
            //将上传文件存储到指定目录
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码
            ftp.storeFile(fileName, inputStream);
            //关闭输入流
            inputStream.close();
            //退出ftp
          //  ftp.logout();
            //表示上传成功
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }


    /**
     * 删除文件-FTP方式
     * @param path FTP服务器上传地址
     * @param fileName FTP服务器上要删除的文件名
     * @return
     */
    public static boolean deleteFile(String path, String fileName) {
        boolean success = false;
        try {
            ftp.changeWorkingDirectory(path);//转移到指定FTP服务器目录
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            path = new String(path.getBytes("UTF-8"), "ISO-8859-1");
            ftp.deleteFile(fileName);
            ftp.logout();
            success = true;
        } catch (Exception e) {
            LOG.error("FTP 删除出错",e);
            e.printStackTrace();
        }
        return success;
    }

    /**
     * 下载文件-FTP方式
     * @param path FTP服务器上传地址
     * @param fileName 本地文件路径
     * @param localPath 本里存储路径
     * @return boolean
     */
    public static boolean downFile(String path, String fileName, String localPath,OutputStream outputStream) {
        boolean success = false;
        try {
            ftp.changeWorkingDirectory(path);//转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles(); //得到目录的相应文件列表
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "\\" + ff.getName());
                  /*  OutputStream outputStream = new FileOutputStream(localFile);*/
                    //将文件保存到输出流outputStream中
                    ftp.retrieveFile(new String(ff.getName().getBytes("UTF-8"), "ISO-8859-1"), outputStream);
                    outputStream.flush();
                    outputStream.close();
                }
            }
          //  ftp.logout();
            success = true;
        } catch (Exception e) {
            LOG.error("FTP 下载出错",e);
            e.printStackTrace();
        }
        return success;
    }

    /**
     * 判断是否有重名文件
     * @param fileName
     * @param fs
     * @return
     */
    public static boolean isFileExist(String fileName, FTPFile[] fs) {
        for (int i = 0; i < fs.length; i++) {
            FTPFile ff = fs[i];
            if (ff.getName().equals(fileName)) {
                return true; //如果存在返回 正确信号
            }
        }
        return false; //如果不存在返回错误信号
    }

    /**
     * 根据重名判断的结果 生成新的文件的名称
     * @param fileName
     * @param fs
     * @return
     */
    public static String changeName(String fileName, FTPFile[] fs) {
        int n = 0;
//      fileName = fileName.append(fileName);
        while (isFileExist(fileName.toString(), fs)) {
            n++;
            String a = "[" + n + "]";
            int b = fileName.lastIndexOf(".");//最后一出现小数点的位置
            int c = fileName.lastIndexOf("[");//最后一次"["出现的位置
            if (c < 0) {
                c = b;
            }
            StringBuffer name = new StringBuffer(fileName.substring(0, c));//文件的名字
            StringBuffer suffix = new StringBuffer(fileName.substring(b + 1));//后缀的名称
            fileName = name.append(a) + "." + suffix;
        }
        return fileName.toString();
    }


    public void createDirs(String remoteUpLoadPath) throws IOException {
        String[] dirs = remoteUpLoadPath.split("/");
        for (String dir : dirs) {
            this.ftp.mkd(dir);
            this.ftp.changeWorkingDirectory(dir);

        }
    }



    public static void main(String[] args) throws FileNotFoundException {

        String path = "/brp/";
        File f1 = new File("E:\\中在在.zip");
        String filename = f1.getName();
      /*  System.out.println(filename);*/
        //InputStream input = new FileInputStream(f1);
        //ftpTest a = new ftpTest();
        //a.uploadFile("172.25.5.193", 21, "shiyanming", "123", path, filename, input);
        /*
         * String path ="D:\\ftpindex\\"; File f2 = new
         * File("D:\\ftpindex\\old.txt"); String filename2= f2.getName();
         * System.out.println(filename2); ftpTest a = new
         * ftpTest(); a.downFile("172.25.5.193", 21, "shi", "123", path,
         * filename2, "C:\\");
         */
        InputStream input = new FileInputStream(f1);
//      a.uploadFile("218.108.250.205", 21, "hwyhftp", "!#hwyhftp", path, filename, input);
        //a.deleteFile("218.108.250.205", 21, "hwyhftp", "!#hwyhftp", path, filename);
//      a.downFile("218.108.250.205", 21, "hwyhftp", "!#hwyhftp", path, "欢[2].txt");
        /*FTPClient ftp = getConnectionFTP();*/
//      a.deleteFile(ftp, path, "a[2].txt");
       /* boolean r= FtpUtils.uploadFile(path, filename, input);*/
       /* System.out.println(r);*/
       /* FtpUtils.downFile(path, filename, "F:/");*/
        /*FtpUtils.deleteFile(path, filename);*/
        FtpUtils.closeFTP();
    }

}
