package com.msrs.apartmentservice.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msrs.apartmentservice.model.Apartment;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TenantDtoResponse {
    String tenantName;
    @JsonFormat(pattern = "dd-mm-yyyy")
    Date tenantInDate;
    String email;
    String mobileNumber;
    int totalMembers;
}
