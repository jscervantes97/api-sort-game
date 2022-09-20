package sortgame.apisortgame.Controllers;


import org.springframework.web.bind.annotation.*;
import sortgame.apisortgame.Application.JuegoApplication;
import sortgame.apisortgame.Models.DTO.JuegoResultDTO;
import sortgame.apisortgame.Models.DTO.MovimientoDTO;
import sortgame.apisortgame.Models.Juego;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping()
public class JuegoController {

    @Autowired
    private JuegoApplication juegoApplication ;

    @PostMapping("/iniciar-juego")
    public JuegoResultDTO iniciarJuego(){
        return this.juegoApplication.InicializarJuego(4 , 4);
    }

    @GetMapping("/consultar-juego")
    public Juego consultarJuego(){
        return this.juegoApplication.getJuego();
    }

    @PostMapping("/mover")
    public JuegoResultDTO moverColorDePilaAPila(@RequestBody MovimientoDTO movimientos){
        return this.juegoApplication.moverColorDePilaAPila(movimientos.getPosicionOrigen() , movimientos.getPosicionDestino());
    }


}
