public class Counter {


    public void a() {
        synchronized (Main.o1) {
            // T1
            synchronized (Main.o2) {

            }
        }
    }

    public void b() {
        synchronized (Main.o2) {
            // T2
            synchronized (Main.o1) {

            }
        }
    }
}
