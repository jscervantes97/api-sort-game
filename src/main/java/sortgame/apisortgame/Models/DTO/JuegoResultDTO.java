package sortgame.apisortgame.Models.DTO;

import lombok.Data;
import sortgame.apisortgame.Models.Juego;

@Data
public class JuegoResultDTO {

    public static final String JUEGO_CREADO = "Juego creado" ;

    public static final String JUEGO_TERMINADO = "Juego terminado" ;

    public static final String PILA_ORIGEN_VACIA = "La pila de origen esta vacia" ;

    public static final String PILA_DESTINO_VACIA = "La pila de destino esta vacia" ;

    public static final String PILA_DESTINO_LLENA = "La pila de destino esta llena" ;

    public static final String PILA_DESTINO_COLOR_NO_COINCIDE_ORIGEN = "El color a agregar en la pila no es el mismo que el que esta en el tope" ;

    private String resultado ;

    private Juego juego ;

    public JuegoResultDTO(String resultado, Juego juego) {
        this.resultado = resultado;
        this.juego = juego;
    }

    public JuegoResultDTO() {
    }
}
