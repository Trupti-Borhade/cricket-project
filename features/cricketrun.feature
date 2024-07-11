@cricket-run

Feature: Verify the run of the player in cricket framework

  Background:
    Given I open application

  @sanity @add-new-player
  Scenario Outline: Verify if user is able to add details in "Add new player"
    And I click on Add New Player link
    And I enter "<Player Name>" with "playername"
    And I select dropdown option "<Player Country>" under "Player Country"
    And I select "<Gender>" gender
    And I enter "<Player Year>" with "playerYear"
    And I click on Add Player button
    And I verify popup is available
    And I verify popup text "<Player Name>  Added  Successfully"
    And I accept popup
    Examples:
      |Player Name   | Player Country | Gender |Player Year   |
      | Player21     | India          | Male   |1991          |
      | Player22     | India          | Male   |1989          |
      | Player23     | India          | Male   |1994          |
      | Player24     | India          | Male   |1995          |


  @smoke @add-runlabel
  Scenario Outline: Verify if user is able to access "Add Run" page
    And I click on Add Run link
    And I verify current url contains "add-run.php"
    And I verify Add Run header text
    And I verify dropdown element under "Player Name"
    And I verify dropdown option "<Player Name>" under "Player Name"
    And I verify Against Country label
    And I verify exact "Run" text
    And I verify Balls label
    And I verify Fours label
    And I verify Sixes label
    And I verify Inning Date label
    And I verify Add Run button
    Examples:
      |Player Name     |
      |Player21 - IND  |

  @sanity @add-score
  Scenario Outline: Verify if user is able to enter data in "Add Run" page
    And I click on Add Run link
    And I select dropdown option "<Player Name>" under "Player Name" label
    And I select dropdown "<Against Country>" under "Against Country"
    And I enter "<Player Run>" using "playerrun"
    And I enter "<Player Balls>" using "playerballs"
    And I enter "<Player Fours>" using "playerfours"
    And I enter "<Player Sixes>" using "playersixes"
    And I enter "<Inning Date>" using "playerYear"
    And I click on Add Run button
    And I verify alert is available
    And I verify "errormsg" is "Runs Added Successfully"
    Examples:
    |Player Name      | Against Country  |Player Run|Player Balls|Player Fours  |Player Sixes |Inning Date   |
    | Player21 - IND  |  Australia       |90        |45          |5             | 4           | 2024-06-26   |
    | Player22 - IND  |  Australia       | 60       | 32         | 4            | 1           | 2024-06-26   |
    | Player23 - IND  |  Australia       | 20       | 10         | 2            | 1           | 2024-06-26   |
    | Player24 - IND  |  Australia       | 14       | 7          | 1            | 1           | 2024-06-26   |


  @regression @duplicate-entry
  Scenario Outline: Verify if user is able to enter data for the same player again in "Add Run" page
    And I click on Add Run link
    And I select dropdown option "<Player Name>" under "Player Name" label
    And I select dropdown "<Against Country>" under "Against Country"
    And I enter "<Player Run>" using "playerrun"
    And I enter "<Player Balls>" using "playerballs"
    And I enter "<Player Fours>" using "playerfours"
    And I enter "<Player Sixes>" using "playersixes"
    And I enter "<Inning Date>" using "playerYear"
    And I click on Add Run button
    And I verify alert is available
    And I verify "errormsg" is "Issue in Data. Duplicate Entry"
    Examples:
      |Player Name     | Against Country |Player Run |Player Balls |Player Fours  |Player Sixes |Inning Date   |
      | Player21 - IND |  Australia      | 90        | 45          |5             | 4          | 2024-06-26   |

  @sanity @view-run
  Scenario Outline: Verify the run of every player
    And I click on HomePage link
    And I verify All Players Runs header text
    And I refresh application
    And I verify "<Player Name>" under "Player Name"
    And I click on "<Player Name>" under "Player Name"
    And I verify current url contains "view-runs.php"
    And I verify "<Player Name>" header text
    And I verify "<Date>" under "Date" label
    And I verify "<Against Country>" under "Against Country" label
    And I verify "<Run>" under "Run" label
    And I verify "<Four/Sixes>" under "Four/Sixes" label
    And I verify "<Balls>" under "Balls" label
    Examples:
      | Player Name     | Date       | Against Country | Run  | Four/Sixes          | Balls |
      | Player21        | 2024-06-26 | AUS             | 90   | 5 Four(s)/ 4 Six(s) | 45    |


  @regression @current-statistics
  Scenario Outline: Verify if the runs are added again for the same player,it is also added to to the previous run score of that player on Home Page Statistics
    And I click on Add Run link
    And I select dropdown option "<Player Name>" under "Player Name" label
    And I select dropdown "<Against Country>" under "Against Country"
    And I enter "<Player Run>" using "playerrun"
    And I enter "<Player Balls>" using "playerballs"
    And I enter "<Player Fours>" using "playerfours"
    And I enter "<Player Sixes>" using "playersixes"
    And I enter "<Inning Date>" using "playerYear"
    And I click on Add Run button
    And I verify alert is available
    And I verify "errormsg" is "Runs Added Successfully"
    And I refresh application
    And I click on HomePage link
    And I verify current url contains "index.php"
    And I verify "<Name>" under "Player Name"
    And I verify "<Total Run>" under "Total Run"
    And I click on "<Name>" under "Player Name"
    And I verify current url contains "view-runs.php"
    And I verify "<Name>" header text
    And I refresh application
    And I verify "<Date>" under "Date" label
    And I verify "AUS" under "Against Country" label
    And I verify "<Run>" under "Run" label
    And I verify "<Four/Sixes>" under "Four/Sixes" label
    And I verify "<Balls>" under "Balls" label
    Examples:
      |Player Name     | Against Country |Player Run |Player Balls |Player Fours   | Player Sixes |Inning Date   |Name       |Total Run| Date       | Run | Four/Sixes         | Balls |
      |Player21 - IND  | Australia       | 80        |45           |5              | 4            | 2024-06-27   | Player21  |170      | 2024-06-27 | 80  |5 Four(s)/ 4 Six(s) | 45    |


  @sanity @delete-viewrunplayer
  Scenario Outline: Verify if "delete" button in view run table is activate
    And I click on HomePage link
    And I verify All Players Runs header text
    And I verify "<Player Name>" under "Player Name"
    And I click on "<Player Name>" under "Player Name"
    And I verify current url contains "view-runs.php"
    And I click on "Delete" button under "<Run>" header
    And I verify alert is available
    And I verify popup text "Are you sure! you want to delete this Runs ?"
    And I accept popup
    And I verify "<Run>" not present under "<Player Name>"
    Examples:
    | Player Name | Run   |
    | Player21    | 90    |


