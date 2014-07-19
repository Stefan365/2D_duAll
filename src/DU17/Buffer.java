package DU17;

/**
 * Rozhran� pro sd�lenou pam� (buffer) v probl�mu
 * producent-konzument.
 */
public interface Buffer {

	/**
	 * Ulo�� hodnotu value do sd�len� pam�ti.
	 * 
	 * @param value
	 *            hodnota ukl�dan� ze sd�len� pam�ti.
	 */
	public void set(int value);

	/**
	 * Na�te hodnotu ze sd�len� pam�ti.
	 * 
	 * @return hodnota na�ten� ze sd�len� pam�ti.
	 */
	public int get();
}
