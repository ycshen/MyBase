package com.brp.model;


import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public class HttpExtend extends HttpEntityEnclosingRequestBase{
	/**
	 * Default METHOD is GET
	 */
    private String METHOD_NAME = "GET";

    public HttpExtend(final String method) {
        super();
    	METHOD_NAME = method;
    }

    public HttpExtend(final String method,final URI uri) {
        super();
        setURI(uri);
    	METHOD_NAME = method;
    }

    /**
     * @throws IllegalArgumentException if the uri is invalid.
     */
    public HttpExtend(final String method,final String uri) {
        super();
        setURI(URI.create(uri));
    	METHOD_NAME = method;
    }

    @Override
    public String getMethod() {
        return METHOD_NAME;
    }
    


}
