/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 113 "model.ump"
// line 210 "model.ump"
public class Child
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Child Attributes
  private String id;

  //Child Associations
  private List<Patient> patients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Child(String aId, Patient... allPatients)
  {
    id = aId;
    patients = new ArrayList<Patient>();
    boolean didAddPatients = setPatients(allPatients);
    if (!didAddPatients)
    {
      throw new RuntimeException("Unable to create Child, must have at least 1 patients. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }
  /* Code from template association_GetMany */
  public Patient getPatient(int index)
  {
    Patient aPatient = patients.get(index);
    return aPatient;
  }

  public List<Patient> getPatients()
  {
    List<Patient> newPatients = Collections.unmodifiableList(patients);
    return newPatients;
  }

  public int numberOfPatients()
  {
    int number = patients.size();
    return number;
  }

  public boolean hasPatients()
  {
    boolean has = patients.size() > 0;
    return has;
  }

  public int indexOfPatient(Patient aPatient)
  {
    int index = patients.indexOf(aPatient);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfPatientsValid()
  {
    boolean isValid = numberOfPatients() >= minimumNumberOfPatients();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatients()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPatient(Patient aPatient)
  {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) { return false; }
    patients.add(aPatient);
    if (aPatient.indexOfChild(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPatient.addChild(this);
      if (!wasAdded)
      {
        patients.remove(aPatient);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removePatient(Patient aPatient)
  {
    boolean wasRemoved = false;
    if (!patients.contains(aPatient))
    {
      return wasRemoved;
    }

    if (numberOfPatients() <= minimumNumberOfPatients())
    {
      return wasRemoved;
    }

    int oldIndex = patients.indexOf(aPatient);
    patients.remove(oldIndex);
    if (aPatient.indexOfChild(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPatient.removeChild(this);
      if (!wasRemoved)
      {
        patients.add(oldIndex,aPatient);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setPatients(Patient... newPatients)
  {
    boolean wasSet = false;
    ArrayList<Patient> verifiedPatients = new ArrayList<Patient>();
    for (Patient aPatient : newPatients)
    {
      if (verifiedPatients.contains(aPatient))
      {
        continue;
      }
      verifiedPatients.add(aPatient);
    }

    if (verifiedPatients.size() != newPatients.length || verifiedPatients.size() < minimumNumberOfPatients())
    {
      return wasSet;
    }

    ArrayList<Patient> oldPatients = new ArrayList<Patient>(patients);
    patients.clear();
    for (Patient aNewPatient : verifiedPatients)
    {
      patients.add(aNewPatient);
      if (oldPatients.contains(aNewPatient))
      {
        oldPatients.remove(aNewPatient);
      }
      else
      {
        aNewPatient.addChild(this);
      }
    }

    for (Patient anOldPatient : oldPatients)
    {
      anOldPatient.removeChild(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPatientAt(Patient aPatient, int index)
  {  
    boolean wasAdded = false;
    if(addPatient(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientAt(Patient aPatient, int index)
  {
    boolean wasAdded = false;
    if(patients.contains(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientAt(aPatient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Patient> copyOfPatients = new ArrayList<Patient>(patients);
    patients.clear();
    for(Patient aPatient : copyOfPatients)
    {
      aPatient.removeChild(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]";
  }
}