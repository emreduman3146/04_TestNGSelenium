package com.testng.annotations.c_advancedAnnotations.d_listeners.IReporter;

import org.testng.*;
import org.testng.annotations.Listeners;
import org.testng.xml.XmlSuite;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyListener implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)
    {

        ISuite suite = suites.get(0);
        Map<String, Collection<ITestNGMethod>> methodsByGroup = suite.getMethodsByGroups();
        Map<String, ISuiteResult> tests = suite.getResults();

        for (String key : tests.keySet()) {
            System.out.println("Key: " + key + ", Value: " + tests.get(key));
        }

        Collection<ISuiteResult> suiteResults = tests.values();
        ISuiteResult suiteResult = suiteResults.iterator().next();
        ITestContext testContext = suiteResult.getTestContext();
        Collection<ITestNGMethod> perfMethods = methodsByGroup.get("smokeTest");
        IResultMap failedTests = testContext.getFailedTests();

        for (ITestNGMethod perfMethod : perfMethods) {
            Set<ITestResult> testResultSet = failedTests.getResults(perfMethod);
            for (ITestResult testResult : testResultSet) {
                System.out.println("Test " + testResult.getName() + " failed, error " + testResult.getThrowable());
            }
        }

        IResultMap passedTests = testContext.getPassedTests();


        for (ITestNGMethod perfMethod : perfMethods) {
            Set<ITestResult> testResultSet = passedTests.getResults(perfMethod);
            for (ITestResult testResult : testResultSet) {
                System.out.println("Test " + testResult.getName() + " passed, time took " +
                        (testResult.getEndMillis() - testResult.getStartMillis()));
            }
        }

    }

}


/*
    IReporter: Bu listener, istenilen koşullara göre TestNG'de özel raporlar oluşturmaya yardımcı olur.
    TestNG'nin tüm suites'leri çalıştırıldığında çağrılan generateReport() adlı bir methodu vardır.
    Bu method üç argüman kullanır:
            xmlSuite: xml dosyasında çalıştırılacak suites'lerin bir listesini içerir
            suites: Sınıf adı, paket adı, method adı ve test çalıştırma sonuçları gibi test çalıştırma ve suites hakkında tüm bilgileri içerir
            outputDirectory: Raporun kaydedileceği yolu içerir.


     xml dosyasında tanımlanan suite adinda bir klasör olusur.
     Icinde rapor oluşturulacaktır.
 */