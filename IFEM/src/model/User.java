/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 56 "model.ump"
// line 129 "model.ump"
public abstract class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String email;
  private String password;

  //User Associations
  private IFEM iFEM;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aEmail, String aPassword, IFEM aIFEM)
  {
    email = aEmail;
    password = aPassword;
    boolean didAddIFEM = setIFEM(aIFEM);
    if (!didAddIFEM)
    {
      throw new RuntimeException("Unable to create user due to iFEM. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPassword()
  {
    return password;
  }
  /* Code from template association_GetOne */
  public IFEM getIFEM()
  {
    return iFEM;
  }
  /* Code from template association_SetOneToMany */
  public boolean setIFEM(IFEM aIFEM)
  {
    boolean wasSet = false;
    if (aIFEM == null)
    {
      return wasSet;
    }

    IFEM existingIFEM = iFEM;
    iFEM = aIFEM;
    if (existingIFEM != null && !existingIFEM.equals(aIFEM))
    {
      existingIFEM.removeUser(this);
    }
    iFEM.addUser(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    IFEM placeholderIFEM = iFEM;
    this.iFEM = null;
    if(placeholderIFEM != null)
    {
      placeholderIFEM.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "email" + ":" + getEmail()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iFEM = "+(getIFEM()!=null?Integer.toHexString(System.identityHashCode(getIFEM())):"null");
  }
}