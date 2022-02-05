package com.bakaroo.spring.data.jpa.tutorial.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Embeddable
@AttributeOverrides({
    @AttributeOverride(
        name = "name",
        column = @Column(name = "guardian_name")
    ),
    @AttributeOverride(
        name = "email",
        column = @Column(name = "guardian_email")
    ),
    @AttributeOverride(
        name = "mobile",
        column = @Column(name = "guardian_mobile")
    )
})
public class Guardian {
  
  private String name;
  private String email;
  private  String mobile;
}
