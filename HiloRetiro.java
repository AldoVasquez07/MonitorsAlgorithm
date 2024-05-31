class HiloRetiro extends Thread {
    private CuentaBancaria cuenta;
    private double cantidad;

    public HiloRetiro(CuentaBancaria cuenta, double cantidad) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            cuenta.retirar(cantidad);
            try {
                Thread.sleep(150); // Simula un trabajo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
