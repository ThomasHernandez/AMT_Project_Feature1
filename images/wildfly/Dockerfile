FROM jboss/wildfly:10.1.0.Final

MAINTAINER Ciani Antony <antony.ciani@heig-vd.ch>

COPY apps-dist/StaticWebPage-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/StaticWebPage-1.0-SNAPSHOT.war

COPY data/mysql-connector-java-5.1.40-bin.jar /opt/jboss/wildfly/standalone/deployments

COPY data/standalone.xml /opt/jboss/wildfly/standalone/configuration/

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

