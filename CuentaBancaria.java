class CuentaBancaria {
    private double saldo = 0;

    // Método sincronizado para depositar dinero
    public synchronized void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Depositado: " + cantidad + ", Nuevo saldo: " + saldo);
        notify(); // Notifica a los hilos en espera
    }

    // Método sincronizado para retirar dinero
    public synchronized void retirar(double cantidad) {
        while (saldo < cantidad) {
            try {
                System.out.println("Esperando para retirar: " + cantidad + ", Saldo actual: " + saldo);
                wait(); // Espera hasta que haya suficiente saldo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        saldo -= cantidad;
        System.out.println("Retirado: " + cantidad + ", Nuevo saldo: " + saldo);
    }

    // Método para obtener el saldo actual
    public synchronized double obtenerSaldo() {
        return saldo;
    }
}
