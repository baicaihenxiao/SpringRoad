package club.cser.springroad.beans.entity;

public class People {
    private int age;
    private HelloWorld helloWorld;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void hi() {
        System.out.println("People say hi:" + age + " " + helloWorld.getName());
    }
}
