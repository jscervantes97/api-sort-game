package sortgame.apisortgame.Application;


import sortgame.apisortgame.Models.Color;
import sortgame.apisortgame.Models.DTO.JuegoResultDTO;
import sortgame.apisortgame.Models.Juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sortgame.apisortgame.Models.PilaColores;

import java.util.ArrayList;
import java.util.List;


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


    public JuegoResultDTO InicializarJuego(Integer tamañoPila, Integer totalPilas){
        this.juego = new Juego(tamañoPila);
        this.juego.setListaPilaColores(this.pilaColoresApplication.crearListaPilaColores(tamañoPila, totalPilas));
        return new JuegoResultDTO(JuegoResultDTO.JUEGO_CREADO, this.juego);
    }

    public JuegoResultDTO moverColorDePilaAPila(Integer posicionOrigen, Integer posicionDestino){
        List<PilaColores> listaPilaColores = this.juego.getListaPilaColores();
        PilaColores pilaOrigen = listaPilaColores.get(posicionOrigen);
        PilaColores pilaDestino = listaPilaColores.get(posicionDestino);
        JuegoResultDTO resultDTO = new JuegoResultDTO();

        if(pilaOrigen.getPilaColores().isEmpty()){
            resultDTO.setResultado(JuegoResultDTO.PILA_ORIGEN_VACIA);
        }else if(pilaDestino.getEstaLLeno()){
            resultDTO.setResultado(JuegoResultDTO.PILA_DESTINO_LLENA);
        }else if(pilaDestino.getPilaColores().isEmpty()){
            Color colorAMover = pilaOrigen.sacarColorDeLaPila();
            pilaDestino.agregarColorAPila(colorAMover);
            listaPilaColores.set(posicionOrigen, pilaOrigen);
            listaPilaColores.set(posicionDestino, pilaDestino);
            resultDTO.setResultado("Se movio un color de " + colorAMover.getCodigoColor());
            this.juego.setListaPilaColores(listaPilaColores);
            this.juego.incrementarMovimientos();
        }
        else if(pilaOrigen.obtenerUltimoColorEnPila().getClaveColor() != pilaDestino.obtenerUltimoColorEnPila().getClaveColor()){
            resultDTO.setResultado(JuegoResultDTO.PILA_DESTINO_LLENA);
        }
        else {
            Color colorAMover = pilaOrigen.sacarColorDeLaPila();
            pilaDestino.agregarColorAPila(colorAMover);
            listaPilaColores.set(posicionOrigen, pilaOrigen);
            listaPilaColores.set(posicionDestino, pilaDestino);
            resultDTO.setResultado("Se movio un color de " + colorAMover.getCodigoColor());
            this.juego.setListaPilaColores(listaPilaColores);
            this.juego.incrementarMovimientos();
        }
        resultDTO.setJuego(this.juego);
        return resultDTO;
    }





}
