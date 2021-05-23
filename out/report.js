$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("google-search-text.feature");
formatter.feature({
  "line": 1,
  "name": "Google search",
  "description": "",
  "id": "google-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "user can search any keyword",
  "description": "",
  "id": "google-search;user-can-search-any-keyword",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "an open browser with google.com",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "a keyword selenium is entered in input field",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the first one should contain selenium",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleStepDefinition.openGoogleSearch()"
});
formatter.result({
  "duration": 4183466600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "selenium",
      "offset": 10
    }
  ],
  "location": "GoogleStepDefinition.enterKeyword(String)"
});
formatter.result({
  "duration": 981118400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "selenium",
      "offset": 29
    }
  ],
  "location": "GoogleStepDefinition.theFirstOneShouldContainKeyword(String)"
});
formatter.result({
  "duration": 429500,
  "status": "passed"
});
formatter.match({
  "location": "GoogleStepDefinition.closeBrowser()"
});
formatter.result({
  "duration": 820696500,
  "status": "passed"
});
});