package sortgame.apisortgame.Application;

import sortgame.apisortgame.Models.Color;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ColorApplication {

    public final static Integer CLAVE_COLOR_AZUL = 0 ;

    public final static Integer CLAVE_COLOR_VERDE = 1 ;

    public final static Integer CLAVE_COLOR_ROJO = 2 ;

    public final static Integer CLAVE_COLOR_AMARILLO = 3 ;


    public Color obtenerColorRandom(){
        Color color = new Color();
        Random ran = new Random();
        int nxt = ran.nextInt(4);
        color.setClaveColor(nxt);
        color.setCodigoColor(obtenerCodigoColorHexadecimal(nxt));
        return color ;
    }

    public String obtenerCodigoColorHexadecimal(Integer codigoColor){
        String codigoHexadecimal = "";
        switch (codigoColor){
            case 0 -> codigoHexadecimal = "AZUL";
            case 1 -> codigoHexadecimal = "VERDE" ;
            case 2 -> codigoHexadecimal = "ROJO" ;
            case 3 -> codigoHexadecimal = "AMARILLO" ;
        }
        return codigoHexadecimal;
    }

}
