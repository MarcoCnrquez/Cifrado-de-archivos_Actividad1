package Cod_Descod;
//ACTIVIDAD 1
// Se va a crear un programa de cifrado simple. El proceso es muy sencillo. Se divide en dos
//partes. En primer lugar, cada letra mayúscula o minúscula debe desplazarse tres posiciones
//hacia la derecha, de acuerdo con la tabla ASCII: la letra ’a’ debe convertirse en la letra ’d’, la
//letra ’y’ debe convertirse en el carácter ’|’, etc. En segundo lugar, cada línea debe invertirse.
//Después de invertir, todos los caracteres de la mitad en adelante (truncado) deben moverse
//una posición a la izquierda en ASCII. En este caso, ’b’ se convierte en ’a’ y ’a’ se convierte
//en ’‘’.
 public class Codificar {
     //METODO DEL PRIMER PASO
    public static String inicio(String x){
        char temp;
        String cad = "";
        for (int i = 0; i < x.length(); i++) {  //Longitud de la cadena en el ciclo
            temp = x.charAt(i);
            if (temp >= 65 && temp <= 90 | temp >= 97 && temp <= 122) { //122 
                temp = (char) (x.charAt(i)+3);
                cad = cad + temp;
            } else {
                cad = cad + temp;
            }
        }
        return invertir2(cad);
    }
    //METODO INVERTIR2
    public static String invertir2(String x){
        char temporal;
        String cad = "";
        for (int i = 0; i < x.length(); i++) {
            temporal = x.charAt(i);
            cad = temporal + cad;
        }
        
        return restar(cad);
        
    }
    //METODO RESTAR
     public static String restar(String x){
        int mitad = (int)(x.length()/2);
        String guardar = "";
        char temporal;
        guardar = x.substring(0, mitad); //Posicion inicial y a la mitad de la cadena
        x= x.substring(mitad, x.length());
         for (int i = 0; i < x.length(); i++) {
             temporal = x.charAt(i);
            if (temporal >= 65 && temporal <= 90 | temporal >= 97 && temporal <= 122) {
                temporal = (char) (x.charAt(i)-1); //Restamos para pasar a numero entero
                guardar = guardar + temporal;
            } else {
                guardar = guardar + temporal;
            }
         }
         System.out.println(guardar);
        return guardar;
     }
}
