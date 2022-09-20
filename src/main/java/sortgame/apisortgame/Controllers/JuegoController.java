package sortgame.apisortgame.Controllers;


import org.springframework.web.bind.annotation.PostMapping;
import sortgame.apisortgame.Application.JuegoApplication;
import sortgame.apisortgame.Models.Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class JuegoController {

    @Autowired
    private JuegoApplication juegoApplication ;

    @PostMapping("/iniciar-juego")
    public Juego iniciarJuego(){
        return this.juegoApplication.InicializarJuego(4 , 6);
    }

    @GetMapping("/consultar-juego")
    public Juego consultarJuego(){
        return this.juegoApplication.getJuego();
    }


}
