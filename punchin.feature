Feature: Punch In functionality

  Scenario: User punches in and sees confirmation
    Given User is logged in
    When User clicks on PunchIn button
    Then A toast message should appear with "Punch In Successfully"
