//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.10.10 à 10:48:07 PM UTC 
//


package sn.uvs.formation.professeur;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour profDetails complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="profDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomProf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prenomProf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "profDetails", propOrder = {
    "id",
    "nomProf",
    "prenomProf"
})
public class ProfDetails {

    protected int id;
    @XmlElement(required = true)
    protected String nomProf;
    @XmlElement(required = true)
    protected String prenomProf;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété nomProf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomProf() {
        return nomProf;
    }

    /**
     * Définit la valeur de la propriété nomProf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomProf(String value) {
        this.nomProf = value;
    }

    /**
     * Obtient la valeur de la propriété prenomProf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenomProf() {
        return prenomProf;
    }

    /**
     * Définit la valeur de la propriété prenomProf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenomProf(String value) {
        this.prenomProf = value;
    }

}
