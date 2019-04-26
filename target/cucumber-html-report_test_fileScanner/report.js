$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/VehicleCheck.feature");
formatter.feature({
  "line": 2,
  "name": "Vehicle Check",
  "description": "",
  "id": "vehicle-check",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@VehicleCheck"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Vehicle Check",
  "description": "",
  "id": "vehicle-check;vehicle-check",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am on DVLA page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I should be able to search each vehicle defined in the CSV file",
  "keyword": "Then "
});
formatter.match({
  "location": "DVLASteps.i_am_on_DVLA_page()"
});
formatter.result({
  "duration": 4149308829,
  "status": "passed"
});
formatter.match({
  "location": "DVLASteps.i_should_be_able_to_search_each_vehicle_defined_in_the_CSV_file()"
});
formatter.result({
  "duration": 3204833756,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 600765118,
  "status": "passed"
});
});