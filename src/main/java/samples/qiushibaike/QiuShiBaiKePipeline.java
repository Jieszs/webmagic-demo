package samples.qiushibaike;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

public class QiuShiBaiKePipeline extends FilePersistentBase implements Pipeline {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public QiuShiBaiKePipeline() {
        this.setPath("/data/webmagic/");
    }

    public QiuShiBaiKePipeline(String path) {
        this.setPath(path);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        String path = this.path + PATH_SEPERATOR + task.getUUID() + PATH_SEPERATOR;

        try {
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.getFile(path + DigestUtils.md5Hex(resultItems.getRequest().getUrl()) + ".txt")), "UTF-8"));
            printWriter.println("url:\t" + resultItems.getRequest().getUrl());
            List<String> authors = resultItems.get("authors");
            List<String> ages = resultItems.get("ages");
            List<String> contents = resultItems.get("contents");
            List<String> likeCount = resultItems.get("likeCount");
            List<String> commentCount = resultItems.get("commentCount");
            for (int i = 0; i < contents.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("作者：").append(authors.get(i))
                        .append("\t年龄：").append(ages.get(i))
                        .append("\n内容:").append(contents.get(i))
                        .append("\n点赞数：").append(likeCount.get(i))
                        .append("\t评论数:").append(commentCount.get(i));
                printWriter.println(sb.toString());
            }
            printWriter.close();
        } catch (IOException var10) {
            this.logger.warn("write file error", var10);
        }

    }
}
