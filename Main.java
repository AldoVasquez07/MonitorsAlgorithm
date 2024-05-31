public class Main {
	public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();

        HiloDeposito hiloDeposito = new HiloDeposito(cuenta, 100);
        HiloRetiro hiloRetiro = new HiloRetiro(cuenta, 50);

        hiloDeposito.start();
        hiloRetiro.start();

        try {
            hiloDeposito.join();
            hiloRetiro.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
