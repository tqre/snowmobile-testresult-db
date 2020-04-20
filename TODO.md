# TODO

Priority:
- input validation on add_testreports:
   - validation that snowmobile is in database  

Important functionality:
- edit/delete functionality
  - snowmobile deletion
  - user editing/deletion, admin only version
  - testreport deletion
  - cross-reference handling, delete something -> wipe database

Extra functionality:
- show testreports per user
- my account: password change
- tester can edit only his own tests
- edit timestamp if a report was edited

Cosmetics/user convenience:
- forms look cluttered, align them, layout&colour stuff
- confirmation on successful operations
- wrap long texts (report text at least in viewreport)
  
In the far future:
- real backend SQL server
- more detailed access control scheme
  - role enumeration, role class
- user registration + email verification
https://www.baeldung.com/registration-with-spring-mvc-and-spring-security  
