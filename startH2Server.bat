Rem This .bat start H2 server on the port 8001 and the root ./data.

start java -cp "./lib/*" org.h2.tools.Server -tcp -tcpPort 8001 -tcpAllowOthers -baseDir ./data