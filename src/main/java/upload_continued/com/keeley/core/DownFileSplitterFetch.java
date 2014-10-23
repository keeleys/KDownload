package upload_continued.com.keeley.core;

import upload_continued.com.keeley.util.DownFileUtility;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownFileSplitterFetch extends Thread{
    String sURL; // 下载文件的地址
    long nStartPos; // 文件分段的开始位置
    long nEndPos; // 文件分段的结束位置
    int nThreadID; // 线程的 ID
    boolean bDownOver = false; // 是否下载完成
    boolean bStop = false; // 停止下载
    DownFileAccess fileAccessI = null; // 文件对象
    boolean bFirst = true;

    /**
     * 下载，上传子线程初始化
     * @param sURL
     * @param sName
     * @param nStart
     * @param nEnd
     * @param id
     * @throws IOException
     */
    public DownFileSplitterFetch(String sURL, String sName, long nStart, long nEnd,
                                 int id,boolean bFirst) throws IOException {
        this.sURL = sURL;
        this.nStartPos = nStart;
        this.nEndPos = nEnd;
        nThreadID = id;
        fileAccessI = new DownFileAccess(sName, nStartPos,bFirst);
        this.bFirst = bFirst;
    }

    /**
     * 线程执行
     */
    public void run() {
        this.urldownload();
    }

    /**
     * 地址下载
     */
    private void urldownload(){
        DownFileUtility.log("Thread " + nThreadID + " url start >> "+nStartPos +"------end >> "+nEndPos);
        while (nStartPos < nEndPos && !bStop) {
            try {
                URL url = new URL(sURL);
                HttpURLConnection httpConnection = (HttpURLConnection) url
                        .openConnection();
                httpConnection.setRequestProperty("User-Agent", "NetFox");
                String sProperty = "bytes=" + nStartPos + "-";
                httpConnection.setRequestProperty("RANGE", sProperty); //从起始开始读取
                DownFileUtility.log(sProperty);
                InputStream input = httpConnection.getInputStream();
                byte[] b = new byte[1024];
                int nRead;
                while ((nRead = input.read(b, 0, 1024)) > 0         //读取到结束点nEndPos
                        && nStartPos < nEndPos && !bStop) {
                    if((nStartPos+nRead)>nEndPos)
                    {
                        nRead = (int)(nEndPos - nStartPos);
                    }
                    nStartPos += fileAccessI.write(b, 0, nRead);
                }
                DownFileUtility.log("Thread " + nThreadID + " nStartPos : "+nStartPos);
                fileAccessI.oSavedFile.close();
                DownFileUtility.log("Thread " + nThreadID + " is over!");
                input.close();
                bDownOver = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(!bDownOver){
            if(nStartPos >= nEndPos){
                bDownOver = true;
            }
        }
    }
    /**
     * 停止
     */
    public void splitterStop() {
        bStop = true;
    }
}
