package club.cser.springroad.beans.entity;

public class BeanLifeCycle {

    private String cycle;

    @Override
    public String toString() {
        return "BeanLifeCycle{" +
                "cycle='" + cycle + '\'' +
                '}';
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        System.out.println("settingg method..." + cycle);
        this.cycle = cycle;
    }

    public BeanLifeCycle() {
        System.out.println("constructt method..." + cycle);
    }

    public void initttt() {
        System.out.println("initt method..." + cycle);
    }

    public void destroyyyy() {
        System.out.println("destroyy method..." + cycle);
    }
}
