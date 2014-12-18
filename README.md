testng-parameter-error
======================

There is a problem in testng (v.6.8.8) if you nest test suites. Parameters are overriden. This project is a little demo project to show you this problem.

<h1>Usage:</h1>

``` bash
git clone https://github.com/chillinPanda/testng-parameter-error.git
cd testng-parameter-error
mvn test
```

<h1>Problem:</h1>

I opened a new issue in the testng project for this problem: https://github.com/cbeust/testng/issues/581

<h2>Output:</h2>

``` bash
ParameterErrorDemoWiki.test:12 check if we got the right parameter from  expected [www.wikipedia.org] but found [www.google.com]
```

<h2>Observation</h2>
Beneath you can see the testng.xml which will be run by "mvn test". The parameter "www.wikipedia.org" gets overriden by "www.google.com". If you switch the <suite-file> order, you will get a different test output because then "www.google.com" gets overriden.

``` xml
<suite name="Demo" parallel="tests">
  <suite-files>
    
    <suite-file path="src/test/testng_xmls/testng_wiki.xml">
      <parameter name="url" value="www.wikipedia.org" />
    </suite-file>
    
    <suite-file path="src/test/testng_xmls/testng_google.xml">
      <parameter name="url" value="www.google.com" />
    </suite-file>
    
  </suite-files>
</suite>
```
