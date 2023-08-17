package org.DSA;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Testing {

	public static void main(String[] args) {

		final Logger logger = LoggerFactory.getLogger(Testing.class);
		String urlString =  "http://" + "localhost " + ":" + "5500";
		URL url;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			String message = String.format("Invalid url %s. Reason: %s", urlString, e.getMessage());
			logger.error(message);
		}

		String host = "localhost";
		int port = 5500;
		int timeoutInMillis = 10000;
		try {
			try (Socket soc = new Socket()) {
				soc.connect(new InetSocketAddress(host, port), timeoutInMillis);
			}
			((org.slf4j.Logger) logger).debug("Host {}:{} is reachable", host, port);
		} catch (IOException ex) {
			String message = String.format("Host %s:%s is NOT reachable", host, port);
			logger.error(message);
		}
	}

}