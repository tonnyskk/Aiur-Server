package com.origin.aiur.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class RequestFilter implements ContainerRequestFilter {

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		String token = request.getQueryParameters().getFirst("token");
		request.getQueryParameters().add("valid", "true - " + token);
		return request;
	}

}
