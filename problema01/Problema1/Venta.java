package Problema1;

import java.util.Scanner;

public class Venta {
    private double precioProducto;
    private int producto;
    private double descuento;
    private double precioFinal;

    public Venta( int producto, double precioProducto ) {
        this.precioProducto = precioProducto;
        this.producto = producto;
    }


    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void CalcularDescuento() {
        if (this.precioProducto >= 1000 && this.producto >= 10) {
            this.descuento = this.precioProducto * 0.10;
        } else  {
            this.descuento = this.precioProducto * 0.05;
        }
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void CalcularprecioFinal() {
        this.precioFinal = this.precioProducto - descuento;
    }

    public String toString() {
        return String.format("Ventas"
                        + "\nProductos: %d"
                        + "\nPrecio de los productos: %.2f"
                        + "\nDescuento: %.2f"
                        + "\nPrecio Final: %.2f",
                this.producto, this.precioProducto, this.descuento, this.precioFinal);
    }
}

class ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de productos y el precio ");
        Venta venta1 = new Venta(sc.nextInt(), sc.nextDouble());
        venta1.CalcularDescuento();
        venta1.CalcularprecioFinal();
        System.out.println(venta1);
    }
}
