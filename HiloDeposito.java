class HiloDeposito extends Thread {
    private CuentaBancaria cuenta;
    private double cantidad;

    public HiloDeposito(CuentaBancaria cuenta, double cantidad) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            cuenta.depositar(cantidad);
            try {
                Thread.sleep(100); // Simula un trabajo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}