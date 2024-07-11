@cricket-player
Feature: Verify cricket database framework

  Background:
    Given I open application

  @smoke @add-player
    Scenario: Verify if user is able to "Add new player"
      And I click on Add New Player link
      And I verify current url contains "new-player.php"
      And I verify Add new Player header text
      And I verify Player Name text
      And I verify textbox under "Player Name"
      And I verify Player Country text
      And I verify dropdown under "Player Country"
      And I verify Player Gender text
      And I verify Player Year text
      And I verify textbox under "Player Year"
      And I verify Add Player button

  @sanity @new-player
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
    |Player Name  | Player Country | Gender   |Player Year  |
    | Player1     | India          | Male     | 1989        |
    | Player2     | India          | Male     | 1990        |
    | Player3     | India          | Male     | 1993        |
    | Player4     | India          | Male     | 1997        |


  @sanity @all-player
    Scenario Outline: Verify if all players data is visible under "All Player"
      And I click on All Players link
      And I verify current url contains "all-player.php"
      And I refresh application
      And I verify View All Players header text
      And I verify Player ID text
      And I verify "<Player Name>" under "Player Name" label
      And I verify "<Player Country>" under "Player Country" label
      And I verify "<Player Gender>" under "Player Gender" label
      And I verify "<Player Year>" under "Player Year" label
      And I verify Delete button under Actions
      Examples:
        |Player Name  | Player Country |Player Gender  | Player Year |
        | Player1     | IND            |Male           | 1989        |

  @sanity @delete-viewallplayer
    Scenario Outline: Verify if "delete" button in View All Players is activate
      And I click on All Players link
      And I verify current url contains "all-player.php"
      And I refresh application
      And I click on "Delete" button under "<Player Name>"
      And I verify alert is available
      And I verify popup text "Are you sure! you want to delete this player ?"
      And I accept popup
      And I verify "<Player Name>" not present under "Player Name"
    Examples:
      |Player Name    |
      | Player1       |

