## Test automation project for https://pilulka.cz

##	Table of contents

- [Technologies and tools](#technologist-technologies-and-tools)
- [Implemented checks](#bookmark-tabs-implemented-checks)
- [Running tests from the terminal](#computer-running-tests-from-the-terminal)
- [Running tests in Jenkins](#-running-tests-in-jenkins)
- [Test results report in Allure Report](#-test-results-report-in-allure-report)
- [Integration with Allure TestOps](#-integration-with-allure-testops)
- [Integration with Jira](#-integration-with-jira)
- [Telegram notifications using a bot](#-telegram-notifications-using-a-bot)
- [Test running example in Selenoid](#-test-running-example-in-selenoid)
- [Mobile Test running example for Wikipedia application](#mobile-mobile-test-running-example-for-wikipedia-application)

## :technologist: Technologies and tools

<p  align="center">

<code><img width="5%" title="IntelliJ IDEA" src="media/logo/Idea.svg"></code>
<code><img width="5%" title="Java" src="media/logo/Java.svg"></code>
<code><img width="5%" title="Selenoid" src="media/logo/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="media/logo/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="media/logo/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="media/logo/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="media/logo/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="media/logo/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="media/logo/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="media/logo/Jenkins_logo.svg"></code>
<code><img width="5%" title="Jira" src="media/logo/Jira.svg"></code>
<code><img width="5%" title="Telegram" src="media/logo/Telegram.svg"></code>
</p>

## :bookmark_tabs: Implemented checks:
### UI Tests

- Menu display checking
- Product availability checking
- Checking the addition and deletion of goods from the basket
- Checking the display of the footer menu
- Authorization on the site with incorrect credentials 

## :computer: Running tests from the terminal

### Local running tests

```bash
gradle clean test
```

### Remote running tests

```bash
gradle clean test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-Dremote=${SERVER_REMOTE}
```

## <img width="4%" title="Jenkins" src="media/logo/Jenkins_logo.svg"> Running tests in [Jenkins](https://jenkins.autotests.cloud/job/pilulka/)

First you need to click on the <code><strong>*Collect with parameters*</strong></code> button and set options. By clicking on the <code><strong>*Collect*</strong></code> button a build will be started.

<p align="center">
  <img src="media/jenkins.png" alt="Jenkins" width="800">
</p>

After build is completed, in the <code><strong>*Builds history*</strong></code> opposite the build number will appear
the *Allure Report* icon, clicking on which will open the page with the generated html-report.

<p align="center">
  <img src="media/allure-report.png" alt="allure-report" width="800">
</p>

## <img width="4%" title="Allure Report" src="media/logo/Allure.svg"> Test results report in [Allure Report](https://jenkins.autotests.cloud/job/pilulka/30/allure/)

<p align="center">
  <img src="media/allure-report1.png" alt="allure-report1" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="media/logo/Allure_TO.svg"> Integration with [Allure TestOps](https://allure.autotests.cloud/launch/18709)

## Main dashboard

<p align="center">
  <img src="media/dashboard.png" alt="dashboard" width="900">
</p>

## Test results

<p align="center">
  <img src="media/testsresults.png" alt="testresults" width="900">
</p>

## <img width="4%" title="Jira" src="media/logo/Jira.svg"> Integration with [Jira](https://jira.autotests.cloud/browse/HOMEWORK-490)

<p align="center">
  <img src="media/jira.png" alt="jira" width="900">
</p>

## <img width="4%" title="Telegram" src="media/logo/Telegram.svg"> Telegram notifications using a bot
After the build is completed, a special bot created in <code>Telegram</code>, automatically processes and sends a test run report message.

<p align="center">
<img title="Telegram Notifications" src="media/telegram.png">
</p>

## <img width="4%" title="Selenoid" src="media/logo/Selenoid.svg"> Test running example in Selenoid

A video is attached to each test in the report.

<p align="center">
  <img title="Selenoid Video" src="media/video/test.gif">
</p>