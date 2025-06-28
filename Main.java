public class Main {
    public static void main(String[] args) {
        Voltage220 directCharger = new Mobile();
        directCharger.charge();

        System.out.println("Зарядка через адаптер");
        Voltage380 socket = new Voltage380();
        Voltage220 adapter = new VoltageAdapter(socket);
        adapter.charge();
    }
}

class Voltage380 {
    public void send380V() {
        System.out.println("Напряжение 380 В");
    }
}

interface Voltage220 {
    void charge();
}

class Mobile implements Voltage220 {
    @Override
    public void charge() {
        System.out.println("Телефон заряжается от 220 В");
    }
}

class VoltageAdapter implements Voltage220 {
    private Voltage380 source;

    public VoltageAdapter(Voltage380 source) {
        this.source = source;
    }

    @Override
    public void charge() {
        source.send380V();
        System.out.println("Адаптер преобразует 380 В в 220 В");
        System.out.println("Телефон заряжается через адаптер от 380 В");
    }
}
