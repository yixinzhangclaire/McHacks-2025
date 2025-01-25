/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 8 "model.ump"
// line 119 "model.ump"
public class Patient extends User
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Patient> patientsById = new HashMap<String, Patient>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Patient Attributes
  private String id;

  //Patient Associations
  private MedicalRecord medicalRecord;
  private List<Child> children;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Patient(String aEmail, String aPassword, IFEM aIFEM, Person aPerson, String aId, MedicalRecord aMedicalRecord)
  {
    super(aEmail, aPassword, aIFEM, aPerson);
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id. See https://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    if (aMedicalRecord == null || aMedicalRecord.getPatient() != null)
    {
      throw new RuntimeException("Unable to create Patient due to aMedicalRecord. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    medicalRecord = aMedicalRecord;
    children = new ArrayList<Child>();
  }

  public Patient(String aEmail, String aPassword, IFEM aIFEM, Person aPerson, String aId)
  {
    super(aEmail, aPassword, aIFEM, aPerson);
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id. See https://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    medicalRecord = new MedicalRecord(this);
    children = new ArrayList<Child>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    String anOldId = getId();
    if (anOldId != null && anOldId.equals(aId)) {
      return true;
    }
    if (hasWithId(aId)) {
      return wasSet;
    }
    id = aId;
    wasSet = true;
    if (anOldId != null) {
      patientsById.remove(anOldId);
    }
    patientsById.put(aId, this);
    return wasSet;
  }

  public String getId()
  {
    return id;
  }
  /* Code from template attribute_GetUnique */
  public static Patient getWithId(String aId)
  {
    return patientsById.get(aId);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithId(String aId)
  {
    return getWithId(aId) != null;
  }
  /* Code from template association_GetOne */
  public MedicalRecord getMedicalRecord()
  {
    return medicalRecord;
  }
  /* Code from template association_GetMany */
  public Child getChild(int index)
  {
    Child aChild = children.get(index);
    return aChild;
  }

  public List<Child> getChildren()
  {
    List<Child> newChildren = Collections.unmodifiableList(children);
    return newChildren;
  }

  public int numberOfChildren()
  {
    int number = children.size();
    return number;
  }

  public boolean hasChildren()
  {
    boolean has = children.size() > 0;
    return has;
  }

  public int indexOfChild(Child aChild)
  {
    int index = children.indexOf(aChild);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfChildren()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addChild(Child aChild)
  {
    boolean wasAdded = false;
    if (children.contains(aChild)) { return false; }
    children.add(aChild);
    if (aChild.indexOfPatient(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aChild.addPatient(this);
      if (!wasAdded)
      {
        children.remove(aChild);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeChild(Child aChild)
  {
    boolean wasRemoved = false;
    if (!children.contains(aChild))
    {
      return wasRemoved;
    }

    int oldIndex = children.indexOf(aChild);
    children.remove(oldIndex);
    if (aChild.indexOfPatient(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aChild.removePatient(this);
      if (!wasRemoved)
      {
        children.add(oldIndex,aChild);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addChildAt(Child aChild, int index)
  {  
    boolean wasAdded = false;
    if(addChild(aChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChildren()) { index = numberOfChildren() - 1; }
      children.remove(aChild);
      children.add(index, aChild);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveChildAt(Child aChild, int index)
  {
    boolean wasAdded = false;
    if(children.contains(aChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChildren()) { index = numberOfChildren() - 1; }
      children.remove(aChild);
      children.add(index, aChild);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addChildAt(aChild, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    patientsById.remove(getId());
    MedicalRecord existingMedicalRecord = medicalRecord;
    medicalRecord = null;
    if (existingMedicalRecord != null)
    {
      existingMedicalRecord.delete();
    }
    ArrayList<Child> copyOfChildren = new ArrayList<Child>(children);
    children.clear();
    for(Child aChild : copyOfChildren)
    {
      if (aChild.numberOfPatients() <= Child.minimumNumberOfPatients())
      {
        aChild.delete();
      }
      else
      {
        aChild.removePatient(this);
      }
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "medicalRecord = "+(getMedicalRecord()!=null?Integer.toHexString(System.identityHashCode(getMedicalRecord())):"null");
  }
}