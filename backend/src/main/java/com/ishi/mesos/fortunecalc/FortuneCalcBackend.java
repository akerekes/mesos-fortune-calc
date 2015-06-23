package com.ishi.mesos.fortunecalc;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;
import static spark.SparkBase.port;

public class FortuneCalcBackend {
	public static void main(String args[]) {
		String fortune_fortune_backend_port_port = System.getenv("FORTUNE_BACKEND_PORT");
		int httpServerPort = Integer.parseInt(fortune_fortune_backend_port_port == null ? "9090" : fortune_fortune_backend_port_port);
		port(httpServerPort);
		get("/add/:number1/:number2", new Route() {
				@Override
				public Object handle(Request request, Response response) throws Exception {
					return Integer.parseInt(request.params("number1")) + Integer.parseInt(request.params("number2"));
				}
			}
		);
	}
}
