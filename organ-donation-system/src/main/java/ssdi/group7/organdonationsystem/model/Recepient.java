package ssdi.group7.organdonationsystem.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recepient")
public class Recepient {

	public Long id;

	public Long recepientId;

	public Long organId;

	public Recepient() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, organId, recepientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recepient other = (Recepient) obj;
		return Objects.equals(id, other.id) && Objects.equals(organId, other.organId)
				&& Objects.equals(recepientId, other.recepientId);
	}

	public Recepient(Long id, Long recepientId, Long organId) {
		super();
		this.id = id;
		this.recepientId = recepientId;
		this.organId = organId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "recepient_id", nullable = false)
	public Long getRecepientId() {
		return recepientId;
	}

	public void setRecepientId(Long recepientId) {
		this.recepientId = recepientId;
	}

	@Column(name = "organ_id", nullable = false)
	public Long getOrganId() {
		return organId;
	}

	public void setOrganId(Long organId) {
		this.organId = organId;
	}

	@Override
	public String toString() {
		return "Recepient [id=" + id + ", recepientId=" + recepientId + ", organId=" + organId + "]";
	}

}
