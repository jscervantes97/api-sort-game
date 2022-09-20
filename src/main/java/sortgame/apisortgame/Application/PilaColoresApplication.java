package sortgame.apisortgame.Application;

import sortgame.apisortgame.Models.Color;
import sortgame.apisortgame.Models.PilaColores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Component
public class PilaColoresApplication {

    @Autowired private ColorApplication colorApplication ;

    public PilaColores crearPilaColor(Integer tamañoPila){
        PilaColores pila = new PilaColores(tamañoPila);
        Stack<Color> colores = new Stack<>();
        for(int iterator = 0 ; iterator < tamañoPila ; iterator++){
            colores.push(this.colorApplication.obtenerColorRandom());
        }
        pila.setPilaColores(colores);
        pila.setLimitePila(tamañoPila);
        pila.setEstaLLeno(true);
        return pila ;
    }

    public PilaColores crearPilaVacia(Integer tamañoPila){
        PilaColores pila = new PilaColores(tamañoPila);
        pila.setLimitePila(tamañoPila);
        pila.setEstaLLeno(false);
        return pila ;
    }

    public List<PilaColores> crearListaPilaColores(Integer tamañoPila , Integer totalPilas){
        List<PilaColores> listaPilaColores = new ArrayList<>();
        for(int iterator = 0 ; iterator < totalPilas-2 ; iterator++){
            listaPilaColores.add(this.crearPilaColor(tamañoPila));
        }
        listaPilaColores.add(this.crearPilaVacia(tamañoPila));
        listaPilaColores.add(this.crearPilaVacia(tamañoPila));
        return listaPilaColores ;
    }

}
