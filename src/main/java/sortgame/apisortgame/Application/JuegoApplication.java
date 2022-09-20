package sortgame.apisortgame.Application;


import sortgame.apisortgame.Models.Juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class JuegoApplication {

    @Autowired
    private ColorApplication colorApplication ;

    @Autowired
    private PilaColoresApplication pilaColoresApplication ;

    private Juego juego ;

    public JuegoApplication(){

        this.juego = new Juego();
    }

    public Juego getJuego(){
        return this.juego ;
    }


    public Juego InicializarJuego(Integer tamañoPila, Integer totalPilas){
        this.juego = new Juego(tamañoPila);
        this.juego.setListaPilaColores(this.pilaColoresApplication.crearListaPilaColores(tamañoPila, totalPilas));
        return this.juego ;

    }

    public Juego moverColorDePilaAPila(Integer posicionOrigen, Integer posicionDestino){
        return this.juego ;
    }





}
