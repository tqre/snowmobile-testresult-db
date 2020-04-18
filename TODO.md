# TODO

Priority:
- user input validation on all forms
  - users
    - everything
  - testreports:
    - validation that snowmobile is in database

Important functionality:
- edit/delete functionality
  - cross-references handling, delete something -> wipe database
  - snowmobile editing/deletion
  - user detail editing/deletion, admin only stuff
  - testreport editing/deletion

Extra functionality:
- show testreports per user
- my account: password change
- tester can edit his own tests

Cosmetics/user convenience:
- forms look cluttered, align them, layout&colour stuff
- confirmation on successful operations
- don't show report text on snowmobilestatus/viewtests.html -> link to individual tests
  
Probably not enough time:
- real backend SQL server instead of Heroku deployment
- more detailed access control scheme
  - role enumeration, role class?
  - who can add snowmobiles, who tests?
- user registration + email verification
https://www.baeldung.com/registration-with-spring-mvc-and-spring-security  
