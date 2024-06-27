package blanc.utils;

public class Template {

    private String template;

    public Template(String template) {
        this.template = template;
    }

    public Template set(String name, String value) {
        template = template.replace(String.format("${%s}", name), value);
        return this;
    }

    public String text() {
        return template;
    }

}
