package ssdi.group7.organdonationsystem.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transplant")
public class Transplant {

	public Long id;
	public Long donarId;

	public Long recepientId;

	public Long organId;

	public Transplant() {

	}

	public Transplant(Long id, Long donarId, Long recepientId, Long organId) {
		super();
		this.id = id;
		this.donarId = donarId;
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

	@Column(name = "donar_id", nullable = false)
	public Long getDonarId() {
		return donarId;
	}

	public void setDonarId(Long donarId) {
		this.donarId = donarId;
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
	public int hashCode() {
		return Objects.hash(donarId, id, organId, recepientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transplant other = (Transplant) obj;
		return Objects.equals(donarId, other.donarId) && Objects.equals(id, other.id)
				&& Objects.equals(organId, other.organId) && Objects.equals(recepientId, other.recepientId);
	}

	@Override
	public String toString() {
		return "Transplant [id=" + id + ", donarId=" + donarId + ", recepientId=" + recepientId + ", organId=" + organId
				+ "]";
	}

}
