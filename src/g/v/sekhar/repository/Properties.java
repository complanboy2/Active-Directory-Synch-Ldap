/**
 * 
 */
package g.v.sekhar.repository;

/**
 * @author G.V.Sekhar
 * 
 * @version $Revision: 1.0 $
 */
public class Properties
{
	// Add the required user attributes toretrieve
	// User MailIid
	/**
	 * Field USER_ATTRIBUTES_MAIL. (value is ""mail"") Value: {@value
	 * USER_ATTRIBUTES_MAIL}
	 */
	public static final String USER_ATTRIBUTES_MAIL = "mail";
	// User Group : A user may be assigned to multiple groups
	/**
	 * Field USER_ATTRIBUTES_MEMBEROF. (value is ""memberOf"") Value: {@value
	 * USER_ATTRIBUTES_MEMBEROF}
	 */
	public static final String USER_ATTRIBUTES_MEMBEROF = "memberOf";
	// User Account Control: User status whether he is active or disabled
	/**
	 * Field USER_ATTRIBUTES_USERACCOUNTCONTROL. (value is
	 * ""userAccountControl"") Value: {@value
	 * USER_ATTRIBUTES_USERACCOUNTCONTROL}
	 */
	public static final String USER_ATTRIBUTES_USERACCOUNTCONTROL = "userAccountControl";
	// distinguishedName: Unique name of the user, user id
	/**
	 * Field USER_ATTRIBUTES_DISTINGUISHED_NAME. (value is
	 * ""distinguishedName"") Value: {@value USER_ATTRIBUTES_DISTINGUISHED_NAME}
	 */
	public static final String USER_ATTRIBUTES_DISTINGUISHED_NAME = "distinguishedName";
	// givenname: Given name of the user, this may not be unique among users.
	/**
	 * Field USER_ATTRIBUTES_GIVEN_NAME. (value is ""givenname"") Value:
	 * {@value USER_ATTRIBUTES_GIVEN_NAME}
	 */
	public static final String USER_ATTRIBUTES_GIVEN_NAME = "givenname";
	// telephonenumber: Given phone number of the user
	/**
	 * Field USER_ATTRIBUTES_TELEPHONE_NUMBER. (value is ""telephonenumber"")
	 * Value: {@value USER_ATTRIBUTES_TELEPHONE_NUMBER}
	 */
	public static final String USER_ATTRIBUTES_TELEPHONE_NUMBER = "telephonenumber";

	// Defining all the search filters to apply
	/**
	 * Field FILTER_OBJECT_CLASS. (value is ""User"") Value: {@value
	 * FILTER_OBJECT_CLASS}
	 */
	public static final String FILTER_OBJECT_CLASS = "User";
	/**
	 * Field FILTER_OBJECT_CATEGORY. (value is ""Person"") Value: {@value
	 * FILTER_OBJECT_CATEGORY}
	 */
	public static final String FILTER_OBJECT_CATEGORY = "Person";

}