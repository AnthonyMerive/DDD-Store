package venta;

import co.com.sofka.domain.generic.AggregateEvent;
import domicilio.values.DomicilioID;
import venta.entities.*;
import venta.events.*;
import venta.values.*;

import java.util.*;

public class Venta extends AggregateEvent<VentaID> {

    protected Set<Vendedor> vendedores;
    protected Set<Cliente> clientes;
    protected Set<Producto> productos;

    public Venta(VentaID entityId) {
        super(entityId);
        subscribe(new VentaChange(this));

    }

    public Set<Vendedor> vendedores() {
        return vendedores;
    }

    public Set<Cliente> clientes() {
        return clientes;
    }

    public Set<Producto> productos() {
        return productos;
    }

    //Commands:

    public void asociarDomicilio(DomicilioID domicilioID) {
        Objects.requireNonNull(domicilioID);

        appendChange(new DomicilioAsociado(domicilioID)).apply();
    }

    public void agregarCliente(ClienteID clienteID, Nombre nombre, Direccion direccion, MontoPago montoPago) {
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(montoPago);

        appendChange(new ClienteAgregado(clienteID, nombre, direccion, montoPago)).apply();
    }

    public void agregarProducto(ProductoID productoID, Nombre nombre, Descripcion descripcion, CostoProducto costoProducto) {
        Objects.requireNonNull(productoID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(costoProducto);

        appendChange(new ProductoAgregado(productoID, nombre, descripcion, costoProducto)).apply();

    }
}
