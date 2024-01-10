package test;
import java.util.Arrays;

public class Test
{
	private static final int	d		= 32;
	private static final int	size	= 6;

	public static void main(String[] args)
	{
		int[] ar = randomArray(size);
		System.out.println("Исходный массив: " + Arrays.toString(ar));
		int dec = decode(ar);
		System.out.println("Закодированный массив: " + dec);
		int[]	enc		= encode(dec, ar.length);
		String	enc_str	= Arrays.toString(enc);
		System.out.println("Раскодированный массив: " + enc_str);
		int proc = 100 / size;
		System.out.println("В двоичном виде закодированный массив занимает " + proc + "% от исходного");
		int proc_str = 100 * (dec + "").length() / (enc_str.length()); // - 2 - size - 1);
		System.out.println("В строковом виде закодированный массив занимает " + proc_str + "% от исходного");
	}

	private static int[] randomArray(int m)
	{
		int[]	arr			= new int[m];
		int		minValue	= 0;
		int		maxValue	= d - 8;
		for (int i = 0; i < m; i++)
			arr[i] = minValue + (int) (Math.random() * (maxValue - minValue + 1));
		return arr;
	}

	/**
	 * Декодирование
	 * 
	 * @param b      закодированный массив
	 * @param length размер исходного массива
	 * @return исходный массив
	 */
	private static int[] encode(int b, int length)
	{
		int[] arr = new int[length];
		for (int i = 0; i < length - 1; i++) {
			arr[length - i - 1] = (int) (b % d);
			b = b / d;
		}
		arr[0] = (int) (b % d);
		return arr;
	}

	/**
	 * Кодирование
	 * 
	 * @param ar исходный массив
	 * @return массив закодированный в int
	 */
	private static int decode(int[] ar)
	{
		int b = ar[0];
		for (int i = 0; i < ar.length - 1; i++)
			b = b * d + ar[i + 1];
		return b;
	}
}