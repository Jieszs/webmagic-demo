package samples.pipeline;

import entity.FileInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;
import util.DownLoadUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 文件下载
 *
 * @author qq3434569
 */
public class FileDownLoadPipeline extends FilePersistentBase implements Pipeline {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public FileDownLoadPipeline() {
        this.setPath("/data/webmagic/");
    }

    public FileDownLoadPipeline(String path) {
        this.setPath(path);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        String path = this.path + PATH_SEPERATOR + task.getUUID() + PATH_SEPERATOR;
        List<FileInfo> fileInfos = resultItems.get("fileInfos");
        if (CollectionUtils.isEmpty(fileInfos)) {
            return;
        }
        for (FileInfo fileInfo : fileInfos) {
            DownLoadUtil.download(fileInfo.getUrl(), path + fileInfo.getFileName() + "." + fileInfo.getExtension());
        }

    }
}
