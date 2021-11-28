package ssdi.group7.organdonationsystem.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "waitlist")
public class Waitlist {

	public Long id;
	public Long userId;

	public int score;

	public Long organId;

	public Waitlist() {

	}

	public Waitlist(Long id, Long userId, int score, Long organId) {
		super();
		this.id = id;
		this.userId = userId;
		this.score = score;
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

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "score", nullable = false)
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
		return Objects.hash(id, organId, score, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waitlist other = (Waitlist) obj;
		return Objects.equals(id, other.id) && Objects.equals(organId, other.organId) && score == other.score
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Waitlist [id=" + id + ", userId=" + userId + ", score=" + score + ", organId=" + organId + "]";
	}

}
