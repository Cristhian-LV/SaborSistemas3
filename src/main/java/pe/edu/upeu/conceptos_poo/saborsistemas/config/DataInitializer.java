package pe.edu.upeu.conceptos_poo.saborsistemas.config;

import pe.edu.upeu.conceptos_poo.saborsistemas.modelos.*;
import pe.edu.upeu.conceptos_poo.saborsistemas.service.*;

public class DataInitializer {

    // 1. Inyección de dependencia por constructor (usando la interfaz, y es final)
    private final ProductoInterface productoInterface;
    private final CategoriaInterface categoriaInterface;
    private final UsuarioInterface usuarioInterface;
    private final PerfilInterface perfilInterface;
    private final UnidadMedidaInterface unidadMedidaInterface;

    public DataInitializer(final ProductoInterface productoInterface, CategoriaInterface categoriaInterface, UsuarioInterface usuarioInterface, PerfilInterface perfilInterface, UnidadMedidaInterface unidadMedidaInterface) {
        this.productoInterface = productoInterface;
        this.categoriaInterface = categoriaInterface;
        this.usuarioInterface = usuarioInterface;
        this.perfilInterface = perfilInterface;
        this.unidadMedidaInterface = unidadMedidaInterface;
    }


    public void initializeData() {
        dataProductos();
        dataCategorias();
        dataUsuarios();
        dataPerfiles();
        dataUnidadesMedida();
    }

    private void dataProductos() {
        try {
            // Asume que la interfaz ProductoInterface tiene un método count()
            if (productoInterface.count() == 0) {

                System.out.println("--- INICIALIZADOR DE DATOS ---");
                System.out.println("No se encontraron productos. Agregando datos de prueba...");

                String[] nombres=new String[]{"Hamburguesas","Papas fritas","Coca cola (500ml)","Torta de chocolate","Ensalada","Sopa de tomate","Café americano"};
                Double[] precios=new Double[]{8.5,3.0,2.5,4.5,7.0,5.5,2.0};
                Long[] stocks=new Long[]{98L,197L,299L,50L,98L,80L,100L};
                Categoria[] categorias=new Categoria[]{
                        new Categoria(1L,""),
                        new Categoria(3L,""),
                        new Categoria(2L,""),
                        new Categoria(4L,""),
                        new Categoria(5L,""),
                        new Categoria(6L,""),
                        new Categoria(7L,"")
                };

                UnidadMedida[] unidadesM=new UnidadMedida[]{
                        new UnidadMedida(1L,""),
                        new UnidadMedida(2L,""),
                        new UnidadMedida(1L,""),
                        new UnidadMedida(2L,""),
                        new UnidadMedida(1L,""),
                        new UnidadMedida(4L,""),
                        new UnidadMedida(3L,"")
                };

                for (int i = 0; i < nombres.length; i++) {
                    Producto producto=new Producto();
                    producto.setNombre(nombres[i]);
                    producto.setPrecioU(precios[i]);
                    producto.setStok(stocks[i]);
                    producto.setCategoria(categorias[i]);
                    producto.setUnidadMedida(unidadesM[i]);
                    productoInterface.saveProducto(producto);
                }
                System.out.println("Se han agregado los productos de prueba.");
                System.out.println("------------------------------------");

            } else {
                System.out.println("La base de datos ya contiene productos. Inicialización de 'ss_Producto' omitida.");
            }
        } catch (Exception e) {
            System.err.println("Error al intentar inicializar los datos: " + e.getMessage());
            // Dependiendo de tu lógica, puedes decidir si este error es fatal o no.
        }
    }

    private void dataCategorias(){
        try {
            if (categoriaInterface.count() == 0) {

                String[] nombres=new String[]{"Plato fuerte","Bebida","Acompañamientos","Postres","Platos ligeros","Entradas","Bebidas calientes"};

                for (int i = 0; i < nombres.length; i++) {
                    Categoria categoria=new Categoria();
                    categoria.setNombre(nombres[i]);
                    categoriaInterface.save(categoria);
                }
                System.out.println("Se han agregado los datos de prueba.");
                System.out.println("------------------------------------");

            } else {
                System.out.println("La db ya tiene datos");
            }
        } catch (Exception e) {
            System.err.println("Error al intentar inicializar los datos: " + e.getMessage());
        }
    }

    private void dataUsuarios(){
        try {
            if (usuarioInterface.count() == 0) {

                String[] nombres=new String[]{"cliente@gmail.com","vendedor@gmail.com","jclv@gmail.com"};
                String[] claves=new String[]{"admin123","admin123","admin123"};
                String[] roles=new String[]{"Cliente","Vendedor","Administrador"};
                Perfil[] perfiles=new Perfil[]{
                        new Perfil(1L,"Cliente","CLIENT"),
                        new Perfil(3L,"Vendedor","Vend"),
                        new Perfil(2L,"Administrador","ADMI")
                };


                for (int i = 0; i < nombres.length; i++) {
                    Usuario usuario=new Usuario();
                    usuario.setNombre_Usuario(nombres[i]);
                    usuario.setClave(claves[i]);
                    usuario.setRol(roles[i]);
                    usuario.setIdPerfil(perfiles[i]);
                    usuarioInterface.save(usuario);
                }
                System.out.println("Se han agregado los datos de prueba.");
                System.out.println("------------------------------------");

            } else {
                System.out.println("La db ya tiene datos");
            }
        } catch (Exception e) {
            System.err.println("Error al intentar inicializar los datos: " + e.getMessage());
            // Dependiendo de tu lógica, puedes decidir si este error es fatal o no.
        }
    }

    private void dataPerfiles(){
        try {
            if (perfilInterface.count() == 0) {

                String[] correos=new String[]{"Cliente","Administrador","Vendedor"};
                String[] claves=new String[]{"CLIENT","ADMI","Vend"};

                for (int i = 0; i < correos.length; i++) {
                    Perfil perfil=new Perfil();
                    perfil.setCorreo(correos[i]);
                    perfil.setContraseña(claves[i]);
                    perfilInterface.save(perfil);
                }
                System.out.println("Se han agregado los datos de prueba.");
                System.out.println("------------------------------------");

            } else {
                System.out.println("La db ya tiene datos");
            }
        } catch (Exception e) {
            System.err.println("Error al intentar inicializar los datos: " + e.getMessage());
            // Dependiendo de tu lógica, puedes decidir si este error es fatal o no.
        }
    }

    private void dataUnidadesMedida(){
        try {
            if (unidadMedidaInterface.count() == 0) {

                String[] nombres=new String[]{"Unidad","Porción","Taza","Tazón","Sobre"};

                for (int i = 0; i < nombres.length; i++) {
                    UnidadMedida uMedida=new UnidadMedida();
                    uMedida.setNombre_Medida(nombres[i]);
                    unidadMedidaInterface.save(uMedida);
                }
                System.out.println("Se han agregado los datos de prueba.");
                System.out.println("------------------------------------");

            } else {
                System.out.println("La db ya tiene datos");
            }
        } catch (Exception e) {
            System.err.println("Error al intentar inicializar los datos: " + e.getMessage());
            // Dependiendo de tu lógica, puedes decidir si este error es fatal o no.
        }
    }
}