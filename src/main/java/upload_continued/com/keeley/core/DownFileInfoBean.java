package upload_continued.com.keeley.core;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-7-29
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */
public class DownFileInfoBean {
    private String sSiteURL; // 文件的下载地址
    private String sFilePath; // 保存文件的路径
    private String sFileName; // 保存文件的名字
    private int nSplitter; // 文件分成几段，默认是5段

    /**
     * 默认初始化
     */
    public DownFileInfoBean() {
        // default 5
        this("", "", "", 5);
    }
    /**
     * 下载文件信息初始化
     * @param sURL 下载的链接地址
     * @param sPath 上传的保存路径
     * @param sName 上传保存的文件名
     * @param nSpiltter 文件分段个数
     */
    public DownFileInfoBean(String sURL, String sPath, String sName, int nSpiltter) {
        sSiteURL = sURL;
        sFilePath = sPath;
        sFileName = sName;
        this.nSplitter = nSpiltter;
    }

    public String getSSiteURL() {
        return sSiteURL;
    }

    public void setSSiteURL(String value) {
        sSiteURL = value;
    }

    public String getSFilePath() {
        return sFilePath;
    }

    public void setSFilePath(String value) {
        sFilePath = value;
    }

    public String getSFileName() {
        return sFileName;
    }

    public void setSFileName(String value) {
        sFileName = value;
    }

    public int getNSplitter() {
        return nSplitter;
    }

    public void setNSplitter(int nCount) {
        nSplitter = nCount;
    }
}
