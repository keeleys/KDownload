package upload_continued.com.keeley.test;

import upload_continued.com.keeley.core.DownFileFetch;
import upload_continued.com.keeley.core.DownFileInfoBean;
import upload_continued.com.keeley.listen.DownListener;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-7-29
 * Time: 下午2:25
 * To change this template use File | Settings | File Templates.
 */
public class TestDown {
    public static void main(String[] args) {
        try {
            DownFileInfoBean bean = new DownFileInfoBean(
                    "http://dldir1.qq.com/qqfile/qq/QQ6.1/11905/QQ6.1.exe", "e:\\temp",
                    "QQ6.1.exe", 5,true,null);
            /*File file = new File("D:\\dan07.apk");
            DownFileInfoBean bean = new DownFileInfoBean(null, "D:\\temp",
                    "dan07.apk", 3,false,file);*/
            DownFileFetch fileFetch = new DownFileFetch(bean);
            fileFetch.addListener( new DownListener() {
                public void success() {
                    System.out.println("client end");
                }
            });
            fileFetch.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
