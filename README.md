Hangs Payara 5.2021.8 on application lifecycle events such as shutdown.

See https://github.com/payara/Payara/issues/5476

1.

```
# gradle war
```
  
2. Drop war file from build/libs to Payara's domain1/autodeploy
3. Try to shutdown Payara

```
# ./asadmin stop-domain domain1
```
