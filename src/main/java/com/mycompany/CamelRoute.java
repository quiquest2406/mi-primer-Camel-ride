package com.mycompany;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		/* 
		 * You can define here the Camel Route.
		 * For instance, start by calling from() method, then use the Fluent API to build the Camel Route definition.
		 */
		CamelContext context =new DefaultCamelContext();
		context.addRoutes(new RouteBuilder(){
			public void configure(){
				from("file:data/inbox?noop=true")
				.to("file:data/outbox");
			}
		}
		);
		context.start();
		Thread.sleep(10000);
		context.stop();
	}
}
