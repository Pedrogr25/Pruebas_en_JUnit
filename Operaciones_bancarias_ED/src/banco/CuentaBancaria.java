package banco;

public class CuentaBancaria {

	
	private int saldo;
	private String password;
	
	// Constructor con los dos atributos de la clase. 
	
	public CuentaBancaria(int saldo, String password) {
		super();
		this.saldo = saldo;
		this.password = password;
	}
	
	/*
	 *  Me da una cantidad que queremos ingresar, si esa cantidad es mayor que 0, se depositará en nuestra cuenta,
	 *  si el numero es negativo me da un error -1.
	 */
	
	public int depositar (int cantidad) {
		if (cantidad>0) {
			saldo += cantidad;
			return saldo;
		} else
			return -1;
	}
	
	/*
	 * Si la contraseña es correcta, me permite retirar el dinero, una vez comprobada si la contraseña es correcta,
	 * verifica si el saldo es superior a la cantidad a retirar, SI ES ASÍ, RETIRA EL DINERO, si no, me devuelve un -1.
	 * En el caso de que la contraseña fuese incorrecta, me devuelve un -2.
	 */
	
	public int retirar (int cantidad, String pass) {
		if (passwordCorrecta(pass)) {
			if (saldo >= cantidad) {
				saldo-=cantidad;
				return saldo;
			} else
				return -1;
		
		}else
			return -2;	
	}
	
	/*
	 * Comprueba que la contraseña introducida es correcta.
	 */
	public boolean passwordCorrecta(String pass) {
		return password.equals(pass);
	}
}
