package desafio.webserviceplural;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plural")
public class PluralController {

    @GetMapping("/{palabra}")
    public String convertirAPlural(@PathVariable String palabra){

        int[] cantidadesPorRegla = new int[4];
        // Separar las palabras por comas
        String[] palabrasArray = palabra.split(",");
        String palabrasPluralizadas = "";
        String cantidadReglas = "";
        int index = 0;

        for(String i:palabrasArray){

            palabrasPluralizadas += "palabrasArray[" + index + "]" + " = ";

            if(i.endsWith("a") ||
                    i.endsWith("e") ||
                    i.endsWith("i") ||
                    i.endsWith("o") ||
                    i.endsWith("u") ){

                i = i + "s";


                cantidadesPorRegla[0]++;
            }
            else if(i.endsWith("s") || i.endsWith("x")) {
                cantidadesPorRegla[1]++;
            }
            else if(i.endsWith("z")) {

                i = i.substring(0, i.length() - 1);
                i = i + "ces";
                cantidadesPorRegla[2]++;

            }
            else{
                i = i + "es";
                cantidadesPorRegla[3]++;
            }

            palabrasPluralizadas += i + "<br>";

            index++;
        }

        for(int i=0; i<4; i++){
            cantidadReglas += cantidadesPorRegla[i] + " en " + "cantidadesPorRegla["+i+"]" + "<br>";
        }

        String resultadoTotal = palabrasPluralizadas + cantidadReglas;

        return resultadoTotal;
    }
}



