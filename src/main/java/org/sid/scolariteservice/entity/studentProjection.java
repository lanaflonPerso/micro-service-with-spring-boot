package org.sid.scolariteservice.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1", types = Student.class)
public interface studentProjection {

	public String getEmail();
	public String getName();
	public Laboratory getLaboratory();
}
