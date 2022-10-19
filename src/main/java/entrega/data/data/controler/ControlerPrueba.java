package entrega.data.data.controler;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/demo")
public class ControlerPrueba {

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {

        return "Saved";

    }

    @GetMapping("/conocimientos/getByid/{id}")
    public String getByid(@PathVariable String id) {
        return id;
    }
}
