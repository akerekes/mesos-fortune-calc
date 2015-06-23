package com.ishi.mesos.fortunecalc;

import spark.Request;
import spark.Response;
import spark.Route;
import us.monoid.web.Resty;

import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

public class FortuneCalcWeb {

	// assumes that this directory contains .html and .jsp files
	// This is just a directory within your source tree, and can be exported as part of your normal .jar
	final static String WEBAPPDIR = "webapp";
	final static String CONTEXTPATH = "/fc";

	public static void main(String args[]) throws Exception {
		String backend_host = System.getenv("FORTUNE_BACKEND_HOST");
		String backend_port = System.getenv("FORTUNE_BACKEND_PORT");
		final String backend_url = (backend_host == null ? "localhost" : backend_host) + ":" + (backend_port == null ? 9090 : backend_port);
		String fortune_web_port = System.getenv("FORTUNE_WEB_PORT");
		int httpServerPort = Integer.parseInt(fortune_web_port == null ? "8080" : fortune_web_port);
		port(httpServerPort);
		staticFileLocation("webapp");
		get("/add", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				int number1 = Integer.parseInt(request.queryParams("number1"));
				int number2 = Integer.parseInt(request.queryParams("number2"));
				Resty r = new Resty();
				return r.text(String.format("http://%s/add/%d/%d", backend_url, number1, number2)).toString();

			}
		});
	}

}
