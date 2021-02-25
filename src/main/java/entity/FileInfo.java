package entity;

/**
 *文件信息
 *
 * @author qq3434569
 */
public class FileInfo {
    private String url;
    private String fileName;
    private String extension;

    public FileInfo(String url, String fileName, String extension) {
        this.url = url;
        this.fileName = fileName;
        this.extension = extension;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
