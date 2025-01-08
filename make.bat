@echo off


IF /I "%1"=="run-app-dependencies" GOTO run-app-dependencies
IF /I "%1"=="run-app-only" GOTO run-app-only
IF /I "%1"=="run-all" GOTO run-all
IF /I "%1"=="stop-app-dependencies" GOTO stop-app-dependencies
IF /I "%1"=="stop-app-only" GOTO stop-app-only
IF /I "%1"=="stop-all" GOTO stop-all
GOTO error

:run-app-dependencies
	CALL make.bat stop-app-dependencies
	mvn clean install -DskipTests
	mvn -pl ms-party-app io.fabric8:docker-maven-plugin:start@com.weecover.tiles_postgres-tile_1.0.1__prepare-it-postgres io.fabric8:docker-maven-plugin:start@com.weecover.tiles_s3-tile_1.0.1__prepare-it-s3
	GOTO :EOF

:run-app-only
	CALL make.bat stop-app-only
	mvn -pl ms-party-acceptance-test io.fabric8:docker-maven-plugin:start@com.weecover.tiles_app-tile_1.0.1__prepare-it-app
	GOTO :EOF

:run-all
	CALL make.bat stop-all
	mvn clean install -DskipTests
	mvn -pl ms-party-acceptance-test io.fabric8:docker-maven-plugin:start@com.weecover.tiles_postgres-tile_1.0.1__prepare-it-postgres io.fabric8:docker-maven-plugin:start@com.weecover.tiles_s3-tile_1.0.1__prepare-it-s3 io.fabric8:docker-maven-plugin:start@com.weecover.tiles_app-tile_1.0.1__prepare-it-app
	GOTO :EOF

:stop-app-dependencies
	docker rm -f postgres-1 s3mock-1
	GOTO :EOF

:stop-app-only
	docker rm -f ms-party-1
	GOTO :EOF

:stop-all
	CALL make.bat stop-app-only
	CALL make.bat stop-app-dependencies
	GOTO :EOF

:error
    IF "%1"=="" (
        ECHO make: *** No targets specified and no makefile found.  Stop.
    ) ELSE (
        ECHO make: *** No rule to make target '%1%'. Stop.
    )
    GOTO :EOF

