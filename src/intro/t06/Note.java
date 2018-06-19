package intro.t06;

public class Note {
    private String title;
    private String body;

    public Note setTitle(String title) {
        this.title = title;
        return this;
    }

    public Note setBody(String body) {
        this.body = body;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}