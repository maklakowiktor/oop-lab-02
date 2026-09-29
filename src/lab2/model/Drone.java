package lab2.model;

import lab2.annotation.Repeat;

public class Drone {
    private final String name;

    public Drone(String name) {
        this.name = name;
    }

    @Repeat(5)
    public void greet(String person) {
        System.out.println(name + ": hello, " + person);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public void report(String task, double progress, boolean done) {
        System.out.printf("%s: %s %.1f%% (done: %b)%n", name, task, progress, done);
    }

    @Repeat(2)
    protected void beep(int times) {
        System.out.println(name + ": " + "beep ".repeat(times).trim());
    }

    @Repeat(3)
    protected void moveTo(double x, double y) {
        System.out.println(name + ": moves to (" + x + ", " + y + ")");
    }

    protected void charge(int percent) {
        System.out.println(name + ": charged to " + percent + "%");
    }

    @Repeat(1)
    private void scan(String area, long radius, char mode) {
        System.out.println(name + ": scans " + area + " in radius " + radius + " (mode: " + mode + ")");
    }

    @Repeat(2)
    private void log(StringBuilder buffer) {
        buffer.append("log;");
        System.out.println(name + ": writes log, buffer = " + buffer);
    }

    private void selfDestruct() {
        System.out.println(name + ": self destruct");
    }
}
