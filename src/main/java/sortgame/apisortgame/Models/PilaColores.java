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

    public Color obtenerUltimoColorEnPila(){
        return this.pilaColores.isEmpty() ? null : this.pilaColores.peek();
    }

    public Color sacarColorDeLaPila(){
        //return this.pilaColores.isEmpty() ? null : this.pilaColores.pop();
        Color colorSacar = null ;
        if(!this.pilaColores.isEmpty()){
            colorSacar = this.pilaColores.pop();
            this.estaLLeno = false ;
        }
        return colorSacar ;
    }


    public void agregarColorAPila(Color color){
        this.pilaColores.push(color);
        if(this.pilaColores.size() == this.limitePila){
            this.estaLLeno = true ;
        }
    }

}
