```java
// Código de ejemplo de una aplicación móvil para conciertos

public class AppConciertos {

    public static void main(String[] args) {
        System.out.println("Iniciando la aplicación de conciertos...");

        // Inicializar la base de datos de eventos y boletos
        BaseDatosConciertos baseDatos = new BaseDatosConciertos();

        // Crear un objeto para la gestión de ventas
        GestorVentas gestorVentas = new GestorVentas(baseDatos);

        // Simular la venta de un boleto
        Boleto boleto = gestorVentas.venderBoleto(1, "Juan Pérez");
        if (boleto != null) {
            System.out.println("Boleto vendido a: " + boleto.getNombreCliente());
        }

        // Simular el acceso a un evento con un código QR
        boolean accesoPermitido = gestorVentas.verificarAcceso(boleto.getCodigoQR());
        if (accesoPermitido) {
            System.out.println("Acceso permitido.");
        } else {
            System.out.println("Acceso denegado.");
        }

        System.out.println("Aplicación de conciertos finalizada.");
    }
}

class BaseDatosConciertos {
    // Aquí iría la lógica para almacenar y recuperar datos de eventos y boletos
    public Boleto obtenerBoleto(int idBoleto) {
        // Simulación: crear un boleto de ejemplo
        return new Boleto(idBoleto, "Cliente de ejemplo", "QR123");
    }
}

class GestorVentas {
    private BaseDatosConciertos baseDatos;

    public GestorVentas(BaseDatosConciertos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public Boleto venderBoleto(int idBoleto, String nombreCliente) {
        // Simulación: obtener el boleto de la base de datos y asignar el cliente
        Boleto boleto = baseDatos.obtenerBoleto(idBoleto);
        if (boleto != null) {
            boleto.setNombreCliente(nombreCliente);
        }
        return boleto;
    }

    public boolean verificarAcceso(String codigoQR) {
        // Simulación: verificar el código QR
        return codigoQR.equals("QR123");
    }
}

class Boleto {
    private int id;
    private String nombreCliente;
    private String codigoQR;

    public Boleto(int id, String nombreCliente, String codigoQR) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.codigoQR = codigoQR;
    }

    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCodigoQR() {
        return codigoQR;
    }
}
```
