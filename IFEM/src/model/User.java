/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 60 "model.ump"
// line 135 "model.ump"
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
  private Person person;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aEmail, String aPassword, IFEM aIFEM, Person aPerson)
  {
    email = aEmail;
    password = aPassword;
    boolean didAddIFEM = setIFEM(aIFEM);
    if (!didAddIFEM)
    {
      throw new RuntimeException("Unable to create user due to iFEM. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddPerson = setPerson(aPerson);
    if (!didAddPerson)
    {
      throw new RuntimeException("Unable to create user due to person. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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
  /* Code from template association_GetOne */
  public Person getPerson()
  {
    return person;
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
  /* Code from template association_SetOneToMany */
  public boolean setPerson(Person aPerson)
  {
    boolean wasSet = false;
    if (aPerson == null)
    {
      return wasSet;
    }

    Person existingPerson = person;
    person = aPerson;
    if (existingPerson != null && !existingPerson.equals(aPerson))
    {
      existingPerson.removeUser(this);
    }
    person.addUser(this);
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
    Person placeholderPerson = person;
    this.person = null;
    if(placeholderPerson != null)
    {
      placeholderPerson.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "email" + ":" + getEmail()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iFEM = "+(getIFEM()!=null?Integer.toHexString(System.identityHashCode(getIFEM())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "person = "+(getPerson()!=null?Integer.toHexString(System.identityHashCode(getPerson())):"null");
  }
}