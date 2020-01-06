# UpgradeQA
The Suite Test.xml is alocated on src/test/resource.
The class BorrowerRegistration.java contains the Web exercise and it's alocated on src/test/java
The class ApiRegistration.java contains the 3 tests related to API exercise and also it's alocated on src/test/java

For Web exercise you need to initialize Selenium on your local or just add a line on SetUp method on BorrowerRegistration.java with this info: 
  "System.setProperty("webdriver.chrome.driver","<your location>\\<Selenium Folder>\\chromedriver.exe");"
