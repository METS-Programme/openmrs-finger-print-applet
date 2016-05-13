package org.openmrs.module.fingerprint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Simon
 *
 */
@Entity
@Table(name = "patient_finger_print")
public class PatientFingerPrint implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1589083633711580633L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "patient_id", nullable = false)
	private Integer patientId;
	
	@Column(name = "left_thumb", nullable = true, length=1700)
	private byte[] leftThumb;
	
	@Column(name = "left_index_finger", nullable = true,length=2000)
	private byte[] leftIndex;
	
	public PatientFingerPrint(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public byte[] getLeftThumb() {
		return leftThumb;
	}

	public void setLeftThumb(byte[] leftThumb) {
		this.leftThumb = leftThumb;
	}

	public byte[] getLeftIndex() {
		return leftIndex;
	}

	public void setLeftIndex(byte[] leftIndex) {
		this.leftIndex = leftIndex;
	}
	
	

}
