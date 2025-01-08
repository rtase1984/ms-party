# Use this to run dependencies and execute application (or integration tests) from IDE
# or run application completely and execute acceptance test from IDE
# Usages:
# 	make run-app-dependencies
#   make run-app-only
# 	make run-all
#   make stop-app-dependencies
#   make stop-app-only
#   make stop-all

run-app-dependencies: stop-app-dependencies
	mvn clean install -DskipTests
	mvn -pl ms-party-app io.fabric8:docker-maven-plugin:start@com.weecover.tiles_postgres-tile_1.0.2__prepare-it-postgres \
                          io.fabric8:docker-maven-plugin:start@com.weecover.tiles_s3-tile_1.0.1__prepare-it-s3

run-app-only: stop-app-only
	mvn -pl ms-party-acceptance-test io.fabric8:docker-maven-plugin:start@com.weecover.tiles_app-tile_1.0.1__prepare-it-app

run-all: stop-all
	mvn clean install -DskipTests
	mvn -pl ms-party-acceptance-test io.fabric8:docker-maven-plugin:start@com.weecover.tiles_postgres-tile_1.0.2__prepare-it-postgres \
                                      io.fabric8:docker-maven-plugin:start@com.weecover.tiles_s3-tile_1.0.1__prepare-it-s3 \
                                      io.fabric8:docker-maven-plugin:start@com.weecover.tiles_app-tile_1.0.1__prepare-it-app

stop-app-dependencies:
	docker rm -f postgres-1 s3mock-1

stop-app-only:
	docker rm -f ms-party-1

stop-all:
	make stop-app-only
	make stop-app-dependencies