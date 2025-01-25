/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Time;

// line 2 "model.ump"
// line 176 "model.ump"
public class IFEM
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IFEM Associations
  private List<User> users;
  private List<HospitalStay> hospitalStaies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IFEM()
  {
    users = new ArrayList<User>();
    hospitalStaies = new ArrayList<HospitalStay>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }
  /* Code from template association_GetMany */
  public HospitalStay getHospitalStay(int index)
  {
    HospitalStay aHospitalStay = hospitalStaies.get(index);
    return aHospitalStay;
  }

  public List<HospitalStay> getHospitalStaies()
  {
    List<HospitalStay> newHospitalStaies = Collections.unmodifiableList(hospitalStaies);
    return newHospitalStaies;
  }

  public int numberOfHospitalStaies()
  {
    int number = hospitalStaies.size();
    return number;
  }

  public boolean hasHospitalStaies()
  {
    boolean has = hospitalStaies.size() > 0;
    return has;
  }

  public int indexOfHospitalStay(HospitalStay aHospitalStay)
  {
    int index = hospitalStaies.indexOf(aHospitalStay);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */


  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    IFEM existingIFEM = aUser.getIFEM();
    boolean isNewIFEM = existingIFEM != null && !this.equals(existingIFEM);
    if (isNewIFEM)
    {
      aUser.setIFEM(this);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a iFEM
    if (!this.equals(aUser.getIFEM()))
    {
      users.remove(aUser);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHospitalStaies()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public HospitalStay addHospitalStay(Time aArrivalTime, AssessmentDoc aAssessmentDoc)
  {
    return new HospitalStay(aArrivalTime, this, aAssessmentDoc);
  }

  public boolean addHospitalStay(HospitalStay aHospitalStay)
  {
    boolean wasAdded = false;
    if (hospitalStaies.contains(aHospitalStay)) { return false; }
    IFEM existingIFEM = aHospitalStay.getIFEM();
    boolean isNewIFEM = existingIFEM != null && !this.equals(existingIFEM);
    if (isNewIFEM)
    {
      aHospitalStay.setIFEM(this);
    }
    else
    {
      hospitalStaies.add(aHospitalStay);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeHospitalStay(HospitalStay aHospitalStay)
  {
    boolean wasRemoved = false;
    //Unable to remove aHospitalStay, as it must always have a iFEM
    if (!this.equals(aHospitalStay.getIFEM()))
    {
      hospitalStaies.remove(aHospitalStay);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addHospitalStayAt(HospitalStay aHospitalStay, int index)
  {  
    boolean wasAdded = false;
    if(addHospitalStay(aHospitalStay))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHospitalStaies()) { index = numberOfHospitalStaies() - 1; }
      hospitalStaies.remove(aHospitalStay);
      hospitalStaies.add(index, aHospitalStay);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHospitalStayAt(HospitalStay aHospitalStay, int index)
  {
    boolean wasAdded = false;
    if(hospitalStaies.contains(aHospitalStay))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHospitalStaies()) { index = numberOfHospitalStaies() - 1; }
      hospitalStaies.remove(aHospitalStay);
      hospitalStaies.add(index, aHospitalStay);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHospitalStayAt(aHospitalStay, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (users.size() > 0)
    {
      User aUser = users.get(users.size() - 1);
      aUser.delete();
      users.remove(aUser);
    }
    
    while (hospitalStaies.size() > 0)
    {
      HospitalStay aHospitalStay = hospitalStaies.get(hospitalStaies.size() - 1);
      aHospitalStay.delete();
      hospitalStaies.remove(aHospitalStay);
    }
    
  }

}