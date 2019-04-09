/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;

// line 50 "model.ump"
// line 87 "model.ump"
public class Kategori
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Kategori Attributes
  private int kategoriid;
  private String kategorinavn;

  //Kategori Associations
  private List<Studie> studies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Kategori(int aKategoriid, String aKategorinavn)
  {
    kategoriid = aKategoriid;
    kategorinavn = aKategorinavn;
    studies = new ArrayList<Studie>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setKategoriid(int aKategoriid)
  {
    boolean wasSet = false;
    kategoriid = aKategoriid;
    wasSet = true;
    return wasSet;
  }

  public boolean setKategorinavn(String aKategorinavn)
  {
    boolean wasSet = false;
    kategorinavn = aKategorinavn;
    wasSet = true;
    return wasSet;
  }

  public int getKategoriid()
  {
    return kategoriid;
  }

  public String getKategorinavn()
  {
    return kategorinavn;
  }
  /* Code from template association_GetMany */
  public Studie getStudy(int index)
  {
    Studie aStudy = studies.get(index);
    return aStudy;
  }

  public List<Studie> getStudies()
  {
    List<Studie> newStudies = Collections.unmodifiableList(studies);
    return newStudies;
  }

  public int numberOfStudies()
  {
    int number = studies.size();
    return number;
  }

  public boolean hasStudies()
  {
    boolean has = studies.size() > 0;
    return has;
  }

  public int indexOfStudy(Studie aStudy)
  {
    int index = studies.indexOf(aStudy);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStudies()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Studie addStudy(int aStudieid, String aStudienavn, String aStudiebeskrivelse)
  {
    return new Studie(aStudieid, aStudienavn, aStudiebeskrivelse, this);
  }

  public boolean addStudy(Studie aStudy)
  {
    boolean wasAdded = false;
    if (studies.contains(aStudy)) { return false; }
    Kategori existingKategori = aStudy.getKategori();
    boolean isNewKategori = existingKategori != null && !this.equals(existingKategori);
    if (isNewKategori)
    {
      aStudy.setKategori(this);
    }
    else
    {
      studies.add(aStudy);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudy(Studie aStudy)
  {
    boolean wasRemoved = false;
    //Unable to remove aStudy, as it must always have a kategori
    if (!this.equals(aStudy.getKategori()))
    {
      studies.remove(aStudy);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStudyAt(Studie aStudy, int index)
  {  
    boolean wasAdded = false;
    if(addStudy(aStudy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudies()) { index = numberOfStudies() - 1; }
      studies.remove(aStudy);
      studies.add(index, aStudy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStudyAt(Studie aStudy, int index)
  {
    boolean wasAdded = false;
    if(studies.contains(aStudy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudies()) { index = numberOfStudies() - 1; }
      studies.remove(aStudy);
      studies.add(index, aStudy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStudyAt(aStudy, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=studies.size(); i > 0; i--)
    {
      Studie aStudy = studies.get(i - 1);
      aStudy.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "kategoriid" + ":" + getKategoriid()+ "," +
            "kategorinavn" + ":" + getKategorinavn()+ "]";
  }
}