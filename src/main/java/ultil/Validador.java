package ultil;

public class Validador {
	
	//metodo criado para verificar  campo do tipo numerico
	 public static <T extends Number> boolean validarNumero(T numero) {
	        try {
	            // Converte o número para String e tenta fazer o parsing
	            String strNumero = String.valueOf(numero);
	            double valor = Double.parseDouble(strNumero);
	            return  valor >= 0;
	        } catch (NumberFormatException | NullPointerException e) {
	            return false;
	            
	        }
	 }

}
