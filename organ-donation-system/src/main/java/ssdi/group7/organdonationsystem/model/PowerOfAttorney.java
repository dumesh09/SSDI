package ssdi.group7.organdonationsystem.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "powerofattorney")
public class PowerOfAttorney {

	public Long id;
	public Long userId;

	public String FirstName;

	public String LastName;

	public String email;

	public int phone;

	public String relation;

	public PowerOfAttorney() {

	}

	public PowerOfAttorney(Long id, Long userId, String firstName, String lastName, String email, int phone,
			String relation) {
		super();
		this.id = id;
		this.userId = userId;
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
		this.phone = phone;
		this.relation = relation;
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

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false)
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Column(name = "relation", nullable = false)
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(FirstName, LastName, email, id, phone, relation, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOfAttorney other = (PowerOfAttorney) obj;
		return Objects.equals(FirstName, other.FirstName) && Objects.equals(LastName, other.LastName)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id) && phone == other.phone
				&& Objects.equals(relation, other.relation) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "PowerOfAttorney [id=" + id + ", userId=" + userId + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", email=" + email + ", phone=" + phone + ", relation=" + relation + "]";
	}

}
