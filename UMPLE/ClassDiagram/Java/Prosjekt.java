/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;
import java.sql.Time;

// line 55 "model.ump"
// line 92 "model.ump"
public class Prosjekt
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Prosjekt Attributes
  private int prosjektid;
  private String prosjektnavn;
  private String prosjektbeskrivelse;

  //Prosjekt Associations
  private Arrangement arrangement;
  private List<Stemme> stemmes;
  private Bedrift bedrift;
  private Studie studie;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Prosjekt(int aProsjektid, String aProsjektnavn, String aProsjektbeskrivelse, Arrangement aArrangement, Bedrift aBedrift, Studie aStudie)
  {
    prosjektid = aProsjektid;
    prosjektnavn = aProsjektnavn;
    prosjektbeskrivelse = aProsjektbeskrivelse;
    boolean didAddArrangement = setArrangement(aArrangement);
    if (!didAddArrangement)
    {
      throw new RuntimeException("Unable to create prosjekt due to arrangement");
    }
    stemmes = new ArrayList<Stemme>();
    boolean didAddBedrift = setBedrift(aBedrift);
    if (!didAddBedrift)
    {
      throw new RuntimeException("Unable to create prosjekt due to bedrift");
    }
    boolean didAddStudie = setStudie(aStudie);
    if (!didAddStudie)
    {
      throw new RuntimeException("Unable to create prosjekt due to studie");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setProsjektid(int aProsjektid)
  {
    boolean wasSet = false;
    prosjektid = aProsjektid;
    wasSet = true;
    return wasSet;
  }

  public boolean setProsjektnavn(String aProsjektnavn)
  {
    boolean wasSet = false;
    prosjektnavn = aProsjektnavn;
    wasSet = true;
    return wasSet;
  }

  public boolean setProsjektbeskrivelse(String aProsjektbeskrivelse)
  {
    boolean wasSet = false;
    prosjektbeskrivelse = aProsjektbeskrivelse;
    wasSet = true;
    return wasSet;
  }

  public int getProsjektid()
  {
    return prosjektid;
  }

  public String getProsjektnavn()
  {
    return prosjektnavn;
  }

  public String getProsjektbeskrivelse()
  {
    return prosjektbeskrivelse;
  }
  /* Code from template association_GetOne */
  public Arrangement getArrangement()
  {
    return arrangement;
  }
  /* Code from template association_GetMany */
  public Stemme getStemme(int index)
  {
    Stemme aStemme = stemmes.get(index);
    return aStemme;
  }

  public List<Stemme> getStemmes()
  {
    List<Stemme> newStemmes = Collections.unmodifiableList(stemmes);
    return newStemmes;
  }

  public int numberOfStemmes()
  {
    int number = stemmes.size();
    return number;
  }

  public boolean hasStemmes()
  {
    boolean has = stemmes.size() > 0;
    return has;
  }

  public int indexOfStemme(Stemme aStemme)
  {
    int index = stemmes.indexOf(aStemme);
    return index;
  }
  /* Code from template association_GetOne */
  public Bedrift getBedrift()
  {
    return bedrift;
  }
  /* Code from template association_GetOne */
  public Studie getStudie()
  {
    return studie;
  }
  /* Code from template association_SetOneToMany */
  public boolean setArrangement(Arrangement aArrangement)
  {
    boolean wasSet = false;
    if (aArrangement == null)
    {
      return wasSet;
    }

    Arrangement existingArrangement = arrangement;
    arrangement = aArrangement;
    if (existingArrangement != null && !existingArrangement.equals(aArrangement))
    {
      existingArrangement.removeProsjekt(this);
    }
    arrangement.addProsjekt(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStemmes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stemme addStemme(int aStemmeid, String aEpost, int aStemmeverdi, Time aStemmetidspunkt, Arrangement aArrangement)
  {
    return new Stemme(aStemmeid, aEpost, aStemmeverdi, aStemmetidspunkt, aArrangement, this);
  }

  public boolean addStemme(Stemme aStemme)
  {
    boolean wasAdded = false;
    if (stemmes.contains(aStemme)) { return false; }
    Prosjekt existingProsjekt = aStemme.getProsjekt();
    boolean isNewProsjekt = existingProsjekt != null && !this.equals(existingProsjekt);
    if (isNewProsjekt)
    {
      aStemme.setProsjekt(this);
    }
    else
    {
      stemmes.add(aStemme);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStemme(Stemme aStemme)
  {
    boolean wasRemoved = false;
    //Unable to remove aStemme, as it must always have a prosjekt
    if (!this.equals(aStemme.getProsjekt()))
    {
      stemmes.remove(aStemme);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStemmeAt(Stemme aStemme, int index)
  {  
    boolean wasAdded = false;
    if(addStemme(aStemme))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStemmes()) { index = numberOfStemmes() - 1; }
      stemmes.remove(aStemme);
      stemmes.add(index, aStemme);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStemmeAt(Stemme aStemme, int index)
  {
    boolean wasAdded = false;
    if(stemmes.contains(aStemme))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStemmes()) { index = numberOfStemmes() - 1; }
      stemmes.remove(aStemme);
      stemmes.add(index, aStemme);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStemmeAt(aStemme, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBedrift(Bedrift aBedrift)
  {
    boolean wasSet = false;
    if (aBedrift == null)
    {
      return wasSet;
    }

    Bedrift existingBedrift = bedrift;
    bedrift = aBedrift;
    if (existingBedrift != null && !existingBedrift.equals(aBedrift))
    {
      existingBedrift.removeProsjekt(this);
    }
    bedrift.addProsjekt(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setStudie(Studie aStudie)
  {
    boolean wasSet = false;
    if (aStudie == null)
    {
      return wasSet;
    }

    Studie existingStudie = studie;
    studie = aStudie;
    if (existingStudie != null && !existingStudie.equals(aStudie))
    {
      existingStudie.removeProsjekt(this);
    }
    studie.addProsjekt(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Arrangement placeholderArrangement = arrangement;
    this.arrangement = null;
    if(placeholderArrangement != null)
    {
      placeholderArrangement.removeProsjekt(this);
    }
    for(int i=stemmes.size(); i > 0; i--)
    {
      Stemme aStemme = stemmes.get(i - 1);
      aStemme.delete();
    }
    Bedrift placeholderBedrift = bedrift;
    this.bedrift = null;
    if(placeholderBedrift != null)
    {
      placeholderBedrift.removeProsjekt(this);
    }
    Studie placeholderStudie = studie;
    this.studie = null;
    if(placeholderStudie != null)
    {
      placeholderStudie.removeProsjekt(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "prosjektid" + ":" + getProsjektid()+ "," +
            "prosjektnavn" + ":" + getProsjektnavn()+ "," +
            "prosjektbeskrivelse" + ":" + getProsjektbeskrivelse()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "arrangement = "+(getArrangement()!=null?Integer.toHexString(System.identityHashCode(getArrangement())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "bedrift = "+(getBedrift()!=null?Integer.toHexString(System.identityHashCode(getBedrift())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "studie = "+(getStudie()!=null?Integer.toHexString(System.identityHashCode(getStudie())):"null");
  }
}