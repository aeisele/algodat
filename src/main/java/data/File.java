package data;

// file approximation
public class File {

    private final String fileName;
    private final String content;

    public File(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }

}
