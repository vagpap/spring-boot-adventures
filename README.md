Adventures in SpringBoot/SpringCloud etc.

Currently, there are 3 different projects in the repository:
Services that expose a simple REST endpoint (GET)
* review-service
* product-service
Infrastructure:
* api-gateway-camel: An API Gateway example based on Apache Camel

There is no master pom.xml, so each project defines it's own.

Prerequisites:
Required is an instance of Consul, even in -dev mode (had some issues with Docker so I prefer to run one locally from my DEV machine)

Services, register themselves upon startup in Consul, following the approach of each start creating a new registration in Consul, in order to show scalability and load-balancing of requests
The gateway utilises Java DSL routes, bound to service names. Service URLs are determined by Consul, to which the gateway connects to retrieve registered services information.
Furthermore, the routes insert a custom header to the request, which is interpreted from the services themselves. This is just to show that Camel has capabilities of adding correlationIDs etc. in the header of each request.

Usage:
1. Start Consul in DEV mode: consul agent -dev
2. Start review and product services: mvn spring-boot:run (start in random port)
3. Start the gateway: mvn spring-boot:run (starts in port: 8767)
5. Trigger a GET request towards: http://localhost:8767/product/1 or http://localhost:8767/review/1
6. One can start multiple instances of the services, and inspect results of calls. It is expected that the real server port, visible in the service response, changes everytime
7. Note that management endpoints (Actuator) are enabled by default, which is usually a security risk and should be handled accordningly

The initial source of information for this package was this blog series: http://callistaenterprise.se/blogg/teknik/2015/05/20/blog-series-building-microservices/
