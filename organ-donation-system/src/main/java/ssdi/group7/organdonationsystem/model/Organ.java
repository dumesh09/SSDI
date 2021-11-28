package ssdi.group7.organdonationsystem.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organ")
public class Organ {

	public Long organId;

	public String organName;

	public String bloodType;

	public Organ() {

	}

	public Organ(Long organId, String organName, String bloodType) {
		super();
		this.organId = organId;
		this.organName = organName;
		this.bloodType = bloodType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getOrganId() {
		return organId;
	}

	public void setOrganId(Long organId) {
		this.organId = organId;
	}

	@Column(name = "organ_name", nullable = false)
	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	@Column(name = "blood_type", nullable = false)
	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bloodType, organId, organName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organ other = (Organ) obj;
		return Objects.equals(bloodType, other.bloodType) && Objects.equals(organId, other.organId)
				&& Objects.equals(organName, other.organName);
	}

	@Override
	public String toString() {
		return "Organ [organId=" + organId + ", organName=" + organName + ", bloodType=" + bloodType + "]";
	}

}
