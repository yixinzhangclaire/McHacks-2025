/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 52 "model.ump"
// line 124 "model.ump"
public abstract class Employee extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Attributes
  private int employeeID;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(String aEmail, String aPassword, IFEM aIFEM, int aEmployeeID)
  {
    super(aEmail, aPassword, aIFEM);
    employeeID = aEmployeeID;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEmployeeID(int aEmployeeID)
  {
    boolean wasSet = false;
    employeeID = aEmployeeID;
    wasSet = true;
    return wasSet;
  }

  public int getEmployeeID()
  {
    return employeeID;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "employeeID" + ":" + getEmployeeID()+ "]";
  }
}