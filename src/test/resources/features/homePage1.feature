Feature:Validate todo list application111
@smoke2
Scenario: To Validate the ToDo Item is added
  Given User in on the home page
  When User add a item "running" as to do
  Then user marks the item "running" as completed