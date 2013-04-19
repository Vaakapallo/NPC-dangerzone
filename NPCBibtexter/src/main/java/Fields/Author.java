package Fields;

public class Author implements Field {

    private String name;

    public Author(String name) {
        this.name = name;
    }

    @Override
    public String getField() {
        return name;
    }

    @Override
    public String toString() {
        return "author = {" + name + "},\n";
    }

    @Override
    public void setField(String value) {
        this.name = value;
    }
}
