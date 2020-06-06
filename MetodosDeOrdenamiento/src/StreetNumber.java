/*Vivimos en una cuadra, dode cada casa esta enumerada del 1 al 8, nuestra casa es la numero 6, un dia nos damos cuenta que la suma
 *  de las numeraciones de las casas del lado izquierdo es igual a la suma de las numeraciones de las casas del lado derecho. 
 *  Queremos desarrollar un software que nos permita saber dado un numero N de csas, si lo hubiera, la posicion que cumpla esta 
 *  situacion.
 */


public class StreetNumber {

	private static long gauss(long n) {
		return n * (n + 1) /2;
	}

	public static long iterativoCuadratico(long n) {
		if (n < 3)
			return -1;
		for (long i = 2; i < n; i++) {
			long sumaIzq = 0;
			for (long j = 1; j < i; j++)
				sumaIzq += j;
			long sumaDer = 0;
			for (long k = i + 1; k <= n; k++)
				sumaDer += k;
			if (sumaDer == sumaIzq)
				return i;
		}
		return -1;
	}

	public static long iterativoLinealConGauss(long n) {
		if (n < 3)
			return -1;
		long sumaIzq, sumaDer;
		for (int i = 2; i < n; i++) {
			sumaIzq = gauss(i - 1);
			sumaDer = gauss(n) - gauss(i);
			if (sumaDer==sumaIzq)
				return i;
		}
		return -1;
	}

	public static long iterativoLineal(long n) {
		if (n < 3)
			return -1;
		for (long i = 2; i < n; i++) {
			long sumaIzq = (i - 1) * i / 2;
			long sumaDer = (n * (n + 1) - i * (i + 1)) / 2;
			if (sumaDer == sumaIzq)
				return i;
		}
		return -1;
	}

	public static long matematicoConstante(long n){
		if(n<3) return -1;

		double i= Math.sqrt((Math.pow(n, 2)+n)/2);
		long entera=(long)i;
		if((i-entera) == 0) return (long) i;
		return -1;
	}

	public static void main(String[] args) {

		//long n= 288;
		//long n= 1681;
		//long n= 9800;
		//long n= 57121;
		//long n= 332928;
		//long n= 1940449;
		//long n= 11309768;
		long n= 65918161;
		
		long tIni = System.currentTimeMillis();
		System.out.print(matematicoConstante(n));
		long tFin = System.currentTimeMillis();
		long diff = tFin - tIni;
		System.out.println("  Tiempo de ejecucion del matematicoConstante  "+diff);
		System.out.println("-----------------------------------------");
		tIni = System.currentTimeMillis();
		System.out.print(iterativoLinealConGauss(n));
		tFin = System.currentTimeMillis();
		diff = tFin - tIni;
		System.out.println("  Tiempo de ejecucion del iterativoLinealConGauss  "+diff);
		System.out.println("-----------------------------------------");
                tIni = System.currentTimeMillis();
		System.out.print(iterativoLineal(n));
		tFin = System.currentTimeMillis();
		diff = tFin - tIni;
		System.out.println("  Tiempo de ejecucion del iterativoLineal  "+diff);
		System.out.println("-----------------------------------------");
		tIni = System.currentTimeMillis();
		//System.out.print(iterativoCuadratico(n));
		tFin = System.currentTimeMillis();
		diff = tFin - tIni;
		System.out.println("  Tiempo de ejecucion del iterativoCuadratico  "+diff);
		System.out.println("-----------------------------------------");

	}	
}
