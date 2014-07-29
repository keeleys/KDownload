package upload_continued;

import junit.framework.Assert;
import org.junit.Test;
import upload_continued.com.keeley.core.DownFileFetch;
import upload_continued.com.keeley.core.DownFileInfoBean;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-7-29
 * Time: 下午2:03
 * To change this template use File | Settings | File Templates.
 */
public class AppTest {

    @Test
    public void testDown() throws IOException {
        DownFileInfoBean bean = new DownFileInfoBean(
                "http://cdn.market.hiapk.com/data/upload//2012/09_27/17/car.wu.wei.kyo.shandian_174928.apk", "e:\\temp",
                "shandian_174928.apk", 5,true,null);
            /*File file = new File("D:\\dan07.apk");
            DownFileInfoBean bean = new DownFileInfoBean(null, "D:\\temp",
                    "dan07.apk", 3,false,file);*/
        DownFileFetch fileFetch = new DownFileFetch(bean);
        fileFetch.start();
    }
}
