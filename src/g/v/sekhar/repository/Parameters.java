/**
 * 
 */
package g.v.sekhar.repository;

import org.apache.log4j.Logger;

/**
 * @author G.V.Sekhar
 * @version $Revision: 1.0 $
 * 
 * Defines all the connection parameters for Active Directory. You can
 * add extra parameters, if any required.
 * 
 */
public class Parameters
{
	
	private static final Logger LOGGER = Logger.getLogger(Parameters.class);
	
	/**
	 * Field serverIp.
	 */
	private String serverIp;
	/**
	 * Field portNumber.
	 */
	private String portNumber;
	/**
	 * Field userName.
	 */
	private String userName;
	/**
	 * Field password.
	 */
	private String password;
	/**
	 * Field domainName.
	 */
	private String domainName;
	/**
	 * Field SSLOn.
	 */
	private String SSLOn;
	/**
	 * Field searchQueries.
	 */
	private String[] searchQueries;
	/**
	 * Field retrieveAttributes.
	 */
	private String[] retrieveAttributes;

	/**
	 * Method getServerIp.
	 * 
	 * @return String
	 */
	public final String getServerIp()
	{
		return serverIp;
	}

	/**
	 * Method setServerIp.
	 * 
	 * @param serverIp
	 *            String
	 */
	public final void setServerIp(String serverIp)
	{
		LOGGER.debug("server IP::" + serverIp);
		this.serverIp = serverIp;
	}

	/**
	 * Method getPortNumber.
	 * 
	 * @return String
	 */
	public final String getPortNumber()
	{
		return portNumber;
	}

	/**
	 * Method setPortNumber.
	 * 
	 * @param portNumber
	 *            String
	 */
	public final void setPortNumber(String portNumber)
	{
		LOGGER.debug("portNumber::" + portNumber);
		this.portNumber = portNumber;
	}

	/**
	 * Method getUserName.
	 * 
	 * @return String
	 */
	public final String getUserName()
	{
		return userName;
	}

	/**
	 * Method setUserName.
	 * 
	 * @param userName String
	 */
	public final void setUserName(String userName)
	{
		LOGGER.debug("userName::" + userName);
		this.userName = userName;
	}

	/**
	 * Method getPassword.
	 * 
	 * @return String
	 */
	public final String getPassword()
	{
		return password;
	}

	/**
	 * Method setPassword.
	 * 
	 * @param password String
	 */
	public final void setPassword(String password)
	{
		LOGGER.debug("password::" + password);
		this.password = password;
	}

	/**
	 * Method getDomainName.
	 * 
	 * @return String
	 */
	public final String getDomainName()
	{
		return domainName;
	}

	/**
	 * Method setDomainName.
	 * 
	 * @param domainName String
	 */
	public final void setDomainName(String domainName)
	{
		LOGGER.debug("domainName::" + domainName);
		this.domainName = domainName;
	}

	/**
	 * Method getSSLOn.
	 * 
	 * @return String
	 */
	public final String getSSLOn()
	{
		return SSLOn;
	}

	/**
	 * Method setSSLOn.
	 * 
	 * @param sSLOn String
	 */
	public final void setSSLOn(String sSLOn)
	{
		LOGGER.debug("sSLOn::" + sSLOn);
		this.SSLOn = sSLOn;
	}

	/**
	 * Method getSearchQueries.
	 * 
	 * @return String[]
	 */
	public final String[] getSearchQueries()
	{
		return searchQueries;
	}

	/**
	 * Method setSearchQueries.
	 * 
	 * @param searchQueries String[]
	 */
	public final void setSearchQueries(String[] searchQueries)
	{
		LOGGER.debug("searchQueries::" + searchQueries);
		this.searchQueries = searchQueries;
	}

	/**
	 * Method getRetrieveAttributes.
	 * 
	 * @return String[]
	 */
	public String[] getRetrieveAttributes()
	{
		return retrieveAttributes;
	}

	/**
	 * Method setRetrieveAttributes.
	 * 
	 * @param retrieveAttributes String[]
	 */
	public void setRetrieveAttributes(String[] retrieveAttributes)
	{
		LOGGER.debug("retrieveAttributes::" + retrieveAttributes);
		this.retrieveAttributes = retrieveAttributes;
	}
}