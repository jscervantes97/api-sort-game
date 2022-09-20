package sortgame.apisortgame.Models;

import lombok.Data;

import java.util.Stack;


@Data
public class PilaColores {

    private Stack<Color> pilaColores ;

    private Boolean estaLLeno ;

    private Integer limitePila ;

    public PilaColores(Integer limitePila) {
        pilaColores = new Stack<>();
        estaLLeno = false ;
        this.limitePila = limitePila ;
    }

}
