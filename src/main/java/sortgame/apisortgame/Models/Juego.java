package sortgame.apisortgame.Models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Juego {

    private List<PilaColores> listaPilaColores;

    private Integer topePilas ;

    private Boolean terminado ;

    private Integer totalMovimientos;

    public Juego(){
        this.topePilas = 4 ;
        this.inicializarAtributos();
    }

    public Juego(Integer topePilas){
        this.topePilas = topePilas ;
        inicializarAtributos();
    }

    private void inicializarAtributos(){
        this.terminado = false ;
        this.totalMovimientos = 0 ;
        this.listaPilaColores = new ArrayList<>();
    }

}
