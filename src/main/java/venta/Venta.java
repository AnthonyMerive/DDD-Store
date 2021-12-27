package venta;

import co.com.sofka.domain.generic.AggregateEvent;

import co.com.sofka.domain.generic.DomainEvent;
import domicilio.values.DomicilioID;
import venta.entities.*;
import venta.events.*;
import venta.values.*;

import java.util.*;

public class Venta extends AggregateEvent<VentaID> {

    protected Set<Vendedor> vendedores;
    protected Set<Cliente> clientes;
    protected Set<Producto> productos;
    protected DomicilioID domicilioID;

    public Venta(VentaID entityId) {
        super(entityId);
        appendChange(new VentaCreada(entityId)).apply();
        subscribe(new VentaChange(this));

    }

    public static Venta from(VentaID ventaID, List<DomainEvent> events){
        var venta = new Venta(ventaID);
        events.forEach(venta::applyEvent);
        return venta;
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

    public DomicilioID domicilioID() {
        return domicilioID;
    }

    //Factory:

    protected Optional<Vendedor> obtenerVendedorPorID(VendedorID vendedorID){
        return vendedores
                .stream()
                .filter(vendedor -> vendedor.identity().equals(vendedorID)).findFirst();
    }

    protected Optional<Cliente> obtenerClientePorID(ClienteID clienteID){
        return clientes()
                .stream()
                .filter(cliente -> cliente.identity().equals(clienteID)).findFirst();
    }

    protected Optional<Producto> obtenerProductoPorID(ProductoID productoID){
        return productos
                .stream()
                .filter(producto-> producto.identity().equals(productoID)).findFirst();
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

    public void agregarVendedor(VendedorID vendedorID, Nombre nombre, Dependencia dependencia, MontoRecibido montoRecibido) {
        Objects.requireNonNull(vendedorID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(dependencia);
        Objects.requireNonNull(montoRecibido);

        appendChange(new VendedorAgregado(vendedorID, nombre, dependencia, montoRecibido)).apply();
    }
}
