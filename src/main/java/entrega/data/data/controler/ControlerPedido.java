package entrega.data.data.controler;

import entrega.data.data.dto.Pedido;
import entrega.data.data.dto.Respuesta;
import entrega.data.data.excepciones.ExcepcionManager;
import entrega.data.data.mgr.ImgrPedido;
import entrega.data.data.mgr.MgrPedido;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/demo")
public class ControlerPedido {

    ImgrPedido manager = new MgrPedido();

    @PostMapping(path = "pedido/save")
    public @ResponseBody void save (@RequestBody Pedido pedido){

        try {
            manager.Save(pedido);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }

    }

    @DeleteMapping(path = "pedido/delate")
    public @ResponseBody void delate (@RequestBody Pedido pedido){

        try {
            manager.Delete(pedido);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/pedido/lista")
    public Respuesta lista(){
        Respuesta respuesta = new Respuesta();
        try {
            List lista = manager.listado();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (ExcepcionManager e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }
}
