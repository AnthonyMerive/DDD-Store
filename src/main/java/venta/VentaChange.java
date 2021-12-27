package venta;

import co.com.sofka.domain.generic.EventChange;
import venta.entities.*;
import venta.events.*;

import java.util.HashSet;

public class VentaChange extends EventChange {

    public VentaChange(Venta venta) {

        apply((VentaCreada event) ->{
            venta.vendedores = new HashSet<>();
            venta.clientes = new HashSet<>();
            venta.productos = new HashSet<>();
        });

        apply((DomicilioAsociado event) ->{
            venta.domicilioID = event.domicilioID();

        });

        apply((ClienteAgregado event) ->{
            var numClientes = venta.clientes().size();

            if(numClientes > 1){
                throw new IllegalArgumentException("Solo debe existir un cliente por venta");
            }

            venta.clientes.add(new Cliente(
                    event.clienteID(),
                    event.nombre(),
                    event.direccion(),
                    event.montoPago()
            ));

        });

        apply((ProductoAgregado event) ->{
            var numProductos = venta.productos().size();

            if(numProductos > 100){
                throw new IllegalArgumentException("Demasiados productos para una venta");
            }

            venta.productos.add(new Producto(
                    event.productoID(),
                    event.nombre(),
                    event.descripcion(),
                    event.costoProducto()
            ));
        });

        apply((VendedorAgregado event) ->{
            var numVendedor = venta.vendedores().size();

            if(numVendedor > 1){
                throw new IllegalArgumentException("Solo debe existir un vendedor por venta");
            }

            venta.vendedores.add(new Vendedor(
                    event.vendedorID(),
                    event.nombre(),
                    event.dependencia(),
                    event.montoRecibido()
            ));
        });
    }

}
