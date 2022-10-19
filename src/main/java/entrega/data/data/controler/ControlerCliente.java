package entrega.data.data.controler;

import entrega.data.data.dto.Cliente;
import entrega.data.data.dto.Respuesta;
import entrega.data.data.excepciones.ExcepcionManager;
import entrega.data.data.mgr.ImgrCliente;
import entrega.data.data.mgr.MgrCliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/demo")
@CrossOrigin("*")
public class ControlerCliente {

    ImgrCliente manager = new MgrCliente();

    @PostMapping(path = "cliente/save")
    public @ResponseBody void Save (@RequestBody Cliente cliente){
        try {
            manager.Save(cliente);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "cliente/delate")
    public @ResponseBody void Delate (@RequestBody Cliente cliente){
        try {
            manager.Delete(cliente);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }

    }

    @GetMapping(path = "/cliente/lista")
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
