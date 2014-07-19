package DU17;

/**
 * Rozhraní pro sdílenou pamì (buffer) v problému
 * producent-konzument.
 */
public interface Buffer {

	/**
	 * Uloí hodnotu value do sdílené pamìti.
	 * 
	 * @param value
	 *            hodnota ukládaná ze sdílené pamìti.
	 */
	public void set(int value);

	/**
	 * Naète hodnotu ze sdílené pamìti.
	 * 
	 * @return hodnota naètená ze sdílené pamìti.
	 */
	public int get();
}
