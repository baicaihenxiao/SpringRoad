package club.cser.springroad.beans.entity;

public class HelloWorld {

    private String name;

    public HelloWorld() {
        System.out.println("initialize HelloWorld...no args");
    }

    public HelloWorld(String name) {
        System.out.println("initialize HelloWorld...with args " + name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello: " + name);
    }
}
