package in.rudresh.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;
	
	@NotBlank(message="name is required")
	private String pName;

	private Double pPrice;

	private String pBrand;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime created_at;

	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime modified_at;

}
