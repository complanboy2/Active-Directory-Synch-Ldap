/**
 * 
 */
package g.v.sekhar.repository;

/**
 * This class stores the user objects along with their attributes.
 * 
 * @author G.V.Sekhar
 * @version $Revision: 1.0 $
 */
public class User
{
	/**
	 * Field attributeValues.
	 */
	private String[] attributeValues;

	/**
	 * Method getAttributeValues.
	 * 
	 * @return String[]
	 */
	public final String[] getAttributeValues()
	{
		return attributeValues;
	}

	/**
	 * Method setAttributeValues.
	 * 
	 * @param attributeValues
	 *            String[]
	 */
	public final void setAttributeValues(String[] attributeValues)
	{
		this.attributeValues = attributeValues;
	}
}