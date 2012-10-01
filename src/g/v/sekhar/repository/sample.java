package g.v.sekhar.repository;

import java.util.List;
import org.apache.log4j.Logger;

import javax.naming.CommunicationException;
import javax.naming.NamingException;
import javax.net.ssl.SSLHandshakeException;

/**
 * Sample calling for Active Directory Synch
 * 
 * @author G.V.Sekhar
 * @version $Revision: 1.0 $
 */
public class sample
{

	private static final Logger LOGGER = Logger.getLogger(sample.class);

	/**
	 * Method main.
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args)
	{
		Parameters p = new Parameters();
		p.setDomainName("watchmouse.com");
		p.setPassword("password");
		p.setPortNumber("389");

		String[] at = { "sAMACCOUNTNAME", "mail", "userAccountControl" };
		p.setRetrieveAttributes(at);
		
		String[] sq = { "DC=watchmouse,DC=com" };
		p.setSearchQueries(sq);
		
		p.setServerIp("192.168.0.71");
		p.setSSLOn("false");
		p.setUserName("Administrator");

		AdSynch ad = new AdSynch(p);
		try
		{
			List<User> e = ad.processRequest();
			for (User user : e)
			{
				String[] s = user.getAttributeValues();
				for (String string : s)
				{
					System.out.print(string + "::");
				}
				System.out.println();

			}
		} catch (SSLHandshakeException e)
		{
			LOGGER.error(e.getMessage(), e);
		} catch (CommunicationException e)
		{
			LOGGER.error(e.getMessage(), e);
		} catch (NamingException e)
		{
			LOGGER.error(e.getMessage(), e);
		} catch (NullPointerException e)
		{
			LOGGER.error(e.getMessage(), e);
		} catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}
}