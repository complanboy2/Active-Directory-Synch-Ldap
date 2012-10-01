package g.v.sekhar.repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.CommunicationException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.net.ssl.SSLHandshakeException;

import org.apache.log4j.Logger;

/**
 * This provides the basic functionalities to retrieve the objects and their
 * parameters from the Active Directory.
 * 
 * @author G.V.Sekhar
 * @version $Revision: 1.0 $
 * 
 */
public class AdSynch
{

	private static final Logger LOGGER = Logger.getLogger(AdSynch.class);
	
	/**
	 * Field parametersHashTable.
	 */
	Hashtable<String, String> parametersHashTable = new Hashtable<String, String>();
	/**
	 * Field localInitialLdapContext.
	 */
	InitialLdapContext localInitialLdapContext = null;
	/**
	 * Field parameters.
	 */
	Parameters parameters = null;
	/**
	 * Field searchFilter.
	 */
	String searchFilter = null;
	/**
	 * Field searchctls.
	 */
	SearchControls searchctls = null;

	/**
	 * Constructor for AdSynch.
	 * 
	 * @param parameters
	 *            Parameters
	 */
	public AdSynch(Parameters parameters)
	{
		this.parameters = parameters;
	}

	/**
	 * Method processRequest.
	 * 
	 * @return List<User>
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws SSLHandshakeException
	 * @throws CommunicationException
	 * @throws NamingException
	 */
	public final List<User> processRequest() throws ArrayIndexOutOfBoundsException, SSLHandshakeException,
			CommunicationException, NamingException
	{
		setConnectionParameters();
		setSearchParameters();
		return getUsers();
	}

	/**
	 * Method setConnectionParameters.
	 * 
	 * @throws NamingException
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws SSLHandshakeException
	 * @throws CommunicationException
	 */
	private void setConnectionParameters() throws NamingException, ArrayIndexOutOfBoundsException,
			SSLHandshakeException, CommunicationException
	{
		LOGGER.info(">> setConnectionParameters()");
		
		parametersHashTable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
		parametersHashTable.put("java.naming.security.authentication", "simple");
		parametersHashTable.put("com.sun.jndi.ldap.connect.pool", "true");
		parametersHashTable.put("com.sun.jndi.ldap.connect.pool.timeout", "60000");
		parametersHashTable.put("java.naming.referral", "follow");

		StringBuffer tempStringBuffer = new StringBuffer();
		// If SSL is enabled, set the protocol to ldaps else ldap only.
		if ("true".equalsIgnoreCase(parameters.getSSLOn()))
		{
			LOGGER.info("SSL is ON");
			tempStringBuffer.append("ldaps://");
			parametersHashTable.put("java.naming.security.protocol", "ssl");
		} else
		{
			LOGGER.info("SSL is OFF");
			tempStringBuffer.append("ldap://");
		}

		tempStringBuffer.append(parameters.getServerIp()).append(":").append(parameters.getPortNumber()).append("/");

		StringBuilder principalVaule = new StringBuilder(parameters.getUserName()).append("@").append(
				parameters.getDomainName());

		parametersHashTable.put("java.naming.provider.url", tempStringBuffer.toString());
		parametersHashTable.put("java.naming.security.principal", principalVaule.toString());
		parametersHashTable.put("java.naming.security.credentials", parameters.getPassword());

		localInitialLdapContext = new InitialLdapContext(parametersHashTable, null);
		
		LOGGER.info("<< setConnectionParameters()");
	}

	/**
	 * Method setSearchParameters.
	 */
	private void setSearchParameters()
	{
		LOGGER.info(">> setSearchParameters()");
		
		// Search controls and setting up the returning attributes
		searchctls = new SearchControls();
		searchctls.setReturningAttributes(parameters.getRetrieveAttributes());

		// Set the search scope. You can change this as according your
		// structure.
		// Remember this value has effect on performance.
		// Example: setting the scope to Subtree.
		searchctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		// Set the search filter. Change as according by changing the values in
		// properties class.
		searchFilter = new StringBuilder("(&(objectClass=").append(Properties.FILTER_OBJECT_CLASS)
				.append(")(objectCategory=").append(Properties.FILTER_OBJECT_CATEGORY).append("))").toString();
		
		LOGGER.info("<< setSearchParameters");
	}

	/**
	 * If multiple search queries are added, then process each one.
	 * 
	 * Method getUsers.
	 * 
	 * @return List<User>
	 * @throws NamingException
	 */
	private List<User> getUsers() throws NamingException
	{
		LOGGER.info(">> getUsers()");
		
		String[] searchQuiries = parameters.getSearchQueries();

		List<User> users = new ArrayList<User>();
		for (int i = 0; i < searchQuiries.length; i++)
		{
			users.addAll(getAttributes(searchQuiries[i]));
		}
		
		LOGGER.info("<< getUsers()");
		
		return users;
	}

	/**
	 * Retrieve the input attributes from the Active Directory for the given
	 * search query
	 * 
	 * Method getAttributes.
	 * 
	 * @param searchBase
	 *            String
	 * @return List<User>
	 * @throws NamingException
	 */
	private final List<User> getAttributes(String searchBase) throws NamingException
	{
		LOGGER.info(">> getAttributes()");

		NamingEnumeration<SearchResult> results = localInitialLdapContext.search(searchBase, searchFilter, searchctls);

		List<User> users = new ArrayList<User>();
		User user = null;

		while (results.hasMoreElements())
		{
			user = new User();
			SearchResult searchResult = results.next();
			Attributes attrs = searchResult.getAttributes();

			if (attrs != null && attrs.size() != 0)
			{
				Attribute attribute = null;

				String[] retrieveAttributes = parameters.getRetrieveAttributes();
				String[] attributesValues = new String[retrieveAttributes.length];
				for (int i = 0; i < retrieveAttributes.length; i++)
				{
					attribute = attrs.get(retrieveAttributes[i]);
					if (attribute != null && attribute.get() != null)
					{
						if (!isNullOrEmpty(attribute.get().toString()))
						{
							attributesValues[i] = attribute.get().toString();
						}
					}
				}
				user.setAttributeValues(attributesValues);
			}
			users.add(user);
		}
		
		LOGGER.info("<< getAttributes()");
		return users;
	}

	/**
	 * Method isNullOrEmpty.
	 * 
	 * @param message
	 *            String
	 * @return boolean
	 */
	private final static boolean isNullOrEmpty(String message)
	{
		return message == null ? true : message.trim().length() == 0;
	}
}