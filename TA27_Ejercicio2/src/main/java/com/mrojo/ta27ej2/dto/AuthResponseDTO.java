/**
 * 
 */
package com.mrojo.ta27ej2.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author Marc
 *
 */
@Data
@Entity
public class AuthResponseDTO {

	@Id
	private long id;
	private String accessToken;
	private String tokenType = "Bearer ";

	public AuthResponseDTO(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
}
