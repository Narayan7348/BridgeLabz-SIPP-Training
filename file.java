public class File {
    private String name;
    private String path;

    public File(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}