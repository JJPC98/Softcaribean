package entrega.data.data.controler;

import entrega.data.data.dto.Repartidor;
import entrega.data.data.dto.Respuesta;
import entrega.data.data.excepciones.ExcepcionManager;
import entrega.data.data.mgr.ImgrRepartidor;
import entrega.data.data.mgr.MgrRepartidor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/demo")
public class ControlerRepartidor {

    ImgrRepartidor manager = new MgrRepartidor();

    @PostMapping(path = "repartidor/save")
    public @ResponseBody void save (@RequestBody Repartidor repartidor) {
        try {
            manager.Save(repartidor);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "repartidor/delate")
    public @ResponseBody void delate (@RequestBody Repartidor repartidor){

        try {
            manager.Delete(repartidor);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/repartidor/lista")
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

