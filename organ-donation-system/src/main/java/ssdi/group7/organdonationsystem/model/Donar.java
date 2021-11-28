package ssdi.group7.organdonationsystem.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donar")
public class Donar {

	public Long id;

	public Donar(Long id, Long donarId, Long organId) {
		super();
		this.id = id;
		this.donarId = donarId;
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

	public Long donarId;
	public Long organId;

	public Donar() {

	}

	public Donar(Long donarId, Long organId) {
		super();
		this.donarId = donarId;
		this.organId = organId;
	}

	@Column(name = "donar_id", nullable = false)
	public Long getDonarId() {
		return donarId;
	}

	public void setDonarId(Long donarId) {
		this.donarId = donarId;
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
		return Objects.hash(donarId, id, organId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donar other = (Donar) obj;
		return Objects.equals(donarId, other.donarId) && Objects.equals(id, other.id)
				&& Objects.equals(organId, other.organId);
	}

	@Override
	public String toString() {
		return "Donar [id=" + id + ", donarId=" + donarId + ", organId=" + organId + "]";
	}

}
