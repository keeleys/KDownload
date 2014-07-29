package upload_continued.com.keeley.util;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-7-29
 * Time: 下午2:14
 * To change this template use File | Settings | File Templates.
 */
public class DownFileUtility {
    public DownFileUtility() {
    }

    /**
     * 休眠时长
     * @param nSecond
     */
    public static void sleep(int nSecond) {
        try {
            Thread.sleep(nSecond);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印日志信息
     * @param sMsg
     */
    public static void log(String sMsg) {
        System.err.println(sMsg);
    }

    /**
     * 打印日志信息
     * @param sMsg
     */
    public static void log(int sMsg) {
        System.err.println(sMsg);
    }
}
